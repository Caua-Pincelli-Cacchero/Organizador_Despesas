package br.com.Caua_Pincelli_Cacchero.organizadorDespesas.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "Despesas")
@Data
public class Despesas {

    @Id
    UUID id;

    @Column(nullable = false, length = 100)
    String descricao;

    @Column(nullable = false)
    BigDecimal valor;

    @Enumerated(EnumType.STRING)
    CategoriaDespesa tipoDespesa;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private User usuario;

}
