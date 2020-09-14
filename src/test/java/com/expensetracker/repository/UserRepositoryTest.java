package com.expensetracker.repository;

import com.expensetracker.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

    Logger log = Logger.getLogger(getClass().getName());

    @Autowired
    UserRepository userRepository;

    User testUser;

    @BeforeEach
    void setUp() {

        testUser = userRepository.findById((long) 1).orElse(null);
        assertThat(testUser).isNotNull();
        log.info("Test to retrieve User data by Id from database -> "+ testUser);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createUserObject_ThenSaveToDatabaseTest() {

        User user = new User();
        user.setEmail("netlincteam@gmail.com");
        user.setName("Netlinc Technologies");

        log.info("Created User Object -> "+ user);
        assertThat(user.getId()).isNull();

        //Save User object to database
        user = userRepository.save(user);

        log.info("After saving User object to database -> "+ user);
        assertThat(user.getId()).isNotNull();

        Collection<User> getAllUser = userRepository.findAll();
        assertThat(getAllUser.size()).isEqualTo(4);

        log.info("After getting all Users in database -> "+ getAllUser);

    }

    @Test
    void findAllUsersInDatabaseTest() {

        Collection<User> getAllUser = userRepository.findAll();
        assertThat(getAllUser).isNotNull();
        assertThat(getAllUser.size()).isEqualTo(4);

        log.info("All Users in database -> "+ getAllUser);

    }

    @Test
    void findAUserByIdInDatabaseTest() {

        Collection<User> getAllUser = userRepository.findAll();
        assertThat(getAllUser).isNotNull();
        assertThat(getAllUser.size()).isEqualTo(4);

        log.info("After checking database for Users -> "+ getAllUser);

        testUser = userRepository.findById((long) 2).orElse(null);
        assertThat(testUser).isNotNull();

        log.info("After getting User by Id in database  ->"+ testUser);

    }

    @Test
    void updateUserInDatabaseTest() {

        testUser = userRepository.findById((long) 4).orElse(null);
        assertThat(testUser).isNotNull();

        assertThat(testUser.getName()).isEqualTo("Netlinc Technologies");
        testUser.setName("Netlinc");

        testUser = userRepository.save(testUser);
        assertThat(testUser.getName()).isEqualTo("Netlinc");

        log.info("After updating name of User object ->"+ testUser);

        Collection<User> getAllUser = userRepository.findAll();
        assertThat(getAllUser).isNotNull();
        assertThat(getAllUser.size()).isEqualTo(4);

        log.info("After checking database for Users -> "+ getAllUser);

    }

    @Test
    void deleteUserInDatabaseTest() {

        Collection<User> getAllUser = userRepository.findAll();
        assertThat(getAllUser).isNotNull();
        assertThat(getAllUser.size()).isEqualTo(4);

        testUser = userRepository.findById((long) 4).orElse(null);
        assertThat(testUser).isNotNull();
        log.info("After getting User by Id in database  ->"+ testUser);

        userRepository.deleteById((long) 4);

        User deleteUser = userRepository.findById((long) 4).orElse(null);
        assertThat(deleteUser).isNull();

        getAllUser = userRepository.findAll();
        assertThat(getAllUser).isNotNull();
        assertThat(getAllUser.size()).isEqualTo(3);

        log.info("After deleting User object from database ->"+ getAllUser);

    }
}