package com.example.demo.Business.impl;

import com.example.demo.Repositories.UserItemRepository;
import com.example.demo.RepositoryClasses.User;
import com.example.demo.dto.UpdateUserRequestDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UpdateUserUseCaseImpTest {
    @Mock
    private UserItemRepository userItemRepositoryMock;
    @InjectMocks
    private UpdateUserUseCaseImp updateUserUseCase;
    @Test
    void updateUser() {
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
        User newUser = User.builder()
                .category("CLIENT")
                .phone("94387758434785")
                .address("Pieter Breughelstraat")
                .pwd("mahata")
                .username("dragonslayer")
                .email("viktor.skachkov01@gmail.com")
                .firstName("Viktor")
                .lastName("Skachkov")
                .build();
        User expectedUser = User.builder()
                .id(1L)
                .category("CLIENT")
                .phone("94387758434785")
                .address("Pieter Breughelstraat")
                .pwd("mahata")
                .username("dragonslayer")
                .email("viktor.skachkov01@gmail.com")
                .firstName("Viktor")
                .lastName("Skachkov")
                .build();
        when(userItemRepositoryMock.findAll()).thenReturn(List.of(user1));
        List<User> userList = userItemRepositoryMock.findAll();
        UpdateUserRequestDTO updateUserRequestDTO = UpdateUserRequestDTO.builder()
                .id(1)
                .category("CLIENT")
                .phone("94387758434785")
                .address("Pieter Breughelstraat")
                .pwd("mahata")
                .username("dragonslayer")
                .email("viktor.skachkov01@gmail.com")
                .firstName("Viktor")
                .lastName("Skachkov")
                .build();
        when(userItemRepositoryMock.findById((long) updateUserRequestDTO.getId())).thenReturn(Optional.of(user1));
        Optional<User> u = userItemRepositoryMock.findById((long) updateUserRequestDTO.getId());
        when(userItemRepositoryMock.save(newUser)).thenReturn(newUser);
        User result = userItemRepositoryMock.save(newUser);
        User returnUser = updateUserUseCase.updateUser(updateUserRequestDTO);
        assertEquals(expectedUser, returnUser);
    }
}