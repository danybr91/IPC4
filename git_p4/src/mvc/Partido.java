package mvc;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;

public class Partido {
	private String local;
	private String visitante;
	private Date fecha;
	//Gestion de la notificacion de cambios, se para el propio partido como parametro
	private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
	
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
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
	
	public void Guardar(Partido partido){
		this.local  = partido.getLocal();
		
		changeSupport.firePropertyChange("local",this.local, partido.local);
		
	}
	/**
	 * Metodo que permite registrar listener
	 * @param listener
	 */
	public void addPropertyChangeListener (PropertyChangeListener listener)
	{
		changeSupport.addPropertyChangeListener(listener);
	}
	
}
