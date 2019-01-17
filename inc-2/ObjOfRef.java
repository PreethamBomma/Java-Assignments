class ObjOfRef
{
	/*public ObjOfRef()
	{
		System.out.println("Default Constructor");
		ObjOfRef obj=new ObjOfRef("kill");
	}*/

	public ObjOfRef(String s)
	{
		String k=s;
		System.out.println(k);
	}
	public static void main(String... ar)
	{
		ObjOfRef ob=new ObjOfRef("Test");
		ObjOfRef[] arr=new ObjOfRef[2];
		arr[1]=new ObjOfRef("Second Reference");
		arr[0]=new ObjOfRef("First reference");
	}
}

