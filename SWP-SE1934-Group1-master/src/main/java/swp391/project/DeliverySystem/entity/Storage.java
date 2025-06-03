package swp391.project.DeliverySystem.entity;

import java.math.BigDecimal;

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
@Table(name = "Storages")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String storageName;
    private String address;
    private Integer capacity;

    @Column(precision = 10, scale = 2)
    private BigDecimal pricePerMonth;

    private String contactInfo;
    private String status;
}
