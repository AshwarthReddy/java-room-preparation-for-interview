package com.anr.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class User implements Serializable{

    String name;
    transient String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
       objectOutputStream.defaultWriteObject();;
        String customPassword = "123" + password;
        objectOutputStream.writeObject(customPassword);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
       objectInputStream.defaultReadObject();
      String pwd = (String) objectInputStream.readObject();
      password = pwd.substring(3);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

public class CustomSerializationAndDeserialization {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        User user = new User("Aswarth", "password");
        FileOutputStream fileOutputStream = new FileOutputStream("user.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(user);
        System.out.println("user = " + user);


        FileInputStream fileInputStream = new FileInputStream("user.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        User aswarth = (User) objectInputStream.readObject();
        System.out.println("aswarth = " + aswarth);


    }
}

























