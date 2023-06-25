package ar.com.itau.event.adapter.rest;

import ar.com.itau.event.config.Config;
import brave.Tracer;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class HeadersProvider {

    private static final String TRACE_ID_HEADER = "traceId";

    private final Config config;
    private final Tracer tracer;

    public HeadersProvider(final Config config, final Tracer tracer) {
        this.config = config;
        this.tracer = tracer;
    }

    public HttpHeaders get() {
        final HttpHeaders headers = new HttpHeaders();
        final String traceId = tracer.currentSpan().context().traceIdString();
        headers.set(TRACE_ID_HEADER, traceId);
        return headers;
    }

}
