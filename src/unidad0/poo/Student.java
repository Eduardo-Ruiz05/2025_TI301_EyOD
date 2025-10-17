package unidad0.poo;

public class Student extends User{
    public String controlNumber;

    public Student(String controlNumber, String firstName, String lastName) {
        super(firstName, lastName);
        this.controlNumber = controlNumber;
    }

    public String getControlNumber() {
        return controlNumber;
    }
    
    
}
