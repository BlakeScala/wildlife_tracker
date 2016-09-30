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

  @Test
  public void getName_returnsName_true() {
    EndangeredAnimal animal = new EndangeredAnimal("Rattlesnake", "healthy", "adult");
    assertEquals("Rattlesnake", animal.getName());
  }

  @Test
  public void equals_returnsTrueIfEndangeredAnimalsAreSame() {
    EndangeredAnimal animal = new EndangeredAnimal("Rattlesnake", "healthy", "adult");
    EndangeredAnimal animalTwo = new EndangeredAnimal("Rattlesnake", "healthy", "adult");
    assertTrue(animal.equals(animalTwo));
  }

  @Test
  public void save_insertsEndangeredAnimalIntoDatabase() {
    EndangeredAnimal animal = new EndangeredAnimal("Rattlesnake", "healthy", "adult");
    animal.save();
    assertEquals(EndangeredAnimal.all().get(0), animal);
  }

  @Test
  public void save_savesIdToEndangeredAnimals() {
    EndangeredAnimal animal = new EndangeredAnimal("Rattlesnake", "healthy", "adult");
    animal.save();
    EndangeredAnimal savedAnimal = EndangeredAnimal.allEndangered().get(0);
    assertEquals(animal.getId(), savedAnimal.getId());
  }

  @Test
  public void find_findsCorrectEndangeredAnimal() {
    EndangeredAnimal animal = new EndangeredAnimal("Rattlesnake", "healthy", "adult");
    EndangeredAnimal animalTwo = new EndangeredAnimal("Rattlesnake", "healthy", "adult");
    animal.save();
    animalTwo.save();
    assertEquals(EndangeredAnimal.find(animalTwo.getId()), animalTwo);
  }

  @Test
  public void allEndangered_onlyReturnsEndangered() {
    EndangeredAnimal animal = new EndangeredAnimal("Rattlesnake", "healthy", "adult");
    Animal animalTwo = new Animal("Brown Bear");
    animal.save();
    animalTwo.save();
    assertTrue(EndangeredAnimal.allEndangered().size() == 1);
  }

  @Test
  public void delete_deletesEndangeredAnimal() {
    EndangeredAnimal animal = new EndangeredAnimal("Rattlesnake", "healthy", "adult");
    animal.save();
    animal.delete();
    assertEquals(null, EndangeredAnimal.find(animal.getId()));
  }

  @Test
  public void updateName_updatesName() {
    EndangeredAnimal animal = new EndangeredAnimal("Rattlesnake", "healthy", "adult");
    animal.save();
    animal.updateName("Diamondback Rattlesnake");
    assertEquals(animal.getName(), "Diamondback Rattlesnake");
  }

  @Test
  public void updateHealth_updatesHealth() {
    EndangeredAnimal animal = new EndangeredAnimal("Rattlesnake", "healthy", "adult");
    animal.save();
    animal.updateHealth("ill");
    assertEquals(EndangeredAnimal.find(animal.getId()).getHealth(), "ill");
  }

  @Test
  public void updateAge_updatesAge() {
    EndangeredAnimal animal = new EndangeredAnimal("Rattlesnake", "healthy", "young");
    animal.save();
    animal.updateAge("adult");
    assertEquals("adult", EndangeredAnimal.find(animal.getId()).getAge());
  }

  @Test
  public void delete_deletesAnimal() {
    EndangeredAnimal animal = new EndangeredAnimal("Rattlesnake", "healthy", "young");
    animal.save();
    animal.delete();
    assertEquals(null, EndangeredAnimal.find(animal.getId()));
  }
}
