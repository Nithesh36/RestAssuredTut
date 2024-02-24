package Inteview;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmailPojo{
    String password;
    String email;
    @JsonProperty("email")
    public String getEmail() {
        return this.email; }
    public void setEmail(String email) {
        this.email = email; }

    @JsonProperty("password")
    public String getPassword() {
        return this.password; }

    public void setPassword(String password) {
        this.password = password; }

}

