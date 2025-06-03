package swp391.project.DeliverySystem.entity;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Issues")
public class Issues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IncidentCode")
    private String incidentCode;

    @ManyToOne
    @JoinColumn(name = "OrderID", nullable = false)
    private OrderRequests orderRequest;

    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customers customer;

    @Column(name = "IncidentDate")
    private LocalDate incidentDate;

    @Column(name = "Description")
    private String description;

    @Column(name = "Resolution")
    private String resolution;

    @Column(name = "Status")
    private String status;
}
