package com.company;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



class RadioQuestion extends JPanel implements ActionListener{
    int correctAns;
    Quiz quiz;
    int selected;
    boolean used;
    JPanel qPanel=new JPanel();
    JPanel aPanel=new JPanel();
    JRadioButton[] responses;
    ButtonGroup group=new ButtonGroup();
    JPanel botPanel=new JPanel();
    JButton next=new JButton("Next");
    JButton finish=new JButton("Finish");


    public RadioQuestion(String q, String[] options, int ans, Quiz quiz){
        this.quiz=quiz;
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        correctAns=ans;
        qPanel.add(new JLabel(q));
        add(qPanel);
        responses=new JRadioButton[options.length];
        for(int i=0;i<options.length;i++){
            responses[i]=new JRadioButton(options[i]);
            responses[i].addActionListener(this);
            group.add(responses[i]);
            aPanel.add(responses[i]);
        }
        add(aPanel);
        next.addActionListener(this);
        finish.addActionListener(this);
        botPanel.add(next);
        botPanel.add(finish);
        add(botPanel);
    }

    public void actionPerformed(ActionEvent e){
        Object src=e.getSource();
        if(src.equals(next)){
            showResult();
            if(selected==correctAns){
                used=true;
                quiz.next();
            }
            else
            {
                quiz.next();
            }
        }
        if(src.equals(finish)){
            quiz.showSummary();
        }
        for(int i=0;i<responses.length;i++){
            if(src==responses[i]){
                selected=i;
            }
        }
    }

    public void showResult(){
        String text=responses[selected].getText();
        quiz.total++;
        if(selected==correctAns){
            JOptionPane.showMessageDialog(null,text+" is correct!");
        }else{
            quiz.wrongs++;
            JOptionPane.showMessageDialog(null,text+" is wrong.");
        }
    }
}