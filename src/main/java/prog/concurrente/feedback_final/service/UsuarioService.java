package prog.concurrente.feedback_final.service;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import prog.concurrente.feedback_final.domain.Reserva;
import prog.concurrente.feedback_final.domain.Usuario;
import prog.concurrente.feedback_final.model.UsuarioDTO;
import prog.concurrente.feedback_final.repos.ReservaRepository;
import prog.concurrente.feedback_final.repos.UsuarioRepository;
import prog.concurrente.feedback_final.util.NotFoundException;
import prog.concurrente.feedback_final.util.ReferencedWarning;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ReservaRepository reservaRepository;

    public UsuarioService(final UsuarioRepository usuarioRepository,
            final ReservaRepository reservaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.reservaRepository = reservaRepository;
    }

    public List<UsuarioDTO> findAll() {
        final List<Usuario> usuarios = usuarioRepository.findAll(Sort.by("id"));
        return usuarios.stream()
                .map(usuario -> mapToDTO(usuario, new UsuarioDTO()))
                .toList();
    }

    public UsuarioDTO get(final Long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> mapToDTO(usuario, new UsuarioDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final UsuarioDTO usuarioDTO) {
        final Usuario usuario = new Usuario();
        mapToEntity(usuarioDTO, usuario);
        return usuarioRepository.save(usuario).getId();
    }

    public void update(final Long id, final UsuarioDTO usuarioDTO) {
        final Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(usuarioDTO, usuario);
        usuarioRepository.save(usuario);
    }

    public void delete(final Long id) {
        usuarioRepository.deleteById(id);
    }

    private UsuarioDTO mapToDTO(final Usuario usuario, final UsuarioDTO usuarioDTO) {
        usuarioDTO.setId(usuario.getId());
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setDireccion(usuario.getDireccion());
        usuarioDTO.setEmail(usuario.getEmail());
        usuarioDTO.setPass(usuario.getPass());
        return usuarioDTO;
    }

    private Usuario mapToEntity(final UsuarioDTO usuarioDTO, final Usuario usuario) {
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setDireccion(usuarioDTO.getDireccion());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPass(usuarioDTO.getPass());
        return usuario;
    }

    public ReferencedWarning getReferencedWarning(final Long id) {
        final ReferencedWarning referencedWarning = new ReferencedWarning();
        final Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        final Reserva usuarioReserva = reservaRepository.findFirstByUsuario(usuario);
        if (usuarioReserva != null) {
            referencedWarning.setKey("usuario.reserva.usuario.referenced");
            referencedWarning.addParam(usuarioReserva.getId());
            return referencedWarning;
        }
        return null;
    }

}
