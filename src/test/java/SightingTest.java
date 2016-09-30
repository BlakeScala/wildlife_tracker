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
}
