package lava.lms.repository;

import lava.lms.domain.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
    // 비디오 관련 메소드 정의
}