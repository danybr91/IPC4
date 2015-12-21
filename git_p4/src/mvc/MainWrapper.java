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
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTable;

public class MainWrapper extends JFrame implements
PropertyChangeListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5312499194754732142L;
	private JPanel contentPane;
	//private Modelo partidos;
	private JTextField textLocal;
	private JTextField textVisitante;
	private JTextField textFecha;
	private JButton btnGuardar_1;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JTable table;
	
	
	public String getLocal() {
		return textLocal.getText();
	}

	public String getVisitante() {
		return textVisitante.getText();
	}
	
	public String getFecha() {
		return textFecha.getText();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modelo miModelo = new Modelo();
					MainWrapper vista = new MainWrapper(miModelo);
					vista.setGuardarAction(new GuardarAction(miModelo,vista));
					vista.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWrapper(Modelo m) {
		//Anhadimos listener
		m.addChangeListener(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {30, 86, 0, 0, 45};
		gbl_panel.rowHeights = new int[]{23, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		panel.setMaximumSize(getMinimumSize());
		
		JLabel lblLocal = new JLabel("Local:");
		GridBagConstraints gbc_lblLocal = new GridBagConstraints();
		gbc_lblLocal.anchor = GridBagConstraints.EAST;
		gbc_lblLocal.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocal.gridx = 1;
		gbc_lblLocal.gridy = 2;
		panel.add(lblLocal, gbc_lblLocal);
		
		textLocal = new JTextField();
		GridBagConstraints gbc_textLocal = new GridBagConstraints();
		gbc_textLocal.anchor = GridBagConstraints.WEST;
		gbc_textLocal.insets = new Insets(0, 0, 5, 5);
		gbc_textLocal.gridx = 2;
		gbc_textLocal.gridy = 2;
		panel.add(textLocal, gbc_textLocal);
		textLocal.setColumns(10);
		
		JLabel lblVisitante = new JLabel("Visitante:");
		GridBagConstraints gbc_lblVisitante = new GridBagConstraints();
		gbc_lblVisitante.anchor = GridBagConstraints.EAST;
		gbc_lblVisitante.insets = new Insets(0, 0, 5, 5);
		gbc_lblVisitante.gridx = 1;
		gbc_lblVisitante.gridy = 3;
		panel.add(lblVisitante, gbc_lblVisitante);
		
		textVisitante = new JTextField();
		GridBagConstraints gbc_textVisitante = new GridBagConstraints();
		gbc_textVisitante.anchor = GridBagConstraints.WEST;
		gbc_textVisitante.insets = new Insets(0, 0, 5, 5);
		gbc_textVisitante.gridx = 2;
		gbc_textVisitante.gridy = 3;
		panel.add(textVisitante, gbc_textVisitante);
		textVisitante.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 1;
		gbc_lblFecha.gridy = 4;
		panel.add(lblFecha, gbc_lblFecha);
		
		textFecha = new JTextField();
		GridBagConstraints gbc_textFecha = new GridBagConstraints();
		gbc_textFecha.anchor = GridBagConstraints.WEST;
		gbc_textFecha.insets = new Insets(0, 0, 5, 5);
		gbc_textFecha.gridx = 2;
		gbc_textFecha.gridy = 4;
		panel.add(textFecha, gbc_textFecha);
		textFecha.setColumns(10);
		
		btnGuardar_1 = new JButton("Guardar");
		btnGuardar_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnGuardar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		GridBagConstraints gbc_btnGuardar_1 = new GridBagConstraints();
		gbc_btnGuardar_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar_1.gridx = 1;
		gbc_btnGuardar_1.gridy = 5;
		panel.add(btnGuardar_1, gbc_btnGuardar_1);
		
		btnModificar = new JButton("Modificar");
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.insets = new Insets(0, 0, 0, 5);
		gbc_btnModificar.gridx = 2;
		gbc_btnModificar.gridy = 5;
		panel.add(btnModificar, gbc_btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEliminar.gridx = 3;
		gbc_btnEliminar.gridy = 5;
		panel.add(btnEliminar, gbc_btnEliminar);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		table = new JTable();
		panel_1.add(table, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Introduce los datos del partido");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
	}
	
	public void setGuardarAction(Action action)
	{
		btnGuardar_1.setAction(action);	
	}
	
	public void setModificarAction(Action action){
		
	}
	

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println(evt.getPropertyName());
		//Si la propiedad cambiada es guardar
		if (evt.getPropertyName().equals("Nuevo"))
		{
			//Actualizamos los datos
			
			System.out.println("Se ha actualizado algo");	
						
		}
		
	}
}
