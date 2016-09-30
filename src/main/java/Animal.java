import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class Animal {
  public int id;
  public String name;

  public Animal(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object otherAnimal) {
    if (!(otherAnimal instanceof Animal)) {
      return false;
    } else {
      Animal newAnimal = (Animal) otherAnimal;
      return this.getName().equals(newAnimal.getName());
    }
  }
}
