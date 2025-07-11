package org.example.apprenantservice.controllers;

//import org.springframework.security.access.prepost.PreAuthorize;
import org.example.apprenantservice.dtos.UserDTO;
import org.example.apprenantservice.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = service.createUser(userDTO);
        return ResponseEntity.ok(createdUser);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/userList")
    public List<UserDTO> getUsers(){
        return service.getUsersList();
    }

//    @PreAuthorize("hasAnyRole('ADMIN', 'DRIVER', 'SENDER')")
    @PutMapping("/update/{id}")
    public UserDTO updateUser(@RequestBody UserDTO dto, @PathVariable Long id){
        return service.updateUser(id,dto);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateRole/{id}")
    public UserDTO updateUserRole(@RequestBody UserDTO dto, @PathVariable Long id){
        return service.updateUserRole(id,dto);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUser(id);
    }

}
