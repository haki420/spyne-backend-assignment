package Controllers;

import Models.Discussion;
import Services.DiscussionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/discussions")
public class DiscussionController {
    private DiscussionService discussionService;

    @PostMapping
    public Discussion createDiscussion(@RequestBody Discussion discussion) {
        return discussionService.createDiscussion(discussion);
    }

    @GetMapping("/tags")
    public List<Discussion> getDiscussionsByTags(@RequestParam List<String> tags) {
        return discussionService.findDiscussionsByTags(tags);
    }

    @GetMapping("/search")
    public List<Discussion> getDiscussionsByText(@RequestParam String text) {
        return discussionService.findDiscussionsByText(text);
    }
}
