package com.clase31.demo.bl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.clase31.demo.dao.UsuarioDAO;
import com.clase31.demo.dto.UsuarioDTO;
import org.springframework.stereotype.Service;

@Service

public class UsuarioBL implements UsuarioService {
     @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public Iterable<UsuarioDTO> findAll() {
        return usuarioDAO.findAll();
    }

    @Override
    public Optional<UsuarioDTO> findById(Long id) {
        return usuarioDAO.findById(id);
    }

    @Override
    public UsuarioDTO save(UsuarioDTO consulta) {
        return usuarioDAO.save(consulta);
    }

    @Override
    public void deleteById(Long id) {
        usuarioDAO.deleteById(id);
    }
}
