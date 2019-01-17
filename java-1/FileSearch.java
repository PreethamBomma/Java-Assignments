import java.util.regex.*;
import java.util.Scanner.*;
import java.io.File;
import java.util.*;
class FileSearch {
	public static String regex;
	static String entries[] ;
	/*
	  A HashMap with fileName as key and the absolutePath of the file as value
	*/
	static Map<String, String> filePaths = new HashMap<String, String>();

	public static File[] filesList;
	/*
		@param REGEX
		takes the regular expression as input and then matches the filenames against the regular expression.
	 */
	public static void searchFile(String pregex) {

		String regex = pregex;
		//System.out.println("In searchFile   "+regex);
		String result = "";
		Pattern pattern = Pattern.compile(regex);

		// Logic to enumerate the HashMap
		Iterator iterator = filePaths.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry pair = (Map.Entry) iterator.next();
			//String fNmae=pair.getKey();
			//System.out.println(pair.getKey().toString());
			Matcher matcher = pattern.matcher(pair.getKey().toString());

			//matcher.find() checks the returns true or false
			if (matcher.find())
				System.out.println("Found file at " + pair.getValue());


		}

	}


		public static int traverse( File file ) {
			filesList = file.listFiles();
			// Check if it is a directory
			if(filesList!=null) {
				for (File afile : filesList) {


					if (afile.isDirectory()) {
						//System.out.println("Directory " + afile.getPath());
						traverse(afile);
					}
					else {
						//System.out.println("File " + afile.getName());
						filePaths.put(afile.getName(), afile.getPath());
					}
				}
			}
			return 1;
		}



	public static void main (String a[]) {
	
		//getenv() method is used to access environment variables
		File file = new File(System.getenv("HOME"));
		System.out.println("Indexing files");
		traverse(file);
		//System.out.println(Arrays.asList(filePaths));
		//System.out.println("End of traversal");
		while (true) {
			System.out.println("Enter a Regular Expression\nEnter exit to terminate");
			Scanner scanner = new Scanner(System.in);
			regex = scanner.nextLine();
			String absolutePath = "";
			if (regex.equals("exit")) {
				System.exit(0);
			}
			else
			searchFile(regex);
			//System.out.println(absolutePath);
		}
	}

}


