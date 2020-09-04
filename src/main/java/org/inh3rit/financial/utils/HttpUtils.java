package org.inh3rit.financial.utils;

import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.stream.Collectors;

public class HttpUtils {
    private static final HttpClient client = HttpClient.newBuilder().build();

    public static HttpResponse get(String uri) throws IOException, InterruptedException {
        return get(uri, null);
    }

    public static HttpResponse get(String uri, Map<String, String> headers) throws IOException, InterruptedException {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create(uri));
        setHeaders(builder, headers);
        HttpRequest request = builder
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public static HttpResponse post(String uri, Map<String, String> headers, Map<String, String> body) throws IOException, InterruptedException {
        HttpRequest.Builder builder = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .POST(HttpRequest.BodyPublishers.ofString(
                        body.entrySet().stream().map(entry -> entry.getKey() + "=" + entry.getValue()).collect(Collectors.joining(",")))
                )
                .uri(URI.create(uri));
        setHeaders(builder, headers);
        HttpRequest request = builder
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    private static void setHeaders(HttpRequest.Builder builder, Map<String, String> headers) {
        if (CollectionUtils.isEmpty(headers)) return;
        headers.forEach((k, v) -> builder.header(k, v));
    }
}
