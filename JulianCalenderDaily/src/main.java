
public class main {
	
	/* I used a few exercises as the basis for this coding exercise.
	 * 
	 * 
	 * The goal is to find between two inputs the number of leap years between two dates under the revised gregorian calender.
	 * 
	 * The Revised Julian Calendar is a calendar system very similar to the familiar Gregorian Calendar, but slightly more accurate in terms of average year length. The Revised Julian Calendar has a leap day on Feb 29th of leap years as follows:

    Years that are evenly divisible by 4 are leap years.
    Exception: Years that are evenly divisible by 100 are not leap years.
    Exception to the exception: Years for which the remainder when divided by 900 is either 200 or 600 are leap years.

	For instance, 2000 is an exception to the exception: the remainder when dividing 2000 by 900 is 200. So 2000 is a leap year in the Revised Julian Calendar.
	 
	 *
	 *
	 *
	 *
	 * The second exercise is to find the first day (in the future) in which the revised gregorian calender and the used original one
	 * would have their two leap years correspond and would both have february 29th on the same day
	 *
	 *
	 *
	 */
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long input1 = 123456789101112L;
		long input2 = 1314151617181920L;
		if(input1 > input2) {
		System.out.println(leaps(input2, input1));
		System.out.println("The gregorian calender will match up in the year: " + bonus());
		}
		else {
			System.out.println(leaps(input1, input2));
			System.out.println("The gregorian calender will match up in the year: " + bonus());
		}
		}
		//Java was automatically putting larger numbers as ints without an 'L' on the end, needed for numbers too large for ints
	
	
	private static long leaps(long firstyear,long secondyear) {
		
		// Looping over each year would take up way too much processing power.
		// Easiest way is to simply work out each special case mathematically
		// We can then add to the total where the case would result in the leap year
		// And subtract where they'd be an exception to this rule since 100 is divisable by 4 anyway
		secondyear-=1;
		//Last of second year doesn't count in this exercise
		long fours = (secondyear / 4) - (firstyear / 4);
		long hundred = (secondyear / 100) - (firstyear / 100);
		long ninehundreds = ((secondyear - 200)/900) - ((firstyear - 200)/900);
				//Took me a while on this one, but realised its all offset by 200
				// So in order 1100,2000,2900 and so on..
				//If we bring these down by 200 we get them directly divisable by 900 which is exactly what we want
		long ninehundreds2 = ((secondyear - 600)/900) - ((firstyear - 600)/900);
		//Same tactic works here
		// 1500,2400,3300
		

				
		return fours - hundred + ninehundreds + ninehundreds2;
		//So as per original fours are the baseline
		// The hundreds are an exception to this rule and aren't added, so those are immediatly nullified.
		//With exceptions for the remaining two
	}
	private static long bonus() {
	//The gregorian calender started in 1582, to figure out the distance between the two we need to start from here.
	// The first leap year was 1584 under this
		long secondyear = 2019;
		
		
		/* This code isn't actually important, however I used it to figure out where I was going originally when doing this part.
		
		
		
		long other = leaps(1582L, secondyear);
		
		long fours = (secondyear / 4) - (1582L / 4);
		long hundred = (secondyear / 100) - (1582L / 100);
		long fourhundred = (secondyear / 100) - (1582L / 100);
		
		long gregoriantotal = fours - hundred + fourhundred;
		
		long difference = gregoriantotal - other;
		//This has gotten us the total difference in days between the gregorian calender and it's modified version
		//So now we just need them to sync up back to 366 days with all conditions correct
		// The standard gregorian calender has a few more days advantage
		
		
		
		*/
		
		
		
		
		
		
		
		
		
		
		// Since the difference lies in the exception to the exception we can work every 200 years
		//Since were working from the beginning we can also hard code a start of 1600 as the first year that was divisible by 200 since the start
		long year = 1600;
		int check = 0;
		int countgreg = 0;
		int countrev = 0;
		while(check == 0) {
			if(year % 400 == 0) {
				
				countgreg++;
			}
			//Since were only interested in the bonus' compared to each other no point bothering with exceptions or every 4 years
			if(year % 900 == 200 || year % 900 == 600) {
				countrev++;
				
			}
			if(countgreg - countrev == 366) {
				
				check = 1;
			}
			else {
		year+=200;
			}
		}
		return year;
	}
	}


