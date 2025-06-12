package project.swp391.DeliverySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.swp391.DeliverySystem.entity.EmailConfirmed;

public interface EmailConfirmedRepository extends JpaRepository<EmailConfirmed, Long> {
    
    // Additional query methods can be defined here if needed
    
}
