package com.busanit501.boot501.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomParticipantsId implements Serializable {
    private Integer roomId;
    private Integer userId;
}
