package cafefashionsociety.structureliteraturemeadow.apicontroller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import cafefashionsociety.structureliteraturemeadow.model.Quote;
import cafefashionsociety.structureliteraturemeadow.service.QuoteService;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class QuoteRestRequest {

    @Autowired
    QuoteService quoteService;

    public void NewQuoteRequest() throws IOException {
        String url = "";
        RequestEntity req = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(req, String.class);
        try (InputStream is = new ByteArrayInputStream(resp.getBody().getBytes())) {
            JsonReader reader = Json.createReader(is);
            JsonArray quoteArray = reader.readArray();
            LinkedList<Quote> quotes = new LinkedList<>();
            for (int i = 0; i < quoteArray.size(); i++) {
                JsonObject o = quoteArray.getJsonObject(i);
                Quote newquote = new Quote("q" + String.valueOf(i), o.getString("q"), o.getString("a"));
                quotes.add(newquote);
            }
            quoteService.saveAll(quotes);
        } catch (IOException e) {

        }
    }

}
