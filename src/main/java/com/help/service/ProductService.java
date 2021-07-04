package com.help.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.help.entity.Product;

public class ProductService {
    Scanner sc = new Scanner(System.in);
    public List<Product> productList;

    public List<Product> getProducts() {
        productList = new ArrayList<Product>();
        productList.add(new Product(1, "soup", "tin", 0.65));
        productList.add(new Product(2, "bread", "loaf", 0.80));
        productList.add(new Product(3, "milk", "bottle", 1.30));
        productList.add(new Product(4, "apples", "single", 0.10));
        return productList;
    }
}
