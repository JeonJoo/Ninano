package pkg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class FlowerCraw {
	public ArrayList<HashMap<String, String>> getFlower(String webURL){
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		Document doc;
		try {
			doc = Jsoup.connect(webURL).get();
			Elements eles = doc.select("#goodsImgList > ul > li:nth-child(1)");
			for(Element li : eles) {
				String product = li.selectFirst("a > div.goods_text > p").text();
				String price = li.selectFirst("a > div.goods_text > div.price > p > span").text();
				String img = "";
				try {
					img = li.selectFirst("a > div.goods_img > img").attr("src");
				} catch(NullPointerException e) {
						img = "/images/다운로드.jpg";
					}
					HashMap<String, String> map = new HashMap<String, String>();
					map.put("key_product", product);
					map.put("key_price", price);
					map.put("key_img", img);
					list.add(map);
					
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return list;	
	}
}
