/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package htmlparser.components;

/**
 *
 * @author Ярослав
 */
public class DetailComponent {
    private String articul;
    private String name;
    private String producer;
    private double price;
    private String analogs;
    private String using;
    private String available;
    
    
    public DetailComponent(String articul, String name, String producer, double cost,String available, String analogs, String using){
        this.articul=articul;
        this.available=available;
        this.name=name;
        this.producer=producer;
        this.price=cost;
        this.analogs=analogs;
        this.using=using;
    }

    /**
     * @return the articul
     */
    public String getArticul() {
        return articul;
    }

    /**
     * @param articul the articul to set
     */
    public void setArticul(String articul) {
        this.articul = articul;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the producer
     */
    public String getProducer() {
        return producer;
    }

    /**
     * @param producer the producer to set
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }

    /**
     * @return the cost
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the analogs
     */
    public String getAnalogs() {
        return analogs;
    }

    /**
     * @param analogs the analogs to set
     */
    public void setAnalogs(String analogs) {
        this.analogs = analogs;
    }

    /**
     * @return the using
     */
    public String getUsing() {
        return using;
    }

    /**
     * @param using the using to set
     */
    public void setUsing(String using) {
        this.using = using;
    }

    /**
     * @return the available
     */
    public String getAvailable() {
        return available;
    }

    /**
     * @param available the available to set
     */
    public void setAvailable(String available) {
        this.available = available;
    }
}
