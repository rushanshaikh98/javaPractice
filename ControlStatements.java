class A{
	public static void main(String args[]){
		System.out.print("-------------------- If elseif else! ---------------------\n");
		int x = 25;
		if (x<10){
			System.out.println("Number is less than 10!");
		}
		else if (x<20){
			System.out.println("Number is less than 20 but greater than 10!");
		}
		else{
			System.out.println("Number is greater than or equal to 20!");	
		}
		
		System.out.print("-------------------- for Loop! ---------------------\n");
		for (int i=1; i<10; i++){
			System.out.println(i);
		}
		
		System.out.print("-------------------- do while loop! ---------------------\n");		
		int j = 10;
		do {
			System.out.println(j);
			j-=1;
		}
		while(j>0);
		
		System.out.print("-------------------- while loop! ---------------------\n");
		
		int p = 45;
		while (p<50){
			System.out.println(p);
			p+=1;
		}
		
		
		System.out.print("-------------------- Switch! ---------------------\n");
		int day = 1;
		
		switch (day){
			case 1:
				System.out.println("Monday");
				break;
			case 2:
				System.out.println("Tuesday");
				break;
			case 3:
				System.out.println("Wednesday");
				break;
			case 4:
				System.out.println("Thursday");
				break;
			case 5:
				System.out.println("Friday");
				break;
			case 6:
				System.out.println("Saturday");
				break;
			case 7:
				System.out.println("Sunday");
				break;
			default:
				System.out.println("Invalid");
				break;
		}
		
		String[] cars = {"Volvo", "Lexus", "Ford"};
		cars[0] = "Mercedes";
		System.out.println(cars[0]);
		System.out.println(cars.length);
		
		for (int i=0; i<cars.length; i++){
			System.out.println(cars[i]);
		}
		
		for (String i: cars){
			System.out.println(i);
		}
		
		
		int[][] nums = { {1, 2, 3, 4}, {5, 6, 7} };
		System.out.println(nums[0][0]);
		System.out.println(nums[0].length);
		
		for (int r=0; r<nums.length; r++){
			for (int s=0; s<nums[r].length; s++){
				System.out.println(nums[r][s]);
			}
		}
		
	}
}
