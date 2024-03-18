import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


//first one is an intro for the online grocery list
public class Runner extends JFrame implements ActionListener {
    //variables
    JLabel label = new JLabel ("Welcome to the Online Grocery List");
    JButton continueButton = new JButton ("Click here to start!");
    JLabel d = new JLabel("Deals Today:");
    JLabel d1 = new JLabel ("Spend 50 save 10");
    JLabel d2 = new JLabel ("Spend 100 save 25");

    final int WIDTH = 500;
    final int HEIGHT = 500;
    //constructer sets the different labels and buttons
    public Runner() {
        super("My Frame");
        setSize(WIDTH,HEIGHT);
        setLayout(new FlowLayout());

        Font labelFont1 = label.getFont();
        label.setFont(new Font(labelFont1.getFontName(), Font.PLAIN, 18));
        add(label);
        add(d);
        add(d1);
        add(d2);

        add(continueButton);

        add(d);
        add(d1);
        add(d2);

        continueButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    @Override
    //detects for action events
    public void actionPerformed(ActionEvent e) {
        //will set declare instance of an item for each different option
        if (e.getSource() == continueButton) {
            Item chocolate = new Item("chocolate", 2);
            Item cake = new Item("cake", 7);
            Item milk = new Item("Milk", 3);
            Item cookies = new Item("cookies", 8);
            Item steak = new Item("steak", 10);
            Item ham = new Item("ham", 5);
            Item oranges = new Item("oranges", 1);
            Item chicken = new Item("chicken", 7);
            Item turkey = new Item("turkey", 8);
            Item iceCream = new Item("ice cream", 4);
            Item chips = new Item("chips", 2);
            //passes to the next screen all the different items
            S2 scrn2 = new S2(chocolate, cake, milk, cookies, steak, ham, oranges, chicken, turkey, iceCream, chips);
            scrn2.setVisible(true);
        }
    }
    //runs the runner
    public static void main(String[] args) {
        Runner run = new Runner();
        run.setVisible(true);
    }
}
//Second Screen allows user to pick quantity of items.
class S2 extends JFrame implements ActionListener {
    //variables
    Item chocolate;
    Item cake;
    Item milk;
    Item cookies;
    Item steak;
    Item ham;
    Item oranges;
    Item chicken;
    Item turkey;
    Item iceCream;
    Item chips;
    int amountchocolate;
    int amountcake;
    int amountMilk;
    int amountCookies;
    int amountSteak;
    int amountham;
    int amountoranges;
    int amountchicken;
    int amountturkey;
    int amountIceCream;
    int amountChips;
    JLabel directions1 = new JLabel ("Please enter the amount of each you would like to buy. Please input only integers");
    JLabel directions2 = new JLabel ("If you would not like the product listed, please input 0");
    JLabel chocolateLabel = new JLabel("chocolate $3");
    JTextField chocolateTextField = new JTextField (2);
    JLabel cakeLabel = new JLabel ("cake $5");
    JTextField cakeTextField = new JTextField (2);
    JLabel milkLabel = new JLabel ("Milk $4");
    JTextField milkTextField = new JTextField (2);
    JLabel cookiesLabel = new JLabel("Cookies $6");
    JTextField cookiesTextField = new JTextField (2);
    JLabel steakLabel = new JLabel ("Steak $10");
    JTextField steakTextField = new JTextField (2);
    JLabel hamLabel = new JLabel ("ham $3");
    JTextField hamTextField = new JTextField (2);
    JLabel orangesLabel = new JLabel ("oranges $2");
    JTextField orangesTextField = new JTextField (2);
    JLabel chickenLabel = new JLabel ("chicken $4");
    JTextField chickenTextField = new JTextField (2);
    JLabel turkeyLabel = new JLabel ("turkey $4");
    JTextField turkeyTextField = new JTextField (2);
    JLabel iceCreamLabel = new JLabel ("Ice Cream $3");
    JTextField iceCreamTextField = new JTextField (2);
    JLabel chipsLabel = new JLabel ("Chips $2");
    JTextField chipsTextField = new JTextField (2);


