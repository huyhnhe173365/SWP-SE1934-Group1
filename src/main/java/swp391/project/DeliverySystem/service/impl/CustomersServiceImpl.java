package swp391.project.DeliverySystem.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import lombok.AllArgsConstructor;
import swp391.project.DeliverySystem.dto.CustomersDTO;
import swp391.project.DeliverySystem.dto.LoginDTO;
import swp391.project.DeliverySystem.entity.Customers;
import swp391.project.DeliverySystem.entity.Roles;
import swp391.project.DeliverySystem.exception.ResourceNotFoundException;
import swp391.project.DeliverySystem.mapper.CustomerMapper;
import swp391.project.DeliverySystem.repository.CustomerRepository;
import swp391.project.DeliverySystem.repository.RolesRepository;
import swp391.project.DeliverySystem.service.CustomersService;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements CustomersService {

    private CustomerRepository customerRepository;
    private RolesRepository rolesRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Map<String, Object> login(LoginDTO loginDTO) {
        Customers customer = customerRepository.findByEmail(loginDTO.getEmail())
            .orElseThrow(() -> new ResourceNotFoundException("Invalid email or password"));

        if (!passwordEncoder.matches(loginDTO.getPassword(), customer.getPasswordHash())) {
            throw new ResourceNotFoundException("Invalid email or password");
        }

        Map<String, Object> response = new HashMap<>();
        response.put("id", customer.getId());
        response.put("fullName", customer.getFullName());
        response.put("email", customer.getEmail());
        response.put("role", customer.getRole().getName());
        
        return response;
    }

    @Override
    public CustomersDTO createCustomers(CustomersDTO customersDTO) {
        // Hash the password before saving
        customersDTO.setPasswordHash(passwordEncoder.encode(customersDTO.getPasswordHash()));
        
        // Set default values for new customers
        customersDTO.setIsEmailConfirmed(false);
        customersDTO.setIsDeleted(false);
        
        Customers customers = CustomerMapper.mapToCustomers(customersDTO, null);
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
