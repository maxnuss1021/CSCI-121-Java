
public class Patient {//defines variables to be used in the patient class
    int IDnumber;
    int age;
    BloodData d1;
    public Patient(){//constructor without parameters to set to the default blood type and sets IDNumber and Age to 0
        IDnumber = 0;
        age= 0;
        d1 = new BloodData();
    }
    public Patient(int IDnumber, int age, BloodData d1){//uses polymorphism to allow the user to use their own bloodtype
        this.IDnumber = IDnumber;
        this.age = age;
        this.d1 = d1;

    }

    public int getIDnumber() {  //return ID number
        return IDnumber;
    }

    public int getAge() {//returns age
        return age;
    }

    public BloodData getD1() {//returns the blood type
        return d1;
    }
}
