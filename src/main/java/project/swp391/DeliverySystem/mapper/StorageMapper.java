package project.swp391.DeliverySystem.mapper;

import project.swp391.DeliverySystem.dto.StorageDTO;
import project.swp391.DeliverySystem.entity.Storage;

public class StorageMapper {
    public static StorageDTO mapToStorageDTO(Storage storage) {
        return new StorageDTO(
                storage.getId(),
                storage.getStorageName(),
                storage.getAddress(),
                storage.getCapacity(),
                storage.getPricePerMonth(),
                storage.getContactInfo(),
                storage.getStatus()
        );
    }

    public static Storage mapToStorage(StorageDTO storageDTO) {
        return new Storage(
                storageDTO.getId(),
                storageDTO.getStorageName(),
                storageDTO.getAddress(),
                storageDTO.getCapacity(),
                storageDTO.getPricePerMonth(),
                storageDTO.getContactInfo(),
                storageDTO.getStatus()
        );
    }
}