package pt.ubi;

public interface ServerInterface extends java.rmi.Remote {

    public void reciveMessage(String s) throws java.rmi.RemoteException;

    public String getMessage() throws java.rmi.RemoteException;

    public void resetMessage() throws java.rmi.RemoteException;
}
