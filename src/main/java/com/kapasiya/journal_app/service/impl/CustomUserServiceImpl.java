package com.kapasiya.journal_app.service.impl;


import com.kapasiya.journal_app.dto.request.UserRequestDTO;
import com.kapasiya.journal_app.dto.response.UserResponseDTO;
import com.kapasiya.journal_app.entity.Role;
import com.kapasiya.journal_app.entity.User;
import com.kapasiya.journal_app.mapper.UserMapper;
import com.kapasiya.journal_app.repository.RoleRepository;
import com.kapasiya.journal_app.repository.UserRepository;
import com.kapasiya.journal_app.service.def.CustomUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class CustomUserServiceImpl implements CustomUserService {
    private final MongoTemplate mongoTemplate;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public List<UserResponseDTO> getUserForSA() {
        Query query = new Query();
        Criteria criteria = new Criteria();
        query.addCriteria(criteria.andOperator(
                Criteria.where("email").exists(true),
                Criteria.where("email").ne(null).ne(""),
                Criteria.where("sentimentalAnalysis").is(false))
        );
        List<User> users = mongoTemplate.find(query, User.class);
        return users.stream().parallel().map(UserMapper::toRDto).toList();
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = mongoTemplate.findAll(User.class);
        return users.stream().parallel().map(UserMapper::toRDto).toList();
    }

    @Override
    public List<UserResponseDTO> deleteUser(String id) {
        Query query = new Query();
        mongoTemplate.remove(query.addCriteria(Criteria.where("id").is(id)), "im_user");
        List<User> users = mongoTemplate.findAll(User.class);
        return users.stream().parallel().map(UserMapper::toRDto).toList();
    }

    @Override
    public List<User> addUsers(UserRequestDTO requestDTO) {
        User user = UserMapper.toEntity(requestDTO);
        List<String> userRoles = requestDTO.getRolesName();
        Set<Role> roleList = new HashSet<>();
        for (String role : userRoles) {
            roleList.add(roleRepository.findByName(role));
        }
        user.setRoles(roleList);
        return mongoTemplate.findAll(User.class);
    }


}
