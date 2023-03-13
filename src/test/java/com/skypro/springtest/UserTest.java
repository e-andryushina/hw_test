package com.skypro.springtest;

import com.skypro.springtest.exception.InvalidDataException;
import com.skypro.springtest.model.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class UserTest {

    private User user;

    @Test
    public void createUserTest() {
        user = new User("user1", "user1@gmail.com");
        assertThat(user.getLogin()).isEqualTo("user1");
        assertThat(user.geteMail()).isEqualTo("user1@gmail.com");
    }

    @Test
    public void whenLoginOrEmailIsAbsentEnteredDefaultValue() {
        user = new User(null, null);
        assertThat(user.getLogin()).isEqualTo("Unknown");
        assertThat(user.geteMail()).isEqualTo("Unknown");
        user = new User("", "");
        assertThat(user.getLogin()).isEqualTo("Unknown");
        assertThat(user.geteMail()).isEqualTo("Unknown");
        user = new User("  ", "  ");
        assertThat(user.getLogin()).isEqualTo("Unknown");
        assertThat(user.geteMail()).isEqualTo("Unknown");
    }

    @Test
    public void whenEnteredIrrelevantLoginOrEmailThrownException() {
        assertThrows(InvalidDataException.class,() -> user = new User ("user1", "user1gmailcom"));
        assertThrows(InvalidDataException.class,() -> user = new User ("user1", "user1"));
    }
}

