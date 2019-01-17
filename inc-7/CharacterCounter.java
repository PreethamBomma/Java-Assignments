/*Using TextFile and a Map<Character,Integer>,
create a program that takes the file name as a command line argument and counts the occurrence
of all the different characters. Save the results in a text file.

*/
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;
import java.util.*;

public class CharacterCounter
{
  public static String fileContents;
  public static Map<Character,Integer> countCharacters(String filename)
  {
    try
      {
         fileContents = new String(Files.readAllBytes(Paths.get(filename)));
      }
      catch(IOException e)
      {
        e.printStackTrace();
      }
  Map<Character,Integer> map = new TreeMap<Character,Integer>();
  for(int i = 0; i < fileContents.length(); i++) {
    Character character = fileContents.charAt(i);
    if(Character.isLetter(character)) {
      if((map.keySet().contains(character))) {
        int counter=map.get(character);
        map.put(character,++counter);
      }
      else {
        map.put(character, 1);
        }
    }
  }
  return map;
}

public static void main(String[] args) {
  String output="";
  try
  {
    if(args[0]==null)
    {
      System.out.println("Usage: java CharacterCounter <filename>");
    }
    else
    {
       output=countCharacters(args[0]).toString();
      System.out.println(output);
    }
  }
  catch(ArrayIndexOutOfBoundsException e)
  {
      e.printStackTrace();
  }
//  catch(IOException e)
  //{
    //e.printStackTrace();
  //}
  try (PrintStream out = new PrintStream(new FileOutputStream("output.txt"))) {
    out.print(output);
    out.flush();
    out.close();
}
catch(FileNotFoundException e)
{

}
}
}
