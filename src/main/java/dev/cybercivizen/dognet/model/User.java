package dev.cybercivizen.dognet.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Getter
@Setter
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
}
