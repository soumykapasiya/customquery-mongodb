package com.kapasiya.journal_app.dto.response;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class UserResponseDTO {

    private String id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private boolean sentimentalAnalysis;
}
