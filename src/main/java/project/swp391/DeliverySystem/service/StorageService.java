package project.swp391.DeliverySystem.service;

import project.swp391.DeliverySystem.dto.StorageDTO;

import java.util.List;

public interface StorageService {
    List<StorageDTO> getAllStorages();
    StorageDTO getStorageById(Long id);
    StorageDTO createStorage(StorageDTO storageDTO);
    StorageDTO updateStorage(Long id, StorageDTO storageDTO);
    void deleteStorage(Long id);
}

