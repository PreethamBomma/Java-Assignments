import java.util.regex.*;
import java.util.Scanner;
public class Regex
{
  public static void main(String[] ar)
  {
    String s1 = "Testing for ending with period.";
    String s2 = "testing for beginning with capital letter and ending with period.";

    Pattern pattern=Pattern.compile("^[A-Z].*[\\.]$");
    String[] stringArray = new String[] {s1, s2};

		for(String s : stringArray) {
			System.out.print(s + "\nThis sentence begins with capital letter and ends with full stop: ");
			Matcher matcher=pattern.matcher(s);
			System.out.println(matcher.matches());
		}





  }


}
