package swp391.project.DeliverySystem.mapper;

import swp391.project.DeliverySystem.entity.CustomerVouchers;
import swp391.project.DeliverySystem.dto.CustomerVouchersDTO;

public class CustomerVouchersMapper {
    public static CustomerVouchersDTO mapToCustomerVouchersDTO(CustomerVouchers customerVouchers) {
        if (customerVouchers == null) return null;
        return new CustomerVouchersDTO(
            customerVouchers.getId() != null ? customerVouchers.getId().intValue() : null,
            customerVouchers.getCustomer(),
            customerVouchers.getVoucher(),
            customerVouchers.getUsedAt(),
            customerVouchers.getIsUsed()
        );
    }

    public static CustomerVouchers mapToCustomerVouchers(CustomerVouchersDTO dto) {
        if (dto == null) return null;
        CustomerVouchers entity = new CustomerVouchers();
        entity.setId(dto.getId() != null ? dto.getId().longValue() : null);
        entity.setCustomer(dto.getCustomer());
        entity.setVoucher(dto.getVouchers());
        entity.setUsedAt(dto.getUsedAt());
        entity.setIsUsed(dto.getIsUsed());
        return entity;
    }
}

