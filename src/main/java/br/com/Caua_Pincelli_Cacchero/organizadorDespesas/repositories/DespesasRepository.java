package br.com.Caua_Pincelli_Cacchero.organizadorDespesas.repositories;

import br.com.Caua_Pincelli_Cacchero.organizadorDespesas.models.Despesas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DespesasRepository extends JpaRepository<Despesas, UUID> {}
