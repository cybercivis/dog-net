package dev.cybercivizen.dognet.media;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.cybercivizen.dognet.post.Post;

import javax.persistence.*;

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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Media(Long id, String filePath) {
        this.id = id;
        this.filePath = filePath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


