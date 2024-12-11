package org.example.eetest04.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name="productEntity")
@Table(name="product_tbl")
public class Product extends Base {
    @Id
    @SequenceGenerator(name = "productSeq", sequenceName = "product_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "productSeq")
    private Long id;

    @Pattern(regexp = "^[a-zA-Z0-9]{2,50}$", message = "Invalid Product Name !!!")
    @Column(name = "product_name", length = 50)
    private String name;

    @Pattern(regexp = "^[a-zA-Z0-9]{2,500}$", message = "Invalid Description !!!!")
    @Column(name = "description", length = 500)
    private String description;
}
