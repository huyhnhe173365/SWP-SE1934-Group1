package project.swp391.DeliverySystem.service;

import java.util.List;

import project.swp391.DeliverySystem.dto.CustomersDTO;

public interface CustomersService {
    CustomersDTO createCustomers(CustomersDTO customersDTO);

    CustomersDTO getCustomersById(Long CustomersId);

    List<CustomersDTO> getAllCustomers();

    CustomersDTO updateCustomers(Long CustomersId, CustomersDTO updatedCustomers);

    void deleteCustomers(Long CustomersId);

}
