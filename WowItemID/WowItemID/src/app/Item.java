package app;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Item {

	private static final String[] ITEMSLOTS = {"ammo", "head", "neck", "shoulder", "shirt", "chest", "waist",
					"legs", "feet", "wrist", "hands", "finger1", "trinket1"};
	private static final String IMAGEPREFIX = "https://wow.zamimg.com/images/wow/icons/large/";
	private String imageUrl;
	private String slot;
	private String name;
	private String description;
	private String id;
	
	public Item() {
		
	}
	
	public Item(String id, String n, String s, String img, String d) {
		this.id = id;
		name = n;
		slot = s;
		imageUrl = img;
		description = d;
	}
	
	public static Item getItemFromBnet(String itemID) {
		String json = RESTCaller.RESTCall(itemID);
		JsonParser parser = new JsonParser();
		JsonElement jsonTree = parser.parse(json);
		JsonObject itemObject = jsonTree.getAsJsonObject();
		JsonElement name = itemObject.get("name");
		JsonElement icon = itemObject.get("icon");
		JsonElement inventoryType = itemObject.get("inventoryType");
		JsonElement description = itemObject.get("description");
		
		Item i = new Item(itemID, name.getAsString(), ITEMSLOTS[inventoryType.getAsInt()], icon.getAsString(), description.getAsString());
		return i;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String createSimCraftStringForItem(int iLevel) {
		String result = slot +"=" + name.replaceAll(" ", "_").toLowerCase() + ",id=" + id +",ilevel=" + Integer.toString(iLevel);
		return result;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
