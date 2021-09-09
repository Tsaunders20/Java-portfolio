import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;



public class main {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// The overall objective is to assess balance in a friendship graph, the concepts a little weird but easy when you figure it out
		// Each character should have x number of friends and y number of enemies all consistant with one another
		// We have two other inputs N and M which are the number of characters and the number of lines respectivelly.
		// If x and y are consistant we say balanced as our output, otherwise we don't
		
		
		
		
		
		
		String fileName = "Unittest";
		System.out.println(getFile(fileName));
		
		fileName = "Unittestfail";
		System.out.println(getFile(fileName));
		
		fileName = "biggot";
		System.out.println(getFile(fileName));
		
		


	}
	private static String getFile(String input) throws FileNotFoundException, IOException {
		
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(input), StandardCharsets.UTF_8));) {

            String line;
            int check = 0;
            String[][] arr = new String[0][0];
            int iter = 0;
            int n=0;
            while ((line = br.readLine()) != null) { // Effectively going over m lines
                
                if(check == 0) {
                	n = Integer.parseInt(line.substring(0, line.indexOf(" ")));
                	int m = Integer.parseInt(line.substring(line.indexOf(" ")+1, line.length()));
                	arr=new String[n][3];
                	
                	check = 1;
                }
                else {
                // In hindsight didn't need m but effectively what were doing is creating a multi-dimensional array
                // So we'll have roughly a array like [ [CHARACTERNAME,FRIENDS,ENEMIES] ,[...] ];

                String status = "--";
                	if(line.indexOf("++")!=-1) {
                		//Originally had a bunch of substrings using the spaces
                		//But characters with spaces were messing everything up
                		status = "++";
                	}
                	String Character1 = line.substring(0, line.indexOf(status)-1);
                	String Character2 = line.substring(line.lastIndexOf(status)+3, line.length());
                //	String status = line.substring(line.indexOf(" ")+1, line.indexOf(" ",line.indexOf(" ")+1));
                	

					int contains = doesexist(arr,Character1,arr.length);
                	if(contains == -1) {
                		arr[iter][0] = Character1;
                		if(status.equals("++")) {
                		arr[iter][1] = "1";
                		arr[iter][2] = "0";
                		}
                		else {
                			arr[iter][1] = "0";
                		arr[iter][2] = "1";
                		}
                		iter++;
                	
                	}
                	else {
                		if(status.equals("++")) {
           		    	 arr[contains][1] = Integer.toString(
           		    			 Integer.parseInt(arr[contains][1])+1
           		    			 );
	           		     }
	           		     else {
	           		    	 arr[contains][2] = Integer.toString(
	           		    			 Integer.parseInt(arr[contains][2])+1);
	           		     }

                		
                		
                	}
                	
                	contains = doesexist(arr,Character2,arr.length);
                	if(contains == -1) {
                		arr[iter][0] = Character2;
                		if(status.equals("++")) {
                		arr[iter][1] = "1";
                		arr[iter][2] = "0";
                		}
                		else {
                			arr[iter][1] = "0";
                		arr[iter][2] = "1";
                		}
                		iter++;
                	
                	}
                	else {
                		if(status.equals("++")) {
           		    	 arr[contains][1] = Integer.toString(
           		    			 Integer.parseInt(arr[contains][1])+1
           		    			 );
	           		     }
	           		     else {
	           		    	 arr[contains][2] = Integer.toString(
	           		    			 Integer.parseInt(arr[contains][2])+1);
	           		     }

                		
                		
                	}
                	
                	
                	
                	
                	
                	
                }
            }
            int friendcount = Integer.parseInt(arr[0][1]);
            int enemycount = Integer.parseInt(arr[0][2]);
            for(int y=0;y<n;y++) {
    		//System.out.println(arr[y][0] + ", " + arr[y][1] + ", " + arr[y][2]);
            	//For debug, outputs the table itself in our variable format
            	/* 
            	 * Superman, 2, 3
					Green Lantern, 2, 3
					Wonder Woman, 2, 3
					Sinestro, 2, 3
					Cheetah, 2, 3
					Lex Luthor, 2, 3
            	 */
    		if(Integer.parseInt(arr[y][1]) != friendcount || Integer.parseInt(arr[y][2]) != enemycount) {
    			return "Not Balanced";
    			
    		}
            }
            return "balanced";
        }
		
		
		
	}
	private static int doesexist(String [][]arr,String Character,int length) {
		// Originally did a boolean for this, but realised i could just give myself the index for later and make it easier
		for(int i=0;i<length;i++) {
			if(Character.equals(arr[i][0])) {
				return i;
			}
		}
		return -1;
	}

}
