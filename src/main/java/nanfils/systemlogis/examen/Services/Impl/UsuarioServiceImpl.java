package nanfils.systemlogis.examen.Services.Impl;

import nanfils.systemlogis.examen.Entities.Usuario;
import nanfils.systemlogis.examen.Entities.UsuarioRol;
import nanfils.systemlogis.examen.Repositories.RoleRepository;
import nanfils.systemlogis.examen.Repositories.UsuarioRepository;
import nanfils.systemlogis.examen.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal=usuarioRepository.findByUsername(usuario.getUsername());
        if(usuarioLocal !=null){
            System.out.println("User exist");
            throw new Exception("User present");
        }
        else
        {
             for (UsuarioRol usuarioRol: usuarioRoles){
                 roleRepository.save(usuarioRol.getRol());
             }
             usuario.getUsuarioRoles().addAll(usuarioRoles);
             usuarioLocal=usuarioRepository.save(usuario);
        }
        return  usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void supprimerEtudiant(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }
}
