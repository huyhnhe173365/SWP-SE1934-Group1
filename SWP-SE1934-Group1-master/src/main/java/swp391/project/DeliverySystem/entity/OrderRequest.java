package swp391.project.DeliverySystem.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(name = "OrderRequests")
public class OrderRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customers customer;

    @Column(unique = true)
    private String trackingNumber;

    @ManyToOne
    @JoinColumn(name = "LabelID")
    private Label label;

    @ManyToOne
    @JoinColumn(name = "SurveyStaffID")
    private Staff surveyStaff;

    private LocalDate surveyDate;

    @ManyToOne
    @JoinColumn(name = "StorageID")
    private Storage storage;

    private String pickUpLocation;
    private String deliveryLocation;
    private String transport;
    private LocalDate pickUpDate;

    private LocalDateTime expectedDeliveryTime;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalAmount;

    private String status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
