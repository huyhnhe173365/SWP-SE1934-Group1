package project.swp391.DeliverySystem.service;

import java.util.List;
import project.swp391.DeliverySystem.dto.LabelDTO;

public interface LabelService {
    LabelDTO createLabels(LabelDTO labelDTO);

    LabelDTO getLabelById(Long LabelId);

    List<LabelDTO> getAllLabel();

    LabelDTO updateLabel(Long LabelId, LabelDTO labelDTO);

    void deleteLabelById(Long LabelId);
}
