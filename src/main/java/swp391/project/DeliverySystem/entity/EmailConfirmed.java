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
@Table(name = "EmailConfirmed")
public class EmailConfirmed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customers customer;

    @Column(nullable = false)
    private String token;

    @Column(name = "ExpirationDate", nullable = false)
    private LocalDateTime expirationDate;
}
