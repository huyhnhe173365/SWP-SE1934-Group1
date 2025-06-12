package project.swp391.DeliverySystem.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import project.swp391.DeliverySystem.entity.Label;
import project.swp391.DeliverySystem.entity.OrderRequests;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabelCalendarDTO {
    private Integer id;
    private LocalDateTime scheduleDate;
    private BigDecimal price;
    private Label label;
    private OrderRequests order;
    private Boolean isBooked = false;

}
