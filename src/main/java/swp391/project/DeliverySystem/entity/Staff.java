package swp391.project.DeliverySystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "AssignedLabelID")
    private Label assignedLabel;

    @ManyToOne
    @JoinColumn(name = "AssignedStorageID")
    private Storage assignedStorage;

    private String status;
}

