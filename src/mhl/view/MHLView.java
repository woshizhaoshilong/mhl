package mhl.view;

import mhl.domain.*;
import mhl.service.*;
import mhl.utils.Utility;

import java.util.List;

public class MHLView {
    boolean loop =true;
    String key ="";
    //定义EmployeeService 属性对象
    EmployeeService employeeService=new EmployeeService();
    DiningtableService diningtableService =new DiningtableService();
    MenuService menuService=new MenuService();
    BillService billService = new BillService();
    MultiTableBeanService multiTableBeanService=new MultiTableBeanService();

    public static void main(String[] args) {
        new MHLView().mainmenu();

    }
    //完成结账
    public void paybill(){
        System.out.println("============结账服务============");
        System.out.println("请选择要结账的餐桌号:(-1退出)");
        int diningTableId = Utility.readNumber();
        if (diningTableId==-1){
            System.out.println("============取消结账============");
            return;
        }
        if (!billService.hasPayBillByDiningTableId(diningTableId)){
            System.out.println("============该餐桌无账单或该餐桌不存在============");
            return;
        }

        System.out.println("结账方式(现金/微信/支付宝):");
        String paymode = Utility.readString();
        if (!(paymode.equals("现金")||paymode.equals("微信")||paymode.equals("支付宝"))){
            System.out.println("============您输入有误系统默认取消结账============");
            return;
        }

        System.out.println("请确认是否结账Y/N");
        char key = Utility.readConfirmSelection();
        if (key=='Y'){
            if(billService.payBill(diningTableId,paymode)){
                System.out.println("============您的账单已支付============");
            }
            else {
                System.out.println("============结账未成功============");
            }

        }else {
            System.out.println("============取消结账============");
        }
    }

    //生成账单
    public void listbill(){
        List<MultiTableBean> multiTableBeans = multiTableBeanService.list2();
        System.out.println("\n编号\t\t菜品号\t\t菜品量\t\t金额\t\t桌号\t\t日期\t\t\t\t\t\t状态\t\t\t菜名");
        for (MultiTableBean bill : multiTableBeans) {
            System.out.println(bill);
        }
        System.out.println("显示完毕");

    }
    public void orderMenu(){
        System.out.println("============点餐服务============");
        System.out.println("请输入点餐的桌号(-1退出):");
        int orderDiningTableId = Utility.readNumber();
        if (orderDiningTableId==-1){
            System.out.println("============取消点餐============");
            return;
        }
        System.out.println("请输入点餐的菜品号(-1退出):");
        int orderMenuId = Utility.readNumber();
        if (orderMenuId==-1){
            System.out.println("============取消点餐============");
            return;
        }
        System.out.println("请输入点餐的菜品量(-1退出):");
        int orderNums = Utility.readNumber();
        if (orderNums==-1){
            System.out.println("============取消点餐============");
            return;
        }
        //验证餐桌号是否存在
        Diningtable diningtable = diningtableService.getDiningtableById(orderDiningTableId);
        if (diningtable==null){
            System.out.println("============您输入的餐桌不存在============");
            return;
        }
       //验证菜品是否存在
        Menu menu = menuService.getMenuById(orderMenuId);
        if (menu==null){
            System.out.println("============您输入的菜品不存在============");
            return;
        }
        if(billService.orderMenu(orderMenuId,orderNums,orderDiningTableId)){
            System.out.println("============点餐成功============");
        }else {
            System.out.println("点餐失败");
        }


    }
    public void  listDiningtable(){
        List<Diningtable> list = diningtableService.list();
        System.out.println("\n 餐桌编号\t\t餐桌状态");
        for (Diningtable diningtable : list) {
            System.out.println(diningtable);
        }
    }
    public void orderDiningTable(){
        System.out.println("============预定餐桌============");
        System.out.println("请输入要预定的餐桌号(输入-1退出)");
        int orderId = Utility.readNumber();
        if (orderId==-1){
            System.out.println("==========取消预定餐桌==========");
            return;
        }
        System.out.println("确认是否预定餐桌Y/N");
        char key = Utility.readConfirmSelection();
        if (key == 'Y'){
            Diningtable diningtable = diningtableService.getDiningtableById(orderId);
            if (diningtable==null){
                System.out.println("==========该餐桌不存在===========");
                return;
            }
            if (!("空".equals(diningtable.getState()))){
                System.out.println("=============该餐桌非空闲状态==================");
                return;
            }
            System.out.println("请输入预定人的名字：");
            String ordername = Utility.readString();
            System.out.println("请输入预定人的电话:");
            String ordertel = Utility.readString();
            if (diningtableService.orderDiningtable(orderId,ordername,ordertel)){
                System.out.println("预定成功~");
            }
            else{
                System.out.println("预定失败");
            }

        }else {
            System.out.println("==========取消预定餐桌==========");
        }
    }
    public void listmenu(){
        List<Menu> list = menuService.list();
        System.out.println("\n菜品编号\t\t菜品名称\t\t菜品类型\t\t菜品价格");
        for (Menu menu : list) {
            System.out.println(menu);
        }
        System.out.println("显示完毕");
    }

    public void mainmenu(){
        while (loop){
            System.out.println("======================满汉楼=====================");
            System.out.println("\t\t 1 登录满汉楼");
            System.out.println("\t\t 2 退出满汉楼");
            System.out.println("请输入你的选择");
            key=Utility.readString();
            switch (key){
                case "1":
                    System.out.println("登录满汉楼");
                    System.out.println("请输入员工号");
                   String empid= Utility.readString();
                    System.out.println("请输入密码");
                    String pwd =Utility.readString();
                    Employee employee = employeeService.getEmployeeByIdAndPwd(empid, pwd);
                    //到数据库去判断
                    if (employee!=null){
                        System.out.println("================登录"+employee.getName()+"成功================");
                        //显示二级菜单
                        while (loop){
                            System.out.println("================满汉楼二级菜单================");
                            System.out.println("\t\t 1 显示餐桌状态");
                            System.out.println("\t\t 2 预定餐桌");
                            System.out.println("\t\t 3 显示所有菜品");
                            System.out.println("\t\t 4 点餐服务");
                            System.out.println("\t\t 5 查看账单");
                            System.out.println("\t\t 6 结账");
                            System.out.println("\t\t 9 退出");
                            key=Utility.readString();
                            switch (key){
                                case "1":
                                   listDiningtable();
                                    System.out.println("=========显示结束=============");
                                    break;
                                case "2":
                                    orderDiningTable();
                                    break;
                                case "3":
                                   listmenu();
                                    break;
                                case "4":
                                    orderMenu();
                                    break;
                                case "5" :
                                  listbill();
                                    break;
                                case "6":
                                    paybill();
                                case "9":
                                    loop=false;
                                    System.out.println("退出菜单");
                                    break;
                                default:
                                    System.out.println("输入有误请重新输入");
                            }
                        }
                    }
                    else {
                        System.out.println("===============登录失败=================");
                    }
                    break;
                case "2":
                    loop=false;
                    System.out.println("退出满汉楼");
                    break;
                default:
                    System.out.println("输入有误请重新输入");
            }
        }
    }
}
