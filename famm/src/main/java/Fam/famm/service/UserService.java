package Fam.famm.service;

import Fam.famm.dto.UserDto;
import Fam.famm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAllUser() {
        return userRepository.findAll();
    }

    public UserDto getUserById(String name) {
        Optional<UserDto> userOptional = userRepository.findByName(name);
        return userOptional.orElse(null);
    }

    public UserDto registerUser(UserDto userDto) {
        return userRepository.save(userDto);
    }

}
