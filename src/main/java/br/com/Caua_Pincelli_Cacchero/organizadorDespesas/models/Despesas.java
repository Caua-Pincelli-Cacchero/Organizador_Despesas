package br.com.Caua_Pincelli_Cacchero.organizadorDespesas.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "Despesas")
@Data
public class Despesas {

    @Id
    UUID id;

    @Column(name = "descricao", nullable = false, length = 100)
    String descricao;

    @Column(nullable = false)
    int valor;

    @Enumerated(EnumType.STRING)
    CategoriaDespesa tipoDespesa;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;

}
