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

  public EndangeredAnimal(String name, String health, String age) {
    super(name);
    this.health = health;
    this.age = age;
  }
}
