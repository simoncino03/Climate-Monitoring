/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;
/**
 *
 * @author simon
 */
public class ClientCM {
    /**
     * @param args the command line arguments
     * 
     */
    static CentroDiComandoInterface cd;
    public static void main(String[] args) throws RemoteException, NotBoundException {
        LoginRegistrazione lr=new LoginRegistrazione();
        lr.setVisible(true);       
        Registry reg=LocateRegistry.getRegistry(1090);
        cd= (CentroDiComandoInterface) reg.lookup("Server"); 
    }
    
    public static void login(String nome, String pass) throws SQLException, RemoteException{
        cd.controlloLogin(nome, pass);
    }
    public static void ricercaUtente()
    {
        RicercaUtente ru=new RicercaUtente();
        ru.setVisible(true);
    }
    
    
}
