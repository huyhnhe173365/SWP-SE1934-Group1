package project.swp391.DeliverySystem.service;

import java.util.List;

import project.swp391.DeliverySystem.dto.RolesDTO;

public interface RolesService {
    RolesDTO createRoles(RolesDTO rolesDTO);

    RolesDTO getRolesById(Long RolesId);

    List<RolesDTO> getAllRoles();

    RolesDTO updateRoles(Long RolesId, RolesDTO updatedRoles);

    void deleteRoles(Long RolesId);
}
