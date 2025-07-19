package principal;

import java.util.Scanner;

public class ConversorMonedas {
    public static void main(String[] args) {
        ConsultaConversion consulta = new ConsultaConversion();
        Scanner lectura = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("******************************************************");
            System.out.println("Sea bienvenido al Conversor de Moneda:\n");
            System.out.println("1. Dolar ==> Peso argentino\n" +
                    "2. Peso argentino ==> Dolar\n" +
                    "3. Dolar ==> Real brasileno\n" +
                    "4. Real brasileno ==> Dolar\n" +
                    "5. Dolar ==> Peso colombiano\n" +
                    "6. Peso colombiano ==> Dolar\n" +
                    "7. Salir");
            System.out.println("Eliga una opcion valida: ");
            System.out.println("******************************************************");
            opcion = lectura.nextInt();

            switch (opcion) {
                case 1:
                    consulta.convertir("USD", "ARS");
                    break;
                case 2:
                    consulta.convertir("ARS", "USD");
                    break;
                case 3:
                    consulta.convertir("USD", "BRL");
                    break;
                case 4:
                    consulta.convertir("BRL", "USD");
                    break;
                case 5:
                    consulta.convertir("USD", "COP");
                    break;
                case 6:
                    consulta.convertir("COP", "USD");
                    break;
                case 7:
                    System.out.println("Gracias por utilizar el sistema conversor.");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        } while (opcion != 7);
    }
}