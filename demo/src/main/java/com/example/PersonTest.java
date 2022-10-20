package com.example;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;

public class PersonTest {


    public static void main(String[] args) {
        Person person1 = new Person("Joe", "Smith", 40);
        Person person2 = new Person("Amy", "Gold", 32);
        Person person3 = new Person("Tony", "Stark", 21);
        Person person4 = new Person("Sean", "Irish", 24);
        Person person5 = new Person("Tina", "Brock", 28);
        Person person6 = new Person("Lenny", "Hep", 18);
        ArrayList<Person> myList = new ArrayList<Person>();
        myList.add(person1);
        myList.add(person2);
        myList.add(person3);
        myList.add(person4);
        myList.add(person5);
        myList.add(person6);

        //Age sort
        Comparator<Person> comparatorAge = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        };
        System.out.println("----Age sort----");
        System.out.println("----------------");
        System.out.println("Ascending sort:");
        myList.sort(comparatorAge);
        for (Person person : myList) {
            System.out.println(person.toString());
        }
        System.out.println("----------------");
        System.out.println("Descending sort:");
        myList.sort(comparatorAge.reversed());
        for (Person person : myList) {
            System.out.println(person.toString());
        }

        //First name sort
        Comparator<Person> comparatorFirstName = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Collator.getInstance().compare(o1.getFirstName(), o2.getFirstName());
            }
        };
        System.out.println();
        System.out.println("----First name sort----");
        System.out.println("----------------");
        System.out.println("Ascending sort:");
        myList.sort(comparatorFirstName);
        for (Person person : myList) {
            System.out.println(person.toString());
        }
        System.out.println("----------------");
        System.out.println("Descending sort:");
        myList.sort(comparatorFirstName.reversed());
        for (Person person : myList) {
            System.out.println(person.toString());
        }

        //Last name sort
        Comparator<Person> comparatorLastName = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().length() - o2.getLastName().length();
            }
        };
        System.out.println();
        System.out.println("----Last name sort----");
        System.out.println("----------------");
        System.out.println("Ascending sort:");
        myList.sort(comparatorLastName);
        for (Person person : myList) {
            System.out.println(person.toString());
        }
        System.out.println("----------------");
        System.out.println("Descending sort:");
        myList.sort(comparatorLastName.reversed());
        for (Person person : myList) {
            System.out.println(person.toString());
        }
    }
}
