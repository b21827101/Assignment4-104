import java.io.IOException;
import java.io.PrintWriter;

public class Writing{
	public static void main(String[] args) throws IOException {//writing output
		PrintWriter out= new PrintWriter("stackOut.txt");
		PrintWriter out1= new PrintWriter("queueOut.txt");

		for(int i=0;Test.outstacklist.size()>i;i++) {
			out.println(Test.outstacklist.get(i));//writing the stackOut.txt
		}
		out.close();
		for(int i=0;Test.outlist.size()>i;i++) {
			out1.println(Test.outlist.get(i));//writing the queueOut.txt
		}
		out1.close();
		PrintWriter writer = new PrintWriter("stack.txt");
        for(int i=0;Stack.stackarray.size()>i;i++) {//uploading the stack txt
        	writer.print(Stack.stackarray.get(i)+" ");
        }
         writer.close(); 
         
         PrintWriter writer1 = new PrintWriter("queue.txt");
         for(int i=0;Queue.queuearray.size()>i;i++) {//uploading the queue txt
         	writer1.print(Queue.queuearray.get(i)+" ");
         }
         writer1.close(); 
 		
	}
}