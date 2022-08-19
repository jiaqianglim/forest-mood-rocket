package cafefashionsociety.structureliteraturemeadow.runner;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cafefashionsociety.structureliteraturemeadow.model.Quote;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class GetQuotesFromAPIService {

    @Value("spring.getquotes.url")
    private String url;

    public ResponseEntity<String> getQuotesJson(String url) {

        RequestEntity<Void> req = RequestEntity.get(this.url).accept(MediaType.APPLICATION_JSON).build();
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(req, String.class);
        return resp;
    }

    public List<Quote> readQuotesJson(ResponseEntity<String> resp) throws IOException {

        List<Quote> quotes = new LinkedList<>();
        try (InputStream in = new ByteArrayInputStream(resp.getBody().getBytes())) {
            JsonReader reader = Json.createReader(in);
            JsonArray data = reader.readArray();
            for (int i = 0; i < data.size(); i++) {
                JsonObject quoteData = data.getJsonObject(i);
                Quote quote = new Quote(quoteData.getString("q"), quoteData.getString("a"));
                quotes.add(quote);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return quotes;
    }

}
