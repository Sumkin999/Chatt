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

public class CleintWindow 
{

	private JFrame frame;
	private JTextField textField;
	private JTextField messageField;
	
	private static JTextArea textFrame= new JTextArea();
	
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
					
					CleintWindow window = new CleintWindow();
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
	public CleintWindow() 
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
		textFrame.setBackground(Color.GREEN);
		textFrame.setForeground(Color.RED);

		textFrame.setColumns(20);
		textFrame.setTabSize(0);
		textFrame.setRows(2);
		textFrame.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(textFrame);
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
				if(!messageField.getText().equals(""))
				{
					client.Send(messageField.getText());
					messageField.setText("");
				}
				
			}
		);
		panel_1.add(btnNewButton);
		
		frame.setLocationRelativeTo(null);
	}
	
	public static void PrintMessageToConsole(String message)
	{
		System.out.println("       M1 "+message);
		textFrame.setText(textFrame.getText()+message+"\n");
	}
	
	

}
