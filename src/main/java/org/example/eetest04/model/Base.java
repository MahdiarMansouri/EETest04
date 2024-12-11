package org.example.eetest04.model;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.*;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@MappedSuperclass
public class Base {
    @Version
    @JsonbTransient
    private boolean versionId;

    @JsonbTransient
    private boolean deleted;

    @JsonbTransient
    private boolean editing;

    @JsonbTransient
    private boolean locked;
}
