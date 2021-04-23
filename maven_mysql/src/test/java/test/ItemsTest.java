package test;

import dao.Dao;
import dao.DaoImpl;
import domain.Items;
import org.junit.Test;

import java.util.List;

public class ItemsTest {
    @Test
    public void findAll() throws Exception{
        Dao dao=new DaoImpl();
        List<Items> list=dao.findall();
        for (Items items : list) {
            System.out.println(items.getId()+":"+items.getName());

        }
    }
}
