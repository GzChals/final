package prog.concurrente.feedback_final.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;


public class ReservaDTO {

    private Long id;

    //@NotNull
    //private Long idUsuario;

    //@NotNull
    //private Long idServicio;

    @NotNull
    private LocalDate diaReserva;

    @NotNull
    @Schema(type = "string", example = "18:30")
    private LocalTime horaReserva;

    private EstadoReserva estadoReserva;

    @NotNull
    private Long usuario;

    private Long servicio;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    //public Long getIdUsuario() {
    //    return idUsuario;
    //}

    //public void setIdUsuario(final Long idUsuario) {
    //    this.idUsuario = idUsuario;
    //}

    //public Long getIdServicio() {
    //    return idServicio;
    //}

    //public void setIdServicio(final Long idServicio) {
    //    this.idServicio = idServicio;
    //}

    public LocalDate getDiaReserva() {
        return diaReserva;
    }

    public void setDiaReserva(final LocalDate diaReserva) {
        this.diaReserva = diaReserva;
    }

    public LocalTime getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(final LocalTime horaReserva) {
        this.horaReserva = horaReserva;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(final EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public Long getUsuario() {
        return usuario;
    }

    public void setUsuario(final Long usuario) {
        this.usuario = usuario;
    }

    public Long getServicio() {
        return servicio;
    }

    public void setServicio(final Long servicio) {
        this.servicio = servicio;
    }

}
