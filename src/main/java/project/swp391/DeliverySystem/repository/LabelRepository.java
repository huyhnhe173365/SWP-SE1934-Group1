package project.swp391.DeliverySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.swp391.DeliverySystem.entity.Label;

public interface LabelRepository extends JpaRepository<Label, Long> {

    // Additional query methods can be defined here if needed
    
}
