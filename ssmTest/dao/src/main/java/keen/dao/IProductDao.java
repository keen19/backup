package keen.dao;

import keen.domain.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDao")
public interface IProductDao {

    /**
     * 查询所有产品信息
     * @return
     */
    @Select("select * from product")
    List<Product> findAll();
}
