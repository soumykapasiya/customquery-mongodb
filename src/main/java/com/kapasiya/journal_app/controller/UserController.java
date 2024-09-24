package com.kapasiya.journal_app.controller;

import com.kapasiya.journal_app.dto.request.UserRequestDTO;
import com.kapasiya.journal_app.dto.response.UserResponseDTO;
import com.kapasiya.journal_app.entity.User;
import com.kapasiya.journal_app.service.def.CustomUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final CustomUserService customUserService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        return ResponseEntity.ok().body(customUserService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<List<User>> addUser(@RequestBody UserRequestDTO requestDTO){
        return ResponseEntity.ok().body(customUserService.addUsers(requestDTO));
    }

    @DeleteMapping
    public ResponseEntity<List<UserResponseDTO>> deleteUser(@RequestParam String id){
        return ResponseEntity.ok().body(customUserService.deleteUser(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<UserResponseDTO>> getAllUsersByMongoTemp(){
        return ResponseEntity.ok().body(customUserService.getUserForSA());
    }

}
