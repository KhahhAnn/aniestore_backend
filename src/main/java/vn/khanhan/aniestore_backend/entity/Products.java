package vn.khanhan.aniestore_backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Products {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;

    @Column(name = "product_name", nullable = false)
    @NotNull(message = "Vui lòng nhập tên sản phẩm!")
    private String productName;

    @Column(name = "type_product")
    private String typeProduct;

    @Column(name = "color")
    private String color;

    @Column(name = "size")
    private String size;

    @Column(name = "purchase_price", nullable = false)
    private double purchasePrice;

    @Column(name = "origin_prices", nullable = false)
    private double originPrices;

    @Column(name = "sale_prices")
    private double salePrices;

   @Column(name = "quantity_of_stock")
   private int quantity;


    @OneToMany(
            mappedBy = "products",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Review> reviewList;

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Order> orderList;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    private Category category;

    @OneToOne(mappedBy = "products")
    private ImportInvoiceDetail importInvoiceDetail;
}
