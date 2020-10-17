package com.RMI.rmiInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {

	public String TextSearch(String name) throws RemoteException;

}