package project.swp391.DeliverySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.swp391.DeliverySystem.entity.Vouchers;

public interface VouchersRepository extends JpaRepository<Vouchers, Long> {

    // Additional query methods can be defined here if needed

}
