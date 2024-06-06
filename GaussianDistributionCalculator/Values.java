import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener {
    JLabel directions = new JLabel("Welcome, please enter the mean, standard");
    JLabel directions2 = new JLabel("deviation,and x-values of your distribution");
    JLabel mean = new JLabel("Mean:");
    JTextField meanTextField = new JTextField(10);
    JLabel standardDev = new JLabel("Standard Deviation:");
    JTextField standardDevTextField = new JTextField(10);
    JLabel xValue1 = new JLabel("X Value 1");
    JTextField xValueTextField = new JTextField(10);
    JLabel xValue2 = new JLabel("X Value 2");
    JTextField xValue2TextField = new JTextField(10);
    String[] choices = { "greater than", "less than", "between"};
    final JComboBox<String> cb = new JComboBox<String>(choices);
    JButton continueButton = new JButton("Continue");
    final int WIDTH = 1300;
    final int HEIGHT = 200;
    public GUI() {
        super("Z-Score Calculator");
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        Font labelFont = directions.getFont();
        directions.setFont(new Font(labelFont.getFontName(), Font.PLAIN, 30));
        add(directions);
        Font labelFont0 = directions2.getFont();
        directions2.setFont(new Font(labelFont0.getFontName(), Font.PLAIN, 30));
        add(directions2);
        Font labelFont1 = mean.getFont();
        mean.setFont(new Font(labelFont1.getFontName(), Font.PLAIN, 30));
        add(mean);
        add(meanTextField);
        Font labelFont2 = standardDev.getFont();
        standardDev.setFont(new Font(labelFont2.getFontName(), Font.PLAIN, 30));
        add(standardDev);
        add(standardDevTextField);
        Font labelFont3 = xValue1.getFont();
        xValue1.setFont(new Font(labelFont3.getFontName(), Font.PLAIN, 30));
        add(xValue1);
        add(xValueTextField);
        Font labelFont4 = xValue2.getFont();
        xValue2.setFont(new Font(labelFont4.getFontName(), Font.PLAIN, 30));
        add(xValue2);
        add(xValue2TextField);
        add(cb);

        continueButton.setPreferredSize(new Dimension(250,75));
        add(continueButton);
        continueButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //sets the frame to switch to the next when the button is clicked
        if (e.getSource() == continueButton) {
            double mean = 0.0;
            double standardDeviation = 0.0;
            double xValue1 = 0.0;
            try {
                 mean = Double.valueOf(meanTextField.getText().trim());
                 mean = (double) Math.round(mean * 100) /100;
                 standardDeviation = Double.valueOf(standardDevTextField.getText());
                 standardDeviation = (double) Math.round(standardDeviation * 100) /100;
                 xValue1 = Double.valueOf(xValueTextField.getText());
                 xValue1 = (double) Math.round(xValue1 * 100) /100;
            }
            catch(Exception exception){
                JOptionPane.showMessageDialog(this, "Please exit out of the application and make sure you add a valid integer for the mean, standard deviation, and the first xValue");
            }
            if (standardDeviation<= 0){
                JOptionPane.showMessageDialog(this, "Please exit out of the application and make sure your standard deviation is greater than 0");
            }
            double xValue2;
            try{
                xValue2 = Double.valueOf(xValue2TextField.getText().trim());
                xValue2 = (double) Math.round(xValue2 * 100) /100;
            }
            catch(Exception exception){
                xValue2 = xValue1;
            }
            String sign = (String) cb.getSelectedItem();
            if (sign.equals("between")){
                Values values = new Values(mean, standardDeviation, xValue1, xValue2);
                Screen2 screen2 = new Screen2(values, sign);
                screen2.setVisible(true);
            }
            else if(sign.equals("less than")){
                Values values = new Values(mean, standardDeviation, xValue1, false);
                Screen2 screen2 = new Screen2(values, sign);
                screen2.setVisible(true);
            }
            else{
                Values values = new Values(mean, standardDeviation, xValue1, true);
                Screen2 screen2 = new Screen2(values, sign);
                screen2.setVisible(true);
            }


        }
    }
    public static void main(String[] args){
        GUI code = new GUI();
        code.setVisible(true);

    }
}
class Screen2 extends JFrame{
    JLabel message;
    public Screen2(Values v, String s){
        setSize(750,250);
        double zScore = v.getzScore1();
        zScore = (double) Math.round(zScore * 1000) /1000;
        double zScore2 = v.getzScore2();
        zScore2 = (double) Math.round(zScore2 * 1000) /1000;
        double percent = v.getPercentile();
        percent = (double) Math.round(percent * 100000) /100000;
        if (s.equals("between")){
            message = new JLabel("<html> Z score 1: " + zScore + " <br>" +" Z score 2: " + zScore2 + "<br> " + "<br>" + percent + "% Is the probability that a random value in this distribution falls between these x values<html>");
            Font labelFont = message.getFont();
            message.setFont(new Font(labelFont.getFontName(), Font.PLAIN, 30));
            add(message);
        }
        if (s.equals("less than")){
            message = new JLabel("<html> Z score:" + zScore + "<br>" + "<br>" + percent + "% Is the probability that a random value in this distribution is less than this x value<html>");
            Font labelFont = message.getFont();
            message.setFont(new Font(labelFont.getFontName(), Font.PLAIN, 30));
            add(message);
        }
        if (s.equals("greater than")){
            message = new JLabel("<html> Z score: " + zScore +  "<br>" + "<br> "+ percent + "% Is the probability that a random value in this distribution is greater than your x value <html>");
            Font labelFont = message.getFont();
            message.setFont(new Font(labelFont.getFontName(), Font.PLAIN, 30));
            add(message);
        }

    }

}

