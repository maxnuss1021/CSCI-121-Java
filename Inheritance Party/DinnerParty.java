import java.util.*;
public class DinnerParty extends Party{
    //variable for the choice of food for the dinner party
    public int DinnerChoice;

    //creates a function for the dinner party choice 
    public void setDinnerChoice(int i){
        DinnerChoice = i;
    }
    //returns the dinner party choice
    public int getDinnerChoice(){
        return DinnerChoice;
    }
}
