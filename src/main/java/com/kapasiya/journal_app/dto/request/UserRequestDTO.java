package com.kapasiya.journal_app.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class UserRequestDTO {
    private String name;
    private String email;
    private String phone;
    private String password;
    private boolean sentimentalAnalysis;
    private List<String> rolesName;
}
