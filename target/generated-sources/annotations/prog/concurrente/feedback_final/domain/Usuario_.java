package prog.concurrente.feedback_final.domain;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SetAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.OffsetDateTime;

@StaticMetamodel(Usuario.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Usuario_ {

	
	/**
	 * @see prog.concurrente.feedback_final.domain.Usuario#lastUpdated
	 **/
	public static volatile SingularAttribute<Usuario, OffsetDateTime> lastUpdated;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Usuario#dateCreated
	 **/
	public static volatile SingularAttribute<Usuario, OffsetDateTime> dateCreated;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Usuario#pass
	 **/
	public static volatile SingularAttribute<Usuario, String> pass;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Usuario#reservas
	 **/
	public static volatile SetAttribute<Usuario, Reserva> reservas;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Usuario#direccion
	 **/
	public static volatile SingularAttribute<Usuario, String> direccion;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Usuario#id
	 **/
	public static volatile SingularAttribute<Usuario, Long> id;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Usuario
	 **/
	public static volatile EntityType<Usuario> class_;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Usuario#nombre
	 **/
	public static volatile SingularAttribute<Usuario, String> nombre;
	
	/**
	 * @see prog.concurrente.feedback_final.domain.Usuario#email
	 **/
	public static volatile SingularAttribute<Usuario, String> email;

	public static final String LAST_UPDATED = "lastUpdated";
	public static final String DATE_CREATED = "dateCreated";
	public static final String PASS = "pass";
	public static final String RESERVAS = "reservas";
	public static final String DIRECCION = "direccion";
	public static final String ID = "id";
	public static final String NOMBRE = "nombre";
	public static final String EMAIL = "email";

}

