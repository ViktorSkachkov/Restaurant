package com.example.demo.Business.impl;

import com.example.demo.Business.AccessTokenEncoder;
import com.example.demo.Business.LoginUseCase;
import com.example.demo.Business.exception.InvalidCredentialsException;
import com.example.demo.RepositoryClasses.RoleEnum;
import com.example.demo.RepositoryClasses.User;
import com.example.demo.Repositories.UserItemRepository;
import com.example.demo.Repositories.UserRoleRepository;
import com.example.demo.dto.AccessTokenDTO;
import com.example.demo.dto.LoginRequestDTO;
import com.example.demo.dto.LoginResponseDTO;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {
    private final UserItemRepository userItemRepository;
    private final UserRoleRepository userRoleRepository;
    //private final PasswordEncoder passwordEncoder;
    private final AccessTokenEncoder accessTokenEncoder;

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequest) {
User user = userItemRepository.findByUsername(loginRequest.getUsername());
        if (user == null) {
            throw new InvalidCredentialsException();
        }
       /* if (loginRequest.getPwd().equals(user.getPwd())) {
            throw new InvalidCredentialsException();
        }*/
        /*if (!matchesPassword(loginRequest.getPwd(), user.getPwd())) {
            throw new InvalidCredentialsException();
        }*/


        String accessToken = generateAccessToken(user);
        return LoginResponseDTO.builder().accessToken(accessToken).build();
    }
    /*private boolean matchesPassword(String rawPassword, String encodedPassword) {
        // TODO: implement this part
        return passwordEncoder.matches(rawPassword, encodedPassword);
       // return true;
    }*/

    /*List<String> roles = user.getUserRoles().stream()
              .map(userRole -> userRole.getRole().toString())
              .toList();*/

    private String generateAccessToken(User user) {
        Long id = user.getId();
        List<String> roles = new ArrayList<>();
        /*for(UserRole userRole : userRoleRepository.findAll()) {
            if(userRole.getUserId() == user.getId()) {
                roles.add(userRole.getRole().name());
            }
        }*/
        /*for(UserRole userRole : userRoleRepository.findAll())
        {
            if(userRole.getUserId().equals(user.getId())) {
                if(userRole.getRole().equals("CLIENT")) {
                    roles.add(RoleEnum.CLIENT.name());
                }
                if(userRole.getRole().equals("WORKER")) {
                    roles.add(RoleEnum.WORKER.name());
                }
            }
        }*/

        roles = user.getUserRoles().stream()
                .map(userRole -> userRole.getRole().toString())
                .toList();

        //roles.add(RoleEnum.WORKER.name());
        AccessTokenDTO a = AccessTokenDTO.builder()
                .subject(user.getUsername())
                .roles(roles)
                .userId(Long.parseLong(String.valueOf(id)))
                .build();
        return accessTokenEncoder.encode(a);
        //return "";
    }
    @Override
    public AccessTokenDTO generateToken(Long id, String username) {
        Long ID = id;
        List<String> roles = new ArrayList<>();
        /*for(UserRole userRole : userRoleRepository.findAll()) {
            if(userRole.getUserId() == user.getId()) {
                roles.add(userRole.getRole().name());
            }
        }*/
        roles.add(RoleEnum.WORKER.name());
        AccessTokenDTO a = AccessTokenDTO.builder()
                .subject(username)
                .roles(roles)
                .userId(Long.parseLong(String.valueOf(ID)))
                .build();
        return a;
        //return "";
    }
}
