package project.swp391.DeliverySystem.service;

import java.util.List;

import project.swp391.DeliverySystem.dto.CustomerVouchersDTO;

public interface CustomerVouchersService {
    CustomerVouchersDTO createCustomerVouchers(CustomerVouchersDTO customerVouchersDTO);

    CustomerVouchersDTO getCustomerVouchersById(Long CustomerVouchersId);

    List<CustomerVouchersDTO> getAllCustomerVouchers();

    CustomerVouchersDTO updateCustomerVouchers(Long CustomerVouchersId, CustomerVouchersDTO customerVouchersDTO);

    void deleteCustomerVouchers(Long CustomerVouchersId);
}
