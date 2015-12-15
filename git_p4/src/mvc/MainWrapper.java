package mvc;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWrapper extends JFrame implements
PropertyChangeListener{

	private JPanel contentPane;
	private JTextField txtLocal;
	private JTextField textField;
	private JTextField textField_1;
	private JButton btnGuardar = new JButton("Guardar");
	private Partido partido;
	
	

	public String getTxtLocal() {
		return txtLocal.getText();
	}

	public JTextField getTextField() {
		return textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Partido p = new Partido();
					MainWrapper frame = new MainWrapper(p);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWrapper(Partido p) {
		//Definimos el partido
		partido = p;
		//Anhadimos listener
		partido.addPropertyChangeListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("1px"),},
			new RowSpec[] {
				RowSpec.decode("1px"),}));
		
		JLabel lblIngreseDatosDel = new JLabel("Ingrese datos del partido");
		contentPane.add(lblIngreseDatosDel, "1, 1, fill, fill");
		
		JLabel lblLocal = new JLabel("Local");
		contentPane.add(lblLocal, "1, 1, fill, fill");
		
		txtLocal = new JTextField();
		contentPane.add(txtLocal, "1, 1, fill, fill");
		txtLocal.setColumns(10);
		
		JLabel lblVisitante = new JLabel("Visitante");
		contentPane.add(lblVisitante, "1, 1, fill, fill");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "1, 1, fill, fill");
		textField_1.setColumns(10);
		
		JLabel lblFecha = new JLabel("fecha");
		contentPane.add(lblFecha, "1, 1, fill, fill");
		
		textField = new JTextField();
		contentPane.add(textField, "1, 1, fill, fill");
		textField.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		contentPane.add(btnGuardar, "1, 1, fill, fill");
	}
	
	public void setGuardarAction(Action action)
	{
		btnGuardar.setAction(action);
	}
	
	

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		//Si la propiedad cambiada es guardar
		if (evt.getPropertyName().equals("local"))
		{
			//Actualizamos los datos
			Date fecha = (Date)evt.getNewValue();
			textField_1.setText(fecha.toString());
			
						
		}
		
	}

}
