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
}
