package org.example;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestStreamElementType;

@RegisterRestClient(baseUri = "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop")
public interface MyRemoteService {

    @POST
    @Path("/chat/ernie-4.0-turbo-8k")
    @RestStreamElementType(MediaType.APPLICATION_JSON)
    Uni<String> doSseChartUni(ChatParam param, @HeaderParam("X-Request-ID") String requestId, @QueryParam("access_token") String token);

    @POST
    @Path("/chat/ernie-4.0-turbo-8k")
    @RestStreamElementType(MediaType.APPLICATION_JSON)
    Multi<String> doSseChartMulti(ChatParam param, @HeaderParam("X-Request-ID") String requestId,@QueryParam("access_token") String token);
}
