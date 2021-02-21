package patologia.vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import enumerados.Peligrosidad;
import excepciones.BaseDeDatosException;
import excepciones.CampoVacioException;
import excepciones.ExistenciaException;
import mocosete.VistaGui;
import patologia.control.ControlPatologia;
import transfers.TPatologia;

public class GUIAltaPatologia extends JPanel
{
	private static final long serialVersionUID = 1L;
	private ControlPatologia control;
	private VistaGui ventana;
	
	///// Componentes
	private JLabel nombrePato,nombrePeli,tituloDescrip;
	///// paneles principales de la ventana
	private JPanel panelNombre, panelPeli, panelDescripcion, panelBotones;
	///// panel auxiliar de la descripcion
	private JPanel panelTextoDescrip;
	///// paneles auxiliares para la ordenacion
	private JPanel auxN,auxS;
	private JTextField cNombre;
	private JComboBox<Peligrosidad> cbPeli;
	private JTextArea textoDescrip;
	private JScrollPane scrollDP;
	private JTextField textoField;
	private JButton botonAlta,botonAtras;
	
	private String nombre,peligro,descrip;
	
	///// Constructor
	public GUIAltaPatologia(ControlPatologia controlador, VistaGui v) {
		this.control = controlador;
		this.ventana = v;
		
		configurarPanel();
		configurarEventos();
	}

	private void configurarEventos() {
		ponerEscuchaBotonAceptar();
		ponerEscuchaBotonCancelar();
	}

	private void ponerEscuchaBotonCancelar()
	{
		this.botonAtras.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				volverVentanaAnterior();				
			}
        });
	}

	private void remove(){
		this.ventana.remove(this);
	}

	private void volverVentanaAnterior(){
		remove();
	    ventana.add(VistaGui.sacaPila());
		revalidate();
		ventana.pack();
		ventana.setLocationRelativeTo(null);
	}
	
	private void ponerEscuchaBotonAceptar() 
	{		
		this.botonAlta.addActionListener(new ActionListener(){
		private TPatologia patologiaNueva;

			public void actionPerformed(ActionEvent arg0) 
			{
				recogidaDatosPato();
				patologiaNueva = new TPatologia(nombre,peligro,descrip);
				
				try {
					control.altaPatologia(patologiaNueva);
					JOptionPane.showMessageDialog(null, "La patologia ha sido registrado", "Correcto", JOptionPane.CLOSED_OPTION);
					volverVentanaAnterior();
				} 
				catch (CampoVacioException | ExistenciaException | BaseDeDatosException e)
				{
					JOptionPane.showMessageDialog(null, "Datos erroneos", "ERROR", JOptionPane.ERROR_MESSAGE);
				}					
			}
        });
	}

	private void recogidaDatosPato(){
		nombre = (String) this.textoField.getText();
		peligro = (String) this.cbPeli.getSelectedItem();
		descrip = (String) this.textoDescrip.getText();        
	}
	private void configurarPanel() {
		this.setPreferredSize(new Dimension(600,420));
		this.setBackground(Color.WHITE);
		//this.setLayout(new BorderLayout());
		this.auxN = new JPanel(new BorderLayout());
		this.auxS = new JPanel(new BorderLayout());
		
		this.auxN.add(panelNombre(),BorderLayout.NORTH);
		this.auxN.add(panelPeligrosidad(),BorderLayout.SOUTH);
		this.auxS.add(descripPato(),BorderLayout.NORTH);
		this.auxS.add(panelBotons(),BorderLayout.SOUTH);
		
		//this.add(this.auxN,BorderLayout.NORTH);
		//this.add(this.auxS,BorderLayout.CENTER);
		this.add(this.auxN);
		this.add(this.auxS);
	}
	///// Panel donde se escribe el nombre de la nueva patologia
	private JPanel panelNombre()
	{
		this.panelNombre = new JPanel(new BorderLayout());
		this.nombrePato = new JLabel("Nombre de la patologia : ");		
		this.cNombre = new JTextField();		
		this.cNombre.setColumns(20);
		
		this.panelNombre.setBackground(Color.WHITE);
		this.panelNombre.add(this.nombrePato,BorderLayout.CENTER);
		this.panelNombre.add(this.cNombre,BorderLayout.EAST);
		
		return this.panelNombre;
	}
	///// Panel donde se elige la peligrosidad
	private JPanel panelPeligrosidad()
	{
		this.panelPeli = new JPanel(new BorderLayout());
		this.cbPeli = new JComboBox<Peligrosidad>();
		this.cbPeli.setModel(new DefaultComboBoxModel<Peligrosidad>(Peligrosidad.values()));
		this.cbPeli.setBackground(Color.WHITE);
		this.nombrePeli = new JLabel("Elige el grado de peligrosidad : ");
		
		this.panelPeli.setBackground(Color.WHITE);		
		this.panelPeli.add(this.cbPeli,BorderLayout.CENTER);
		this.panelPeli.add(this.nombrePeli,BorderLayout.WEST);
		
		return this.panelPeli;
	}
	///// Panel donde va a ir la descripcion de la patología
	private JPanel descripPato()
	{
		this.panelDescripcion = new JPanel(new BorderLayout());
		this.tituloDescrip = new JLabel("Agrega una descripcion a la patologia : ");
		this.textoDescrip = new JTextArea();
		this.textoDescrip.setBackground(Color.WHITE);
		this.scrollDP = new JScrollPane(this.textoDescrip);
		this.panelTextoDescrip = new JPanel();
		
		this.scrollDP.setPreferredSize(new Dimension(400,300));
		this.panelTextoDescrip.add(this.scrollDP);		
		
		this.textoDescrip.setEditable(true);
		this.textoDescrip.setLineWrap(true);
		this.textoDescrip.setWrapStyleWord(true);	
		
		this.panelDescripcion.add(this.tituloDescrip,BorderLayout.NORTH);
		this.panelDescripcion.add(this.panelTextoDescrip,BorderLayout.SOUTH);
		this.panelDescripcion.setBackground(Color.WHITE);		
		return this.panelDescripcion;
	}
	///// Panel donde van los botones
	private JPanel panelBotons()
	{
		this.panelBotones = new JPanel(new BorderLayout());
		this.botonAlta = new JButton("Aceptar");	
		this.botonAtras = new JButton("Cancelar");
		
		this.panelBotones.add(this.botonAlta,BorderLayout.EAST);
		this.panelBotones.add(this.botonAtras,BorderLayout.WEST);
		this.panelBotones.setBackground(Color.WHITE);
		return this.panelBotones;
	}
}
