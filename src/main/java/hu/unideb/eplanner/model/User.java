package hu.unideb.eplanner.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity


public @Data class User
{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;
        @NotNull
        String name;
}
