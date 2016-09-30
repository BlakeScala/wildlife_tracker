import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.*;

public class AnimalTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void animal_instantiatesCorrectly_true() {
    Animal animal = new Animal("Brown Bear");
    assertTrue(animal instanceof Animal);
  }

  @Test
  public void getName_returnsName_true() {
    Animal animal = new Animal("Brown Bear");
    assertEquals("Brown Bear", animal.getName());
  }

  @Test
  public void equals_returnsTrueIfAnimalsAreSame() {
    Animal animal = new Animal("Brown Bear");
    Animal animalTwo = new Animal("Brown Bear");
    assertTrue(animal.equals(animalTwo));
  }
}
