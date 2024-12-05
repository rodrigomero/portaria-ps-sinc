package com.mero.portaria.domain.service;

import java.util.List;

public interface UserService {
    UserDTO findUser(Integer id);

    UserDTO findByUsername(String username);

    UserDTO saveUser(UserDTO dto);

    UserDTO login(LoginDTO dto);

    List<UserDTO> findAll();
}
