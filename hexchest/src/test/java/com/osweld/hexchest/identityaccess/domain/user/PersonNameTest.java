package com.osweld.hexchest.identityaccess.domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class PersonNameTest {

    @Test
    @DisplayName("Should create PersonName with valid first and last names")
    void testPersonNameCreation() {
      
        PersonName personName = new PersonName("John", "Doe");
        assertThat(personName.firstName()).isEqualTo("John");
        assertThat(personName.lastName()).isEqualTo("Doe");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when first name is null")
    void testFirstNameNull() {
        assertThatThrownBy(() -> new PersonName(null, "Doe"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("First name cannot be null or blank");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when last name is null")
    void testLastNameNull() {
        assertThatThrownBy(() -> new PersonName("John", null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Last name cannot be null or blank");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when first name is blank")
    void testFirstNameBlank() {
        assertThatThrownBy(() -> new PersonName("   ", "Doe"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("First name cannot be null or blank");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when last name is blank")
    void testLastNameBlank() {
        assertThatThrownBy(() -> new PersonName("John", "   "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Last name cannot be null or blank");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when first name is too long")
    void testFirstNameTooLong() {
        String longFirstName = "a".repeat(101);
        assertThatThrownBy(() -> new PersonName(longFirstName, "Doe"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("First name cannot be longer than 100 characters");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when last name is too long")
    void testLastNameTooLong() {
        String longLastName = "a".repeat(101);
        assertThatThrownBy(() -> new PersonName("John", longLastName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Last name cannot be longer than 100 characters");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when first name contains invalid characters")
    void testFirstNameInvalidCharacters() {
        assertThatThrownBy(() -> new PersonName("John123", "Doe"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("First name contains invalid characters");
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when last name contains invalid characters")
    void testLastNameInvalidCharacters() {
        assertThatThrownBy(() -> new PersonName("John", "Doe!"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("Last name contains invalid characters");
    }

    @Test
    @DisplayName("Should return full name correctly")
    void testFullName() {
        PersonName personName = new PersonName("John", "Doe");
        assertThat(personName.fullName()).isEqualTo("John Doe");
    }
}