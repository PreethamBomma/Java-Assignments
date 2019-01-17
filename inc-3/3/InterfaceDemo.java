/*
Create three interfaces, each with two methods.
Inherit a new interface that combines the three, adding a new method.
Create a class by implementing the new interface and also inheriting from a concrete class.
Now write four methods, each of which takes one of the four interfaces as an argument.
In main( ), create an object of your class and pass it to each of the methods
*/
interface First{
    void firstMethod();
    void secondMethod();

}
interface Second{
    void thirdMethod();
    void fourthMethod();

}
interface Third{
    void fifthMethod();
    void sixthMethod();

}
interface  New extends First,Second,Third
{
  void testMethod();
}

class InterfaceTest
{
  private int integerVariable=0;
  
}
class InterfaceDemo extends InterfaceTest implements New{
  public void firstMethod() {}
  public void secondMethod() {}
  public void thirdMethod() {}
  public void fourthMethod() {}
  public void fifthMethod() {}
  public void sixthMethod() {}
  public void festMethod() {}
}
public class InterfaceMain
{
  public static void alpha(First first)
  {
    first.firstMethod();
  }
  public static void beta(Second second)
  {
    second.thirdMethod();
  }
  public static void gamma(Third third)
  {
    third.fifthMethod();
  }
  public static void delta(New newObj)
  {
    newObj.tesMethod();
  }
  public static void main(String[] ar)
  {
    InterfaceDemo interfaceDemo=new InterfaceDemo();
    alpha(interfaceDemo);
    beta(interfaceDemo);
    gamma(interfaceDemo);
    delta(interfaceDemo);

  }

}
