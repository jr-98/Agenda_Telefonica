/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Persona;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class Enlace {

    private static final String url = "jdbc:derby://localhost:1527//Agenda_Telefonica";
    private static final String usuario = "Administrador";
    private static final String clave = "admin";
    private Connection conexion = null; // manages connection
    private PreparedStatement seleccionaTodos = null;
    private PreparedStatement seleccionaPorApellido = null;
    private PreparedStatement insertarPersona = null;

    public Enlace() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            System.out.println("Cargando Driver JavaDB");
        } catch (ClassNotFoundException es) {
            System.out.println("Error, no se encuentra la clase 'org.apache.derby.jdbc.ClinentDriver'"+es);
        }
        try {
            conexion = DriverManager.getConnection(url, usuario, clave);
            seleccionaTodos = conexion.prepareStatement("SELECT* FROM AGENDA");
            seleccionaPorApellido = conexion.prepareStatement("SELECT* FROM AGENDA where APELLIDO=?");
            insertarPersona = conexion.prepareStatement("INSERT into AGENDA"
                    + "( NOMBRE, APELLIDO, CORREO, TELEFONO) "
                    + "VALUES ( ?, ?, ?, ? )");
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
            System.exit(1);
        } // end catch
        // end PersonQueries constructor
        // select all of the addresses in the database
    }

    public List<Persona> obtenerTodasPersonas() {
        List< Persona> results = null;
        ResultSet resultSet = null;
        try {
            // executeQuery returns ResultSet containing matching entries
            resultSet = seleccionaTodos.executeQuery();
            results = new ArrayList<Persona>();
            while (resultSet.next()) {
                results.add(new Persona(
                        resultSet.getInt("ID"),
                        resultSet.getString("NOMBRE"),
                        resultSet.getString("APELLIDO"),
                        resultSet.getString("CORREO"),
                        resultSet.getString("TELEFONO")));//mayus
            } // end while
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } // end catch
        finally {
            try {
                resultSet.close();
            } // end try
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            } // end catch
        } // end finally
        return results;
    } // end method getAllPeople
// select person by last name

    public List<Persona> obtenerPersonasPorApellido(String nombre) {
        List< Persona> results = null;
        ResultSet resultSet = null;
        try {
            seleccionaPorApellido.setString(1, nombre); // specify last name
// executeQuery returns ResultSet containing matching entries
            resultSet = seleccionaPorApellido.executeQuery();
            results = new ArrayList<Persona>();
            while (resultSet.next()) {
                results.add(new Persona(resultSet.getInt("ID"),
                        resultSet.getString("NOMBRE"),
                        resultSet.getString("APELLIDO"),
                        resultSet.getString("CORREO"),
                        resultSet.getString("TELEFONO")));
            } // end while
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } // end catch
        finally {
            try {
                resultSet.close();
            } // end try
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
                close();
            } // end catch
        } // end finally
        return results;
    } // end method getPeopleByName 
    // add an entry

    public int agregarPersona(String nombre, String apellido, String correo, String telefono) {
        int result = 0;
        // set parameters, then execute insertNewPerson
        try {
            insertarPersona.setString(1, nombre);
            insertarPersona.setString(2, apellido);
            insertarPersona.setString(3, correo);
            insertarPersona.setString(4, telefono);
// insert the new entry; returns # of rows updated
            result = insertarPersona.executeUpdate();
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
            close();
        } // end catch
        return result;
    } // end method addPerson
// close the database connection

    public void close() {
        try {
            conexion.close();
        } // end try
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } // end catch
    } // end method close
} // end class PersonQueries
