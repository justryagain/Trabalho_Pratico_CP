import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
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
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
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



public class Login extends JFrame {

	public static final String JDBC_DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:basededados.sqlite";
	private JTextField username;
	private JTextField password;
	private JPanel menu;
	private JPanel menu2;
	private JTable table;
	
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\img\\logo.jpg"));
		
		

		setResizable(false);
		setTitle("TP CP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 405);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel login = new JPanel();
		contentPane.add(login, "name_951077403946935");
		login.setLayout(null);
		
		username = new JTextField();
		username.setForeground(new Color(0, 0, 204));
		username.setBounds(173, 51, 112, 20);
		login.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setToolTipText("");
		password.setForeground(new Color(0, 0, 204));
		password.setBounds(173, 97, 112, 20);
		login.add(password);
		password.setColumns(10);
		
		JButton btnSign = new JButton("Entrar");
		btnSign.setForeground(new Color(0, 0, 102));
		btnSign.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		btnSign.setBackground(new Color(153, 153, 204));
		btnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = username.getText();
				String pass = password.getText();
				
				if (user.equals("admin") && pass.equals("admin")){
				
					login.setVisible(false);
					menu.setVisible(true);
					setBounds(100, 100, 500, 400);
					
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
				setBounds(100, 100, 500, 405);
				
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
									
					Statement st = conn.createStatement();

				   ResultSet rs = st.executeQuery("SELECT * FROM Epoca");
				while(rs.next()){
					DefaultComboBoxModel cb = (DefaultComboBoxModel) comboBox1.getModel();
				    cb.addElement(rs.getString("designacao"));
				    
				    
				   }
				
				}catch(SQLException se){
					   se.printStackTrace();
				}
				
				
				
				//Carrega os dados (Nome das Equipas) da BD para a comboBox.
				try{
									
					Statement st = conn.createStatement();

				   ResultSet rs = st.executeQuery("SELECT * FROM Equipa");
				while(rs.next()){
					DefaultComboBoxModel cb2 = (DefaultComboBoxModel) comboBox2.getModel();
					DefaultComboBoxModel cb3 = (DefaultComboBoxModel) comboBox3.getModel();
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
			        ResultSet rs = stat.executeQuery("SELECT * FROM Jogador");
			        
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
		lblNewLabel_1.setBounds(0, 0, 484, 367);
		login.add(lblNewLabel_1);
		
		menu = new JPanel();
		contentPane.add(menu, "name_951077423084622");
		menu.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 33, 464, 12);
		menu.add(separator_1);
		
		
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
		panel.setToolTipText("Escolha a \u00C9poca e clique em Procurar.");
		panel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("\u00C9poca", null, panel, null);
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
					
					//Carrega todos os dados para a Table2.
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
		tabbedPane.addTab("Equipa", null, panel_1, null);
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
				
				//Carrega todos os dados para a Table3.
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
				"C\u00F3d", "Nome do Jogador", "Data de Nascimento", "Posi\u00E7\u00E3o de Jogo"
			}
		));
		
		
		table3.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table3.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table3.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table3.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table3.getColumnModel().getColumn(0).setResizable(false);
		table3.getColumnModel().getColumn(1).setResizable(false);
		table3.getColumnModel().getColumn(2).setResizable(false);
		table3.getColumnModel().getColumn(3).setResizable(false);
		table3.getColumnModel().getColumn(0).setPreferredWidth(40);
		table3.getColumnModel().getColumn(1).setPreferredWidth(286);
		table3.getColumnModel().getColumn(2).setPreferredWidth(171);
		table3.getColumnModel().getColumn(3).setPreferredWidth(194);
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
					
					//Carrega todos os dados para a Table4.
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
				
				//Carrega todos os dados para a Table3.
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
		
		JLabel lblVisitante = new JLabel("Visitante");
		lblVisitante.setForeground(new Color(0, 0, 102));
		lblVisitante.setBackground(new Color(255, 153, 153));
		lblVisitante.setFont(new Font("Segoe UI Light", Font.PLAIN, 25));
		lblVisitante.setBounds(200, 8, 97, 20);
		menu2.add(lblVisitante);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\img\\bg7.jpg"));
		lblNewLabel_2.setBounds(17, 41, 463, 315);
		menu2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Voltar");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				login.setVisible(true);
				menu2.setVisible(false);		
			}
		});
		lblNewLabel_3.setForeground(new Color(25, 25, 112));
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Andrei\\Desktop\\TP\\Trabalho_Pratico_CP\\img\\undo.png"));
		lblNewLabel_3.setBounds(17, 8, 67, 20);
		menu2.add(lblNewLabel_3);
		
		
	
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
}
