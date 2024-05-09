package bo.edu.uagrm.soe.practica2.controller;

import bo.edu.uagrm.soe.practica2.dao.UsuariosDao;
import bo.edu.uagrm.soe.practica2.ds.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.net.URI;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestController
public class UsuariosController {

    @Autowired
    private UsuariosDao UsuariosDao;

    @CrossOrigin(origins = "*") // Permitir todas las solicitudes de cualquier origen
    @GetMapping("/usuarios")
    public Iterable<Usuario> list() {
        return UsuariosDao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> create(@RequestBody @Valid Usuario Usuario, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            Usuario savedUsuario = UsuariosDao.save(Usuario);

            return ResponseEntity
                    .created(URI.create("/usuarios/" + savedUsuario.getId()))
                    .body(savedUsuario);
        } else
            throw new ResponseStatusException(BAD_REQUEST, String.format("Request contains incorrect data = [%s]", getErrors(bindingResult)));
    }

    private String getErrors(BindingResult bindingResult) {
        return bindingResult.getAllErrors().stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(", "));
    }
}
