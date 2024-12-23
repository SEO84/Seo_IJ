package com.busanit501.boot501.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDTO {

    private Integer commentId;
    private Integer postId;
    private Integer userId;
    private String content;
    private String createdAt; // yyyy-MM-dd HH:mm:ss
}
