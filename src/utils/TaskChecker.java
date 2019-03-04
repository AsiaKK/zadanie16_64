package utils;

import domain.Task;

import java.io.IOException;
import java.util.List;

public class TaskChecker {

    public static void main(String[] args) throws IOException {

        TaskCreator taskCreator = new TaskCreator();
        MyFileReader myFileReader = new MyFileReader();
        TaskShower taskShower = new TaskShower();

        List<Task> tasksFromFile = myFileReader.getFromFile("Tasks.CSV");
        taskShower.showAllTasks(tasksFromFile);

        taskShower.showAllPassedTask(tasksFromFile);

        Task newTaskFromUser = taskCreator.createTaskFromUser();
        tasksFromFile.add(newTaskFromUser);

        taskShower.showAllTasks(tasksFromFile);
        taskShower.showAllFutureTaskForNext24Hours(tasksFromFile);
        taskShower.showAllFutureTaskForNext30Days(tasksFromFile);
        taskShower.showAllFutureTaskForTillEndOfWeek(tasksFromFile);
    }
}
