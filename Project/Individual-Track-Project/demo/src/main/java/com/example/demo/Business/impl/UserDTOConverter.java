package com.example.demo.Business.impl;

import com.example.demo.Normal.*;
import com.example.demo.dto.ClientDTO;
import com.example.demo.dto.TableItemDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.dto.WorkerDTO;

final class UserDTOConverter {
    private UserDTOConverter() {

    }
    public static UserDTO convertToDTO(User user) {
        return UserDTO.builder()
                    .id(user.getId())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .username(user.getUsername())
                    .pwd(user.getPwd())
                    .email(user.getEmail())
                    .address(user.getAddress())
                    .phone(user.getPhone())
                    .logged(false)
                    .category(user.getCategory())
                    .build();
    }
}
