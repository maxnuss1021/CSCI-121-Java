import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//welcome page
//taking in 2 two patients; store values
//displaying patient data
//thank you slide
public class GUICode extends JFrame implements ActionListener {//sets messages, labels, variables, and text boxes
    JLabel j1 = new JLabel ("Red Cross");
    JLabel j2 = new JLabel ("Welcome! Donate Blood Today");
    JLabel j3 = new JLabel("Click the continue button to register you and one other to donate! Click See my Type to set your blood data!");
    //the second option allows the user to "set their data". However, they will have to re-enter it to register for the blood drive.
    JButton continueButton = new JButton("Continue");
    JButton TestBlood = new JButton("See my Type?");
    final int WIDTH = 1300;
    final int HEIGHT = 500;
    public GUICode() {//adds all the elements to the frame
        super("My Frame");
        setSize(WIDTH,HEIGHT);
        setLayout(new FlowLayout());

        Font labelFont1 = j1.getFont();//changes font to desired style.
        j1.setFont(new Font(labelFont1.getFontName(), Font.PLAIN, 100));
        add(j1);
        j1.setForeground (Color.red);

        Font labelFont2 = j2.getFont();
        j2.setFont(new Font(labelFont2.getFontName(), Font.PLAIN, 40));
        add(j2);

        Font labelFont3 = j3.getFont();
        j3.setFont(new Font(labelFont3.getFontName(), Font.PLAIN, 20));
        add(j3);

        TestBlood.setPreferredSize(new Dimension(400,60));//changes the size of the button to make the GUI look good.
        TestBlood.addActionListener(this);
        add(TestBlood);

        continueButton.setPreferredSize(new Dimension(400,60));
        continueButton.addActionListener(this);
        add(continueButton);

        //sets the frame to close when the exit button is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // moves to the next frame when the continue button is pressed
        if (e.getSource() == continueButton) {
            Screen2 screen2 = new Screen2();
            screen2.setVisible(true);

        }
        if (e.getSource() == TestBlood){//if test is selected goes to TestBloodData for the user to set his blood type
            TestBloodData1 gui2 = new TestBloodData1();
            gui2.setVisible(true);
        }
    }
    //the main function
    public static void main(String[] args) {//main function runs the entire code.
        GUICode code = new GUICode();
        code.setVisible(true);
    }

}



class Screen2 extends JFrame implements ActionListener{//Screen2 takes in info on the different patients for donation
    //defines labels, text fields, variables, and messages
    JLabel j = new JLabel("Please enter your Blood Type in the first TextField");
    JLabel l = new JLabel("and your Blood factor in the second TextField");
    JLabel j1 = new JLabel("Blood Types include 'O', 'A', 'B', or 'AB'");
    JLabel j2 = new JLabel("Blood Factors include '+', or '-'");
    //extra spaces are for design purposes.
    JLabel j3 = new JLabel ("   Patient 1: BloodType is 'O' and Blood Factor is '+'       ");
    JLabel j4 = new JLabel("               Patient 2: ");
    JTextField type2 = new JTextField(3);
    JTextField factor2 = new JTextField(3);
    JLabel j5 = new JLabel("          Patient 3: ");
    JTextField type3 = new JTextField(3);
    JTextField factor3 = new JTextField(3);
    JButton continueButton = new JButton("Continue");
    final int WIDTH = 900;
    final int HEIGHT = 500;
    public Screen2() {//puts in all the information
        super("My Frame");
        setSize(WIDTH,HEIGHT);
        setLayout(new FlowLayout());

        Font labelFont = j.getFont();
        j.setFont(new Font(labelFont.getFontName(), Font.PLAIN, 25));
        add(j);

        Font labelFont0 = l.getFont();
        l.setFont(new Font(labelFont0.getFontName(), Font.PLAIN, 25));
        add(l);

        Font labelFont1 = j1.getFont();
        j1.setFont(new Font(labelFont1.getFontName(), Font.PLAIN, 25));
        add(j1);

        Font labelFont2 = j2.getFont();
        j2.setFont(new Font(labelFont2.getFontName(), Font.PLAIN, 25));
        add(j2);

        Font labelFont3 = j3.getFont();
        j3.setFont(new Font(labelFont3.getFontName(), Font.PLAIN, 25));
        add(j3);

        Font labelFont4 = j4.getFont();
        j4.setFont(new Font(labelFont4.getFontName(), Font.PLAIN, 25));
        add(j4);

        add(type2);
        add(factor2);

        Font labelFont5 = j5.getFont();
        j5.setFont(new Font(labelFont5.getFontName(), Font.PLAIN, 25));
        add(j5);

        add(type3);
        add(factor3);

        continueButton.setPreferredSize(new Dimension(300,40));
        add(continueButton);
        continueButton.addActionListener(this);
        //sets the frame to close when the exit button is clicked
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //declares variables and moves to the next frame when the continue button is pressed
        if (e.getSource() == continueButton) {
            String typePatient2 = type2.getText();
            String factorPatient2 = factor2.getText();
            String typePatient3 = type3.getText();
            String factorPatient3 = factor3.getText();
            BloodData Patient1 = new BloodData(typePatient2, factorPatient2);
            BloodData Patient2 = new BloodData(typePatient3, factorPatient3);

            Screen3 screen3 = new Screen3(Patient1, Patient2);
            screen3.setVisible(true);

        }
    }
}

