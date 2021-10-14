package edu.escuelaing.arep;

import static spark.Spark.*;

import org.json.JSONObject;
import spark.Request;

public class Calculator {

  public static void main(String[] args) {
    get(
      "/exp",
      "application/json",
      (req, res) -> {
        res.type("application/json");
        return processRequest("exp", exp(req.queryParams("value")), req);
      }
    );

    get(
      "/atan",
      "application/json",
      (req, res) -> {
        res.type("application/json");
        return processRequest("atan", atan(req.queryParams("value")), req);
      }
    );
  }

  public static Double exp(String value) {
    Double res = Math.pow(2.7182818, Integer.parseInt(value));
    return res;
  }

  public static Double atan(String value) {
    Double res = Math.atan(Double.parseDouble(value));
    return res;
  }

  public static JSONObject processRequest(String operation, Double value, Request req) {
    JSONObject json = new JSONObject();
    json.put("operacion", operation);
    json.put("input", req.queryParams("value"));
    json.put("output", value);
    return json;
  }
}
