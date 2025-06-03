package swp391.project.DeliverySystem.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import swp391.project.DeliverySystem.entity.Customers;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IssuesDTO {
    public long id;
    private String incidentCode;
    private Long orderID;
    private Customers customer;
    private LocalDate incidentDate;
    private String description;
    private String resolution;
    private String status;
}
