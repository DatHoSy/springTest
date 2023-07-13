package kits.edu.finalproject.controller;

import kits.edu.finalproject.entity.Product;
import kits.edu.finalproject.model.ProductDTO;
import kits.edu.finalproject.model.ResponeDTO;
import kits.edu.finalproject.service.productImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    ProductServiceImpl productService;

    @GetMapping
    @ResponseBody
    public ResponeDTO<List<Product>> getAllProduct() {
        try {
            List<Product> listProduct = productService.findProductByName("tivi");
            return ResponeDTO.<List<Product>>builder().error("null").data(listProduct).build();
        } catch (Exception e) {
            return ResponeDTO.<List<Product>>builder().error("error").build();
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public Product createProduct(@RequestBody Product productBody) {
        try {
            Product product = productService.createProduct(productBody);
            return ResponeDTO.<Product>builder().error("null").data(product).build().getData();
        } catch (Exception e) {
            return ResponeDTO.<Product>builder().error("error").build().getData();
        }
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public Product updateProduct(@PathVariable int id, @RequestBody Product productBody) {
        try {
            Product product = productService.updateProduct(id, productBody);
            return ResponeDTO.<Product>builder().error("null").data(product).build().getData();
        } catch (Exception e) {
            return ResponeDTO.<Product>builder().error("error").build().getData();
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponeDTO<String> deleteProduct(@PathVariable int id) {
        try {
            boolean isDelete = productService.deleteProduct(id);
            return ResponeDTO.<String>builder().error("null").data("True").build();
        } catch (Exception e) {
            return ResponeDTO.<String>builder().error("error").data("False").build();
        }
    }
}
