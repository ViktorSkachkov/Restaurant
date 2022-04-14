package com.example.demo.Administrations;
import com.example.demo.DataHelpers.UserDataHelper;
import com.example.demo.dto.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAdministration {
    private UserDataHelper userDataHelper;
    public UserAdministration(UserDataHelper userDataHelper) {
        this.userDataHelper = userDataHelper;
    }
    public boolean addUser(UserDTO user) {
        return true;
    }
    public void deleteUser(UserDTO user) {

    }
}
