package com.example.demo.MockAdministration;

import com.example.demo.DataHelpers.UserDataHelper;
import com.example.demo.MockDataHelpers.MockUserDataHelper;
import com.example.demo.Normal.User;

public class MockUserAdministration {
    private MockUserDataHelper mockUserDataHelper;
    public MockUserAdministration(MockUserDataHelper mockUserDataHelper) {
        this.mockUserDataHelper = mockUserDataHelper;
    }
    public boolean addUser(User user) {
        return true;
    }
    public void deleteUser(User user) {

    }
}
