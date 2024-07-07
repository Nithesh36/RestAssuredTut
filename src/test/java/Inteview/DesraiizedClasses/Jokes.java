package Inteview.DesraiizedClasses;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Jokes{
    @JsonProperty("error")
    public boolean getError() {
        return this.error; }
    public void setError(boolean error) {
        this.error = error; }
    boolean error;
    @JsonProperty("category")
    public String getCategory() {
        return this.category; }
    public void setCategory(String category) {
        this.category = category; }
    String category;
    @JsonProperty("type")
    public String getType() {
        return this.type; }
    public void setType(String type) {
        this.type = type; }
    String type;
    @JsonProperty("setup")
    public String getSetup() {
        return this.setup; }
    public void setSetup(String setup) {
        this.setup = setup; }
    String setup;
    @JsonProperty("delivery")
    public String getDelivery() {
        return this.delivery; }
    public void setDelivery(String delivery) {
        this.delivery = delivery; }
    String delivery;
    @JsonProperty("flags")
    public Flags getFlags() {
        return this.flags; }
    public void setFlags(Flags flags) {
        this.flags = flags; }
    Flags flags;
    @JsonProperty("id")
    public int getId() {
        return this.id; }
    public void setId(int id) {
        this.id = id; }
    int id;
    @JsonProperty("safe")
    public boolean getSafe() {
        return this.safe; }
    public void setSafe(boolean safe) {
        this.safe = safe; }
    boolean safe;
    @JsonProperty("lang")
    public String getLang() {
        return this.lang; }
    public void setLang(String lang) {
        this.lang = lang; }
    String lang;
}

