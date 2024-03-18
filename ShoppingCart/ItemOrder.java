public class ItemOrder {
    //variables
    public Item name;
    public int amt;
    //constructur takes in the item object and amount
    public ItemOrder(Item item, int amount) {
        name = item;
        amt = amount;
    }
    // allows the user to change the amount. Takes a boolean that when true adds an item and when false deletes one
    public void changeAmount(boolean x) {
        if (x){
            amt += 1;
        }
        else {
            amt -= 1;
        }

    }
    // when used this method returns the item
    public Item getItem(){
        return name;
    }
    // when used this method returns the amount
    public int getAmount(){
        return amt;
    }
    // when used this method returns the total price by multiplying the item amount by the item price
    public int getTotalPrice(){
        return name.getItemPrice() * amt;
    }
}
