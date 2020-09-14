package com.expensetracker.service.user;

import com.expensetracker.model.User;
import com.expensetracker.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    User testUser;

    @BeforeEach
    void setUp() {

        userService = new UserServiceImpl();
        testUser = new User();
        MockitoAnnotations.initMocks(this);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {

        when(userService.save(testUser)).thenReturn(testUser);
        userService.save(testUser);

        verify(userRepository, times(1)).save(testUser);

    }

    @Test
    void findById() {

        when(userService.findById((long) 1)).thenReturn(Optional.of(testUser));
        userService.findById(testUser.getId());

        verify(userRepository, times(1)).findById(testUser.getId());

    }

    @Test
    void update() {

        when(userService.update(testUser)).thenReturn(testUser);
        userService.update(testUser);

        verify(userRepository, times(1)).save(testUser);

    }

    @Test
    void deleteById() {

        doNothing().when(userRepository).delete(testUser);
        userService.deleteById(testUser.getId());

        verify(userRepository, times(1)).deleteById(testUser.getId());

    }

    @Test
    void findAll() {

        Collection<User> users = new ArrayList<>();
        when(userService.findAll()).thenReturn(users);
        userService.findAll();

        verify(userRepository, times(1)).findAll();

    }
}