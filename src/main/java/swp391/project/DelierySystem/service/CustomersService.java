package swp391.project.DelierySystem.service;

import swp391.project.DelierySystem.dto.Customersdto;
import java.util.List;

public interface CustomersService {
    Customersdto createCustomers(Customersdto customersdto);

    Customersdto getCustomersById(Long CustomersId);

    List<Customersdto> getAllCustomers();

    Customersdto updateCustomers(Long CustomersId, Customersdto updatedCustomers);

    void deleteCustomers(Long CustomersId);
}
