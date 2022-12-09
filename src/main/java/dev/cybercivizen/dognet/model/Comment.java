package dev.cybercivizen.dognet.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String content;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    //@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonManagedReference
    @OneToMany(mappedBy = "comment")
    private List<Reply> replies;

    @JsonManagedReference
    @OneToMany(mappedBy = "comment")
    private List<CommentLike> likes;

    @CreatedDate
    @Column(name = "creation_date")
    private Instant creationDate;

    public Comment() {
    }

    public Comment(String content, Post post, User user, List<Reply> replies, List<CommentLike> likes, Instant creationDate) {
        this.content = content;
        this.post = post;
        this.user = user;
        this.replies = replies;
        this.likes = likes;
        this.creationDate = creationDate;
    }
}
