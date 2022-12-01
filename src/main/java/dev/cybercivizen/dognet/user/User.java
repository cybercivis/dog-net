package dev.cybercivizen.dognet.user;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import dev.cybercivizen.dognet.comment.Comment;
import dev.cybercivizen.dognet.commentLike.CommentLike;
import dev.cybercivizen.dognet.country.Country;
import dev.cybercivizen.dognet.post.Post;
import dev.cybercivizen.dognet.postLike.PostLike;
import dev.cybercivizen.dognet.reply.Reply;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    private String username;
    private String password;
    private String email;

    @ManyToOne
    @JoinColumn(name= "country_id")
    private Country country;

    @Column(name="picture_file_path", nullable = true)
    private String pictureFilePath;

    @Column(name="birth_date", nullable = false)
    private Date birthDate;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Reply> replies;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<PostLike> postLikes;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<CommentLike> commentLikes;

    @CreatedDate
    @Column(name="creation_date")
    private Instant creationDate;

    public User() { /*For Spring Data JPA */ }

    public User(String firstName, String lastName, String username, String password, String email, Country country, String pictureFilePath, Date birthDate, List<Post> posts, List<Comment> comments, List<Reply> replies, List<PostLike> postLikes, List<CommentLike> commentLikes, Instant creationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.country = country;
        this.pictureFilePath = pictureFilePath;
        this.birthDate = birthDate;
        this.posts = posts;
        this.comments = comments;
        this.replies = replies;
        this.postLikes = postLikes;
        this.commentLikes = commentLikes;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getPictureFilePath() {
        return pictureFilePath;
    }

    public void setPictureFilePath(String pictureFilePath) {
        this.pictureFilePath = pictureFilePath;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> post) {
        this.posts = post;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comment) {
        this.comments = comment;
    }

    public List<PostLike> getPostLikes() {
        return postLikes;
    }

    public void setPostLikes(List<PostLike> postLikes) {
        this.postLikes = postLikes;
    }

    public List<CommentLike> getCommentLikes() {
        return commentLikes;
    }

    public void setCommentLikes(List<CommentLike> commentLikes) {
        this.commentLikes = commentLikes;
    }

    public Instant getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Instant creationDate) {
        this.creationDate = creationDate;
    }

}
