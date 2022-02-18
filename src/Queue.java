import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Queue <T>{
	private static int top;
	private int capacity;
	private int size=100;
	public static ArrayList<Integer> queuearray = new ArrayList<Integer>();
  
    public Queue(int capacity)
    { 
    	queuearray = new ArrayList<Integer>(100);
    	capacity = size;
		top = -1;
    } 
    
    static int dequeue(Integer value,ArrayList<Integer> queuearray) {// Getting the last value from the list.
		int valueabs=Math.abs(value);
		int x = 0;
		while(valueabs!=0) {
	    	top=top-1;
			x=queuearray.remove(0);
			valueabs=valueabs-1;
		}
		return x;
	}
  
    static void enqueue(Integer element,ArrayList<Integer> queuearray) {//add an element x in the stack
    	//The only difference with the add method is that it doesn't add random
    	top=top+1;
    	queuearray.add(queuearray.size(),element);//queuearray.size()
	}
    

    static void add(Integer value,ArrayList<Integer> queuearray) {// for adding random number
		while(value!=0) {
	    	top=top+1;
			Random rand = new Random();
			int int1 = rand.nextInt(100);
			queuearray.add(size(queuearray),int1);//queuearray.size()
			value=value-1;
		}
	}
    
    public static Boolean isEmpty(ArrayList<Integer> queue){//check if the queue is empty or not
		return queue.size() == 0;
	}

	public Boolean isFull() {//check if the queue is full or not
		return top == capacity - 1;
	}
	
	public static ArrayList<Integer> removeGreater(int num, ArrayList<Integer> queue) {
		if (queue.isEmpty()) {
			return null;
        }
        ArrayList<Integer> sortedStack = new ArrayList<Integer>();//creating empty arraylist for appending element
        int element = 0;
        while(!queue.isEmpty()) {
        	if (num >= (element = dequeue(1,queue))){//removing num is greater than
        		enqueue(element ,sortedStack);
        	}
        }
        while(!isEmpty(queue)) {
			dequeue(1,queue);
		}
        for(Integer element1:sortedStack) {
        	enqueue(element1,queue);

		}
        return queuearray;
	}
	public static int peek(ArrayList<Integer> queuearray){
		if (!isEmpty(queuearray)) {
			return queuearray.get(0);//gets the zero index of arraylist
		}
		else {
			System.exit(1);
		}

		return -1;
	}
	
	
	static void reversequeue(ArrayList<Integer> head ) 
    { 
		ArrayList<Integer> queue = new ArrayList<Integer>(); 

        while (!isEmpty(head)) { 
            Stack.push(peek(head),queue); 
            dequeue(1,head); 
        } 
        while (!isEmpty(queue)) { 
            enqueue(Stack.peek(queue),head); 
            Stack.pop(1,queue); 
        }
    } 
  
	
	public static void main(int num) { 
		ArrayList<Integer> head = new ArrayList<Integer>(queuearray.subList(0, num));//sublisting of queuearray
        ArrayList<Integer> tail = new ArrayList<Integer>(queuearray.subList(num , queuearray.size()));
        reversequeue(head);//I have determined how long to reverse
		while(!isEmpty(queuearray)) {
			dequeue(1,queuearray);
		}
        while(!isEmpty(tail)) {
        	int i = dequeue(1,tail);
        	enqueue(i,head);
        }
        while(!isEmpty(head)) {
        	int i = dequeue(1,head);
        	enqueue(i,queuearray);
        }
	}
	
	
	public static int size(ArrayList<Integer> queue){
		return top + 1;
	}
	
	public static int calculateDistance(ArrayList<Integer> queue) {
		ArrayList<Integer> head = new ArrayList<Integer>();
		int sum=0;
		while(!isEmpty(queue)){
			int i=0;
			int top=peek(queue);//gets the zero index
			for(int j=i+1;j<size(queue);j++){//queue.size()
				sum+=Math.abs(queue.get(j) -top);
			}
			int x1=dequeue(1,queue);
			enqueue(x1,head);
		}
		while(!isEmpty(head)){
			int i=dequeue(1,head);
			enqueue(i,queuearray);
		}
		return sum;
	}		
	

	static void FrontToLast(ArrayList<Integer> q, int qsize) { 
		if (qsize <= 0) 
			return; 
		enqueue(peek(q),q);// Recursive call for pushing element 
		dequeue(1,q); 
		FrontToLast(q, qsize - 1); 
	} 

	static void pushInQueue(ArrayList<Integer> q, int temp, int qsize) { 
		if (q.isEmpty() || qsize == 0)  { 
			enqueue(temp,q); 
			return; 
		} 
		else if (temp <= peek(q)){ 
			enqueue(temp,q); 
			FrontToLast(q, qsize); 
		} 
		else { 
			enqueue(peek(q),q); 
			dequeue(1,q); 
			pushInQueue(q, temp, qsize - 1); 
		} 
	} 

	static void sortQueue(ArrayList<Integer> q) { 
		if (q.isEmpty()) 
			return; 
		int temp = peek(q);
		dequeue(1,q); 
		sortQueue(q); 
		pushInQueue(q, temp, q.size()); 
	} 
	
	static int distinct(ArrayList<Integer> queue) {
		Set<Integer> hashsetList = new HashSet<Integer>(queue);//hashset no duplicates
		return hashsetList.size();
	}

	public static String string1() {
		String s="";
		for(Integer element:queuearray) {
			s+=element+" ";
		}
		return s;
		
	}

}