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

  public int getId() {
    return this.id;
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

  public List<Animal> all() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals";
      return con.createQuery(sql)
        .executeAndFetch(Animal.class);
    }
  }
}
