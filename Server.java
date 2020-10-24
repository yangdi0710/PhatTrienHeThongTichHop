package lab4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws IOException {
		try {
			ServerSocket server = new ServerSocket(8887);
			System.out.println("Server đã được tạo!");
			Socket socket = server.accept();
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			Scanner scanner = new Scanner(System.in);
			while (true) {
				String str = dis.readUTF();
				
				if (str.equals("q")) {
					break;
				}	
				System.out.println("Client: " + str);
				String str2 = scanner.nextLine();
				dos.writeUTF(str2);
				dos.flush();
			}
			dos.close();
			dis.close();
			server.close();
			socket.close();

		} catch (Exception e) {

		}
	}
}