package mhl.domain;

import java.util.Date;

/**
 * 这是一个javabean可以和多张表对应
 * */
public class MultiTableBean {
    private Integer id;
    private String billid;
    private Integer menuid;
    private Integer nums;
    private Double money;
    private Integer diningTableId;
    private Date billdate;
    private String state;
    private String name;
    public MultiTableBean(){}

    public MultiTableBean(Integer id, String billid, Integer menuid, Integer nums, Double money, Integer diningTableId, Date billdate, String state, String name) {
        this.id = id;
        this.billid = billid;
        this.menuid = menuid;
        this.nums = nums;
        this.money = money;
        this.diningTableId = diningTableId;
        this.billdate = billdate;
        this.state = state;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillid() {
        return billid;
    }

    public void setBillid(String billid) {
        this.billid = billid;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getDiningTableId() {
        return diningTableId;
    }

    public void setDiningTableId(Integer diningTableId) {
        this.diningTableId = diningTableId;
    }

    public Date getBilldate() {
        return billdate;
    }

    public void setBilldate(Date billdate) {
        this.billdate = billdate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return  id +
                "\t\t"+menuid  +"\t\t\t"+ nums +"\t\t\t"+ money +
                "\t"+diningTableId +
                "\t\t"+ billdate +
                "\t\t"+ state
                + "\t\t"+ name;
    }

}
