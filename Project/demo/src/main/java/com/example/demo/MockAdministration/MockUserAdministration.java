package com.example.demo.MockAdministration;

import com.example.demo.DataHelpers.UserDataHelper;
import com.example.demo.MockDataHelpers.MockUserDataHelper;
import com.example.demo.dto.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MockUserAdministration {
    private MockUserDataHelper mockUserDataHelper;
    public MockUserAdministration(MockUserDataHelper mockUserDataHelper) {
        this.mockUserDataHelper = mockUserDataHelper;
    }
    public boolean addUser(UserDTO user) {
        return true;
    }
    public void deleteUser(UserDTO user) {

    }
}
