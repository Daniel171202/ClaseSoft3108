package com.clase31.demo.dao;
import com.clase31.demo.dto.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDAO extends JpaRepository<UsuarioDTO, Long>{
    
}
