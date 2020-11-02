package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private static JTextField FNameInput;
    private static JTextField LNameInput;
    private static JTextField AgeInput;
    private static ButtonGroup G1;
    private static JRadioButton MaleInput;
    private static JRadioButton FemaleInput;
    private static String RadioInput;
    private static JCheckBox StatusInput;
    private static String status;
    private static JTextArea AdressInput;
    private static JButton butonSave;

    public static void main(String[] args) {
        JPanel jPanel = buildPanel();
        addActionToButon(jPanel);

    }

    private static void addActionToButon(JPanel panel) {
        butonSave.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.updateUI();
                        panel.removeAll();
                        panel.updateUI();
                        if (MaleInput.isSelected()) {

                            RadioInput = MaleInput.getText();
                        }
                        if (FemaleInput.isSelected()) {

                            RadioInput = FemaleInput.getText();
                        }
                        if (StatusInput.isSelected()){
                            status = "Yes";}
                        else{
                            status = "No";}
                        Component infoLabel = new JLabel(
                                    "<html>First Name:   " + FNameInput.getText() +
                                        "<br>Last Name:    " + LNameInput.getText() +
                                        "<br>Age:    " + AgeInput.getText() +
                                        "<br>Gender:    " + RadioInput +
                                        "<br>Married:    " + status +
                                        "<br>Adress:    " + AdressInput.getText() +
                                        "</html>"
                        );
                        infoLabel.setBounds(10, 10, 200, 100);
                        panel.updateUI();
                        panel.add(infoLabel);
                        panel.updateUI();


                        ;
                    }
                }
        );
    }

    private static JPanel buildPanel() {
        JFrame frame = new JFrame("Insert data");
        frame.setSize(350, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);

        placeComponents(panel);

        frame.setVisible(true);

        return panel;
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel FNameLabel = new JLabel("First name: ");
        FNameLabel.setBounds(10, 20, 80, 25);
        panel.add(FNameLabel);

        FNameInput = new JTextField(20);
        FNameInput.setBounds(100, 20, 165, 25);
        panel.add(FNameInput);

        JLabel LNameLabel = new JLabel("Last name: ");
        LNameLabel.setBounds(10, 50, 80, 25);
        panel.add(LNameLabel);

        LNameInput = new JTextField(20);
        LNameInput.setBounds(100, 50, 165, 25);
        panel.add(LNameInput);

        JLabel AgeLabel = new JLabel("Age: ");
        AgeLabel.setBounds(10, 80, 80, 25);
        panel.add(AgeLabel);

        AgeInput = new JTextField(20);
        AgeInput.setBounds(100, 80, 165, 25);
        panel.add(AgeInput);

        MaleInput = new JRadioButton();
        FemaleInput = new JRadioButton();


        G1 = new ButtonGroup();

        JLabel L1 = new JLabel("Gender: ");
        MaleInput.setText("Male");
        FemaleInput.setText("Female");

        MaleInput.setBounds(90, 110, 60, 50);
        FemaleInput.setBounds(150, 110, 80, 50);
        L1.setBounds(10, 110, 150, 50);

        panel.add(MaleInput);
        panel.add(FemaleInput);
        panel.add(L1);
        G1.add(MaleInput);
        G1.add(FemaleInput);


        StatusInput = new JCheckBox("Married?");
        StatusInput.setBounds(10, 160, 100, 30);
        panel.add(StatusInput);


        AdressInput = new JTextArea();
        AdressInput.setBounds(100, 210, 165, 55);
        panel.add(AdressInput);

        JLabel AdressLabel = new JLabel("Adress: ");
        AdressLabel.setBounds(10, 210, 80, 25);
        panel.add(AdressLabel);

        butonSave = new JButton("Save");
        butonSave.setBounds(10, 280, 100, 25);
        panel.add(butonSave);
    }

}
