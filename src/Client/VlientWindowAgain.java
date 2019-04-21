package Client;

import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import java.awt.Color;

public class VlientWindowAgain {

	private JFrame frame;
	private JTextField textField;
	private JTextField messageField;
	
	private static JTextArea txtrAfasfasf= new JTextArea();
	
	private Client client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					
					VlientWindowAgain window = new VlientWindowAgain();
					window.frame.setVisible(true);
					
					
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VlientWindowAgain() 
	{
		initialize();
		String name=JOptionPane.showInputDialog("Enter your name");
		client=new Client(name,"localhost",6056);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Chat Window");
		frame.setBounds(100, 100, 508, 333);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		txtrAfasfasf.setBackground(Color.GREEN);
		txtrAfasfasf.setForeground(Color.RED);
		//txtrAfasfasf.setDropMode(DropMode.ON);
		txtrAfasfasf.setColumns(20);
		txtrAfasfasf.setTabSize(0);
		txtrAfasfasf.setRows(2);
		//textArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(txtrAfasfasf);
		frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		messageField = new JTextField();
		panel_1.add(messageField);
		messageField.setColumns(40);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(
		e->
			{
				
			}
		);
		panel_1.add(btnNewButton);
		
		frame.setLocationRelativeTo(null);
		//textField_1.setColumns(40);
	}
	
	public static void PrintMessageToConsole(String message)
	{
		System.out.println("       M1 "+message);
		txtrAfasfasf.setText(txtrAfasfasf.getText()+message+"\n");
	}
	
	/*private static void PrintTOConsole(String message)
	{
		System.out.println("M2 "+message);
		txtrAfasfasf.setText(txtrAfasfasf.getText()+message+"\n");
	}*/

}
