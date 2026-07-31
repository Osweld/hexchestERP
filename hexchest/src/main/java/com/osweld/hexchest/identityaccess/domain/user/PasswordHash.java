package com.osweld.hexchest.identityaccess.domain.user;

public record PasswordHash(String value) {

    private static final int MIN_HASH_LENGTH = 60; 
    private static final int MAX_HASH_LENGTH = 255; 

    public PasswordHash {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Password hash cannot be null or blank");
        }

        if (value.length() < MIN_HASH_LENGTH) {
            throw new IllegalArgumentException("Password hash must be at least " + MIN_HASH_LENGTH + " characters long");
        }

        if (value.length() > MAX_HASH_LENGTH) {
            throw new IllegalArgumentException("Password hash cannot be longer than " + MAX_HASH_LENGTH + " characters");
        }
    }

    @Override
    public String toString() {
        return value;
    }

}
