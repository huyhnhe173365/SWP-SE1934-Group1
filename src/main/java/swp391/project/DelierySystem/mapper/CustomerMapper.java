package swp391.project.DelierySystem.mapper;

import swp391.project.DelierySystem.dto.CustomersDTO;
import swp391.project.DelierySystem.entity.Customers;

public class CustomerMapper {
        public static CustomersDTO mapToCustomersdto(Customers customers) {
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
                customers.getRoleId()
            );             
        }
        public static Customers mapToCustomer(CustomersDTO customersdto) {
            return new Customers(
                customersdto.getId(),
                customersdto.getFullName(),
                customersdto.getEmail(),
                customersdto.getPhoneNumber(),
                customersdto.getCitizenId(),
                customersdto.getDateOfBirth(),
                customersdto.getCustomerType(),
                customersdto.getPasswordHash(),
                customersdto.getIsEmailConfirmed(),
                customersdto.getIsDeleted(),
                customersdto.getRoleId()
            );
        }
}