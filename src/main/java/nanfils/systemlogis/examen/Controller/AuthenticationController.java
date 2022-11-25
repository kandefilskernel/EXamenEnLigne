package nanfils.systemlogis.examen.Controller;

import nanfils.systemlogis.examen.Configuration.JwtUtils;
import nanfils.systemlogis.examen.Entities.JwtRequest;
import nanfils.systemlogis.examen.Entities.JwtResponse;
import nanfils.systemlogis.examen.Services.Impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateurToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try
        {
            authenticar(jwtRequest.getUsername(),jwtRequest.getPassword());

        }catch (Exception exception){
            exception.printStackTrace();
            throw  new Exception("User non decouvert");
        }
        UserDetails userDetails=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token=this.jwtUtils.generateToken(userDetails);
        return  ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticar(String username, String password) throws Exception {
        try
        {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
        }catch (DisabledException disabledException){
            throw new Exception("User destabilisé" + disabledException.getMessage() );
        }catch (BadCredentialsException badCredentialsException){
            throw  new Exception("Identifiant non correct" + badCredentialsException.getMessage());
        }
    }
}
