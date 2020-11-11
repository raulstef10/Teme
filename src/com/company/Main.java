package com.company;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JOptionPane;

class Quiz extends JFrame{
    JPanel p=new JPanel();
    CardLayout cards=new CardLayout();
    int numQs;
    int wrongs=0;
    int total=0;

    String[][] answers={
            {"Enschede","Amsterdam","Den Haag","Berlin"},
            {"P","Po","Pt","K"},
            {"Euler","Erasmus","Fibonnaci","Archemides"},
            {"Storms","Earthquakes","Floods","Wildfires"},
            {"Bull","Horse","Jaguar","Eagle"},
            
    };

    RadioQuestion questions[]={

            new RadioQuestion(
                    "What is the capital of the Netherlands?",
                    answers[0],
                    1,this
            ),
            new RadioQuestion(
                    "What is the symbol for potassium?",
                    answers[1],
                    3,this
            ),
            new RadioQuestion(
                    "Who discovered the number e?",
                    answers[2],
                    0,this
            ),
            new RadioQuestion(
                    "Which natural disaster is measured with a Richter scale?",
                    answers[3],
                    1,this
            ),
            new RadioQuestion(
                    "Which animal can be seen on the Porsche logo?",
                    answers[4],
                    1,this
            )
    };

    public static void main(String args[]){
        new Quiz();
    }

    public Quiz(){
        super("Quiz");
        setResizable(true);
        setSize(500,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        p.setLayout(cards);
        numQs=questions.length;
            p.add(questions[0],"0");
        cards.show(p,"0");
        cards.next(p);
            p.add(questions[1],"1");
        cards.next(p);
        cards.show(p,"1");
            p.add(questions[2],"2");
        cards.next(p);
        cards.show(p,"2");
            p.add(questions[3],"3");
        cards.next(p);
        cards.show(p,"3");
            p.add(questions[4],"4");
        cards.show(p,"4");
        cards.next(p);





        add(p);
        setVisible(true);
    }

    public void next(){
        if(total==5){
            showSummary();
        }else{cards.next(p);
                p.updateUI();
    }}

    public void showSummary(){
        JOptionPane.showMessageDialog(null,"Results: "+
                "\nIncorrect Answers: \t"+wrongs+
                "\nCorrect Answers: \t"+(total-wrongs)+
                "\nPercent Correct: \t\t"+(int)(((float)(total-wrongs)/total)*100)+"%"
        );
        System.exit(0);
    }
}