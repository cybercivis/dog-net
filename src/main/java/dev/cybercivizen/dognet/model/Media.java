package dev.cybercivizen.dognet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.cybercivizen.dognet.model.Post;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "file_path", nullable = false)
    private String filePath;

    @JsonIgnore
    @OneToOne(mappedBy = "media")
    private Post post;

    public Media() {
    }

    public Media(Long id, String filePath, Post post) {
        this.id = id;
        this.filePath = filePath;
        this.post = post;
    }
}


