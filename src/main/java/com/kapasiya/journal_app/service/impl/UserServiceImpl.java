package com.kapasiya.journal_app.service.impl;

import com.kapasiya.journal_app.dto.request.UserRequestDTO;
import com.kapasiya.journal_app.dto.response.UserResponseDTO;
import com.kapasiya.journal_app.entity.User;
import com.kapasiya.journal_app.mapper.UserMapper;
import com.kapasiya.journal_app.repository.UserRepository;
import com.kapasiya.journal_app.service.def.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(UserMapper::toRDto).toList();
    }

    @Override
    public List<UserResponseDTO> addUser(UserRequestDTO requestDTO){
        userRepository.save(UserMapper.toEntity(requestDTO));
        List<User> userList = userRepository.findAll();
        return userList.stream().map(UserMapper::toRDto).toList();
    }

    @Override
    public List<UserResponseDTO> deleteUser(String id){
        userRepository.deleteById(id);
        List<User> userList = userRepository.findAll();
        return userList.stream().map(UserMapper::toRDto).toList();
    }
}
