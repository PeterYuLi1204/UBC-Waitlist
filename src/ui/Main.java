package ui;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Scanner;

import utils.Waitlist;

public class Main {

    public static final String WAITING_LIST = "Waiting List";
    public static final String LINK_PREFIX = "https://courses.students.ubc.ca";

    public static Document doc;
    public static Elements sections;
    public static String courseName;
    public static String courseNum;
    public static String semester;
    public static String searchTerm;
    public static ArrayList<String> waitlists = new ArrayList<>();
    public static Integer waitlistsSize;

    public static void main(String[] args) {
        // Get course name from user
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the course abbreviation:");
        courseName = input.nextLine().toUpperCase();

        // Get course number from user
        System.out.println("Enter the course number:");
        courseNum = input.nextLine();

        // Get current semester from user
        System.out.println("Enter the current semester:");
        semester = input.nextLine();
        searchTerm = WAITING_LIST + " " + semester;

        System.out.println("\nRetrieving waitlist information now...\n");

        String courseLink = "https://courses.students.ubc.ca/cs/courseschedule?pname=subjarea&tname=subj-course&dept=" + courseName + "&course=" + courseNum;

        try {

            doc = Jsoup.connect(courseLink).get();

            sections = doc.getElementsByTag("tr");

            for (Element section : sections) {
                if (section.text().contains(searchTerm)) {

                    String link = LINK_PREFIX + section.select("a[href]").attr("href");
                    waitlists.add(link);

                }
            }

            // checks if there is no waitlist. Try phys 117 sem 2 as a test
            int waitlistssize = waitlists.size();
            if (waitlistssize == 0) {
                System.out.println("There is no waitlist for " + courseName + " " + courseNum + " in semester " + semester);
            } else {
                for (String link : waitlists) {
                    Waitlist.getWaitlist(link);
                    System.out.println();
                }
            }

        } catch (Exception e) {
            System.out.println("An error occurred");
        }
    }
}