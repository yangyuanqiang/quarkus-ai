
package org.example;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.RestStreamElementType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Path("/ai")
public class ExampleResource {

    @RestClient
    MyRemoteService myRemoteService;

    @Context
    public HttpHeaders httpHeaders;

    private static final String TOKEN_TMP = "24.a338d0b629343d7992b2fcb77386a809.2592000.1723945101.282335-55095548";

    @GET
    @Path("chart-uni")
    @RestStreamElementType(MediaType.APPLICATION_JSON)
    public Uni<String> chartUni() {
        String requestId = httpHeaders.getHeaderString("X-Request-ID");
        if (requestId == null) {
            requestId = UUID.randomUUID().toString();
        }

        ChatParam chatParam = this.buildParam();
        return myRemoteService.doSseChartUni(chatParam, requestId, TOKEN_TMP);
    }

    @GET
    @Path("chart-multi")
    @RestStreamElementType(MediaType.APPLICATION_JSON)
    public Multi<String> chartMulti() {
        String requestId = httpHeaders.getHeaderString("X-Request-ID");
        if (requestId == null) {
            requestId = UUID.randomUUID().toString();
        }

        ChatParam chatParam = this.buildParam();
        return myRemoteService.doSseChartMulti(chatParam, requestId, TOKEN_TMP);
    }

    private ChatParam buildParam() {
        Map<String, String> msg = new HashMap<>();
        msg.put("content", "Write a 1000-word news article about OpenAI");
        msg.put("role", "user");

        ArrayList<Map<String, String>> arrayList = new ArrayList<>();
        arrayList.add(msg);

        ChatParam param = new ChatParam();
        param.max_output_tokens = 1500;
        param.messages = arrayList;
        param.setStream(true);

        return param;
    }
}
