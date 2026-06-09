package scd;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Leave_Mgmt extends JFrame {
    private static final long serialVersionUID = 1L;
    
    private final JPanel contentPane;
    private final JTextField nameField;
    private final JTextField departmentField;
    private final JTextField leavesField;
    private final JTextField regNoField;
    private final JTextArea reasonArea;
    
    private int totalLeaves = 5;
    
    public void reset() {
        nameField.setText("");
        departmentField.setText("");
        leavesField.setText("");
        regNoField.setText("");
        reasonArea.setText("");
        
        JOptionPane.showMessageDialog(contentPane, "Form Reset Successfully");
    }
    
    public void approveLeave() {
        String name = nameField.getText().trim();
        String dep = departmentField.getText().trim();
        String regno = regNoField.getText().trim();
        
        if (name.isEmpty() || dep.isEmpty() || regno.isEmpty()) {
            throw new IllegalArgumentException("All the Input Fields Must be filled!");
        }
        
        int leave;
        try {
            leave = Integer.parseInt(leavesField.getText().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Number of leaves must be a valid integer!");
        }
        
        if (leave <= 0) {
            throw new IllegalArgumentException("Number of leaves must be greater than zero!");
        } else if (leave > totalLeaves) {
            // Error message changed to hide the exact limit
            throw new IllegalArgumentException("You're exceeding the allowed balance for this request.");
        }
        
        totalLeaves -= leave;
    }
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Leave_Mgmt frame = new Leave_Mgmt();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public Leave_Mgmt() {
        setTitle("Leave Application Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 680);
        setLocationRelativeTo(null); 
        
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.info);
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // TITLE
        JLabel heading = new JLabel("LEAVE APPLICATION FORM", JLabel.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        heading.setForeground(new Color(25, 25, 112));
        heading.setBounds(100, 15, 400, 35);
        contentPane.add(heading);
        
        // NAME
        JLabel nameLabel = new JLabel("Enter Name :");
        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        nameLabel.setForeground(new Color(0, 51, 102));
        nameLabel.setBounds(190, 70, 140, 20);
        contentPane.add(nameLabel);
        
        nameField = new JTextField();
        nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nameField.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));
        nameField.setBackground(Color.WHITE);
        nameField.setBounds(190, 95, 220, 35);
        contentPane.add(nameField);
        nameField.setColumns(10);
        
        // REGISTRATION
        JLabel regLabel = new JLabel("Enter Registration No:");
        regLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        regLabel.setForeground(new Color(0, 51, 102));
        regLabel.setBounds(190, 145, 180, 20);
        contentPane.add(regLabel);
        
        regNoField = new JTextField();
        regNoField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        regNoField.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));
        regNoField.setBackground(Color.WHITE);
        regNoField.setColumns(10);
        regNoField.setBounds(190, 170, 220, 35);
        contentPane.add(regNoField);
        
        // DEPARTMENT
        JLabel depLabel = new JLabel("Enter Department:");
        depLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        depLabel.setForeground(new Color(0, 51, 102));
        depLabel.setBounds(190, 220, 160, 20);
        contentPane.add(depLabel);
        
        departmentField = new JTextField();
        departmentField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        departmentField.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));
        departmentField.setBackground(Color.WHITE);
        departmentField.setColumns(10);
        departmentField.setBounds(190, 245, 220, 35);
        contentPane.add(departmentField);
        
        // LEAVE TYPE
        JLabel lblLeaveType = new JLabel("Leave Type :");
        lblLeaveType.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblLeaveType.setForeground(new Color(0, 51, 102));
        lblLeaveType.setBounds(190, 295, 120, 20);
        contentPane.add(lblLeaveType);
        
        String[] leaveTypes = {"Sick", "Casual", "Annual", "Emergency"};
        JComboBox<String> comboBox = new JComboBox<>(leaveTypes);
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
        comboBox.setBackground(Color.WHITE);
        comboBox.setBounds(190, 320, 220, 35);
        contentPane.add(comboBox);
        
        // NUMBER OF LEAVES
        JLabel noLeavesLabel = new JLabel("Enter Number of Leaves:");
        noLeavesLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        noLeavesLabel.setForeground(new Color(0, 51, 102));
        noLeavesLabel.setBounds(190, 370, 220, 20);
        contentPane.add(noLeavesLabel);
        
        leavesField = new JTextField();
        leavesField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        leavesField.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));
        leavesField.setBackground(Color.WHITE);
        leavesField.setColumns(10);
        leavesField.setBounds(190, 395, 220, 35);
        contentPane.add(leavesField);
        
        // REASON
        JLabel reasonLabel = new JLabel("Specify Reason:");
        reasonLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        reasonLabel.setForeground(new Color(0, 51, 102));
        reasonLabel.setBounds(190, 445, 150, 20);
        contentPane.add(reasonLabel);
        
        reasonArea = new JTextArea();
        reasonArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
        reasonArea.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237), 2));
        reasonArea.setBackground(Color.WHITE);
        reasonArea.setBounds(190, 470, 220, 80);
        contentPane.add(reasonArea);
        
        // BUTTONS 
        
        /* RESET Button */
        JButton resetBtn = new JButton("Reset");
        resetBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
        resetBtn.setBackground(new Color(255, 204, 102));
        resetBtn.setFocusPainted(false);
        resetBtn.addActionListener((ActionEvent e) -> {
            int decision = JOptionPane.showConfirmDialog(contentPane, "Do you want to reset?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (decision == JOptionPane.YES_OPTION) {
                reset();
            }
        });
        resetBtn.setBounds(90, 570, 100, 35);
        contentPane.add(resetBtn);
        
        /* Exit Button */
        JButton btnExit = new JButton("Exit");
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnExit.setBackground(new Color(255, 153, 153));
        btnExit.setFocusPainted(false);
        btnExit.addActionListener((ActionEvent e) -> {
            int choice = JOptionPane.showConfirmDialog(contentPane, "Do you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (choice == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        btnExit.setBounds(240, 570, 100, 35);
        contentPane.add(btnExit);
        
        /* SUBMIT BUTTON */
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnSubmit.setBackground(new Color(144, 238, 144));
        btnSubmit.setFocusPainted(false);
        btnSubmit.addActionListener((ActionEvent e) -> {
            try {
                approveLeave();
                // Modified success dialog to hide leaf balance metrics
                JOptionPane.showMessageDialog(contentPane, "Leave Application Submitted Successfully.", "Information", JOptionPane.INFORMATION_MESSAGE);
            } catch (IllegalArgumentException err) {
                JOptionPane.showMessageDialog(btnSubmit, err.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnSubmit.setBounds(390, 570, 100, 35);
        contentPane.add(btnSubmit);
    }
}
