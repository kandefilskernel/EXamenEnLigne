package nanfils.systemlogis.examen.Services;

import nanfils.systemlogis.examen.Entities.Usuario;
import nanfils.systemlogis.examen.Entities.UsuarioRol;

import java.util.Set;
public interface UsuarioService {
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;
    public Usuario obtenerUsuario(String username);
    public void supprimerEtudiant(Long usuarioId);
}
