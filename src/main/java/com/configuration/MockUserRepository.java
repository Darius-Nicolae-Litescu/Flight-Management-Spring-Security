package com.configuration;

import com.configuration.model.CustomUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MockUserRepository {
    public static final MockUserRepository userRepository = new MockUserRepository();
    private final MockUserSupplier supplier = MockUserSupplier.supplier;
    private List<CustomUser> customUserList;
    private MockUserRepository(){
        customUserList = new ArrayList<>();
        initializeUsers();
    }

    private void initializeUsers(){
        Arrays.stream(new int[1000]).forEach(number -> addUser(supplier.userSupplier.get()));
    }

    public void addUser(CustomUser customUser){
        this.customUserList.add(customUser);
    }

    public UserDetails getUserByUsername(String username){
        Optional<UserDetails> optionalUser = this.customUserList.stream().filter(customUser -> customUser.getUsername().equals(username))
                .map(user->(UserDetails)user).findAny();
        return optionalUser.orElse(null);
    }

    public List<CustomUser> getAll(){
        return this.customUserList;
    }
}
