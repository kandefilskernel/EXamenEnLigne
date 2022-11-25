package nanfils.systemlogis.examen.Repositories;

import nanfils.systemlogis.examen.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    public Usuario findByUsername(String username);
}
