package Inteview.DesraiizedClasses;

import com.fasterxml.jackson.annotation.JsonProperty;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class Flags {
    @JsonProperty("nsfw")
    public boolean getNsfw() {
        return this.nsfw;
    }

    public void setNsfw(boolean nsfw) {
        this.nsfw = nsfw;
    }

    boolean nsfw;

    @JsonProperty("religious")
    public boolean getReligious() {
        return this.religious;
    }

    public void setReligious(boolean religious) {
        this.religious = religious;
    }

    boolean religious;

    @JsonProperty("political")
    public boolean getPolitical() {
        return this.political;
    }

    public void setPolitical(boolean political) {
        this.political = political;
    }

    boolean political;

    @JsonProperty("racist")
    public boolean getRacist() {
        return this.racist;
    }

    public void setRacist(boolean racist) {
        this.racist = racist;
    }

    boolean racist;

    @JsonProperty("sexist")
    public boolean getSexist() {
        return this.sexist;
    }

    public void setSexist(boolean sexist) {
        this.sexist = sexist;
    }

    boolean sexist;

    @JsonProperty("explicit")
    public boolean getExplicit() {
        return this.explicit;
    }

    public void setExplicit(boolean explicit) {
        this.explicit = explicit;
    }

    boolean explicit;
}
