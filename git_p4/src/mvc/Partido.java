package mvc;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

/**
 * Clase que implementa un partido
 * @author Daniel Belén, Andrés Heredia, Álvaro Sainz, Gabriel Via.
 *
 */
public class Partido {
	private String local = new String();
	private String visitante = new String();
	private Date fecha = new Date();

	public Partido() {

	}
	

	@Override
	public String toString() {
		return "Partido [local=" + local + ", visitante=" + visitante + ", fecha=" + fecha + "]";
	}


	public Partido(String local, String visitante, Date fecha) {
		super();
		this.local = local;
		this.visitante = visitante;
		this.fecha = fecha;
	}

	// Gestion de la notificacion de cambios, se para el propio partido como
	// parametro
	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

	public String getLocal() {
		return local;
	}
	public String getVisitante() {
		return visitante;
	}

	public void setVisitante(String visitante) {
		this.visitante = visitante;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void Guardar(String local, String visitante, Date fecha) {
		//Guardamos /modificamos el partido
			changeSupport.firePropertyChange("local", this.local, local);
			changeSupport.firePropertyChange("visitante", this.visitante, visitante);
			changeSupport.firePropertyChange("fecha", this.fecha, fecha);
			this.local = local;
			this.visitante = visitante;
			this.fecha = fecha;
			
			

	}

	/**
	 * Metodo que permite registrar listener
	 * 
	 * @param listener
	 */
	public void addPropertyChangeListener (PropertyChangeListener listener)
	{
		changeSupport.addPropertyChangeListener(listener);
	}
}
