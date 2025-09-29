package br.com.Caua_Pincelli_Cacchero.organizadorDespesas.controllers;

import br.com.Caua_Pincelli_Cacchero.organizadorDespesas.models.User;
import br.com.Caua_Pincelli_Cacchero.organizadorDespesas.services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private userService service;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.create(user);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable UUID id, @RequestBody User user) {
        return service.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        service.delete(id);
    }
}
