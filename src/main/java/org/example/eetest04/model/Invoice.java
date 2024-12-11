package org.example.eetest04.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@SuperBuilder

@Entity(name = "invoiceEntity")
@Table(name = "invoice_tbl")
public class Invoice extends Base {
    @Id
    @SequenceGenerator(name = "invoiceSeq", sequenceName = "invoice_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoiceSeq")
    private Long id;

    @Column(name = "serial")
    private String serial;

    private int totalAmount;
    private int discount;
    private int netPrice;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "date_time")
    private LocalDate dateTime;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<InvoiceItem> itemList;

    public void addItem(InvoiceItem item) {
        if (itemList == null) {
            itemList = new ArrayList<>();
        }
        itemList.add(item);
    }

    public int getTotalAmount() {
        itemList.forEach(item -> totalAmount += item.getAmount());
        return totalAmount;
    }
}
