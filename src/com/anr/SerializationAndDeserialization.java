package com.anr;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Dog implements Serializable {
    String name;
    int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class SerializationAndDeserialization {



    // serialization
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Dog dog = new Dog("Puppy", 2);

        FileOutputStream fos  = new FileOutputStream("dog.ser");
        ObjectOutputStream oos =  new ObjectOutputStream(fos);
        oos.writeObject(dog);

        // de-serialization
        FileInputStream fis = new FileInputStream("dog.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fis);
        Dog d = (Dog) objectInputStream.readObject();
        System.out.println("d = " + d);



    }


}
