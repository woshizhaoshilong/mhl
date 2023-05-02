package mhl.service;

import mhl.dao.BillDAO;
import mhl.domain.Bill;

import java.util.List;
import java.util.UUID;

public class BillService {
    private BillDAO billDAO =new BillDAO();
    private MenuService menuService =new MenuService();
    private DiningtableService diningtableService=new DiningtableService();
    //编写点餐的方法
    //1.生成账单
    //2.需要更新对应餐桌状态
    //3.成功的话返回true
    public boolean orderMenu(int menuId,int nums,int diningTableid){
        //生成一个账单号UUID
        String billid = UUID.randomUUID().toString();
        //将账单生成到bill表
        int update = billDAO.update("Insert into bill values(null,?,?,?,?,?,now(),'未结账')",
                billid, menuId, nums, menuService.getMenuById(menuId).getPrice() * nums, diningTableid);
        if(update<=0){
            return false;
        }
            return diningtableService.updateDiningtableState(diningTableid,"就餐中");
    }
    //返回账单
    public List<Bill> list(){
        return billDAO.queryMuLti("select * from bill", Bill.class);
    }
    public boolean hasPayBillByDiningTableId(int diningTabelid){
        Bill bill = billDAO.querySingle("select * from bill where diningtableid=? And state='未结账'Limit 0,1", Bill.class, diningTabelid);
        return bill!=null;
    }
    public boolean payBill(int diningtableid,String paymode){
        int update = billDAO.update("update bill set state =? where diningtableid=? and state='未结账'", paymode, diningtableid);
        if (update<=0){
            return false;
        }
        if (!diningtableService.updateDiningtableToFree(diningtableid)){
            return false;
        }
        return true;
    }
}
