package vn.khanhan.aniestore_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "review")
public class Review {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "content_rated")
    private String contentRated;

    @Column(name = "star", nullable = false)
    private double star;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    }, fetch = FetchType.LAZY)
    @Column(name = "user_id", nullable = false)
    private Users user;
}
