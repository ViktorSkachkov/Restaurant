package com.example.demo.Controllers;

import com.example.demo.Business.AccessTokenDecoder;
import com.example.demo.Business.AddUserUseCase;
import com.example.demo.Business.GetUsersUseCase;
import com.example.demo.Business.UpdateUserUseCase;
import com.example.demo.RepositoryClasses.User;
import com.example.demo.dto.CreateUserRequestDTO;
import com.example.demo.dto.CreateUserResponseDTO;
import com.example.demo.dto.GetUsersResponseDTO;
import com.example.demo.dto.UserDTO;
import org.h2.command.ddl.CreateUser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.context.annotation.FilterType.CUSTOM;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private GetUsersUseCase getUsersUseCase;
    @MockBean
    private AddUserUseCase addUserUseCase;
    @MockBean
    private UpdateUserUseCase updateUserUseCase;
    @MockBean
    private AccessTokenDecoder accessTokenDecoder;
    @Test
    void getClients() throws Exception {
        GetUsersResponseDTO getUsersResponseDTO = GetUsersResponseDTO.builder()
                .users(List.of(UserDTO.builder()
                        .id(1)
                        .firstName("Viktor")
                        .lastName("Skachkov")
                        .username("dragonslayer")
                        .pwd("mahata")
                        .email("viktor.skachkov01@gmail.com")
                        .address("Pieter Breughelstraat 19")
                        .phone("94387758434785")
                        .category("CLIENT")
                        .build()))
                .build();
        when(getUsersUseCase.getUsers(0))
                .thenReturn(getUsersResponseDTO);

        mockMvc.perform(get("/users/clients"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                            [ {     "id": 1,
                                                     "firstName": "Viktor",
                                                     "lastName": "Skachkov",
                                                     "username": "dragonslayer",
                                                     "pwd": "mahata",
                                                     "email" : "viktor.skachkov01@gmail.com",
                                                     "address" : "Pieter Breughelstraat 19",
                                                     "phone" : "94387758434785",
                                                     "category": "CLIENT"}]
                        """));

        verify(getUsersUseCase).getUsers(0);
    }
    @Test
    void getWorkers() throws Exception {
        GetUsersResponseDTO getUsersResponseDTO = GetUsersResponseDTO.builder()
                .users(List.of(UserDTO.builder()
                        .id(1)
                        .firstName("Viktor")
                        .lastName("Skachkov")
                        .username("dragonslayer")
                        .pwd("mahata")
                        .email("viktor.skachkov01@gmail.com")
                        .address("Pieter Breughelstraat 19")
                        .phone("94387758434785")
                        .category("WORKER")
                        .build()))
                .build();
        when(getUsersUseCase.getUsers(0))
                .thenReturn(getUsersResponseDTO);

        mockMvc.perform(get("/users/workers"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                            [ {     "id": 1,
                                                     "firstName": "Viktor",
                                                     "lastName": "Skachkov",
                                                     "username": "dragonslayer",
                                                     "pwd": "mahata",
                                                     "email" : "viktor.skachkov01@gmail.com",
                                                     "address" : "Pieter Breughelstraat 19",
                                                     "phone" : "94387758434785",
                                                     "category": "WORKER"}]
                        """));

        verify(getUsersUseCase).getUsers(0);
    }
    @Test
    void getSpecificUser() throws Exception {
        GetUsersResponseDTO getUsersResponseDTO = GetUsersResponseDTO.builder()
                .users(List.of(UserDTO.builder()
                        .id(1)
                        .firstName("Viktor")
                        .lastName("Skachkov")
                        .username("dragonslayer")
                        .pwd("mahata")
                        .email("viktor.skachkov01@gmail.com")
                        .address("Pieter Breughelstraat 19")
                        .phone("94387758434785")
                        .category("WORKER")
                        .build()))
                .build();
        when(getUsersUseCase.getUsers(0))
                .thenReturn(getUsersResponseDTO);

        mockMvc.perform(get("/users/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                            {     "id": 1,
                                                     "firstName": "Viktor",
                                                     "lastName": "Skachkov",
                                                     "username": "dragonslayer",
                                                     "pwd": "mahata",
                                                     "email" : "viktor.skachkov01@gmail.com",
                                                     "address" : "Pieter Breughelstraat 19",
                                                     "phone" : "94387758434785",
                                                     "category": "WORKER"}
                        """));

        verify(getUsersUseCase).getUsers(0);
    }
    @Test
    void addUser() throws Exception {
        CreateUserRequestDTO createUserRequestDTO = CreateUserRequestDTO.builder()
                        .firstName("Viktor")
                        .lastName("Skachkov")
                        .username("dragonslayer")
                        .pwd("mahata")
                        .email("viktor.skachkov01@gmail.com")
                        .address("Pieter Breughelstraat 19")
                        .phone("94387758434785")
                        .category("WORKER")
                .build();
        User user = User.builder()
                .id(1L)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .pwd("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .category("WORKER")
                .build();
        CreateUserResponseDTO createUserResponseDTO = CreateUserResponseDTO.builder()
                .userId(1L)
                .build();
        when(addUserUseCase.createUser(createUserRequestDTO)).thenReturn(createUserResponseDTO);
        mockMvc.perform(post("/users")
                .contentType(APPLICATION_JSON_VALUE)
                .content("""
                        {
                                  "firstName": "Viktor",
                                                     "lastName": "Skachkov",
                                                     "username": "dragonslayer",
                                                     "pwd": "mahata",
                                                     "email" : "viktor.skachkov01@gmail.com",
                                                     "address" : "Pieter Breughelstraat 19",
                                                     "phone" : "94387758434785",
                                                     "category": "WORKER"}
                        }
                        """))
                       .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json("""
                            { "userId":  1 }
                       """));
        verify(addUserUseCase).createUser(createUserRequestDTO);
    }
}