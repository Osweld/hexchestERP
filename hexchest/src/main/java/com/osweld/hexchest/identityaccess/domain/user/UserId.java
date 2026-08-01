package com.osweld.hexchest.identityaccess.domain.user;

import java.util.UUID;

public record UserId(UUID value) {

    public UserId {
        if (value == null) {
            throw new IllegalArgumentException("UserId cannot be null");
        }
    }

    public static UserId generate() {
        return new UserId(java.util.UUID.randomUUID());
    }

    @Override
    public String toString() {
        return value.toString();
    }


}
    