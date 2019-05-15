package encapsulation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Encapsulation {

    static ArrayList<Student> studentList = new ArrayList<>();

    public static void addStudent() {
        String UserResponse;
        do {
            Student aStudent = new Student();
            Scanner sc = new Scanner(System.in);

            System.out.println("Please enter student name");
            aStudent.setName(sc.nextLine());

            System.out.println("Please enter student age");
            aStudent.setAge(Integer.parseInt(sc.next()));

            System.out.println("Please enter student gender M/F");
            aStudent.setGender(sc.next().charAt(0));

            System.out.println("Please enter true if student "
                    + "is \"alive\" and \"false\" if not");
            aStudent.setAlive(Boolean.parseBoolean(sc.next()));

            //add student to the list
            studentList.add(aStudent);
            System.out.println("Enter Q to quit or any other letter to continue");
            UserResponse = sc.next();
        } while (!UserResponse.equalsIgnoreCase("Q"));
    }

    public static void displayAllStudents() {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println("Name: " + studentList.get(i).getName());
            System.out.println("Age: " + studentList.get(i).getAge());
            System.out.println("Gender: " + studentList.get(i).getGender());
            System.out.println("Alive: " + String.valueOf(studentList.get(i).getAlive()) + "\t");
        }
    }

    public static void removeStudent() {
        String studentToRemove;

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Please enter student to remove or press Q to quit");
            studentToRemove = sc.nextLine();
            if (!studentToRemove.equalsIgnoreCase("Q")) {
                for (int i = 0; i < studentList.size(); i++) {
                    if (studentToRemove.equalsIgnoreCase(studentList.get(i).getName())) {
                        studentList.remove(i--);
                    }
                }
            }
        } while (!studentToRemove.equalsIgnoreCase("Q"));
    }

    public static void saveToFile() {
        try {

            BufferedWriter bw = null;
            FileWriter fw = null;

            fw = new FileWriter("C:\\Users\\Trainee\\OneDrive\\Software Development Traineeship\\Java\\Java Save To File Files\\studentlist.txt");
            bw = new BufferedWriter(fw);

            for (int i = 0; i < studentList.size(); i++) {
                bw.write(studentList.get(i).getName());
                bw.newLine();

                bw.write(studentList.get(i).getGender());
                bw.newLine();

                bw.write(String.valueOf(studentList.get(i).getAge()));
                bw.newLine();

                bw.write(String.valueOf(studentList.get(i).getAlive()));
                bw.newLine();

            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.print("Exception");
        }
    }
    
        public static void ReadFromFile() {
        File inFile = new File("C:\\Users\\Trainee\\OneDrive\\Software Development Traineeship\\Java\\Java Save To File Files\\studentlist.txt");

        try {

            Scanner sc = new Scanner(inFile);
            while (sc.hasNextLine()) {
                Student aStudent = new Student();
                aStudent.setName(sc.nextLine());
                aStudent.setGender(sc.nextLine().charAt(0));
                aStudent.setAge(Integer.parseInt(sc.nextLine()));
                aStudent.setAlive(Boolean.parseBoolean(sc.nextLine()));

                studentList.add(aStudent);
            }
            sc.close();

        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + inFile + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + inFile + "'");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        ReadFromFile();

        do {
            System.out.println("Please select an option\n");
            System.out.println("1. Display Student List");
            System.out.println("2. Add Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Exit");

            option = sc.nextInt();

            switch (option) {
                case 1:
                    displayAllStudents();
                    break;
                case 2:
                    addStudent();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    saveToFile();
                    break;
            }
        } while (option != 4);
    }

}
