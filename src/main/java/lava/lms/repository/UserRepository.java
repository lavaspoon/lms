package lava.lms.repository;

import lava.lms.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    // 사용자 관련 메소드 정의
}
