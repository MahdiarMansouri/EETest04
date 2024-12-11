package org.example.eetest04.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

@Entity(name = "invoiceItemEntity")
@Table(name = "invoice_item_tbl")
public class InvoiceItem extends Base {
    @Id
    @SequenceGenerator(name = "invoiceItemSeq", sequenceName = "invoice_item_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoiceItemSeq")
    private Long id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    @Column(name = "amount")
    private int amount;

    @ManyToOne
    @JoinColumn(name="product_id", foreignKey = @ForeignKey(name = "fk_invoice_item_product"))
    private Product product;

    @ManyToOne
    @JoinColumn(name = "invoice_id", foreignKey = @ForeignKey(name = "fk_invoice_item_invoice"))
    private Invoice invoice;

    public int getAmount() {
        amount = quantity * price;
        return amount;
    }


}
