package com.osweld.hexchest.identityaccess.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class EmailTest {

    @Test
    @DisplayName("Should create Email when format is valid")
    void shouldCreateEmailWhenFormatIsValid() {
        Email email = new Email("user@example.com");

        assertThat(email.value()).isEqualTo("user@example.com");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when email is null")
    void shouldThrowWhenEmailIsNull() {
        assertThatThrownBy(() -> new Email(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Email cannot be null or blank");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when email is blank")
    void shouldThrowWhenEmailIsBlank() {
        assertThatThrownBy(() -> new Email("   "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Email cannot be null or blank");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when email format is invalid")
    void shouldThrowWhenEmailFormatIsInvalid() {
        assertThatThrownBy(() -> new Email("invalid-email"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Invalid email format");
    }
}
