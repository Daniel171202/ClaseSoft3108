package com.clase31.demo.bl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.clase31.demo.dto.UsuarioDTO;
public interface UsuarioService {

     public Iterable<UsuarioDTO> findAll();

    public Optional<UsuarioDTO> findById(Long id);

    public UsuarioDTO save(UsuarioDTO usuario);

    public void deleteById(Long id);
}
