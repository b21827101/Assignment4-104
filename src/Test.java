import java.util.ArrayList;

public class Test{
	public static ArrayList<String> outlist = new ArrayList<String>();
	public static ArrayList<String> outstacklist = new ArrayList<String>();


	public static void main(String[] args) {
		
	    @SuppressWarnings("unchecked")
		ArrayList<String> al2 = (ArrayList<String>)Reading.commandlist.clone();
	
	    for(int i=0;al2.size()>i;i++) {
	
	    	if(al2.get(i).contains("S")){//Calling methods according to input file
	    		if(al2.get(i).contains("removeGreater")) {
	    	    	String wordA1 = al2.get(i).split(" ")[2];
	    			int num=Integer.valueOf(wordA1);
	    			outstacklist.add("After removeGreater "+num+":");
	    			Stack.removeGreater(num, Stack.stackarray);;
	    			outstacklist.add(Stack.string1(Stack.stackarray));
	    		}
	    		
	    		else if(al2.get(i).contains("calculateDistance")) {
	    			outstacklist.add("After calculateDistance:");
	    			outstacklist.add("Total distance="+Stack.calculateDistance(Stack.stackarray));

	    		}
	    		else if(al2.get(i).contains("addOrRemove")) {
	    	    	String wordA1 = al2.get(i).split(" ")[2];//splitting and get the second index from this line
	    			int num=Integer.valueOf(wordA1);
	    			outstacklist.add("After addOrRemove "+num+":");
	    			if(num>0) {
	    				Stack.add(num,Stack.stackarray);
		    			outstacklist.add(Stack.string1(Stack.stackarray));
	    			}
	    			else{
	    				int x=Math.abs(num);
	    				Stack.pop(x,Stack.stackarray);
		    			outstacklist.add(Stack.string1(Stack.stackarray));

	    			}
	    		}
	    		else if(al2.get(i).contains("sortElements")) {
	    			outstacklist.add("After sortElements:");
	    			ArrayList<Integer> x=Stack.sortstack(Stack.stackarray);
	    			Stack.stackarray.addAll(x);
	    			outstacklist.add(Stack.string1(Stack.stackarray));
	    		}
	    		else if(al2.get(i).contains("distinctElements")) {
	    			Stack.distinct(Stack.stackarray);
	    			outstacklist.add("After distinctElements:");
	    			outstacklist.add("Total distinct element="+Stack.distinct(Stack.stackarray));

	    		}
	    		else if(al2.get(i).contains("reverse")) {
	    	    	String wordA1 = al2.get(i).split(" ")[2];
	    			outstacklist.add("After reverse "+wordA1+":");
	    			int num=Integer.valueOf(wordA1);
	    	        ArrayList<Integer> tail = new ArrayList<Integer>(Stack.stackarray.subList(num,Stack.stackarray.size()));
	    			ArrayList<Integer> x=Stack.main(num);
	    			Stack.stackarray.addAll(x);
	    			Stack.stackarray.addAll(tail);
	    			outstacklist.add(Stack.string1(Stack.stackarray));

	    		}
	    	}
		
		
	    	else if(al2.get(i).contains("Q")){//Calling methods according to input file
	    		if(al2.get(i).contains("removeGreater")) {
	    			String wordA1 = al2.get(i).split(" ")[2];
	    			int num=Integer.valueOf(wordA1);
	    			outlist.add("After removeGreater "+num+":");
	    			Queue.removeGreater(num, Queue.queuearray);
	    			outlist.add(Queue.string1());

	    		}
	    		else if(al2.get(i).contains("calculateDistance")) {
	    			outlist.add("After calculateDistance:");
	    			outlist.add("Total distance="+Queue.calculateDistance(Queue.queuearray));
	    		}
	    		else if(al2.get(i).contains("addOrRemove")) {
	    			String wordA1 = al2.get(i).split(" ")[2];//splitting and get the second index from this line
	    			int num=Integer.valueOf(wordA1);	    
	    			outlist.add("After addOrRemove "+num+":");
	    			if(num>0) {
	    				Queue.enqueue(num,Queue.queuearray);
		    			outlist.add(Queue.string1());

	    			}
	    			else{
	    				int x=Math.abs(num);
	    				Queue.dequeue(x,Queue.queuearray);
		    			outlist.add(Queue.string1());

	    			}
	    		}
	    		else if(al2.get(i).contains("sortElements")) {
	    			Queue.sortQueue(Queue.queuearray);
	    			outlist.add("After sortElements:");
	    			outlist.add(Queue.string1());
	    		}
	    		else if(al2.get(i).contains("reverse")) 
	    		{
	    			String wordA1 = al2.get(i).split(" ")[2];//splitting and get the second index from this line
	    			outlist.add("After reverse "+wordA1+":");
	    			int num=Integer.valueOf(wordA1);	    
	    			Queue.main(num);
	    			outlist.add(Queue.string1());
	    		}
	    		
	    		else if(al2.get(i).contains("distinctElements")) {
	    			outlist.add("After distinctElements:");
	    			outlist.add("Total distinct element="+Queue.distinct(Queue.queuearray));

	    		}
			
	    	}
	    }
	}
}
		
		

	