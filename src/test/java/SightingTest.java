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
}
