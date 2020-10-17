package com.RMI.rmiInterface;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ServerOperation extends UnicastRemoteObject implements RMIInterface {

	private static final long serialVersionUID = 1L;

	protected ServerOperation() throws RemoteException {

		super();

	}

	@Override
	public String TextSearch(String name) throws RemoteException {
		String m = null;
		try {

			File f = new File("C:\\Users\\Duy\\eclipse-workspace\\lab3\\src\\com\\RMI\\rmiInterface\\lib.txt");
			FileReader fr = new FileReader(f);
			//
			BufferedReader br = new BufferedReader(fr);
			Scanner c = new Scanner(f, "UTF-8");
			while (c.hasNextLine()) {
				String line = c.nextLine();
				if (line.contentEquals(name)) {
					m = " has in library";
				}
			}
			if (m == null) {
				m = " hasn't in library";
			}
			c.close();
			fr.close();
			br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		System.err.println(name + " is trying to contact!");
		return "Book name :" + name + m;

	}

	public static void main(String[] args) {

		try {
			Naming.rebind("//localhost/MyServer", new ServerOperation());
			System.err.println("Server ready");
		} catch (Exception e) {

			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();

		}

	}

}