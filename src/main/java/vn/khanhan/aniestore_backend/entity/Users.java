package vn.khanhan.aniestore_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private UUID id;

    @Column(name = "user_name", nullable = false)
    @NotNull(message = "Vui lòng nhập userName!")
    private String userName;

    @Column(name = "email", nullable = false, unique = true)
    @Email(message = "Email không hợp lệ!")
    private String email;

    @Column(name = "password", nullable = false)
    @NotNull(message = "Vui lòng nhập password! ")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$",
            message = "Password phải chứa ít nhất 1 ký tự hoa, 1 số và từ 8 ký tự trở lên")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "is_active", nullable = false)
    private boolean isActive;

    @Column(name = "active_code", nullable = false)
    private String activeCode;

    @Lob
    @Column(name = "image", columnDefinition = "LONGTEXT")
    private String image;

    @Column(name = "phone_number", nullable = false)
    @NotNull(message = "Vui lòng nhập số điện thoại!")
    @Pattern(regexp = "^0[0-9]{8,9}$", message = "Số điện thoại không hợp lệ!")
    private String phoneNum;

    @Column(name = "address", nullable = false)
    @NotNull(message = "Vui lòng nhập địa chỉ giao hàng!")
    private String address;

    @Column(name = "gender")
    private String gender;

    @Column(name = "birthday")
    private Date birthday;

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,
    }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_role")

    )
    private List<Roles> rolesList;

    @OneToMany(
            mappedBy = "user",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Review> reviewList;

    @ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_discount",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "discount_id")
    )
    @JsonIgnore
    private List<Discount> discountList;

    @Column(name = "create_at")
    private java.util.Date createAt;

    @Column(name = "update_at")
    private java.util.Date updateAt;
}
