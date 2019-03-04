package utils;

import java.time.format.DateTimeFormatter;

public class DateSettings {
    public static String patternDate1 = "[yyyy-MM-dd HH:mm]";
    public static String patternDate2 = "[dd.MM.yyyy HH:mm]";
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(patternDate1 + patternDate2);
}