package nanfils.systemlogis.examen.Services.Impl;

import nanfils.systemlogis.examen.Entities.Usuario;
import nanfils.systemlogis.examen.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario=this.usuarioRepository.findByUsername(username);
        if(usuario==null){
            throw new UsernameNotFoundException("User non contracté");
        }
        return usuario;
    }
}
