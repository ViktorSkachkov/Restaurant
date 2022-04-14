package com.example.demo;

import com.example.demo.MockAdministration.MockOrderAdministration;
import com.example.demo.MockAdministration.MockUserAdministration;
import com.example.demo.MockControllers.MockOrderController;
import com.example.demo.MockControllers.MockUserController;
import com.example.demo.MockDataHelpers.MockOrderDataHelper;
import com.example.demo.MockDataHelpers.MockUserDataHelper;
import com.example.demo.dto.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTests {
    MockUserDataHelper mudh = new MockUserDataHelper();
    MockUserAdministration mua = new MockUserAdministration(mudh);
    MockUserController muc = new MockUserController(mua);
    @Test
     void GetWorkers() {
        UserDTO worker = WorkerDTO.builder()
                .id(8)
                .firstName("John")
                .lastName("Arryn")
                .username("asoiaf")
                .password("eagleSigil")
                .email("john.arryn@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("335457689897645")
                .build();
        Assertions.assertEquals(worker, muc.GetWorkers().get(1));
    }
    @Test
     void GetClients() {
        UserDTO worker = ClientDTO.builder()
                .id(2)
                .firstName("Pavel")
                .lastName("dimitrov")
                .username("bomber")
                .password("Jackal")
                .email("pavel.dimitrov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("43554373753745")
                .build();
        Assertions.assertEquals(worker, muc.GetClients().get(1));
    }
    @Test
     void GetUser() {
        new ClientDTO(1, "Viktor", "Skachkov", "dragonslayer",
                "mahata", "viktor.skachkov01@gmail.com", "Pieter Breughelstraat 19", "94387758434785");
        UserDTO client = ClientDTO.builder()
                .id(1)
                .firstName("Viktor")
                .lastName("Skachkov")
                .username("dragonslayer")
                .password("mahata")
                .email("viktor.skachkov01@gmail.com")
                .address("Pieter Breughelstraat 19")
                .phone("94387758434785")
                .build();
        Assertions.assertEquals(client, muc.GetUser("dragonslayer",
                "mahata"));
    }
}
