package keen.service;

import keen.domain.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll() throws Exception;
}
