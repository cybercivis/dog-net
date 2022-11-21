package dev.cybercivizen.dognet.comment;

import dev.cybercivizen.dognet.commentLike.CommentLike;
import dev.cybercivizen.dognet.post.Post;
import dev.cybercivizen.dognet.reply.Reply;
import dev.cybercivizen.dognet.user.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "comment")
    private List<Reply> replies;

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

    public List<CommentLike> getLikes() {
        return likes;
    }

    public void setLikes(List<CommentLike> likes) {
        this.likes = likes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }
}
