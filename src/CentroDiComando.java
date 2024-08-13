/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author simon
 */

public class CentroDiComando extends UnicastRemoteObject implements CentroDiComandoInterface{
   static Scanner sc=new Scanner(System.in);
   static Connection conn;
   private static final long serialVersionUID = 1L;

   public CentroDiComando() throws RemoteException {
        super();
    }
   
   public static void main(String [] args) throws RemoteException, SQLException{
        System.out.println("Incominciamo a connetterci al db");
        System.out.println("Inserisci l'indirizzo del db");//127.0.0.1       
        String ind=sc.next();
        System.out.println("Inserisci la porta del db");//5432
        int porta=sc.nextInt();
        System.out.println("Inserisci il nome del db");//Meteo       
        String nome=sc.next();
        System.out.println("Inserisci l'utente del db");//postgres       
        String utente=sc.next();
        System.out.println("Inserisci la passWord del db");//admin       
        String pass=sc.next();
        String perConnessione="jdbc:postgresql://"+ind+":"+porta+"/"+nome;
        conn = DriverManager.getConnection(perConnessione,utente,pass);
        if (conn != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }
       CentroDiComando cd= new CentroDiComando();
       Registry reg=LocateRegistry.createRegistry(1090);
       reg.rebind("Server", cd);
       System.out.println("Server ready");
       
   }
    @Override
    public void controlloLogin(String nome,String pass) throws SQLException, RemoteException 
    {
        String sql="select email,password from OperatoriRegistrati where email=? and passWord=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, nome);
        preparedStatement.setString(2, pass);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String email = resultSet.getString("ID");
                String password = resultSet.getString("NAME");
            }
        }
    }
