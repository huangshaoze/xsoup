package us.codecraft.xsoup;

import junit.framework.Assert;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

/**
 * @author code4crafter@gmail.com
 */
public class XsoupTest {

    private String html = "<html><body><div id='test'><div><a href=\"https://github.com\">github.com</a></div></div></body></html>";

    @Test
    public void testSelect() {


        Document document = Jsoup.parse(html);

        String result = Xsoup.select(document, "//a").get();
        Assert.assertEquals("<a href=\"https://github.com\">github.com</a>", result);

        result = Xsoup.compile("//a").evaluate(document).get();
        Assert.assertEquals("<a href=\"https://github.com\">github.com</a>", result);
    }

    @Test
    public void testParent() {

        Document document = Jsoup.parse(html);

        String result = Xsoup.select(document, "/html/body/div/div/a").get();
        Assert.assertEquals("<a href=\"https://github.com\">github.com</a>", result);

        result = Xsoup.select(document, "/html//div/div/a").get();
        Assert.assertEquals("<a href=\"https://github.com\">github.com</a>", result);

    }
}
