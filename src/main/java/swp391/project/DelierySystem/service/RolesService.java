package swp391.project.DelierySystem.service;

import swp391.project.DelierySystem.dto.RolesDTO;
import java.util.List;

public interface RolesService {
    RolesDTO createRoles(RolesDTO rolesDTO);

    RolesDTO getRolesById(Long RolesId);

    List<RolesDTO> getAllRoles();

    RolesDTO updateRoles(Long RolesId, RolesDTO updatedRoles);

    void deleteRoles(Long RolesId);
}
