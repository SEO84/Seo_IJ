package com.busanit501.boot501.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "matching_rooms")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchingRooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer roomId;

    // 방장 사용자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_id")
    private Users host;

    @Column(nullable = false, length = 255)
    private String title; // 매칭방 제목

    @Lob
    private String description; // 매칭방 설명

    @Builder.Default
    private Integer maxParticipants = 10; // 최대 참가자 수

    @Builder.Default
    private Integer currentParticipants = 1; // 현재 참가자 수

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private RoomStatus status = RoomStatus.Open; // 매칭방 상태

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now(); // 매칭방 생성 시간

    public enum RoomStatus {
        Open, Closed
    }
}
