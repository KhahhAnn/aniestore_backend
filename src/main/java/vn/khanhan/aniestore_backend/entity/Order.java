package vn.khanhan.aniestore_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
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
@Table(name = "order_table")
public class Order {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "total", nullable = false)
    @Min(value = 1, message = "Tổng giá đơn hàng phải lớn hơn 0")
    private double total;

    @Column(name = "order_date", nullable = false)
    private Date orderDate;

    @Column(name = "status", nullable = false)
    private boolean status;

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Products> productsList;
}
