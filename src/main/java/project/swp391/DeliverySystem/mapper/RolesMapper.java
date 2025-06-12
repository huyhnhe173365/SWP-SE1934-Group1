package project.swp391.DeliverySystem.mapper;

import project.swp391.DeliverySystem.dto.RolesDTO;
import project.swp391.DeliverySystem.entity.Roles;

public class RolesMapper {
    public static RolesDTO mapToRolesDTO(Roles roles) {
        return new RolesDTO(
            roles.getId(),
            roles.getRoleName()       
        );
    }
    public static Roles mapToRoles(RolesDTO rolesDTO) {
        return new Roles(
            rolesDTO.getId(),
            rolesDTO.getRoleName()
        );
    }
}
