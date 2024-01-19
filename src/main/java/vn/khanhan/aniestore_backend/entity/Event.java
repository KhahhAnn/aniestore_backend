package vn.khanhan.aniestore_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event")
public class Event {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @Column(name = "img", columnDefinition = "LONGTEXT")
    @Lob
    private String image;

    @Column(name = "link", columnDefinition = "LONGTEXT")
    private String link;
}
