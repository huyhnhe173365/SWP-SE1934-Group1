package project.swp391.DeliverySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.swp391.DeliverySystem.entity.Storage;

public interface StorageRepository extends JpaRepository<Storage, Long> {

    // Additional query methods can be defined here if needed

}
