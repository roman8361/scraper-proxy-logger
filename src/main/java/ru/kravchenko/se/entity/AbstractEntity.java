package ru.kravchenko.se.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
public abstract class AbstractEntity {

    String id = UUID.randomUUID().toString();

}
