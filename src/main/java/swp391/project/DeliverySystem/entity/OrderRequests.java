package swp391.project.DeliverySystem.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
public class OrderRequests {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    // Khóa ngoại CustomerID
    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customers customer;

    @Column(name = "TrackingNumber", unique = true, length = 100)
    private String trackingNumber;

    @Column(name = "LabelID")
    private Long labelId; 
    // Nếu muốn mapping sang Entity Labels, thay Long thành Labels và dùng @ManyToOne tương tự.

    @Column(name = "SurveyStaffID")
    private Long surveyStaffId;
    // Nếu muốn mapping sang Entity Staffs, thay Long bằng Staffs và dùng @ManyToOne

    @Column(name = "SurveyDate")
    private LocalDate surveyDate; // DATE

    @Column(name = "StorageID")
    private Long storageId; 
    // Nếu muốn mapping sang Entity Storages, thay Long thành Storages

    @Column(name = "PickUpLocation", length = 250)
    private String pickUpLocation;

    @Column(name = "DeliveryLocation", length = 250)
    private String deliveryLocation;

    @Column(name = "Transport", length = 100)
    private String transport;

    @Column(name = "PickUpDate")
    private LocalDate pickUpDate; // DATE

    @Column(name = "ExpectedDeliveryTime")
    private LocalDateTime expectedDeliveryTime; // DATETIME

    @Column(name = "TotalAmount", precision = 10, scale = 2)
    private BigDecimal totalAmount; // DECIMAL(10,2)

    @Column(name = "Status", nullable = false, length = 100)
    private String status;

    @Column(name = "CreatedAt", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt", columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;
}