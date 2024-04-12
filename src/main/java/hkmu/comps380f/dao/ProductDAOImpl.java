//package hkmu.comps380f.dao;
//
//import hkmu.comps380f.model.Product;
//import jakarta.annotation.Resource;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProductDAOImpl implements ProductDAO {
//    private List<Product> products;
//    @Resource
//    private ProductDAO productDAO;
//
//    public ProductDAOImpl() {
//        products = new ArrayList<>();
//    }
//
//    public String getProductDAO() {
//        return productDAO;
//    }
//
//    public void setProductDAO(String productDAO) {
//        this.productDAO = productDAO;
//    }
//
//    @Override
//    public List<Product> getAllProducts() {
//        return products;
//    }
//
//    @Override
//    public Product getProductById(String id) {
//        for (Product product : products) {
//            if (product.getId().equals(id)) {
//                return product;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public void addProduct(Product product) {
//        products.add(product);
//    }
//
//    @Override
//    public void updateProduct(Product product) {
//        for (int i = 0; i < products.size(); i++) {
//            if (products.get(i).getId().equals(product.getId())) {
//                products.set(i, product);
//                break;
//            }
//        }
//    }
//
//    @Override
//    public void deleteProduct(String id) {
//        for (Product product : products) {
//            if (product.getId().equals(id)) {
//                products.remove(product);
//                break;
//            }
//        }
//    }
//}