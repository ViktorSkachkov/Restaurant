package com.example.demo.Business.impl;

import com.example.demo.RepositoryClasses.User;
import com.example.demo.Repositories.UserItemRepository;
import com.example.demo.dto.CreateUserRequestDTO;
import com.example.demo.dto.CreateUserResponseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AddUserUseCaseImpTest {
    @Mock
    private UserItemRepository userItemRepositoryMock;
    @InjectMocks
    private AddUserUseCaseImp addUserUseCase;
    @Test
    void addUser() {
        /*Country netherlands = Country.builder().id(1L).code("NL").name("Netherlands").build();
        CreateCountryRequestDTO createCountryRequestDTO = CreateCountryRequestDTO.builder()
                .code(netherlands.getCode())
                .name(netherlands.getName())
                .build();
        CreateCountryResponseDTO actualResult = createCountryUseCaseImpl.createCountry(createCountryRequestDTO);
        CreateCountryResponseDTO expectedResult = CreateCountryResponseDTO.builder()
                .countryId(netherlands.getId())
                .build();*/
        User user = User.builder()
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
        CreateUserRequestDTO createUserRequestDTO = CreateUserRequestDTO.builder()
                .category(user.getCategory())
                .phone(user.getPhone())
                .address(user.getAddress())
                .pwd(user.getPwd())
                .username(user.getUsername())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
        CreateUserResponseDTO actualResult = addUserUseCase.createUser(createUserRequestDTO);
        CreateUserResponseDTO expectedResult = CreateUserResponseDTO.builder()
                .userId(user.getId())
                .build();
        assertEquals(expectedResult, actualResult);

        verify(userItemRepositoryMock).findAll();
    }
}