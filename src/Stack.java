import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Stack <T>{
	
	public static ArrayList<Integer> stackarray = new ArrayList<Integer>();
	int totalsum;
	private static int top;
	private int capacity;
	private int size=100;//size of stack arraylist

	Stack()
	{// Constructor to initialize stack
		stackarray = new ArrayList<Integer>(size);
		capacity = size;
		top = -1;
	}
	
	static void add(Integer value,ArrayList<Integer> stackarray) {// for adding random number
		while(value!=0) {
			top=top+1;
			Random rand = new Random();
			int int1 = rand.nextInt(100);
			stackarray.add(0,int1);
			value=value-1;
		}
	}
	
	static void push(Integer element,ArrayList<Integer> stackarray) {//The only difference with the add method is that it doesn't add random
		top=top+1;
		stackarray.add(0,element);
	}
	
	
	static int pop(Integer value,ArrayList<Integer> stackarray) {// Getting the last value from the list.
		int valueabs=Math.abs(value);//convert to absolute value.I wrote the Integer value to add as much as the value
		int x = 0;
		while(valueabs!=0) {
			top=top-1;
			x=stackarray.get(0);
			stackarray.remove(0);
			valueabs=valueabs-1;
		}
		return x;
	}
			
	public static Boolean isEmpty(ArrayList<Integer> stackarray){//check if the stack is empty or not
		return stackarray.size() == 0;//stackarray.size()
	}

	//check if the stack is full or not
	public Boolean isFull(){
		return top == capacity - 1;
	}
	
	public static int peek(ArrayList<Integer> stackarray){
		return stackarray.get(0);//gets the last one added
	}
	
	public static int size(){
		return top + 1;
	}
	
	public static ArrayList<Integer> removeGreater(int num, ArrayList<Integer> stack) {
		if (stack.isEmpty()) {
			return null;
        }
        ArrayList<Integer> sortedStack = new ArrayList<Integer>();//creating empty arraylist for appending element
        int element = 0;
        while(!stack.isEmpty()) {
        	if (num >= (element = pop(1,stack))){//removing num is greater than
        		push(element ,sortedStack);
        	}
        }
        while(!isEmpty(stack)) {
			pop(1,stack);
		}
        for(Integer element1 : sortedStack) {
        	push(element1,stack);
        }
        return stack;
	}	
	
	
	public static void reverse(ArrayList<Integer> stack) {
        if (isEmpty(stack)) {
            return;
        }
        int last = popBottom(stack);// Remove bottom element from stack
        reverse(stack);// Reverse everything else in stack
        push(last,stack);
    }

	public static int popBottom(ArrayList<Integer> stack) {
        Integer top = pop(1,stack);
        if (isEmpty(stack)) {
            return top;//If we removed the last element, return it
        } else {
            int last = popBottom(stack);
            push(top,stack);
            return last;
        }
    }
	
	public static ArrayList<Integer> main(int num) { 
		ArrayList<Integer> head = new ArrayList<Integer>(stackarray.subList(0, num));//sublisting of stackarray
        reverse(head);//I have determined how long to reverse
        while(!isEmpty(stackarray)) {
			pop(1,stackarray);
		}
        return head;


	}
	
	static int distinct(ArrayList<Integer> stack) {
		Set<Integer> hashsetList = new HashSet<Integer>(stack);//hashset no duplicates
		return hashsetList.size();
	}
	
	
	
	public static int calculateDistance(ArrayList<Integer> stack) {
		ArrayList<Integer> head = new ArrayList<Integer>();
		int sum=0;
		while(!isEmpty(stack)){
			int i=0;
			int top=peek(stack);//gets the last one added
			for(int j=i+1;j<stack.size();j++){
				sum+=Math.abs(stack.get(j) -top);
			}
			int x1=pop(1,stackarray);
			push(x1,head);//appending all elements in arraylist
		}
		for(Integer element:head) {
			push(element,stackarray);
		}
		
		return sum;
		
	}		
	
 
	public static ArrayList<Integer> sortstack(ArrayList<Integer> input) { 
		ArrayList<Integer> tmpStack = new ArrayList<Integer>(); 

		while(!isEmpty(input)){ 
			int tmp = pop(1,input);// pop out the first element 

			while(!tmpStack.isEmpty() && peek(tmpStack)< tmp) { // pop from temporary stack and push it to the input stack 
				push(pop(1,tmpStack),input); 
			} 
			push(tmp,tmpStack); 
		} 

		return tmpStack; 
	} 
	
	public static String string1(ArrayList<Integer> x) {
		String s="";
		for(Integer element:x) {
			s+=element+" ";
		}
		return s;
		
	}
}


