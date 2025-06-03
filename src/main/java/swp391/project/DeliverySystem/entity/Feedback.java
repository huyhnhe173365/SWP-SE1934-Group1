package swp391.project.DeliverySystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customers customer;

    @ManyToOne
    @JoinColumn(name = "OrderRequestID", nullable = false)
    private OrderRequests orderRequest;

    private Integer rating;
    private String comment;
    private LocalDateTime feedbackDate;
}
