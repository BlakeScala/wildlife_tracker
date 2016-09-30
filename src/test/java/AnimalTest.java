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

  @Test
  public void save_insertsAnimalIntoDatabase() {
    Animal animal = new Animal("Brown Bear");
    animal.save();
    assertEquals(Animal.all().get(0), animal);
  }

  @Test
  public void save_savesIdToAnimals() {
    Animal animal = new Animal("Brown Bear");
    animal.save();
    Animal savedAnimal = Animal.all().get(0);
    assertEquals(animal.getId(), savedAnimal.getId());
  }

  @Test
  public void find_findsCorrectAnimal() {
    Animal animal = new Animal("Brown Bear");
    Animal animalTwo = new Animal("Brown Bear");
    animal.save();
    animalTwo.save();
    assertEquals(Animal.find(animalTwo.getId()), animalTwo);
  }

  @Test
  public void delete_deletesAnimal() {
    Animal animal = new Animal("Brown Bear");
    animal.save();
    animal.delete();
    assertEquals(null, Animal.find(animal.getId()));
  }

  @Test
  public void updateName_updatesName() {
    Animal animal = new Animal("Brown Bear");
    animal.save();
    animal.updateName("Black Bear");
    assertEquals(animal.getName(), "Black Bear");
  }
}
