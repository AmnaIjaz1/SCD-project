package project;

import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
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
		setBounds(100, 100, 600, 650);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 242, 241));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// TITLE
		
		JLabel heading = new JLabel("LEAVE APPLICATION FORM");
		heading.setFont(new Font("Arial", Font.BOLD, 22));
		heading.setForeground(new Color(25, 25, 112));
		heading.setBounds(120, 15, 400, 35);
		contentPane.add(heading);
		
		
		// NAME
		
		JLabel NameLabel = new JLabel("Enter Name :");
		NameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		NameLabel.setForeground(new Color(0, 51, 102));
		NameLabel.setBounds(190, 70, 140, 20);
		contentPane.add(NameLabel);
		
		Name = new JTextField();
		Name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Name.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));
		Name.setBackground(new Color(255,255,255));
		Name.setBounds(190, 95, 220, 35);
		contentPane.add(Name);
		Name.setColumns(10);
		
		
		// REGISTRATION
		
		JLabel lblNewLabel = new JLabel("Enter Registration No:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(0, 51, 102));
		lblNewLabel.setBounds(190, 145, 180, 20);
		contentPane.add(lblNewLabel);
		
		regNo = new JTextField();
		regNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		regNo.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));
		regNo.setBackground(new Color(255,255,255));
		regNo.setColumns(10);
		regNo.setBounds(190, 170, 220, 35);
		contentPane.add(regNo);
		
		
		// DEPARTMENT
		
		JLabel DepLabel = new JLabel("Enter Department:");
		DepLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		DepLabel.setForeground(new Color(0, 51, 102));
		DepLabel.setBounds(190, 220, 160, 20);
		contentPane.add(DepLabel);
		
		Department = new JTextField();
		Department.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Department.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));
		Department.setBackground(new Color(255,255,255));
		Department.setColumns(10);
		Department.setBounds(190, 245, 220, 35);
		contentPane.add(Department);
		
		
		// LEAVE TYPE
		
		JLabel lblLeaveType = new JLabel("Leave Type :");
		lblLeaveType.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLeaveType.setForeground(new Color(0, 51, 102));
		lblLeaveType.setBounds(190, 295, 120, 20);
		contentPane.add(lblLeaveType);
		
		
		String[] leaveTypes = {"Sick", "Casual", "Annual", "Emergency"};
		JComboBox<String> comboBox = new JComboBox<>(leaveTypes);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBackground(new Color(255,255,255));
		comboBox.setBounds(190, 320, 220, 35);
		contentPane.add(comboBox);

		
		// NUMBER OF LEAVES
		
		JLabel noLeavesLabel = new JLabel("Enter Number of Leaves:");
		noLeavesLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		noLeavesLabel.setForeground(new Color(0, 51, 102));
		noLeavesLabel.setBounds(190, 370, 220, 20);
		contentPane.add(noLeavesLabel);
		
		Leaves = new JTextField();
		Leaves.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Leaves.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));
		Leaves.setBackground(new Color(255,255,255));
		Leaves.setColumns(10);
		Leaves.setBounds(190, 395, 220, 35);
		contentPane.add(Leaves);
		
		
		// REASON
		
		JLabel ReasonLabel = new JLabel("Specify Reason:");
		ReasonLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		ReasonLabel.setForeground(new Color(0, 51, 102));
		ReasonLabel.setBounds(190, 445, 150, 20);
		contentPane.add(ReasonLabel);
		
		JTextArea reason = new JTextArea();
		reason.setFont(new Font("Tahoma", Font.PLAIN, 14));
		reason.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));
		reason.setBackground(new Color(255,255,255));
		reason.setBounds(190, 470, 220, 80);
		contentPane.add(reason);

		
		// BUTTONS 
		
		/*RESET Button*/
		JButton Resetbtn = new JButton("Reset");
		Resetbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		Resetbtn.setBackground(new Color(255, 204, 102));
		Resetbtn.setFocusPainted(false);
		
		Resetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int decision=JOptionPane.showConfirmDialog(contentPane,"Do you want to reset?","Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				if(decision==JOptionPane.YES_OPTION)
				{
					reset();
				}
			}
		});
		Resetbtn.setBounds(90, 570, 100, 35);
		contentPane.add(Resetbtn);
		
		
		
		/*Exit Button*/
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExit.setBackground(new Color(255, 153, 153));
		btnExit.setFocusPainted(false);
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int choice =JOptionPane.showConfirmDialog(contentPane,"Do you want to exit?","Confirmation", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				if(choice==JOptionPane.YES_OPTION)
				{
					System.exit(0);
				}
			}
		});
		btnExit.setBounds(240, 570, 100, 35);
		contentPane.add(btnExit);
		
		/*SUBMIT BUTTON*/
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSubmit.setBackground(new Color(144, 238, 144));
		btnSubmit.setFocusPainted(false);
		
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
		btnSubmit.setBounds(390, 570, 100, 35);
		contentPane.add(btnSubmit);
	}
}
