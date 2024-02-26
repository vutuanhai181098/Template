package org.example.ecommerce.repository;
import org.assertj.core.api.Assertions;
import org.example.ecommerce.entity.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeAll
    public void init() {
        User user1 = User.builder()
                .username("Tuấn")
                .email("admin@gmail.com")
                .password("123")
                .role(User.Role.ADMIN)
                .enabled(true)
                .build();
        User user2 = User.builder()
                .username("Hải")
                .email("user@gmail.com")
                .password("123")
                .role(User.Role.USER)
                .enabled(true)
                .build();
        userRepository.saveAll(List.of(user1, user2));
    }

    @Test
    void UserRepository_SaveAll_ReturnSavedUser(){
        User user = User.builder()
                .username("Tuấn Hải")
                .email("vutuanhai@gmail.com")
                .password("123")
                .role(User.Role.USER)
                .enabled(true)
                .build();

        User savedUser = userRepository.save(user);

        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getUserId()).isGreaterThan(0);
        Assertions.assertThat(savedUser.getUsername()).isEqualTo("Tuấn Hải");
    }

    @Test
    void UserRepository_GetAll_ReturnMoreThanOneUser() {
        List<User> userList = userRepository.findAll();

        Assertions.assertThat(userList).isNotNull();
        Assertions.assertThat(userList.size()).isEqualTo(2);
    }

    @Test
    void UserRepository_FindById_ReturnUserNotNull(){
        User user = userRepository.findById(1L).get();

        Assertions.assertThat(user).isNotNull();
        Assertions.assertThat(user.getUsername()).isEqualTo("Tuấn");
    }

    @Test
    void UserRepository_UpdateUser_ReturnUser() {
        User user = userRepository.findById(1L).get();
        String oldName = user.getUsername();
        user.setUsername("Tuấn Hải");
        user.setPhone("0986868686");

        User updatedUser = userRepository.save(user);

        Assertions.assertThat(updatedUser.getUsername()).isNotEqualTo(oldName);
        Assertions.assertThat(updatedUser.getPhone()).isNotNull();
    }

    @Test
    void UserRepository_DeleteUserById_ReturnUserIsEmpty() {
        userRepository.deleteById(1L);

        Optional<User> user = userRepository.findById(1L);

        Assertions.assertThat(user).isEmpty();
    }
}
