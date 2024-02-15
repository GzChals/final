package prog.concurrente.feedback_final.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalTime;


public class ServicioDTO {

    private Long id;

    @NotNull
    @Size(max = 255)
    private String nombre;

    @NotNull
    private Integer capacidad;

    @NotNull
    @Schema(type = "string", example = "18:30")
    private LocalTime horaApertura;

    @NotNull
    @Schema(type = "string", example = "18:30")
    private LocalTime horaCierre;

    @NotNull
    private LocalTime duracionSesion;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(final Integer capacidad) {
        this.capacidad = capacidad;
    }

    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(final LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(final LocalTime horaCierre) {
        this.horaCierre = horaCierre;
    }

    public LocalTime getDuracionSesion() {
        return duracionSesion;
    }

    public void setDuracionSesion(final LocalTime duracionSesion) {
        this.duracionSesion = duracionSesion;
    }

}
