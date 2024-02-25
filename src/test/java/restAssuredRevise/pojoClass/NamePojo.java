package restAssuredRevise.pojoClass;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NamePojo {
    // import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root[] root = om.readValue(myJsonString, Root[].class); */
    int id;
    Object name;

    @JsonProperty("name")
    public Object getName() {
        return this.name;
    }

    public void setName(Object name) {
        this.name = name;
    }


    @JsonProperty("id")
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