class Screen3 extends JFrame implements ActionListener {//Screen three wil take in patient information
    //variables and labels
    public BloodData patient2;
    public BloodData patient3;
    JLabel j1 = new JLabel("Please enter your ID Number and age for each Patient");
    JLabel j2 = new JLabel("Patient 2:");
    JLabel j3 = new JLabel("Enter your ID Number here:");
    JTextField idNumber2 = new JTextField(12);
    JLabel j4 = new JLabel("Enter your age here: ");
    JTextField age2 = new JTextField(12);
    JLabel j5 = new JLabel("Patient 3:");
    JLabel j6 = new JLabel("Enter your ID Number here:");
    JTextField idNumber3 = new JTextField(12);
    JLabel j7 = new JLabel("Enter your age here: ");
    JTextField age3 = new JTextField(12);

    JButton continueButton = new JButton("Continue");
    final int WIDTH = 900;
    final int HEIGHT = 500;

    public Screen3(BloodData Patient2, BloodData Patient3){//takes in two different BloodData instances
        super("My Frame");
        patient2 = Patient2;
        patient3 = Patient3;
        setSize(WIDTH,HEIGHT);
        setLayout(new FlowLayout());
        //setting fonts for the labels.

        Font labelFont1 = j1.getFont();
        j1.setFont(new Font(labelFont1.getFontName(), Font.PLAIN, 33));
        add(j1);
        Font labelFont2 = j2.getFont();
        j2.setFont(new Font(labelFont2.getFontName(), Font.PLAIN, 20));
        add(j2);
        Font labelFont3 = j3.getFont();
        j3.setFont(new Font(labelFont3.getFontName(), Font.PLAIN, 20));
        add(j3);
        add(idNumber2);
        Font labelFont4 = j4.getFont();
        j4.setFont(new Font(labelFont4.getFontName(), Font.PLAIN, 20));
        add(j4);
        add(age2);

        Font labelFont5 = j5.getFont();
        j5.setFont(new Font(labelFont5.getFontName(), Font.PLAIN, 20));
        add(j5);
        Font labelFont6 = j6.getFont();
        j6.setFont(new Font(labelFont6.getFontName(), Font.PLAIN, 20));
        add(j6);
        add(idNumber3);
        Font labelFont7 = j7.getFont();
        j7.setFont(new Font(labelFont7.getFontName(), Font.PLAIN, 20));
        add(j7);
        add(age3);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        continueButton.setPreferredSize(new Dimension(300,40));
        add(continueButton);
        continueButton.addActionListener(this);


    }
    @Override
    public void actionPerformed(ActionEvent e) {//what will happen if continue is pressed.
        if (e.getSource() == continueButton) {//takes in teh age and ID number. Passes two patient classes to the next screen
            int IDNumber2 =  Integer.valueOf(idNumber2.getText());
            int Age2 = Integer.valueOf(age2.getText());
            Patient patient22 = new Patient(IDNumber2, Age2, patient2);
            int IDNumber3 = Integer.valueOf(idNumber3.getText());
            int Age3 = Integer.valueOf(age3.getText());
            Patient patient33 = new Patient(IDNumber3, Age3, patient3);
            Screen4 screen4 = new Screen4(patient22, patient33);
            screen4.setVisible(true);
        }

    }
}

