package com.example.joshuansu.homecash.content;

import java.io.Serializable;

/**
 * Created by joshuansu on 17/04/17.
 */

public class ToDoContent implements Serializable{
    private String nombre;
    private String stauts;
    private int idFoto;
    private boolean box;
    private String detalle;

    public ToDoContent(String nombre, String stauts, int idFoto, boolean box, String detalle) {
        this.nombre = nombre;
        this.stauts = stauts;
        this.idFoto = idFoto;
        this.box = box;
        this.detalle = detalle;
    }

    public ToDoContent() {

    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public boolean isBox() {
        return box;
    }

    public void setBox(boolean box) {
        this.box = box;
    }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStauts() {
        return stauts;
    }

    public void setStauts(String stauts) {
        this.stauts = stauts;
    }

    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }
}
