package Fam.famm.repository;

import Fam.famm.dto.ClassDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassRepository extends JpaRepository<ClassDto, Long> {
    Optional<ClassDto> findByTitle(String title);
}
