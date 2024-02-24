package Inteview.DesraiizedClasses;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Root{
    @JsonProperty("page")
    public int getPage() {
        return this.page; }
    public void setPage(int page) {
        this.page = page; }
    int page;
    @JsonProperty("per_page")
    public int getPer_page() {
        return this.per_page; }
    public void setPer_page(int per_page) {
        this.per_page = per_page; }
    int per_page;
    @JsonProperty("total")
    public int getTotal() {
        return this.total; }
    public void setTotal(int total) {
        this.total = total; }
    int total;
    @JsonProperty("total_pages")
    public int getTotal_pages() {
        return this.total_pages; }
    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages; }
    int total_pages;
    @JsonProperty("data")
    public ArrayList<Pojo> getData() {
        return this.data; }
    public void setData(ArrayList<Pojo> data) {
        this.data = data; }
    ArrayList<Pojo> data;
    @JsonProperty("support")
    public Support getSupport() {
        return this.support; }
    public void setSupport(Support support) {
        this.support = support; }
    Support support;
}

