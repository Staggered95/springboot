package shubham.springboot_1;

import org.springframework.stereotype.Component;

@Component
public class Student {
    String name;
    int roll;



    public void setStudent(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }

    public String getName() { return this.name; }
    public int getRoll() { return this.roll; }

    public String toString() {
        return "Name: " + name + " Roll: " + roll;
    }
}
