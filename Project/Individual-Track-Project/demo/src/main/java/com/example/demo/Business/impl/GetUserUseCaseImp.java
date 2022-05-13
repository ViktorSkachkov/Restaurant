package com.example.demo.Business.impl;

//import com.example.demo.Business.GetUserUseCase;
import com.example.demo.Business.exception.UnauthorizedDataAccessException;
import com.example.demo.Normal.RoleEnum;
import com.example.demo.Repositories.UserItemRepository;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.dto.AccessTokenDTO;
import com.example.demo.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/*@Service
@AllArgsConstructor*/
public class GetUserUseCaseImp /*implements GetUserUseCase */{
    /*private final UserItemRepository userItemRepository;
    private final GetUserUseCase getUserUseCase;
    private final AccessTokenDTO requestAccessToken;*/

    /*@Override*/
   // public Optional<UserDTO> getUser(long userId) {
            /*if (!requestAccessToken.hasRole(RoleEnum.WORKER.name()) || !requestAccessToken.hasRole(RoleEnum.CLIENT.name())) {
            if (requestAccessToken.getUserId() != userId) {
                throw new UnauthorizedDataAccessException("USER_ID_NOT_FROM_LOGGED_IN_USER");
            }
        }
        return getUserUseCase.getUser(userId);*/
       // return userItemRepository.findById(userId).map(UserDTOConverter::convertToDTO);

  //  }



    /*@Override
    public UserDTO GetUser(String username, String password) {
        UserDTO user = null;
        for(UserDTO u : udh.GetUsers()) {
            if(u.getUsername().equals(username) && u.getPwd().equals(password))
            {
                user = u;
            }
        }
        return user;
    }*/
}
