package prog.concurrente.feedback_final.service;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import prog.concurrente.feedback_final.domain.Reserva;
import prog.concurrente.feedback_final.domain.Servicio;
import prog.concurrente.feedback_final.model.ServicioDTO;
import prog.concurrente.feedback_final.repos.ReservaRepository;
import prog.concurrente.feedback_final.repos.ServicioRepository;
import prog.concurrente.feedback_final.util.NotFoundException;
import prog.concurrente.feedback_final.util.ReferencedWarning;


@Service
public class ServicioService {

    private final ServicioRepository servicioRepository;
    private final ReservaRepository reservaRepository;

    public ServicioService(final ServicioRepository servicioRepository,
            final ReservaRepository reservaRepository) {
        this.servicioRepository = servicioRepository;
        this.reservaRepository = reservaRepository;
    }

    public List<ServicioDTO> findAll() {
        final List<Servicio> servicios = servicioRepository.findAll(Sort.by("id"));
        return servicios.stream()
                .map(servicio -> mapToDTO(servicio, new ServicioDTO()))
                .toList();
    }

    public ServicioDTO get(final Long id) {
        return servicioRepository.findById(id)
                .map(servicio -> mapToDTO(servicio, new ServicioDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final ServicioDTO servicioDTO) {
        final Servicio servicio = new Servicio();
        mapToEntity(servicioDTO, servicio);
        return servicioRepository.save(servicio).getId();
    }

    public void update(final Long id, final ServicioDTO servicioDTO) {
        final Servicio servicio = servicioRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        mapToEntity(servicioDTO, servicio);
        servicioRepository.save(servicio);
    }

    public void delete(final Long id) {
        servicioRepository.deleteById(id);
    }

    private ServicioDTO mapToDTO(final Servicio servicio, final ServicioDTO servicioDTO) {
        servicioDTO.setId(servicio.getId());
        servicioDTO.setNombre(servicio.getNombre());
        servicioDTO.setCapacidad(servicio.getCapacidad());
        servicioDTO.setHoraApertura(servicio.getHoraApertura());
        servicioDTO.setHoraCierre(servicio.getHoraCierre());
        servicioDTO.setDuracionSesion(servicio.getDuracionSesion());
        return servicioDTO;
    }

    private Servicio mapToEntity(final ServicioDTO servicioDTO, final Servicio servicio) {
        servicio.setNombre(servicioDTO.getNombre());
        servicio.setCapacidad(servicioDTO.getCapacidad());
        servicio.setHoraApertura(servicioDTO.getHoraApertura());
        servicio.setHoraCierre(servicioDTO.getHoraCierre());
        servicio.setDuracionSesion(servicioDTO.getDuracionSesion());
        return servicio;
    }

    public ReferencedWarning getReferencedWarning(final Long id) {
        final ReferencedWarning referencedWarning = new ReferencedWarning();
        final Servicio servicio = servicioRepository.findById(id)
                .orElseThrow(NotFoundException::new);
        final Reserva servicioReserva = reservaRepository.findFirstByServicio(servicio);
        if (servicioReserva != null) {
            referencedWarning.setKey("servicio.reserva.servicio.referenced");
            referencedWarning.addParam(servicioReserva.getId());
            return referencedWarning;
        }
        return null;
    }

}
