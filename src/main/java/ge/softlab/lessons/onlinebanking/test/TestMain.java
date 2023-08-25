package ge.softlab.lessons.onlinebanking.test;

import ge.softlab.lessons.onlinebanking.entities.Account;
import ge.softlab.lessons.onlinebanking.entities.Person;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TestMain {

    public void test(){
        ArrayList<Person> a=new ArrayList<>();
        a.add(new Person());
        a.get(0);

        Set<Person> s = new HashSet<>();
        s.add(new Person());



    }
    public void test1(){
        Person[] personsArray = new Person[10];

        personsArray[0] = new Person();
        personsArray[1] = new Person();
        personsArray[1].setFirstName("test");

        personsArray[3] = new Person();


        System.out.println(personsArray);

        ArrayList<Person>persons = new ArrayList<Person>();
        persons.add(new Person());
        persons.add(new Person());
 //       persons.add(new Account());
  //      persons.add(40);
 //       persons.add(10.5);
 //       persons.add(800L);

        Person p = persons.get(1);
        p.setFirstName("saxeli");


 //       Person p2 = (Person) persons.get(2);
  //      p2.setFirstName("asdasd");

   //     personList.get(1);   //წვდომა კონკრეტულზე თუ ინდექსი ვიცით ხდება ასე
  //      personList.get(10);  // იტყვის რომ ამ ნომრით ინდექსი არ არის.მაქს 10 როცაა,რეალურად 9 წევრია.
   //     personList.remove(0);   // ნულოვან ინდექსზე არსებულ ობიექტს წაშლის

    //     p.setFirstName("asdasd");

        persons.remove(0);

        System.out.println(persons);


    }
}
