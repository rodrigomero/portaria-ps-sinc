package com.mero.portaria.controller;

import com.mero.portaria.domain.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService service;

    @GetMapping("")
    public List<UserDTO> getAllUsers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Integer id) {
        return service.findUser(id);
    }

    @PostMapping("/save")
    public UserDTO saveUser(@RequestBody @Valid UserDTO dto) {

        return service.saveUser(dto);
    }

    @PostMapping("/login")
    public UserDTO loginUser(@RequestBody @Valid LoginDTO dto) {
        return service.login(dto);
    }
}
