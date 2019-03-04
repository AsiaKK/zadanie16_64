package domain;

import java.time.LocalDateTime;
import java.util.StringJoiner;

public class Task {

    private String name;
    private String description;
    private LocalDateTime endDateOfPerform;
    TaskState taskState;

    public Task(String name, String description, LocalDateTime endDateOfPerform, TaskState taskState) {
        this.name = name;
        this.description = description;
        this.endDateOfPerform = endDateOfPerform;
        this.taskState = taskState;
    }

    public Task(String name, LocalDateTime endDateOfPerform, TaskState taskState) {
        this.name = name;
        this.endDateOfPerform = endDateOfPerform;
        this.taskState = taskState;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getEndDateOfPerform() {
        return endDateOfPerform;
    }

    public TaskState getTaskState() {
        return taskState;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Task.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("description='" + description + "'")
                .add("endDateOfPerform='" + endDateOfPerform + "'")
                .add("taskState=" + taskState)
                .toString();
    }
}
