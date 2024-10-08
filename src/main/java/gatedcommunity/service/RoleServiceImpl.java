package gatedcommunity.service;

import gatedcommunity.model.entity.Role;
import gatedcommunity.repository.RoleRepository;
import gatedcommunity.service.interfaces.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleUser() {
        return roleRepository.findByTitle("ROLE_USER")
                .orElseThrow(() -> new RuntimeException("Role_USER not found"));
    }
}
