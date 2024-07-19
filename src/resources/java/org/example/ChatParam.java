
package org.example;

import java.util.List;
import java.util.Map;

public class ChatParam {
    List<Map<String, String>> messages;

    Number temperature = 0.8;

    Number top_p = 0.8;

    private Number penalty_score = 1.0;

    private Boolean stream = false;

    private String system;

    List<String> stop;

    private Boolean disable_search = false;

    private Boolean enable_citation = false;

    int max_output_tokens = 1024;

    String response_format;
    String user_id;

    public List<Map<String, String>> getMessages() {
        return messages;
    }

    public void setMessages(List<Map<String, String>> messages) {
        this.messages = messages;
    }

    public Number getTemperature() {
        return temperature;
    }

    public void setTemperature(Number temperature) {
        this.temperature = temperature;
    }

    public Number getTop_p() {
        return top_p;
    }

    public void setTop_p(Number top_p) {
        this.top_p = top_p;
    }

    public Number getPenalty_score() {
        return penalty_score;
    }

    public void setPenalty_score(Number penalty_score) {
        this.penalty_score = penalty_score;
    }

    public Boolean getStream() {
        return stream;
    }

    public void setStream(Boolean stream) {
        this.stream = stream;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public List<String> getStop() {
        return stop;
    }

    public void setStop(List<String> stop) {
        this.stop = stop;
    }

    public Boolean getDisable_search() {
        return disable_search;
    }

    public void setDisable_search(Boolean disable_search) {
        this.disable_search = disable_search;
    }

    public Boolean getEnable_citation() {
        return enable_citation;
    }

    public void setEnable_citation(Boolean enable_citation) {
        this.enable_citation = enable_citation;
    }

    public int getMax_output_tokens() {
        return max_output_tokens;
    }

    public void setMax_output_tokens(int max_output_tokens) {
        this.max_output_tokens = max_output_tokens;
    }

    public String getResponse_format() {
        return response_format;
    }

    public void setResponse_format(String response_format) {
        this.response_format = response_format;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
