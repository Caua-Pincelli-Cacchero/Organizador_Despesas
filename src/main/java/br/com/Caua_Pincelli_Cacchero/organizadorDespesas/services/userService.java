package br.com.Caua_Pincelli_Cacchero.organizadorDespesas.services;

import br.com.Caua_Pincelli_Cacchero.organizadorDespesas.models.User;
import br.com.Caua_Pincelli_Cacchero.organizadorDespesas.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class userService {
    @Autowired
    private userRepository repository;

    public User create(User user) {

        user.setId(UUID.randomUUID());
        user.setNome(user.getNome());
        user.setEmail(user.getEmail());
        user.setSenha(user.getSenha());
        user.setLimiteGastos(user.getLimiteGastos());

        return repository.save(user);
    }
}
