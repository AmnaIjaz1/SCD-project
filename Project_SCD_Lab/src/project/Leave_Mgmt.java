package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Leave_Mgmt extends JFrame {


	private static final long serialVersionUID = 1L;
	static JPanel contentPane;
	static JTextField Name;
	static JTextField Department;
	static JTextField Leaves;
	static JTextField regNo;
	
	static int totalLeaves=5;
	
	public static void reset() {
		
			
			Name.setText(" ");
			Department.setText(" ");
			Leaves.setText(" ");
			regNo.setText(" ");
			
			JOptionPane.showMessageDialog(contentPane,"Form Reset Successfully");
			
		
	}
	
	public static void ApproveLeave() {
		String name=Name.getText();
		String dep=Department.getText();
		String Regno=regNo.getText();
		
		int leave;
		try {
		   leave = Integer.parseInt(Leaves.getText().trim());
		} 
		catch (NumberFormatException e) {
		    throw new IllegalArgumentException("Number of leaves must be a valid integer!");
		}
		
		
		if (name.isEmpty() || dep.isEmpty() || Regno.isEmpty()) {
	        throw new IllegalArgumentException("All the Input Fields Must be filled!");
	    }
		
	    if (leave == 0) {
	        throw new IllegalArgumentException("Number of leaves cannot be zero!");
	    } else if (leave > totalLeaves) {
	        throw new IllegalArgumentException("You're exceeding the total number of leaves allocated (i.e. 5)");
	    }
		else if(leave > totalLeaves){
			throw new IllegalArgumentException("You're exceding The Total No leaves Allocated(i.e 5)");
		}	
	

	
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Leave_Mgmt frame = new Leave_Mgmt();
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
	public Leave_Mgmt() {
		setTitle("Leave Application Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Name = new JTextField();
		Name.setBounds(40, 42, 170, 31);
		contentPane.add(Name);
		Name.setColumns(10);
		
		JLabel NameLabel = new JLabel("Enter Name :");
		NameLabel.setBounds(40, 23, 86, 14);
		contentPane.add(NameLabel);
		
		JLabel DepLabel = new JLabel("Enter Department:");
		DepLabel.setBounds(40, 154, 120, 14);
		contentPane.add(DepLabel);
		
		Department = new JTextField();
		Department.setColumns(10);
		Department.setBounds(40, 179, 170, 31);
		contentPane.add(Department);
		
		JLabel noLeavesLabel = new JLabel("Enter Number of Leaves:");
		noLeavesLabel.setBounds(40, 290, 149, 14);
		contentPane.add(noLeavesLabel);
		
		Leaves = new JTextField();
		Leaves.setColumns(10);
		Leaves.setBounds(40, 315, 170, 31);
		contentPane.add(Leaves);
		
		JLabel ReasonLabel = new JLabel("Specify Reason:");
		ReasonLabel.setBounds(40, 369, 117, 14);
		contentPane.add(ReasonLabel);
		
		JTextArea reason = new JTextArea();
		reason.setBounds(40, 394, 305, 67);
		contentPane.add(reason);
		
		JLabel lblNewLabel = new JLabel("Enter Registration No:");
		lblNewLabel.setBounds(40, 84, 125, 14);
		contentPane.add(lblNewLabel);
		
		regNo = new JTextField();
		regNo.setColumns(10);
		regNo.setBounds(40, 107, 170, 31);
		contentPane.add(regNo);
		
		
		JLabel lblLeaveType = new JLabel("Leave Type :");
		lblLeaveType.setBounds(40, 221, 120, 14);
		contentPane.add(lblLeaveType);
		
		
		
		String[] leaveTypes = {"Sick", "Casual", "Annual", "Emergency"};
		JComboBox<String> comboBox = new JComboBox<>(leaveTypes);
		comboBox.setBounds(40, 246, 170, 30);
		contentPane.add(comboBox);

		
		//BUTTONS 
		
		/*RESET Button*/
		JButton Resetbtn = new JButton("Reset");
		Resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int decision=JOptionPane.showConfirmDialog(contentPane,"Do you want to reset?","Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				if(decision==JOptionPane.YES_OPTION)
				{
					reset();
				}
				

			}
		});
		Resetbtn.setBounds(80, 484, 89, 23);
		contentPane.add(Resetbtn);
		
		
		
		/*Exit Button*/
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice =JOptionPane.showConfirmDialog(contentPane,"Do you want to exit?","Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				if(choice==JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
				
				
				
			}
		});
		btnExit.setBounds(222, 484, 89, 23);
		contentPane.add(btnExit);
		
		/*SUBMIT BUTTON*/
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					ApproveLeave();
					
					JOptionPane.showConfirmDialog(btnSubmit, "Leave Application Successful", "Information", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
					totalLeaves--;
					
				}
				catch(IllegalArgumentException err){
					
				JOptionPane.showMessageDialog(btnSubmit, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					
				}
				
				
			}
		});
		btnSubmit.setBounds(369, 484, 89, 23);
		contentPane.add(btnSubmit);
		
		
		
		
	}
}
