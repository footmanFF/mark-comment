package com.fm;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

/**
 * @author zhangli on 2017/8/21.
 */
public class JsoupTest {

    @Test
    public void test(){
        String s = "If many mappings are to be stored in a <tt>HashMap</tt>\n" +
                "instance, creating it with a sufficiently large capacity will allow\n" +
                "the mappings to be stored more efficiently than letting it perform\n" +
                "automatic rehashing as needed to grow the table.  Note that using\n" +
                "many keys with the same {@code hashCode()} is a sure way to slow\n" +
                "down performance of any hash table. To ameliorate impact, when keys\n" +
                "are {@link Comparable}, this class may use comparison order among\n" +
                "keys to help break ties.";
        Document document = Jsoup.parse(s);
        document.getAllElements();
        Element element = document.select("body").first();
        element.children()
               .forEach((t) -> {
                   t.tagName();
                   t.tagName();
               });
    }

}