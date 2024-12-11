package org.example.eetest04.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "customerEntity")
@Table(name = "customer_tbl")
public class Customer extends Base {
    @Id
    @SequenceGenerator(name = "customerSeq", sequenceName = "customer_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customerSeq")
    private Long id;

    @Pattern(regexp = "^[a-zA-Z]{3,30}$")
    @Column(name = "name", length = 30)
    private String name;

    @Pattern(regexp = "^[a-zA-Z]{3,30}$")
    @Column(name = "family", length = 30)
    private String family;

    @Pattern(regexp = "^(09|\\+98)[0-9]{9}$")
    @Column(name = "phone", length = 13)
    private String phone;

    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@(gmail\\.com|yahoo\\.com)$")
    @Column(name= "email", length = 100)
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Column(name = "invoices")
    private List<Invoice> invoices;
}
