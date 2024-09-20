package DataAccessObject;

import DataTranserObject.ProductoBean;

public class ProductoDAO {

    public String calcOperation(ProductoBean pb) {

        String aplicaDesc = calcDescuento(pb) == 0 ? "No aplica" : "" + calcDescuento(pb);

        return "### Datos de la compra ###\n" +
                "Marca: " + getMarca(pb) +
                "\nTalla: " + getTalla(pb) +
                "\nNúmero de pares: " + pb.getNumPares() +
                "\nDescuento: " +  aplicaDesc +
                "\n[!] Precio a pagar: " + calcVenta(pb);
    }

    public String getMarca(ProductoBean pb) {

        String marca = "";

        switch (pb.getMarca()) {
            case 0 -> {
                marca = "NIKE";
            } case 1 -> {
                marca = "ADIDAS";
            } case 2 -> {
                marca = "FILA";
            }
        }

        return marca;
    }

    public int getTalla(ProductoBean pb) {
        int talla = 0;

        switch (pb.getTalla()) {
            case 0 -> {
                talla = 38;
            } case 1 -> {
                talla = 40;
            } case 2 -> {
                talla = 42;
            }
        }

        return talla;
    }

    public int calcCostoParZapatillas(ProductoBean pb) {

        int costo = 0;

        if (pb.getTalla() == 0) {
            switch (pb.getMarca()) {
                case 0 -> {
                    costo = 150;
                }
                case 1 -> {
                    costo = 140;
                }
                case 2 -> {
                    costo = 80;
                }
            }
        } else if (pb.getTalla() == 1) {
            switch (pb.getMarca()) {
                case 0 -> {
                    costo = 160;
                }
                case 1 -> {
                    costo = 150;
                }
                case 2 -> {
                    costo = 85;
                }
            }
        } else if (pb.getTalla() == 2) {
            switch (pb.getMarca()) {
                case 0 -> {
                    costo = 160;
                }
                case 1 -> {
                    costo = 150;
                }
                case 2 -> {
                    costo = 90;
                }
            }
        }

        return costo;
    }

    public int calcVenta(ProductoBean pb) {
        return (int) ((calcVentaNeta(pb) * pb.getNumPares()) - calcDescuento(pb));
    }

    public float calcDescuento(ProductoBean pb) {
        int cant = pb.getNumPares();
        float descuento = 0;

        if (cant >= 2 && cant <= 5) {
            descuento = (float) (pb.getVentaNeta() * 0.05);
        } else if (cant >= 6 && cant <= 10) {
            descuento = (float) (pb.getVentaNeta() * 0.08);
        } else if (cant >= 11 && cant <= 20) {
            descuento = (float) (pb.getVentaNeta() * 0.1);
        } else if (cant >= 20) {
            descuento = (float) (pb.getVentaNeta() * 0.15);
        }

        return descuento;
    }

    public float calcVentaNeta(ProductoBean pb) {
        return calcCostoParZapatillas(pb);
    }

}
