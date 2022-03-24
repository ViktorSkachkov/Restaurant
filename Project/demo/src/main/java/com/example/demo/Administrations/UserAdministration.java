package com.example.demo.Administrations;
import com.example.demo.DataHelpers.UserDataHelper;
import com.example.demo.Normal.*;

public class UserAdministration {
    private UserDataHelper userDataHelper;
    public UserAdministration(UserDataHelper userDataHelper) {
        this.userDataHelper = userDataHelper;
    }
    public boolean addUser(User user) {
        return true;
    }
    public void deleteUser(User user) {

    }
}
