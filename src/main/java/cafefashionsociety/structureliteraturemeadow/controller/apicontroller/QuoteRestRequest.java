package cafefashionsociety.structureliteraturemeadow.controller.apicontroller;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import cafefashionsociety.structureliteraturemeadow.model.Quote;
import cafefashionsociety.structureliteraturemeadow.service.QuoteService;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@Component
public class QuoteRestRequest {

    @Autowired
    QuoteService quoteService;

    Logger logger = LoggerFactory.getLogger(QuoteRestRequest.class);

    public void NewQuoteRequest() throws IOException {
        String url = "https://zenquotes.io/api/quotes";
        RequestEntity req = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
        RestTemplate template = new RestTemplate();
        logger.info("template created");
        ResponseEntity<String> resp = template.exchange(req, String.class);
        logger.info("response exchanged");
        try (InputStream is = new ByteArrayInputStream(resp.getBody().getBytes())) {
            JsonReader reader = Json.createReader(is);
            JsonArray quoteArray = reader.readArray();
            LinkedList<Quote> quotes = new LinkedList<>();
            for (int i = 0; i < quoteArray.size(); i++) {
                JsonObject o = quoteArray.getJsonObject(i);
                Quote newquote = new Quote("q" + String.valueOf(i), o.getString("q"), o.getString("a"));
                quotes.add(newquote);
            }
            logger.info("quotes added");
            quoteService.saveAll(quotes);
            logger.info("quotes saved");
        } catch (IOException e) {
            logger.info("quote request failed");
        }
    }

    public void LocalNewRequest() throws IOException {
        LinkedList<Quote> quotes = new LinkedList<>();
        String file = "src/main/resources/static/motivationalquotes.json";
        try (InputStream is = new FileInputStream(file)) {
            JsonReader reader = Json.createReader(is);
            JsonArray quoteArray = reader.readArray();
            for (int i = 0; i < quoteArray.size(); i++) {
                JsonObject o = quoteArray.getJsonObject(i);
                Quote newquote = new Quote("q" + String.valueOf(i), o.getString("q"), o.getString("a"));
                quotes.add(newquote);
            }
            quoteService.saveAll(quotes);
            logger.info("quotes saved");
        } catch (IOException e) {
            logger.info("quote request failed");
        }
    }

}
