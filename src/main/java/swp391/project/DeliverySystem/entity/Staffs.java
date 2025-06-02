package swp391.project.DeliverySystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
public class Staffs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FullName", nullable = false, length = 100)
    private String fullName;

    @Column(name = "Email", length = 100, unique = true)
    private String email;

    @Column(name = "PhoneNumber", length = 20)
    private String phoneNumber;

    @Column(name = "AssignedLabelID")
    private Long assignedLabelId;  // INT có thể NULL

    @Column(name = "AssignedStorageID")
    private Long assignedStorageId; // INT có thể NULL

    @Column(name = "Status", length = 100)
    private String status;

    /*
     * Theo SQL ban đầu có ràng buộc:
     * CHECK (
     *   (AssignedLabelID IS NOT NULL AND AssignedStorageID IS NULL)
     *   OR
     *   (AssignedLabelID IS NULL AND AssignedStorageID IS NOT NULL)
     * )
     *
     * Hiện tại JPA không hỗ trợ CHECK constraint mặc định,
     * nếu muốn enforce, bạn có thể:
     * 1. Tạo Trigger/Constraint trực tiếp trong DB (như SQL đã định nghĩa).
     * 2. Hoặc validate trong Service/DTO (trước khi save).
     */
}
