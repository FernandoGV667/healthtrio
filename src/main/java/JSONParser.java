import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class JSONParser {
  public static void main(String[] args) {
    ObjectMapper mapper = new ObjectMapper();
    try {
      URL url =
          new URL(
              "https://www.healthit.gov/data/open-api?source=Meaningful-Use-Acceleration-Scorecard.csv");
      MeasuredData[] md = mapper.readValue(url, MeasuredData[].class);
      List<MeasuredData> mdList =
          Arrays.stream(md)
              .filter(m -> m.getPeriod() == 2014)
              .sorted(Comparator.comparing(MeasuredData::getRegion).reversed())
              .toList();
      System.out.println("YEAR 2014 STATISTICS :");
      System.out.printf("%-25s %s","STATE", "% of hospitals");
      System.out.println("\n=========================================");
      mdList.forEach(System.out::println);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
