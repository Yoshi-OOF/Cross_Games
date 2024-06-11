package api;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Game;
import pojo.Result;
import pojo.ResultGame;


public class APIManager {

	public static String imgUrl;

	public static String gameName;

	public static void setInformations(Game newGame, String searchedText) throws GameNotFoundException {
		
		String searchedEncoded = "";
		try {
			searchedEncoded = URLEncoder.encode(searchedText, StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
		
		HttpRequest request = HttpRequest.newBuilder()
				//  https://rawg-video-games-database.p.rapidapi.com/games
				.uri(URI.create("https://api.rawg.io/api/games"
						+ "?key=bed0e2440362497d86cfd2b400a1fd31"
						+ "&search=" + searchedEncoded
						+ "&search_exact=5"
						+ "&page_size=1"))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (InterruptedException|IOException e) {
			Thread.currentThread().interrupt();
			return;
		}

		System.out.println(response.body());

		//String responsebody = "{\"count\":174,\"next\":\"https://api.rawg.io/api/games?key=bed0e2440362497d86cfd2b400a1fd31&page=2&page_size=1&search=Zelda&search_exact=1\",\"previous\":null,\"results\":[{\"slug\":\"zelda\",\"name\":\"!Zelda\",\"playtime\":0,\"platforms\":[{\"platform\":{\"id\":171,\"name\":\"Web\",\"slug\":\"web\"}}],\"stores\":[{\"store\":{\"id\":9,\"name\":\"itch.io\",\"slug\":\"itch\"}}],\"released\":\"2020-02-19\",\"tba\":false,\"background_image\":\"https://media.rawg.io/media/screenshots/efa/efa59bd0fed6969e7175dee1a6238c2d.jpg\",\"rating\":0.0,\"rating_top\":0,\"ratings\":[],\"ratings_count\":0,\"reviews_text_count\":0,\"added\":0,\"added_by_status\":null,\"metacritic\":null,\"suggestions_count\":19,\"updated\":\"2020-02-21T03:16:12\",\"id\":413428,\"score\":\"11.116092\",\"clip\":null,\"tags\":[{\"id\":45,\"name\":\"2D\",\"slug\":\"2d\",\"language\":\"eng\",\"games_count\":85731,\"image_background\":\"https://media.rawg.io/media/games/14a/14a83c56ff668baaced6e8c8704b6391.jpg\"},{\"id\":260,\"name\":\"GameMaker\",\"slug\":\"gamemaker\",\"language\":\"eng\",\"games_count\":5511,\"image_background\":\"https://media.rawg.io/media/screenshots/ee4/ee45c49e1507ef9f8ec85219d655aa00.jpg\"},{\"id\":61,\"name\":\"Top-Down\",\"slug\":\"top-down\",\"language\":\"eng\",\"games_count\":8964,\"image_background\":\"https://media.rawg.io/media/games/f3e/f3eec35c6218dcfd93a537751e6bfa61.jpg\"},{\"id\":867,\"name\":\"zelda\",\"slug\":\"zelda\",\"language\":\"eng\",\"games_count\":297,\"image_background\":\"https://media.rawg.io/media/screenshots/203/203b13cab5edb554e958e70ab243415d.jpg\"}],\"esrb_rating\":null,\"user_game\":null,\"reviews_count\":0,\"community_rating\":0,\"saturated_color\":\"0f0f0f\",\"dominant_color\":\"0f0f0f\",\"short_screenshots\":[{\"id\":-1,\"image\":\"https://media.rawg.io/media/screenshots/efa/efa59bd0fed6969e7175dee1a6238c2d.jpg\"},{\"id\":2295873,\"image\":\"https://media.rawg.io/media/screenshots/efa/efa59bd0fed6969e7175dee1a6238c2d.jpg\"}],\"parent_platforms\":[{\"platform\":{\"id\":14,\"name\":\"Web\",\"slug\":\"web\"}}],\"genres\":[{\"id\":3,\"name\":\"Adventure\",\"slug\":\"adventure\"}]}],\"user_platforms\":false}\n";

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		ResultGame result;
		try {
			result = objectMapper.readValue(response.body(), ResultGame.class);
			if (result.getResults().length == 0) {
				throw new GameNotFoundException();
			}
			Result firstResult = result.getResults()[0];
			System.out.println(firstResult.getBackgroundImage());

			imgUrl = firstResult.getBackgroundImage();
			gameName= firstResult.getName();

			newGame.setName(firstResult.getName());
			newGame.setImageURL(firstResult.getBackgroundImage());
			newGame.setDescription(firstResult.getDescription());


		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}


}
