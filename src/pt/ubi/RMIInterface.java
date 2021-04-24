/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.ubi;

/**
 *
 * @author turtl
 */
public interface RMIInterface extends java.rmi.Remote{
    public java.util.Date getDate() throws java.rmi.RemoteException;
    
}
