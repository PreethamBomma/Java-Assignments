import java.io.*;
public class Ping {
  public static void main(String[] args) throws Exception {
      Process process = Runtime.getRuntime().exec("ping -c1 127.0.0.1");
    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    String output;
    while((output = reader.readLine()) != null) {
      if(output.contains("time")) {
        break;
      }
      else
        continue;
    }

    String[] words = output.split("=");
    System.out.println("Median time taken to ping: "+ words[3]);

  }
}
