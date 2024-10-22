package lava.lms.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class WatchProgressDto {
    private String userId; // 사용자 ID
    private Long videoId; // 비디오 ID
    private Double watchedPercentage; // 시청 이수율

    // 생성자, getter, setter
}

