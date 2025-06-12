package project.swp391.DeliverySystem.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.swp391.DeliverySystem.dto.StorageDTO;
import project.swp391.DeliverySystem.entity.Storage;
import project.swp391.DeliverySystem.exception.ResourceNotFoundException;
import project.swp391.DeliverySystem.mapper.StorageMapper;
import project.swp391.DeliverySystem.repository.StorageRepository;
import project.swp391.DeliverySystem.service.StorageService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StorageServiceImpl implements StorageService {

    private final StorageRepository storageRepository;

    public StorageServiceImpl(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    @Override
    public List<StorageDTO> getAllStorages() {
        // Lấy tất cả Storage entity, chuyển thành DTO
        List<Storage> entities = storageRepository.findAll();
        return entities.stream()
                .map(StorageMapper::mapToStorageDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StorageDTO getStorageById(Long id) {
        Storage entity = storageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Storage", "id", id));
        return StorageMapper.mapToStorageDTO(entity);
    }

    @Override
    public StorageDTO createStorage(StorageDTO storageDTO) {
        // Chuyển DTO → entity và save
        Storage entity = StorageMapper.mapToStorage(storageDTO);
        // Khi tạo mới, dto.getId() thường null hoặc bị bỏ qua
        Storage saved = storageRepository.save(entity);
        return StorageMapper.mapToStorageDTO(saved);
    }

    @Override
    public StorageDTO updateStorage(Long id, StorageDTO storageDTO) {
        Storage existing = storageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Storage", "id", id));

        // Cập nhật từng trường từ DTO
        existing.setStorageName(storageDTO.getStorageName());
        existing.setAddress(storageDTO.getAddress());
        existing.setCapacity(storageDTO.getCapacity());
        existing.setPricePerMonth(storageDTO.getPricePerMonth());
        existing.setContactInfo(storageDTO.getContactInfo());
        existing.setStatus(storageDTO.getStatus());

        Storage updated = storageRepository.save(existing);
        return StorageMapper.mapToStorageDTO(updated);
    }

    @Override
    public void deleteStorage(Long id) {
        Storage existing = storageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Storage", "id", id));
        storageRepository.delete(existing);
    }
}
