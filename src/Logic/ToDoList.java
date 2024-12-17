package Logic;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList implements Serializable {
    private ArrayList<Task> tasks;

    public void createTask(){
        Scanner sc = MyScanner.getInstance();
        System.out.println("Which task type do you wnat to create?");
        System.out.println("1. Deadline Task");
        System.out.println("2. Freeform Task");
        int choice = Integer.parseInt(sc.nextLine());
        System.out.println("Enter task name: ");
        String taskName = sc.nextLine();

        switch(choice){
            case 1:
                System.out.println("Enter task end date in format: yyyy-mm-dd");
                LocalDate taskEndDate;
                try {
                    taskEndDate = LocalDate.parse(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("Invalid date format, task creation aborted");
                    return;
                }
                Task task = Task.DeadlineTask(taskName, taskEndDate);
                addTask(task);
                break;
            case 2:
                Task task2 = Task.FreeformTask(taskName);
                addTask(task2);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }
    public void removeTask(int taskid) throws Exception {
        if (tasks.get(taskid).getTaskEndDate().isBefore(LocalDate.now()) && !tasks.get(taskid).getTaskEndDate().isEqual(tasks.get(taskid).getTaskStartDate())) {
            System.out.println("You have finally completed the task you lazy person!");
        }else {
            System.out.println("You have removed the task!");
        }
        tasks.remove(taskid);
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Task task : tasks) {
            sb.append("Task " + tasks.indexOf(task) + ":\n");
            sb.append(task.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

}
