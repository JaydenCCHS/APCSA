/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gui_project;

/**
 *
 * @author JHoang2026
 */
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.List;
import javax.sound.sampled.*;

public class GUI_Project extends JFrame{
    final private static DefaultListModel<String> memberListModel = new DefaultListModel<>();
   
    public static void main(String[] args) {      
        //CSV file
        String csvFilePath = "files/example.csv";
        List<List<String>> data = Arrays.asList(
                Arrays.asList("Name", "Age", "City"),
                Arrays.asList("Connor Musick", "18", "San Diego"),
                Arrays.asList("Jayden Hoang", "17", "San Diego")
        );

        try {
            writeCsvFile(csvFilePath, data);
            System.out.println("CSV file created successfully: " + csvFilePath);
        } catch (IOException e) {
            System.err.println("Error writing to CSV file: " + e.getMessage());
        }
    //Set boundaries for display
    JFrame frame = new JFrame("Gym Membership Form");
    frame.setSize(800, 450);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(10, 2));

    //Create gym title, choose font, and add to display
    JLabel titleLabel = new JLabel("Welcome to SD Body Sculpting Gym!", JLabel.CENTER);
    titleLabel.setFont(new Font("SansSerif", Font.BOLD, 20));
    frame.add(titleLabel);
    frame.add(new JLabel());

    //Adding barbell image
    ImageIcon imageIcon1 = new ImageIcon("barbell.jpg");
        JLabel label1 = new JLabel(imageIcon1);
        frame.add(label1); // If adding to a JFrame
        Image image1 = imageIcon1.getImage().getScaledInstance(150, 40, Image.SCALE_SMOOTH);
        imageIcon1 = new ImageIcon(image1);
        label1.setIcon(imageIcon1);
        frame.revalidate();
        frame.repaint();
   
    //Adding body builder image
    ImageIcon imageIcon2 = new ImageIcon("bodyBuilder.jpg");  
        JLabel label2 = new JLabel(imageIcon2);
        frame.add(label2); // If adding to a JFrame
        Image image2 = imageIcon2.getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH);
        imageIcon2 = new ImageIcon(image2);
        label2.setIcon(imageIcon2);
        frame.revalidate();
        frame.repaint();
   
    //Initialize labels and text fields
    JLabel nameLabel = new JLabel("Full Name:");
    JTextField nameField = new JTextField();
    JLabel ageLabel = new JLabel("Age:");
    JTextField ageField = new JTextField();
    JLabel emailLabel = new JLabel("Email:");
    JTextField emailField = new JTextField();
    JLabel membershipLabel = new JLabel("Membership Type:");
    String[] memberships = {"Basic", "Standard", "Premium"};
    Arrays.sort(memberships);
    JComboBox<String> membershipBox = new JComboBox<>(memberships);
    JLabel renewalLabel = new JLabel("Renewal Date (YYYY-MM-DD):");
    JTextField renewalField = new JTextField();

    //Initializing buttons
    JButton submitButton = new JButton("Register");
    JButton viewMembersButton = new JButton("View Members");
    JButton deleteMemberButton = new JButton("Delete Member");
    JButton editMemberButton = new JButton("Edit Member");
   
    //Add buttons, labels, and text fields to display
    frame.add(nameLabel);
    frame.add(nameField);
    frame.add(ageLabel);
    frame.add(ageField);
    frame.add(emailLabel);
    frame.add(emailField);
    frame.add(membershipLabel);
    frame.add(membershipBox);
    frame.add(renewalLabel);
    frame.add(renewalField);
    frame.add(submitButton);
    frame.add(viewMembersButton);
    frame.add(deleteMemberButton);
    frame.add(editMemberButton);

   
    //Add sound
   submitButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e)
        {
            playSound("75235__creek23__cha-ching.wav");
        }
    }
    );

    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String age = ageField.getText();
            String email = emailField.getText();
            String membership = (String) membershipBox.getSelectedItem();
            String renewalDate = renewalField.getText();

            if (name.isEmpty() || age.isEmpty() || email.isEmpty() || renewalDate.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (FileWriter writer = new FileWriter("gym_members.csv", true)) {
                writer.append(name).append(", ")
                      .append(age).append(", ")
                      .append(email).append(", ")
                      .append(membership).append(", ")
                      .append(renewalDate).append("\n\n");
                playSound("75235__creek23__cha-ching.wav");
                JOptionPane.showMessageDialog(frame, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Error saving data", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    });

    viewMembersButton.addActionListener(e -> viewMembers());
    deleteMemberButton.addActionListener(e -> deleteMember());
    editMemberButton.addActionListener(e -> editMember());

    frame.setVisible(true);
}
    //Upload sound      
    class SoundClass{
    String filePath = "75235__creek23__cha-ching.wav"; // Replace with your file path
    public static void playSound(String filePath) {
        try {
            File soundFile = new File(filePath);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.setFramePosition(0);
            System.out.println("Playing the sound");
            clip.start();

            // Keep the program running until the sound finishes playing
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                    System.exit(0);
                }
            });
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
   
    public void createTimeForSound() {
        TimerTask task = new TimerTask() {
        public void run() {
            playSound(filePath);
            System.out.println("Task performed on: " + new Date() + "n" +
              "Thread's name: " + Thread.currentThread().getName());
        }
    };
}
}

//Write CSV File    
public static void writeCsvFile(String filePath, List<List<String>> data) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (List<String> row : data) {
                String line = String.join(",", row);
                writer.write(line);
                writer.newLine();
            }
        }
    }

