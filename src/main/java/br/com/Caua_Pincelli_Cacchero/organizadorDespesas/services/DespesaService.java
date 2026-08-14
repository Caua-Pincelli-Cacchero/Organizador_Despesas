package br.com.Caua_Pincelli_Cacchero.organizadorDespesas.services;

import br.com.Caua_Pincelli_Cacchero.organizadorDespesas.exception.UserAndExpenseNotFoundException;
import br.com.Caua_Pincelli_Cacchero.organizadorDespesas.models.Despesas;
import br.com.Caua_Pincelli_Cacchero.organizadorDespesas.models.User;
import br.com.Caua_Pincelli_Cacchero.organizadorDespesas.repositories.DespesasRepository;
import br.com.Caua_Pincelli_Cacchero.organizadorDespesas.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DespesaService {

    private final DespesasRepository repositoryDespesas;
    private final UserRepository repositoryUser;

    public Despesas createDespesa(Despesas despesas) {

            User user = repositoryUser.findById(despesas.getUsuario().getId())
                    .orElseThrow(() -> new UserAndExpenseNotFoundException("Usuário não encontrado!"));

            despesas.setId(UUID.randomUUID());
            despesas.setUsuario(user);

            return repositoryDespesas.save(despesas);

    }

    public Despesas findById(UUID id) {

        return repositoryDespesas.findById(id).get();
    }

    public List<Despesas> findAll(){
        return repositoryDespesas.findAll();
    }

    public Despesas updateDespesa(UUID id, Despesas despesas) {

        Despesas existingDespesa = repositoryDespesas.findById(id)
                .orElseThrow(() -> new UserAndExpenseNotFoundException("Despesa não encontrada!"));

        despesas.setDescricao(despesas.getDescricao());
        despesas.setValor(despesas.getValor());
        despesas.setTipoDespesa(despesas.getTipoDespesa());

        return repositoryDespesas.save(existingDespesa);

    }

    public void delete(UUID id) {
        repositoryDespesas.deleteById(id);
    }
}
