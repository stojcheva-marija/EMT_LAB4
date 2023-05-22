package mk.ukim.finki.emt.ordermanagment.xport.client;

import mk.ukim.finki.emt.ordermanagment.domain.valueObjects.Item;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class ItemClient {

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public ItemClient(@Value("${app-item-catalog.url}") String serverUrl){
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<Item> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/item").build().toUri(),
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Item>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}
