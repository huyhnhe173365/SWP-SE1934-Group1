package swp391.project.DeliverySystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CustomerVouchers", uniqueConstraints = @UniqueConstraint(columnNames = {"CustomerID", "VoucherID"}))
public class CustomerVoucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "VoucherID", nullable = false)
    private Vouchers vouchers;

    private Boolean isUsed = false;
    private LocalDateTime usedAt;
}
