package android.hospital.entities.campaign;

/**
 * Created by logan on 06/03/2018.
 */

public class CampaignItemModel {
    protected String name;
    protected Integer redeemed;
    protected Integer available;
    protected Integer sold;

    public CampaignItemModel(String name, Integer redeemed, Integer available, Integer sold) {
        this.name = name;
        this.redeemed = redeemed;
        this.available = available;
        this.sold = sold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRedeemed() {
        return redeemed;
    }

    public void setRedeemed(Integer redeemed) {
        this.redeemed = redeemed;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }
}
