package app;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class ItemIDFetch {
	
	public static String fetchItem(String itemName) {
		String url = "https://www.wowhead.com/search?q=" + itemName;
		URLConnection con;
		String result = null;
		try {
			con = new URL( url ).openConnection();
			con.connect();
			InputStream is = con.getInputStream();
			String resultString = con.getURL().toString();
			if (resultString.contains("item=")) {
				result = resultString.substring(resultString.indexOf("item=") + 5);
				Item i = Item.getItemFromBnet(result);
			}
			//if the page was not redirected we don't get a proper result
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static String createSimCraftStringForItem(String slot, String itemName, int iLevel) {
		String result = "";
		String itemId = fetchItem(itemName);
		if (itemId == null) {
			return null;
		}
		result = slot +"=" + itemName.replaceAll(" ", "_").toLowerCase() + ",id=" + itemId +",ilevel=" + Integer.toString(iLevel);
		return result;
	}
	
	public static void main(String[] args) {
		fetchItem("Convergence of Fates");
	}
	
	//
}
