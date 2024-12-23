package com.busanit501.boot501.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchingRoomDTO {

    private Integer roomId;
    private Integer hostId;   // 방장 사용자 ID
    private String title;
    private String description;
    private Integer maxParticipants;
    private Integer currentParticipants;
    private String status;    // "Open", "Closed"
    private String createdAt;
}
