package com.example.demo.Business.impl;

import com.example.demo.Repositories.UserRoleRepository;
import com.example.demo.RepositoryClasses.User;
import com.example.demo.Repositories.UserItemRepository;
import com.example.demo.RepositoryClasses.UserRole;
import com.example.demo.dto.CreateUserRequestDTO;
import com.example.demo.dto.CreateUserResponseDTO;
import com.example.demo.dto.GetMealsResponseDTO;
import com.example.demo.dto.GetUsersResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddUserUseCaseImpTest {
    @Mock
    private UserItemRepository userItemRepositoryMock;
    @Mock
    private UserRoleRepository userRoleRepositoryMock;
    @InjectMocks
    private AddUserUseCaseImp addUserUseCase;

    @InjectMocks
    private GetUsersUseCaseImp getUsersUseCase;
    @Test
    void addUser() {
        Long symbol = Long.valueOf(1);
        User user1 = User.builder()
                .id(1L)
                .category("CLIENT")
                .phone("94387758434785")
                .address("Pieter Breughelstraat 19")
                .pwd("mahata")
                .username("dragonslayer")
                .email("viktor.skachkov01@gmail.com")
                .firstName("Viktor")
                .lastName("Skachkov")
                .build();
        when(userItemRepositoryMock.findAll()).thenReturn(List.of(user1));
        GetUsersResponseDTO getUsersResponseDTO = getUsersUseCase.getUsers(symbol);
        User user2 = User.builder()
                //.id(2L)
                .category("CLIENT")
                .phone("43554373753745")
                .address("Pieter Breughelstraat 19")
                .pwd("Jackal")
                .username("bomber")
                .email("pavel.dimitrov01@gmail.com")
                .firstName("Pavel")
                .lastName("Dimitrov")
                .build();
        CreateUserRequestDTO createUserRequestDTO = CreateUserRequestDTO.builder()
                .category(user2.getCategory())
                .phone(user2.getPhone())
                .address(user2.getAddress())
                .pwd(user2.getPwd())
                .username(user2.getUsername())
                .email(user2.getEmail())
                .firstName(user2.getFirstName())
                .lastName(user2.getLastName())
                .build();
        /*when(userItemRepositoryMock.save(user2)).thenReturn(user2);
        User savedUser = userItemRepositoryMock.save(user2);
        assertEquals(user2.getUsername(), savedUser.getUsername());*/
        when(userItemRepositoryMock.save(user2)).thenReturn(user2);
        CreateUserResponseDTO actualResult = addUserUseCase.createUser(createUserRequestDTO);
        CreateUserResponseDTO expectedResult = CreateUserResponseDTO.builder()
                .userId(user2.getId())
                .build();
        assertEquals(expectedResult, actualResult);
    }
}