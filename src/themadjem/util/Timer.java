package themadjem.util;


import java.time.LocalTime;

import static java.lang.Math.pow;

/**
 * This class is a timer object that can keep track of
 * a start and an end time and report the difference
 *
 * @author Jesse Maddox
 * @version 1.0
 */
public class Timer {
    //vars to store the start and end times
    private LocalTime startTime;
    private LocalTime endTime;




    public Timer() {

    }

    public void start() {
        startTime = LocalTime.now();
    }

    public void end() {
        endTime = LocalTime.now();
    }

    public void clear() {
        startTime = null;
        endTime = null;
    }

    /**
     * This method will print (to System.out) the difference
     * in time between a starting and an ending time
     *
     * @param header header of the time report
     */
    public void printElapsedTime(String header) {

        endTime = endTime.minusHours(startTime.getHour());
        endTime = endTime.minusMinutes(startTime.getMinute());
        endTime = endTime.minusSeconds(startTime.getSecond());
        endTime = endTime.minusNanos(startTime.getNano());
        if (header != null) {
            System.out.print(header);
        }
        if (endTime.getHour() != 0) {
            System.out.print(endTime.getHour() + " Hours, ");
        }
        if (endTime.getMinute() != 0) {
            System.out.print(endTime.getMinute() + " Minutes, ");
        }
        if (endTime.getSecond() != 0 || endTime.getNano() != 0) {
            int nanos = (int) (endTime.getNano() / pow(10, 4));
            System.out.println(endTime.getSecond() + "." + nanos + " Seconds");
        } else {
            System.out.print("less than 0.001 second");
        }
    }
}
