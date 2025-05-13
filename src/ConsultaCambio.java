import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConsultaCambio {

    public static void conversaoCambio(int op, Scanner scanner) throws IOException, InterruptedException {
        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/f5723b929eff35f731fdde11/latest/USD"))
                .build();

        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
        JsonObject taxas = json.getAsJsonObject("conversion_rates");

        double valor, resultado;

        System.out.print("Digite o valor que deseja converter: ");
        valor = scanner.nextDouble();

        switch (op) {
            case 1:
                resultado = valor * taxas.get("ARS").getAsDouble();
                System.out.printf("Resultado: %.2f Pesos argentinos (ARS)%n", resultado);
                break;
            case 2:
                resultado = valor / taxas.get("ARS").getAsDouble();
                System.out.printf("Resultado: %.2f Dólares (USD)%n", resultado);
                break;
            case 3:
                resultado = valor * taxas.get("BRL").getAsDouble();
                System.out.printf("Resultado: %.2f Reais (BRL)%n", resultado);
                break;
            case 4:
                resultado = valor / taxas.get("BRL").getAsDouble();
                System.out.printf("Resultado: %.2f Dólares (USD)%n", resultado);
                break;
            case 5:
                resultado = valor * taxas.get("COP").getAsDouble();
                System.out.printf("Resultado: %.2f Pesos colombianos (COP)%n", resultado);
                break;
            case 6:
                resultado = valor / taxas.get("COP").getAsDouble();
                System.out.printf("Resultado: %.2f Dólares (USD)%n", resultado);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
}