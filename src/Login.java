import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.math.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JToolBar;
import javax.swing.JProgressBar;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;



public class Login extends JFrame {

	public static final String JDBC_DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:basededados.sqlite";
	private JTextField username;
	private JTextField password;
	private JPanel menu;
	private JPanel menu2;
	private JTable table;
	public static int id_epoca = 3;
	public static int id_equipa = 1;
	public static int id_jogador;
	public static int id_jogo;
	public static int empate = 0;
	public static String autogolo = "NAO";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox comboBox1;
	private JTable table2;
	private JComboBox comboBox2;
	private JTextField Txt;
	private JTable table3;
	private JComboBox comboBox3;
	private JTable table4;
	private JTextField Txt2;
	private JTable table5;
	private JTextField Rnd_ep;
	private JTextField Des_ep;
	private JTextField Di_ep;
	private JTextField Df_ep;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JComboBox comboBox_editar_ep;
	private JComboBox comboBox_eliminar_ep;
	private JTextField Rnd_eq;
	private JTextField Nde_eq;
	private JTextField Ndes_eq;
	private JTextField Ddf_eq;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JComboBox comboBox_editar_eq;
	private JComboBox comboBox_eliminar_eq;
	private JTextField Ndj_jgd;
	private JTextField Ddn_jgd;
	private JTextField Pdj_jgd;
	private JTextField textField_10;
	private JTextField textField_12;
	private JTextField textField_11;
	private JTextField Ndj_editar_jgd;
	private JTextField Jgd_eliminar;
	private JTextField Rnd_jg;
	private JTextField Ddj_jg;
	private JTextField Jogo_eliminar;
	private JComboBox golos_v;
	private JComboBox comboBox_add_ec;
	private JComboBox comboBox_add_v;
	private JTextField vitoria_jg;
	private JTextField derrota_jg;
	private JComboBox Eq_jgd;
	private JTextField textField_e;
	private JCheckBox chck_empate;
	private JComboBox marcador_Equipa;
	private JComboBox marcador_Jogador;
	private JTextField marcador_Minuto;
	private JTextField marcador_Eliminar;
	private JComboBox marcador_IDjogo;
	private JTextField ttl_Golos;
	private JTextField ttl_Autogolos;
	private JTextField melhor_Marcador;
	private JTextField mm_Golos;
	private JTextField mm_MediaMinutosGolos;
	private JComboBox estat_Equipa;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagens\\logo.jpg"));
		setResizable(false);
		setTitle("TP - Complementos de Programa\u00E7\u00E3o");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 439);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		setLocationRelativeTo(null);
		
		JPanel login = new JPanel();
		login.setBackground(Color.WHITE);
		contentPane.add(login, "name_951077403946935");
		login.setLayout(null);
		
		username = new JTextField();
		username.setForeground(new Color(0, 0, 204));
		username.setBounds(173, 51, 112, 20);
		login.add(username);
		username.setColumns(10);
		
		
		password = new JPasswordField();
		password.setForeground(new Color(0, 0, 204));
		password.setBounds(173, 97, 112, 20);
		login.add(password);
		password.setColumns(10);
		
		
		
		JButton btnSign = new JButton("Entrar");
		btnSign.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					String user = username.getText();
					String pass = password.getText();
					
					if (user.equals("admin") && pass.equals("admin")){
						username.setText("");
						password.setText("");
						login.setVisible(false);
						menu.setVisible(true);
						//setBounds(100, 100, 500, 400);
						
						 //Ligação à base de dados.
						Connection conn = null;
						
						try{
							   Class.forName(JDBC_DRIVER); 
							   conn = DriverManager.getConnection(DB_URL);
						}catch(SQLException se){
							   se.printStackTrace();
						}catch(Exception e1){
							   e1.printStackTrace();
						}
						
						  //Carrega os dados para comboBox (Administrator-Epoca-Designacao)
						try{
							
					   		DefaultComboBoxModel cb = (DefaultComboBoxModel) comboBox_editar_ep.getModel();
					   		DefaultComboBoxModel cb2 = (DefaultComboBoxModel) comboBox_eliminar_ep.getModel();
					   		cb.removeAllElements();
							cb2.removeAllElements();
							
							Statement st = conn.createStatement();
							ResultSet rs = st.executeQuery("SELECT * FROM Epoca");
							
						   	while(rs.next()){
						   		cb.addElement(rs.getString("designacao"));
						   		cb2.addElement(rs.getString("designacao"));
						   	}		
						   	
						}catch(SQLException se){
							   se.printStackTrace();
						}
						
						try{
							   Class.forName(JDBC_DRIVER); 
							   conn = DriverManager.getConnection(DB_URL);
						}catch(SQLException se){
							   se.printStackTrace();
						}catch(Exception e1){
							   e1.printStackTrace();
						}
						
						  //Carrega os dados para comboBox (Administrator-Equipa-Nome da Equipa)
						try{
							
					   		DefaultComboBoxModel cb = (DefaultComboBoxModel) comboBox_editar_eq.getModel();
					   		DefaultComboBoxModel cb2 = (DefaultComboBoxModel) comboBox_eliminar_eq.getModel();
					   		cb.removeAllElements();
							cb2.removeAllElements();
							
							Statement st = conn.createStatement();
							ResultSet rs = st.executeQuery("SELECT * FROM Equipa");
							
						   	while(rs.next()){
						   		cb.addElement(rs.getString("nome_equipa"));
						   		cb2.addElement(rs.getString("nome_equipa"));
						   	}		
						   	
						}catch(SQLException se){
							   se.printStackTrace();
						}
						
						  //Carrega os dados para as comboBox (Administrator-Jogo-Nome da Equipa)
						try{
							
					   		DefaultComboBoxModel cb = (DefaultComboBoxModel) comboBox_add_ec.getModel();
					   		DefaultComboBoxModel cb2 = (DefaultComboBoxModel) comboBox_add_v.getModel();
					   		

					   		cb.removeAllElements();
							cb2.removeAllElements();
							
							Statement st = conn.createStatement();
							ResultSet rs = st.executeQuery("SELECT * FROM Equipa");
							
						   	while(rs.next()){
						   		cb.addElement(rs.getString("nome_equipa"));
						   		cb2.addElement(rs.getString("nome_equipa"));
					 
						   	}		
						   	
						}catch(SQLException se){
							   se.printStackTrace();
						}
						
						//Carrega os dados para as comboBox (Administrator-Jogador-Nome da Equipa)
						try{
							
					   		DefaultComboBoxModel cb = (DefaultComboBoxModel) Eq_jgd.getModel();				  
					   		cb.removeAllElements();
							
							Statement st = conn.createStatement();
							ResultSet rs = st.executeQuery("SELECT * FROM Equipa");
							
						   	while(rs.next()){
						   		cb.addElement(rs.getString("nome_equipa"));
					 
						   	}		
						   	
						}catch(SQLException se){
							   se.printStackTrace();
						}
						
						//Carrega os dados para as comboBox (Administrator-Marcador-Equipa)
						try{
							
					   		DefaultComboBoxModel cb = (DefaultComboBoxModel) marcador_Equipa.getModel();				  
					   		cb.removeAllElements();
							
							Statement st = conn.createStatement();
							ResultSet rs = st.executeQuery("SELECT * FROM Equipa");
							
						   	while(rs.next()){
						   		cb.addElement(rs.getString("nome_equipa"));
					 
						   	}		
						   	
						}catch(SQLException se){
							   se.printStackTrace();
						}
						
						//Carrega os dados para as comboBox (Administrator-Marcador-Plantel)
						try{
							
					   		DefaultComboBoxModel cb = (DefaultComboBoxModel) marcador_Jogador.getModel();				  
					   		cb.removeAllElements();
							
							Statement st = conn.createStatement();
							ResultSet rs = st.executeQuery("SELECT DISTINCT Jogador.nome_jogador FROM Plantel JOIN Jogador ON Plantel.id_jogador = Jogador.id_jogador WHERE Jogador.equipa = 'Sporting' ");
							
						   	while(rs.next()){
						   		cb.addElement(rs.getString("nome_jogador"));
					 
						   	}		
						   	
						}catch(SQLException se){
							   se.printStackTrace();
						}
						
						//Carrega os dados para as comboBox (Administrator-Marcador-IDjogo)
						try{
							
					   		DefaultComboBoxModel cb = (DefaultComboBoxModel) marcador_IDjogo.getModel();				  
					   		cb.removeAllElements();
							
							Statement st = conn.createStatement();
							ResultSet rs = st.executeQuery("SELECT * FROM Jogo ");
							
						   	while(rs.next()){
						   		cb.addElement(rs.getString("id_jogo"));
					 
						   	}		
						   	
						}catch(SQLException se){
							   se.printStackTrace();
						}
						
						
					}else{
						JOptionPane.showMessageDialog(null, "Dados incorretos!");
					}
				}
			}
		});
		btnSign.setForeground(new Color(0, 0, 102));
		btnSign.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnSign.setBackground(new Color(153, 153, 204));
		btnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = username.getText();
				String pass = password.getText();
				
				if (user.equals("admin") && pass.equals("admin")){
					username.setText("");
					password.setText("");
					login.setVisible(false);
					menu.setVisible(true);
					
					 //Ligação à base de dados.
					Connection conn = null;
					
					try{
						   Class.forName(JDBC_DRIVER); 
						   conn = DriverManager.getConnection(DB_URL);
					}catch(SQLException se){
						   se.printStackTrace();
					}catch(Exception e1){
						   e1.printStackTrace();
					}
					
					  //Carrega os dados para comboBox (Administrator-Epoca-Designacao)
					try{
						
				   		DefaultComboBoxModel cb = (DefaultComboBoxModel) comboBox_editar_ep.getModel();
				   		DefaultComboBoxModel cb2 = (DefaultComboBoxModel) comboBox_eliminar_ep.getModel();
				   		cb.removeAllElements();
						cb2.removeAllElements();
						
						Statement st = conn.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM Epoca");
						
					   	while(rs.next()){
					   		cb.addElement(rs.getString("designacao"));
					   		cb2.addElement(rs.getString("designacao"));
					   	}		
					   	
					}catch(SQLException se){
						   se.printStackTrace();
					}
					
					try{
						   Class.forName(JDBC_DRIVER); 
						   conn = DriverManager.getConnection(DB_URL);
					}catch(SQLException se){
						   se.printStackTrace();
					}catch(Exception e1){
						   e1.printStackTrace();
					}
					
					  //Carrega os dados para comboBox (Administrator-Equipa-Nome da Equipa)
					try{
						
				   		DefaultComboBoxModel cb = (DefaultComboBoxModel) comboBox_editar_eq.getModel();
				   		DefaultComboBoxModel cb2 = (DefaultComboBoxModel) comboBox_eliminar_eq.getModel();
				   		cb.removeAllElements();
						cb2.removeAllElements();
						
						Statement st = conn.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM Equipa");
						
					   	while(rs.next()){
					   		cb.addElement(rs.getString("nome_equipa"));
					   		cb2.addElement(rs.getString("nome_equipa"));
					   	}		
					   	
					}catch(SQLException se){
						   se.printStackTrace();
					}
					
					  //Carrega os dados para as comboBox (Administrator-Jogo-Nome da Equipa)
					try{
						
				   		DefaultComboBoxModel cb = (DefaultComboBoxModel) comboBox_add_ec.getModel();
				   		DefaultComboBoxModel cb2 = (DefaultComboBoxModel) comboBox_add_v.getModel();

				   		cb.removeAllElements();
						cb2.removeAllElements();
						
						Statement st = conn.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM Equipa");
						
					   	while(rs.next()){
					   		cb.addElement(rs.getString("nome_equipa"));
					   		cb2.addElement(rs.getString("nome_equipa"));
				 
					   	}		
					   	
					}catch(SQLException se){
						   se.printStackTrace();
					}
					
					//Carrega os dados para as comboBox (Administrator-Jogador-Equipa)
					try{
						
				   		DefaultComboBoxModel cb = (DefaultComboBoxModel) Eq_jgd.getModel();				  
				   		cb.removeAllElements();
						
						Statement st = conn.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM Equipa");
						
					   	while(rs.next()){
					   		cb.addElement(rs.getString("nome_equipa"));
				 
					   	}		
					   	
					}catch(SQLException se){
						   se.printStackTrace();
					}
					
					//Carrega os dados para as comboBox (Administrator-Marcador-Equipa)
					try{
						
				   		DefaultComboBoxModel cb = (DefaultComboBoxModel) marcador_Equipa.getModel();				  
				   		cb.removeAllElements();
						
						Statement st = conn.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM Equipa");
						
					   	while(rs.next()){
					   		cb.addElement(rs.getString("nome_equipa"));
				 
					   	}		
					   	
					}catch(SQLException se){
						   se.printStackTrace();
					}
					
					//Carrega o Plantel da equipa Sporting (inicial) (Administrator-Marcador-Plantel)
					try{
						
				   		DefaultComboBoxModel cb = (DefaultComboBoxModel) marcador_Jogador.getModel();				  
				   		cb.removeAllElements();
						
						Statement st = conn.createStatement();
						ResultSet rs = st.executeQuery("SELECT DISTINCT Jogador.nome_jogador FROM Plantel JOIN Jogador ON Plantel.id_jogador = Jogador.id_jogador WHERE Jogador.equipa = 'Sporting' ");
						
					   	while(rs.next()){
					   		cb.addElement(rs.getString("nome_jogador"));
				 
					   	}		
					   	
					}catch(SQLException se){
						   se.printStackTrace();
					}
									
					//Carrega os dados para as comboBox (Administrator-Marcador-IDjogo)
					try{
						
				   		DefaultComboBoxModel cb = (DefaultComboBoxModel) marcador_IDjogo.getModel();				  
				   		cb.removeAllElements();
						
						Statement st = conn.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM Jogo ");
						
					   	while(rs.next()){
					   		cb.addElement(rs.getString("id_jogo"));
				 
					   	}		
					   	
					}catch(SQLException se){
						   se.printStackTrace();
					}
					
					
				}else{
					JOptionPane.showMessageDialog(null, "Dados incorretos!");
				}
			}
		});
		btnSign.setBounds(173, 128, 112, 23);
		login.add(btnSign);
		
		JButton btnVisitor = new JButton("Visitante");
		btnVisitor.setForeground(new Color(0, 0, 102));
		btnVisitor.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnVisitor.setBackground(new Color(153, 153, 204));
		btnVisitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(false);
				menu2.setVisible(true);
				
				 //Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				
				//Carrega os dados (Designação da Epoca) da BD para a comboBox.
				try{
					DefaultComboBoxModel cb = (DefaultComboBoxModel) comboBox1.getModel();
					cb.removeAllElements();
					
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM Epoca");
					
					while(rs.next()){
						cb.addElement(rs.getString("designacao"));				   				    
					}
				
				}catch(SQLException se){
					   se.printStackTrace();
				}
							
				
				//Carrega os dados (Nome das Equipas) da BD para a comboBox.
				try{
					DefaultComboBoxModel cb2 = (DefaultComboBoxModel) comboBox2.getModel();
					DefaultComboBoxModel cb3 = (DefaultComboBoxModel) comboBox3.getModel();
					cb2.removeAllElements();
					cb3.removeAllElements();
					
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM Equipa");
					while(rs.next()){
					    cb2.addElement(rs.getString("nome_equipa"));
					    cb3.addElement(rs.getString("nome_equipa"));    
					}
				
				}catch(SQLException se){
					   se.printStackTrace();
				}
		
				
				//Carrega todos os dados para a Table3.
			    try
			    {
					DefaultTableModel dm = (DefaultTableModel)table3.getModel();
					dm.getDataVector().removeAllElements();
					dm.fireTableDataChanged();
					
			        Statement stat = conn.createStatement();
			        ResultSet rs = stat.executeQuery("SELECT * FROM Jogador ORDER BY equipa DESC");
			        
			        int colunas = rs.getMetaData().getColumnCount();
			        
			        while(rs.next())
			        {  
			            Object[] row = new Object[colunas];
			            for (int i = 1; i <= colunas; i++)
			            {  
			                row[i - 1] = rs.getObject(i);
			            }
			            ((DefaultTableModel) table3.getModel()).insertRow(rs.getRow()-1,row);   
			        }
			        rs.close();
			        stat.close();
			    }
			    
			    catch (SQLException e1)
			    {
			    }
			    
			  //Carrega os dados para as comboBox (Visitante-Estatistica-nome de equipas)
				try{
					
			   		DefaultComboBoxModel cb = (DefaultComboBoxModel) estat_Equipa.getModel();				  
			   		cb.removeAllElements();
					
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM Equipa");
					
				   	while(rs.next()){
				   		cb.addElement(rs.getString("nome_equipa"));
			 
				   	}		
				   	
				}catch(SQLException se){
					   se.printStackTrace();
				}
			}
		});
				
		btnVisitor.setBounds(173, 162, 112, 24);
		login.add(btnVisitor);
		
		JLabel lblNewLabel = new JLabel("Palavra-passe");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(196, 80, 74, 14);
		login.add(lblNewLabel);
		
		JLabel lblUtilizador = new JLabel("Utilizador");
		lblUtilizador.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblUtilizador.setForeground(Color.WHITE);
		lblUtilizador.setBounds(206, 32, 74, 14);
		login.add(lblUtilizador);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\img\\bg7.jpg"));
		lblNewLabel_1.setBounds(0, 0, 494, 401);
		login.add(lblNewLabel_1);
		
		menu = new JPanel();
		menu.setBackground(Color.WHITE);
		contentPane.add(menu, "name_951077423084622");
		menu.setLayout(null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(20, 48, 455, 302);
		menu.add(tabbedPane_1);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		tabbedPane_1.addTab("\u00C9pocas", null, panel_9, null);
		panel_9.setLayout(null);
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_2.setBounds(10, 11, 429, 252);
		panel_9.add(tabbedPane_2);
		
		JPanel panel_17 = new JPanel();
		panel_17.setForeground(Color.WHITE);
		panel_17.setBackground(Color.WHITE);
		tabbedPane_2.addTab("Adicionar", null, panel_17, null);
		panel_17.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setBounds(10, 30, 46, 14);
		panel_17.add(lblNewLabel_4);
		
		JLabel lblDesignao_1 = new JLabel("Designa\u00E7\u00E3o");
		lblDesignao_1.setForeground(Color.BLACK);
		lblDesignao_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDesignao_1.setBounds(10, 62, 61, 14);
		panel_17.add(lblDesignao_1);
		
		JLabel lblDataDenicio = new JLabel("Data de \u00CDnicio");
		lblDataDenicio.setForeground(Color.BLACK);
		lblDataDenicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataDenicio.setBounds(10, 96, 81, 14);
		panel_17.add(lblDataDenicio);
		
		JLabel lblDataDeFim = new JLabel("Data de Fim");
		lblDataDeFim.setForeground(Color.BLACK);
		lblDataDeFim.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataDeFim.setBounds(10, 130, 81, 14);
		panel_17.add(lblDataDeFim);
		
		Rnd_ep = new JTextField();
		Rnd_ep.setEditable(false);
		Rnd_ep.setBounds(30, 25, 46, 20);
		panel_17.add(Rnd_ep);
		Rnd_ep.setColumns(10);
		
		
		Des_ep = new JTextField();
		Des_ep.setBounds(101, 62, 145, 20);
		panel_17.add(Des_ep);
		Des_ep.setColumns(10);
		
		Di_ep = new JTextField();
		Di_ep.setColumns(10);
		Di_ep.setBounds(101, 96, 145, 20);
		panel_17.add(Di_ep);
		
		Df_ep = new JTextField();
		Df_ep.setColumns(10);
		Df_ep.setBounds(101, 130, 145, 20);
		panel_17.add(Df_ep);
		
		JButton btnNewButton_1 = new JButton("Criar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
	
				Random r = new Random();
				id_epoca = r.nextInt(999);
				Rnd_ep.setText(String.valueOf(id_epoca));

			}
		});
		btnNewButton_1.setBounds(101, 25, 145, 23);
		panel_17.add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("( Ex: 1997/1998 )");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setBounds(280, 65, 113, 14);
		panel_17.add(lblNewLabel_5);
		
		JLabel lblExemploDdmmaa = new JLabel("( Ex: dd-mm-aa )");
		lblExemploDdmmaa.setForeground(Color.BLACK);
		lblExemploDdmmaa.setBounds(280, 97, 113, 14);
		panel_17.add(lblExemploDdmmaa);
		
		JLabel lblExDdmmaa = new JLabel("( Ex: dd-mm-aa )");
		lblExDdmmaa.setForeground(Color.BLACK);
		lblExDdmmaa.setBounds(280, 131, 113, 14);
		panel_17.add(lblExDdmmaa);
		
		JButton button_3 = new JButton("Adicionar");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String Rnd_epoca = Rnd_ep.getText();
				String Des_epoca = Des_ep.getText();
				String Di_epoca = Di_ep.getText();
				String Df_epoca = Df_ep.getText();
				
				
				if( Rnd_epoca.isEmpty() || Des_epoca.isEmpty() || Di_epoca.isEmpty() || Df_epoca.isEmpty()){
					JOptionPane.showMessageDialog(null, "É obrigatório preencher todos os campos.");
				}else{
				
					 //Ligação à base de dados.
					Connection conn = null;
					
					try{
						   Class.forName(JDBC_DRIVER); 
						   conn = DriverManager.getConnection(DB_URL);
					}catch(SQLException se){
						   se.printStackTrace();
					}catch(Exception e1){
						   e1.printStackTrace();
					}
					
					//Insere dados na tabela Epoca da base de dados.
					try {
						Statement stat = conn.createStatement();
						stat.executeUpdate("INSERT INTO Epoca VALUES ("+ id_epoca +", '"+ Des_ep.getText() +"', '"+ Di_ep.getText() +"', '"+ Df_ep.getText() +"')");
						JOptionPane.showMessageDialog(null, "Dados adicionados com sucesso!");
						
						Rnd_ep.setText("");
						Des_ep.setText("");
						Di_ep.setText("");
						Df_ep.setText("");
						
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		button_3.setBackground(Color.WHITE);
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_3.setBounds(-12, 170, 447, 35);
		panel_17.add(button_3);
		
		JPanel panel_18 = new JPanel();
		panel_18.setForeground(Color.WHITE);
		panel_18.setBackground(Color.WHITE);
		tabbedPane_2.addTab("Editar", null, panel_18, null);
		panel_18.setLayout(null);
		
		JLabel lblpocaAEditar = new JLabel("\u00C9poca a editar");
		lblpocaAEditar.setForeground(Color.BLACK);
		lblpocaAEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblpocaAEditar.setBounds(10, 22, 78, 14);
		panel_18.add(lblpocaAEditar);
		
		comboBox_editar_ep = new JComboBox();
		comboBox_editar_ep.setBounds(99, 20, 145, 20);
		panel_18.add(comboBox_editar_ep);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 55, 410, 6);
		panel_18.add(separator);
		
		JLabel lblDesignaop = new JLabel("Designa\u00E7\u00E3o");
		lblDesignaop.setForeground(Color.BLACK);
		lblDesignaop.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDesignaop.setBounds(10, 78, 78, 14);
		panel_18.add(lblDesignaop);
		
		JLabel lblDataDeIncio = new JLabel("Data de in\u00EDcio");
		lblDataDeIncio.setForeground(Color.BLACK);
		lblDataDeIncio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataDeIncio.setBounds(10, 122, 78, 14);
		panel_18.add(lblDataDeIncio);
		
		JLabel lblDataDeFim_1 = new JLabel("Data de fim");
		lblDataDeFim_1.setForeground(Color.BLACK);
		lblDataDeFim_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataDeFim_1.setBounds(10, 174, 78, 14);
		panel_18.add(lblDataDeFim_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(99, 72, 145, 20);
		panel_18.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(99, 120, 145, 20);
		panel_18.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(99, 172, 145, 20);
		panel_18.add(textField_6);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String desUpdateEpoca = textField_4.getText();
				if(desUpdateEpoca.isEmpty()){
					JOptionPane.showMessageDialog(null, "Não inseriu nada em 'Designação' para editar.");
				}else{
						
					//Ligação à base de dados.
					Connection conn = null;
					
					try{
						   Class.forName(JDBC_DRIVER); 
						   conn = DriverManager.getConnection(DB_URL);
					}catch(SQLException se){
						   se.printStackTrace();
					}catch(Exception e1){
						   e1.printStackTrace();
					}
					
					//Edita o campo designação da tabela Epoca.
					try {
						String item = (String) comboBox_editar_ep.getSelectedItem();
						Statement stat = conn.createStatement();
						stat.executeUpdate("UPDATE Epoca SET designacao='"+ textField_4.getText() +"' WHERE designacao='"+ item.toString() +"'");
						JOptionPane.showMessageDialog(null, "Dados editados com sucesso!");					
						textField_4.setText("");
	
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}				
			}
		});
		
		btnEditar.setBounds(280, 72, 78, 23);
		panel_18.add(btnEditar);
		
		JButton button_2 = new JButton("Editar");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				
				String diUpdateEpoca = textField_5.getText();
				if(diUpdateEpoca.isEmpty()){
					JOptionPane.showMessageDialog(null, "Não inseriu nada em 'Data de Inicio' para editar.");
				}else{
					//Ligação à base de dados.
					Connection conn = null;
					
					try{
						   Class.forName(JDBC_DRIVER); 
						   conn = DriverManager.getConnection(DB_URL);
					}catch(SQLException se){
						   se.printStackTrace();
					}catch(Exception e1){
						   e1.printStackTrace();
					}
					
					//Edita o campo data_inicio da tabela Epoca.
					try {
						String item = (String) comboBox_editar_ep.getSelectedItem();
						Statement stat = conn.createStatement();
						stat.executeUpdate("UPDATE Epoca SET data_inicio='"+ textField_5.getText() +"' WHERE designacao='"+ item.toString() +"'");
						JOptionPane.showMessageDialog(null, "Dados editados com sucesso!");					
						textField_5.setText("");
	
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		button_2.setBounds(280, 119, 78, 23);
		panel_18.add(button_2);
		
		JButton button_4 = new JButton("Editar");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String dfUpdateEpoca = textField_6.getText();
				if(dfUpdateEpoca.isEmpty()){
					JOptionPane.showMessageDialog(null, "Não inseriu nada em 'Data de Fim' para editar.");
				}else{
					//Ligação à base de dados.
					Connection conn = null;
					
					try{
						   Class.forName(JDBC_DRIVER); 
						   conn = DriverManager.getConnection(DB_URL);
					}catch(SQLException se){
						   se.printStackTrace();
					}catch(Exception e1){
						   e1.printStackTrace();
					}
					
					//Edita o campo data_fim da tabela Epoca.
					try {
						String item = (String) comboBox_editar_ep.getSelectedItem();
						Statement stat = conn.createStatement();
						stat.executeUpdate("UPDATE Epoca SET data_fim='"+ textField_6.getText() +"' WHERE designacao='"+ item.toString() +"'");
						JOptionPane.showMessageDialog(null, "Dados editados com sucesso!");					
						textField_6.setText("");
	
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		button_4.setBounds(280, 171, 78, 23);
		panel_18.add(button_4);
		
		JButton button_16 = new JButton("");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				
				//Carrega os dados (Designação da Epoca) da BD para a comboBox.
				try{
					DefaultComboBoxModel cb = (DefaultComboBoxModel) comboBox_editar_ep.getModel();
					cb.removeAllElements();
					
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM Epoca");
					
					while(rs.next()){
						cb.addElement(rs.getString("designacao"));				   				    
					}
				
				}catch(SQLException se){
					   se.printStackTrace();
				}
			}
		});
		
		button_16.setForeground(Color.CYAN);
		button_16.setBackground(Color.WHITE);
		button_16.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\imagens\\refresh.png"));
		button_16.setBounds(254, 19, 27, 23);
		panel_18.add(button_16);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(Color.WHITE);
		tabbedPane_2.addTab("Eliminar", null, panel_19, null);
		panel_19.setLayout(null);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				//Elimina a epoca escolhida na comboBox_eliminar_ep
				try {
					String item = (String) comboBox_eliminar_ep.getSelectedItem();
					Statement stat = conn.createStatement();
					stat.executeUpdate("DELETE FROM Epoca WHERE designacao='"+item+"'");
					JOptionPane.showMessageDialog(null, "Dados eliminados com sucesso!");					
					textField_6.setText("");
					
					//Atualiza a combobox depois de eliminar da base de dados a linha ecolhida.
					DefaultComboBoxModel cb = (DefaultComboBoxModel) comboBox_eliminar_ep.getModel();
					DefaultComboBoxModel cb2 = (DefaultComboBoxModel) comboBox_editar_ep.getModel();
					cb.removeAllElements();
					cb2.removeAllElements();
					
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM Epoca");
					
					while(rs.next()){
						cb.addElement(rs.getString("designacao"));
						cb2.addElement(rs.getString("designacao"));
					}
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(-12, 170, 452, 35);
		panel_19.add(btnEliminar);
		
		JLabel lblpocaAEliminar = new JLabel("\u00C9poca a eliminar");
		lblpocaAEliminar.setForeground(Color.BLACK);
		lblpocaAEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblpocaAEliminar.setBounds(10, 21, 97, 14);
		panel_19.add(lblpocaAEliminar);
		
		comboBox_eliminar_ep = new JComboBox();
		comboBox_eliminar_ep.setBounds(117, 19, 145, 20);
		panel_19.add(comboBox_eliminar_ep);
		
		JButton button_17 = new JButton("");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				
				//Carrega os dados (Designação da Epoca) da BD para a comboBox.
				try{
					DefaultComboBoxModel cb = (DefaultComboBoxModel) comboBox_eliminar_ep.getModel();
					cb.removeAllElements();
					
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM Epoca");
					
					while(rs.next()){
						cb.addElement(rs.getString("designacao"));				   				    
					}
				
				}catch(SQLException se){
					   se.printStackTrace();
				}
			}
		});
		
		button_17.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\imagens\\refresh.png"));
		button_17.setForeground(Color.CYAN);
		button_17.setBackground(Color.WHITE);
		button_17.setBounds(272, 18, 27, 23);
		panel_19.add(button_17);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\img\\bg6.jpg"));
		lblNewLabel_6.setBounds(0, 0, 450, 274);
		panel_9.add(lblNewLabel_6);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		tabbedPane_1.addTab("Equipas", null, panel_10, null);
		panel_10.setLayout(null);
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_3.setBounds(10, 11, 429, 252);
		panel_10.add(tabbedPane_3);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		tabbedPane_3.addTab("Adicionar", null, panel_14, null);
		panel_14.setLayout(null);
		
		Rnd_eq = new JTextField();
		Rnd_eq.setEditable(false);
		Rnd_eq.setColumns(10);
		Rnd_eq.setBounds(30, 25, 46, 20);
		panel_14.add(Rnd_eq);
		
		JButton Criar_rnd = new JButton("Criar");
		Criar_rnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Random r = new Random();
				id_equipa = r.nextInt(999);
				Rnd_eq.setText(String.valueOf(id_equipa));
			}
		});
		Criar_rnd.setBounds(120, 24, 145, 23);
		panel_14.add(Criar_rnd);
		
		JLabel label_2 = new JLabel("ID");
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(10, 30, 46, 14);
		panel_14.add(label_2);
		
		JLabel lblNomeDaEquipa = new JLabel("Nome da Equipa");
		lblNomeDaEquipa.setForeground(Color.BLACK);
		lblNomeDaEquipa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDaEquipa.setBounds(10, 62, 100, 14);
		panel_14.add(lblNomeDaEquipa);
		
		Nde_eq = new JTextField();
		Nde_eq.setColumns(10);
		Nde_eq.setBounds(120, 62, 145, 20);
		panel_14.add(Nde_eq);
		
		JLabel lblExSporting = new JLabel("( Ex: \"Sporting\" )");
		lblExSporting.setForeground(Color.BLACK);
		lblExSporting.setBounds(280, 65, 113, 14);
		panel_14.add(lblExSporting);
		
		JLabel lblNomeDoEstdio = new JLabel("Nome do Est\u00E1dio");
		lblNomeDoEstdio.setForeground(Color.BLACK);
		lblNomeDoEstdio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDoEstdio.setBounds(10, 96, 100, 14);
		panel_14.add(lblNomeDoEstdio);
		
		JLabel lblDataDeFundao = new JLabel("Data de Funda\u00E7\u00E3o");
		lblDataDeFundao.setForeground(Color.BLACK);
		lblDataDeFundao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataDeFundao.setBounds(10, 130, 100, 14);
		panel_14.add(lblDataDeFundao);
		
		JButton add_eq = new JButton("Adicionar");
		add_eq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Rnd_equipa = Rnd_eq.getText();
				String Nome_equipa = Nde_eq.getText();
				String Nome_estadio = Ndes_eq.getText();
				String Ddf_equipa = Ddf_eq.getText();
				
				
				if( Rnd_equipa.isEmpty() || Nome_equipa.isEmpty() || Nome_estadio.isEmpty() || Ddf_equipa.isEmpty()){
					JOptionPane.showMessageDialog(null, "É obrigatório preencher todos os campos.");
				}else{
						
				
					 //Ligação à base de dados.
					Connection conn = null;
					
					try{
						   Class.forName(JDBC_DRIVER); 
						   conn = DriverManager.getConnection(DB_URL);
					}catch(SQLException se){
						   se.printStackTrace();
					}catch(Exception e1){
						   e1.printStackTrace();
					}
					
					//Insere dados na tabela Equipa da base de dados.
					try {
						Statement stat = conn.createStatement();
						stat.executeUpdate("INSERT INTO Equipa VALUES ("+ id_equipa +", '"+ Nde_eq.getText() +"', '"+ Ndes_eq.getText() +"', '"+ Ddf_eq.getText() +"')");
						JOptionPane.showMessageDialog(null, "Dados adicionados com sucesso!");				
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					
					//É criada uma linha para a tabela Classificacao com tudo a zeros, para a equipa criada.				
					try {
						int idClass = 3 + (int)(Math.random()*999);
						Statement stat = conn.createStatement();
						stat.executeUpdate("INSERT INTO Classificacao VALUES ("+ idClass +", '"+ Nde_eq.getText() +"', 0, 0, 0, 0)");
						
						Rnd_eq.setText("");
						Nde_eq.setText("");
						Ndes_eq.setText("");
						Ddf_eq.setText("");
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		add_eq.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add_eq.setBackground(Color.WHITE);
		add_eq.setBounds(-12, 170, 451, 35);
		panel_14.add(add_eq);
		
		Ndes_eq = new JTextField();
		Ndes_eq.setColumns(10);
		Ndes_eq.setBounds(120, 96, 145, 20);
		panel_14.add(Ndes_eq);
		
		Ddf_eq = new JTextField();
		Ddf_eq.setColumns(10);
		Ddf_eq.setBounds(120, 130, 145, 20);
		panel_14.add(Ddf_eq);
		
		JLabel lblExEstdio = new JLabel("( Ex: \"Est\u00E1dio de Alvalade\" )");
		lblExEstdio.setForeground(Color.BLACK);
		lblExEstdio.setBounds(280, 97, 135, 14);
		panel_14.add(lblExEstdio);
		
		JLabel label_8 = new JLabel("( Ex: dd-mm-aa )");
		label_8.setForeground(Color.BLACK);
		label_8.setBounds(280, 131, 113, 14);
		panel_14.add(label_8);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.WHITE);
		panel_15.setForeground(Color.WHITE);
		tabbedPane_3.addTab("Editar", null, panel_15, null);
		panel_15.setLayout(null);
		
		JLabel lblEquipaAEditar = new JLabel("Equipa a editar");
		lblEquipaAEditar.setForeground(Color.BLACK);
		lblEquipaAEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEquipaAEditar.setBounds(14, 22, 93, 14);
		panel_15.add(lblEquipaAEditar);
		
		comboBox_editar_eq = new JComboBox();
		comboBox_editar_eq.setBounds(125, 20, 145, 20);
		panel_15.add(comboBox_editar_eq);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 55, 410, 6);
		panel_15.add(separator_2);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(125, 72, 145, 20);
		panel_15.add(textField_7);
		
		JLabel lblNomeDaEquipa_1 = new JLabel("Nome da Equipa");
		lblNomeDaEquipa_1.setForeground(Color.BLACK);
		lblNomeDaEquipa_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDaEquipa_1.setBounds(14, 78, 93, 14);
		panel_15.add(lblNomeDaEquipa_1);
		
		JButton button_7 = new JButton("Editar");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ndeUpdateEquipa = textField_7.getText();
				if(ndeUpdateEquipa.isEmpty()){
					JOptionPane.showMessageDialog(null, "Não inseriu nada em 'Nome de Equipa' para editar.");
				}else{
					//Ligação à base de dados.
					Connection conn = null;
					
					try{
						   Class.forName(JDBC_DRIVER); 
						   conn = DriverManager.getConnection(DB_URL);
					}catch(SQLException se){
						   se.printStackTrace();
					}catch(Exception e1){
						   e1.printStackTrace();
					}
					
					//Edita o campo nome_equipa da tabela Equipa.
					try {
						String item = (String) comboBox_editar_eq.getSelectedItem();
						Statement stat = conn.createStatement();
						stat.executeUpdate("UPDATE Equipa SET nome_equipa='"+ textField_7.getText() +"' WHERE nome_equipa='"+ item.toString() +"'");
						JOptionPane.showMessageDialog(null, "Dados editados com sucesso!");					
						textField_7.setText("");
	
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
		button_7.setBounds(280, 72, 78, 23);
		panel_15.add(button_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(125, 120, 145, 20);
		panel_15.add(textField_8);
		
		JLabel lblNomeDeEstdio = new JLabel("Nome de Est\u00E1dio");
		lblNomeDeEstdio.setForeground(Color.BLACK);
		lblNomeDeEstdio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDeEstdio.setBounds(14, 122, 93, 14);
		panel_15.add(lblNomeDeEstdio);
		
		JButton button_8 = new JButton("Editar");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ndesUpdateEquipa = textField_8.getText();
				if(ndesUpdateEquipa.isEmpty()){
					JOptionPane.showMessageDialog(null, "Não inseriu nada em 'Nome do Estádio' para editar.");
				}else{
					//Ligação à base de dados.
					Connection conn = null;
					
					try{
						   Class.forName(JDBC_DRIVER); 
						   conn = DriverManager.getConnection(DB_URL);
					}catch(SQLException se){
						   se.printStackTrace();
					}catch(Exception e1){
						   e1.printStackTrace();
					}
					
					//Edita o campo nome_estadio da tabela Equipa.
					try {
						String item = (String) comboBox_editar_eq.getSelectedItem();
						Statement stat = conn.createStatement();
						stat.executeUpdate("UPDATE Equipa SET nome_estadio='"+ textField_8.getText() +"' WHERE nome_equipa='"+ item.toString() +"'");
						JOptionPane.showMessageDialog(null, "Dados editados com sucesso!");					
						textField_8.setText("");
	
					} catch (SQLException e1) {
						e1.printStackTrace();
					}	
				}
			}
		});
		
		button_8.setBounds(280, 119, 78, 23);
		panel_15.add(button_8);
		
		JButton button_9 = new JButton("Editar");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String desUpdateEpoca = textField_9.getText();
				if(desUpdateEpoca.isEmpty()){
					JOptionPane.showMessageDialog(null, "Não inseriu nada em 'Data de Fundação' para editar.");
				}else{
					//Ligação à base de dados.
					Connection conn = null;
					
					try{
						   Class.forName(JDBC_DRIVER); 
						   conn = DriverManager.getConnection(DB_URL);
					}catch(SQLException se){
						   se.printStackTrace();
					}catch(Exception e1){
						   e1.printStackTrace();
					}
					
					//Edita o campo data_fundacao da tabela Equipa.
					try {
						String item = (String) comboBox_editar_eq.getSelectedItem();
						Statement stat = conn.createStatement();
						stat.executeUpdate("UPDATE Equipa SET data_fundacao='"+ textField_9.getText() +"' WHERE nome_equipa='"+ item.toString() +"'");
						JOptionPane.showMessageDialog(null, "Dados editados com sucesso!");					
						textField_9.setText("");
	
					} catch (SQLException e1) {
						e1.printStackTrace();
					}	
				}
			}
		});
		button_9.setBounds(280, 171, 78, 23);
		panel_15.add(button_9);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(125, 172, 145, 20);
		panel_15.add(textField_9);
		
		JLabel lblDataDeFundao_1 = new JLabel("Data de Funda\u00E7\u00E3o");
		lblDataDeFundao_1.setForeground(Color.BLACK);
		lblDataDeFundao_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataDeFundao_1.setBounds(14, 174, 104, 14);
		panel_15.add(lblDataDeFundao_1);
		
		JButton button_18 = new JButton("");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				
				//Carrega os dados (Designação da Epoca) da BD para a comboBox.
				try{
					DefaultComboBoxModel cb = (DefaultComboBoxModel) comboBox_editar_eq.getModel();
					cb.removeAllElements();
					
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM Equipa");
					
					while(rs.next()){
						cb.addElement(rs.getString("nome_equipa"));				   				    
					}
				
				}catch(SQLException se){
					   se.printStackTrace();
				}
			}
		});
		
		button_18.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\imagens\\refresh.png"));
		button_18.setForeground(Color.CYAN);
		button_18.setBackground(Color.WHITE);
		button_18.setBounds(280, 19, 27, 23);
		panel_15.add(button_18);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.WHITE);
		tabbedPane_3.addTab("Eliminar", null, panel_16, null);
		panel_16.setLayout(null);
		
		JLabel lblEquipaAEliminar = new JLabel("Equipa a eliminar");
		lblEquipaAEliminar.setForeground(Color.BLACK);
		lblEquipaAEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEquipaAEliminar.setBounds(10, 21, 97, 14);
		panel_16.add(lblEquipaAEliminar);
		
		comboBox_eliminar_eq = new JComboBox();
		comboBox_eliminar_eq.setBounds(117, 19, 145, 20);
		panel_16.add(comboBox_eliminar_eq);
		
		JButton button_5 = new JButton("Eliminar");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				//Elimina a equipa escolhida na comboBox_eliminar_eq
				try {
					String item = (String) comboBox_eliminar_eq.getSelectedItem();
					Statement stat = conn.createStatement();
					Statement stat2 = conn.createStatement();
					Statement stat3 = conn.createStatement();
					stat.executeUpdate("DELETE FROM Equipa WHERE nome_equipa='"+item+"'");
					stat2.executeUpdate("DELETE FROM Classificacao WHERE equipa='"+item+"'");
					stat3.executeUpdate("DELETE FROM Jogo WHERE equipa_casa='"+item+"' OR equipa_visitante='"+item+"'");
					JOptionPane.showMessageDialog(null, "Dados eliminados com sucesso!");					
					textField_6.setText("");
					
					//Atualiza a combobox depois de eliminar da base de dados a linha ecolhida.
					DefaultComboBoxModel cb = (DefaultComboBoxModel) comboBox_eliminar_eq.getModel();
					DefaultComboBoxModel cb2 = (DefaultComboBoxModel) comboBox_editar_eq.getModel();
					cb.removeAllElements();
					cb2.removeAllElements();
					
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM Equipa");
					
					while(rs.next()){
						cb.addElement(rs.getString("nome_equipa"));
						cb2.addElement(rs.getString("nome_equipa"));
					}
					
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_5.setBackground(Color.WHITE);
		button_5.setBounds(-13, 170, 450, 35);
		panel_16.add(button_5);
		
		JButton button_19 = new JButton("");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				
				//Carrega os dados (Designação da Epoca) da BD para a comboBox.
				try{
					DefaultComboBoxModel cb = (DefaultComboBoxModel) comboBox_eliminar_eq.getModel();
					cb.removeAllElements();
					
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM Equipa");
					
					while(rs.next()){
						cb.addElement(rs.getString("nome_equipa"));				   				    
					}
				
				}catch(SQLException se){
					   se.printStackTrace();
				}
			}
		});
		
		button_19.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\imagens\\refresh.png"));
		button_19.setForeground(Color.CYAN);
		button_19.setBackground(Color.WHITE);
		button_19.setBounds(272, 18, 27, 23);
		panel_16.add(button_19);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setBackground(new Color(0, 0, 0));
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\img\\bg6.jpg"));
		lblNewLabel_7.setBounds(0, 0, 450, 274);
		panel_10.add(lblNewLabel_7);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		tabbedPane_1.addTab("Jogadores", null, panel_11, null);
		panel_11.setLayout(null);
		
		JTabbedPane tabbedPane_4 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_4.setBounds(10, 11, 429, 252);
		panel_11.add(tabbedPane_4);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(Color.WHITE);
		tabbedPane_4.addTab("Adicionar", null, panel_20, null);
		panel_20.setLayout(null);
		
		JTextField Rnd_jgd = new JTextField();
		Rnd_jgd.setEditable(false);
		Rnd_jgd.setColumns(10);
		Rnd_jgd.setBounds(30, 20, 46, 20);
		panel_20.add(Rnd_jgd);
		
		JLabel label_3 = new JLabel("ID");
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(10, 25, 46, 14);
		panel_20.add(label_3);
		
		JButton Btn_rnd_jgd = new JButton("Criar");
		Btn_rnd_jgd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Random r = new Random();
				id_jogador = r.nextInt(999);
				Rnd_jgd.setText(String.valueOf(id_jogador));
			}
		});
		Btn_rnd_jgd.setBounds(130, 19, 145, 23);
		panel_20.add(Btn_rnd_jgd);
		
		JLabel lblNomeDoJogador = new JLabel("Nome do Jogador");
		lblNomeDoJogador.setForeground(Color.BLACK);
		lblNomeDoJogador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDoJogador.setBounds(10, 52, 100, 14);
		panel_20.add(lblNomeDoJogador);
		
		Ndj_jgd = new JTextField();
		Ndj_jgd.setColumns(10);
		Ndj_jgd.setBounds(130, 52, 145, 20);
		panel_20.add(Ndj_jgd);
		
		JLabel lblExcristiano = new JLabel("( Ex: \"Cristiano Ronaldo\" )");
		lblExcristiano.setForeground(Color.BLACK);
		lblExcristiano.setBounds(280, 55, 135, 14);
		panel_20.add(lblExcristiano);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setForeground(Color.BLACK);
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataDeNascimento.setBounds(10, 110, 113, 14);
		panel_20.add(lblDataDeNascimento);
		
		Ddn_jgd = new JTextField();
		Ddn_jgd.setColumns(10);
		Ddn_jgd.setBounds(130, 108, 145, 20);
		panel_20.add(Ddn_jgd);
		
		JLabel lblExDdmmaa_1 = new JLabel("( Ex: dd-mm-aa )");
		lblExDdmmaa_1.setForeground(Color.BLACK);
		lblExDdmmaa_1.setBounds(280, 111, 135, 14);
		panel_20.add(lblExDdmmaa_1);
		
		JLabel lblPosioDeJogo = new JLabel("Posi\u00E7\u00E3o de Jogo");
		lblPosioDeJogo.setForeground(Color.BLACK);
		lblPosioDeJogo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPosioDeJogo.setBounds(10, 138, 100, 14);
		panel_20.add(lblPosioDeJogo);
		
		Pdj_jgd = new JTextField();
		Pdj_jgd.setColumns(10);
		Pdj_jgd.setBounds(130, 136, 145, 20);
		panel_20.add(Pdj_jgd);
		
		JLabel lblExdf = new JLabel("( Ex: \"DF\",\"MD\",\"AV\",\"GR\" )");
		lblExdf.setForeground(Color.BLACK);
		lblExdf.setBounds(280, 139, 135, 14);
		panel_20.add(lblExdf);
		
		JButton Add_jgd = new JButton("Adicionar");
		Add_jgd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String Rnd_jogador = Rnd_jgd.getText();
				String nome_Jogador = Ndj_jgd.getText();
				String data_Nascimento = Ddn_jgd.getText();
				String posicao_Jogo = Pdj_jgd.getText();
				
				
				if( Rnd_jogador.isEmpty() || nome_Jogador.isEmpty() || data_Nascimento.isEmpty() || posicao_Jogo.isEmpty()){
					JOptionPane.showMessageDialog(null, "É obrigatório preencher todos os campos.");
				}else{
					 //Ligação à base de dados.
					Connection conn = null;
					
					try{
						   Class.forName(JDBC_DRIVER); 
						   conn = DriverManager.getConnection(DB_URL);
					}catch(SQLException se){
						   se.printStackTrace();
					}catch(Exception e1){
						   e1.printStackTrace();
					}
					
					//Insere dados nos campos da tabela Jogador da base de dados.
					try {
						String equipa = (String) Eq_jgd.getSelectedItem();
						Statement stat = conn.createStatement();
						stat.executeUpdate("INSERT INTO Jogador VALUES ("+ id_jogador +", '"+ Ndj_jgd.getText() +"','"+ equipa.toString() +"', '"+ Ddn_jgd.getText() +"', '"+ Pdj_jgd.getText() +"')");
						Statement stat2 = conn.createStatement();
						stat.executeUpdate("INSERT INTO Plantel VALUES ("+id_jogador +", "+ id_equipa +", "+ id_epoca +")");
						JOptionPane.showMessageDialog(null, "Dados adicionados com sucesso!");
						
						Rnd_jgd.setText("");
						Ndj_jgd.setText("");
						Ddn_jgd.setText("");
						Pdj_jgd.setText("");
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		
		});
		
		Add_jgd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Add_jgd.setBackground(Color.WHITE);
		Add_jgd.setBounds(-13, 180, 451, 35);
		panel_20.add(Add_jgd);
		
		JLabel lblEquipa_1 = new JLabel("Equipa");
		lblEquipa_1.setForeground(Color.BLACK);
		lblEquipa_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEquipa_1.setBounds(10, 80, 100, 14);
		panel_20.add(lblEquipa_1);
		
		Eq_jgd = new JComboBox();
		Eq_jgd.setBounds(130, 80, 145, 20);
		panel_20.add(Eq_jgd);
		
		JButton button_23 = new JButton("");
		button_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 //Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				//Carrega os dados para as comboBox (Administrator-Jogador-Nome da Equipa)
				try{
					
			   		DefaultComboBoxModel cb = (DefaultComboBoxModel) Eq_jgd.getModel();				  
			   		cb.removeAllElements();
					
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM Equipa");
					
				   	while(rs.next()){
				   		cb.addElement(rs.getString("nome_equipa"));
			 
				   	}		
				   	
				}catch(SQLException se){
					   se.printStackTrace();
				}
			}
		});
		button_23.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\imagens\\refresh.png"));
		button_23.setForeground(Color.CYAN);
		button_23.setBackground(Color.WHITE);
		button_23.setBounds(280, 80, 27, 23);
		panel_20.add(button_23);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(Color.WHITE);
		tabbedPane_4.addTab("Editar", null, panel_21, null);
		panel_21.setLayout(null);
		
		JLabel lblJogadorAEditar = new JLabel("Jogador a editar");
		lblJogadorAEditar.setForeground(Color.BLACK);
		lblJogadorAEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblJogadorAEditar.setBounds(14, 22, 93, 14);
		panel_21.add(lblJogadorAEditar);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 55, 410, 6);
		panel_21.add(separator_4);
		
		JLabel lblNomeDoJogador_1 = new JLabel("Nome do Jogador");
		lblNomeDoJogador_1.setForeground(Color.BLACK);
		lblNomeDoJogador_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDoJogador_1.setBounds(14, 78, 101, 14);
		panel_21.add(lblNomeDoJogador_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(140, 72, 145, 20);
		panel_21.add(textField_10);
		
		JButton button_11 = new JButton("Editar");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ndjEditarJogador = Ndj_editar_jgd.getText();
				if(ndjEditarJogador.isEmpty()){
					JOptionPane.showMessageDialog(null, "Insira o nome do jogador que deseja editar.");
				}else{
					String ndjUpdateJogador = textField_10.getText();
					if(ndjUpdateJogador.isEmpty()){
						JOptionPane.showMessageDialog(null, "Não inseriu nada em 'Nome de Jogador' para editar.");
					}else{
					
							//Ligação à base de dados.
							Connection conn = null;
							
							try{
								   Class.forName(JDBC_DRIVER); 
								   conn = DriverManager.getConnection(DB_URL);
							}catch(SQLException se){
								   se.printStackTrace();
							}catch(Exception e1){
								   e1.printStackTrace();
							}
							
							//Edita o campo nome_jogador da tabela Jogador.
							try {
								Statement stat = conn.createStatement();
								stat.executeUpdate("UPDATE Jogador SET nome_jogador='"+ textField_10.getText() +"' WHERE nome_jogador='"+ Ndj_editar_jgd.getText() +"'");
								JOptionPane.showMessageDialog(null, "Dados editados com sucesso!");					
								textField_10.setText("");
			
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
					}
				}
			}
		});
		
		button_11.setBounds(300, 72, 78, 23);
		panel_21.add(button_11);
		
		JButton button_12 = new JButton("Editar");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String ndjEditarJogador = Ndj_editar_jgd.getText();
					if(ndjEditarJogador.isEmpty()){
						JOptionPane.showMessageDialog(null, "Insira o nome do jogador que deseja editar.");
					}else{
						String ddnUpdateJogador = textField_11.getText();
						if(ddnUpdateJogador.isEmpty()){
							JOptionPane.showMessageDialog(null, "Não inseriu nada em 'Data de Nascimento' para editar.");
						}else{
							//Ligação à base de dados.
							Connection conn = null;
							
							try{
								   Class.forName(JDBC_DRIVER); 
								   conn = DriverManager.getConnection(DB_URL);
							}catch(SQLException se){
								   se.printStackTrace();
							}catch(Exception e1){
								   e1.printStackTrace();
							}
							
							//Edita o campo data_nascimento da tabela Jogador.
							try {
								Statement stat = conn.createStatement();
								stat.executeUpdate("UPDATE Jogador SET data_nascimento='"+ textField_11.getText() +"' WHERE nome_jogador='"+ Ndj_editar_jgd.getText() +"'");
								JOptionPane.showMessageDialog(null, "Dados editados com sucesso!");					
								textField_11.setText("");
			
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
					}
				}
			}
		});
		
		button_12.setBounds(300, 137, 78, 23);
		panel_21.add(button_12);
		
		JButton button_13 = new JButton("Editar");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ndjEditarJogador = Ndj_editar_jgd.getText();
				if(ndjEditarJogador.isEmpty()){
					JOptionPane.showMessageDialog(null, "Insira o nome do jogador que deseja editar.");
				}else{
					String pdjUpdateJogador = textField_12.getText();
					if(pdjUpdateJogador.isEmpty()){
						JOptionPane.showMessageDialog(null, "Não inseriu nada em 'Posição de Jogador' para editar.");
					}else{
						//Ligação à base de dados.
						Connection conn = null;
						
						try{
							   Class.forName(JDBC_DRIVER); 
							   conn = DriverManager.getConnection(DB_URL);
						}catch(SQLException se){
							   se.printStackTrace();
						}catch(Exception e1){
							   e1.printStackTrace();
						}
						
						//Edita o campo posicao da tabela Jogador.
						try {
							Statement stat = conn.createStatement();
							stat.executeUpdate("UPDATE Jogador SET posicao='"+ textField_12.getText() +"' WHERE nome_jogador='"+ Ndj_editar_jgd.getText() +"'");
							JOptionPane.showMessageDialog(null, "Dados editados com sucesso!");					
							textField_12.setText("");
		
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		
		button_13.setBounds(300, 171, 78, 23);
		panel_21.add(button_13);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(140, 137, 145, 20);
		panel_21.add(textField_12);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(140, 172, 145, 20);
		panel_21.add(textField_11);
		
		JLabel lblPosioDeJogo_1 = new JLabel("Posi\u00E7\u00E3o de Jogo");
		lblPosioDeJogo_1.setForeground(Color.BLACK);
		lblPosioDeJogo_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPosioDeJogo_1.setBounds(14, 174, 104, 14);
		panel_21.add(lblPosioDeJogo_1);
		
		JLabel lblDataDeNascimento_1 = new JLabel("Data de Nascimento");
		lblDataDeNascimento_1.setForeground(Color.BLACK);
		lblDataDeNascimento_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataDeNascimento_1.setBounds(14, 143, 116, 14);
		panel_21.add(lblDataDeNascimento_1);
		
		Ndj_editar_jgd = new JTextField();
		Ndj_editar_jgd.setColumns(10);
		Ndj_editar_jgd.setBounds(140, 20, 145, 20);
		panel_21.add(Ndj_editar_jgd);
		
		JLabel lblEquipa_2 = new JLabel("Equipa");
		lblEquipa_2.setForeground(Color.BLACK);
		lblEquipa_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEquipa_2.setBounds(14, 110, 116, 14);
		panel_21.add(lblEquipa_2);
		
		JButton button_15 = new JButton("Editar");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ndjEditarJogador = Ndj_editar_jgd.getText();
				if(ndjEditarJogador.isEmpty()){
					JOptionPane.showMessageDialog(null, "Insira o nome do jogador que deseja editar.");
				}else{
							String equipaUpdateJogador = textField_e.getText();
							if(equipaUpdateJogador.isEmpty()){
								JOptionPane.showMessageDialog(null, "Não inseriu nada em 'Equipa' para editar.");
							}else{
						//Ligação à base de dados.
						Connection conn = null;
						
						try{
							   Class.forName(JDBC_DRIVER); 
							   conn = DriverManager.getConnection(DB_URL);
						}catch(SQLException se){
							   se.printStackTrace();
						}catch(Exception e1){
							   e1.printStackTrace();
						}
						
						//Edita o campo equipa da tabela Jogador.
						try {
							Statement stat = conn.createStatement();
							stat.executeUpdate("UPDATE Jogador SET equipa='"+ textField_e.getText() +"' WHERE nome_jogador='"+ Ndj_editar_jgd.getText() +"'");
							JOptionPane.showMessageDialog(null, "Dados editados com sucesso!");					
							textField_e.setText("");
		
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}			
				}
			}
		});
		
		button_15.setBounds(300, 104, 78, 23);
		panel_21.add(button_15);
		
		textField_e = new JTextField();
		textField_e.setBounds(140, 104, 145, 20);
		panel_21.add(textField_e);
		textField_e.setColumns(10);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBackground(Color.WHITE);
		tabbedPane_4.addTab("Eliminar", null, panel_22, null);
		panel_22.setLayout(null);
		
		JLabel lblJogadorAEliminar = new JLabel("Jogador a eliminar");
		lblJogadorAEliminar.setForeground(Color.BLACK);
		lblJogadorAEliminar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblJogadorAEliminar.setBounds(10, 21, 97, 14);
		panel_22.add(lblJogadorAEliminar);
		
		JButton button_14 = new JButton("Eliminar");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				//Elimina o jogador por nome
				try {
					Statement stat = conn.createStatement();
					stat.executeUpdate("DELETE FROM Jogador WHERE nome_jogador='"+ Jgd_eliminar.getText() +"'");
					JOptionPane.showMessageDialog(null, "Dados eliminados com sucesso!");	
					Jgd_eliminar.setText("");
										
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		button_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_14.setBackground(Color.WHITE);
		button_14.setBounds(-13, 170, 450, 35);
		panel_22.add(button_14);
		
		Jgd_eliminar = new JTextField();
		Jgd_eliminar.setColumns(10);
		Jgd_eliminar.setBounds(117, 19, 145, 20);
		panel_22.add(Jgd_eliminar);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\img\\bg6.jpg"));
		lblNewLabel_8.setBounds(0, 0, 450, 274);
		panel_11.add(lblNewLabel_8);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		tabbedPane_1.addTab("Jogos", null, panel_12, null);
		panel_12.setLayout(null);
		
		JTabbedPane tabbedPane_5 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_5.setBounds(10, 11, 429, 252);
		panel_12.add(tabbedPane_5);
		
		JPanel panel_23 = new JPanel();
		panel_23.setBackground(Color.WHITE);
		tabbedPane_5.addTab("Adicionar", null, panel_23, null);
		panel_23.setLayout(null);
		
		derrota_jg = new JTextField();
		derrota_jg.setColumns(10);
		derrota_jg.setBounds(210, 149, 100, 20);
		panel_23.add(derrota_jg);
		
		vitoria_jg = new JTextField();
		vitoria_jg.setBounds(51, 149, 100, 20);
		panel_23.add(vitoria_jg);
		vitoria_jg.setColumns(10);
		
		JLabel lblGolosoDaCasa = new JLabel("Golos da Casa");
		lblGolosoDaCasa.setForeground(new Color(0, 100, 0));
		lblGolosoDaCasa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGolosoDaCasa.setBounds(10, 113, 113, 14);
		panel_23.add(lblGolosoDaCasa);
		
		JLabel label_5 = new JLabel("ID");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_5.setBounds(10, 17, 46, 14);
		panel_23.add(label_5);
		
		Rnd_jg = new JTextField();
		Rnd_jg.setEditable(false);
		Rnd_jg.setColumns(10);
		Rnd_jg.setBounds(30, 12, 46, 20);
		panel_23.add(Rnd_jg);
		
		JButton Btn_rnd_jg = new JButton("Criar");
		Btn_rnd_jg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Random r = new Random();
				id_jogo = r.nextInt(999);
				Rnd_jg.setText(String.valueOf(id_jogo));
			}
		});
		
		Btn_rnd_jg.setBounds(130, 8, 145, 23);
		panel_23.add(Btn_rnd_jg);
		
		JLabel lblEquipaDaCasa = new JLabel("Equipa da Casa");
		lblEquipaDaCasa.setForeground(new Color(0, 100, 0));
		lblEquipaDaCasa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEquipaDaCasa.setBounds(10, 38, 100, 14);
		panel_23.add(lblEquipaDaCasa);
		
		JLabel lblEquipaVisitante = new JLabel("Equipa Visitante");
		lblEquipaVisitante.setForeground(new Color(139, 0, 0));
		lblEquipaVisitante.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEquipaVisitante.setBounds(10, 63, 100, 14);
		panel_23.add(lblEquipaVisitante);
		
		JLabel lblDataDoJogo = new JLabel("Data do Jogo");
		lblDataDoJogo.setForeground(Color.BLACK);
		lblDataDoJogo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDataDoJogo.setBounds(10, 88, 113, 14);
		panel_23.add(lblDataDoJogo);
		
		Ddj_jg = new JTextField();
		Ddj_jg.setColumns(10);
		Ddj_jg.setBounds(130, 88, 145, 20);
		panel_23.add(Ddj_jg);
		
		JLabel label_12 = new JLabel("( Ex: dd-mm-aa )");
		label_12.setForeground(Color.BLACK);
		label_12.setBounds(280, 89, 135, 14);
		panel_23.add(label_12);
		
		JComboBox golos_c = new JComboBox();
		golos_c.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		golos_c.setBounds(130, 113, 55, 20);
		panel_23.add(golos_c);
		
		JButton button_10 = new JButton("Adicionar");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Rnd_jogo = Rnd_jg.getText();
				String Ddj_jogo = Ddj_jg.getText();
				
				if(empate == 0){
					String vitoria_Jogo = vitoria_jg.getText();
					String derrota_Jogo = derrota_jg.getText();
				
					if( Rnd_jogo.isEmpty() || Ddj_jogo.isEmpty() || vitoria_Jogo.isEmpty() || derrota_Jogo.isEmpty()){
						JOptionPane.showMessageDialog(null, "É obrigatório preencher todos os campos.");
					}else{
						
						 //Ligação à base de dados.
						Connection conn = null;
						
						try{
							   Class.forName(JDBC_DRIVER); 
							   conn = DriverManager.getConnection(DB_URL);
						}catch(SQLException se){
							   se.printStackTrace();
						}catch(Exception e1){
							   e1.printStackTrace();
						}
						
						//Insere dados na tabela Jogo da base de dados e atualiza a tabela Classificativa.
						try {
							String Edc_jg = (String) comboBox_add_ec.getSelectedItem();
							String Ev_jg = (String) comboBox_add_v.getSelectedItem();		
							
							Statement stat = conn.createStatement();
							Statement stat2 = conn.createStatement();
							Statement stat3 = conn.createStatement();
							Statement stat4 = conn.createStatement();
							Statement stat5 = conn.createStatement();
							Statement stat6 = conn.createStatement();
							Statement stat7 = conn.createStatement();
							Statement stat8 = conn.createStatement();
							Statement stat9 = conn.createStatement();
							Statement stat10 = conn.createStatement();
							Statement stat11 = conn.createStatement();
							
							stat.executeUpdate("INSERT INTO Jogo VALUES ("+ id_jogo +", '"+ Edc_jg.toString() +"', '"+ Ev_jg.toString() +"', '"+ Ddj_jg.getText() +"',"+ golos_c.getSelectedIndex() +","+ golos_v.getSelectedIndex() +",'"+ vitoria_jg.getText() +"',"+empate+",'"+ derrota_jg.getText() +"')");					
							stat2.executeUpdate("UPDATE Classificacao SET pontos=pontos+3 WHERE equipa='"+vitoria_jg.getText()+"'");
							stat3.executeUpdate("UPDATE Classificacao SET vitorias=vitorias+1 WHERE equipa='"+vitoria_jg.getText()+"'");
							stat4.executeUpdate("UPDATE Classificacao SET derrotas=derrotas+0 WHERE equipa='"+vitoria_jg.getText()+"'");
							stat5.executeUpdate("UPDATE Classificacao SET pontos=pontos+0 WHERE equipa='"+derrota_jg.getText()+"'");
							stat6.executeUpdate("UPDATE Classificacao SET vitorias=vitorias+0 WHERE equipa='"+derrota_jg.getText()+"'");
							stat7.executeUpdate("UPDATE Classificacao SET derrotas=derrotas+1 WHERE equipa='"+derrota_jg.getText()+"'");
							
							//Caso haja empate atualizar dados
							if(empate == 1){	
								stat8.executeUpdate("UPDATE Classificacao SET pontos=pontos+1 WHERE equipa='"+Edc_jg.toString()+"'");
								stat9.executeUpdate("UPDATE Classificacao SET pontos=pontos+1 WHERE equipa='"+Ev_jg.toString()+"'");
								stat10.executeUpdate("UPDATE Classificacao SET empates=empates+1 WHERE equipa='"+Edc_jg.toString()+"'");
								stat11.executeUpdate("UPDATE Classificacao SET empates=empates+1 WHERE equipa='"+Ev_jg.toString()+"'");				
							}
							
							JOptionPane.showMessageDialog(null, "Dados adicionados com sucesso!");
							
							Rnd_jg.setText("");
							Ddj_jg.setText("");
							vitoria_jg.setText("");
							derrota_jg.setText("");
		
							
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}else{
					if( Rnd_jogo.isEmpty() || Ddj_jogo.isEmpty()){
						JOptionPane.showMessageDialog(null, "É obrigatório preencher todos os campos.");
					}else{
						
						 //Ligação à base de dados.
						Connection conn = null;
						
						try{
							   Class.forName(JDBC_DRIVER); 
							   conn = DriverManager.getConnection(DB_URL);
						}catch(SQLException se){
							   se.printStackTrace();
						}catch(Exception e1){
							   e1.printStackTrace();
						}
						
						//Inserir dados na tabela Jogo e Atualização da tabela Classificativa.
						try {
							String Edc_jg = (String) comboBox_add_ec.getSelectedItem();
							String Ev_jg = (String) comboBox_add_v.getSelectedItem();		
							
							Statement stat = conn.createStatement();
							Statement stat2 = conn.createStatement();
							Statement stat3 = conn.createStatement();
							Statement stat4 = conn.createStatement();
							Statement stat5 = conn.createStatement();
							Statement stat6 = conn.createStatement();
							Statement stat7 = conn.createStatement();
							Statement stat8 = conn.createStatement();
							Statement stat9 = conn.createStatement();
							Statement stat10 = conn.createStatement();
							Statement stat11 = conn.createStatement();
							
							stat.executeUpdate("INSERT INTO Jogo VALUES ("+ id_jogo +", '"+ Edc_jg.toString() +"', '"+ Ev_jg.toString() +"', '"+ Ddj_jg.getText() +"',"+ golos_c.getSelectedIndex() +","+ golos_v.getSelectedIndex() +",'"+ vitoria_jg.getText() +"',"+empate+",'"+ derrota_jg.getText() +"')");					
							stat2.executeUpdate("UPDATE Classificacao SET pontos=pontos+3 WHERE equipa='"+vitoria_jg.getText()+"'");
							stat3.executeUpdate("UPDATE Classificacao SET vitorias=vitorias+1 WHERE equipa='"+vitoria_jg.getText()+"'");
							stat4.executeUpdate("UPDATE Classificacao SET derrotas=derrotas+0 WHERE equipa='"+vitoria_jg.getText()+"'");
							stat5.executeUpdate("UPDATE Classificacao SET pontos=pontos+0 WHERE equipa='"+derrota_jg.getText()+"'");
							stat6.executeUpdate("UPDATE Classificacao SET vitorias=vitorias+0 WHERE equipa='"+derrota_jg.getText()+"'");
							stat7.executeUpdate("UPDATE Classificacao SET derrotas=derrotas+1 WHERE equipa='"+derrota_jg.getText()+"'");
							
							//Caso haja empate atualizar dados
							if(empate == 1){	
								stat8.executeUpdate("UPDATE Classificacao SET pontos=pontos+1 WHERE equipa='"+Edc_jg.toString()+"'");
								stat9.executeUpdate("UPDATE Classificacao SET pontos=pontos+1 WHERE equipa='"+Ev_jg.toString()+"'");
								stat10.executeUpdate("UPDATE Classificacao SET empates=empates+1 WHERE equipa='"+Edc_jg.toString()+"'");
								stat11.executeUpdate("UPDATE Classificacao SET empates=empates+1 WHERE equipa='"+Ev_jg.toString()+"'");				
							}
							
							JOptionPane.showMessageDialog(null, "Dados adicionados com sucesso!");
							
							Rnd_jg.setText("");
							Ddj_jg.setText("");
							vitoria_jg.setText("");
							derrota_jg.setText("");
		
							
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_10.setBackground(Color.WHITE);
		button_10.setBounds(-12, 183, 451, 35);
		panel_23.add(button_10);
		
		JLabel lblVitria = new JLabel("Vit\u00F3ria");
		lblVitria.setForeground(new Color(143, 188, 143));
		lblVitria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVitria.setBounds(10, 150, 100, 14);
		panel_23.add(lblVitria);
		
		JLabel lblDerrota = new JLabel("Derrota");
		lblDerrota.setForeground(new Color(233, 150, 122));
		lblDerrota.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDerrota.setBounds(158, 150, 100, 14);
		panel_23.add(lblDerrota);
		
		chck_empate = new JCheckBox("Empate");
		chck_empate.setBackground(new Color(0, 0, 0));
		chck_empate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		chck_empate.setForeground(new Color(240, 230, 140));
		chck_empate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(chck_empate.isSelected()){
					boolean disabled = false;
					vitoria_jg.setEnabled(disabled);
					derrota_jg.setEnabled(disabled);
					empate = 1;
				}else{
					boolean enabled = true;
					vitoria_jg.setEnabled(enabled);
					derrota_jg.setEnabled(enabled);
					empate = 0;
					
				}
			}
		});
		
		chck_empate.setBounds(318, 149, 97, 23);
		panel_23.add(chck_empate);
		
		JLabel lblGolosDoVisitante = new JLabel("Golos do Visitante");
		lblGolosDoVisitante.setForeground(new Color(139, 0, 0));
		lblGolosDoVisitante.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGolosDoVisitante.setBounds(210, 113, 113, 14);
		panel_23.add(lblGolosDoVisitante);
		
		golos_v = new JComboBox();
		golos_v.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"}));
		golos_v.setBounds(318, 113, 55, 20);
		panel_23.add(golos_v);
		
		JPanel panel_26 = new JPanel();
		panel_26.setBorder(new LineBorder(new Color(0, 128, 0), 2));
		panel_26.setBackground(new Color(0, 0, 0));
		panel_26.setBounds(5, 138, 416, 40);
		panel_23.add(panel_26);
		
		comboBox_add_ec = new JComboBox();
		comboBox_add_ec.setBounds(130, 36, 206, 20);
		panel_23.add(comboBox_add_ec);
		
		comboBox_add_v = new JComboBox();
		comboBox_add_v.setBounds(130, 62, 206, 20);
		panel_23.add(comboBox_add_v);
		
		JButton button_24 = new JButton("");
		button_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				//Carrega os dados para as comboBox (Administrator-Jogo-Nome da Equipa)
				try{
			   		DefaultComboBoxModel cb = (DefaultComboBoxModel) comboBox_add_ec.getModel();
			   		cb.removeAllElements();
					
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM Equipa");
					
				   	while(rs.next()){
				   		cb.addElement(rs.getString("nome_equipa"));			 
				   	}		
				   	
				}catch(SQLException se){
					   se.printStackTrace();
				}
			}
		});
		button_24.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\imagens\\refresh.png"));
		button_24.setForeground(Color.CYAN);
		button_24.setBackground(Color.WHITE);
		button_24.setBounds(346, 33, 27, 23);
		panel_23.add(button_24);
		
		JButton button_25 = new JButton("");
		button_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				//Carrega os dados para as comboBox (Administrator-Jogo-Nome da Equipa)
				try{
			   		DefaultComboBoxModel cb = (DefaultComboBoxModel) comboBox_add_v.getModel();
			   		cb.removeAllElements();
					
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM Equipa");
					
				   	while(rs.next()){
				   		cb.addElement(rs.getString("nome_equipa"));			 
				   	}		
				   	
				}catch(SQLException se){
					   se.printStackTrace();
				}
			}
		});
		button_25.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\imagens\\refresh.png"));
		button_25.setForeground(Color.CYAN);
		button_25.setBackground(Color.WHITE);
		button_25.setBounds(346, 59, 27, 23);
		panel_23.add(button_25);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBackground(Color.WHITE);
		tabbedPane_5.addTab("Eliminar", null, panel_25, null);
		panel_25.setLayout(null);
		
		JLabel lblEliminarJogoid = new JLabel("Eliminar Jogo [ID]");
		lblEliminarJogoid.setForeground(Color.BLACK);
		lblEliminarJogoid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEliminarJogoid.setBounds(10, 21, 97, 14);
		panel_25.add(lblEliminarJogoid);
		
		Jogo_eliminar = new JTextField();
		Jogo_eliminar.setColumns(10);
		Jogo_eliminar.setBounds(117, 19, 145, 20);
		panel_25.add(Jogo_eliminar);
		
		JButton button_6 = new JButton("Eliminar");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				//Elimina jogos por ID
				try {
					Statement stat = conn.createStatement();
					stat.executeUpdate("DELETE FROM Jogo WHERE id_jogo='"+ Jogo_eliminar.getText() +"'");
					JOptionPane.showMessageDialog(null, "Dados eliminados com sucesso!");	
					Jogo_eliminar.setText("");
										
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}
		});
		
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_6.setBackground(Color.WHITE);
		button_6.setBounds(-11, 170, 450, 35);
		panel_25.add(button_6);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\img\\bg6.jpg"));
		lblNewLabel_9.setBounds(0, 0, 450, 274);
		panel_12.add(lblNewLabel_9);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		tabbedPane_1.addTab("Marcadores", null, panel_13, null);
		panel_13.setLayout(null);
		
		JTabbedPane tabbedPane_6 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_6.setBounds(10, 11, 429, 252);
		panel_13.add(tabbedPane_6);
		
		JPanel panel_24 = new JPanel();
		panel_24.setBackground(Color.WHITE);
		tabbedPane_6.addTab("Adicionar", null, panel_24, null);
		panel_24.setLayout(null);
		
		marcador_Equipa = new JComboBox();
		marcador_Equipa.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				//Carrega o Plantel da equipa que é escolhida na combobox da Equipa.
				try{
					
			   		DefaultComboBoxModel cb = (DefaultComboBoxModel) marcador_Jogador.getModel();				  
			   		cb.removeAllElements();
					
			   		String equipa = (String) marcador_Equipa.getSelectedItem();
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT DISTINCT Jogador.nome_jogador FROM Plantel JOIN Jogador ON Plantel.id_jogador = Jogador.id_jogador WHERE Jogador.equipa = '"+equipa+"' ");
				   	while(rs.next()){
				   		cb.addElement(rs.getString("nome_jogador"));
			 
				   	}		
				   	
				}catch(SQLException se){
					   se.printStackTrace();
				}				
			}
		});
		
		marcador_Equipa.setBounds(126, 45, 188, 20);
		panel_24.add(marcador_Equipa);
		
		marcador_Jogador = new JComboBox();
		marcador_Jogador.setBounds(126, 73, 188, 20);
		panel_24.add(marcador_Jogador);
		
		JLabel lblEquipa_3 = new JLabel("Equipa");
		lblEquipa_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEquipa_3.setBounds(20, 48, 108, 14);
		panel_24.add(lblEquipa_3);
		
		JLabel lblNomeDoJogador_2 = new JLabel("Nome do jogador");
		lblNomeDoJogador_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeDoJogador_2.setBounds(20, 75, 108, 14);
		panel_24.add(lblNomeDoJogador_2);
		
		JLabel lblMinuto = new JLabel("Minuto");
		lblMinuto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMinuto.setBounds(20, 107, 108, 14);
		panel_24.add(lblMinuto);
		
		marcador_Minuto = new JTextField();
		marcador_Minuto.setBounds(126, 105, 112, 20);
		panel_24.add(marcador_Minuto);
		marcador_Minuto.setColumns(10);
		
		JLabel lblAutoGolo = new JLabel("Auto golo");
		lblAutoGolo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAutoGolo.setBounds(20, 136, 108, 14);
		panel_24.add(lblAutoGolo);
		
		JCheckBox marcador_Autogolo = new JCheckBox("");
		marcador_Autogolo.setBackground(Color.WHITE);
		marcador_Autogolo.setBounds(126, 132, 97, 23);
		panel_24.add(marcador_Autogolo);
		
		JButton button_20 = new JButton("Adicionar");
		button_20.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				
				String marcMinuto = marcador_Minuto.getText();
			
				if( marcMinuto.isEmpty()){
					JOptionPane.showMessageDialog(null, "É obrigatório preencher todos os campos.");
				}else{
						
					 //Ligação à base de dados.
					Connection conn = null;
					
					try{
						   Class.forName(JDBC_DRIVER); 
						   conn = DriverManager.getConnection(DB_URL);
					}catch(SQLException se){
						   se.printStackTrace();
					}catch(Exception e1){
						   e1.printStackTrace();
					}
					
					//Insere dados na tabela Equipa da base de dados.
					try {
						
						if(marcador_Autogolo.isSelected()){
							autogolo = "SIM";
						}else{
							autogolo = "NAO";
						}
						
						String marcIDjogo = (String) marcador_IDjogo.getSelectedItem();
						String marcNomeJogador = (String) marcador_Jogador.getSelectedItem();
						int marcID = 1 + (int)(Math.random() * ((999-1) + 1));
						String marMinuto = marcador_Minuto.getText();
						
						Statement stat = conn.createStatement();
						stat.executeUpdate("INSERT INTO Marcadores VALUES ("+ marcIDjogo.toString() +", '"+ marcNomeJogador.toString() +"', '"+ marcMinuto +"', '"+ autogolo +"', '"+ marcID +"')");
						JOptionPane.showMessageDialog(null, "Dados adicionados com sucesso!");	
						
						marcador_Minuto.setText("");
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}			
				}
			}
		});
		
		button_20.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_20.setBackground(Color.WHITE);
		button_20.setBounds(-11, 170, 447, 35);
		panel_24.add(button_20);
		
		JLabel lblIdDoJogo = new JLabel("ID do Jogo");
		lblIdDoJogo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdDoJogo.setBounds(20, 19, 108, 14);
		panel_24.add(lblIdDoJogo);
		
		marcador_IDjogo = new JComboBox();
		marcador_IDjogo.setBounds(126, 17, 188, 20);
		panel_24.add(marcador_IDjogo);
		
		JButton button_26 = new JButton("");
		button_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				//Carrega os dados para as comboBox (Administrator-Marcador-IDjogo)
				try{
					
			   		DefaultComboBoxModel cb = (DefaultComboBoxModel) marcador_IDjogo.getModel();				  
			   		cb.removeAllElements();
					
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM Jogo ");
					
				   	while(rs.next()){
				   		cb.addElement(rs.getString("id_jogo"));
			 
				   	}		
				   	
				}catch(SQLException se){
					   se.printStackTrace();
				}
			}
		});
		button_26.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\imagens\\refresh.png"));
		button_26.setForeground(Color.CYAN);
		button_26.setBackground(Color.WHITE);
		button_26.setBounds(324, 14, 27, 23);
		panel_24.add(button_26);
		
		JButton button_27 = new JButton("");
		button_27.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\imagens\\refresh.png"));
		button_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				//Carrega dados da Equipa para a combobox marcador_Equipa.
				try{
					
			   		DefaultComboBoxModel cb = (DefaultComboBoxModel) marcador_Equipa.getModel();				  
			   		cb.removeAllElements();
					
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT * FROM Equipa ");
					
				   	while(rs.next()){
				   		cb.addElement(rs.getString("nome_equipa"));
			 
				   	}		
				   	
				}catch(SQLException se){
					   se.printStackTrace();
				}
			}
		});
		button_27.setForeground(Color.CYAN);
		button_27.setBackground(Color.WHITE);
		button_27.setBounds(324, 42, 27, 23);
		panel_24.add(button_27);
		
		JButton button_28 = new JButton("");
		button_28.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\imagens\\refresh.png"));
		button_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				//Carrega o Plantel da equipa que é escolhida na combobox da Equipa para a combobox marcador_Jogdor.
				try{
					
			   		DefaultComboBoxModel cb = (DefaultComboBoxModel) marcador_Jogador.getModel();				  
			   		cb.removeAllElements();
					
			   		String equipa = (String) marcador_Equipa.getSelectedItem();
					Statement st = conn.createStatement();
					ResultSet rs = st.executeQuery("SELECT DISTINCT Jogador.nome_jogador FROM Plantel JOIN Jogador ON Plantel.id_jogador = Jogador.id_jogador WHERE Jogador.equipa = '"+equipa+"' ");
				   	while(rs.next()){
				   		cb.addElement(rs.getString("nome_jogador"));
			 
				   	}		
				   	
				}catch(SQLException se){
					   se.printStackTrace();
				}
			}
		});
		
		button_28.setForeground(Color.CYAN);
		button_28.setBackground(Color.WHITE);
		button_28.setBounds(324, 70, 27, 23);
		panel_24.add(button_28);
		
		JPanel panel_28 = new JPanel();
		panel_28.setBackground(Color.WHITE);
		tabbedPane_6.addTab("Eliminar", null, panel_28, null);
		panel_28.setLayout(null);
		
		JLabel lblEliminarMarcadorid = new JLabel("Eliminar Marcador [ID]");
		lblEliminarMarcadorid.setForeground(Color.BLACK);
		lblEliminarMarcadorid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEliminarMarcadorid.setBounds(10, 21, 119, 14);
		panel_28.add(lblEliminarMarcadorid);
		
		marcador_Eliminar = new JTextField();
		marcador_Eliminar.setColumns(10);
		marcador_Eliminar.setBounds(139, 19, 145, 20);
		panel_28.add(marcador_Eliminar);
		
		JButton button_21 = new JButton("Eliminar");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				//Eliminar Marcador por ID
				try {
					Statement stat = conn.createStatement();
					stat.executeUpdate("DELETE FROM Marcadores WHERE id_marcador='"+ marcador_Eliminar.getText() +"'");
					JOptionPane.showMessageDialog(null, "Dados eliminados com sucesso!");	
					marcador_Eliminar.setText("");
										
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}	
			}
		});
		
		button_21.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_21.setBackground(Color.WHITE);
		button_21.setBounds(-12, 170, 450, 35);
		panel_28.add(button_21);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\imagens\\bg6.jpg"));
		lblNewLabel_10.setBounds(0, 0, 450, 274);
		panel_13.add(lblNewLabel_10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(17, 33, 458, 14);
		menu.add(separator_1);
		
		JLabel lblAdministrador = new JLabel("Administrador");
		lblAdministrador.setForeground(new Color(0, 0, 102));
		lblAdministrador.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		lblAdministrador.setBackground(new Color(255, 153, 153));
		lblAdministrador.setBounds(160, 8, 156, 20);
		menu.add(lblAdministrador);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\img\\bg6.jpg"));
		label_1.setBounds(10, 41, 474, 349);
		menu.add(label_1);
		
		JButton button_22 = new JButton("Voltar");
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
				menu.setVisible(false);
			}
		});
		
		button_22.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\imagens\\undo.png"));
		button_22.setOpaque(false);
		button_22.setForeground(new Color(0, 0, 128));
		button_22.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_22.setContentAreaFilled(false);
		button_22.setBorderPainted(false);
		button_22.setBounds(1, 8, 89, 23);
		menu.add(button_22);
		
		
		menu2 = new JPanel();
		menu2.setBackground(new Color(255, 255, 255));
		menu2.setForeground(new Color(0, 0, 0));
		contentPane.add(menu2, "name_476462340410637");
		menu2.setLayout(null);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(17, 33, 458, 14);
		menu2.add(separator_3);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 48, 455, 302);
		menu2.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("");
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("\u00C9pocas", null, panel, null);
		panel.setLayout(null);

		
		
		JButton btnNewButton = new JButton("Procurar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				String x = (String) comboBox1.getSelectedItem();
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				//Carrega os dados ( * de Cada epoca) da BD para a Tabel.
			    try
			    {
					DefaultTableModel dm = (DefaultTableModel)table.getModel();
					dm.getDataVector().removeAllElements();
					dm.fireTableDataChanged();
					
			        Statement stat = conn.createStatement();
			        ResultSet rs = stat.executeQuery("SELECT * FROM Epoca WHERE designacao='"+x+"'");
			        
			        int colunas = rs.getMetaData().getColumnCount();
			        
			        while(rs.next())
			        {  
			            Object[] row = new Object[colunas];
			            for (int i = 1; i <= colunas; i++)
			            {  
			                row[i - 1] = rs.getObject(i);
			            }
			            ((DefaultTableModel) table.getModel()).insertRow(rs.getRow()-1,row); 
			        }
			        rs.close();
			        stat.close();
			        conn.close();
			    }
			    
			    catch (SQLException e)
			    {
			    }
	
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 71, 429, 31);
		panel.add(btnNewButton);
		
		comboBox1 = new JComboBox();
		comboBox1.setToolTipText("Escolha a \u00C9poca e clique em Procurar.");
		comboBox1.setBounds(10, 36, 105, 20);
		panel.add(comboBox1);
		
		
		
		
		
		JLabel lblDesignao = new JLabel("\u00C9pocas");
		lblDesignao.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDesignao.setBounds(10, 11, 83, 14);
		panel.add(lblDesignao);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new CompoundBorder());
		scrollPane.setBounds(10, 113, 429, 150);
		panel.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3d", "Designa\u00E7\u00E3o", "Data de Inicio", "Data de Fim"
			}
		));
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(44);
		table.getColumnModel().getColumn(1).setPreferredWidth(214);
		table.getColumnModel().getColumn(2).setPreferredWidth(226);
		table.getColumnModel().getColumn(3).setPreferredWidth(285);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		

		table.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		
		JCheckBox checkBox2 = new JCheckBox("");
		checkBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(checkBox2.isSelected()){
					
					//Ligação à base de dados.
					Connection conn = null;
					
					try{
						   Class.forName(JDBC_DRIVER); 
						   conn = DriverManager.getConnection(DB_URL);
					}catch(SQLException se){
						   se.printStackTrace();
					}catch(Exception e1){
						   e1.printStackTrace();
					}
					
					//Carrega todos os dados para a Table1.
				    try
				    {
						DefaultTableModel dm = (DefaultTableModel)table.getModel();
						dm.getDataVector().removeAllElements();
						dm.fireTableDataChanged();
						
				        Statement stat = conn.createStatement();
				        ResultSet rs = stat.executeQuery("SELECT * FROM Epoca");
				        
				        int colunas = rs.getMetaData().getColumnCount();
				        
				        while(rs.next())
				        {  
				            Object[] row = new Object[colunas];
				            for (int i = 1; i <= colunas; i++)
				            {  
				                row[i - 1] = rs.getObject(i);
				            }
				            ((DefaultTableModel) table.getModel()).insertRow(rs.getRow()-1,row);  
				        }
				        rs.close();
				        stat.close();
				        conn.close();
				    }
				    
				    catch (SQLException e1)
				    {
				    }
					
				}else{
					DefaultTableModel dm = (DefaultTableModel)table.getModel();
					dm.getDataVector().removeAllElements();
					dm.fireTableDataChanged();
				}	
			}
		});
		checkBox2.setVerticalAlignment(SwingConstants.TOP);
		checkBox2.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox2.setBounds(400, 23, 35, 23);
		panel.add(checkBox2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBounds(252, 17, 187, 34);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblMostrarTodasAs_1 = new JLabel("Mostrar todas as \u00C9pocas");
		lblMostrarTodasAs_1.setBounds(9, 10, 134, 15);
		lblMostrarTodasAs_1.setForeground(new Color(0, 0, 102));
		lblMostrarTodasAs_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_5.add(lblMostrarTodasAs_1);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Equipas", null, panel_1, null);
		panel_1.setLayout(null);
		
		JButton button = new JButton("Procurar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String x = (String) comboBox2.getSelectedItem();
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				//Carrega os dados ( * de Cada epoca) da BD para a Tabel.
			    try
			    {
					DefaultTableModel dm = (DefaultTableModel)table2.getModel();
					dm.getDataVector().removeAllElements();
					dm.fireTableDataChanged();
					
			        Statement stat = conn.createStatement();
			        ResultSet rs = stat.executeQuery("SELECT * FROM Equipa WHERE nome_equipa='"+x+"'");
			        
			        int colunas = rs.getMetaData().getColumnCount();
			        
			        while(rs.next())
			        {  
			            Object[] row = new Object[colunas];
			            for (int i = 1; i <= colunas; i++)
			            {  
			                row[i - 1] = rs.getObject(i);
			            }
			            ((DefaultTableModel) table2.getModel()).insertRow(rs.getRow()-1,row);			            			            
			        }
			        rs.close();
			        stat.close();
			        conn.close();
			    }
			    
			    catch (SQLException e)
			    {
			    }				
			}
		});
		
		JLabel lblMostrarTodasAs = new JLabel("Mostrar todas as Equipas");
		lblMostrarTodasAs.setForeground(new Color(0, 0, 102));
		lblMostrarTodasAs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMostrarTodasAs.setBounds(261, 27, 137, 14);
		panel_1.add(lblMostrarTodasAs);
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(10, 71, 429, 31);
		panel_1.add(button);
		
		JLabel lblEquipas = new JLabel("Equipas");
		lblEquipas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEquipas.setBounds(10, 11, 83, 14);
		panel_1.add(lblEquipas);
		
		comboBox2 = new JComboBox();
		comboBox2.setToolTipText("Escolha a Equipa e clique em Procurar.");
		comboBox2.setBounds(10, 36, 105, 20);
		panel_1.add(comboBox2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 113, 429, 150);
		panel_1.add(scrollPane_1);
		
		table2 = new JTable();
		table2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3d", "Nome da Equipa", "Nome do Est\u00E1dio", "Data de Funda\u00E7\u00E3o"
			}
		));
		
		table2.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table2.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table2.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table2.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table2.getColumnModel().getColumn(0).setResizable(false);
		table2.getColumnModel().getColumn(0).setPreferredWidth(41);
		table2.getColumnModel().getColumn(1).setResizable(false);
		table2.getColumnModel().getColumn(1).setPreferredWidth(183);
		table2.getColumnModel().getColumn(2).setResizable(false);
		table2.getColumnModel().getColumn(2).setPreferredWidth(243);
		table2.getColumnModel().getColumn(3).setResizable(false);
		table2.getColumnModel().getColumn(3).setPreferredWidth(226);
		table2.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		
		
		
		table2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane_1.setViewportView(table2);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkBox.isSelected()){
					
					//Ligação à base de dados.
					Connection conn = null;
					
					try{
						   Class.forName(JDBC_DRIVER); 
						   conn = DriverManager.getConnection(DB_URL);
					}catch(SQLException se){
						   se.printStackTrace();
					}catch(Exception e1){
						   e1.printStackTrace();
					}
					
					//Carrega todos os dados para a Table2.
				    try
				    {
						DefaultTableModel dm = (DefaultTableModel)table2.getModel();
						dm.getDataVector().removeAllElements();
						dm.fireTableDataChanged();
						
				        Statement stat = conn.createStatement();
				        ResultSet rs = stat.executeQuery("SELECT * FROM Equipa");
				        
				        int colunas = rs.getMetaData().getColumnCount();
				        
				        while(rs.next())
				        {  
				            Object[] row = new Object[colunas];
				            for (int i = 1; i <= colunas; i++)
				            {  
				                row[i - 1] = rs.getObject(i);
				            }
				            ((DefaultTableModel) table2.getModel()).insertRow(rs.getRow()-1,row);				            			            
				        }
				        rs.close();
				        stat.close();
				        conn.close();
				    }
				    
				    catch (SQLException e)
				    {
				    }
					
				}else{
					DefaultTableModel dm = (DefaultTableModel)table2.getModel();
					dm.getDataVector().removeAllElements();
					dm.fireTableDataChanged();
				}		
			}
		});
		checkBox.setVerticalAlignment(SwingConstants.TOP);
		checkBox.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox.setBounds(400, 23, 35, 23);
		panel_1.add(checkBox);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(252, 17, 187, 34);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Jogadores", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblJogadores = new JLabel("Nome do Jogador");
		lblJogadores.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblJogadores.setBounds(10, 11, 116, 14);
		panel_2.add(lblJogadores);
		
		Txt = new JTextField();
		Txt.setToolTipText("Insira o Nome ou a letra do jogador que deseja procurar.");
		Txt.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				//Carrega todos os campos da tabela Jogador, consoante o que for inserido na caixa de texto "Txt"
			    try
			    {
					DefaultTableModel dm = (DefaultTableModel)table3.getModel();
					dm.getDataVector().removeAllElements();
					dm.fireTableDataChanged();
					
			        Statement stat = conn.createStatement();
			        ResultSet rs = stat.executeQuery("SELECT * FROM Jogador WHERE nome_jogador LIKE '"+Txt.getText()+"%'");
			        
			        int colunas = rs.getMetaData().getColumnCount();
			        
			        while(rs.next())
			        {  
			            Object[] row = new Object[colunas];
			            for (int i = 1; i <= colunas; i++)
			            {  
			                row[i - 1] = rs.getObject(i);
			            }
			            ((DefaultTableModel) table3.getModel()).insertRow(rs.getRow()-1,row);			            			            
			        }
			        rs.close();
			        stat.close();
			        conn.close();
			    }
			    
			    catch (SQLException e1)
			    {
			    }	    
			}
		});


		Txt.setBounds(10, 31, 429, 20);
		panel_2.add(Txt);
		Txt.setColumns(10);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 69, 429, 194);
		panel_2.add(scrollPane_2);
		
		table3 = new JTable();
		table3.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3d", "Nome do Jogador", "Equipa", "Data de N.", "Pos"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table3.getColumnModel().getColumn(0).setResizable(false);
		table3.getColumnModel().getColumn(0).setPreferredWidth(40);
		table3.getColumnModel().getColumn(1).setResizable(false);
		table3.getColumnModel().getColumn(1).setPreferredWidth(200);
		table3.getColumnModel().getColumn(2).setPreferredWidth(110);
		table3.getColumnModel().getColumn(2).setMaxWidth(2147483645);
		table3.getColumnModel().getColumn(3).setResizable(false);
		table3.getColumnModel().getColumn(4).setPreferredWidth(47);
		scrollPane_2.setViewportView(table3);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Jogos", null, panel_3, null);
		panel_3.setLayout(null);
		
		JCheckBox checkBox3 = new JCheckBox("");
		checkBox3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					if(checkBox3.isSelected()){
					
					//Ligação à base de dados.
					Connection conn = null;
					
					try{
						   Class.forName(JDBC_DRIVER); 
						   conn = DriverManager.getConnection(DB_URL);
					}catch(SQLException se){
						   se.printStackTrace();
					}catch(Exception e1){
						   e1.printStackTrace();
					}
					
					//Carrega todos os campos da tabela Jogo da bd para a Table4.
				    try
				    {
						DefaultTableModel dm = (DefaultTableModel)table4.getModel();
						dm.getDataVector().removeAllElements();
						dm.fireTableDataChanged();
						
				        Statement stat = conn.createStatement();
				        ResultSet rs = stat.executeQuery("SELECT * FROM Jogo");
				        
				        int colunas = rs.getMetaData().getColumnCount();
				        
				        while(rs.next())
				        {  
				            Object[] row = new Object[colunas];
				            for (int i = 1; i <= colunas; i++)
				            {  
				                row[i - 1] = rs.getObject(i);
				            }
				            ((DefaultTableModel) table4.getModel()).insertRow(rs.getRow()-1,row);			         		            
				        }
				        rs.close();
				        stat.close();
				        conn.close();
				    }
				    
				    catch (SQLException e1)
				    {
				    }
					
				}else{
					DefaultTableModel dm = (DefaultTableModel)table4.getModel();
					dm.getDataVector().removeAllElements();
					dm.fireTableDataChanged();
				}				
			}
		});
		
		checkBox3.setVerticalAlignment(SwingConstants.TOP);
		checkBox3.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox3.setBounds(400, 23, 35, 23);
		panel_3.add(checkBox3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(252, 17, 187, 34);
		panel_3.add(panel_6);
		
		JLabel lblMostrarTodasOs = new JLabel("Mostrar todos os Jogos");
		lblMostrarTodasOs.setForeground(new Color(0, 0, 102));
		lblMostrarTodasOs.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMostrarTodasOs.setBounds(9, 10, 137, 14);
		panel_6.add(lblMostrarTodasOs);
		
		JLabel lblEquipa = new JLabel("Equipa");
		lblEquipa.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEquipa.setBounds(10, 11, 83, 14);
		panel_3.add(lblEquipa);
		
		comboBox3 = new JComboBox();
		comboBox3.setToolTipText("Escolha a Equipa para encontrar um jogo.");
		comboBox3.setBounds(10, 31, 101, 20);
		panel_3.add(comboBox3);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblData.setBounds(123, 11, 83, 14);
		panel_3.add(lblData);
		
		JButton button_1 = new JButton("Procurar");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
							
				DefaultTableModel dm = (DefaultTableModel)table4.getModel();
				dm.getDataVector().removeAllElements();
				dm.fireTableDataChanged();
				
				String x = (String) comboBox3.getSelectedItem();
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				//Carrega os dados dos jogos em relação à Época e as Equipas.
			    try
			    {
					
			        Statement stat = conn.createStatement();
			        ResultSet rs = stat.executeQuery("SELECT * FROM Jogo WHERE equipa_casa='"+x+"' OR equipa_visitante='"+x+"'");
			        
			        int colunas = rs.getMetaData().getColumnCount();
			        
			        while(rs.next())
			        {  
			            Object[] row = new Object[colunas];
			            for (int i = 1; i <= colunas; i++)
			            {  
			                row[i - 1] = rs.getObject(i);
			            }
			            ((DefaultTableModel) table4.getModel()).insertRow(rs.getRow()-1,row);			            			          
			        }

			        rs.close();
			        stat.close();
			        conn.close();
			    }
			    
			    catch (SQLException e)
			    {
			    }					
			}
		});
		
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBounds(10, 71, 429, 31);
		panel_3.add(button_1);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 113, 429, 150);
		panel_3.add(scrollPane_3);
		
		table4 = new JTable();
		table4.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3d", "Equipa da Casa", "Equipa Visitante", "Data", "Golos C.", "Golos V."
			}
		));
		table4.getColumnModel().getColumn(0).setPreferredWidth(48);
		table4.getColumnModel().getColumn(1).setPreferredWidth(160);
		table4.getColumnModel().getColumn(2).setPreferredWidth(165);
		table4.getColumnModel().getColumn(3).setPreferredWidth(114);
		table4.getColumnModel().getColumn(4).setPreferredWidth(101);
		table4.getColumnModel().getColumn(5).setPreferredWidth(102);
		scrollPane_3.setViewportView(table4);
		
		Txt2 = new JTextField();
		Txt2.setToolTipText("Escreva o dia, o m\u00EAs ou o ano do jogo.");
		Txt2.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {			
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				//Carrega todos os campos da tabela Jogo começados pela data inserida na caixa de texto Txt.
			    try
			    {
					DefaultTableModel dm = (DefaultTableModel)table4.getModel();
					dm.getDataVector().removeAllElements();
					dm.fireTableDataChanged();
					
			        Statement stat = conn.createStatement();
			        ResultSet rs = stat.executeQuery("SELECT * FROM Jogo WHERE data LIKE '%"+Txt2.getText()+"%'");
			        
			        int colunas = rs.getMetaData().getColumnCount();
			        
			        while(rs.next())
			        {  
			            Object[] row = new Object[colunas];
			            for (int i = 1; i <= colunas; i++)
			            {  
			                row[i - 1] = rs.getObject(i);
			            }
			            ((DefaultTableModel) table4.getModel()).insertRow(rs.getRow()-1,row);			            			            
			        }
			        rs.close();
			        stat.close();
			        conn.close();
			    }
			    
			    catch (SQLException e1)
			    {
			    }				
			}
		});
		
		Txt2.setBounds(121, 31, 101, 20);
		panel_3.add(Txt2);
		Txt2.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setForeground(new Color(0, 0, 153));
		panel_7.setBackground(Color.WHITE);
		tabbedPane.addTab("Classifica\u00E7\u00E3o", null, panel_7, null);
		panel_7.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 50, 430, 213);
		panel_7.add(scrollPane_4);
		
		table5 = new JTable();
		table5.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3d", "Equipa", "Pontos", "Vit\u00F3rias", "Empates", "Derrotas"
			}
		));
		table5.getColumnModel().getColumn(0).setPreferredWidth(42);
		table5.getColumnModel().getColumn(1).setPreferredWidth(167);
		table5.getColumnModel().getColumn(2).setPreferredWidth(90);
		table5.getColumnModel().getColumn(3).setPreferredWidth(83);
		table5.getColumnModel().getColumn(4).setPreferredWidth(81);
		table5.getColumnModel().getColumn(5).setPreferredWidth(89);
		
		
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(table5.getModel());
		table5.setRowSorter(sorter);
		List<RowSorter.SortKey> sortKeys = new ArrayList<>();
		
		int columnIndexToSort = 2;
		sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
		 
		sorter.setSortKeys(sortKeys);
		sorter.sort();
		scrollPane_4.setViewportView(table5);
		table5.setForeground(new Color(0, 0, 204));
		
		JLabel lblTabelaClassificativa = new JLabel("Tabela Classificativa");
		lblTabelaClassificativa.setForeground(new Color(0, 0, 153));
		lblTabelaClassificativa.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTabelaClassificativa.setBounds(145, 11, 163, 14);
		panel_7.add(lblTabelaClassificativa);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {								
					
					 //Ligação à base de dados.
					Connection conn = null;
					
					try{
						   Class.forName(JDBC_DRIVER); 
						   conn = DriverManager.getConnection(DB_URL);
					}catch(SQLException se){
						   se.printStackTrace();
					}catch(Exception e1){
						   e1.printStackTrace();
					}
					//Carrega todos os campos da tabela Classificacao da db para a Table5.
				    try
				    {
						DefaultTableModel dm = (DefaultTableModel)table5.getModel();
						dm.getDataVector().removeAllElements();
						dm.fireTableDataChanged();
						
				        Statement stat = conn.createStatement();
				        ResultSet rs = stat.executeQuery("SELECT * FROM Classificacao");
				        
				        int colunas = rs.getMetaData().getColumnCount();
				        
				        while(rs.next())
				        {  
				            Object[] row = new Object[colunas];
				            for (int i = 1; i <= colunas; i++)
				            {  
				                row[i - 1] = rs.getObject(i);
				            }
				            ((DefaultTableModel) table5.getModel()).insertRow(rs.getRow()-1,row);        
				        }
				        rs.close();
				        stat.close();
				        conn.close();
				    }
				    
				    catch (SQLException e1)
				    {
				    }			    
			}
		});
		
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAtualizar.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\img\\refresh.png"));
		btnAtualizar.setBounds(10, 25, 102, 23);
		panel_7.add(btnAtualizar);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		tabbedPane.addTab("Estat\u00EDstica", null, panel_8, null);
		panel_8.setLayout(null);
		
		estat_Equipa = new JComboBox();
		estat_Equipa.setBounds(88, 31, 115, 20);
		panel_8.add(estat_Equipa);
		
		JLabel lblNewLabel_11 = new JLabel("Equipa");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(10, 33, 46, 14);
		panel_8.add(lblNewLabel_11);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setForeground(new Color(0, 0, 128));
		separator_5.setBounds(10, 62, 430, 10);
		panel_8.add(separator_5);
		
		JPanel panel_27 = new JPanel();
		panel_27.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_27.setBounds(10, 73, 430, 190);
		panel_8.add(panel_27);
		panel_27.setLayout(null);
		
		JLabel lblTotalDeGolos = new JLabel("Total de Golos:");
		lblTotalDeGolos.setBounds(24, 11, 95, 14);
		panel_27.add(lblTotalDeGolos);
		lblTotalDeGolos.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblMdiaDeGolos = new JLabel("Autogolos:");
		lblMdiaDeGolos.setBounds(24, 45, 139, 14);
		panel_27.add(lblMdiaDeGolos);
		lblMdiaDeGolos.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		ttl_Golos = new JTextField();
		ttl_Golos.setHorizontalAlignment(SwingConstants.CENTER);
		ttl_Golos.setEditable(false);
		ttl_Golos.setForeground(new Color(128, 0, 0));
		ttl_Golos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ttl_Golos.setBounds(209, 8, 106, 20);
		panel_27.add(ttl_Golos);
		ttl_Golos.setColumns(10);
		
		ttl_Autogolos = new JTextField();
		ttl_Autogolos.setHorizontalAlignment(SwingConstants.CENTER);
		ttl_Autogolos.setEditable(false);
		ttl_Autogolos.setForeground(new Color(128, 0, 0));
		ttl_Autogolos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ttl_Autogolos.setColumns(10);
		ttl_Autogolos.setBounds(209, 42, 106, 20);
		panel_27.add(ttl_Autogolos);
		
		JPanel panel_29 = new JPanel();
		panel_29.setBorder(new LineBorder(new Color(0, 0, 128)));
		panel_29.setBounds(10, 70, 410, 109);
		panel_27.add(panel_29);
		panel_29.setLayout(null);
		
		mm_MediaMinutosGolos = new JTextField();
		mm_MediaMinutosGolos.setHorizontalAlignment(SwingConstants.CENTER);
		mm_MediaMinutosGolos.setEditable(false);
		mm_MediaMinutosGolos.setBounds(197, 77, 106, 21);
		panel_29.add(mm_MediaMinutosGolos);
		mm_MediaMinutosGolos.setForeground(new Color(255, 69, 0));
		mm_MediaMinutosGolos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mm_MediaMinutosGolos.setColumns(10);
		
		mm_Golos = new JTextField();
		mm_Golos.setHorizontalAlignment(SwingConstants.CENTER);
		mm_Golos.setEditable(false);
		mm_Golos.setBounds(197, 42, 106, 20);
		panel_29.add(mm_Golos);
		mm_Golos.setForeground(new Color(255, 69, 0));
		mm_Golos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mm_Golos.setColumns(10);
		
		melhor_Marcador = new JTextField();
		melhor_Marcador.setHorizontalAlignment(SwingConstants.CENTER);
		melhor_Marcador.setEditable(false);
		melhor_Marcador.setBounds(197, 10, 106, 20);
		panel_29.add(melhor_Marcador);
		melhor_Marcador.setForeground(new Color(255, 69, 0));
		melhor_Marcador.setFont(new Font("Tahoma", Font.PLAIN, 12));
		melhor_Marcador.setColumns(10);
		
		JLabel lblMdiaDeMinutos = new JLabel("M\u00E9dia de minutos de golos");
		lblMdiaDeMinutos.setBounds(12, 80, 175, 14);
		panel_29.add(lblMdiaDeMinutos);
		lblMdiaDeMinutos.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblGolos = new JLabel("Golos:");
		lblGolos.setBounds(12, 45, 129, 14);
		panel_29.add(lblGolos);
		lblGolos.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblMelhorMarcador = new JLabel("Melhor Marcador:");
		lblMelhorMarcador.setBounds(12, 18, 129, 14);
		panel_29.add(lblMelhorMarcador);
		lblMelhorMarcador.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Ligação à base de dados.
				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				try {
					String estatisticaEquipa = (String) estat_Equipa.getSelectedItem();
					Statement stat = conn.createStatement();
					ResultSet rs = stat.executeQuery("Select Count(Marcadores.nome_jogador) as TotaldeGolos From Marcadores Join Jogador On Marcadores.nome_jogador = Jogador.nome_jogador Where Jogador.equipa='"+ estatisticaEquipa.toString() +"' AND Marcadores.autogolo='NAO'");
					while(rs.next()){
				   		String totalGolos = rs.getString("TotaldeGolos");
				   		ttl_Golos.setText(totalGolos);
				   	}
				   	
				   	ResultSet rs2 = stat.executeQuery("Select Count(Marcadores.autogolo) as Autogolos From Marcadores Join Jogador On Marcadores.nome_jogador = Jogador.nome_jogador Where Jogador.equipa='"+ estatisticaEquipa.toString() +"' AND Marcadores.autogolo='SIM'");
				   	while(rs2.next()){
				   		String totalAutogolos = rs2.getString("Autogolos");
				   		ttl_Autogolos.setText(totalAutogolos);
				   	}
				   	
				   	ResultSet rs3 = stat.executeQuery("Select Marcadores.nome_jogador as Mmarcador From Marcadores Join Jogador On Marcadores.nome_jogador = Jogador.nome_jogador Where Jogador.equipa='"+ estatisticaEquipa.toString() +"' AND Marcadores.autogolo='NAO' LIMIT 1");
				   	while(rs3.next()){
				   		String melhorMarcador = rs3.getString("Mmarcador");
				   		melhor_Marcador.setText(melhorMarcador);
				   	}
				   	
				   	ResultSet rs4 = stat.executeQuery("Select Count(Marcadores.nome_jogador) as mmGolos From Marcadores Join Jogador On Marcadores.nome_jogador = Jogador.nome_jogador Where Jogador.nome_jogador='"+ melhor_Marcador.getText() +"' AND Marcadores.autogolo='NAO'");
				   	while(rs4.next()){
				   		String mmGolos = rs4.getString("mmGolos");
				   		mm_Golos.setText(mmGolos);
				   	}
				   	
				   	ResultSet rs5 = stat.executeQuery("Select AVG(Marcadores.minuto) as MediaMinutosGolos From Marcadores Join Jogador On Marcadores.nome_jogador = Jogador.nome_jogador Where Jogador.nome_jogador='"+ melhor_Marcador.getText() +"' AND Marcadores.autogolo='NAO'");
				   	while(rs5.next()){
				   		String mediaMGolos = rs5.getString("MediaMinutosGolos");
				   		mm_MediaMinutosGolos.setText(mediaMGolos);
				   	}
				   	
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\imagens\\check.png"));
		btnNewButton_2.setBounds(204, 26, 46, 31);
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		panel_8.add(btnNewButton_2);
		
		JLabel lblVisitante = new JLabel("Visitante");
		lblVisitante.setForeground(new Color(0, 0, 102));
		lblVisitante.setBackground(new Color(255, 153, 153));
		lblVisitante.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		lblVisitante.setBounds(200, 8, 97, 20);
		menu2.add(lblVisitante);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\img\\bg7.jpg"));
		lblNewLabel_2.setBounds(10, 41, 474, 349);
		menu2.add(lblNewLabel_2);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login.setVisible(true);
				menu2.setVisible(false);
			}
		});
		
		btnVoltar.setForeground(new Color(0, 0, 128));
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\imagens\\undo.png"));
		btnVoltar.setBounds(1, 8, 89, 23);
		btnVoltar.setOpaque(false);
		btnVoltar.setContentAreaFilled(false);
		btnVoltar.setBorderPainted(false);
		menu2.add(btnVoltar);
		
		
	
	}

	
	
	protected JComboBox getComboBox1() {
		return comboBox1;
	}
	protected JTable getTable() {
		return table;
	}
	protected JComboBox getComboBox2() {
		return comboBox2;
	}
	protected JTextField getTxt() {
		return Txt;
	}

	protected JComboBox getComboBox3() {
		return comboBox3;
	}
	protected JTextField getTxt2() {
		return Txt2;
	}
	protected JTable getTable5() {
		return table5;
	}
	public JTextField getRnd() {
		return Rnd_ep;
	}
	protected JComboBox getComboBox_editar_ep() {
		return comboBox_editar_ep;
	}
	protected JTextField getTextField_4() {
		return textField_4;
	}
	protected JComboBox getComboBox_eliminar() {
		return comboBox_eliminar_ep;
	}
	protected JComboBox getComboBox_editar_eq() {
		return comboBox_editar_eq;
	}
	protected JComboBox getComboBox_eliminar_eq() {
		return comboBox_eliminar_eq;
	}
	protected JTextField getTextField_7() {
		return textField_7;
	}
	public JTextField getTextField_8() {
		return textField_8;
	}
	public JTextField getTextField_9() {
		return textField_9;
	}
	protected JTextField getPassword() {
		return password;
	}
	protected JComboBox getGolos_v() {
		return golos_v;
	}
	protected JComboBox getComboBox_add_ec() {
		return comboBox_add_ec;
	}
	protected JComboBox getComboBox_add_v() {
		return comboBox_add_v;
	}
	protected JComboBox getEq_jgd() {
		return Eq_jgd;
	}
	protected JCheckBox getChck_empate() {
		return chck_empate;
	}
	protected JComboBox getMarcador_Equipa() {
		return marcador_Equipa;
	}
	protected JComboBox getMarcar_Jogador() {
		return marcador_Jogador;
	}
	protected JComboBox getMarcador_IDjogo() {
		return marcador_IDjogo;
	}
	protected JComboBox getEstat_Equipa() {
		return estat_Equipa;
	}
}
