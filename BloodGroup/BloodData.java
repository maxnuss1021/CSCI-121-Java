
enum type {//declares enums
    A, B, AB, O
}
public class BloodData {//bloodData stores all the information about the specific patients blood
    type Type;
    String factor;
    public BloodData(){ //constructor sets the type and factor
        Type = type.O;
        factor = "+";
    }
    public BloodData(String ty, String factor) { //uses enums to the blood type regardless
        if (ty.equalsIgnoreCase("O")){
            Type = type.O;
        }
        if (ty.equalsIgnoreCase("A")){
            Type = type.A;
        }
        if (ty.equalsIgnoreCase("B")){
            Type = type.B;
        }
        if (ty.equalsIgnoreCase("AB")){
            Type = type.AB;
        }
        this.factor = factor;
    }

    public type getType() {//returns blood type
        return Type;
    }

    public void setType(String ty) {//sets blood type
        if (ty.equalsIgnoreCase("O")){
            Type = type.O;
        }
        if (ty.equalsIgnoreCase("A")){
            Type = type.A;
        }
        if (ty.equalsIgnoreCase("B")){
            Type = type.B;
        }
        if (ty.equalsIgnoreCase("AB")){
            Type = type.AB;
        }
    }

    public String getFactor() {//gets blood factor
        return factor;
    }

    public void setFactor(String factor) { // sets blood factor
        this.factor = factor;
    }


}
