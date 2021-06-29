/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Combustible;

import java.io.Serializable;

/**
 *
 * @author Asus
 */
public class PrecioCombustible implements Serializable{
    double precio_G, precios_GE;
    String impuesto;

    public PrecioCombustible(double precio_G, double precios_GE, String impuesto) {
        this.precio_G = precio_G;
        this.precios_GE = precios_GE;
        this.impuesto = impuesto;
    }

    public double getPrecio_G() {
        return precio_G;
    }

    public void setPrecio_G(double precio_G) {
        this.precio_G = precio_G;
    }

    public double getPrecios_GE() {
        return precios_GE;
    }

    public void setPrecios_GE(double precios_GE) {
        this.precios_GE = precios_GE;
    }

    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String impuesto) {
        this.impuesto = impuesto;
    }
    
    
}
