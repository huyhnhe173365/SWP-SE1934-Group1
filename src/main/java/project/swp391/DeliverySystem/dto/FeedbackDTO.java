package project.swp391.DeliverySystem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.swp391.DeliverySystem.entity.Customers;
import project.swp391.DeliverySystem.entity.OrderRequests;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDTO {
    private Integer id;
    private Customers customer;
    private OrderRequests orderRequest;
    private Integer rating;
    private String comment;
    private String feedbackDate;
}
