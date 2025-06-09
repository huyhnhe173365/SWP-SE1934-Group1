package swp391.project.DeliverySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import swp391.project.DeliverySystem.entity.Roles;

import java.util.Optional;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    Optional<Object> findByRoleName(String roleName);

    // Additional query methods can be defined here if needed  
}