    JButton continueButton = new JButton("Continue");
    final int WIDTH = 500;
    final int HEIGHT = 500;
//this frame displays the order and offers the option to add or delete
    public S2 (Item c, Item ca, Item m, Item coo, Item s, Item h, Item o, Item ch, Item t, Item i, Item chi ) {
        //variables
        super("My Frame");
        chocolate = c;
        cake = ca;
        milk = m;
        cookies = coo;
        steak = s;
        ham = h;
        oranges = o;
        chicken = ch;
        turkey = t;
        iceCream = i;
        chips = chi;

        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());


        add(directions1);
        add(directions2);
        add(chocolateLabel);
        add(chocolateTextField);
        add(cakeLabel);
        add(cakeTextField);
        add(milkLabel);
        add(milkTextField);
        add(cookiesLabel);
        add(cookiesTextField);
        add(steakLabel);
        add(steakTextField);
        add(hamLabel);
        add(hamTextField);
        add(orangesLabel);
        add(orangesTextField);
        add(chickenLabel);
        add(chickenTextField);
        add(turkeyLabel);
        add(turkeyTextField);
        add(iceCreamLabel);
        add(iceCreamTextField);
        add(chipsLabel);
        add(chipsTextField);



        add(continueButton);
        continueButton.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    //action listener waits for a button to be pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == continueButton) {
            amountchocolate = Integer.valueOf(chocolateTextField.getText());
            amountcake = Integer.valueOf(cakeTextField.getText());
            amountMilk = Integer.valueOf(milkTextField.getText());
            amountCookies = Integer.valueOf((cookiesTextField.getText()));
            amountSteak = Integer.valueOf(steakTextField.getText());
            amountham = Integer.valueOf(hamTextField.getText());
            amountoranges = Integer.valueOf(orangesTextField.getText());
            amountchicken = Integer.valueOf((chickenTextField.getText()));
            amountturkey = Integer.valueOf((turkeyTextField.getText()));
            amountIceCream = Integer.valueOf(iceCreamTextField.getText());
            amountChips = Integer.valueOf((chipsTextField.getText()));
            ItemOrder choc = new ItemOrder(chocolate, amountchocolate);
            ItemOrder cak = new ItemOrder(cake, amountcake);
            ItemOrder ilk = new ItemOrder(milk, amountMilk);
            ItemOrder cookie = new ItemOrder(cookies, amountCookies);
            ItemOrder teak = new ItemOrder(steak, amountSteak);
            ItemOrder hm = new ItemOrder(ham, amountham);
            ItemOrder oran = new ItemOrder(oranges, amountoranges);
            ItemOrder chi = new ItemOrder(chicken, amountchicken);
            ItemOrder tur = new ItemOrder(turkey, amountturkey);
            ItemOrder ice = new ItemOrder(iceCream, amountIceCream);
            ItemOrder chip = new ItemOrder(chips, amountChips);
            Screen3 screen3 = new Screen3(choc, cak, ilk, cookie, teak, hm, oran, chi, tur, ice, chip);
            screen3.setVisible(true);



        }
    }
}
//screen three shows the complete shopping list and offers the user to add or delete items
class Screen3 extends JFrame implements ActionListener{
    ItemOrder chocolate;
    ItemOrder cake;
    ItemOrder milk;
    ItemOrder cookies;
    ItemOrder steak;
    ItemOrder ham;
    ItemOrder oranges;
    ItemOrder chicken;
    ItemOrder turkey;
    ItemOrder iceCream;
    ItemOrder chips;

