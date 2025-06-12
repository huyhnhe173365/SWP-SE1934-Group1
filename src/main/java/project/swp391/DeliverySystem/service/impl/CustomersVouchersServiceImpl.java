package project.swp391.DeliverySystem.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.swp391.DeliverySystem.service.CustomerVouchersService;
import project.swp391.DeliverySystem.dto.CustomerVouchersDTO;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomersVouchersServiceImpl implements CustomerVouchersService {

    @Override
    public CustomerVouchersDTO createCustomerVouchers(CustomerVouchersDTO customerVouchersDTO) {
        return null;
    }

    @Override
    public CustomerVouchersDTO getCustomerVouchersById(Long CustomerVouchersId) {
        return null;
    }

    @Override
    public List<CustomerVouchersDTO> getAllCustomerVouchers() {
        return null;
    }

    @Override
    public CustomerVouchersDTO updateCustomerVouchers(Long CustomerVouchersId, CustomerVouchersDTO customerVouchersDTO) {
        return null;
    }

    @Override
    public void deleteCustomerVouchers(Long CustomerVouchersId) {

    }
}
