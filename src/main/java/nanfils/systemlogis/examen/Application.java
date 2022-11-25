package nanfils.systemlogis.examen;

import nanfils.systemlogis.examen.Entities.Rol;
import nanfils.systemlogis.examen.Entities.Usuario;
import nanfils.systemlogis.examen.Entities.UsuarioRol;
import nanfils.systemlogis.examen.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Application  {
    @Autowired
	private UsuarioService usuarioService;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		Usuario usuario=new Usuario();
		usuario.setName("MULUMBA KANDE KERNEL");
		usuario.setUsername("kernel");
		usuario.setPassword("12345");
		usuario.setFamily("KANDE NGONGO");
		usuario.setPhone("0815515896");
		usuario.setEmail("fistonkande24@gmail.com");
		usuario.setProfile("kernel.jpg");
		Rol  rol=new Rol();
		rol.setRolId(1L);
		rol.setName("ADMIN");

		Set<UsuarioRol> usuarioRoles =new HashSet<>();
		UsuarioRol usuarioRol=new UsuarioRol();
		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(usuario);
		usuarioRoles.add(usuarioRol);

		Usuario usuarioGuardado=usuarioService.guardarUsuario(usuario,usuarioRoles);
	}*/
}
