package com.busanit501.boot501.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WalkRecordDTO {

    private Integer recordId;
    private Integer userId;
    private String startTime; // yyyy-MM-dd HH:mm:ss
    private String endTime;   // yyyy-MM-dd HH:mm:ss
    private Integer duration; // 분
}
