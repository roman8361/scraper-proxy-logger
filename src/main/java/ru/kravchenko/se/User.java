package ru.kravchenko.se;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.UUID;

@Getter
@Setter
@Entity
public class User {

    @Getter
    private String id = UUID.randomUUID().toString();

    private String name;

    private String surname;

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

}
