package Repository;

import Models.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscussionRepository extends JpaRepository<Discussion, Long> {
    List<Discussion> findByHashtagsNameIn(List<String> tags);
    List<Discussion> findByTextContaining(String text);
}
