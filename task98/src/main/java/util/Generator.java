package util;

import java.util.Date;

/**
 * Created by vlad on 30.10.15.
 */
public class Generator {

    public static int integer(int min, int max) {
        return min + (int) (Math.random() * ((max + 1) - min));
    }

    public static String city() {
        switch (integer(0, 6)) {
            case 0:
                return "Karaganda";
            case 1:
                return "Kazan";
            case 2:
                return "Kanzas";
            case 3:
                return "Voronezh";
            case 4:
                return "Peterburg";
            case 5:
                return "Kirov";
            default:
                return "Moscow";
        }
    }

    public static String street() {
        switch (integer(0, 5)) {
            case 0:
                return "Selskaya";
            case 1:
                return "Truboprovodnaya";
            case 2:
                return "Tverskaya";
            case 3:
                return "Zorge";
            case 4:
                return "Pirozhkovaya";
            default:
                return "Kul-Gali";
        }
    }

    public static String passportSeries() {
        return String.valueOf(integer(1000, 9999));
    }

    public static String passportNumber() {
        return String.valueOf(integer(100000, 999999));
    }

    public static String passportIssued() {
        return integer(1, 28) + "." + integer(1, 12) + "." + integer(2017, 2080);
    }

    public static Date dateBefore() {
        return dateBefore(new Date());
    }

    public static Date dateBefore(Date date) {
        long current_time = date.getTime();
        Date result = new Date();
        result.setTime((long) (current_time * (1 - 0.1 * Math.random())));
        return result;
    }

    public static Date dateOrNull(Date min , Date max) {
        Date result = null;
        if (Math.random() > 0.5) {
            long current_time = min.getTime();
            long middle_time = max.getTime() - min.getTime();
            result = new Date();
            result.setTime((long) (current_time + (middle_time * Math.random())));
        }
        return result;
    }

}
