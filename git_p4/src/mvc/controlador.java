package mvc;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.Action;

import mvc.Modelo.Partido;

	//-----------CONTROLADOR------------------------
	class GuardarAction extends AbstractAction
	{		
		/**
		 * 
		 */
		private static final long serialVersionUID = -340230671664188041L;
		private Modelo modelo;
		private MainWrapper vista;
		
		//Constructor
		public GuardarAction(Modelo modelo, MainWrapper vista)
		{			
			this.modelo = modelo;
			this.vista = vista;
			putValue(Action.NAME,"Guardar");
			putValue(Action.SHORT_DESCRIPTION,"Guardamos un partido");
		}
		
		public void actionPerformed(ActionEvent e)
		{ 
			//recopilamos los datos del partido y llamamos al modelo para que proceda a almacenarlo
			SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
			String strFecha = vista.getFecha();
			Date fecha = null;
			try {

			fecha = formatoDelTexto.parse(strFecha);

			} catch (ParseException ex) {

			ex.printStackTrace();

			}
			Partido p = modelo.creaPartido(vista.getLocal(),vista.getVisitante(),fecha);
			modelo.Guardar(p);		
			
			
		}
	}
	

