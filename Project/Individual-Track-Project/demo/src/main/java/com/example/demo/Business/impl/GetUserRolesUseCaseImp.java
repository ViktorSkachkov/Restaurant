package com.example.demo.Business.impl;

//import com.example.demo.Business.GetUserRolesUseCase;
import com.example.demo.Repositories.TableItemRepository;
import com.example.demo.Repositories.UserRoleRepository;
import com.example.demo.dto.GetTableItemsResponseDTO;
//import com.example.demo.dto.GetUserRolesResponseDTO;
import com.example.demo.dto.TableItemDTO;
//import com.example.demo.dto.UserRoleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetUserRolesUseCaseImp /*implements GetUserRolesUseCase*/ {
    private final UserRoleRepository userRoleRepository;

    /*@Override
    public GetUserRolesResponseDTO getUserRoles() {
        List<UserRoleDTO> userRoles = userRoleRepository.findAll()
                .stream()
                .map(UserRoleDTOConverter::convertToDTO)
                .toList();

        return GetUserRolesResponseDTO.builder()
                .userRoles(userRoles)
                .build();
    }*/
}
