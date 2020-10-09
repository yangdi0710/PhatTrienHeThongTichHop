package IPAddress;

import java.net.*;

public class PhanLoaiDCIP {
	public static void main(String[] args) {
		try {
			if (args.length != 1) {
				System.out.println("Cach su dung: Java TimDCIP <Hostname>");
			}
			InetAddress host = InetAddress.getByName("iuh.edu.vn");
			String hostName = host.getHostName();
			System.out.println("Host name:" + hostName);
			System.out.println("Dia chi IP:" + host.getHostAddress());
			byte[] b = host.getAddress();
			int i = b[0] >= 0 ? b[0] : 256 + b[0];
			if ((i >= 1) & (i <= 126))
				System.out.println(host + " thuoc dia chi lop A");
			if ((i <= 191) & (i >= 128))
				System.out.println(host + " thuoc dia chi lop B");
			if ((i <= 223) & (i >= 192))
				System.out.println(host + " thuoc dia chi lop C");
		} catch (UnknownHostException e) {
			System.out.println("Khong tim thay dia chi");
			return;
		}
	}
}