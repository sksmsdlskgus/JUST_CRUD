package Fam.famm.service;

import Fam.famm.dto.ClassDto;
import Fam.famm.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {

    @Autowired
    private ClassRepository classRepository;

    public List<ClassDto> getAllClass() {
        return classRepository.findAll();
    }

    public ClassDto getClassById(String title) {
        Optional<ClassDto> classOptional = classRepository.findByTitle(title);
        return classOptional.orElse(null);
    }

    public ClassDto registerClass(ClassDto classDto) {
        return classRepository.save(classDto);
    }

    public void modifyClass(String title, ClassDto updatedClassDto) {
        Optional<ClassDto> classOptional = classRepository.findByTitle(title);
        if (classOptional.isPresent()) {
            ClassDto existingClass = classOptional.get();
            existingClass.setTitle(updatedClassDto.getTitle());
            existingClass.setContent(updatedClassDto.getContent());
            existingClass.setName(updatedClassDto.getName());
            classRepository.save(existingClass);
        } else {
            throw new IllegalArgumentException("Class not found: " + title);
        }
    }

    public void removeClass(String title) {
        Optional<ClassDto> classOptional = classRepository.findByTitle(title);
        classOptional.ifPresent(classRepository::delete);
    }
}
