// Class with main block

public class MethodsDemo {


	public static void main(String[] args) {


       // To create object of the current class (MethodsDemo)
		MethodsDemo d = new MethodsDemo();
		
       // To store the value returned by getData method (Custom method outside main block but within same class)
		String name = d.getData();

	   // To print the value returned by getData method 	
		System.out.println(name);
				
       // To create object of the another class (MethodsDemo2)
		MethodsDemo2 d1 = new MethodsDemo2();
       
	   // To get the value of returned by method defined into that another class (method defined into MethodsDemo2 class)
		d1.getUserData();

	   // To print the value returned by static method of the current class (Custom method with static keyword outside main block but within same class- MethodsDemo)
		getData2();

	}

//Custom public method outside main block but within same class
	public String getData()

	{

		System.out.println ("Welcome to India...");

		return "Have Funnn";

	}


// Custom method with static keyword outside main block but within same class
	public static String getData2()

	{

		System.out.println ("Welcome to Mumbai- City of dreams");

		return "HappyJourney";

	}



}