package com.accountmanagementsystem.backend.controller;

import com.accountmanagementsystem.backend.entities.Role;
import com.accountmanagementsystem.backend.entities.User;
import com.accountmanagementsystem.backend.exceptions.InvalidRoleException;
import com.accountmanagementsystem.backend.services.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{roleId}")
    public ResponseEntity<Role> findRole(@PathVariable int roleId) throws InvalidRoleException {
        Role role = roleService.findById(roleId);
        ResponseEntity<Role> responseEntity = new ResponseEntity<Role>(role, HttpStatus.OK);
        return responseEntity;
    }

    @CrossOrigin(origins = "*")
    @GetMapping()
    public List<Role> findAll() {
        return this.roleService.findAll();
    }

    @PostMapping()
    public ResponseEntity<Role> save(@RequestBody Role role) {
        Role roleSave = roleService.save(role);
        ResponseEntity<Role> responseEntity = new ResponseEntity<Role>(roleSave, HttpStatus.OK);
        return responseEntity;
    }

    @PutMapping()
    public ResponseEntity<Role> update (@RequestBody Role role) throws InvalidRoleException {
        Role roleUpdate = roleService.update(role) ;
        ResponseEntity<Role> responseEntity = new ResponseEntity<Role>(roleUpdate, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<Role> delete(@PathVariable int roleId) throws InvalidRoleException {
        Role role = roleService.delete(roleId);
        ResponseEntity<Role> responseEntity = new ResponseEntity<Role>(role, HttpStatus.OK);
        return responseEntity;
    }
}
