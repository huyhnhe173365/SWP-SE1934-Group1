package swp391.project.DeliverySystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LabelCalendars")
public class LabelCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "LabelID", nullable = false)
    private Label label;

    private String task;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
