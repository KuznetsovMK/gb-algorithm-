package lesson5;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Task1: " + MyMath.pow(2, 0));

        //task2
        Subject subject1 = new Subject(99, 1, "Apple");
        Subject subject2 = new Subject(1, 1000, "Orange");
        Subject subject3 = new Subject(2, 1000, "Potato");
        Subject subject4 = new Subject(4, 2000, "Garlic");

        List<Subject> subjectList = List.of(subject1, subject2, subject3, subject4);
        Bag bag = new Bag(99, subjectList);
        bag.putSubject();

        System.out.println("Task2: " + "вес: " + bag.getCurrentWeight() + ", стоимость предметов: " + bag.getCurrentCost());
    }
}
