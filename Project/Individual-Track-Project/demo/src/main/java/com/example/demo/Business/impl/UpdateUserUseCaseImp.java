package com.example.demo.Business.impl;

import com.example.demo.Business.UpdateUserUseCase;
import com.example.demo.Repositories.UserItemRepository;
import com.example.demo.RepositoryClasses.User;
import com.example.demo.dto.UpdateUserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UpdateUserUseCaseImp implements UpdateUserUseCase {
    private final UserItemRepository userRepository;

    @Override
    @Transactional
    public User updateUser(UpdateUserRequestDTO request) {
        Optional<User> userOptional = userRepository.findById((long) request.getId());
        User user = userOptional.get();
        user.setCategory(request.getCategory());
        user.setAddress(request.getAddress());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhone(request.getPhone());
        user.setPwd(request.getPwd());
        userRepository.save(user);
        return user;
    }
}
