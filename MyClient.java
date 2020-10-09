package IPAddress;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {
	public static void main(String[] args) {
		try {
			Socket client = new Socket("LocalHost", 9540);
			System.out.println("Client da duoc tao");
			Scanner inFromServer = new Scanner(client.getInputStream());
			PrintStream outToServer = new PrintStream(client.getOutputStream());
			System.out.println("server: " + inFromServer.nextLine());
			Scanner scan = new Scanner(System.in);
			String ten = scan.nextLine();
			outToServer.println(ten);
			System.out.println("server: " + inFromServer.nextLine());
		} catch (UnknownHostException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}