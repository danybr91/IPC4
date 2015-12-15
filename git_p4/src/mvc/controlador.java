package mvc;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class controlador {

	//-----------CONTROLADOR------------------------
	class GuardarAction extends AbstractAction
	{		
		private Partido modelo;
		private MainWrapper vista;
		
		//Constructor
		public GuardarAction(Partido modelo, MainWrapper vista)
		{			
			this.modelo = modelo;
			this.vista = vista;
			putValue(Action.NAME,"Guardar");
			putValue(Action.SHORT_DESCRIPTION,"Guardamos un partido");
		}
		public void actionPerformed(ActionEvent e)
		{ 
			//recopilamos los datos del partido y llamamos al modelo para que proceda a almacenarlo
			vista.getTxtLocal();
			Partido p = new Partido();
			modelo.Guardar(p);
			
			
		}
	}
	
}
