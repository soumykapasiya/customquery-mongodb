package com.kapasiya.journal_app.service.def;


import com.kapasiya.journal_app.dto.request.UserRequestDTO;
import com.kapasiya.journal_app.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {


    List<UserResponseDTO> getAllUsers();

    List<UserResponseDTO> addUser(UserRequestDTO requestDTO);

    List<UserResponseDTO> deleteUser(String id);
}
