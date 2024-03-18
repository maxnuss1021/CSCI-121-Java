public class Item {
    // variables
    public String name;
    public int price;
    //constructor taking in a name and price
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }
    //function returns the name when called
    public String getItemName() {
        return name;
    }
    // returns the item price when called
    public int getItemPrice() {
        return price;
    }

}