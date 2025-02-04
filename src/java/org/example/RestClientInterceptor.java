package org.example;

import jakarta.ws.rs.ConstrainedTo;
import jakarta.ws.rs.RuntimeType;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.*;

import java.io.IOException;

@Provider
@ConstrainedTo(RuntimeType.CLIENT)
public class RestClientInterceptor implements ReaderInterceptor, WriterInterceptor {

//    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
        /*
         ******* Issue and Question 1 *******
         * When I request http://localhost:8080/ai/chart-uni,I can get response headers correctly;
         * But request http://localhost:8080/ai/chart-multi,headers will be empty array[].
         */
        MultivaluedMap<String, String> headers = context.getHeaders();
        System.out.println(headers);

        Object ret = context.proceed();

        //TODO save Response body to MongoDB;
        //*****   Question 2   *****: How can I get the request Header "X-Request-ID"??? Should I use ThreadLocal?

        return ret;
    }

    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
        Object entity = context.getEntity();

        //TODO save ChatParam to MongoDB, I will use Event+ObservesAsync
        if (entity instanceof ChatParam) {
            String requestId = (String) context.getHeaders().getFirst("X-Request-ID");
//            ReqLogEvent<Object> reqLogEvent = ReqLogEvent.builder().requestId(requestId)
//                    .reqParam(entity).build();
//            myEvent.fireAsync(reqLogEvent);
        }

//        threadLocal.set(requestId);

        context.proceed();
    }
}
