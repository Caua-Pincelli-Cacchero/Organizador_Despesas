package br.com.Caua_Pincelli_Cacchero.organizadorDespesas.controllers;

import br.com.Caua_Pincelli_Cacchero.organizadorDespesas.models.Despesas;
import br.com.Caua_Pincelli_Cacchero.organizadorDespesas.services.DespesaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/despesas")
public class DespesaController {

    private final DespesaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Despesas createDespesas(@RequestBody Despesas despesas) {
        return service.createDespesa(despesas);
    }

    @GetMapping("/{id}")
    public Despesas findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Despesas> findAll(){
        return service.findAll();
    }

    @PutMapping("/{id}")
    public Despesas updateDespesa(@PathVariable UUID id, @RequestBody Despesas despesas) {
        return service.updateDespesa(id, despesas);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDespesa(@PathVariable UUID id) {
        service.delete(id);
    }
}
