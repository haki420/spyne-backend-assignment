package Services;

import Models.Discussion;
import Models.Hashtag;
import Repository.DiscussionRepository;
import Repository.HashtagRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DiscussionService {
    private DiscussionRepository discussionRepository;

    private HashtagRepository hashtagRepository;

    public Discussion createDiscussion(Discussion discussion) {
        discussion.setCreatedOn(LocalDateTime.now());
        Set<Hashtag> hashtags = discussion.getHashtags().stream()
                .map(tag -> hashtagRepository.findByName(tag.getName()).orElse(tag))
                .collect(Collectors.toSet());
        discussion.setHashtags(hashtags);
        return discussionRepository.save(discussion);
    }

    public List<Discussion> findDiscussionsByTags(List<String> tags) {
        return discussionRepository.findByHashtagsNameIn(tags);
    }

    public List<Discussion> findDiscussionsByText(String text) {
        return discussionRepository.findByTextContaining(text);
    }
}