package lab4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class NumberClient {
	public static void main(String[] args) throws IOException {
		Socket mySocket = null;
		DataOutputStream dos = null;
		DataInputStream dis = null;
		try {
			mySocket = new Socket("localhost", 8888);
			dos = new DataOutputStream(mySocket.getOutputStream());
			dis = new DataInputStream(mySocket.getInputStream());
			Scanner input = new Scanner(System.in);
			String s = null;
			while (true) {
				System.out.println("\nNhập dữ liệu: ");
				s = input.nextLine();
				dos.writeUTF(s);
				String str = dis.readUTF();
				System.out.println("Kết quả từ Server: " + str);
			}
		} catch (Exception e) {
			System.out.println("Ngắt kết nối!");
			dis.close();
			dos.close();
			mySocket.close();
			e.printStackTrace();
		}
	}
}
