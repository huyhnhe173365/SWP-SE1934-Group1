package project.swp391.DeliverySystem.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import project.swp391.DeliverySystem.dto.CustomersDTO;
import project.swp391.DeliverySystem.entity.Customers;
import project.swp391.DeliverySystem.entity.Roles;
import project.swp391.DeliverySystem.exception.ResourceNotFoundException;
import project.swp391.DeliverySystem.mapper.CustomerMapper;
import project.swp391.DeliverySystem.repository.CustomerRepository;
import project.swp391.DeliverySystem.repository.RolesRepository;
import project.swp391.DeliverySystem.service.CustomersService;

import java.util.stream.Collectors;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements CustomersService{

    private CustomerRepository customerRepository;
    private RolesRepository rolesRepository;
    @Override
    public CustomersDTO createCustomers(CustomersDTO customersDTO) {
        Roles defaultRole = (Roles) rolesRepository.findByRoleName("CUSTOMER")
                .orElseThrow(() -> new RuntimeException("Default role CUSTOMER not found"));
        customersDTO.setId(null); // Ensure ID is null for new entity
        Customers customers = CustomerMapper.mapToCustomers(customersDTO, defaultRole);
        Customers savedCustomers = customerRepository.save(customers);
        return CustomerMapper.mapToCustomersDTO(savedCustomers); 
    }
    @Override
    public CustomersDTO getCustomersById(Long CustomersId) {
        Customers customers = customerRepository.findById(CustomersId)
            .orElseThrow(() -> new ResourceNotFoundException("Customers not found with id: " + CustomersId));
        return CustomerMapper.mapToCustomersDTO(customers);        
    }
    @Override
    public List<CustomersDTO> getAllCustomers() {
        List<Customers> customers = customerRepository.findAll();
        return customers.stream()
            .map(customer -> CustomerMapper.mapToCustomersDTO(customer))
            .collect(Collectors.toList());
    }
    @Override
    public CustomersDTO updateCustomers(Long CustomersId, CustomersDTO updatedCustomers) {
        Customers customers = customerRepository.findById(CustomersId)
            .orElseThrow(() -> new ResourceNotFoundException("Customers not found with id: " + CustomersId));
            customers.setFullName(updatedCustomers.getFullName());
            customers.setEmail(updatedCustomers.getEmail());
            customers.setPhoneNumber(updatedCustomers.getPhoneNumber());
            customers.setCitizenId(updatedCustomers.getCitizenId());
            customers.setDateOfBirth(updatedCustomers.getDateOfBirth());
            customers.setCustomerType(updatedCustomers.getCustomerType());
            customers.setPasswordHash(updatedCustomers.getPasswordHash());
            customers.setIsEmailConfirmed(updatedCustomers.getIsEmailConfirmed());
            customers.setIsDeleted(updatedCustomers.getIsDeleted());
            Roles role = rolesRepository.findById(updatedCustomers.getRole().getId())
            .orElseThrow(() -> new ResourceNotFoundException("Role not found with id: " + updatedCustomers.getRole().getId())); 
            customers.setRole(role);
            Customers updatedCustomersObj = customerRepository.save(customers);
        return CustomerMapper.mapToCustomersDTO(updatedCustomersObj);
    }
    @Override
    public void deleteCustomers(Long CustomersId) {
        Customers customers = customerRepository.findById(CustomersId)
            .orElseThrow(() -> new ResourceNotFoundException("Customers not found with id: " + CustomersId));
        customers.setIsDeleted(true);
        customerRepository.deleteById(CustomersId);
    }
}
