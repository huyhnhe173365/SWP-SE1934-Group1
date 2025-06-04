package swp391.project.DeliverySystem.mapper;

import swp391.project.DeliverySystem.dto.OrderTrackingDTO;
import swp391.project.DeliverySystem.entity.OrderRequests;
import swp391.project.DeliverySystem.entity.OrderTracking;

public class OrderTrackingMapper {

    public static OrderTrackingDTO toDTO(OrderTracking entity) {
        if (entity == null) return null;

        return new OrderTrackingDTO(
                entity.getId(),
                entity.getOrder() != null ? entity.getOrder().getId() : null,
                entity.getTrackingNumber(),
                entity.getStatus(),
                entity.getUpdatedAt(),
                entity.getLocation(),
                entity.getNotes()
        );
    }

    public static OrderTracking toEntity(OrderTrackingDTO dto, OrderRequests order) {
        if (dto == null) return null;

        OrderTracking entity = new OrderTracking();
        entity.setId(dto.getId());
        entity.setOrder(order);
        entity.setTrackingNumber(dto.getTrackingNumber());
        entity.setStatus(dto.getStatus());
        entity.setLocation(dto.getLocation());
        entity.setNotes(dto.getNotes());
        return entity;
    }
}