    JLabel directions1 = new JLabel("This is your cart.");
    JLabel directions2 = new JLabel("If you would like to add or delete an item, please click the corresponding button below");
    JLabel directions3 = new JLabel("If you are happy with the items in your cart, please hit the Continue button");
    JButton add = new JButton("Add");
    JButton delete = new JButton("Delete");
    JButton continueButton = new JButton("Continue");
    JTextArea items;

    final int WIDTH = 800;
    final int HEIGHT = 700;
    public ShoppingCart S1 = new ShoppingCart();
//constructer takes in the item orders
    public Screen3 (ItemOrder choc, ItemOrder cak, ItemOrder ilk, ItemOrder cookie, ItemOrder teak, ItemOrder hm, ItemOrder oran, ItemOrder chi, ItemOrder tur, ItemOrder ice, ItemOrder chip) {
        super("My Frame");
        S1.addItem(choc);
        S1.addItem(cak);
        S1.addItem(ilk);
        S1.addItem(cookie);
        S1.addItem(teak);
        S1.addItem(hm);
        S1.addItem(oran);
        S1.addItem(tur);
        S1.addItem(ice);
        S1.addItem(chi);
        S1.addItem(chip);
        chocolate = choc;
        cake = cak;
        milk = ilk;
        cookies = cookie;
        steak = teak;
        ham = hm;
        oranges = oran;
        chicken = chi;
        turkey = tur;
        iceCream = ice;
        chips = chip;

        items = new JTextArea(S1.getItems() + " your total price is $" + S1.getTotalPrice());
        items.setEditable(false);
        items.setLineWrap(true);
        items.setWrapStyleWord(true);
        items.setColumns(30);
        boolean b = false;

        setLayout(new FlowLayout());
        add(items);
        setSize(WIDTH, HEIGHT);
        add(directions1);
        add(directions2);
        add(directions3);
        add(add);
        add(delete);
        add(continueButton);
        delete.addActionListener(this);
        add.addActionListener(this);
        continueButton.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    //Action Listener will act based on what happens
    public void actionPerformed(ActionEvent e) {
        //if you want to add boolean is true and goes to the next one
        if (e.getSource() == add) {
            boolean b = true;
            AddOrDeleteScreen addOrDeleteScreen = new AddOrDeleteScreen(chocolate, cake, milk, cookies, steak, ham, oranges, chicken, turkey, iceCream, chips, b);
            addOrDeleteScreen.setVisible(true);
        }
        //if delete the boolean is false
        if (e.getSource() == delete){
            boolean b = false;
            AddOrDeleteScreen addOrdeleteScreen = new AddOrDeleteScreen(chocolate, cake, milk, cookies, steak, ham, oranges, chicken, turkey, iceCream, chips, b);
            addOrdeleteScreen.setVisible(true);
        }
        //continue if the user is okay with his order
        if(e.getSource() == continueButton) {
            ArrayList <ItemOrder> ar = new ArrayList<ItemOrder>();
            ar.add(chocolate);
            ar.add(milk);
            ar.add(cake);
            ar.add(cookies);
            ar.add(steak);
            ar.add(ham);
            ar.add(oranges);
            ar.add(chicken);
            ar.add(turkey);
            ar.add(iceCream);
            ar.add(chips);
            ShoppingCart SC = new ShoppingCart(ar);
            FinalScreen finalScreen = new FinalScreen(SC);
            finalScreen.setVisible(true);
        }







    }
}
//adds or deletes users desired items
class AddOrDeleteScreen extends JFrame implements ActionListener{
    //variables
    ItemOrder chocolate;
    ItemOrder cake;
    ItemOrder milk;
    ItemOrder cookies;
    ItemOrder steak;
    ItemOrder ham;
    ItemOrder oranges;
    ItemOrder chicken;
    ItemOrder turkey;
    ItemOrder iceCream;
    ItemOrder chips;
    JPanel panel1 = new JPanel();
    JLabel label1 = new JLabel("Select an item you would like to add or delete and then click the corresponding button");
    String[] choices = { "chocolate", "cake", "Milk", "Cookies", "Steak", "ham", "oranges", "chicken", "turkey", "Ice Cream", "Chips"};
    final JComboBox<String> cb = new JComboBox<String>(choices);
    JButton continueButton = new JButton("Continue");
    final int WIDTH = 800;
    final int HEIGHT = 500;
    public boolean yes;
    String x = " ";
    //add or delete sceeen takes in the item orders and adds or deletes from the quantity.
    public AddOrDeleteScreen (ItemOrder choc, ItemOrder cak, ItemOrder ilk, ItemOrder cookie, ItemOrder teak, ItemOrder hm, ItemOrder oran, ItemOrder chi, ItemOrder tur, ItemOrder ice, ItemOrder chip, boolean b) {
        super("My Frame");
        chocolate = choc;
        cake = cak;
        milk = ilk;
        cookies = cookie;
        steak = teak;
        ham = hm;
        oranges = oran;
        chicken = chi;
        turkey = tur;
        iceCream = ice;
        chips = chip;
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        add(panel1);
        add(label1);
        add(cb);
        add(continueButton);
        continueButton.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    @Override
    //listens for the action events and then changes the amount if the user wishes
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == continueButton) {
            try{
                x = (String) cb.getSelectedItem();
                if (x.equals("chocolate")){
                    chocolate.changeAmount(yes);
                }
                if(x.equals("cake")){
                    cake.changeAmount(yes);
                }
                if (x.equals("Milk")){
                    milk.changeAmount(yes);
                }
                if (x.equals("Cookies")){
                    chocolate.changeAmount(yes);
                }
                if (x.equals("Steak")){
                    chocolate.changeAmount(yes);
                }
                if (x.equals("ham")){
                    chocolate.changeAmount(yes);
                }
                if (x.equals("oranges")){
                    chocolate.changeAmount(yes);
                }
                if (x.equals("chicken")){
                    chocolate.changeAmount(yes);
                }
                if (x.equals("turkey")){
                    chocolate.changeAmount(yes);
                }
                if (x.equals("Ice Cream")){
                    chocolate.changeAmount(yes);
                }
                if (x.equals("Chips")){
                    chocolate.changeAmount(yes);
                }
                //if you delete an item that is not in your cart then it will produce an error.
                if (chocolate.getTotalPrice() < 0 || cake.getTotalPrice() < 0 || milk.getTotalPrice() < 0 || cookies.getTotalPrice() < 0 || steak.getTotalPrice() < 0 || ham.getTotalPrice() < 0 || oranges.getTotalPrice() < 0 || chicken.getTotalPrice() < 0 || turkey.getTotalPrice() < 0 || iceCream.getTotalPrice() < 0 || chips.getTotalPrice() < 0) {
                    System.out.println(1/0);
                }
            } catch (Exception exception){
                JOptionPane.showMessageDialog(this, "You deleted an item that did not exist in your cart. Please click x and restart");
            }
            Screen3 screen3 = new Screen3(chocolate, cake, milk, cookies, steak, ham, oranges, chicken, turkey, iceCream, chips);
            screen3.setVisible(true);
        }
    }
}

//shows the final message with all of your items and prices
class FinalScreen extends JFrame {
    JTextArea message;
    ShoppingCart sh;
    final int WIDTH = 1000;
    final int HEIGHT = 500;
//final screen will print out the final amount in a text box so that it all fits :)
    public FinalScreen (ShoppingCart s){
        super();
        setSize(WIDTH,HEIGHT);
        sh = s;
        int total = s.getTotalPrice();
        if (total >= 100){
            total -= 25;
        }
        else if(total >= 50){
            total -= 10;
        }
        message = new JTextArea(s.getItems() + " your total price is $" + total);
        message.setEditable(false);
        message.setLineWrap(true);
        message.setWrapStyleWord(true);
        message.setColumns(30);
        add(message);
    }
}



