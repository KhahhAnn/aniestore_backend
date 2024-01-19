package vn.khanhan.aniestore_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "import_invoice")
public class ImportInvoice  {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;

    @Column(name = "invoice_name")
    private String invoiceName;

    @Column(name = "import_date", nullable = false)
    @NotNull(message = "Vui lòng nhập ngày nhập hàng!")
    private Date importDate;

    @Column(name = "total_price", nullable = false)
    @Min(value = 1, message = "Hóa đơn nhập phải lớn hơn 0!")
    private double totalPrice;

    @ManyToMany(cascade = {
            CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "import_products",
            joinColumns = @JoinColumn(name = "invoice_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Products> productsList;
}
