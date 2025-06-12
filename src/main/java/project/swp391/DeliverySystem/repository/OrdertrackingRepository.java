package project.swp391.DeliverySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.swp391.DeliverySystem.entity.OrderTracking;

public interface OrdertrackingRepository extends JpaRepository<OrderTracking, Long> {
}
