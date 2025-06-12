package project.swp391.DeliverySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.swp391.DeliverySystem.entity.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Long>{
    
}
