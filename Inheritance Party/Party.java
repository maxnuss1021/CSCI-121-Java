public class Party {
    public int numberOfGuests;
    public String invite;
    public void setGuests(int x){
        numberOfGuests = x;
    }
    //returns the number of guests the user inputs 
    public int getGuests(){
        return numberOfGuests;
    }
    //prints out the message in the terminal
    public void displayInvitation(String s){
        System.out.println(s);
        invite = s;
    }
    //returns the messgae the user inputs 
    public String getInvite(){
        return invite;
    }
}
