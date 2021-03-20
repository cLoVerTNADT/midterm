import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawl {
    public static void main(String[] args) {
        WebCrawler webCrawler = new WebCrawler();
        String myUrl = "https://www.wikipedia.org/";
        webCrawler.search(myUrl);
    }
}

class WebCrawler {
    private Queue<String> queue;
    private ArrayList<String> websites;

    public WebCrawler() {
        this.queue = new LinkedList<>();
        this.websites = new ArrayList<>();
    }

    public void search(String root) {
        this.queue.add(root);
        this.websites.add(root);

        while (!queue.isEmpty()) {
            String vertex = queue.remove(); //
            String url = readUrl(vertex);

            String regex = "https://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(url);

            while (matcher.find()) {
                String actual = matcher.group();

                if (!websites.contains(actual)) {
                    websites.add(actual);
                    System.out.println(actual);
                    queue.add(actual);
                }
            }
        }
    }

    public String readUrl(String vertex) {
        String result = "";
        try {
            URL url = new URL(vertex);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String input = "";

            while ((input = br.readLine()) != null) {
                result = result + input;
            }
            br.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return result;
    }
}