//Load members
private static List<String> loadMembers() {
    List<String> members = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("gym_members.csv"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            members.add(line);
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Error reading data", "Error", JOptionPane.ERROR_MESSAGE);
    }
    return members;
}

//View members
private static void viewMembers() {
    JFrame viewFrame = new JFrame("Registered Members");
    viewFrame.setSize(400, 300);
    viewFrame.setLayout(new BorderLayout());

    memberListModel.clear();
    List<String> members = loadMembers();
    for (String member : members) {
        memberListModel.addElement(member);
    }
    JList<String> memberList = new JList<>(memberListModel);
    JScrollPane scrollPane = new JScrollPane(memberList);
    viewFrame.add(scrollPane, BorderLayout.CENTER);
    viewFrame.setVisible(true);
}

//Delete members
private static void deleteMember() {
    String emailToDelete = JOptionPane.showInputDialog("Enter email of member to delete:");
    if (emailToDelete == null || emailToDelete.isEmpty()) return;
    List<String> members = loadMembers();
    List<String> updatedMembers = new ArrayList<>();

    for (String member : members) {
        if (!member.contains(emailToDelete)) {
            updatedMembers.add(member);
        }
    }
    saveMembers(updatedMembers);
    JOptionPane.showMessageDialog(null, "Member deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
}

//Edit members
private static void editMember() {
    String emailToEdit = JOptionPane.showInputDialog("Enter email of member to edit:");
    if (emailToEdit == null || emailToEdit.isEmpty()) return;
    List<String> members = loadMembers();
    List<String> updatedMembers = new ArrayList<>();

    for (String member : members) {
        if (member.contains(emailToEdit)) {
            String[] details = member.split(", ");
            String newName = JOptionPane.showInputDialog("Enter new name:", details[0]);
            String newAge = JOptionPane.showInputDialog("Enter new age:", details[1]);
            String newEmail = JOptionPane.showInputDialog("Enter new email:", details[2]);
            String newMembership = JOptionPane.showInputDialog("Enter new membership type:", details[3]);
            String newRenewalDate = JOptionPane.showInputDialog("Enter new renewal date (YYYY-MM-DD):", details[4]);
            updatedMembers.add(newName + ", " + newAge + ", " + newEmail + ", " + newMembership + ", " + newRenewalDate + "\n");
        } else {
            updatedMembers.add(member);
        }
    }

    saveMembers(updatedMembers);
    JOptionPane.showMessageDialog(null, "Member details updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
}

//Save members
private static void saveMembers(List<String> members) {
    try (FileWriter writer = new FileWriter("gym_members.csv")) {
        for (String member : members) {
            writer.write(member + "\n");
        }
    } catch (IOException ex) {
        JOptionPane.showMessageDialog(null, "Error saving data", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

//Play sound
private static void playSound(String soundFileName) {
    try {
        File soundFile = new File(soundFileName);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    } catch (Exception e) {
        System.err.println("Cannot play sound: " + e.getMessage());
    }
   
}
}
