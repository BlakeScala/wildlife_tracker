import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import org.sql2o.*;
import java.util.List;
import java.util.ArrayList;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      model.put("animals", Animal.all());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/add-endangered-sighting", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/endangered-sighting-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("endangered-form-success", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/endangered-form-success.vtl");
      String rangerName = request.queryParams("rangerName");
      String location = request.queryParams("location");
      String animalName = request.queryParams("animal-name");
      String animalHealth = request.queryParams("animal-health");
      String animalAge = request.queryParams("animal-age");
      EndangeredAnimal endangeredAnimal = new EndangeredAnimal(animalName, animalHealth, animalAge);
      Sighting sighting = new Sighting(location, rangerName, endangeredAnimal.getId());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
