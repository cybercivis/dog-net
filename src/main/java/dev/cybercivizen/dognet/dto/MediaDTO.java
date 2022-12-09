package dev.cybercivizen.dognet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MediaDTO {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("filePath")
    private String filePath;
}
