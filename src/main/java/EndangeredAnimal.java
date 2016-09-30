import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class EndangeredAnimal extends Animal {
  private String health;
  private String age;

  public static final String HEALTH_HEALTHY = "healthy";
  public static final String HEALTH_OKAY = "okay";
  public static final String HEALTH_ILL = "ill";
  public static final String AGE_NEWBORN = "newborn";
  public static final String AGE_YOUNG = "young";
  public static final String AGE_ADULT = "adult";
  public static final String DATABASE_TYPE = "endangered";

  public EndangeredAnimal(String name, String health, String age) {
    super(name);
    this.health = health;
    this.age = age;
    type = DATABASE_TYPE;
  }

  public static List<EndangeredAnimal> allEndangered() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals WHERE type = 'endangered';";
      return con.createQuery(sql)
        .executeAndFetch(EndangeredAnimal.class);
    }
  }

  @Override
  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO animals (name, type, health, age) VALUES (:name, :type, :health, :age)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("type", this.type)
        .addParameter("health", this.health)
        .addParameter("age", this.age)
        .executeUpdate()
        .getKey();
    }
  }
}
