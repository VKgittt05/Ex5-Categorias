package com.Gerenciamento_Categorias.Categorias.repositories;

import com.Gerenciamento_Categorias.Categorias.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}

