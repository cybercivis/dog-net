package dev.cybercivizen.dognet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
@EntityListeners(AuditingEntityListener.class)
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String content;

    @OneToOne
    @JoinColumn(name = "media_id")
    private Media media;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //@JsonManagedReference
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    //@JsonManagedReference
    @OneToMany(mappedBy = "post")
    private List<PostLike> likes;

    @CreatedDate
    @Column(name="creation_date")
    private Instant creationDate;

    public Post() {}

    public Post(String content, Media media, List<Comment> comments, User user, Instant creationDate, List<PostLike> likes) {
        this.content = content;
        this.media = media;
        this.comments = comments;
        this.user = user;
        this.creationDate = creationDate;
        this.likes = likes;
    }
}
