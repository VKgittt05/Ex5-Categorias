package com.Gerenciamento_Categorias.Categorias.controllers;

import com.Gerenciamento_Categorias.Categorias.models.Categoria;
import com.Gerenciamento_Categorias.Categorias.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @PostMapping
    public ResponseEntity<Categoria> criar(@RequestBody Categoria categoria) {
        Categoria novaCategoria = service.salvar(categoria);
        return new ResponseEntity<>(novaCategoria, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Categoria> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
