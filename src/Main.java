import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    public static Document doc;
    public static Elements content;

    public static void main(String[] args) {
        String url = "https://courses.students.ubc.ca/cs/courseschedule?pname=subjarea&tname=subj-section&dept=DSCI&course=100&section=WL4";

        try {
            doc = Jsoup.connect(url).get();

            content = doc.getElementsByTag("tr");

            for (Element element : content) {
                System.out.println(element.text());
            }
        } catch (Exception e) {
            System.out.println("An error occurred");
        }
    }
}