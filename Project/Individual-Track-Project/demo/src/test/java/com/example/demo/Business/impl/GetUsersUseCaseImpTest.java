package com.example.demo.Business.impl;

import com.example.demo.RepositoryClasses.User;
import com.example.demo.Repositories.UserItemRepository;
import com.example.demo.dto.GetUsersResponseDTO;
import com.example.demo.dto.UserDTO;
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
class GetUsersUseCaseImpTest {
    @Mock
    private UserItemRepository userItemRepositoryMock;

    @InjectMocks
    private GetUsersUseCaseImp getUsersUseCase;

    @Test
    void getUsers() {
       Long symbol = Long.valueOf(1);
        User user = User.builder()
                .id(1L)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("CLIENT")
                .build();
        when(userItemRepositoryMock.findAll()).thenReturn(List.of(user));
        GetUsersResponseDTO actualResult = getUsersUseCase.getUsers(symbol);
        UserDTO userDto = UserDTO.builder()
                .id(1)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("CLIENT")
                .build();
        GetUsersResponseDTO expectedResult = GetUsersResponseDTO.builder()
                .users(List.of(userDto))
                .build();
        assertEquals(expectedResult, actualResult);
        verify(userItemRepositoryMock).findAll();
    }
}