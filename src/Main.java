import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static Document doc;
    public static Elements content;
    public static String text;

    public static void main(String[] args) {
        String url = "https://courses.students.ubc.ca/cs/courseschedule?pname=subjarea&tname=subj-section&dept=PHYS&course=131&section=20W";

        try {
            doc = Jsoup.connect(url).get();

            content = doc.select("table.'table");

            String text = content.text();
        } catch (Exception e) {
            System.out.println("An error occurred");
        }

        System.out.println(text);
    }
}