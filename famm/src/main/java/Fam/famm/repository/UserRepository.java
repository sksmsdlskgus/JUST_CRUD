package Fam.famm.repository;

import Fam.famm.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDto, Long> {
    Optional<UserDto> findByName(String name);
}
