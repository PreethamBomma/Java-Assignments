import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class GruberHealthcareKYC {
    static String result="";
    public static void main(String[] args)
    {
       Scanner scanner = new Scanner(System.in);
       int noOfInputs = scanner.nextInt();
       for(int i = 0;i < noOfInputs;i++)
        {
          String signUpDate = scanner.next();
          String currentDate = scanner.next();
          getDateRange(signUpDate,currentDate);
        }
       System.out.println(result); //printing out final result
    }
    /**
     * Method used to get the KYC window range given sign up date and current date
     *
     * @param signUpDate
     *        sign up date for KYC by the customer
     *
     * @param currentDate
     *        current date
     */
    public static void getDateRange(String signUpDate,String currentDate)
    {

        LocalDate signUpLocalDate = LocalDate.now();
        LocalDate currentLocalDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try
         {
          signUpLocalDate = LocalDate.parse(signUpDate,formatter);
          currentLocalDate = LocalDate.parse(currentDate,formatter);
         }
        catch(DateTimeParseException e)
         {
          System.out.println("Enter date of format dd-MM-yyyy\n example : 14-03-1998"+"\n");
         }
        if ( signUpLocalDate.isAfter( currentLocalDate ) )
         {
          result+="No Range"+"\n";
          return ;
         }
        LocalDate anniversaryDate = signUpLocalDate.plusYears(currentLocalDate.getYear()-signUpLocalDate.getYear());
        LocalDate lowerKYCRange = anniversaryDate.minusDays(30);
        LocalDate higherKYCRange = anniversaryDate.plusDays(30);
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        if (anniversaryDate.plusDays(30).isAfter(currentLocalDate))
         {
          result = result + formatter.format(lowerKYCRange) + " " +formatter.format(currentLocalDate)+"\n";
         }
         else if ( lowerKYCRange.getMonth().equals(currentLocalDate.getMonth()))
         {
           if( lowerKYCRange.getDayOfMonth() >= currentLocalDate.getDayOfMonth())
              result = result + formatter.format(lowerKYCRange) + " " + formatter.format(higherKYCRange)+"\n";
           else
              result = result + formatter.format(lowerKYCRange) + " " + formatter.format(currentLocalDate)+"\n";
         }
         else if (higherKYCRange.getMonth().equals(currentLocalDate.getDayOfMonth()))
         {
           if(higherKYCRange.getDayOfMonth() < currentLocalDate.getDayOfMonth())
              result = result +formatter.format(lowerKYCRange) + " " + formatter.format(higherKYCRange)+"\n";

           else
              result = result +formatter.format(lowerKYCRange) + " " + formatter.format(currentLocalDate)+"\n";

         }
         else if(anniversaryDate.getMonth().equals(currentLocalDate.getMonth()))
           result = result + formatter.format(lowerKYCRange) + " " + formatter.format(currentLocalDate)+"\n";
         else
           result = result + formatter.format(lowerKYCRange) +" "+ formatter.format(higherKYCRange)+"\n";
           return;



}

    }
