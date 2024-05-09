package bo.edu.uagrm.soe.practica2.dao;

import bo.edu.uagrm.soe.practica2.ds.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuariosDao extends CrudRepository<Usuario, Integer> {
}
