package swp391.project.DelierySystem.service;

import swp391.project.DelierySystem.dto.CustomersDTO;
import java.util.List;

public interface CustomersService {
    CustomersDTO createCustomers(CustomersDTO customersdto);

    CustomersDTO getCustomersById(Long CustomersId);

    List<CustomersDTO> getAllCustomers();

    CustomersDTO updateCustomers(Long CustomersId, CustomersDTO updatedCustomers);

    void deleteCustomers(Long CustomersId);
}
