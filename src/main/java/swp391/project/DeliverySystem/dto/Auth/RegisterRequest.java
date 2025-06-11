package swp391.project.DeliverySystem.dto.Auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import swp391.project.DeliverySystem.dto.CustomersDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private CustomersDTO customersDTO;
    private String confirmedPassword;
    // getters/setters
}
