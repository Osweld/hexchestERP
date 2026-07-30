package com.osweld.hexchest.identityaccess.domain.user;

import java.time.Instant;
import java.util.Objects;

import lombok.Getter;

@Getter
public class User {

    private final UserId userId;
    private PasswordHash passwordHash;
    private PersonName personName;
    private Email email;
    private Status status;
    private Role role;
    private Instant createdAt;

    private User(UserId userId, PasswordHash passwordHash, PersonName personName, Email email, Status status, Role role,
            Instant createdAt) {
        this.userId = Objects.requireNonNull(userId, "userId cannot be null");
        this.passwordHash = Objects.requireNonNull(passwordHash, "passwordHash cannot be null");
        this.personName = Objects.requireNonNull(personName, "personName cannot be null");
        this.email = Objects.requireNonNull(email, "email cannot be null");
        this.status = Objects.requireNonNull(status, "status cannot be null");
        this.role = Objects.requireNonNull(role, "role cannot be null");
        this.createdAt = Objects.requireNonNull(createdAt, "createdAt cannot be null");
    }

    public static User createInitialAdminUser(UserId userId, PasswordHash passwordHash, PersonName personName,
            Email email, Instant createdAt) {
        return new User(userId, passwordHash, personName, email, Status.ACTIVE, Role.ADMIN, createdAt);
    }

    public static User create(UserId userId, PasswordHash passwordHash, PersonName personName, Email email, Role role,
            Instant createdAt) {
        return new User(userId, passwordHash, personName, email, Status.PENDING, role, createdAt);
    }

}
