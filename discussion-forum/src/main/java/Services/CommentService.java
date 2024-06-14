package Services;

import Models.Comment;
import Repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {
    private CommentRepository commentRepository;

    public Comment createComment(Comment comment) {
        comment.setCreatedOn(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    public Comment findCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }
}