package utils;

import domain.Task;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;


public class TaskShower {

    public void showAllTasks(List<Task> tasks) {
        System.out.println("==============================================");
        System.out.println("Wszystkie zadania:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void showAllPassedTask(List<Task> tasks, LocalDateTime currentDateTime) {
        System.out.println("==============================================");
        System.out.println("Wszystkie przeszłe zadania:");
        for (Task task : tasks) {
            if (task.getEndDateOfPerform().isBefore(currentDateTime)) {
                System.out.println(task);
            }
        }
    }

    public void showAllPassedTask(List<Task> tasks) {
        showAllPassedTask(tasks, LocalDateTime.now());
    }

    public void showAllFutureTaskForNext24Hours(List<Task> tasks) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("==============================================");
        System.out.println("Wszystkie przyszłe zadania w ciągu 24h):");
        for (Task task : tasks) {
            if (task.getEndDateOfPerform().isAfter(now) && task.getEndDateOfPerform().isBefore(now.plusHours(24))) {
                System.out.println(task);
            }
        }
    }

    public void showAllFutureTaskForNext30Days(List<Task> tasks) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("==============================================");
        System.out.println("Wszystkie przyszłe zadania(w ciągu 30 dni):");
        for (Task task : tasks) {
            LocalDateTime taskEndDate = task.getEndDateOfPerform();
            if (taskEndDate.isAfter(now) && taskEndDate.isBefore(now.plusDays(30))) {
                System.out.println(task);
            }
        }
    }

    public void showAllFutureTaskForTillEndOfWeek(List<Task> tasks) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println("==============================================");
        System.out.println("Wszystkie przyszłe zadania(do końca tygodnia):");
        for (Task task : tasks) {
            if (task.getEndDateOfPerform().isAfter(now) && task.getEndDateOfPerform().isBefore(calculateDateOnEndOfTheWeek(now))) {
                System.out.println(task);
            }
        }
    }

    private LocalDateTime calculateDateOnEndOfTheWeek(LocalDateTime now) {
        int countDays = calculateDateFactor(now.getDayOfWeek());
        int countHours = calculateHoursFactor(now.getHour());
        int countMinutes = calculateMinutesFactor(now.getMinute());

        return now.plusDays(countDays).plusMinutes(countMinutes).plusHours(countHours);
    }

    private int calculateDateFactor(DayOfWeek dow) {
        int result = DayOfWeek.SUNDAY.ordinal() - dow.ordinal();
        return result;
    }

    private int calculateMinutesFactor(int currentMinutes) {
        LocalDateTime midnight = LocalDateTime.parse("1970-01-01 23:59", DateSettings.dateTimeFormatter);
        return midnight.getMinute() - currentMinutes;
    }

    private int calculateHoursFactor(int currentHours) {
        LocalDateTime midnight = LocalDateTime.parse("1970-01-01 23:59", DateSettings.dateTimeFormatter);
        return midnight.getHour() - currentHours;
    }
}