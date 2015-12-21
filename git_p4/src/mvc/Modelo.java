package mvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Date;
//Clase modelo
import java.util.List;

public class Modelo {

	private List<Partido> partidos = new ArrayList<Partido>();
	private List<PropertyChangeListener> listener = new ArrayList<PropertyChangeListener>();

	public class Partido {
		private String local;
		private String visitante;
		private Date fecha;

		public Partido() {

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

	}

	public List<Partido> getPartidos(){
		return partidos;
	}
	public Partido getPartido(int index){
		return partidos.get(index);
	}
	public Partido creaPartido(String local, String visitante, Date fecha){
		return new Partido(local,visitante,fecha);
	}
	public void Guardar(Partido partido) {
		partidos.add(partido);
		// changeSupport.firePropertyChange("local", this.local, partido.local);
		System.out.println("Guardo partido");
		notifyListeners(this, 
		          "Nuevo", 
		          "antes", 
		          "despues");
		    
	}
	public void Modificar(Partido partido){
		
	}

	private void notifyListeners(Object object, String property, String oldValue, String newValue) {
		for (PropertyChangeListener name : listener) {
			name.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
		}
	}

	/**
	 * Metodo que permite registrar listener
	 * 
	 * @param listener
	 */
	public void addChangeListener(PropertyChangeListener nuevolistener) {
		listener.add(nuevolistener);
	}

}
