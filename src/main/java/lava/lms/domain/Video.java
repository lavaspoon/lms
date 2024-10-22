package lava.lms.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "videos")
public class Video {
    @Id
    private Long id; // Vimeo ID
    private String title;
    private String thumbnail;

    // getters and setters
}