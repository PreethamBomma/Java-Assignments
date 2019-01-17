abstract class Rodent{
	abstract void eat();
	abstract void run();

}
class Mouse extends Rodent
{
	public Mouse()
	{
		System.out.println("\tMouse Constructor");
	}

        void eat()
	{
		System.out.println("Mouse is eating");
	}
	void run()
	{
		System.out.println("Mouse is running");
	}
}
class Gerbil extends Rodent
{

 	public Gerbil()
	{
		System.out.println("\tGerbil Constructor");
	}

	void eat()
	{
		System.out.println("Gerbil is eating");
	}
	void run()
	{
		System.out.println("Gerbil is running");
	}
}
class Hamster extends Rodent
{
 	public Hamster()
	{
		System.out.println("\tHamster Constructor");
	}

	void eat()
	{
		System.out.println("Hamster is eating");
	}
	void run()
	{
		System.out.println("Hamster is running");
	}
}
public class RodentsDemo
{
	public static void main(String args[])
	{
		Rodent[] rod = {
			//	new Rodent(),    //Have to outcomment this line because Rodent is an abstract class now
				new Mouse(),
				new Gerbil(),
				new Hamster()
		};
		for(Rodent i : rod){	//Calling base-class methods
			i.eat();
			i.run();
		}
		/*r[0] = new Mouse();
		r[0].eat();
		r[0].run();
		r[1] = new Gerbil();
		r[1].eat();
		r[1].run();
		r[2] = new Hamster();
		r[2].eat();
		r[2].run();
		r[0].run();
*/



/*
Rodent Base Constructor
Mouse
Rodent Base Constructor
Gerbil
Rodent Base Constructor
Hamster
Mouse is eating
Mouse is running
Gerbil is eating
Gerbil is running
Hamster is eating
Hamster is running
*/
	}
}
