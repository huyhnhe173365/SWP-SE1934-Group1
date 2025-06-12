package project.swp391.DeliverySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.swp391.DeliverySystem.entity.Payment ;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Additional query methods can be defined here if needed

}
