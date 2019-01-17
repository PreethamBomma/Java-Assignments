import java.util.*;
class CharacterCheck
{
         public static boolean checkPangram (String inputString)
           {
               // Create a hash table to mark the
               // characters present in the inputStringing
               // By default all the elements of
               // mark would be false.
               boolean[] characterMarker = new boolean[26];
               // For indexing in mark[]
               int index = 0;

               // Traverse all characters
               for (int i = 0; i < inputString.length(); i++)
               {
                   // If uppercase character, subtract 'A'
                   // to find index.
                   if ('A' <= inputString.charAt(i) && inputString.charAt(i) <= 'Z')

                       index = inputString.charAt(i) - 'A';

                       // If lowercase character, subtract 'a'
                       // to find index.
                   else if('a' <= inputString.charAt(i) &&
                               inputString.charAt(i) <= 'z')

                       index = inputString.charAt(i) - 'a';

                   // Mark current character
                   characterMarker[index] = true;
               }

               // Return false if any character is unmarked
               for (int i = 0; i <= 25; i++)
                   if (characterMarker[i] == false)
                       return (false);

               // If all characters were present
               return (true);
           }

           public static void main(String[] args)
           {
             Scanner scanner=new Scanner(System.in);
             System.out.println("Enter a inputStringing");
             String inputString = scanner.nextLine();
             if (checkAllChars(inputString) == true)
                   System.out.print(inputString + " contains all characters");
               else
                   System.out.print(inputString+ " does not contains all characters");
           }
       }
      /*  ArrayList<String> lowerAlphabetList=new ArrayList<String>();
        lowerAlphabetList.add(lowerAlphabet);

        ArrayList<String> upperAlphabetList=new ArrayList<String>();
        upperAlphabetList.add(upperAlphabet);

        char[] upperAlphabetArray= upperAlphabet.toCharArray();
        char[] lowerAlphabetArray= lowerAlphabet.toCharArray();
        for(char ch:lowerAlphabetArray)
        lowerAlphabetList.add(ch);

        for(char ch:upperAlphabetArray)
        upperAlphabetList.add(ch);

        Scanner scanner=new Scanner(System.in);
	      System.out.println("enter a inputStringing");
	      String input=scanner.nextLine();
        ArrayList<Character> inputList=new ArrayList<Character>();
        char[] inputArray=input.toCharArray();
        for(char ch1:inputArray)
        inputList.add(ch1);
        System.out.println("Contains all:  "+(inputList.containsAll(lowerAlphabetList)||inputList.containsAll(upperAlphabetList)));

    }
}


	//char[] inputArray=input.toArray();
*/
