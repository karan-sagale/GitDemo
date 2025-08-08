public class CoreJavaBrushUp1 {



	public static void main(String[] args) {


		// Data types declaration syntax

		int myNum = 5;

		String website = "Core Java Brushup";

		char letter = 'J';

		double dec = 5.99;

		boolean myCard = true;


		// To Print the every declared value on the console (where + operator used for concatenation)

		System.out.println(myNum+" is the value stored in the myNum int variable");

		System.out.println(website+ " is the value stored in website String variable");

		System.out.println(letter+ " is the value stored in letter char variable");

		System.out.println(dec+ " is the value stored in dec double variable");

		System.out.println(myCard+ " is the value stored in myCard boolean variable");



		//*** Arrays Declaration syntax *** //

		// Syntax 1
		int[] arr = new int[5]; //Here 5 is the size of the array which can hold up to 5 integer values
		arr[0] = 1;

		arr[1] = 2;

		arr[2]= 4;

		arr[3]= 5;

		arr[4]= 6;



		// Syntax 2
		int[] arr2 = {1,2,4,5,6}; // Here all the required integer values can be given directly

		// To Print the values stored in the array by using index value from that array

		System.out.println("Value stored into 0th index of arr is: "+arr2[0]);
		System.out.println("Value stored into 1st index of arr is: "+arr2[1]);
		System.out.println("Value stored into 2nd index of arr is: "+arr2[2]);
		System.out.println("Value stored into 3rd index of arr is: "+arr2[3]);
		System.out.println("Value stored into 4th index of arr is: "+arr2[4]);

		// To Print the values stored in the array using For-Loop

		// Here arr.length is 5 (Size of the array)
		for(int i = 0; i< arr.length; i++) 

		{
			System.out.println("Values stored into arr are: "+arr[i]);

		}


		for (int i =0;i<arr2.length; i++)

		{

			System.out.println("Values stored into arr2 are: "+arr2[i]);

		}


		// Syntax 3 - For defining array of String data type
		String[] name = {"India", "US", "China"};



		for(int i =0; i<name.length;i++)

		{

			System.out.println("Values stored into the array (name) using normal For-loop are: "+name[i]);

		}


		// For-Each loop Syntax
		String[] name1 = {"Java", "Selenium", "Automation"};

		for( String s: name1)

		{

			System.out.println("Values stored into the array (name1) using For-Each loop syntax are: " +s);

		}

	}

}