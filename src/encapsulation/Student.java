package encapsulation;

public class Student {

    private String name;
    private int age;
    private char gender;
    private boolean alive;

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setAge(int a) {
        age = a;
    }

    public int getAge() {
        return age;
    }

    public void setGender(char g) {
        gender = g;
    }

    public char getGender() {
        return gender;
    }

    public void setAlive(boolean a) {
        alive = a;
    }

    public boolean getAlive() {
        return alive;
    }
}
