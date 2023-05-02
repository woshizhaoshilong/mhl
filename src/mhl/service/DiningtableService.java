package mhl.service;

import mhl.dao.DiningtableDAO;
import mhl.domain.Diningtable;

import java.util.List;

public class DiningtableService {
        private DiningtableDAO diningtableDAO=new DiningtableDAO();
        public List<Diningtable> list(){
                return diningtableDAO.queryMuLti("select id,state from diningtable", Diningtable.class);
        }
        public Diningtable getDiningtableById(int id){
               return diningtableDAO.querySingle("select * from diningtable where id=?", Diningtable.class,id);
        }
        public boolean orderDiningtable(int id,String orderName,String orderTel){
                int update = diningtableDAO.update("update diningtable set state='已经预定', ordername =?,orderTel=? where id =?", orderName, orderTel,id);
                return update>0;
        }
        //需要提供一个更新餐桌状态方法
        public boolean updateDiningtableState(int id,String state){
                int update = diningtableDAO.update("update diningtable set state=? where id=?", state, id);
                return update>0;
        }
        public boolean updateDiningtableToFree(int id){
                int update = diningtableDAO.update("update diningtable set state='空',ordername='',orderTel='' where id=?",  id);
                return update>0;
        }

}
