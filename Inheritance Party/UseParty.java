import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.*;
 public class UseParty extends JFrame implements ActionListener {
    //creates variables for the party function 
    public Party p1 = new Party();
    public int Guests;
    public String invite;
    //creates text, buttons, and textfields so users can choose what the inviatation will say, how many guests, and if they want to add a dinner party or not
    JLabel header = new JLabel("How many guests?");
    JTextField text = new JTextField(20);
    JButton cont = new JButton("continue");
    JLabel header2 = new JLabel("What do you want the invitation to say");
    JTextField text2 = new JTextField(20);
    JButton dinnerParty = new JButton("Do you want to make a dinner party?");

    public UseParty() {
        //adds the buttons, textfields, and labels to the gui interface 
        super();
        setSize(500, 500);
        setLayout(new FlowLayout());
        add(header);
        add(text);
        add(header2);
        add(text2);
        add(cont);
        add(dinnerParty);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cont.addActionListener(this);
        dinnerParty.addActionListener(this);
    }

    @Override
    //tells all the different buttons what to do when clicked.
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cont) {
            Guests = Integer.valueOf(text.getText());
            p1.setGuests(Guests);
            invite = text2.getText();
            p1.displayInvitation(invite);
            pdisplay party = new pdisplay((p1));
            party.setVisible(true);

        }
        //tells the code to switch to the next screen when the button is clicked 
        if (e.getSource() == dinnerParty){
            UseDinnerParty p2 = new UseDinnerParty();
            p2.setVisible(true);
        }
    }
    public static void main(String[] args){
    UseParty myparty = new UseParty();
    myparty.setVisible(true);
    }
}
class UseDinnerParty extends JFrame implements ActionListener {
    //creates variables for the Dinner party 
    public DinnerParty p1 = new DinnerParty();
    public int Guests;
    public int choice;
    public String invite;
    //creates text, buttons, and textfields so users can choose what the inviatation will say, how many guests, and what food they pick
    JLabel header = new JLabel("How many guests?");
    JTextField text = new JTextField(20);
    JLabel header2 = new JLabel("What do you want the invitation to say");
    JButton showinvite = new JButton("Show Invite");
    JTextField text2 = new JTextField(20);
    JLabel Choice = new JLabel("Please select your choice for the dinner party: 1 for Tofu, 2 for steak.");
    JButton cont = new JButton("continue");
    JTextField text3 = new JTextField(1);

    public UseDinnerParty() {
        //adds the buttons, textfields, and labels to the gui interface 
        super();
        //sets the size of the interface 
        setSize(500, 500);
        setLayout(new FlowLayout());
        add(header);
        add(text);
        add(header2);
        add(text2);
        add(Choice);
        add(text3);
        add(cont);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cont.addActionListener(this);
        showinvite.addActionListener(this);
    }

    @Override
    //tells all the different buttons what to do when clicked.
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cont) {
            Guests = Integer.valueOf(text.getText());
            p1.setGuests(Guests);
            choice = Integer.valueOf(text3.getText());
            p1.setDinnerChoice(choice);
            invite = text2.getText();
            p1.displayInvitation(invite);
            DPdisplay dp = new DPdisplay(p1);
            dp.setVisible(true);
        }
    }
}
class pdisplay extends JFrame{
    private JLabel party;
    //imports an icon 
    ImageIcon icon = new ImageIcon("/Users/maxnussbaum/Desktop/Party.jpg");
    Image image = icon.getImage();

    //scales the image 
    Image scaledImage = image.getScaledInstance(960, 640, Image.SCALE_SMOOTH);

    JLabel label = new JLabel(new ImageIcon(scaledImage));

    public pdisplay (Party m ) {
        super();
        //prints the number of guests and what the inviatation will say 
        party = new JLabel("The party will have "+ m.getGuests() + " guests. " + m.getInvite());
        final int WIDTH = 2000;
        final int HEIGHT = 1000;
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        add(party);
        add(label);
    }
}
class DPdisplay extends JFrame{
    private JLabel DinnerParty;
    private JLabel DinnerPartyInvite;
    //imports and icon 
    ImageIcon icon = new ImageIcon("/Users/maxnussbaum/Desktop/DinnerParty.jpg");
    Image image = icon.getImage();
    //scales the image 
    Image scaledImage = image.getScaledInstance(960, 640, Image.SCALE_SMOOTH);

    JLabel label = new JLabel(new ImageIcon(scaledImage));

    public DPdisplay (DinnerParty m ) {
        super();
        DinnerParty = new JLabel("The dinner party will have " + m.getGuests()+ " guests. Menu option number "+ m.getDinnerChoice()+ " will be served." );
        DinnerPartyInvite = new JLabel(m.getInvite());
        //sets the width and height of the frame 
        final int WIDTH = 2000;
        final int HEIGHT = 1000;
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        //adds the JLabels to the interface 
        add(DinnerParty);
        add(DinnerPartyInvite);
        add(label);
    }
}
