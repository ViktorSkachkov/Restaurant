package com.example.demo.Business.impl;

import com.example.demo.Business.AddUserUseCase;
import com.example.demo.Business.GetUsersUseCase;
import com.example.demo.RepositoryClasses.User;
import com.example.demo.RepositoryClasses.UserRole;
import com.example.demo.Repositories.UserItemRepository;
import com.example.demo.Repositories.UserRoleRepository;
import com.example.demo.dto.CreateUserRequestDTO;
import com.example.demo.dto.CreateUserResponseDTO;
import com.example.demo.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddUserUseCaseImp implements AddUserUseCase {
    private final UserItemRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final GetUsersUseCase getUsersUseCase;

    @Transactional
    @Override
    public CreateUserResponseDTO createUser(CreateUserRequestDTO request) {
        User savedUser = saveNewUser(request);

        return CreateUserResponseDTO.builder()
                .userId(savedUser.getId())
                .build();
    }


    private User saveNewUser(CreateUserRequestDTO requestDTO) {
        List<UserDTO> listOfUsers = getUsersUseCase.getUsers(0).getUsers();
        int lastIndex = listOfUsers.size() - 1;
        Long index = Long.valueOf(listOfUsers.get(lastIndex).getId() + 1);
        User newUser = User.builder()
                .category(requestDTO.getCategory())
                .address(requestDTO.getAddress())
                .email(requestDTO.getEmail())
                .username(requestDTO.getUsername())
                .pwd(requestDTO.getPwd())
                .phone(requestDTO.getPhone())
                .firstName(requestDTO.getFirstName())
                .lastName(requestDTO.getLastName())
                .build();
        UserRole newUserRole = UserRole.builder()
                .role(requestDTO.getCategory())
                .userId(index)
                .build();
        userRoleRepository.save(newUserRole);
       return userRepository.save(newUser);
    }
}
