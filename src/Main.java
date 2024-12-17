import Logic.SerializatioStuff;
import Logic.ToDoList;
import Logic.UIStuff;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UIStuff ui = new UIStuff();
        SerializatioStuff ser = new SerializatioStuff();
        ToDoList toDoList = null;
        Scanner sc = Logic.MyScanner.getInstance();
        try {
            toDoList = ser.deserialize();
        } catch (Exception e) {
            System.out.println("Error while loading");
            toDoList = new ToDoList();
        }
        boolean run = true;
        while(run){
            ui.printMenu(toDoList.toString());
            int choice = Integer.parseInt(Logic.MyScanner.getInstance().nextLine());
            switch (choice){
                case 1:
                    toDoList.createTask();
                    break;
                case 2:
                    System.out.println("Enter the id of a task you want to remove: ");
                    int taskid = Integer.parseInt(sc.nextLine());
                    try {
                        toDoList.removeTask(taskid);
                    } catch (Exception e) {
                    }
                    break;
                case 3:
                    run = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        try {
            ser.serialize(toDoList);
        } catch (Exception e) {
            System.out.println("Error while saving");
            throw new RuntimeException(e);
        }
    }
}