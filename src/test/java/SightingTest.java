import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.Arrays;
import java.util.*;

public class SightingTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Sighting_instantiatesCorrectly() {
    Sighting sighting = new Sighting("Near the river", "Jerry", 2);
    assertTrue(sighting instanceof Sighting);
  }

  @Test
  public void getLocation_returnsLocation() {
    Sighting sighting = new Sighting("Near the river", "Jerry", 2);
    assertEquals(sighting.getLocation(), "Near the river");
  }

  @Test
  public void getRangerName_returnsRangerName() {
    Sighting sighting = new Sighting("Near the river", "Jerry", 2);
    assertEquals(sighting.getRangerName(), "Jerry");
  }

  @Test
  public void getAnimalId_returnsAnimalId() {
    Sighting sighting = new Sighting("Near the river", "Jerry", 2);
    assertEquals(sighting.getAnimalId(), 2);
  }

  @Test
  public void equals_returnsTrueIfSightingsAreSame() {
    Sighting sighting = new Sighting("Near the river", "Jerry", 2);
    Sighting sightingTwo = new Sighting("Near the river", "Jerry", 2);
    assertTrue(sighting.equals(sightingTwo));
  }

  @Test
  public void save_savesSightingToDatabase() {
    Sighting sighting = new Sighting("Near the river", "Jerry", 2);
    sighting.save();
    assertEquals(Sighting.all().get(0), sighting);
  }

  @Test
  public void save_assignsIdToSightings() {
    Sighting sighting = new Sighting("Near the river", "Jerry", 2);
    sighting.save();
    Sighting savedSighting = Sighting.all().get(0);
    assertEquals(sighting.getId(), savedSighting.getId());
  }

  @Test
  public void all_returnsAllInstancesOfSighting() {
    Sighting sighting = new Sighting("Near the river", "Jerry", 2);
    sighting.save();
    Sighting sightingTwo = new Sighting("NE Quadrant", "Jerry", 3);
    sighting.save();
    assertEquals(Sighting.all().size(), 2);
  }

  @Test
  public void find_findCorrectSighting() {
    Sighting sighting = new Sighting("Near the river", "Jerry", 2);
    sighting.save();
    Sighting sightingTwo = new Sighting("Near the river", "Joe", 3);
    sightingTwo.save();
    assertEquals(Sighting.find(sightingTwo.getId()), sightingTwo);
  }

  @Test
  public void delete_deletesSighting() {
    Sighting sighting = new Sighting("Near the river", "Jerry", 2);
    sighting.save();
    sighting.delete();
    assertEquals(null, Sighting.find(sighting.getId()));
  }
}
