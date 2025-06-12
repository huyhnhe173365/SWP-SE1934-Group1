package project.swp391.DeliverySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.swp391.DeliverySystem.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    // Additional query methods can be defined here if needed
    
}
