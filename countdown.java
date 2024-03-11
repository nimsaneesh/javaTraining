/**
 * 
 */
package java_demo;


//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.TimeUnit;
// 
//public class countdown {
//    public static void main(String[] args) {
//        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
//        executor.scheduleAtFixedRate(() -> loopFunction(), 0, 3, TimeUnit.SECONDS); // Run the loop function with a initial delay of 0 seconds and then every 3 seconds
//        try {
//            Thread.sleep(30000); // Wait for 30 seconds
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        executor.shutdown(); // Shutdown the executor after 30 seconds
//    }
// 
//    public static void loopFunction() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = new Date();
//        System.out.println("Current date and time: " + sdf.format(date)); // Display current date and time in IST
//    }
//}
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class countdown {
    private static final String FILE_PATH = "data.txt";

    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            appendAndReadData();
        }, 0, 3, TimeUnit.SECONDS); // Run the appendAndReadData function with an initial delay of 0 seconds and then every 3 seconds
        try {
            Thread.sleep(30000); // Wait for 30 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown(); // Shutdown the executor after 30 seconds
    }

    public static void appendAndReadData() {
        File file = new File(FILE_PATH);
        try (FileWriter writer = new FileWriter(file, true);
             BufferedWriter bw = new BufferedWriter(writer);
             BufferedReader reader = new BufferedReader(new FileReader(file))) {

            if (!file.exists()) {
                System.out.println("File does not exist. Creating new file.");
                file.createNewFile();
            }

            // Append data
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String data = "Current date and time: " + sdf.format(date) + "\n";
            bw.write(data);
            bw.flush();

            // Read data
            System.out.println("Contents of " + FILE_PATH + ":");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
