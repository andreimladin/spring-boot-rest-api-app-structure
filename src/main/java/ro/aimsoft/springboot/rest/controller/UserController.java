package ro.aimsoft.springboot.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.aimsoft.springboot.rest.dto.UserCreationDTO;
import ro.aimsoft.springboot.rest.dto.UserDTO;
import ro.aimsoft.springboot.rest.service.UserService;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody UserCreationDTO userCreationDTO) {
        userService.createUser(userCreationDTO);
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable @NotNull UUID id) {
        return userService.getUser(id);
    }

}
