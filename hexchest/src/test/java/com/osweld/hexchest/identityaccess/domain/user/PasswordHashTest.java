package com.osweld.hexchest.identityaccess.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PasswordHashTest {

    @Test
    @DisplayName("Should create PasswordHash when valid")
    void shouldCreatePasswordHashWhenValid() {
        PasswordHash passwordHash = new PasswordHash("a".repeat(60));
        assertThat(passwordHash.value()).isEqualTo("a".repeat(60));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when password hash is null")
    void shouldThrowWhenPasswordHashIsNull() {
        assertThatThrownBy(() -> new PasswordHash(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Password hash cannot be null or blank");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when password hash is blank")
    void shouldThrowWhenPasswordHashIsBlank() {
        assertThatThrownBy(() -> new PasswordHash("   "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Password hash cannot be null or blank");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when password hash is too short")
    void shouldThrowWhenPasswordHashIsTooShort() {
        assertThatThrownBy(() -> new PasswordHash("short"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Password hash must be at least 60 characters long");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when password hash is too long")
    void shouldThrowWhenPasswordHashIsTooLong() {
        String longHash = "a".repeat(256);
        assertThatThrownBy(() -> new PasswordHash(longHash))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Password hash cannot be longer than 255 characters");
    }

    @Test
    @DisplayName("Should return the correct string representation of PasswordHash")
    void shouldReturnCorrectStringRepresentation() {
        PasswordHash passwordHash = new PasswordHash("a".repeat(60));
        assertThat(passwordHash.toString()).hasToString("a".repeat(60));
    }

    @Test
    @DisplayName("Should verify equality of PasswordHash values")
    void shouldPasswordEquality() {
        PasswordHash hash1 = new PasswordHash("a".repeat(60));
        PasswordHash hash2 = new PasswordHash("a".repeat(60));
       
        assertThat(hash1).isEqualTo(hash2);
    }

    @Test
    @DisplayName("Should verify inequality of different PasswordHash values")
    void shouldPasswordInequality() {
        PasswordHash hash1 = new PasswordHash("a".repeat(60));
        PasswordHash hash2 = new PasswordHash("b".repeat(60));

        assertThat(hash1).isNotEqualTo(hash2);
    }

    @Test
    @DisplayName("Should verify hash code consistency of PasswordHash values")
    void shouldPasswordHashCodeConsistency() {
        PasswordHash hash1 = new PasswordHash("a".repeat(60));
        PasswordHash hash2 = new PasswordHash("a".repeat(60));
        assertThat(hash1.hashCode()).hasSameHashCodeAs(hash2.hashCode());
    }

}
