/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author steven
 */
public class Sucursal {
    private int codigoSucursal;
    private String descripcion;
    private String rangoFacturacion;
    private String direccion;
    private String fechaActualizacion;
    private String fechaIngreso;
    private String userIngreso;
    private String userActualizacion;
    private String restrictiva;
    private int cEmpresa;

    public Sucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public Sucursal(String descripcion, String rangoFacturacion, String direccion, String fechaActualizacion, String fechaIngreso, String userIngreso, String userActualizacion, String restrictiva, int cEmpresa) {
        this.descripcion = descripcion;
        this.rangoFacturacion = rangoFacturacion;
        this.direccion = direccion;
        this.fechaActualizacion = fechaActualizacion;
        this.fechaIngreso = fechaIngreso;
        this.userIngreso = userIngreso;
        this.userActualizacion = userActualizacion;
        this.restrictiva = restrictiva;
        this.cEmpresa = cEmpresa;
    }

    public Sucursal(int codigoSucursal, String descripcion, String rangoFacturacion, String direccion, String fechaActualizacion, String fechaIngreso, String userIngreso, String userActualizacion, String restrictiva, int cEmpresa) {
        this.codigoSucursal = codigoSucursal;
        this.descripcion = descripcion;
        this.rangoFacturacion = rangoFacturacion;
        this.direccion = direccion;
        this.fechaActualizacion = fechaActualizacion;
        this.fechaIngreso = fechaIngreso;
        this.userIngreso = userIngreso;
        this.userActualizacion = userActualizacion;
        this.restrictiva = restrictiva;
        this.cEmpresa = cEmpresa;
    }

   

    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRangoFacturacion() {
        return rangoFacturacion;
    }

    public void setRangoFacturacion(String rangoFacturacion) {
        this.rangoFacturacion = rangoFacturacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getUserIngreso() {
        return userIngreso;
    }

    public void setUserIngreso(String userIngreso) {
        this.userIngreso = userIngreso;
    }

    public String getUserActualizacion() {
        return userActualizacion;
    }

    public void setUserActualizacion(String userActualizacion) {
        this.userActualizacion = userActualizacion;
    }

    public String getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(String restrictiva) {
        this.restrictiva = restrictiva;
    }

    public int getcEmpresa() {
        return cEmpresa;
    }

    public void setcEmpresa(int cEmpresa) {
        this.cEmpresa = cEmpresa;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "codigoSucursal=" + codigoSucursal + ", descripcion=" + descripcion + ", rangoFacturacion=" + rangoFacturacion + ", direccion=" + direccion + ", fechaActualizacion=" + fechaActualizacion + ", fechaIngreso=" + fechaIngreso + ", userIngreso=" + userIngreso + ", userActualizacion=" + userActualizacion + ", restrictiva=" + restrictiva + ", cEmpresa=" + cEmpresa + '}';
    }
    

 
    
}
