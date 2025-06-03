package swp391.project.DeliverySystem.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import swp391.project.DeliverySystem.entity.Label;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LabelCalendarDTO {
    private Integer id;
    private Label label;
    private String task;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
