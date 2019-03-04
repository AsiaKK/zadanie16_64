package utils;

import domain.Task;

import java.util.Comparator;

public class DateComparator  implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        return o1.getEndDateOfPerform().compareTo(o2.getEndDateOfPerform());
    }
}
