package vn.khanhan.aniestore_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;

    @Column(name = "quantity_import")
    @Min(value = 0, message = "Số lượng nhập phai lớn hơn 0")
    private int quantity;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Products products;

    @Column(name = "total")
    private double total;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "update_at")
    private Date updateAt;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

}
