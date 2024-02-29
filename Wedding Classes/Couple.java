public class Couple {
    //constructors - class takes in two people to make a couple
    public Person Bride;
    public Person Groom;

    public Couple(Person bride, Person groom) {
        Bride = bride;
        Groom = groom;

    }
    //get functions return the individual person

    public Person getBride() {
        return Bride;
    }

    public Person getGroom() {
        return Groom;
    }
}
