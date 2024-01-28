package vn.khanhan.aniestore_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "invoice_detail")
public class ImportInvoiceDetail {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;

    @Column(name = "quantity_import")
    @Min(value = 0, message = "Số lượng nhập phai lớn hơn 0")
    private int quantityImport;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Products products;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    @JoinColumn(name = "import_invoice_id")
    private ImportInvoice importInvoice;

}
