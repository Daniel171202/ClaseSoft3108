package com.clase31.demo.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clase31.demo.bl.UsuarioService;
import com.clase31.demo.dto.MessageResponse;
import com.clase31.demo.dto.UsuarioDTO;

@RestController
@RequestMapping("/usuario")
public class UsuarioAPI {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody UsuarioDTO usuarioDTO) {
        try {
            usuarioService.save(usuarioDTO);
            return new ResponseEntity<>(new MessageResponse("Usuario registrada"), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping
    public ResponseEntity<Object> getUsuarios() {
        try {
            return new ResponseEntity<>(usuarioService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new MessageResponse(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

  @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        Optional<UsuarioDTO> optionalUsuarioDTO = usuarioService.findById(id);

        if (optionalUsuarioDTO.isPresent()) {
            UsuarioDTO usuarioToUpdate = optionalUsuarioDTO.get();
            usuarioToUpdate.setNombre(usuarioDTO.getNombre());
            return ResponseEntity.ok(usuarioService.save(usuarioToUpdate));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Optional<UsuarioDTO> optionalUsuarioDTO = usuarioService.findById(id);

        if (optionalUsuarioDTO.isPresent()) {
            usuarioService.deleteById(id);
            return ResponseEntity.ok(new MessageResponse("Usuario eliminada correctamente"));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    
   
}
