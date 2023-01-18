package ui;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Scanner;

public class Main {

    public static Document doc;
    public static Elements content;
    public static String course;
    public static String courseNum;
    public static String semester;

    public static void main(String[] args) {
        // Get course name from user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the course abbreviation:");
        course = input.nextLine();

        // Get course number from user
        System.out.println("Enter the course number:");
        courseNum = input.nextLine();

        // Get current semester from user
        System.out.println("Enter the current semester:");
        semester = input.nextLine();

        String courseLink = "https://courses.students.ubc.ca/cs/courseschedule?pname=subjarea&tname=subj-section&dept=" + course + "&course=" + courseNum;

        try {
            doc = Jsoup.connect(courseLink).get();

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