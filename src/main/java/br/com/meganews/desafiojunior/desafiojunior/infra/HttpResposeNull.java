package br.com.meganews.desafiojunior.desafiojunior.infra;

import br.com.meganews.desafiojunior.desafiojunior.exceptions.RemoteConnectionException;

import javax.net.ssl.SSLSession;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class HttpResposeNull implements HttpResponse<String> {
    @Override
    public int statusCode() {
        throw new RemoteConnectionException();
    }

    @Override
    public HttpRequest request() {
        throw new RemoteConnectionException();
    }

    @Override
    public Optional<HttpResponse<String>> previousResponse() {
        throw new RemoteConnectionException();
    }

    @Override
    public HttpHeaders headers() {
        throw new RemoteConnectionException();
    }

    @Override
    public String body() {
        throw new RemoteConnectionException();
    }

    @Override
    public Optional<SSLSession> sslSession() {
        throw new RemoteConnectionException();
    }

    @Override
    public URI uri() {
        throw new RemoteConnectionException();
    }

    @Override
    public HttpClient.Version version() {
        throw new RemoteConnectionException();
    }
}
