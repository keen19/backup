package dao;

import domain.Items;

import java.sql.SQLException;
import java.util.List;

public interface Dao {
    public List<Items> findall() throws Exception;
}
