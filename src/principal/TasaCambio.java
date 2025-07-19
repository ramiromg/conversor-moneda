package principal;

import java.util.HashMap;

public record TasaCambio(String base_code,
                         HashMap<String, Double> conversion_rates) {
}
