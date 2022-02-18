import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reading {

	public static ArrayList<Integer> numbersstack = new ArrayList<Integer>();
	public static ArrayList<Integer> queuearraylist = new ArrayList<Integer>();
	public static ArrayList<String> commandlist = new ArrayList<String>();

	public static void read(ArrayList<Integer> arraylist,ArrayList<Integer> arraylist1) {
		File inputFile = new File("stack.txt");
		File inputFile1 = new File("queue.txt");
		try{
			Scanner scanner = new Scanner(inputFile);
			while(scanner.hasNext()){
				String value = scanner.next();//converting from string to integer
				Integer num = Integer.parseInt(value);
				Stack.push(num,arraylist);
			}
			scanner.close();
			Scanner scanner1 = new Scanner(inputFile1);
			while(scanner1.hasNext()){
				String value1 = scanner1.next();
				Integer num1 = Integer.parseInt(value1);//converting from string to integer
				arraylist1.add(num1);
				
			}
			scanner1.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException{
    	
		try (BufferedReader br3 = new BufferedReader(new FileReader(Main.argument1 ))){//Main.argument1 "command.txt"
			String sCurrentLine;
        	while ((sCurrentLine = br3.readLine()) != null) {
            	commandlist.add(sCurrentLine);
            }
             br3.close();
             
        }catch (IOException e){
        	e.printStackTrace();

        }
		read(numbersstack,queuearraylist);
		for(Integer element:numbersstack) {
			Stack.push(element,Stack.stackarray);
		}
		for(Integer element:Reading.queuearraylist) {
			Queue.enqueue(element,Queue.queuearray);
		}
	}
	

} 


