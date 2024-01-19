package vn.khanhan.aniestore_backend.entity;

import jakarta.persistence.*;
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
@Table(name = "category")
public class Category {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;

    @Column(name = "category_name", nullable = false)
    @NotNull(message = "Vui lòng nhập tên loại sản phẩm!")
    private String categoryName;

    @OneToMany(
            mappedBy = "category",
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            },
            fetch = FetchType.LAZY
    )
    private List<Products> productsList;
}
