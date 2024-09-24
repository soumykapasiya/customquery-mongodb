package com.kapasiya.journal_app.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@Document("im_user")
public class User {
    @Id
    private String id;
    private String name;
    @NonNull
    private String email;
    private String phone;
    @NonNull
    private String password;
    @Builder.Default
    private boolean sentimentalAnalysis = false;
    @DBRef private Set<Role> roles = new HashSet<>();

}
