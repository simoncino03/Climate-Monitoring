/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
/**
 *
 * @author simon
 */
public interface CentroDiComandoInterface extends Remote{
    public void controlloLogin(String nome,String pass) throws RemoteException,SQLException;
}
