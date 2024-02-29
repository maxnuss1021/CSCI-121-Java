public class Wedding {
    //constructor takes in the date, location, and couple 
    public String Date;
    public String Location;
    public Couple coup;

    public Wedding(String date, String location, Couple coup){
        this.coup = coup;
        Date = date;
        Location = location;
    }
    //get functions return the date, location, and coup.
    public String getDate(){
        return Date;
    }
    public String getLocation(){
        return Location;
    }
    public Couple coup(){
        return coup;
    }

}
