package med.voll.api.Repository;

import med.voll.api.Models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository  extends JpaRepository<Usuarios,Long> {
    UserDetails findByLogin(String login);
}
