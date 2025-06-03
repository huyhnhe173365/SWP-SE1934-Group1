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

    @Column(name = "Rating", nullable = false)
    private Integer rating;

    @Column(name = "Comment", length = 500)
    private String comment;

    @Column(name = "FeedbackDate", nullable = false)
    private LocalDateTime feedbackDate;
}
