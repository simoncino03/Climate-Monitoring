/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author simon
 */
public interface CentroDiComandoInterface extends Remote{
    public boolean controlloLogin(String nome,String pass) throws RemoteException,SQLException;
    public int registrazione(String centro,String nome,String cognome,String cf,String email,String password)throws RemoteException;
    public ArrayList<String> popolaCentri()throws RemoteException;
    public ArrayList<String> popolaAree()throws RemoteException;
}
