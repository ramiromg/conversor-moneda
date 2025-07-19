package principal;

import com.google.gson.Gson;

import javax.swing.text.TabSet;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaConversion {
    public void convertir(String de, String a) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/9cd6b64313707717c9c23aaf/latest/" + de);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        TasaCambio tasaCambio = null;
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            tasaCambio = new Gson().fromJson(response.body(), TasaCambio.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontro el valor de conversion.");
        }

        Scanner lectura = new Scanner(System.in);
        System.out.println("Ingrese cantidad a convertir: ");
        double cantidad = lectura.nextDouble();
        double tasa = tasaCambio.conversion_rates().get(a);

        System.out.println("El valor "+ cantidad +" ["+ de +"]" +
                " corresponde al valor final de =>>>> " + cantidad*tasa + " [" + a + "]");
    }
}
