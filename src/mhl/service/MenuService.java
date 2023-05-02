package mhl.service;

import mhl.dao.MenuDAO;
import mhl.domain.Menu;

import java.util.List;

public class MenuService {
    private MenuDAO menuDAO =new MenuDAO();
    public List<Menu> list(){
        return menuDAO.queryMuLti("Select * from menu", Menu.class);
    }
    public Menu getMenuById(int id){
        return menuDAO.querySingle("select * from menu where id =?", Menu.class,id);
    }
}
