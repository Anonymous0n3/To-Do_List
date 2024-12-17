package Logic;

import java.io.*;

public class SerializatioStuff {
    public void serialize(ToDoList toDoList) throws IOException, InterruptedException {
        FileOutputStream fileOutputStream = new FileOutputStream("ToDoList.ser");
        ObjectOutputStream objectOutputStream =  new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(toDoList);
        objectOutputStream.close();
        fileOutputStream.close();
        System.out.println("Data Saved");
    }

    public ToDoList deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("ToDoList.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ToDoList toDoList = (ToDoList) objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        System.out.println("Data Loaded");
        return toDoList;
    }
}
