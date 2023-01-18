import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    static Document doc;
    static Elements content;

    public static void main(String[] args) {
        String url = "https://courses.students.ubc.ca/cs/courseschedule?pname=subjarea&tname=subj-section&dept=PHYS&course=131&section=20W";

        try {
            doc = Jsoup.connect(url).get();

            content = doc.select("table");
        } catch (Exception e) {
            System.out.println("An error occurred");
        }

        String text = content.text();

        System.out.println(text);
    }
}