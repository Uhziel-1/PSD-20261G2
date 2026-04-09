package pe.edu.upeu.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.edu.upeu.model.Usuario;
import pe.edu.upeu.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
@DisplayName("UsuarioServce")
public class UsuarioServiceTest {

    @Mock
    private PasswordValidator passwordValidator;
    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImp usuarioService;

    @Nested
    class RegistrarUsuario{
        private Usuario usuarioValido;

        @BeforeEach
        void setup(){
            usuarioValido=new Usuario("ana", "ana@gmail.com", "Segura1!");
        }

        @Test
        void registrarUsuarioValido(){
            //GIVEN
            Mockito.when(passwordValidator.isValid(ArgumentMatchers.anyString())).thenReturn(true);
            Mockito.when(usuarioRepository.existByEmail("ana@gmail.com")).thenReturn(false);
            Mockito.when(usuarioRepository.save(ArgumentMatchers.any(Usuario.class))).thenReturn(usuarioValido);
            //When
            Usuario resultado=usuarioService.registrarUsuario(usuarioValido);
            //Then
            Assertions.assertThat(resultado)
                    .isNotNull()
                    .extracting(Usuario::getUsername,Usuario::getEmail)
                    .containsExactly("ana", "ana@gmail.com");

            Mockito.verify(passwordValidator).isValid("Segura1!");
            Mockito.verify(usuarioRepository).existByEmail("ana@gmail.com");
            Mockito.verify(usuarioRepository).save(usuarioValido);
        }


    }

}
