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
		
		

		setResizable(false);
		setTitle("Login");
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
		username.setBounds(94, 55, 103, 20);
		login.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setBounds(94, 106, 103, 20);
		login.add(password);
		password.setColumns(10);
		
		JButton btnSign = new JButton("Sign In");
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
		btnSign.setBounds(104, 137, 74, 23);
		login.add(btnSign);
		

		
		
		
		


		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 209, 254, 14);
		login.add(separator);
		
		JButton btnVisitor = new JButton("Visitor");
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
			
			
			}

		});
		btnVisitor.setBounds(104, 171, 74, 23);
		login.add(btnVisitor);
		
		menu = new JPanel();
		contentPane.add(menu, "name_951077423084622");
		menu.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 33, 464, 12);
		menu.add(separator_1);
		
		
		menu2 = new JPanel();
		contentPane.add(menu2, "name_476462340410637");
		menu2.setLayout(null);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 33, 464, 14);
		menu2.add(separator_3);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 48, 454, 302);
		menu2.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("\u00C9poca", null, panel, null);
		panel.setLayout(null);

		
		
		JButton btnNewButton = new JButton("Procurar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String x = (String) comboBox1.getSelectedItem();

				Connection conn = null;
				
				try{
					   Class.forName(JDBC_DRIVER); 
					   conn = DriverManager.getConnection(DB_URL);
				}catch(SQLException se){
					   se.printStackTrace();
				}catch(Exception e1){
					   e1.printStackTrace();
				}
				
				
			    try
			    {
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
		
		
		
		
		
		JLabel lblDesignao = new JLabel("Designa\u00E7\u00E3o");
		lblDesignao.setFont(new Font("Tahoma", Font.BOLD, 11));
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
				"ID", "Designação", "Data de Inicio", "Data de Fim"
			}
		));
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(0).setPreferredWidth(44);
		table.getColumnModel().getColumn(1).setPreferredWidth(214);
		table.getColumnModel().getColumn(2).setPreferredWidth(226);
		table.getColumnModel().getColumn(3).setPreferredWidth(285);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Equipa", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Jogadores", null, panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Jogos", null, panel_3, null);
		
		
	
	}

	
	
	protected JComboBox getComboBox1() {
		return comboBox1;
	}
	protected JTable getTable() {
		return table;
	}
}
