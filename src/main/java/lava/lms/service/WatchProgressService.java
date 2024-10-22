package lava.lms.service;

import jakarta.transaction.Transactional;
import lava.lms.domain.User;
import lava.lms.domain.Video;
import lava.lms.domain.WatchProgress;
import lava.lms.dto.WatchProgressDto;
import lava.lms.repository.UserRepository;
import lava.lms.repository.VideoRepository;
import lava.lms.repository.WatchProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WatchProgressService {

    @Autowired
    private WatchProgressRepository watchProgressRepository;

    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    private UserRepository userRepository;

    public Optional<WatchProgress> getLastWatchTime(String userId, Long videoId) {
        return watchProgressRepository.findByUserIdAndVideoId(userId, videoId);
    }

    @Transactional
    public void saveWatchProgress(WatchProgressDto dto) {
        // User 엔티티를 찾기
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Video video = videoRepository.findById(dto.getVideoId())
                .orElseThrow(() -> new IllegalArgumentException("Video not found"));

        // WatchProgress 엔티티 생성 및 설정
        WatchProgress watchProgress = new WatchProgress();
        watchProgress.setUser(user); // User 객체 설정
        watchProgress.setVideo(video);
        watchProgress.setWatchedPercentage(dto.getWatchedPercentage());

        // DB에 저장
        watchProgressRepository.save(watchProgress);
    }

}