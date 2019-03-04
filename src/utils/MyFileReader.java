package utils;

import domain.Task;
import domain.TaskState;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {

    public List<Task> getFromFile(String pathToFile) throws IOException {
        List<Task> orders = new ArrayList<>();

        FileReader fileReader = new FileReader(pathToFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String singleLine;

        while ((singleLine = bufferedReader.readLine()) != null) {
            orders.add(convertToTask(singleLine));
        }

        bufferedReader.close();
        return orders;
    }

    private Task convertToTask(String input) {
        LocalDateTime taskDateTime;

        String[] values = input.split(";");

        String name = values[0];
        String description = values[1];
        taskDateTime = LocalDateTime.parse(values[2], DateSettings.dateTimeFormatter);
        TaskState taskState = TaskState.valueOf(values[3]);

        return new Task(name, description, taskDateTime, taskState);
    }
}