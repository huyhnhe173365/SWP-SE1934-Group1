package swp391.project.DeliverySystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "OrderTracking")
public class OrderTracking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "OrderRequestID", nullable = false)
    private OrderRequests orderRequest;

    private String status;
    private String location;
    private LocalDateTime updateTime;
}

