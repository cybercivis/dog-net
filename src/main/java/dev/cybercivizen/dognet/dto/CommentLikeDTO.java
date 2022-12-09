package dev.cybercivizen.dognet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class CommentLikeDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user")
    private UserPreviewDTO user;

    @JsonProperty("creationDate")
    private Instant creationDate;

}
