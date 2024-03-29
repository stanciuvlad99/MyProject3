package ro.mycode.controllers;

import ro.mycode.models.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ControlStudent {
    private ArrayList<Student> students;
    private final String FILE_PATH="C:\\mycode\\OOP\\Incapsularea\\MyProject5\\src\\ro\\mycode\\data\\student.txt";

    public ControlStudent(ArrayList<Student> students){
        this.students=students;
    }

    public ControlStudent(){
        this.students=new ArrayList<>();
        load(FILE_PATH);
    }

    public void load(String path) {
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            students.clear();
            while (scanner.hasNextLine()){
                String text=scanner.nextLine();
                Student student = new Student(text);
                this.students.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //todo: functie ce afiseaza toti studentii
    public void read(){
        for (int i=0; i<students.size(); i++){
            System.out.println(students.get(i).descriere());
        }
    }

    //todo: functie ce returneaza un student.txt, primeste firstName si lastName ca parametru
    public Student findByFirstNameLastName(String firstName, String lastName){
        for (int i=0; i<students.size(); i++){
            if (students.get(i).getFirstName().equals(firstName) && students.get(i).getLastName().equals(lastName)){
                return students.get(i);
            }
        }
        return null;
    }

    //todo: functie ce returneaza un id valid
    public int nextId(){
        if (students.size()==0){
            return -1;
        }
        return students.get(students.size()-1).getStudentId()+1;
    }

    //todo: functie ce adauga un student.txt in lista, primeste constructor ca parmetru
    public void add(Student student){
        this.students.add(student);
    }

    //todo: functie ce elimina un student.txt, primeste constructor ca parametru
    public void remove(Student student){
        this.students.remove(student);
    }

    //todo: functie ce returneaza un student.txt, primeste email si parola ca parametri
    public Student findByEmailPassword(String email, String password){
        for (int i=0; i<students.size(); i++){
            if (students.get(i).getEmail().equals(email) && students.get(i).getPassword().equals(password)){
                return students.get(i);
            }
        }
        return null;
    }

    //todo: functie ce reuturneaza toti studentii
    public String toSave(){
        if (students.size()==0){
            return "";
        }
        int i=0;
        String text="";
        for (i=0; i<students.size()-1; i++){
            text+=students.get(i).toSave()+"\n";
        }
        text+=students.get(i).toSave();
        return text;
    }

    //todo: functie ce salveaza in fisierul text student.txt
    public void save(String path){
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
