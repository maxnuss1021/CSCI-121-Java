import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.*;
//first class asks the user for the desired size of the pizza
public class Main1 extends JFrame implements ActionListener {
    public String sizes = "";
    //different labels and buttons
    JLabel header = new JLabel("What size pizza?");
    JButton small = new JButton("small ($5)");
    JButton medium = new JButton("medium ($10)");
    JButton large = new JButton("large ($15)");
    JButton supersize = new JButton("super($20)");
    //defining width and height
    public final int WIDTH = 700;
    final int HEIGHT = 500;
    //sets up the screen, adding the buttons and the listeners.
    public Main1() {
        super();
        setSize(WIDTH, HEIGHT);
        setLayout(new GridLayout());
        add(header);
        add(small);
        add(medium);
        add(large);
        add(supersize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        small.addActionListener(this);
        medium.addActionListener(this);
        large.addActionListener(this);
        supersize.addActionListener(this);


    }
    @Override
    //tells all the different buttons what to do when clicked.
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == small) {
            sizes += " Small";
            Main2 pizzaDetails = new Main2(sizes, 5.0); //calls the next class, passing on the size and price of the pizza selected
            pizzaDetails.setVisible(true);
        }
        if (e.getSource() == medium) {
            sizes += " Medium";
            Main2 pizzaDetails = new Main2 (sizes, 10.0);
            pizzaDetails.setVisible(true);
        }
        if (e.getSource() == large) {
            sizes += " Large";
            Main2 pizzaDetails = new Main2(sizes, 15.0);
            pizzaDetails.setVisible(true);
        }
        if (e.getSource() == supersize){
            sizes += " Super";
            Main2 pizzaDetails = new Main2(sizes, 20.0);
            pizzaDetails.setVisible(true);
        }
    }
    public static void main(String[] args){ //starts the entire program calling the first class
        Main1 pizzaOrder = new Main1();
        pizzaOrder.setVisible(true);
    }
}
//second class which takes in the toppings and computes the price
class Main2 extends JFrame implements ActionListener {
    //constructors.
    public static double price; // must be static so that the price adds on to eachother when you order multiple pizzas
    byte counter; // counts the amount of toppings
    public static String items = ""; // will keep track of the items
    Random rand = new Random();
    public int OrderNum = rand.nextInt(99999); // gives the user a random order number so they can identify their order at pickup.
    JLabel header2 = new JLabel("Toppings? +.50 3 MAX");
    JButton pep = new JButton("pepperoni ");
    JButton sausage = new JButton("sausage ");
    JButton chicken = new JButton("chicken ");
    JButton bacon = new JButton("bacon");
    JButton pine = new JButton("pineapple ");
    JButton meatlovers = new JButton("meat lovers (+1.25)");
    JButton excheese = new JButton("(no cost) extra cheese");
    JButton cont = new JButton("submit");
    JButton goback = new JButton("Add to your order");

    public Main2(String p, double i) { //creates the gui and adds in all the buttons and action listeners
        super();
        price += i;
        items += p + " Pizza with";
        final int WIDTH = 2000;
        final int HEIGHT = 500;
        setSize(WIDTH, HEIGHT);
        setLayout(new GridLayout());
        add(header2);
        add(pep);
        add(sausage);
        add(chicken);
        add(bacon);
        add(pine);
        add(meatlovers);
        add(excheese);
        add(cont);
        add(goback);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pep.addActionListener(this);
        sausage.addActionListener(this);
        chicken.addActionListener(this);
        bacon.addActionListener(this);
        pine.addActionListener(this);
        meatlovers.addActionListener(this);
        excheese.addActionListener(this);
        cont.addActionListener(this);
        goback.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
         items += "";
        String deal = " ";
        double x = 0.0;
        //adds to the price and to the list of items
        if (e.getSource() == pep) {
            price += .5;
            items += " pepperoni and";
            counter += 1;
        }
        if (e.getSource() == sausage) {
            price += .5;
            items += " sausage and";
            counter += 1;
        }
        if (e.getSource() == chicken) {
            price += .5;
            items += " chicken and";
            counter += 1;
        }
        if (e.getSource() == bacon) {
            price += .5;
            items += " bacon and";
            counter += 1;
        }
        if (e.getSource() == pine) {
            price += .5;
            items += " pineapple and";
            counter += 1;
        }
        if (e.getSource() == meatlovers) {
            price += 1.25;
            items += " meatlovers package and";
            counter += 3;
        }
        if (e.getSource() == excheese) {
            items += " extra cheese and";
        }
        if (counter > 2) {
            deal = ". You saved 25 cents using a 3 topping deal!"; //added to the final message to tell the user that they got the 25 cents off deal
            x = .25;
        }
        if (counter > 3) {//will display this error message if the user goes beyond 3 toppings. If the limit is exceede the user will have to restart the order process.
            JOptionPane.showMessageDialog(this, "You cannot order more than 3 toppings. Please hit the red x's and redo your order.");
        } else if (e.getSource() == cont) {//displays these messages when the user has completed their order and presses continue
            JOptionPane.showMessageDialog(this, "Your order:" + items + " cost $" + (price - x) + deal + " has been submitted. Please show the order number at pickup."); // gui creativity component
            JOptionPane.showMessageDialog(this, "Your number is "+ OrderNum + " please remember your number and have it ready for pickup."); // gui creativity component
        }
        if (e.getSource() == goback) { //allows the user to go back and add to their order.
            Main1 pizzaOrder = new Main1();
            pizzaOrder.setVisible(true);
        }
    }
}
