package swp391.project.DelierySystem.entity;

import java.time.LocalDate;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
@Table(name = "customers")

public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "PhoneNumber", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "CitizenID",nullable = false, unique = true)
    private Integer citizenId;

    @Column(name = "DateOfBirth")
    private LocalDate dateOfBirth;

    @Column(name = "CustomerType")
    private String customerType;

    @Column(name = "PasswordHash")
    private String passwordHash;

    @Column(name = "IsEmailConfirmed")
    private Boolean isEmailConfirmed;

    @Column(name = "IsDeleted")
    private Boolean isDeleted;

    @Column(name = "RoleID")
    private Integer roleId;
}
