package hu.unideb.eplanner.model.entities.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@ToString
@EqualsAndHashCode
public class AbstractEntity {

    private final @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    Long id;
    @LastModifiedDate
    @JsonIgnore
    LocalDateTime lastModified;
    private @Version
    @JsonIgnore
    Long version;

    protected AbstractEntity() {
        this.id = null;
    }
}
