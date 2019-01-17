class overload
{
	public overload()
	{
		System.out.println("Default Constructor");
		overload obj=new overload("kill");
	}
	public overload(String s)
	{
		String k=s;
		System.out.println("Hi! You passed "+k+" to overloaded constructor");
	}
	public static void main(String... ar)
	{
		overload ob=new overload();
	}
}

