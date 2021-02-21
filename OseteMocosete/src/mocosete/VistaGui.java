package mocosete;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ninio.control.ControlNinio;
import ninio.vista.GUIConsultarNinio;
import patologia.control.ControlPatologia;
import patologia.vistas.GUIConsultarPatologia;

public class VistaGui extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static Stack<JPanel> paneles;
	private ControlPatologia controlPatologia;
	private ControlNinio controlNinio;
	
	private Container contenedor;
	private JPanel panelPrincipal;
	private JPanel panelBotones;
	private JButton botonNinios;
	private JButton botonSalir;
	private JButton botonPatologias;
	
	public VistaGui(ControlPatologia controlPatologia, ControlNinio controlNinio)
	{
		//Poner Título
		super("Osete Mocosete");
		
		//Poner FavIcon
		paneles = new Stack<JPanel>();
		Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("imagenes/favicon.png"));
	    setIconImage(icon);
	    this.controlPatologia = controlPatologia;
	    this.controlNinio = controlNinio;
	    //Inicializamos la ventana
	    initGUI();
	    
	    //Inicializamos los eventos
	    confEventos();
	    
	    this.pack();
	    this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void metePila(JPanel panel){paneles.push(panel);}
	
	public static JPanel sacaPila(){return paneles.pop();}
	
	public boolean pilaVacia() {return paneles.isEmpty();}

	private void initGUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.contenedor = getContentPane();
		this.panelPrincipal = new JPanel(new BorderLayout());
		initPanelPrincipal();
		this.panelPrincipal.setPreferredSize(new Dimension(600, 420));
		this.panelPrincipal.setBackground(Color.WHITE);
		this.contenedor.add(this.panelPrincipal);
		this.contenedor.setVisible(true);
		
	}

	private void initPanelPrincipal()
	{
		initIcono();
		initPanelBotones();
	}

	private void initIcono()
	{
		ImageIcon imagen = new ImageIcon(getClass().getResource("imagenes/icono.png"));
		JLabel icono = new JLabel(imagen); 
		this.panelPrincipal.add(icono,BorderLayout.WEST);
	}
	
	private void initPanelBotones()
	{
		this.panelBotones = new JPanel(new GridBagLayout());
		initBotonNinio();
		initBotonPatologia();
		initBotonSalir();
		this.panelBotones.setBackground(Color.WHITE);
		this.panelPrincipal.add(this.panelBotones, BorderLayout.CENTER);
	}

	private void initBotonNinio()
	{
		this.botonNinios = new JButton("        Niños          ");
		this.panelBotones.add(this.botonNinios,constraints(0,0,150,100));
	}

	private void initBotonPatologia()
	{
		this.botonPatologias = new JButton("    Patologias      ");
		this.panelBotones.add(this.botonPatologias,constraints(0,0,0,97));
	}

	private void initBotonSalir()
	{
		this.botonSalir = new JButton("Salir");
		
		this.panelBotones.add(this.botonSalir,constraints(350,150,0,0));
	}
	
	private GridBagConstraints constraints(int i, int j, int k, int l)
	{
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(i,j, k, l);
		constraints.gridx = 0; 
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		constraints.gridheight = 1;
		constraints.anchor = GridBagConstraints.CENTER;
		return constraints;
	}

	private void confEventos()
	{
		this.botonNinios.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){ponerPConsultarNinios();}
		});
		
		this.botonPatologias.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e){ponerPConsultarPatologias();}
		});
		
		this.botonSalir.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(1);
			}
		});
	}

	private void ponerPConsultarPatologias()
	{
		if(!paneles.empty()){
			while(!paneles.empty()){
				paneles.pop();
			}
		}
		this.contenedor.removeAll();
		GUIConsultarPatologia pConsultarPatologia = new GUIConsultarPatologia(this.controlPatologia,this);
		VistaGui.metePila(this.panelPrincipal);
		this.add(pConsultarPatologia);
		revalidate();
		this.pack();
		this.setLocationRelativeTo(null);
	}

	private void ponerPConsultarNinios()
	{
		if(!paneles.empty()){
			while(!paneles.empty()){
				paneles.pop();
			}
		}
		this.contenedor.removeAll();
		GUIConsultarNinio pConsultarNinio = new GUIConsultarNinio(this.controlNinio, this.controlPatologia, this);
		VistaGui.metePila(this.panelPrincipal);
		this.add(pConsultarNinio);
		revalidate();
		this.pack();
		this.setLocationRelativeTo(null);
	}
}