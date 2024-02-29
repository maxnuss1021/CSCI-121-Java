public class Person {
    //define constructors
    public String firstName;
    public String lastName;
    //constructor takes in the first and last name and sets them for the person
    public  Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    //get method returns the name
    public String getFirst(){
        return firstName;
    }
    //set method sets the name
    public String getLast(){
        return lastName;
    }
}
