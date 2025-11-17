package br.com.Caua_Pincelli_Cacchero.organizadorDespesas.controllers;

import br.com.Caua_Pincelli_Cacchero.organizadorDespesas.models.Despesas;
import br.com.Caua_Pincelli_Cacchero.organizadorDespesas.services.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/despesas")
public class DespesaController {

    @Autowired
    private DespesaService service;

    @PostMapping
    public Despesas createDespesas(@RequestBody Despesas despesas) {
        return service.createDespesa(despesas);
    }

    @GetMapping("/{id}")
    public Despesas findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Despesas updateDespesa(@PathVariable UUID id, @RequestBody Despesas despesas) {
        return service.updateDespesa(id, despesas);
    }

    @DeleteMapping("/{id}")
    public void deleteDespesa(@PathVariable UUID id) {
        service.delete(id);
    }
}
