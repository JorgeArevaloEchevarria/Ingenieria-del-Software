package ninio.vista;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import excepciones.BaseDeDatosException;
import excepciones.CampoVacioException;
import excepciones.ExistenciaException;
import excepciones.InexistenciaException;
import excepciones.TelefonoException;
import ninio.control.ControlNinio;
import transfers.TNinio;

public class GUIAltaNinio extends JPanel{
	private static final long serialVersionUID = 1L;
	
	private ControlNinio c;
	
	public GUIAltaNinio(ControlNinio c){
		
		this.c = c;
		initGUI();
	}
		 
	private void initGUI()
	{
		JFrame frame;
		JPanel paneliz,panelde,panelab,panelar,panelex;
		JLabel nombre,apellidos,telefono, idNinio, nombreTutor,nombrePatologia, movilTutor;
		JTextField text1,text2,text3,text4, text5, text6;
		JButton boton1,boton2;


		frame = new JFrame();
		paneliz  = new JPanel();
		panelde  = new JPanel();
		panelab  = new JPanel();
		panelar  = new JPanel(); 
		panelex = new JPanel();
		nombre = new JLabel();
		apellidos = new JLabel();
		telefono = new JLabel();
		idNinio = new JLabel();
		nombreTutor = new JLabel();
		movilTutor = new JLabel();
		nombrePatologia = new JLabel();

		text1 = new JTextField();
		text2 = new JTextField();
		text3 = new JTextField();
		text4 = new JTextField();
		text5 = new JTextField();
		text6 = new JTextField();

		boton1 = new JButton();
		boton2 = new JButton();

		frame.setTitle("Alta Ni�o");
		frame.setLayout(new FlowLayout());      
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		frame.setResizable(false);
		frame.setSize(400,170);

		nombre.setText("Nombre");
		apellidos.setText("Apellidos");
		telefono.setText("Telefono");
		idNinio.setText("IDNinio");
		nombreTutor.setText("Nombre Tutor");
		movilTutor.setText("Movil Tutor");
		nombrePatologia.setText("Patologia");

		boton1.setText("Aceptar");
		boton2.setText("Cancelar");

		paneliz.setLayout(new GridLayout(7,0));
		paneliz.add(nombre);
		paneliz.add(apellidos);
		paneliz.add(telefono);
		paneliz.add(nombreTutor);
		paneliz.add(movilTutor);
		paneliz.add(nombrePatologia);


		panelde.setLayout(new GridLayout(7,0));
		panelde.add(text1);
		panelde.add(text2);
		panelde.add(text3);
		panelde.add(text4);
		panelde.add(text5);
		panelde.add(text6);

		panelar.setLayout(new GridLayout(1,1));
		panelar.setPreferredSize(new Dimension(350,100));
		panelar.add(paneliz);
		panelar.add(panelde);

		panelab.setLayout(new FlowLayout());
		panelab.setPreferredSize(new Dimension(200,50));
		panelab.add(boton1);
		panelab.add(boton2);

		panelex.setLayout(new GridLayout(2,0));
		panelex.add(panelar);
		panelex.add(panelab);

		frame.add(panelex);

		boton1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				TNinio n = new TNinio(text1.getText(),text2.getText(),text3.getText(),text4.getText(),text5.getText(),text6.getText());
				
				try{c.altaNinio(n);}
				catch (CampoVacioException | InexistenciaException | ExistenciaException | BaseDeDatosException | TelefonoException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}

		});
		
		boton2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.setVisible(false);
				frame.dispose();
			}
			
		});

	}
}

