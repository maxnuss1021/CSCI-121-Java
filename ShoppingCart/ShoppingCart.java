import java.util.ArrayList;
public class ShoppingCart {
    //variables
    public int total = 0;
    private ArrayList<ItemOrder> items;
    //used polymorphism. first constructor is if the program has an array already
    public ShoppingCart(ArrayList<ItemOrder> arr) {
        this.items = arr;

    }
    //second constructor is if the program hasnt created the array yet
    public ShoppingCart(){
        this.items = new ArrayList<>();
    }
    //adds items to the array
    public void addItem(ItemOrder itemOrder) {
        items.add(itemOrder);
    }
    //returns a full string of all the items in the cart with their price and quantity and the total price of the cart
    public String getItems() {
        String ret = "Your items are ";
        for (ItemOrder x : items){
            ret += x.getAmount() + " ";
            ret += x.getItem().getItemName() + " which will cost ";
            ret += x.getTotalPrice() + " dollars, ";
        }

        return ret ;
    }
//gets the total price of the cart
    public int getTotalPrice() {
        for (ItemOrder x : items){
            total += (x.getTotalPrice());
        }
        if (total >= 100){
            total -= 25;
        }
        else if(total >= 50){
            total -= 10;
        }
        return total;

    }
}