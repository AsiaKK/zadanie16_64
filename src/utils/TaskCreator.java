package utils;

import domain.Task;
import domain.TaskState;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TaskCreator {

    public Task createTaskFromUser() {
        Scanner scan = new Scanner(System.in);
        LocalDateTime taskDateTime;

        String userinputName;
        String userInputDescription;
        String userInputDateOfPerform;

        System.out.println("==============================================");
        System.out.println("Podaj nowe zadanie");
        System.out.println("podaj nazwę...");
        userinputName = scan.nextLine();

        System.out.println("podaj opis...");
        userInputDescription = scan.nextLine();

        System.out.println("podaj ostateczna datę wykonania...");
        System.out.println("poprawny format daty: yyyy-MM-dd HH:mm lub dd.MM.yyyy HH:mm");
        userInputDateOfPerform = scan.nextLine();

        scan.close();
        taskDateTime = LocalDateTime.parse(userInputDateOfPerform, DateSettings.dateTimeFormatter);

        Task newTask = new Task(userinputName, userInputDescription, taskDateTime, TaskState.OPEN);

        System.out.println("Twóje nowe zadanie: ");
        System.out.println(newTask.toString());

        return newTask;
    }
}