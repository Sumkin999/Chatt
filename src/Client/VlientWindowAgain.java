package Client;

import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JPanel;

public class VlientWindowAgain {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					VlientWindowAgain window = new VlientWindowAgain();
					window.frame.setVisible(true);
					
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VlientWindowAgain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Chat Window");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		//textField = new JTextField();
		//frame.getContentPane().add(textField, BorderLayout.NORTH);
		
		frame.getContentPane().add(textField, BorderLayout.NORTH);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		TextArea textArea= new TextArea();
		textArea.setEditable(false);
		//textArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		frame.getContentPane().add(scrollPane,BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(40);
		
		JButton btnNewButton = new JButton("Send");
		panel_1.add(btnNewButton);
		
		
		textField.setColumns(10);
	}

}
