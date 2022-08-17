package com.configuration;

import com.configuration.model.CustomUser;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

public class MockUserSupplier {
    public final static MockUserSupplier supplier = new MockUserSupplier();

    private MockUserSupplier() {
    }

    private Integer userCount = 0;
    private String[] usernames = {"user", "admin", "DariusNicolae"};
    private String[][] roles = {{"User"}, {"Admin"}, {"User","Admin"}};
    private String password = "1234";
    Supplier<CustomUser> userSupplier = () -> {
        CustomUser customUser = new CustomUser();
        if (userCount < 3) {
            String username = usernames[userCount];
            String[] userRoles = roles[userCount];
            String userPassword = password;
            customUser.setUsername(username);
            customUser.setRoles(Arrays.asList(userRoles));
            customUser.setPassword(userPassword);
            userCount++;
        } else {
            customUser.setUsername("Duplicate" + Math.abs(new Random().nextLong()));
            customUser.setPassword(password);
            customUser.setRoles(Arrays.asList("User"));
        }
        return customUser;
    };
}
