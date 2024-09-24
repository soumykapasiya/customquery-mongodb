package com.kapasiya.journal_app.service.def;

import com.kapasiya.journal_app.dto.request.UserRequestDTO;
import com.kapasiya.journal_app.dto.response.UserResponseDTO;
import com.kapasiya.journal_app.entity.User;

import java.util.List;

public interface CustomUserService {
    List<UserResponseDTO> getUserForSA();

    List<UserResponseDTO> getAllUsers();

    List<UserResponseDTO> deleteUser(String id);

    List<User> addUsers(UserRequestDTO requestDTO);
}
