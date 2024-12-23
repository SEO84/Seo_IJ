package com.busanit501.boot501.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomParticipantDTO {

    private Integer roomId;
    private Integer userId;
    private String status;    // "Pending", "Accepted", "Rejected"
    private String joinedAt;
}
