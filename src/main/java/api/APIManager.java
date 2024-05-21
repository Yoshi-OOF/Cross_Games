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

import application.model.Game;
import application.pojo.Result;
import application.pojo.ResultGame;


public class APIManager {

	public void setInformations(Game newGame, String searchedText) throws GameNotFoundException {
		
		String searchedEncoded = "";
		try {
			searchedEncoded = URLEncoder.encode(searchedText, StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
		
		HttpRequest request = HttpRequest.newBuilder()
				//  https://rawg-video-games-database.p.rapidapi.com/games
				.uri(URI.create("https://api.rawg.io/api/games"
						+ "?key=c480f46bdb0847df949871a53b335825"
						+ "&search=" + searchedEncoded
						+ "&search_exact=1"
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
			
			newGame.setName(firstResult.getName());
			newGame.setImageURL(firstResult.getBackgroundImage());
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

}