class Screen4 extends JFrame implements ActionListener {//Screen four displayes the blood type data.
    //defines different variables
    public Patient Patient2;
    public Patient Patient3;
    JLabel j1 = new JLabel("DEFAULT Patient 1: BloodType is 'O' and Blood Factor is '+'");
    JLabel patient2;
    JLabel patient3;
    JButton continueButton = new JButton ("Continue");
    final int WIDTH = 900;
    final int HEIGHT = 500;
    public Screen4(Patient patient22, Patient patient33) {//confirms the message and displays it on the screen
        //message contains information on the two patients
        super("My Frame");
        Patient2 = patient22;
        Patient3 = patient33;
        patient2 = new JLabel("Patient 2: BloodType is '" + Patient2.getD1().getType() + "' and Blood Factor is '" + Patient2.d1.getFactor() + "'" + "and ID Number is '" + Patient2.getIDnumber() + "'"  + " and Age is '" + Patient2.getAge() + "'");
        patient3 = new JLabel("Patient 3: BloodType is '" + Patient3.getD1().getType() + "' and BloodFactor is '" + Patient3.d1.getFactor() + "'" + " and ID Number is " +Patient3.getIDnumber() + "'" + " and Age is '" + Patient3.getAge() + "'");
        setSize(WIDTH,HEIGHT);
        setLayout(new FlowLayout());

        Font labelFont1 = j1.getFont();
        j1.setFont(new Font(labelFont1.getFontName(), Font.PLAIN, 20));
        add(j1);

        Font labelFont2 = patient2.getFont();
        patient2.setFont(new Font(labelFont2.getFontName(), Font.PLAIN, 20));
        add(patient2);

        Font labelFont3 = patient3.getFont();
        patient3.setFont(new Font(labelFont3.getFontName(), Font.PLAIN, 20));
        add(patient3);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        continueButton.setPreferredSize(new Dimension(300,40));
        add(continueButton);
        continueButton.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {//what happens when continue is pressed
        if (e.getSource() == continueButton) {
            ScreenYes screenyes = new ScreenYes();
            screenyes.setVisible(true);

        }

    }

}

class ScreenYes extends JFrame implements ActionListener{//Donation added for creativity
    //defines labels and variables.
    JLabel j1 = new JLabel("Thank you for donating!!!");
    JLabel j2 = new JLabel("Please enter your Phone Number and we will contact you soon");
    JTextField textfield = new JTextField(10);
    JButton continueButton = new JButton("Continue");
    final int WIDTH = 900;
    final int HEIGHT = 500;
    public ScreenYes() {//adds all the aspects into the screen. "Takes in" a phone number.
        super("My Frame");
        setSize(WIDTH,HEIGHT);
        setLayout(new FlowLayout());

        Font labelFont1 = j1.getFont();
        j1.setFont(new Font(labelFont1.getFontName(), Font.PLAIN, 25));
        add(j1);

        Font labelFont2 = j2.getFont();
        j2.setFont(new Font(labelFont2.getFontName(), Font.PLAIN, 25));
        add(j2);

        add(textfield);

        continueButton.setPreferredSize(new Dimension(300,40));
        add(continueButton);
        continueButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    public void actionPerformed(ActionEvent e) {//what happens when continue is pressed
        if (e.getSource() == continueButton) {
            ScreenFinal screenfinal = new ScreenFinal();
            screenfinal.setVisible(true);

        }
    }
}


class ScreenFinal extends JFrame {//final screen thanks the user and lets them know they will be contacted to make an appointment.
    JLabel j1 = new JLabel("Thank you for using Red Cross.");
    JLabel j2 = new JLabel("We will contact you in the next 48 hours");
    final int WIDTH = 900;
    final int HEIGHT = 500;
    public ScreenFinal() {//adds everything needed for the last screen
        super("My Frame");
        setSize(WIDTH,HEIGHT);
        setLayout(new FlowLayout());
        Font labelFont1 = j1.getFont();
        j1.setFont(new Font(labelFont1.getFontName(), Font.PLAIN, 25));
        add(j1);

        Font labelFont2 = j2.getFont();
        j2.setFont(new Font(labelFont2.getFontName(), Font.PLAIN, 25));
        add(j2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



}
