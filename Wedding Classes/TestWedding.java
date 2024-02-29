import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;


public class TestWedding extends JFrame implements ActionListener {
    private JTextField bridefirst, bridelast, groomfirst, groomlast;
    //defind the button to be used for the first JFrame
    JButton cont = new JButton("Continue");
    public TestWedding() {
        setTitle("Wedding Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set text boxes with labels for the user

        JLabel bridename = new JLabel("Enter bride's first and last name:");
        bridefirst = new JTextField(10);
        bridelast = new JTextField(10);
        JLabel groomname = new JLabel("Enter groom's first and last name:");
        groomfirst = new JTextField(10);
        groomlast = new JTextField(10);
        //set grid layout so that it all comes together

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridy++;
        add(bridename, gbc);

        gbc.gridy++;
        add(bridefirst, gbc);

        gbc.gridy++;
        add(bridelast, gbc);

        gbc.gridy++;
        add(groomname, gbc);

        gbc.gridy++;
        add(groomfirst, gbc);

        gbc.gridy++;
        add(groomlast, gbc);

        add(cont);

        cont.addActionListener(this);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    //if the continue button is ckicled get the texts and define the person, and couples. 
    // Passes the couple to the next JFrame
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cont) {
            String brideFirstName = bridefirst.getText();
            String brideLastName = bridelast.getText();
            String groomFirstName = groomfirst.getText();
            String groomLastName = groomlast.getText();
            Person groom = new Person(groomFirstName, groomLastName);
            Person bride = new Person(brideFirstName, brideLastName);
            Couple marriage = new Couple(groom, bride);
            placeAndDate wed = new placeAndDate(marriage);
            wed.setVisible(true);
        }
    }
    public static void main(String[] args) {
        TestWedding names = new TestWedding();
        names.setVisible(true);
    }
}
// Second JFrame will take in the place and date of the wedding. Also adds buttons to continue and sets the layout
class placeAndDate extends JFrame implements ActionListener{
    //setting constructores
    public Couple c;
    private JTextField date, location;
    JButton cont = new JButton("Continue");
    //constructor takes in a couple and adds the 
    public placeAndDate(Couple p) {
        c = p;
        setTitle("Wedding Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel header1 = new JLabel("Enter date of the marriage:");
        date = new JTextField(10);
        location = new JTextField(25);
        JLabel header2 = new JLabel("Enter location of the marriage:");


        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add some padding

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridy++;
        add(header1, gbc);

        gbc.gridy++;
        add(date, gbc);

        gbc.gridy++;
        add(header2, gbc);

        gbc.gridy++;
        add(location, gbc);

        add(cont);

        cont.addActionListener(this);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    @Override
    //passes the wedding through to the next slide
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cont) {
            String d = date.getText();
            String l = location.getText();
            Wedding marry = new Wedding(d, l, c);
            display invitation = new display(marry);
            invitation.setVisible(true);

        }
    }
}
class display extends JFrame{
    //definds the image and JLabels before displaying all the wedding information along with the image. 
    private JLabel wedding;
    ImageIcon icon = new ImageIcon("/Users/maxnussbaum/Desktop/marrageproject.jpg");
    Image image = icon.getImage();
    Image scaledImage = image.getScaledInstance(960, 640, Image.SCALE_SMOOTH);
    JLabel label = new JLabel(new ImageIcon(scaledImage));
    public display (Wedding m ) {
        super();
        wedding = new JLabel("The wedding will take place at " + m.getLocation() + "\n on " + m.getDate() + "\n between the Bride " + m.coup().getBride().getFirst() + " " + m.coup.getBride().getLast() + " and the Groom " + m.coup.getGroom().getFirst() + " " + m.coup.getGroom().getLast());
        final int WIDTH = 2000;
        final int HEIGHT = 1000;
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        add(wedding);
        add(label);
    }
}