package utils;

import domain.Task;

import java.util.Comparator;

public class StateComparator implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        return o1.getTaskState().compareTo(o2.getTaskState());
    }
}
