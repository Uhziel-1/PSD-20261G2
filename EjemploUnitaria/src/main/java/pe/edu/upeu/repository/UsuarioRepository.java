package pe.edu.upeu.repository;

import pe.edu.upeu.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> findByUsername(String username);
    Usuario save(Usuario usuario);
    boolean existByEmail(String email);
}
