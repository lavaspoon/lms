package lava.lms.repository;

import lava.lms.domain.WatchProgress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WatchProgressRepository extends JpaRepository<WatchProgress, Long> {
    Optional<WatchProgress> findByUserIdAndVideoId(String userId, Long videoId);
}