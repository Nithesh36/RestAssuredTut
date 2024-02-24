package Inteview.DesraiizedClasses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class ListData{
    @JsonProperty("data")
    public ArrayList<Pojo> getData() {
        return this.data; }
    public void setData(ArrayList<Pojo> data) {
        this.data = data; }
    ArrayList<Pojo> data;
}
