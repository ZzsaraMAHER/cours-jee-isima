package fr.tp.isima.services;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;

import fr.tp.isima.entities.Quote;

public class HttpQuoteService implements QuoteService {

    private final String origin;

    public HttpQuoteService(String origin) {
        this.origin = origin;
    }

    @Override
    public Quote findRandomQuote(String user) {
        try {
            final HttpUriRequest uriReq = RequestBuilder.get().setUri(origin + "/service/findRandomQuote").addParameter("name", "Anonymous").build();
            final HttpClient client = HttpClientBuilder.create().build();
            final HttpResponse resp = client.execute(uriReq);
            // Cette ecriture permet de fermer correctement le flux input stream
            // Introduit en Java 7
            try (InputStream is = resp.getEntity().getContent()) {
                final String out = IOUtils.toString(is);
                final Gson gson = new Gson();
                return gson.fromJson(out, Quote.class);
            }
        } catch (final IOException e) {
            throw new QuoteServiceFailureException(e);
        }
    }

}
