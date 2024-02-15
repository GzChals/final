package prog.concurrente.feedback_final.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import prog.concurrente.feedback_final.model.EstadoReserva;

@StaticMetamodel(Reserva.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Reserva_ {

	
	/**
	 * @see prog.concurrente.feedback_final.domain.Reserva#lastUpdated
	 **/
	public static volatile SingularAttribute<Reserva, OffsetDateTime> lastUpdated;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Reserva#servicio
	 **/
	public static volatile SingularAttribute<Reserva, Servicio> servicio;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Reserva#dateCreated
	 **/
	public static volatile SingularAttribute<Reserva, OffsetDateTime> dateCreated;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Reserva#horaReserva
	 **/
	public static volatile SingularAttribute<Reserva, LocalTime> horaReserva;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Reserva#usuario
	 **/
	public static volatile SingularAttribute<Reserva, Usuario> usuario;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Reserva#id
	 **/
	public static volatile SingularAttribute<Reserva, Long> id;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Reserva#diaReserva
	 **/
	public static volatile SingularAttribute<Reserva, LocalDate> diaReserva;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Reserva#estadoReserva
	 **/
	public static volatile SingularAttribute<Reserva, EstadoReserva> estadoReserva;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Reserva
	 **/
	public static volatile EntityType<Reserva> class_;

	public static final String LAST_UPDATED = "lastUpdated";
	public static final String SERVICIO = "servicio";
	public static final String DATE_CREATED = "dateCreated";
	public static final String HORA_RESERVA = "horaReserva";
	public static final String USUARIO = "usuario";
	public static final String ID = "id";
	public static final String DIA_RESERVA = "diaReserva";
	public static final String ESTADO_RESERVA = "estadoReserva";

}

