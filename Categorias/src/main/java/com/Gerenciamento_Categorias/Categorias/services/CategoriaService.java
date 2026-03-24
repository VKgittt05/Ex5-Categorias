package com.Gerenciamento_Categorias.Categorias.services;

import com.Gerenciamento_Categorias.Categorias.models.Categoria;
import com.Gerenciamento_Categorias.Categorias.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria salvar(Categoria categoria) {
        return repository.save(categoria);
    }

    public List<Categoria> listarTodas() {
        return repository.findAll();
    }

    public Optional<Categoria> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
