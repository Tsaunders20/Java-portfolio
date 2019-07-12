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
		getFile(fileName);



	}
	private static String getFile(String input) throws FileNotFoundException, IOException {
		
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(input), StandardCharsets.UTF_8));) {

            String line;
            int check = 0;
            String[][] arr = new String[0][0];
            while ((line = br.readLine()) != null) {
                
                System.out.println(line);
                if(check == 0) {
                	int n = Integer.parseInt(line.substring(0, line.indexOf(" ")));
                	int m = Integer.parseInt(line.substring(line.indexOf(" ")+1, line.length()));
                	arr=new String[n][3];
                	
                	check = 1;
                }
                else {
                // In hindsight didn't need m but effectivelly what were doing is creating a multi-dimensional array
                // So we'll have roughly a array like [ [CHARACTERNAME,FRIENDS,ENEMIES] ,[...] ];

                
               
                	String Character1 = line.substring(0, line.indexOf(" "));
                	String Character2 = line.substring(line.lastIndexOf(" ")+1, line.length());
                	String status = line.substring(line.indexOf(" ")+1, line.indexOf(" ",line.indexOf(" ")+1));
                	System.out.println(Character1);
                	System.out.println(Character2);
                	System.out.println(status);
                	

                	boolean contains = Arrays.stream(arr).anyMatch(Character1::equals);
                	if(contains == false) {
                		for (int r=0; r<arr.length; r++) {
                			arr[r][0] = Character1;
                			System.out.println(arr[r][0]);
                		     if(status == "++") {
                		    	 arr[r][1] = "1";
                		    	 arr[r][2] = "0";
                		     }
                		     else {
                		    	 arr[r][1] = "0";
                		    	 arr[r][2] = "1";
                		     }
                		         
                		     
                		 }
                	
                	}
                	else {
                		System.out.println("in");
                		for (int i = 0; i < arr.length; i++) {
							if(arr[i][0] == Character1) {
								if(status == "++") {
									System.out.println(arr[i][1]);
	                		    	 arr[i][1] = Integer.toString(Integer.parseInt(arr[i][1])+1);
	                		    	 System.out.println(arr[i][1]);
	                		     }
	                		     else {
	                		    	 arr[i][2] = Integer.toString(Integer.parseInt(arr[i][2])+1);
	                		     }
								
							}
						}
                	
                	}
                	System.out.println(Arrays.toString(arr));
                }
                
                
            }
        }
		
		
		
		
		return "test";
	}

}
