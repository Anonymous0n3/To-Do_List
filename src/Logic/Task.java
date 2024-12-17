package Logic;

import java.time.LocalDate;

public class Task {
    private String taskName;
    private LocalDate taskStartDate;
    private LocalDate taskEndDate;

    private Task(String taskName, LocalDate taskStartDate, LocalDate taskEndDate) {
        this.taskName = taskName;
        this.taskStartDate = taskStartDate;
        this.taskEndDate = taskEndDate;
    }

    public static Task DeadlineTask(String taskName, LocalDate taskEndDate) {
        return new Task(taskName, LocalDate.now(),taskEndDate);
    }

    public static Task FreeformTask(String taskName) {
        return new Task(taskName, LocalDate.now(), LocalDate.now());
    }

    public LocalDate getTaskEndDate() {
        return taskEndDate;
    }

    public void setTaskEndDate(LocalDate taskEndDate) {
        this.taskEndDate = taskEndDate;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDate getTaskStartDate() {
        return taskStartDate;
    }

    public void setTaskStartDate(LocalDate taskStartDate) {
        this.taskStartDate = taskStartDate;
    }

    public String toString() {
        return "\t " + taskName + "\n\t Start Date: " + taskStartDate + "\n\t End Date: " + taskEndDate;
    }

}
