package utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Waitlist {

    public static Document doc;
    public static Elements content;

    public static void getWaitlist(String link) {
        try {
            doc = Jsoup.connect(link).get();

            content = doc.getElementsByClass("'table").select("tr");

            String title = doc.select("h4").text();

            System.out.println(title);

            for (Element element : content) {
                System.out.println(element.text());
            }
        } catch (Exception e) {
            System.out.println("An error occurred");
        }
    }
}
