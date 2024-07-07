package restAssuredRevise.pojoClass;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Root{
    @JsonProperty("id")
    public int getId() {
        return this.id; }
    public void setId(int id) {
        this.id = id; }
    int id;
    @JsonProperty("category")
    public Category getCategory() {
        return this.category; }
    public void setCategory(Category category) {
        this.category = category; }
    Category category;
    @JsonProperty("name")
    public String getName() {
        return this.name; }
    public void setName(String name) {
        this.name = name; }
    String name;
    @JsonProperty("photoUrls")
    public ArrayList<String> getPhotoUrls() {
        return this.photoUrls; }
    public void setPhotoUrls(ArrayList<String> photoUrls) {
        this.photoUrls = photoUrls; }
    ArrayList<String> photoUrls;
    @JsonProperty("tags")
    public ArrayList<Tag> getTags() {
        return this.tags; }
    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags; }
    ArrayList<Tag> tags;
    @JsonProperty("status")
    public String getStatus() {
        return this.status; }
    public void setStatus(String status) {
        this.status = status; }
    String status;
}

