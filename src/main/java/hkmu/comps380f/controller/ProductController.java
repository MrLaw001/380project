//package hkmu.comps380f.controller;
//
//import hkmu.comps380f.dao.ProductDAO;
//import hkmu.comps380f.dao.ProductDAOImpl;
//import hkmu.comps380f.model.Product;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//    @Controller
//    @RequestMapping("/products")
//    public class ProductController {
//        private ProductDAO productDAO;
//
//        public ProductController(ProductDAO productDAO) {
//            this.productDAO = productDAO;
//        }
//
//        @GetMapping("/list")
//        public String listProducts(Model model) {
//            List<Product> products = productDAO.getAllProducts();
//            model.addAttribute("products", products);
//            return "productList";
//        }
//
//        @GetMapping("/add")
//        public String showAddProductForm(Model model) {
//            Product product = new Product();
//            model.addAttribute("product", product);
//            return "addProduct";
//        }
//
//        @PostMapping("/add")
//        public String addProduct(@ModelAttribute("product") Product product) {
//            productDAO.addProduct(product);
//            return "redirect:/products/list";
//        }
//
//        @GetMapping("/edit/{id}")
//        public String showEditProductForm(@PathVariable("id") String id, Model model) {
//            Product product = productDAO.getProductById(id);
//            model.addAttribute("product", product);
//            return "editProduct";
//        }
//
//        @PostMapping("/edit")
//        public String updateProduct(@ModelAttribute("product") Product product) {
//            productDAO.updateProduct(product);
//            return "redirect:/products/list";
//        }
//
//        @GetMapping("/delete/{id}")
//        public String deleteProduct(@PathVariable("id") String id) {
//            productDAO.deleteProduct(id);
//            return "redirect:/products/list";
//        }
//    }
//
