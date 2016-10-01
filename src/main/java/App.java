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
      model.put("animals", Animal.allNotEndangered());
      model.put("endangeredAnimals", EndangeredAnimal.allEndangered());
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/new-animal", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String animalName = request.queryParams("animal-name");
      try {
        Animal animal = new Animal(animalName);
        animal.save();
      }
      catch(IllegalArgumentException exception)
      { }
      model.put("animals", Animal.allNotEndangered());
      model.put("endangeredAnimals", EndangeredAnimal.allEndangered());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/new-endangered-animal", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String endAnimalName = request.queryParams("end-animal-name");
      int inputEndAnimalAge = Integer.parseInt(request.queryParams("end-animal-age"));
      int inputEndAnimalHealth = Integer.parseInt(request.queryParams("end-animal-health"));
      String endAnimalAge = "";
      String endAnimalHealth = "";
      if(inputEndAnimalAge == 1){
        endAnimalAge = EndangeredAnimal.AGE_NEWBORN;
      } else if (inputEndAnimalAge == 2) {
        endAnimalAge = EndangeredAnimal.AGE_YOUNG;
      } else if (inputEndAnimalAge == 3) {
        endAnimalAge = EndangeredAnimal.AGE_ADULT;
      }
      if(inputEndAnimalHealth == 1) {
        endAnimalHealth = EndangeredAnimal.HEALTH_HEALTHY;
      } else if (inputEndAnimalHealth == 2) {
        endAnimalHealth = EndangeredAnimal.HEALTH_OKAY;
      } else if (inputEndAnimalHealth == 3) {
        endAnimalHealth = EndangeredAnimal.HEALTH_ILL;
      }
      try{
        EndangeredAnimal endAnimal = new EndangeredAnimal(endAnimalName, endAnimalHealth, endAnimalAge);
        endAnimal.save();
      }
      catch(IllegalArgumentException exception) { }
      model.put("animals", Animal.allNotEndangered());
      model.put("endangeredAnimals", EndangeredAnimal.allEndangered());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
