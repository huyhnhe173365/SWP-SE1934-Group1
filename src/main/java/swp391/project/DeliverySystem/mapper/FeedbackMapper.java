package swp391.project.DeliverySystem.mapper;

import swp391.project.DeliverySystem.dto.FeedbackDTO;
import swp391.project.DeliverySystem.entity.Feedback;

public class FeedbackMapper {
    public static FeedbackDTO mapToFeedbackDTO(Feedback feedback) {
        if (feedback == null) return null;
        return new FeedbackDTO(
            feedback.getId() != null ? feedback.getId().intValue() : null,
            feedback.getCustomer(),
            feedback.getOrderRequest(),
            feedback.getRating(),
            feedback.getComment(),
            feedback.getFeedbackDate() != null ? feedback.getFeedbackDate().toString() : null
        );
    }

    public static Feedback mapToFeedback(FeedbackDTO dto) {
        if (dto == null) return null;
        Feedback entity = new Feedback();
        entity.setId(dto.getId() != null ? dto.getId().longValue() : null);
        entity.setCustomer(dto.getCustomer());
        entity.setOrderRequest(dto.getOrderRequest());
        entity.setRating(dto.getRating());
        entity.setComment(dto.getComment());
        entity.setFeedbackDate(dto.getFeedbackDate() != null ? java.time.LocalDate.parse(dto.getFeedbackDate()) : null);
        return entity;
    }
}