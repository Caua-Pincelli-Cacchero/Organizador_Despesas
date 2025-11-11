package br.com.Caua_Pincelli_Cacchero.organizadorDespesas.services;

import br.com.Caua_Pincelli_Cacchero.organizadorDespesas.models.Despesas;
import br.com.Caua_Pincelli_Cacchero.organizadorDespesas.models.User;
import br.com.Caua_Pincelli_Cacchero.organizadorDespesas.repositories.despesasRepository;
import br.com.Caua_Pincelli_Cacchero.organizadorDespesas.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class despesaService {

    @Autowired
    private despesasRepository repository;

    public Despesas createDespesa(Despesas despesas) {


        despesas.setId(UUID.randomUUID());
        despesas.setDescricao(despesas.getDescricao());
        despesas.setValor(despesas.getValor());
        despesas.setTipoDespesa(despesas.getTipoDespesa());
        despesas.setUsuario(despesas.getUsuario());

        return repository.save(despesas);
    }

    public Despesas findById(UUID id) {

        return repository.findById(id).get();
    }

    public Despesas updateDespesa(UUID id, Despesas despesas) {

        Despesas existingDespesa = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Despesa não encontrada!"));

        despesas.setDescricao(despesas.getDescricao());
        despesas.setValor(despesas.getValor());
        despesas.setTipoDespesa(despesas.getTipoDespesa());

        return repository.save(despesas);

    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
