import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProjectFormPanel extends JPanel {
    private JTextField txtProjectName;
    private JTextField txtTeamLeader;
    private JComboBox<String> comboTeamSize;
    private JComboBox<String> comboProjectType;
    private JTextField txtStartDate;
    private JButton btnSave;
    private JButton btnClear;

    public ProjectFormPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Form Alanları
        gbc.gridx = 0; gbc.gridy = 0;
        add(new JLabel("Project Name:"), gbc);
        gbc.gridx = 1;
        txtProjectName = new JTextField(20);
        add(txtProjectName, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(new JLabel("Team Leader:"), gbc);
        gbc.gridx = 1;
        txtTeamLeader = new JTextField(20);
        add(txtTeamLeader, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(new JLabel("Team Size:"), gbc);
        gbc.gridx = 1;
        String[] teamSizes = {"1-3", "4-6", "7-10", "10+"};
        comboTeamSize = new JComboBox<>(teamSizes);
        add(comboTeamSize, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        add(new JLabel("Project Type:"), gbc);
        gbc.gridx = 1;
        String[] projectTypes = {"Web", "Mobile", "Desktop", "API"};
        comboProjectType = new JComboBox<>(projectTypes);
        add(comboProjectType, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        add(new JLabel("Start Date (DD/MM/YYYY):"), gbc);
        gbc.gridx = 1;
        txtStartDate = new JTextField(20);
        add(txtStartDate, gbc);

        // Butonlar
        JPanel buttonPanel = new JPanel();
        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        buttonPanel.add(btnSave);
        buttonPanel.add(btnClear);

        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(buttonPanel, gbc);

        // Event Handling
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });
    }

    private void saveData() {
        String projectName = txtProjectName.getText().trim();
        String teamLeader = txtTeamLeader.getText().trim();
        String teamSize = (String) comboTeamSize.getSelectedItem();
        String projectType = (String) comboProjectType.getSelectedItem();
        String startDate = txtStartDate.getText().trim();

        if (projectName.isEmpty() || teamLeader.isEmpty() || startDate.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String recordTime = now.format(formatter);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("projects.txt", true))) {
            writer.write("=== Project Entry ===");
            writer.newLine();
            writer.write("Project Name : " + projectName);
            writer.newLine();
            writer.write("Team Leader  : " + teamLeader);
            writer.newLine();
            writer.write("Team Size    : " + teamSize);
            writer.newLine();
            writer.write("Project Type : " + projectType);
            writer.newLine();
            writer.write("Start Date   : " + startDate);
            writer.newLine();
            writer.write("Record Time  : " + recordTime);
            writer.newLine();
            writer.write("======");
            writer.newLine();
            writer.newLine();

            JOptionPane.showMessageDialog(this, "Project saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error writing to file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        txtProjectName.setText("");
        txtTeamLeader.setText("");
        txtStartDate.setText("");
        comboTeamSize.setSelectedIndex(0);
        comboProjectType.setSelectedIndex(0);
    }
}