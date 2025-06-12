package project.swp391.DeliverySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.swp391.DeliverySystem.entity.OrderRequests;

public interface OrderRequestsRepository extends JpaRepository<OrderRequests, Long> {

    // Additional query methods can be defined here if needed

}
