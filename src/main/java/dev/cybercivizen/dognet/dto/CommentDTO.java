package dev.cybercivizen.dognet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class CommentDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("content")
    private String content;

    @JsonProperty("user")
    private UserPreviewDTO user;

    @JsonProperty("replies")
    private List<ReplyDTO> replies;

    @JsonProperty("likes")
    private List<CommentLikeDTO> likes;

    @JsonProperty("creationDate")
    private Instant creationDate;
}
