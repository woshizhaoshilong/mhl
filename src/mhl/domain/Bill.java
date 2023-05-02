package mhl.domain;

import java.util.Date;

/**
 * CREATE TABLE bill(
 * id int PRIMARY KEY auto_increment,
 * billid VARCHAR(50) NOT NULL DEFAULT'',
 * menuid int NOT NULL DEFAULT 0,
 * nums INT NOT NULL DEFAULT 0,
 * money DOUBLE NOT NULL DEFAULT 0,
 * diningTableId int not NULL DEFAULT 0,
 * billDate DATETIME NOT NULL,
 * state VARCHAR(50) NOT NULL DEFAULT'')CHARSET=utf8;
 * */
public class Bill {
    private Integer id;
    private String billid;
    private Integer menuid;
    private Integer nums;
    private Double money;
    private Integer diningTableId;
    private Date billdate;
    private String state;
    public Bill(){}

    public Bill(Integer id, String billid, Integer menuid, Integer nums, Double money, Integer diningTableId, Date billdate, String state) {
        this.id = id;
        this.billid = billid;
        this.menuid = menuid;
        this.nums = nums;
        this.money = money;
        this.diningTableId = diningTableId;
        this.billdate = billdate;
        this.state = state;
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
                "\t\t"+ state ;
    }
}
