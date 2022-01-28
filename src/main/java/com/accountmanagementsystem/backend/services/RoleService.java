package com.accountmanagementsystem.backend.services;

import com.accountmanagementsystem.backend.entities.Role;
import com.accountmanagementsystem.backend.exceptions.InvalidRoleException;
import com.accountmanagementsystem.backend.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {
    RoleRepository roleRepository;

    public RoleRepository getRoleRepository() {
        return roleRepository;
    }

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findById(int id) throws InvalidRoleException {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if(!optionalRole.isPresent()) {
            throw new InvalidRoleException("Role id not found : "+id);
        }
        return optionalRole.get();
    }

    public List<Role> findAll(){
        return roleRepository.findAll();
    }
    public Role save(Role user) {
        return roleRepository.save(user);
    }
    public Role update(Role role) throws InvalidRoleException {
        Optional<Role> optionalCustomer = roleRepository.findById(role.getRoleId());
        if(!optionalCustomer.isPresent()) {
            throw new InvalidRoleException("Role not existing to edit with id: "+role.getRoleId());
        }
        return roleRepository.save(role);
    }
    public Role delete(int id) throws InvalidRoleException {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if(!optionalRole.isPresent()) {
            throw new InvalidRoleException("Role not existing to delete with id: "+id);
        }
        Role role = optionalRole.get();
        roleRepository.deleteById(id);
        return role;
    }
}
