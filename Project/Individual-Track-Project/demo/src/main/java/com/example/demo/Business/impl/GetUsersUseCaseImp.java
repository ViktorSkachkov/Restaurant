package com.example.demo.Business.impl;

import com.example.demo.Business.GetUsersUseCase;
import com.example.demo.Business.exception.UnauthorizedDataAccessException;
import com.example.demo.Normal.RoleEnum;
import com.example.demo.Repositories.MealRepository;
import com.example.demo.Repositories.UserItemRepository;
import com.example.demo.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
final class GetUsersUseCaseImp implements GetUsersUseCase {
    private final UserItemRepository userItemRepository;
    private AccessTokenDTO requestAccessToken;
    @Override
    public GetUsersResponseDTO getUsers(long userId) {
        /*if (!requestAccessToken.hasRole(RoleEnum.WORKER.name())) {
            if (requestAccessToken.getUserId() != userId) {
                throw new UnauthorizedDataAccessException("USER_ID_NOT_FROM_LOGGED_IN_USER");
            }
        }*/
        List<UserDTO> userItems = userItemRepository.findAll()
                .stream()
                .map(UserDTOConverter::convertToDTO)
                .toList();

        return GetUsersResponseDTO.builder()
                .users(userItems)
                .build();
    }
}
