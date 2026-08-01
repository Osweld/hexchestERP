package com.osweld.hexchest.identityaccess.domain.user;

import java.time.Instant;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class UserTest {

    private final UserId userId = new UserId(UUID.fromString("f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454"));
    private final PasswordHash passwordHash = new PasswordHash(
            "hashedPasswordhashedPasswordhashedPasswordhashedPasswordhashedPassword");
    private final PersonName personName = new PersonName("John", "Doe");
    private final Email email = new Email("john.doe@example.com");
    private final Role roleAdmin = Role.ADMIN;
    private final Role roleUser = Role.USER;
    private final java.time.Instant createdAt = Instant.from(java.time.ZonedDateTime.parse("2024-06-01T12:00:00Z"));

    @Test
    @DisplayName("Should create initial admin user with correct status and role")
    void shouldCreateInitialAdminUserWithCorrectStatusAndRole() {

        User user = User.createInitialAdminUser(userId, passwordHash, personName, email, createdAt);

        assertThat(user.getUserId()).isEqualTo(userId);
        assertThat(user.getPasswordHash()).isEqualTo(passwordHash);
        assertThat(user.getPersonName()).isEqualTo(personName);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getStatus()).isEqualTo(Status.ACTIVE);
        assertThat(user.getRole()).isEqualTo(roleAdmin);
    }

    @Test
    @DisplayName("Should create user with correct status and role")
    void shouldCreateUserWithCorrectStatusAndRole() {
        User user = User.create(userId, passwordHash, personName, email, roleUser, createdAt);
        assertThat(user.getUserId()).isEqualTo(userId);
        assertThat(user.getPasswordHash()).isEqualTo(passwordHash);
        assertThat(user.getPersonName()).isEqualTo(personName);
        assertThat(user.getEmail()).isEqualTo(email);
        assertThat(user.getStatus()).isEqualTo(Status.PENDING);
        assertThat(user.getRole()).isEqualTo(roleUser);

    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when userId is null")
    void shouldThrowWhenUserIdIsNull() {
        assertThatThrownBy(() -> User.create(null, passwordHash, personName, email, Role.USER, createdAt))
                .isInstanceOf(NullPointerException.class).hasMessageContaining("userId cannot be null");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when passwordHash is null")
    void shouldThrowWhenPasswordHashIsNull() {
        assertThatThrownBy(() -> User.create(userId, null, personName, email, Role.USER, createdAt))
                .isInstanceOf(NullPointerException.class).hasMessageContaining("passwordHash cannot be null");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when personName is null")
    void shouldThrowWhenPersonNameIsNull() {
        assertThatThrownBy(() -> User.create(userId, passwordHash, null, email, Role.USER, createdAt))
                .isInstanceOf(NullPointerException.class).hasMessageContaining("personName cannot be null");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when email is null")
    void shouldThrowWhenEmailIsNull() {
        assertThatThrownBy(() -> User.create(userId, passwordHash, personName, null, Role.USER, createdAt))
                .isInstanceOf(NullPointerException.class).hasMessageContaining("email cannot be null");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when createdAt is null")
    void shouldThrowWhenCreatedAtIsNull() {
        assertThatThrownBy(() -> User.create(userId, passwordHash, personName, email, Role.USER, null))
                .isInstanceOf(NullPointerException.class).hasMessageContaining("createdAt cannot be null");
    }



}