package project.swp391.DeliverySystem.mapper;

import project.swp391.DeliverySystem.dto.StaffsDTO;
import project.swp391.DeliverySystem.entity.Staffs;
import project.swp391.DeliverySystem.entity.Label;
import project.swp391.DeliverySystem.entity.Storage;

public class StaffsMapper {
    public static StaffsDTO mapToStaffsDTO(Staffs staffs) {
        return new StaffsDTO(
                staffs.getId(),
                staffs.getFullName(),
                staffs.getEmail(),
                staffs.getPhoneNumber(),
                staffs.getLabel() != null ? staffs.getLabel().getId() : null,
                staffs.getStorage() != null ? staffs.getStorage().getId() : null,
                staffs.getStatus()
        );
    }

    public static Staffs mapToStaffs(StaffsDTO staffsDTO, Label label, Storage storage) {
        return new Staffs(
                staffsDTO.getId(),
                staffsDTO.getFullName(),
                staffsDTO.getEmail(),
                staffsDTO.getPhoneNumber(),
                label,
                storage,
                staffsDTO.getStatus()
        );
    }
}