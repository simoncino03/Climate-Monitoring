/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

import javax.swing.JOptionPane;
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
    static LoginRegistrazione lr=new LoginRegistrazione();
    static PopUpOperatori po=new PopUpOperatori();
    public static void main(String[] args) throws RemoteException, NotBoundException {
        lr.setVisible(true);       
        Registry reg=LocateRegistry.getRegistry(1090);
        cd= (CentroDiComandoInterface) reg.lookup("Server"); 
    }
    
    public static void login(String nome, String pass) throws SQLException, RemoteException{
        boolean presente=cd.controlloLogin(nome, pass);
        if(presente)
        {
            lr.setVisible(false);
            po.modificaTesto("Login");
            po.setVisible(true);
            
        }else{
        JOptionPane.showMessageDialog(lr, "Utente non trovato,controlla le credenziali o registrati", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void ricercaUtente()
    {
        RicercaUtente ru=new RicercaUtente();
        ru.setVisible(true);
    }
    public static void registrazione(String centro,String nome,String cognome,String cf,String email,String password) throws SQLException, RemoteException
    {
        if(cd.controlloLogin(email, password))
        {
             JOptionPane.showMessageDialog(lr, "Utente già presente nel db", "Errore", JOptionPane.ERROR_MESSAGE);
        }else{
            if(cd.registrazione(centro, nome, cognome, cf, email, password)==1)
            {
                lr.setVisible(false);
                po.modificaTesto("Registrazione");
                po.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(lr, "Errore durante la registrazione", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    
}
