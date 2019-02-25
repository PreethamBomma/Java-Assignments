import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;
import java.util.logging.Logger;
public class PingAnyHost {
 private static Logger logger = Logger.getLogger("PingAnyHost log");
 /**
    Pings the given url "noOfPings" times

    @param urlToPing  
     the URL to be pinged

    @param noOfPings  
     no. of time the url should be pinged

    @throws IOException

*/
 public static void pingUrl(String urlToPing, int noOfPings) throws IOException {
  
  logger.info("Pinging " + urlToPing);
  Process process = Runtime.getRuntime().exec("ping -c" + noOfPings + " " + urlToPing);
  BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
  String output;
  int lastIndex = 0;
  Double timeToPing[] = new Double[noOfPings];
  int index = 0;
  while ((output = reader.readLine()) != null) {
   String time = "";
   //logger.info(output);
   if (output.contains("time=")) {
    lastIndex = output.lastIndexOf("=");
    for (int i = lastIndex + 1; i < lastIndex + 5; i++) {
     time += output.charAt(i);
    }
    timeToPing[index++] = Double.valueOf(time);
   }
  }
  Arrays.sort(timeToPing);
  if( noOfPings % 2 != 0)
  logger.info("Median " + timeToPing[noOfPings / 2]);
  else
  logger.info("Median "+ ((timeToPing[(noOfPings/2) - 1] + timeToPing[noOfPings/2])/2));
 } 

 public static void main(String[] args) throws Exception {
  logger.info("Enter URL and noOfPings");
  Scanner scanner = new Scanner(System.in);
  String urlToPing = scanner.next();
  int noOfPings = scanner.nextInt();
  pingUrl(urlToPing, noOfPings);
 }
}