package Fam.famm.controller;

import Fam.famm.dto.ClassDto;
import Fam.famm.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/class")
public class ClassController {

    @Autowired
    private ClassService classService;

    @GetMapping("") //모든 클래스 조회
    public List<ClassDto> getAllClass() {
        return classService.getAllClass();
    }

    @GetMapping("/{title}") // 특정 타이틀의 클래스 정보를 조회
    public ClassDto getClassById(@PathVariable String title) {
        return classService.getClassById(title);
    }

    @PostMapping("") // 클래스 등록
    public ClassDto registerClass(@RequestBody ClassDto classDto) {
        return classService.registerClass(classDto);
    }

    @PutMapping("/{title}") // 클래스 수정
    public void modifyClass(@PathVariable String title, @RequestBody ClassDto classDto) {
        classService.modifyClass(title, classDto);
    }

    @DeleteMapping("/{title}") // 클래스 삭제
    public void removeClass(@PathVariable String title) {
        classService.removeClass(title);
    }
}
