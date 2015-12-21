package mvc;

import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.Action;

/**
 * Clase que implementa la accion de guardado de un partido
 * @author Daniel Belén, Andrés Heredia, Álvaro Sainz, Gabriel Via.
 *
 */
class GuardarAction extends AbstractAction {
	//Atributos
	private static final long serialVersionUID = -340230671664188041L;
	private Partido modelo;
	private MainWrapper vista;

	// Constructor
	public GuardarAction(Partido modelo, MainWrapper vista) {
		this.modelo = modelo;
		this.vista = vista;
		putValue(Action.NAME, "Guardar");
		putValue(Action.SHORT_DESCRIPTION, "Guardar un partido");
	}

	public void actionPerformed(ActionEvent e) {
		// recopilamos los datos del partido y llamamos al modelo para que
		// proceda a almacenarlo
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd/MM/yyyy");
		String strFecha = vista.getFecha();
		Date fecha = null;
		try {

			fecha = formatoDelTexto.parse(strFecha);

		} catch (ParseException ex) {
			
		}
		modelo.Guardar(vista.getLocal(), vista.getVisitante(), fecha);

	}
}
