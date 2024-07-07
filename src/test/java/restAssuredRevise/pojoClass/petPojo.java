package restAssuredRevise.pojoClass;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class petPojo extends  Root1 {
}

class Tag1{
    @JsonProperty("id")
    public int getId() {
        return this.id; }
    public void setId(int id) {
        this.id = id; }
    int id;
    @JsonProperty("name")
    public String getName() {
        return this.name; }
    public void setName(String name) {
        this.name = name; }
    String name;
}

