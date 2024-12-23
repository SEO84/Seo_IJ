package com.busanit501.boot501.controller;

import com.busanit501.boot501.domain.RoomParticipants;
import com.busanit501.boot501.dto.MatchingRoomDTO;
import com.busanit501.boot501.dto.RoomParticipantDTO;
import com.busanit501.boot501.service.MatchingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/matching")
@RequiredArgsConstructor
public class MatchingController {

    private final MatchingService matchingService;

    /**
     * 매칭방 생성
     */
    @PostMapping("/rooms")
    public ResponseEntity<MatchingRoomDTO> createRoom(@RequestBody MatchingRoomDTO dto) {
        MatchingRoomDTO created = matchingService.createRoom(dto);
        return ResponseEntity
                .created(URI.create("/api/matching/rooms/" + created.getRoomId()))
                .body(created);
    }

    /**
     * 매칭방 닫기
     */
    @PutMapping("/rooms/{roomId}/close")
    public ResponseEntity<MatchingRoomDTO> closeRoom(@PathVariable Integer roomId) {
        MatchingRoomDTO closed = matchingService.closeRoom(roomId);
        return ResponseEntity.ok(closed);
    }

    /**
     * 매칭방 참가 신청
     */
    @PostMapping("/rooms/{roomId}/join")
    public ResponseEntity<RoomParticipantDTO> joinRoom(@PathVariable Integer roomId,
                                                       @RequestParam Integer userId) {
        RoomParticipantDTO participantDTO = matchingService.joinRoom(roomId, userId);
        return ResponseEntity.ok(participantDTO);
    }

    /**
     * 매칭방 참가 승인/거절
     */
    @PutMapping("/rooms/{roomId}/participants/{userId}")
    public ResponseEntity<RoomParticipantDTO> updateParticipantStatus(
            @PathVariable Integer roomId,
            @PathVariable Integer userId,
            @RequestParam RoomParticipants.ParticipantStatus status
    ) {
        RoomParticipantDTO updated = matchingService.updateParticipantStatus(roomId, userId, status);
        return ResponseEntity.ok(updated);
    }
}
