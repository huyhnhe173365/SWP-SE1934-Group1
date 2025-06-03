package swp391.project.DeliverySystem.mapper;

import swp391.project.DeliverySystem.entity.EmailConfirmed;
import swp391.project.DeliverySystem.dto.EmailComfirmedDTO;

public class EmailConfirmedMapper {
    public static EmailComfirmedDTO mapToEmailConfirmedDTO(EmailConfirmed emailConfirmed) {
        if (emailConfirmed == null) return null;
        return new EmailComfirmedDTO(
            emailConfirmed.getId() != null ? emailConfirmed.getId().intValue() : null,
            emailConfirmed.getCustomer(),
            emailConfirmed.getToken(),
            emailConfirmed.getExpirationDate()
        );
    }
    public static EmailConfirmed mapToEmailConfirmed(EmailComfirmedDTO dto) {
        if (dto == null) return null;
        EmailConfirmed entity = new EmailConfirmed();
        entity.setId(dto.getId() != null ? dto.getId().longValue() : null);
        entity.setCustomer(dto.getCustomer());
        entity.setToken(dto.getToken());
        entity.setExpirationDate(dto.getExpirationDate());
        return entity;
    }
}
