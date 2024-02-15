package prog.concurrente.feedback_final.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import prog.concurrente.feedback_final.model.EstadoReserva;


@Entity
@Table(name = "Reservas")
@EntityListeners(AuditingEntityListener.class)
public class Reserva {

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
    private Long idUsuario;

    @Column(nullable = false)
    private Long idServicio;

    @Column(nullable = false)
    private LocalDate diaReserva;

    @Column(nullable = false)
    private LocalTime horaReserva;

    @Column
    @Enumerated(EnumType.STRING)
    private EstadoReserva estadoReserva;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servicio_id")
    private Servicio servicio;

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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(final Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(final Long idServicio) {
        this.idServicio = idServicio;
    }

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(final Usuario usuario) {
        this.usuario = usuario;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(final Servicio servicio) {
        this.servicio = servicio;
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
