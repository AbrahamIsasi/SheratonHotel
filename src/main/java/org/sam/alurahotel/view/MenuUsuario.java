package org.sam.alurahotel.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MenuUsuario extends JFrame {

	private JPanel contentPane;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel labelRegistro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuUsuario frame = new MenuUsuario();
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
	public MenuUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuUsuario.class.getResource("/imagenes/aH-40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 609);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(12, 138, 199));
		panelMenu.setBounds(0, 0, 257, 609);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(50, 58, 150, 150);
		panelMenu.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/aH-150px.png")));
		
		JPanel btnRegistro = new JPanel();
		btnRegistro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistro.setBackground(new Color(118, 187, 223));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistro.setBackground(new Color(12, 138, 199));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ReservasView reservas = new ReservasView();
				reservas.setVisible(true);
				dispose();
			}
		});
		btnRegistro.setBounds(0, 255, 257, 56);
		btnRegistro.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnRegistro);
		btnRegistro.setLayout(null);
		
		labelRegistro = new JLabel("Registro de reservas");
		labelRegistro.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/reservado.png")));
		labelRegistro.setForeground(SystemColor.text);
		labelRegistro.setBounds(25, 11, 205, 34);
		labelRegistro.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		labelRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistro.add(labelRegistro);
		
		JPanel btnBusqueda = new JPanel();
		btnBusqueda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBusqueda.setBackground(new Color(118, 187, 223));				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBusqueda.setBackground(new Color(12, 138, 199));	
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				Busqueda busqueda = new Busqueda();
				busqueda.setVisible(true);
				dispose();
			}
		});
		btnBusqueda.setBounds(0, 312, 257, 56);
		btnBusqueda.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnBusqueda);
		btnBusqueda.setLayout(null);
		
		JLabel lblBusquedaDeReservas = new JLabel("Búsqueda");
		lblBusquedaDeReservas.setIcon(new ImageIcon(MenuUsuario.class.getResource("/imagenes/pessoas.png")));
		lblBusquedaDeReservas.setBounds(27, 11, 200, 34);
		lblBusquedaDeReservas.setHorizontalAlignment(SwingConstants.LEFT);
		lblBusquedaDeReservas.setForeground(Color.WHITE);
		lblBusquedaDeReservas.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		btnBusqueda.add(lblBusquedaDeReservas);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 219, 201, 2);
		panelMenu.add(separator);
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 944, 36);
		contentPane.add(header);
		
		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				 btnexit.setBackground(Color.white);
			     labelExit.setForeground(Color.black);
			}
		});
		
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(891, 0, 53, 36);
		header.add(btnexit);
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Ubuntu", Font.PLAIN, 18));
		
	    JPanel panelFecha = new JPanel();
	    panelFecha.setBackground(new Color(118, 187, 223));
	    panelFecha.setBounds(256, 84, 688, 121);
	    contentPane.add(panelFecha);
	    panelFecha.setLayout(null);
	    
	    JLabel lblNewLabel_1 = new JLabel("Sistema de reservas Sheraton Hotel");
	    lblNewLabel_1.setBounds(170, 11, 400, 42);
	    panelFecha.add(lblNewLabel_1);
	    lblNewLabel_1.setForeground(Color.WHITE);
	    lblNewLabel_1.setFont(new Font("Ubuntu", Font.PLAIN, 24));
	    
	    JLabel labelFecha = new JLabel("New label");
	    labelFecha.setBounds(35, 64, 294, 36);
	    panelFecha.add(labelFecha);
	    labelFecha.setForeground(Color.WHITE);
	    labelFecha.setFont(new Font("Ubuntu", Font.PLAIN, 33));
	    Date fechaActual = new Date(); //fecha y hora actual
	    String fecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaActual); //formatear la fecha en una cadena
	    labelFecha.setText("Hoy es " + fecha); //setear la representacion en cadena de la fecha
	    
	    JLabel lblNewLabel = new JLabel("Bienvenido");
	    lblNewLabel.setFont(new Font("Ubuntu", Font.BOLD, 24));
	    lblNewLabel.setBounds(302, 200, 147, 46);
	    contentPane.add(lblNewLabel);
	    
	    String textoDescripcion = "<html><body>El Sheraton es una cadena de hoteles de lujo reconocida por su elegancia y altos estándares de servicio. Ubicado en zonas estratégicas de grandes ciudades, cada hotel de la cadena ofrece una experiencia sofisticada.</body></html>";
	    JLabel labelDescripcion = new JLabel(textoDescripcion);
	    labelDescripcion.setFont(new Font("Ubuntu", Font.PLAIN, 17));
	    labelDescripcion.setBounds(312, 250, 598, 80);//66
	    contentPane.add(labelDescripcion);
	    
	    String textoDescripcion1 = "<html><body>Tenemos un espacio privado que permite acceso a salas de reunión, desayunos complementarios y áreas de trabajo, ideal para combinar placer y productividad en un ambiente exclusivo y tranquilo. Todo esto hace que el Sheraton sea una opción preferida para quienes buscan comodidad y lujo. </body></html>";
	    JLabel labelDescripcion_1 = new JLabel(textoDescripcion1);
	    labelDescripcion_1.setFont(new Font("Ubuntu", Font.PLAIN, 17));
	    labelDescripcion_1.setBounds(311, 339, 569, 88);
	    contentPane.add(labelDescripcion_1);
	    
	    JLabel lblNewLabel_3 = new JLabel("1.- Habitaciones y Suites de Lujo:");
	    lblNewLabel_3.setFont(new Font("Ubuntu", Font.PLAIN, 17));
	    lblNewLabel_3.setBounds(312, 444, 295, 27);
	    contentPane.add(lblNewLabel_3);
	    
	    JLabel lblNewLabel_3_1 = new JLabel("2.- Restaurantes y Bares:");
	    lblNewLabel_3_1.setFont(new Font("Ubuntu", Font.PLAIN, 17));
	    lblNewLabel_3_1.setBounds(312, 474, 355, 27);
	    contentPane.add(lblNewLabel_3_1);

	    JLabel lblNewLabel_3_2 = new JLabel("3.- Sheraton Club (para miembros y huéspedes en suites:");
	    lblNewLabel_3_2.setFont(new Font("Ubuntu", Font.PLAIN, 17));
	    lblNewLabel_3_2.setBounds(312, 504, 355 , 27);
	    contentPane.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("4.- Centro de Bienestar y Fitness:");
		lblNewLabel_3_3.setFont(new Font("Ubuntu", Font.PLAIN, 17));
		lblNewLabel_3_3.setBounds(312, 534, 295, 27);
		contentPane.add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_4 = new JLabel("5.- Piscinas y Áreas Recreativas:");
		lblNewLabel_3_4.setFont(new Font("Ubuntu", Font.PLAIN, 17));
		lblNewLabel_3_4.setBounds(312, 564, 295, 27);
		contentPane.add(lblNewLabel_3_4);
	}
	
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_headerMousePressed

    private void headerMouseDragged(java.awt.event.MouseEvent evt) {
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }
}
