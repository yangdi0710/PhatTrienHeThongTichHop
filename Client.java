package lab4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {
		try {

			Socket socket = new Socket("LocalHost", 8887);
			System.out.println("Client đã được tạo!");
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			Scanner scanner = new Scanner(System.in);
			while (true) {
				String str = scanner.nextLine();
				dos.writeUTF(str);
				if (str.equals("q")) {
					break;
				}
				String str2 = dis.readUTF();
				System.out.println("Server: " + str2);
			}
			dis.close();
			dos.close();
			socket.close();
		} catch (Exception e) {
		}
	}
}