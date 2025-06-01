package swp391.project.DelierySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swp391.project.DelierySystem.entity.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Long>{
    
}
