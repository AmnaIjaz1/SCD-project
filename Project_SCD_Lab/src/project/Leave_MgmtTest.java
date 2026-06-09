package project;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.JTextField;

public class Leave_MgmtTest {

    @BeforeEach
    void setup() {
        // Initialize the static text fields before each test
        Leave_Mgmt.Name = new JTextField();
        Leave_Mgmt.Department = new JTextField();
        Leave_Mgmt.Leaves = new JTextField();
        Leave_Mgmt.regNo = new JTextField();
    }

    @Test
    void testApproveLeave_AllFieldsEmpty_ShouldThrowException() {
        Leave_Mgmt.Name.setText("");
        Leave_Mgmt.Department.setText("");
        Leave_Mgmt.Leaves.setText("0");
        Leave_Mgmt.regNo.setText("");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Leave_Mgmt.ApproveLeave();
        });

        assertEquals("All the Input Fields Must be filled!", exception.getMessage());
    }

    @Test
    void testApproveLeave_ExceedTotalLeaves_ShouldThrowException() {
        Leave_Mgmt.Name.setText("John");
        Leave_Mgmt.Department.setText("IT");
        Leave_Mgmt.Leaves.setText("10"); // exceeds totalLeaves=5
        Leave_Mgmt.regNo.setText("123");

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Leave_Mgmt.ApproveLeave();
        });

        assertEquals("You're exceding The Total No leaves Allocated(i.e 5)", exception.getMessage());
    }

    @Test
    void testApproveLeave_ValidInput_ShouldNotThrowException() {
        Leave_Mgmt.Name.setText("Alice");
        Leave_Mgmt.Department.setText("HR");
        Leave_Mgmt.Leaves.setText("2");
        Leave_Mgmt.regNo.setText("456");

        assertDoesNotThrow(() -> Leave_Mgmt.ApproveLeave());
    }
}
