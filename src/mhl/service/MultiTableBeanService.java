package mhl.service;

import mhl.dao.MultiTableBeanDAO;
import mhl.domain.MultiTableBean;

import java.util.List;

public class MultiTableBeanService {
     private MultiTableBeanDAO multiiTableBeanDAO= new MultiTableBeanDAO();
     public List<MultiTableBean> list2(){
         return multiiTableBeanDAO.queryMuLti("SELECT bill.*,menu.`name` FROM menu,bill WHERE bill.menuid=menu.id", MultiTableBean.class);
     }
}
