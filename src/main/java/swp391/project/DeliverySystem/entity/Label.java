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
@Table(name = "Labels")
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "LabelName", nullable = false, unique = true)
    private String labelName;

    @Column(name = "Description")
    private String description;

    @Column(name = "ContactInfo")
    private String contactInfo;

    @Column(name = "Status")
    private String status;
}
