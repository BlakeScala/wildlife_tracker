import org.sql2o.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sighting {
  private int id;
  private String rangerName;
  private int animalId;
  private String location;
  private Timestamp time;

  public Sighting(String location, String rangerName, int animalId) {
    this.location = location;
    this.rangerName = rangerName;
    this.animalId = animalId;
    this.time = new Timestamp(new Date().getTime());
  }

  public String getLocation() {
    return location;
  }

  public String getRangerName() {
    return rangerName;
  }

  public int getAnimalId() {
    return animalId;
  }

  public int getId() {
    return id;
  }

  public Timestamp getTime() {
    return time;
  }

  @Override
  public boolean equals(Object otherSighting) {
    if (!(otherSighting instanceof Sighting)) {
      return false;
    } else {
      Sighting newSighting = (Sighting) otherSighting;
      return this.getLocation().equals(newSighting.getLocation()) &&
             this.getRangerName().equals(newSighting.getRangerName()) &&
             this.getAnimalId() == (newSighting.getAnimalId()) &&
             this.getId() == (newSighting.getId()) &&
             this.getTime().equals(newSighting.getTime());
    }
  }
}
