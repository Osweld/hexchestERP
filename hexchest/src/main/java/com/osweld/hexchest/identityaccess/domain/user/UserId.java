package com.osweld.hexchest.identityaccess.domain.user;

public record UserId(String value) {

    public UserId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("UserId cannot be null or blank");
        }
    }

    public static UserId generate() {
        return new UserId(java.util.UUID.randomUUID().toString());
    }

    @Override
    public String toString() {
        return value;
    }


}
    