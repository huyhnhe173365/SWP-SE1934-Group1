package project.swp391.DeliverySystem.dto.Auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.swp391.DeliverySystem.dto.CustomersDTO;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private CustomersDTO customersDTO;
    private String confirmedPassword;
    // getters/setters
}
