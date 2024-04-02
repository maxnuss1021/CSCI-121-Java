import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestBloodData {//sets variables for the two different blood data's
    BloodData d1  = new BloodData();
    BloodData d2;
    public void setBloodData(String Type, String Factor){//sets the altered blood type to the users parameters
        d2 = new BloodData(Type, Factor);
    }
    public BloodData returnInitialBD(){//returns the initial default Blood Type
        return d1;
    }
    public BloodData returnChanges(){// returns the altered blood type
        return d2;
    }
}
class TestBloodData1 extends JFrame implements ActionListener{//defines the different messages
    JLabel BD = new JLabel ("Please enter your blood data");//prompts the user to enter their blood data
    JLabel TypeLabel = new JLabel(" Type:");
    JTextField type = new JTextField(2);
    JLabel FactorLabel = new JLabel(" Factor:");
    JTextField Factor = new JTextField(1);
    JButton cont = new JButton("Continue");
    public String Type;
    public String factor;
    public TestBloodData1(){//sets the layout and adds everything into it
        setSize(900,500);
        setLayout(new FlowLayout());
        add(BD);
        add(TypeLabel);
        add(type);
        add(FactorLabel);
        add(Factor);
        add(cont);
        cont.addActionListener(this);//sets action listener
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == cont){//when continue is pressed
            try{//if user inputs an invalid blood type then it will create an error and send them to the error slide
               //checks to see if the user entered a valid input
                if ((type.getText().equals("O")||type.getText().equals("A")||type.getText().equals("AB")||type.getText().equals("B")) && (Factor.getText().equals("+")||Factor.getText().equals("-"))){
                     Type = type.getText();
                     factor = Factor.getText();
                }
                else{
                    int x = 1/0;
                }
            }
            catch(Exception exception){//catches an exception and sends it to the error slide
                ScreenError error = new ScreenError();
                error.setVisible(true);
            }
            //goes to the next slide
            TestBloodData Blood = new TestBloodData();
            Blood.setBloodData(Type, Factor.getText());
            TestBlood2 blood = new TestBlood2(Blood);
            blood.setVisible(true);
        }
    }
}
class TestBlood2 extends JFrame implements ActionListener{
    //GUI will make it seem like the user is setting their own personal blood data but doesn't actually store the data.
    TestBloodData Blood;
    JLabel label = new JLabel("Your updated type is displayed. If the updated information is incorrect please select incorrect.             ");
    JLabel message;
    JLabel message2;
    JButton incorrect = new JButton("Incorrect Information");
    //TestBlood2 will display the default and user edited blood information and asks for confirmation
    public TestBlood2(TestBloodData data){//sets the layout
        setLayout(new FlowLayout());
        setSize(750,500);
        Blood = data;
        message = new JLabel("Previous type: "+Blood.returnInitialBD().getType()+Blood.returnInitialBD().getFactor());
        message2 = new JLabel("Updated type: "+ Blood.returnChanges().getType() + Blood.returnChanges().getFactor());
        add(label);
        add(message);
        add(message2);
        add(incorrect);
        incorrect.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e){//if the user says that the inputted value is incorrect it will go back to the previous slide for correction.
        if (e.getSource() == incorrect){
            TestBloodData1 tb = new TestBloodData1();
            tb.setVisible(true);
        }
    }
}
class ScreenError extends JFrame{//if an error this screen will display. Allowing the user to start over and informing them on the valid inputs.
    JLabel message = new JLabel("There was an error. Please exit and try again.");
    JLabel message2 = new JLabel("Please make sure you only enter O, AB, A, or B for the factor and + or - for the type");
    public ScreenError(){
        setSize(900,500);
        setLayout(new FlowLayout());
        add(message);
        add(message2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
