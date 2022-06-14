package com.example.demo.Business.impl;

import com.example.demo.Repositories.UserItemRepository;
import com.example.demo.Repositories.UserRoleRepository;
import com.example.demo.RepositoryClasses.User;
import com.example.demo.RepositoryClasses.UserRole;
import com.example.demo.dto.GetUsersResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddUserRoleTest {
    @Mock
    private UserItemRepository userItemRepositoryMock;
    @Mock
    private UserRoleRepository userRoleRepositoryMock;
    @InjectMocks
    private GetUsersUseCaseImp getUsersUseCase;
    @Test
    void addUserRole() {
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
        UserRole newUserRole = UserRole.builder()
                .role(user1.getCategory())
                .userId(user1.getId())
                .build();
        when(userRoleRepositoryMock.save(newUserRole)).thenReturn(newUserRole);

        UserRole responseUserRole = userRoleRepositoryMock.save(newUserRole);
        assertEquals(newUserRole, responseUserRole);
        verify(userRoleRepositoryMock).save(newUserRole);
    }
}
