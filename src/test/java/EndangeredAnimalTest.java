import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.*;

public class EndangeredAnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void animal_instantiatesCorrectly_true() {
    EndangeredAnimal animal = new EndangeredAnimal("Rattlesnake", "healthy", "adult");
    assertTrue(animal instanceof EndangeredAnimal);
  }
  


}
