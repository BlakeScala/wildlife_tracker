import org.sql2o.*;
import java.util.ArrayList;
import java.util.List;

public class EndangeredAnimal extends Animal {
  private String health;
  private String age;

  public static final String HEALTH_HEALTHY = "Healthy";
  public static final String HEALTH_OKAY = "Okay";
  public static final String HEALTH_ILL = "Ill";
  public static final String AGE_NEWBORN = "Newborn";
  public static final String AGE_YOUNG = "Young";
  public static final String AGE_ADULT = "Adult";
  public static final String DATABASE_TYPE = "Endangered";

  public EndangeredAnimal(String name, String health, String age) {
    super(name);
    this.health = health;
    this.age = age;
    type = DATABASE_TYPE;
  }

  public int getId() {
    return id;
  }

  public String getHealth() {
    return health;
  }

  public String getAge() {
    return age;
  }

  public static List<EndangeredAnimal> allEndangered() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals WHERE type = 'Endangered';";
      return con.createQuery(sql)
        .executeAndFetch(EndangeredAnimal.class);
    }
  }

  @Override
  public void save() {
    try(Connection con = DB.sql2o.open()) {
      if(this.name.equals(""))
      {
        throw new IllegalArgumentException("Please enter a species of animal!");
      }
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

  public void updateHealth(String health) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE animals SET health = :health WHERE id = :id";
      con.createQuery(sql)
        .addParameter("health", health)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }

  public void updateAge(String age) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "UPDATE animals SET age = :age WHERE id = :id";
      con.createQuery(sql)
        .addParameter("age", age)
        .addParameter("id", this.id)
        .executeUpdate();
    }
  }

  public static EndangeredAnimal find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM animals WHERE id = :id";
      return con.createQuery(sql)
        .throwOnMappingFailure(false)
        .addParameter("id", id)
        .executeAndFetchFirst(EndangeredAnimal.class);
    }
  }
}
