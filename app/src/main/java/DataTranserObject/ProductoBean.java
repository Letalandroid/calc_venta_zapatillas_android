package DataTranserObject;

public class ProductoBean {

    private int marca;
    private int talla;
    private int numPares;
    private int venta;
    private float descuento;

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public int getNumPares() {
        return numPares;
    }

    public void setNumPares(int numPares) {
        this.numPares = numPares;
    }

    public int getVenta() {
        return venta;
    }

    public void setVenta(int venta) {
        this.venta = venta;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getVentaNeta() {
        return ventaNeta;
    }

    public void setVentaNeta(float ventaNeta) {
        this.ventaNeta = ventaNeta;
    }

    private float ventaNeta;

}
