package prog.concurrente.feedback_final.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.Set;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "Servicios")
@EntityListeners(AuditingEntityListener.class)
public class Servicio {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Integer capacidad;

    @Column(nullable = false)
    private LocalTime horaApertura;

    @Column(nullable = false)
    private LocalTime horaCierre;

    @Column(nullable = false)
    private Integer duracionSesion;

    @OneToMany(mappedBy = "servicio")
    private Set<Reserva> reservas;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private OffsetDateTime dateCreated;

    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdated;

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

    public Integer getDuracionSesion() {
        return duracionSesion;
    }

    public void setDuracionSesion(final Integer duracionSesion) {
        this.duracionSesion = duracionSesion;
    }

    public Set<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(final Set<Reserva> reservas) {
        this.reservas = reservas;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(final OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(final OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

}
