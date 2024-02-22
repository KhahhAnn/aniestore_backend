package vn.khanhan.aniestore_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "image_product")
public class ImagesProduct {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "image_name")
    private String imgName;

    @Column(name = "image_data", columnDefinition = "LONGTEXT")
    @Lob
    private String imgData;

    @Column(name = "create_at")
    private Date createAt;

    @Column(name = "update_at")
    private Date updateAt;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,
    }, fetch = FetchType.EAGER)
    @JoinColumn(name = "products_id")
    private Products product;
}
