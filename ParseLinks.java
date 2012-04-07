import java.io.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class ParseLinks
{
	public static String[] readPage(String page_url) throws Exception
	{
		Document doc = Jsoup.connect(page_url).get();
		Elements a = doc.select("a[href]");
		String links[] = new String[30];
		int top = 0;

		l1: for (Element hr : a)
			if (hr.attr("abs:href").startsWith("http://img") | hr.attr("abs:href").startsWith("http://i.img"))
			{
				for(int i=1;i<=top;i++)
					if(hr.attr("abs:href").equals(links[i]) || hr.attr("abs:href").equals(links[i].substring(0, links[i].length() - 4)) )
						continue l1;
				if( hr.attr("abs:href").endsWith(".png") || hr.attr("abs:href").endsWith(".jpg") )
					links[++top] = hr.attr("abs:href");
				else
					links[++top] = hr.attr("abs:href") + ".jpg";
			}
		links[0] = String.valueOf(top);
		return links;
	}
}
