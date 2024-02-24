package Inteview.DesraiizedClasses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Pojo {
    @JsonProperty("id")
    public int getId() {
        return this.id; }
    public void setId(int id) {
        this.id = id; }
    int id;
    @JsonProperty("email")
    public String getEmail() {
        return this.email; }
    public void setEmail(String email) {
        this.email = email; }
    String email;
    @JsonProperty("first_name")
    public String getFirst_name() {
        return this.first_name; }
    public void setFirst_name(String first_name) {
        this.first_name = first_name; }
    String first_name;
    @JsonProperty("last_name")
    public String getLast_name() {
        return this.last_name; }
    public void setLast_name(String last_name) {
        this.last_name = last_name; }
    String last_name;
    @JsonProperty("avatar")
    public String getAvatar() {
        return this.avatar; }
    public void setAvatar(String avatar) {
        this.avatar = avatar; }
    String avatar;
}


