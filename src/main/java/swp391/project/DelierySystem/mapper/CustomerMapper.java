package swp391.project.DelierySystem.mapper;

import swp391.project.DelierySystem.dto.Customersdto;
import swp391.project.DelierySystem.entity.Customers;

public class CustomerMapper {
        public static Customersdto mapToCustomersdto(Customers customers) {
            return new Customersdto(
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
        public static Customers mapToCustomer(Customersdto customersdto) {
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