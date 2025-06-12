package project.swp391.DeliverySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.swp391.DeliverySystem.entity.CustomerVouchers;

public interface CustomerVouchersRepository extends JpaRepository<CustomerVouchers, Long> {
    
    // Additional query methods can be defined here if needed
    
}
