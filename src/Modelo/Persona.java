/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Personal
 */
public class Persona {

    private int ID;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;

    public Persona() {
    }

    public Persona(int id, String nombre, String apellido, String email, String numeroTel) {
        this.ID = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = email;
        this.telefono = numeroTel;
    }

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return correo;
    }

    public void setEmail(String email) {
        this.correo = email;
    }

    public String getNumeroTel() {
        return telefono;
    }

    public void setNumeroTel(String numeroTel) {
        this.telefono = numeroTel;
    }

    
    
}
