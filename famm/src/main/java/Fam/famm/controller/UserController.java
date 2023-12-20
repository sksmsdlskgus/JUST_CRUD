package Fam.famm.controller;

import Fam.famm.dto.UserDto;
import Fam.famm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("") //모든 유저 조회
    public List<UserDto> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/{name}") // 특정 유저의 이름으로 정보를 조회
    public UserDto getUserById(@PathVariable String name) {
        return userService.getUserById(name);
    }

    @PostMapping("") // 유저 등록
    public UserDto registerUser(@RequestBody UserDto userDto) {
        return userService.registerUser(userDto);
    }

}
