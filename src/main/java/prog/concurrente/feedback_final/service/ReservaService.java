package prog.concurrente.feedback_final.service;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import prog.concurrente.feedback_final.domain.Reserva;
import prog.concurrente.feedback_final.domain.Servicio;
import prog.concurrente.feedback_final.domain.Usuario;
import prog.concurrente.feedback_final.model.ReservaDTO;
import prog.concurrente.feedback_final.repos.ReservaRepository;
import prog.concurrente.feedback_final.repos.ServicioRepository;
import prog.concurrente.feedback_final.repos.UsuarioRepository;
import prog.concurrente.feedback_final.util.NotFoundException;


@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ServicioRepository servicioRepository;

    public ReservaService(final ReservaRepository reservaRepository,
            final UsuarioRepository usuarioRepository,
            final ServicioRepository servicioRepository) {
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
        this.servicioRepository = servicioRepository;
    }

    public List<ReservaDTO> findAll() {
        final List<Reserva> reservas = reservaRepository.findAll(Sort.by("id"));
        return reservas.stream()
                .map(reserva -> mapToDTO(reserva, new ReservaDTO()))
                .toList();
    }

    public ReservaDTO get(final Long id) {
        return reservaRepository.findById(id)
                .map(reserva -> mapToDTO(reserva, new ReservaDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ReservaDTO reservaDTO) {
        final Reserva reserva = new Reserva();
        mapToEntity(reservaDTO, reserva);
        return reservaRepository.save(reserva).getId();
    }

    public void update(final Long id, final ReservaDTO reservaDTO) {
        final Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(reservaDTO, reserva);
        reservaRepository.save(reserva);
    }

    public void delete(final Long id) {
        reservaRepository.deleteById(id);
    }

    private ReservaDTO mapToDTO(final Reserva reserva, final ReservaDTO reservaDTO) {
        reservaDTO.setId(reserva.getId());
        reservaDTO.setIdUsuario(reserva.getIdUsuario());
        reservaDTO.setIdServicio(reserva.getIdServicio());
        reservaDTO.setDiaReserva(reserva.getDiaReserva());
        reservaDTO.setHoraReserva(reserva.getHoraReserva());
        reservaDTO.setEstadoReserva(reserva.getEstadoReserva());
        reservaDTO.setUsuario(reserva.getUsuario() == null ? null : reserva.getUsuario().getId());
        reservaDTO.setServicio(reserva.getServicio() == null ? null : reserva.getServicio().getId());
        return reservaDTO;
    }

    private Reserva mapToEntity(final ReservaDTO reservaDTO, final Reserva reserva) {
        reserva.setIdUsuario(reservaDTO.getIdUsuario());
        reserva.setIdServicio(reservaDTO.getIdServicio());
        reserva.setDiaReserva(reservaDTO.getDiaReserva());
        reserva.setHoraReserva(reservaDTO.getHoraReserva());
        reserva.setEstadoReserva(reservaDTO.getEstadoReserva());
        final Usuario usuario = reservaDTO.getUsuario() == null ? null : usuarioRepository.findById(reservaDTO.getUsuario())
                .orElseThrow(() -> new NotFoundException("usuario not found"));
        reserva.setUsuario(usuario);
        final Servicio servicio = reservaDTO.getServicio() == null ? null : servicioRepository.findById(reservaDTO.getServicio())
                .orElseThrow(() -> new NotFoundException("servicio not found"));
        reserva.setServicio(servicio);
        return reserva;
    }

}
