package Services;

import Models.Like;
import Repository.LikeRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    private LikeRepository likeRepository;

    public Like likeComment(Like like) {
        return likeRepository.save(like);
    }
}
