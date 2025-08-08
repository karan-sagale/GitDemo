public class CoreJavaBrushUp3 {



	public static void main(String[] args) {

		// TODO Auto-generated method stub

		//string is an object 
		//String literal declaration syntax - This will not create new object if the string value is same for any 2 of the strings


        String s1 = "Happy new year";

		String s5 = "All the best";



		//String declaration using new keyword - This will CREATE new object irrespective to the value of the String defined

		String s2 = new String("Hello there");

		String s3 = new String("Welcome");



		String s = "Best of Luck";

		String[] splittedString = s.split(" ");

		System.out.println(splittedString[0]);

		System.out.println(splittedString[1]);

		System.out.println(splittedString[2].trim()); // trim is used for removed white spaces before and after the characters of the string

		// To print the String characters into reverse order
		System.out.println("\nReversed String is: \n");
		for(int i =s.length()-1;i>=0;i--)

		{

			System.out.println(s.charAt(i));  // charAt is used for iterating the characters present into the string

		}


	}



}



