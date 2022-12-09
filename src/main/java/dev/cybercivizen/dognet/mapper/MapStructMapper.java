package dev.cybercivizen.dognet.mapper;

import dev.cybercivizen.dognet.dto.*;
import dev.cybercivizen.dognet.model.*;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
     PostDTO postToPostDto(Post post);
     List<PostDTO> postsToPostsDto(List<Post> post);
     MediaDTO mediaToMediaDto(Media media);
     List<PostLikeDTO> postLikesToPostLikesDto(List<PostLike> postLike);
     UserPreviewDTO userToUserPreviewDto(User user);
     List<CommentDTO> commentsToCommentsDto(List<Comment> comment);
     List<CommentLikeDTO> commentLikesToCommentLikesDto(List<CommentLike> commentLike);
     List<ReplyDTO> repliesToRepliesDto(List<Reply> reply);
}
