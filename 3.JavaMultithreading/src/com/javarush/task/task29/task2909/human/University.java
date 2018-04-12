package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public Student getStudentWithAverageGrade(double avarageGrade) {
        //TODO:
        for(Student x : students) {
            if(x.getAverageGrade() == avarageGrade)
                return x;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        int max = 0;
        for (int i = 1; i < students.size() ; i++) {
            if(students.get(i).getAverageGrade() > students.get(max).getAverageGrade())
                max = i;
        }
        return students.size() == 0 ? null : students.get(max);
    }

    public Student getStudentWithMinAverageGrade() {
        int min = 0;
        for (int i = 0; i < students.size() ; i++) {
            if(students.get(i).getAverageGrade() < students.get(min).getAverageGrade())
                min = i;
        }
        return students.size() == 0 ? null : students.get(min);
    }
    public void expel(Student student) {
        students.remove(student);
    }

//    public void getStudentWithMinAverageGradeAndExpel() {
//        //TODO:
//    }
}