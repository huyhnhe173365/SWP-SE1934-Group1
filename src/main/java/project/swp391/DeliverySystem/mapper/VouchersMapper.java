package project.swp391.DeliverySystem.mapper;

import project.swp391.DeliverySystem.dto.VouchersDTO;
import project.swp391.DeliverySystem.entity.Vouchers;

public class VouchersMapper {
    public static VouchersDTO mapToVouchersDTO(Vouchers vouchers) {
        return new VouchersDTO(
                vouchers.getId(),
                vouchers.getCode(),
                vouchers.getDescription(),
                vouchers.getDiscountValue(),
                vouchers.getDiscountType(),
                vouchers.getMinOrderAmount(),
                vouchers.getMaxDiscountAmount(),
                vouchers.getUsageLimit(),
                vouchers.getUsageCount(),
                vouchers.getStatus(),
                vouchers.getStartDate(),
                vouchers.getEndDate()
        );
    }

    public static Vouchers mapToVouchers(VouchersDTO vouchersDTO) {
        return new Vouchers(
                vouchersDTO.getId(),
                vouchersDTO.getCode(),
                vouchersDTO.getDescription(),
                vouchersDTO.getDiscountValue(),
                vouchersDTO.getDiscountType(),
                vouchersDTO.getMinOrderAmount(),
                vouchersDTO.getMaxDiscountAmount(),
                vouchersDTO.getUsageLimit(),
                vouchersDTO.getUsageCount(),
                vouchersDTO.getStatus(),
                vouchersDTO.getStartDate(),
                vouchersDTO.getEndDate()
        );
    }
}