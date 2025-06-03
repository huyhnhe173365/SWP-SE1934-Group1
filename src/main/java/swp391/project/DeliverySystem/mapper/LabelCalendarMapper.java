package swp391.project.DeliverySystem.mapper;

import swp391.project.DeliverySystem.entity.LabelCalendar;
import swp391.project.DeliverySystem.dto.LabelCalendarDTO;
import swp391.project.DeliverySystem.entity.Label;

public class LabelCalendarMapper {
    public static LabelCalendarDTO mapToLabelCalendarDTO(LabelCalendar entity) {
        if (entity == null) return null;
        LabelCalendarDTO dto = new LabelCalendarDTO();
        dto.setId(entity.getId() != null ? entity.getId().intValue() : null);
        dto.setScheduleDate(entity.getScheduleDate());
        dto.setPrice(entity.getPrice());
        dto.setLabel(entity.getLabel());
        dto.setOrder(entity.getOrder());
        dto.setIsBooked(entity.getIsBooked());
        return dto;
    }

    public static LabelCalendar mapToLabelCalendar(LabelCalendarDTO dto, Label label) {
        if (dto == null) return null;
        LabelCalendar entity = new LabelCalendar();
        entity.setId(dto.getId() != null ? dto.getId().longValue() : null);
        entity.setScheduleDate(dto.getScheduleDate());
        entity.setPrice(dto.getPrice());
        entity.setLabel(label);
        entity.setOrder(dto.getOrder());
        entity.setIsBooked(dto.getIsBooked());
        return entity;
    }
}