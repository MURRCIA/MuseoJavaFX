package com.example.interfasmuseoui;

public class CostoUtil {
    // Constantes para los valores mágicos
    private static final int EDAD_MINIMA = 18;
    private static final String NOAFILIADO = "N";
    private static final double PRECIO_BASE = 30000.0;
    private static final double DESCUENTO_A = 0.15;
    private static final double DESCUENTO_B = 0.30;
    private static final double DESCUENTO_C = 0.50;
    private static final double PRECIO_MENOR_EDAD = 5000.0;

    public static double calcularCostoPorPersona(Usuario usuario) {
        double precioIngreso = 0.0;

        if (usuario.getEdad() < EDAD_MINIMA) {
            // Menor de edad
            precioIngreso = PRECIO_MENOR_EDAD;

        }    else {
            switch (usuario.getCategoria()) {
                case "A":
                    precioIngreso = PRECIO_BASE * (1 - DESCUENTO_A);
                    break;
                case "B":
                    precioIngreso = PRECIO_BASE * (1 - DESCUENTO_B);
                    break;
                case "C":
                    precioIngreso = PRECIO_BASE * (1 - DESCUENTO_C);
                    break;
                default:
                    break;
            }
        }

        return precioIngreso;
    }
}

