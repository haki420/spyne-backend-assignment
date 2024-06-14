package Controllers;

import Models.Comment;
import Models.Like;
import Services.CommentService;
import Services.LikeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private CommentService commentService;
    private LikeService likeService;

    @PostMapping
    public Comment createComment(@RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @PostMapping("/{id}/like")
    public Like likeComment(@PathVariable Long id, @RequestBody Like like) {
        like.setComment(commentService.findCommentById(id));
        return likeService.likeComment(like);
    }
}