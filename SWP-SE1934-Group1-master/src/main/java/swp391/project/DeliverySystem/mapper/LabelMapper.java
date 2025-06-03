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

    public static Label mapToLabel(LabelDTO labelDTO) {
        if (labelDTO == null) return null;
        Label label = new Label();
        label.setId(labelDTO.getId() != null ? labelDTO.getId().longValue() : null);
        label.setLabelName(labelDTO.getLabelName());
        label.setDescription(labelDTO.getDescription());
        label.setContactInfo(labelDTO.getContactInfo());
        label.setStatus(labelDTO.getStatus());
        return label;
    }
}