package dev.cybercivizen.dognet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class PostDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("content")
    private String content;

    @JsonProperty("media")
    private MediaDTO media;

    @JsonProperty("user")
    private UserPreviewDTO user;

    @JsonProperty("comments")
    private List <CommentDTO> comments;

    @JsonProperty("likes")
    private List<PostLikeDTO> likes;

    @JsonProperty("creationDate")
    private Instant creationDate;

}
