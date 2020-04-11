package ro.aimsoft.springboot.rest.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.aimsoft.springboot.rest.dto.UserCreationDTO;
import ro.aimsoft.springboot.rest.dto.UserDTO;
import ro.aimsoft.springboot.rest.entity.User;
import ro.aimsoft.springboot.rest.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public void createUser(UserCreationDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        user.setId(UUID.randomUUID());

        userRepo.save(user);
    }

    public List<UserDTO> getAllUsers() {
        return userRepo.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    public UserDTO getUser(UUID id) {
        return userRepo.findById(id)
                .map(user -> modelMapper.map(user, UserDTO.class))
                .orElseThrow(EntityNotFoundException::new);
    }
}
