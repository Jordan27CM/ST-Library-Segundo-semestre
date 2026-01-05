/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author luisr
 */
public class Sala {
    private int numeroSala;
    private boolean disponible;
    private int capacidad;

    public Sala() {
        this.numeroSala = 0;
        this.disponible = false;
        this.capacidad = 0;
    }

    public Sala(int numeroSala, boolean disponible, int capacidad) {
        this.numeroSala = numeroSala;
        this.disponible = disponible;
        this.capacidad = capacidad;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Sala{" + "numeroSala=" + numeroSala + ", disponible=" + disponible + ", capacidad=" + capacidad + '}';
    }
    
    
}
