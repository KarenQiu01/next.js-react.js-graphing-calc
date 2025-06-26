package project.graphing_calc_backend;

import org.springframework.web.bind.annotation.*;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class CalculatorController {

    // Regular calculation endpoint (handles all exp4j functions, no x variable)
    @PostMapping("/calculate")
    public Map<String, Object> calculate(@RequestBody Map<String, String> payload) {
        String expr = payload.get("expression");
        try {
            Expression e = new ExpressionBuilder(expr)
                    .build();
            double result = e.evaluate();
            return Map.of("result", result);
        } catch (Exception ex) {
            System.out.println("Calculate error: " + ex.getMessage());
            return Map.of("error", "Invalid expression");
        }
    }

    // Graphing endpoint: evaluates expression at each x
    @PostMapping("/graph")
    public Map<String, Object> graph(@RequestBody Map<String, Object> payload) {
        String expr = (String) payload.get("expression");
        List<?> xValuesList = (List<?>) payload.get("x");
        List<Double> xValues = new ArrayList<>();
        // --- Robust conversion to Double (Jackson sometimes uses Integer, Double, or String!) ---
        for (Object o : xValuesList) {
            if (o instanceof Number) {
                xValues.add(((Number) o).doubleValue());
            } else {
                try {
                    xValues.add(Double.parseDouble(o.toString()));
                } catch (Exception parseEx) {
                    System.out.println("Failed to parse x value: " + o);
                    xValues.add(Double.NaN);
                }
            }
        }

        System.out.println("Received expression: " + expr);
        System.out.println("First x: " + (xValues.isEmpty() ? "none" : xValues.get(0)));

        List<Double> yValues = new ArrayList<>();
        try {
            Expression e = new ExpressionBuilder(expr)
                    .variable("x")
                    .build();
            for (double x : xValues) {
                try {
                    double y = e.setVariable("x", x).evaluate();
                    if (Double.isNaN(y) || Double.isInfinite(y)) {
                        yValues.add(null); // Plotly skips nulls
                    } else {
                        yValues.add(y);
                    }
                } catch (Exception evalErr) {
                    System.out.println("Eval error at x=" + x + ": " + evalErr.getMessage());
                    yValues.add(null);
                }
            }
            return Map.of("y", yValues);
        } catch (Exception ex) {
            System.out.println("Expression parsing error: " + ex.getMessage());
            // On error, return all nulls
            List<Double> nullList = new ArrayList<>();
            for (int i = 0; i < xValues.size(); i++) nullList.add(null);
            return Map.of("y", nullList);
        }
    }
}