package com.sena.tienda.dto;

public class VentaRequest {

    private String documentoCliente;
    private String codigoBicicleta;
    private int cantidad;

    public String getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(String documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public String getCodigoBicicleta() {
        return codigoBicicleta;
    }

    public void setCodigoBicicleta(String codigoBicicleta) {
        this.codigoBicicleta = codigoBicicleta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}