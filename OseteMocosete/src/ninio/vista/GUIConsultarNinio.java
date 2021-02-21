package ninio.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import excepciones.BaseDeDatosException;
import mocosete.VistaGui;
import ninio.control.ControlNinio;
import patologia.control.ControlPatologia;
import patologia.vistas.GUIAltaPatologia;
import patologia.vistas.GUIMostrarPatologia;
import transfers.TNinio;

public class GUIConsultarNinio extends JPanel{
	
	
	private static final long serialVersionUID = 1L;
	private JTextArea infoNinio;

	

	public GUIConsultarNinio(ControlNinio controlNinio, ControlPatologia controlPatologia, VistaGui vistaGui) {
		// TODO Auto-generated constructor stub
	}
	
	private ControlNinio controlninio;
	
	private ControlPatologia controlPatologia;
	
	private VistaGui ventanaPrincipal;

	private JButton botonFiltro;

	private JTextField textoFiltro;
	
	private JList<String> patologias;

	private JScrollPane listaPatologias;

	private JPanel panelFiltro;

	private JPanel panelLista;

	private JButton botonAtras;

	private JPanel panelBotones;

	private JButton botonMostrar;

	private JButton botonBaja;

	private JButton botonAlta;
	
	
	public GUIConsultarNinio(ControlPatologia controlPatologia, VistaGui vistaGui)
	{
		this.controlPatologia = controlPatologia;
		this.ventanaPrincipal = vistaGui;
		
		initGUI();
		
		confEventos();
	}

	private void initGUI()
	{
		initPanelPrincipal();
		this.setPreferredSize(new Dimension(600, 420));
		this.setBackground(Color.WHITE);
	}

	private void initPanelPrincipal()
	{
		initPanelLista();
		initPanelBotones();
	}

	private void initPanelLista()
	{
		this.panelLista = new JPanel(new BorderLayout());
		initPanelFiltro();
		initPanelListaPatologias();
		this.add(this.panelLista, BorderLayout.CENTER);
	}
	
	private void initPanelFiltro()
	{
		this.panelFiltro = new JPanel();
		initTextoFiltro();
		initBotonFiltro();
		this.panelFiltro.setBackground(Color.WHITE);
		this.panelLista.add(this.panelFiltro, BorderLayout.NORTH);
	}

	private void initTextoFiltro()
	{
		this.textoFiltro = new JTextField();
		this.textoFiltro.setPreferredSize(new Dimension(100, 22));;

		this.panelFiltro.add(this.textoFiltro);
	}

	private void initBotonFiltro()
	{
		this.botonFiltro = new JButton("Filtro");
		
		this.panelFiltro.add(this.botonFiltro);
		
	}
	private void initPanelListaPatologias()
	{
		this.listaPatologias = new JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		try{this.patologias = this.controlPatologia.consultarPatologias();}
		catch (BaseDeDatosException e)
		{
			e.printStackTrace();
		}
		this.listaPatologias.setPreferredSize(new Dimension(200, 300));
		this.listaPatologias.setViewportView(this.patologias);
		
		this.panelLista.add(this.listaPatologias, BorderLayout.CENTER);
	}
	
	private void initPanelBotones()
	{
		this.panelBotones = new JPanel(new GridLayout(4,1));
		this.panelBotones.setPreferredSize(new Dimension(200, 250));
		initBotonAlta();
		initBotonBaja();
		initBotonModificar();
		initBotonAtras();
		this.add(this.panelBotones,BorderLayout.EAST);
	}

	private void initBotonAlta()
	{
		this.botonAlta = new JButton("Alta patología");
		this.panelBotones.add(this.botonAlta);
	}

	private void initBotonBaja()
	{
		this.botonBaja = new JButton("Baja patología");
		this.botonBaja.setEnabled(false);
		this.panelBotones.add(this.botonBaja);
	}

	private void initBotonModificar()
	{
		this.botonMostrar = new JButton("Mostrar patología");
		this.botonMostrar.setEnabled(false);
		this.panelBotones.add(this.botonMostrar);
	}

	private void initBotonAtras()
	{
		this.botonAtras = new JButton("Atrás");
		this.panelBotones.add(this.botonAtras);
	}
	
	private void confEventos()
	{
		patologias.addListSelectionListener(new ListSelectionListener()
		{
			public void valueChanged(ListSelectionEvent e)
			{
				botonMostrar.setEnabled(true);
				botonBaja.setEnabled(true);
			}
		});
		botonAlta.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				GUIAltaPatologia altaPatologia = new GUIAltaPatologia(controlPatologia,ventanaPrincipal);
				meteAlaPila();
				remove();
				ventanaPrincipal.add(altaPatologia);
				revalidate();
				ventanaPrincipal.pack();
				ventanaPrincipal.setLocationRelativeTo(null);
			}
        });
		botonMostrar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String e = (String) patologias.getSelectedValue();
				GUIMostrarPatologia muestraPatologia = new GUIMostrarPatologia(e,controlPatologia,ventanaPrincipal);
				meteAlaPila();
				remove();
				ventanaPrincipal.add(muestraPatologia);
				revalidate();
				ventanaPrincipal.pack();
				ventanaPrincipal.setLocationRelativeTo(null);
			}
        });
		this.botonAtras.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					String nick = (String) patologias.getSelectedValue();
					if(nick != null)
					{
						int opcion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar la patología?." + "\n", "Confirmación", JOptionPane.YES_NO_OPTION);
						if(opcion == JOptionPane.YES_OPTION)
						{
							controlPatologia.bajaPatologia(nick);
							JOptionPane.showMessageDialog(null, "La patología ha sido eliminada", "Correcto", JOptionPane.CLOSED_OPTION);
						}
					}
					
					patologias = controlPatologia.consultarPatologias();
					listaPatologias.setViewportView(patologias);
				}
				catch(BaseDeDatosException e){};
			}
        });
		this.botonFiltro.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				String filtro = textoFiltro.getText();
				
				try {patologias = controlPatologia.consultarPatologiaFiltros(filtro);}
				catch (BaseDeDatosException e){}
				listaPatologias.setViewportView(patologias);
			}
        });
		this.botonAtras.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				remove();
			    ventanaPrincipal.add(VistaGui.sacaPila());
				revalidate();
				ventanaPrincipal.pack();
				ventanaPrincipal.setLocationRelativeTo(null);				
			}
        });
	}
	
	private void remove(){this.ventanaPrincipal.remove(this);}
	
	private void meteAlaPila(){VistaGui.metePila(this);}
}
}
