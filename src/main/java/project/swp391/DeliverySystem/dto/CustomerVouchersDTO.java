package project.swp391.DeliverySystem.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.swp391.DeliverySystem.entity.Customers;
import project.swp391.DeliverySystem.entity.Vouchers;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerVouchersDTO {
    private Integer id;
    private Customers customer;
    private Vouchers vouchers;
    private LocalDateTime usedAt;
    private Boolean isUsed;
}
