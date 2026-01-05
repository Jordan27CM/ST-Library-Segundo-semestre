/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author luisr
 */
public class Usuario {
    private int id;
    private String nickname;
    private String nombre;
    private String apellido;
    private String clave;
    private int nivelAcceso;
    private String rut;

    public Usuario() {
        this.id = 0;
        this.nickname = "";
        this.nombre = "";
        this.apellido = "";
        this.clave = "";
        this.nivelAcceso = 1;
        this.rut = "";
    }

    public Usuario(int id, String nickname, String nombre, String apellido, String clave, int nivelAcceso, String rut) {
        this.id = id;
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.clave = clave;
        this.nivelAcceso = nivelAcceso;
        this.rut = rut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nickname=" + nickname + ", nombre=" + nombre + ", apellido=" + apellido + ", clave=" + clave + ", nivelAcceso=" + nivelAcceso + ", rut=" + rut + '}';
    }
    
}
