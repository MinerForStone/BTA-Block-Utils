package minerforstone.blockutils.render;

import com.google.common.io.Resources;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ParseJson {
	public static void main(String[] args) {
		parse();
	}
	public static void parse() {
		URL resource = ParseJson.class.getResource("/assets/blockutils/models/block/cross.json");

		String fileRead = null;
		Gson gson = new Gson();

		try {
			assert resource != null;
			fileRead = Resources.toString(resource, StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		Map jsonMap = gson.fromJson(fileRead, Map.class);

		Map textures = (Map)jsonMap.get("textures");

		System.out.println(textures.get("particle"));
	}
}
