package br.com.Caua_Pincelli_Cacchero.organizadorDespesas.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "Users")
@Data
public class User {

    UUID id;
    String nome;
    String email;
    String senha;
    int limiteGastos;
}
