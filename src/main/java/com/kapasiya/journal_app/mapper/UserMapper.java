package com.kapasiya.journal_app.mapper;

import com.kapasiya.journal_app.dto.request.UserRequestDTO;
import com.kapasiya.journal_app.dto.response.UserResponseDTO;
import com.kapasiya.journal_app.entity.User;

import java.util.UUID;

public class UserMapper {

    private UserMapper(){
    }

    public static UserResponseDTO toRDto(User user){
        if (user == null){
            return null;
        }

        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .phone(user.getPhone())
                .sentimentalAnalysis(user.isSentimentalAnalysis())
                .build();
    }

    public static User toEntity(UserRequestDTO requestDTO){
        if (requestDTO == null){
            return null;
        }

        return User.builder()
                .id(UUID.randomUUID().toString().substring(0,8))
                .name(requestDTO.getName())
                .email(requestDTO.getEmail())
                .password(requestDTO.getPassword())
                .phone(requestDTO.getPhone())
                .sentimentalAnalysis(requestDTO.isSentimentalAnalysis())
                .build();
    }

}
