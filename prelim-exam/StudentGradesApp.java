import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StudentGradesApp extends JFrame {

    private JTable table;
    private DefaultTableModel model;

    public StudentGradesApp() {
        setTitle("Student Grades");
        setSize(900, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Table columns
        String[] columns = {
                "Student ID", "Name",
                "LAB WORK 1", "LAB WORK 2", "LAB WORK 3",
                "PRELIM EXAM", "ATTENDANCE GRADE"
        };

        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        loadCSV();

        JScrollPane scrollPane = new JScrollPane(table);

        // Buttons
        JButton btnAdd = new JButton("Add Student");
        JButton btnDelete = new JButton("Delete Student");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnDelete);

        btnAdd.addActionListener(e -> addStudent());
        btnDelete.addActionListener(e -> deleteStudent());

        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Load CSV file
    private void loadCSV() {
        File file = new File("MOCK_DATA.csv");
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine(); // skip header
            String line;

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                model.addRow(new Object[]{
                        d[0],                     // Student ID
                        d[1] + " " + d[2],         // Full Name
                        d[3], d[4], d[5],          // Lab works
                        d[6],                      // Prelim
                        d[7]                       // Attendance
                });
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading CSV file");
        }
    }

    // Add student using dialogs
    private void addStudent() {

        String id = JOptionPane.showInputDialog(this, "Enter Student ID:");
        if (id == null || id.trim().isEmpty()) return;

        String name = JOptionPane.showInputDialog(this, "Enter Student Name:");
        if (name == null || name.trim().isEmpty()) return;

        String lw1 = JOptionPane.showInputDialog(this, "Enter Lab Work 1 grade:");
        String lw2 = JOptionPane.showInputDialog(this, "Enter Lab Work 2 grade:");
        String lw3 = JOptionPane.showInputDialog(this, "Enter Lab Work 3 grade:");
        String prelim = JOptionPane.showInputDialog(this, "Enter Prelim Exam grade:");
        String attendance = JOptionPane.showInputDialog(this, "Enter Attendance grade:");

        model.addRow(new Object[]{
                id,
                name,
                lw1,
                lw2,
                lw3,
                prelim,
                attendance
        });
    }

    // Delete selected student
    private void deleteStudent() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            model.removeRow(row);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentGradesApp().setVisible(true);
        });
    }
}
