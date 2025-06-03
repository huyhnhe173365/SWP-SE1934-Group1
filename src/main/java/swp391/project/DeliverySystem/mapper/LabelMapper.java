package swp391.project.DeliverySystem.mapper;

import swp391.project.DeliverySystem.entity.Label;
import swp391.project.DeliverySystem.dto.LabelDTO;

public class LabelMapper {
    public static LabelDTO mapToLabelDTO(Label label) {
        if (label == null) return null;
        return new LabelDTO(
            label.getId() != null ? label.getId().intValue() : null,
            label.getLabelName(),
            label.getDescription(),
            label.getContactInfo(),
            label.getStatus()
        );
    }

    public static Label mapToLabel(LabelDTO dto) {
        if (dto == null) return null;
        Label label = new Label();
        label.setId(dto.getId() != null ? dto.getId().longValue() : null);
        label.setLabelName(dto.getLabelName());
        label.setDescription(dto.getDescription());
        label.setContactInfo(dto.getContactInfo());
        label.setStatus(dto.getStatus());
        return label;
    }
}