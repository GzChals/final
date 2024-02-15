package prog.concurrente.feedback_final.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalTime;
import java.time.OffsetDateTime;

@StaticMetamodel(Servicio.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Servicio_ {

	
	/**
	 * @see prog.concurrente.feedback_final.domain.Servicio#horaApertura
	 **/
	public static volatile SingularAttribute<Servicio, LocalTime> horaApertura;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Servicio#lastUpdated
	 **/
	public static volatile SingularAttribute<Servicio, OffsetDateTime> lastUpdated;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Servicio#dateCreated
	 **/
	public static volatile SingularAttribute<Servicio, OffsetDateTime> dateCreated;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Servicio#reservas
	 **/
	public static volatile SetAttribute<Servicio, Reserva> reservas;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Servicio#id
	 **/
	public static volatile SingularAttribute<Servicio, Long> id;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Servicio#duracionSesion
	 **/
	public static volatile SingularAttribute<Servicio, LocalTime> duracionSesion;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Servicio#horaCierre
	 **/
	public static volatile SingularAttribute<Servicio, LocalTime> horaCierre;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Servicio
	 **/
	public static volatile EntityType<Servicio> class_;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Servicio#nombre
	 **/
	public static volatile SingularAttribute<Servicio, String> nombre;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Servicio#capacidad
	 **/
	public static volatile SingularAttribute<Servicio, Integer> capacidad;

	public static final String HORA_APERTURA = "horaApertura";
	public static final String LAST_UPDATED = "lastUpdated";
	public static final String DATE_CREATED = "dateCreated";
	public static final String RESERVAS = "reservas";
	public static final String ID = "id";
	public static final String DURACION_SESION = "duracionSesion";
	public static final String HORA_CIERRE = "horaCierre";
	public static final String NOMBRE = "nombre";
	public static final String CAPACIDAD = "capacidad";

}

