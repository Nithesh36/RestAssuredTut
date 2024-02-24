package Inteview;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseTokenPojo{
    @JsonProperty("id")
    public int getId() {
        return this.id; }
    public void setId(int id) {
        this.id = id; }
    int id;
    @JsonProperty("token")
    public String getToken() {
        return this.token; }
    public void setToken(String token) {
        this.token = token; }
    String token;
}

