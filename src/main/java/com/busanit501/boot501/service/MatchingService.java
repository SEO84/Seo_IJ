package com.busanit501.boot501.service;

import com.busanit501.boot501.domain.MatchingRooms;
import com.busanit501.boot501.domain.RoomParticipants;
import com.busanit501.boot501.domain.RoomParticipantsId;
import com.busanit501.boot501.domain.Users;
import com.busanit501.boot501.dto.MatchingRoomDTO;
import com.busanit501.boot501.dto.RoomParticipantDTO;
import com.busanit501.boot501.repository.MatchingRoomRepository;
import com.busanit501.boot501.repository.RoomParticipantRepository;
import com.busanit501.boot501.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MatchingService {

    private final MatchingRoomRepository roomRepository;
    private final RoomParticipantRepository participantRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    /**
     * 매칭방 생성
     */
    public MatchingRoomDTO createRoom(MatchingRoomDTO roomDTO) {
        Users host = userRepository.findById(roomDTO.getHostId())
                .orElseThrow(() -> new RuntimeException("Host not found"));

        MatchingRooms room = modelMapper.map(roomDTO, MatchingRooms.class);
        room.setHost(host);

        MatchingRooms savedRoom = roomRepository.save(room);
        return modelMapper.map(savedRoom, MatchingRoomDTO.class);
    }

    /**
     * 매칭방 참가 신청
     */
    public RoomParticipantDTO joinRoom(Integer roomId, Integer userId) {
        // 방, 사용자 유효성 체크
        MatchingRooms room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));
        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // 이미 참가한 상태인지 확인
        RoomParticipantsId pk = new RoomParticipantsId(roomId, userId);
        if (participantRepository.existsById(pk)) {
            throw new RuntimeException("Already joined or pending");
        }

        // 참가자 생성
        RoomParticipants participant = RoomParticipants.builder()
                .roomId(roomId)
                .userId(userId)
                .build();

        participantRepository.save(participant);

        // 방의 현재 참가자 수 +1
        room.setCurrentParticipants(room.getCurrentParticipants() + 1);

        return modelMapper.map(participant, RoomParticipantDTO.class);
    }

    /**
     * 참가 승인/거절
     *  - 방장만 할 수 있다고 가정
     */
    public RoomParticipantDTO updateParticipantStatus(Integer roomId, Integer userId,
                                                      RoomParticipants.ParticipantStatus status) {
        // 방 조회
        MatchingRooms room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        // 참가자 조회
        RoomParticipantsId pk = new RoomParticipantsId(roomId, userId);
        RoomParticipants participant = participantRepository.findById(pk)
                .orElseThrow(() -> new RuntimeException("Participant not found"));

        participant.setStatus(status);
        participantRepository.save(participant);

        return modelMapper.map(participant, RoomParticipantDTO.class);
    }

    /**
     * 매칭방 닫기
     */
    public MatchingRoomDTO closeRoom(Integer roomId) {
        MatchingRooms room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        room.setStatus(MatchingRooms.RoomStatus.Closed);
        MatchingRooms updated = roomRepository.save(room);

        return modelMapper.map(updated, MatchingRoomDTO.class);
    }
}
