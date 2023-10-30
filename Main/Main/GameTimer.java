package Main;

import java.io.*;
import java.util.Scanner;

public class GameTimer {
    private long startTime;
    private long elapsedTimeInMilliseconds;
    private boolean isRunning;

    public GameTimer() {
        startTime = 0; // Initialize the start time to 0
        elapsedTimeInMilliseconds = 0;
        isRunning = false;
    }

    public void start() {
        if (!isRunning) {
            startTime = System.currentTimeMillis() - elapsedTimeInMilliseconds;
            isRunning = true;
        }
    }

    public void pause() {
        if (isRunning) {
            updateElapsedTime();
            isRunning = false;
        }
    }

    public void updateElapsedTime() {
        if (isRunning) {
            // Calculate elapsed time in milliseconds
            long currentTime = System.currentTimeMillis();
            elapsedTimeInMilliseconds = currentTime - startTime;
        }
    }

    public String getFormattedElapsedTime() {
        long totalSeconds = elapsedTimeInMilliseconds / 1000;
        long days = totalSeconds / (60 * 60 * 24);
        long hours = (totalSeconds % (60 * 60 * 24)) / (60 * 60);
        long minutes = (totalSeconds % (60 * 60)) / 60;
        long seconds = totalSeconds % 60;
    
        StringBuilder formattedTime = new StringBuilder();
    
        if (days > 0) {
            formattedTime.append(days).append(" day");
            if (days > 1) {
                formattedTime.append("s");
            }
            formattedTime.append(" ");
        }
    
        if (hours > 0) {
            formattedTime.append(hours).append(" hr");
            if (hours > 1) {
                formattedTime.append("s");
            }
            formattedTime.append(" ");
        }
    
        if (minutes > 0) {
            formattedTime.append(minutes).append(" min");
            if (minutes > 1) {
                formattedTime.append("s");
            }
            formattedTime.append(" ");
        }
    
        if (seconds > 0 || formattedTime.length() == 0) {
            formattedTime.append(seconds).append(" sec");
            if (seconds != 1) {
                formattedTime.append("s");
            }
        }
    
        return formattedTime.toString().trim();
    }

    public long getElapsedTimeInMilliseconds() {
        return elapsedTimeInMilliseconds;
    }

    public long getElapsedTimeInSeconds() {
        return elapsedTimeInMilliseconds / 1000;
    }


    public long getElapsedTimeInMinutes() {
        return elapsedTimeInMilliseconds / (1000 * 60);
    }

    public void saveElapsedTime(String saveFileName) {
        try {
            FileWriter writer = new FileWriter(saveFileName);
            writer.write(Long.toString(elapsedTimeInMilliseconds));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadElapsedTime(String saveFileName) {
        try {
            Scanner scanner = new Scanner(new File(saveFileName));
            elapsedTimeInMilliseconds = Long.parseLong(scanner.nextLine());
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}