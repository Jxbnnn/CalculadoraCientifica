package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraCientifica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            mostrarMenu();
            int opcion;
            try {
                opcion = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Debe ser un número.");
                sc.next();
                continue;
            }
            ejecutarOpcion(opcion, sc);
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n=== Menú Principal ===");
        System.out.println("1. Operaciones Aritméticas");
        System.out.println("2. Ecuación Cuadrática");
        System.out.println("3. Figuras Geométricas");
        System.out.println("4. Sistema de Ecuaciones Lineales");
        System.out.println("5. Ecuación de la Recta");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void ejecutarOpcion(int opcion, Scanner sc) {
        switch (opcion) {
            case 1 -> new OperacionesAritmeticas(sc).calcular();
            case 2 -> new EcuacionCuadratica(sc).resolver();
            case 3 -> new FigurasGeometricas(sc).calcular();
            case 4 -> new SistemaEcuacionesLineales(sc).resolver();
            case 5 -> new EcuacionRecta(sc).calcular();
            case 6 -> {
                System.out.println("Saliendo...");
                System.exit(0);
            }
            default -> System.out.println("Opción inválida");
        }
    }
}

class OperacionesAritmeticas {
    private final Scanner sc;

    public OperacionesAritmeticas(Scanner sc) {
        this.sc = sc;
    }

    public void calcular() {
        try {
            System.out.print("Ingrese el primer número: ");
            double a = sc.nextDouble();
            System.out.print("Ingrese el segundo número: ");
            double b = sc.nextDouble();
            System.out.println("Suma: " + sumar(a, b));
            System.out.println("Resta: " + (a - b));
            System.out.println("Multiplicación: " + (a * b));
            if (b == 0) System.out.println("División: Error - división por cero");
            else System.out.println("División: " + dividir(a, b));
            System.out.println("Mayor: " + Math.max(a, b));
            System.out.println("Menor: " + Math.min(a, b));
            if (a == 0 && b == 0) System.out.println("Potencia: Error - 0^0 no definido");
            else System.out.println("Potencia: " + potencia(a, b));
            System.out.println(b + "% de " + a + " es: " + (a * b / 100));
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Debe ingresar números.");
            sc.next();
        }
    }

    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double dividir(double a, double b) {
        if (b == 0) throw new ArithmeticException("División por cero");
        return a / b;
    }

    public static double potencia(double a, double b) {
        if (a == 0 && b == 0) throw new IllegalArgumentException("0^0 indefinido");
        return Math.pow(a, b);
    }
}

class EcuacionCuadratica {
    private final Scanner sc;

    public EcuacionCuadratica(Scanner sc) {
        this.sc = sc;
    }

    public void resolver() {
        try {
            System.out.print("Ingrese coeficiente A: ");
            double a = sc.nextDouble();
            System.out.print("Ingrese coeficiente B: ");
            double b = sc.nextDouble();
            System.out.print("Ingrese coeficiente C: ");
            double c = sc.nextDouble();
            double discriminante = b * b - 4 * a * c;
            if (a == 0) {
                System.out.println("No es una ecuación cuadrática");
            } else if (discriminante < 0) {
                System.out.println("Soluciones imaginarias");
            } else {
                double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                System.out.println("x1 = " + x1 + ", x2 = " + x2);
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Debe ingresar números.");
            sc.next();
        }
    }
}

class FigurasGeometricas {
    private final Scanner sc;

    public FigurasGeometricas(Scanner sc) {
        this.sc = sc;
    }

    public void calcular() {
        System.out.println("1. Cuadrado\n2. Rectángulo\n3. Círculo\n4. Esfera\n5. Cubo\n6. Cono");
        System.out.print("Seleccione figura: ");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1 -> {
                System.out.print("Lado: ");
                double l = sc.nextDouble();
                System.out.println("Perímetro: " + (4 * l));
                System.out.println("Área: " + (l * l));
            }
            case 2 -> {
                System.out.print("Base: ");
                double b = sc.nextDouble();
                System.out.print("Altura: ");
                double h = sc.nextDouble();
                System.out.println("Perímetro: " + (2 * (b + h)));
                System.out.println("Área: " + (b * h));
            }
            case 3 -> {
                System.out.print("Radio: ");
                double r = sc.nextDouble();
                System.out.println("Perímetro: " + (2 * Math.PI * r));
                System.out.println("Área: " + (Math.PI * r * r));
            }
            case 4 -> {
                System.out.print("Radio: ");
                double r = sc.nextDouble();
                System.out.println("Volumen: " + (4.0 / 3.0 * Math.PI * Math.pow(r, 3)));
            }
            case 5 -> {
                System.out.print("Lado: ");
                double l = sc.nextDouble();
                System.out.println("Volumen: " + (l * l * l));
            }
            case 6 -> {
                System.out.print("Radio: ");
                double r = sc.nextDouble();
                System.out.print("Altura: ");
                double h = sc.nextDouble();
                System.out.println("Volumen: " + (Math.PI * r * r * h / 3));
            }
            default -> System.out.println("Opción inválida");
        }
    }
}

class SistemaEcuacionesLineales {
    private final Scanner sc;

    public SistemaEcuacionesLineales(Scanner sc) {
        this.sc = sc;
    }

    public void resolver() {
        try {
            System.out.print("Ingrese A: ");
            double a = sc.nextDouble();
            System.out.print("Ingrese B: ");
            double b = sc.nextDouble();
            System.out.print("Ingrese C: ");
            double c = sc.nextDouble();
            System.out.print("Ingrese D: ");
            double d = sc.nextDouble();
            System.out.print("Ingrese E: ");
            double e = sc.nextDouble();
            System.out.print("Ingrese F: ");
            double f = sc.nextDouble();
            double det = a * e - b * d;
            if (det == 0) {
                System.out.println("Sistema sin solución única");
            } else {
                double x = (c * e - b * f) / det;
                double y = (a * f - c * d) / det;
                System.out.println("x = " + x + ", y = " + y);
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida");
            sc.next();
        }
    }
}

class EcuacionRecta {
    private final Scanner sc;

    public EcuacionRecta(Scanner sc) {
        this.sc = sc;
    }

    public void calcular() {
        try {
            System.out.print("Ingrese x1: ");
            double x1 = sc.nextDouble();
            System.out.print("Ingrese y1: ");
            double y1 = sc.nextDouble();
            System.out.print("Ingrese x2: ");
            double x2 = sc.nextDouble();
            System.out.print("Ingrese y2: ");
            double y2 = sc.nextDouble();
            if (x1 == x2) {
                System.out.println("Pendiente indefinida (recta vertical)");
                return;
            }
            double m = (y2 - y1) / (x2 - x1);
            double b = y1 - m * x1;
            System.out.println("Ecuación: Y = " + m + "X + " + b);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida");
            sc.next();
        }
    }
}
