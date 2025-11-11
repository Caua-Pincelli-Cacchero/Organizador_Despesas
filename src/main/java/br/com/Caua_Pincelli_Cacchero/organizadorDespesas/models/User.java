package br.com.Caua_Pincelli_Cacchero.organizadorDespesas.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Users")
@Data
public class User {

    @Id
    UUID id;

    @Column(nullable = false)
    String nome;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = false)
    String senha;

    @Column(nullable = false)
    int limiteGastos;

    @JsonManagedReference
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Despesas> despesas;
}
