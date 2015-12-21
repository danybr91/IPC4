package mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Clase que implementa la interfaz grafica de la aplicacion
 * 
 * @author Daniel Belén, Andrés Heredia, Álvaro Sainz, Gabriel Via.
 */
public class MainWrapper extends JFrame implements PropertyChangeListener {

	private static final long serialVersionUID = 5312499194754732142L;
	private JPanel contentPane;
	private JTextField textLocal;
	private JTextField textVisitante;
	private JTextField textFecha;
	private JButton btnGuardar_1;
	private JPanel panel;
	/*
	 * Metodo getters para obtener la informacion de la interfaz y poder almacenarla
	 */
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
					Partido miModelo = new Partido();
					MainWrapper vista = new MainWrapper(miModelo);
					vista.setTitle("Vista 1");
					vista.setGuardarAction(new GuardarAction(miModelo, vista));
					vista.setVisible(true);
					// Segunda ventana
					MainWrapper vista2 = new MainWrapper(miModelo);
					vista2.setGuardarAction(new GuardarAction(miModelo, vista2));
					vista2.setTitle("Vista 2");
					vista2.setLocation(vista.getX()+300, vista.getY());
					vista2.setVisible(true);

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
		setResizable(false);
		// Añadimos listener
		p.addPropertyChangeListener(this);
		
		// Creamos la ventana principal
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 280, 210);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		// Contenedor del formulario
		panel = new JPanel();
		// Borde con título pero sin línea, pues es el único contenido de la
		// ventana. Incorpora un pequeño padding por cuestiones visuales
		panel.setBorder(new TitledBorder(new EmptyBorder(20, 20, 20, 20), 
				"Introduce los datos del partido:", TitledBorder.CENTER, 
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.rowHeights = new int[] {30, 0, 0, 0, 30, 0};
		gbl_panel.columnWidths = new int[] {0, 0};
		gbl_panel.columnWeights = new double[] { 0.0, 1.0 };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel.setLayout(gbl_panel);
		panel.setMaximumSize(getMinimumSize());

		// Etiqueta local y posición en GridLayout
		JLabel lblLocal = new JLabel("Local:");
		GridBagConstraints gbc_lblLocal = new GridBagConstraints();
		gbc_lblLocal.anchor = GridBagConstraints.EAST;
		gbc_lblLocal.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocal.gridx = 0;
		gbc_lblLocal.gridy = 1;
		panel.add(lblLocal, gbc_lblLocal);

		// Cammpo de texto local y posición en GridLayout
		textLocal = new JTextField();
		GridBagConstraints gbc_textLocal = new GridBagConstraints();
		gbc_textLocal.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLocal.insets = new Insets(0, 0, 5, 0);
		gbc_textLocal.gridx = 1;
		gbc_textLocal.gridy = 1;
		panel.add(textLocal, gbc_textLocal);
		textLocal.setColumns(10);

		// Etiqueta visitante y posición en GridLayout
		JLabel lblVisitante = new JLabel("Visitante:");
		GridBagConstraints gbc_lblVisitante = new GridBagConstraints();
		gbc_lblVisitante.anchor = GridBagConstraints.EAST;
		gbc_lblVisitante.insets = new Insets(0, 0, 5, 5);
		gbc_lblVisitante.gridx = 0;
		gbc_lblVisitante.gridy = 2;
		panel.add(lblVisitante, gbc_lblVisitante);

		// Cammpo de texto visitante y posición en GridLayout
		textVisitante = new JTextField();
		GridBagConstraints gbc_textVisitante = new GridBagConstraints();
		gbc_textVisitante.fill = GridBagConstraints.HORIZONTAL;
		gbc_textVisitante.insets = new Insets(0, 0, 5, 0);
		gbc_textVisitante.gridx = 1;
		gbc_textVisitante.gridy = 2;
		panel.add(textVisitante, gbc_textVisitante);
		textVisitante.setColumns(10);

		// Etiqueta Fecha y posición en GridLayout
		JLabel lblFecha = new JLabel("Fecha:");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 3;
		panel.add(lblFecha, gbc_lblFecha);

		// Cammpo de texto Fecha y posición en GridLayout
		textFecha = new JTextField();
		GridBagConstraints gbc_textFecha = new GridBagConstraints();
		gbc_textFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFecha.insets = new Insets(0, 0, 5, 0);
		gbc_textFecha.gridx = 1;
		gbc_textFecha.gridy = 3;
		panel.add(textFecha, gbc_textFecha);
		textFecha.setColumns(10);
		GridBagConstraints gbc_btnGuardar_1 = new GridBagConstraints();
		gbc_btnGuardar_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardar_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnGuardar_1.gridx = 1;
		gbc_btnGuardar_1.gridy = 4;
		
		// Botón que guarda los cambios
		btnGuardar_1 = new JButton("Guardar");
		btnGuardar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		panel.add(btnGuardar_1, gbc_btnGuardar_1);
	}

	/*
	 * ACCION GUARDAR
	 */
	public void setGuardarAction(Action action) {
		btnGuardar_1.setAction(action);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// Actualizamos los datos cuando se dispara el evento
		if (evt.getPropertyName().equals("local")) {
			this.textLocal.setText((String) evt.getNewValue());
		}
		if (evt.getPropertyName().equals("visitante")) {
			this.textVisitante.setText((String) evt.getNewValue());
		}
		if (evt.getPropertyName().equals("fecha")) {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			this.textFecha.setText(df.format((Date) evt.getNewValue()));
		}

	}
}