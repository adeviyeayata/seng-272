package lab1_swing_fileio;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
//test
public class ProjectFormPanel extends JPanel {

    JTextField projectNameField;
    JTextField teamLeaderField;
    JTextField startDateField;

    JComboBox<String> teamSizeBox;
    JComboBox<String> projectTypeBox;

    JButton saveButton;
    JButton clearButton;

    public ProjectFormPanel() {

        setLayout(new GridLayout(7,2));

        add(new JLabel("Project Name"));
        projectNameField = new JTextField();
        add(projectNameField);

        add(new JLabel("Team Leader"));
        teamLeaderField = new JTextField();
        add(teamLeaderField);

        add(new JLabel("Team Size"));
        teamSizeBox = new JComboBox<>(new String[]{
                "1-3","4-6","7-10","10+"
        });
        add(teamSizeBox);

        add(new JLabel("Project Type"));
        projectTypeBox = new JComboBox<>(new String[]{
                "Web","Mobile","Desktop","API"
        });
        add(projectTypeBox);

        add(new JLabel("Start Date"));
        startDateField = new JTextField();
        add(startDateField);

        saveButton = new JButton("Save");
        clearButton = new JButton("Clear");

        add(saveButton);
        add(clearButton);

        saveButton.addActionListener(e -> saveProject());

        clearButton.addActionListener(e -> clearFields());
    }

    private void saveProject() {

        String projectName = projectNameField.getText();
        String teamLeader = teamLeaderField.getText();
        String teamSize = (String) teamSizeBox.getSelectedItem();
        String projectType = (String) projectTypeBox.getSelectedItem();
        String startDate = startDateField.getText();

        if(projectName.isEmpty() || teamLeader.isEmpty() || startDate.isEmpty()) {
            JOptionPane.showMessageDialog(this,"Please fill all fields");
            return;
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("projects.txt", true));

            writer.write("=== Project Entry ===\n");
            writer.write("Project Name : " + projectName + "\n");
            writer.write("Team Leader : " + teamLeader + "\n");
            writer.write("Team Size : " + teamSize + "\n");
            writer.write("Project Type : " + projectType + "\n");
            writer.write("Start Date : " + startDate + "\n");
            writer.write("Record Time : " + LocalDateTime.now() + "\n");
            writer.write("====================\n");

            writer.close();

            JOptionPane.showMessageDialog(this,"Saved successfully");

        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    private void clearFields() {

        projectNameField.setText("");
        teamLeaderField.setText("");
        startDateField.setText("");

        teamSizeBox.setSelectedIndex(0);
        projectTypeBox.setSelectedIndex(0);
    }
}