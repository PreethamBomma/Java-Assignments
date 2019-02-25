import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.Map;
import java.util.TreeMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;

public class CharacterCounter {
 public static String fileContents;
 private static Logger logger = Logger.getLogger("CharacterCounter log");
 static final String outputFilePath = "output.txt";
 static Map < Character, Integer > map = new TreeMap < Character, Integer > ();

 /**
    Method to count occurrences of each character in a String

    @param eachLine read each line of file

    @return character occurrences as a Map

 */
 public static Map < Character, Integer > countCharacters(String lineOfFile) {
  //System.out.println("In method  "+ lineOfFile);
  fileContents = lineOfFile;
  for (int i = 0; i < fileContents.length(); i++) {
   Character character = fileContents.charAt(i);
   if (Character.isLetterOrDigit(character)) {
    if ((map.keySet().contains(character))) {
     int counter = map.get(character);
     map.put(character, ++counter);
    } 
    else {
     map.put(character, 1);
    }
   }
  }
  return map;
 }

 public static void main(String[] args) {

  String output = "";
  BufferedReader fileReader;
  try {
   if (args[0] == null) {
    logger.info("Usage: java CharacterCounter <filename>");
   } 
   else {
    try {
     fileReader = new BufferedReader(new FileReader(args[0].toString()));
     String line = fileReader.readLine();
     while (line != null) {
      output = countCharacters(line).toString();
      line = fileReader.readLine();
     }
    } 
    catch (IOException e) {
     logger.info("Cannot read file");
    }
   }
  } 
  catch (ArrayIndexOutOfBoundsException e) {
   logger.info("File to be read from is not given" + e.getMessage());
  }
  try (PrintStream out = new PrintStream(outputFilePath)) {
   out.append(output);
   out.flush();
  } 
  catch (IOException e) {
   logger.info("Cannot open output file " + e.getMessage());
  }
 }
}