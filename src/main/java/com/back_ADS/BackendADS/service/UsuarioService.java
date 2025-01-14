package com.back_ADS.BackendADS.service;

import com.back_ADS.BackendADS.dto.UserDTO;
import com.back_ADS.BackendADS.entity.Usuario;
import com.back_ADS.BackendADS.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<UserDTO> validateUser(String email, String password) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (password.equals(usuario.getPassword())) {
                return Optional.of(new UserDTO(
                        usuario.getIdUser(),
                        usuario.getName(),
                        usuario.getRole()
                ));
            }
        }
        return Optional.empty();
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario update(Long id, Usuario usuarioDetails) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (optionalUsuario.isPresent()) {
            Usuario usuario = optionalUsuario.get();

            usuario.setEmail(usuarioDetails.getEmail());
            usuario.setName(usuarioDetails.getName());
            usuario.setLastName(usuarioDetails.getLastName());
            usuario.setPassword(usuarioDetails.getPassword());
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
