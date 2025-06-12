package project.swp391.DeliverySystem.mapper;

import project.swp391.DeliverySystem.dto.CustomersDTO;
import project.swp391.DeliverySystem.entity.Customers;
import project.swp391.DeliverySystem.entity.Roles;

public class CustomerMapper {
        public static CustomersDTO mapToCustomersDTO(Customers customers) {
            return new CustomersDTO(
                customers.getId(),
                customers.getFullName(),
                customers.getEmail(),
                customers.getPhoneNumber(),
                customers.getCitizenId(),
                customers.getDateOfBirth(),
                customers.getCustomerType(),
                customers.getPasswordHash(),
                customers.getIsEmailConfirmed(),
                customers.getIsDeleted(),
                customers.getRole()
            );             
        }
        public static Customers mapToCustomers(CustomersDTO customersDTO, Roles role) {
            return new Customers(
                customersDTO.getId(),
                customersDTO.getFullName(),
                customersDTO.getEmail(),
                customersDTO.getPhoneNumber(),
                customersDTO.getCitizenId(),
                customersDTO.getDateOfBirth(),
                customersDTO.getCustomerType(),
                customersDTO.getPasswordHash(),
                customersDTO.getIsEmailConfirmed(),
                customersDTO.getIsDeleted(),
                role
            );
        }
}