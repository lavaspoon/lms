package lava.lms.controller;

import lava.lms.domain.WatchProgress;
import lava.lms.dto.WatchProgressDto;
import lava.lms.service.WatchProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000") // React 앱의 주소
@RestController
@RequestMapping("/api/vimeo")
public class WatchProgressController {

    @Autowired
    private WatchProgressService watchProgressService;

    @GetMapping("/last-watch-time")
    public ResponseEntity<?> getLastWatchTime(@RequestParam String userId, @RequestParam Long videoId) {
        return watchProgressService.getLastWatchTime(userId, videoId)
                .map(watchProgress -> ResponseEntity.ok(watchProgress.getLastWatchTime()))
                .orElse(ResponseEntity.ok(0)); // 없으면 0 리턴
    }

    @PostMapping("/save-watch-time")
    public ResponseEntity<?> saveWatchTime(@RequestBody WatchProgressDto watchProgressDto) {
        System.out.println("watchProgressDto = " + watchProgressDto);
        watchProgressService.saveWatchProgress(watchProgressDto);
        return ResponseEntity.ok("Progress saved");
    }

}

