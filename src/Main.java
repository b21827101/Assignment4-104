import java.io.IOException;

public class Main {
	public static String argument1;

	public static void main(String[] args) throws IOException {
		String argument2=args[0];//First argument command.txt
		argument1=argument2;
		Reading.main(args);
		Test.main(args);
		Writing.main(args);
	}

}
