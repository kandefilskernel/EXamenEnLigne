package nanfils.systemlogis.examen.Controller;
import nanfils.systemlogis.examen.Entities.Rol;
import nanfils.systemlogis.examen.Entities.Usuario;
import nanfils.systemlogis.examen.Entities.UsuarioRol;
import nanfils.systemlogis.examen.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @PostMapping("/")
    public Usuario SaveUser(@RequestBody Usuario usuario )throws Exception
    {
        usuario.setProfile("default.png");
        Set<UsuarioRol> usuarioRoles=new HashSet<>();

        Rol rol=new Rol();
        rol.setRolId(3L);
        rol.setName("SIMPLE");

        UsuarioRol usuarioRol=new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        usuarioRoles.add(usuarioRol);
        return  usuarioService.guardarUsuario(usuario,usuarioRoles);
    }
    
    @GetMapping("/{username}")
    public Usuario RetirerUser(@PathVariable("username")String username)
    {
        return   usuarioService.obtenerUsuario(username);
    }


    @DeleteMapping("/{usuarioId}")
    public void  supprimerUser(@PathVariable("usuarioId")Long usuarioId)
    {
        usuarioService.supprimerEtudiant(usuarioId);
    }
}
