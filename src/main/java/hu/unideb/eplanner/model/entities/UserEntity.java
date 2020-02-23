package hu.unideb.eplanner.model.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

class UserEntity {


    @Id
    @GeneratedValue
    Long id;
    @NotNull
    String name;
    @NotNull
    @Email
    String email;


    public UserEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity userEntity = (UserEntity) o;
        return Objects.equals(id, userEntity.id) &&
                Objects.equals(name, userEntity.name) &&
                Objects.equals(email, userEntity.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }


}
