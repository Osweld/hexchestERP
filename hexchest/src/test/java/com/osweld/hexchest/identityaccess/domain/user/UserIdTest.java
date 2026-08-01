package com.osweld.hexchest.identityaccess.domain.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserIdTest {

    @Test
    @DisplayName("Should create UserId when value is valid")
    void shouldCreateUserIdWhenValueIsValid() {
        UserId userId = new UserId(UUID.randomUUID());
        assertThat(userId).isNotNull();
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException when value is null")
    void shouldThrowIllegalArgumentExceptionWhenValueIsNull() {
       assertThatThrownBy(() -> new UserId(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("UserId cannot be null");
    }

    
    @Test
    @DisplayName("Should return the correct value when UserId is created")
    void shouldReturnTheCorrectValueWhenUserIdIsCreated() {
        UUID expectedValue = UUID.randomUUID();
        UserId userId = new UserId(expectedValue);
        assertThat(userId.value()).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("Should return true when two UserIds with the same value are compared")
    void shouldReturnTrueWhenTwoUserIdsWithTheSameValueAreCompared() {
        UUID value = UUID.randomUUID();
        UserId userId1 = new UserId(value);
        UserId userId2 = new UserId(value);
        assertThat(userId1.equals(userId2)).isNotEqualTo(false);
    }

    @Test
    @DisplayName("Should return false when two UserIds with different values are compared")
    void shouldReturnFalseWhenTwoUserIdsWithDifferentValuesAreCompared() {
        UserId userId1 = new UserId(UUID.randomUUID());
        UserId userId2 = new UserId(UUID.randomUUID());
        assertThat(userId1.equals(userId2)).isNotEqualTo(true);
    }

    @Test
    @DisplayName("Should return false when comparing UserId with null")
    void shouldReturnFalseWhenComparingUserIdWithNull() {
        UserId userId = new UserId(UUID.randomUUID());
        assertThat(userId.equals(null)).isNotEqualTo(true);
    }

    @Test
    @DisplayName("Should generate method retyurn a valid UserId")
    void shouldGenerateMethodRetyurnAValidUserId() {
        UserId userId = UserId.generate();
        assertThat(userId).isNotNull();
        assertThat(userId.value()).isNotNull();
    }

    @Test
    @DisplayName("Should return the correct string representation of UserId")
    void shouldReturnTheCorrectStringRepresentationOfUserId() {
        UUID expectedValue = UUID.randomUUID();
        UserId userId = new UserId(expectedValue);
        assertThat(userId.toString()).hasToString(expectedValue.toString());
    }

    @Test
    @DisplayName("Should return the correct hash code of UserId")
    void shouldReturnTheCorrectHashCodeOfUserId() {
        UUID value = UUID.randomUUID();
        UserId userId = new UserId(value);
        assertThat(userId.hashCode()).hasSameHashCodeAs(value.hashCode());
    }

}