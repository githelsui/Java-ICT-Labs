import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class EraseFrame extends JFrame {

	private JPanel contentPane;
	private JTextField rowTextField;
	private JTextField colTextField;
	private JOptionPane frame;
	private EraseObject eraser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EraseFrame frame = new EraseFrame();
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
	public EraseFrame() {
		EraseObject eraser = new EraseObject("digital.txt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 472);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEraseobject = new JLabel("EraseObject");
		lblEraseobject.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblEraseobject.setBounds(186, 11, 170, 14);
		contentPane.add(lblEraseobject);
		
		JLabel lblRow = new JLabel("Row (1-20)");
		lblRow.setBounds(236, 149, 120, 14);
		contentPane.add(lblRow);
		
		JLabel lblColumn = new JLabel("Column (1-20)");
		lblColumn.setBounds(236, 183, 120, 14);
		contentPane.add(lblColumn);
		
		JTextArea mainText = new JTextArea();
		mainText.setFont(new Font("Monospaced", Font.PLAIN, 13));
		mainText.setEditable(false);
		mainText.setBounds(10, 36, 202, 384);
		contentPane.add(mainText);
		mainText.setText(eraser.result());
		
		rowTextField = new JTextField();
		rowTextField.setBounds(320, 146, 86, 20);
		contentPane.add(rowTextField);
		rowTextField.setColumns(10);
		rowTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0)
			{
				char c = arg0.getKeyChar();
				if(!(Character.isDigit(c)))
				{
					getToolkit().beep();
					arg0.consume();
				}
				if(c==KeyEvent.VK_BACK_SPACE)
				{
					getToolkit().beep();
					arg0.consume();
				}
				if(c==KeyEvent.VK_DELETE) 
				{
					getToolkit().beep();
					arg0.consume();
				}
					if(rowTextField.getText().length() > 1)
				{
					getToolkit().beep();
					arg0.consume();
				}
				
			}
		});


		
		colTextField = new JTextField();
		colTextField.setBounds(320, 177, 86, 20);
		contentPane.add(colTextField);
		colTextField.setColumns(10);
		colTextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0)
			{
				char c = arg0.getKeyChar();
				if(!(Character.isDigit(c)))
				{
					getToolkit().beep();
					arg0.consume();
				}
				if(c==KeyEvent.VK_BACK_SPACE)
				{
					getToolkit().beep();
					arg0.consume();
				}
				if(c==KeyEvent.VK_DELETE) 
				{
					getToolkit().beep();
					arg0.consume();
				}
					if(colTextField.getText().length() > 1)
				{
					getToolkit().beep();
					arg0.consume();
				}
				
			}
		});
		
		JButton Enter = new JButton("Enter");
		Enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String rowText =rowTextField.getText();
				String colText = colTextField.getText();
				if(!(rowText.equals("") || colText.equals("")) )
				{
				
						int intRow =  Integer.parseInt(rowText);
						int intCol =  Integer.parseInt(colText);
					
					if(!eraser.isOutOfBounds(intRow, intCol))
					{
						
						if(eraser.isThereImage(intRow, intCol))
						{
							eraser.prompt(intRow, intCol);
							mainText.setText(eraser.result());
						}
						else
						{
							JOptionPane.showMessageDialog(frame, "There is no image to be removed.");
						}
					}
					else
					{
						
					JOptionPane.showMessageDialog(frame, "Coordinates are out of bounds");
	
					}
					
					
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Please fill out coordinates before entering.");
				}
			}
		
		});
		Enter.setBounds(285, 208, 89, 23);
		contentPane.add(Enter);
		
		
		JLabel lblCoordinates = new JLabel("Coordinates to Erase");
		lblCoordinates.setBounds(276, 121, 148, 14);
		contentPane.add(lblCoordinates);
	}
}
