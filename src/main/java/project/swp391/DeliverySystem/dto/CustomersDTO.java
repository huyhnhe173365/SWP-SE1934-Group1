package project.swp391.DeliverySystem.dto;

import project.swp391.DeliverySystem.entity.Roles;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomersDTO {
    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String citizenId;
    private LocalDate dateOfBirth;
    private String customerType;
    private String passwordHash;
    private Boolean isEmailConfirmed;
    private Boolean isDeleted;
    private Roles role;  // ← Đổi từ Integer thành Long
}
