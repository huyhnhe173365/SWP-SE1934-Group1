package swp391.project.DeliverySystem.service;

import java.util.List;
import java.util.Map;

import swp391.project.DeliverySystem.dto.CustomersDTO;
import swp391.project.DeliverySystem.dto.LoginDTO;

public interface CustomersService {
    CustomersDTO createCustomers(CustomersDTO customersDTO);

    Map<String, Object> login(LoginDTO loginDTO);

    CustomersDTO getCustomersById(Long CustomersId);

    List<CustomersDTO> getAllCustomers();

    CustomersDTO updateCustomers(Long CustomersId, CustomersDTO updatedCustomers);

    void deleteCustomers(Long CustomersId);
    
}
