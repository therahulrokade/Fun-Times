package com.help.cart;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.help.entity.Product;
import com.help.service.ProductService;

public class Cart {

    List<Product> cartItems = new ArrayList<Product>();
    private static DecimalFormat df2 = new DecimalFormat("#.##");
    LocalDateTime fromDate = LocalDateTime.of(2021, Month.JULY, 4, 00, 00);
    LocalDateTime toDate = LocalDateTime.of(2021, Month.JULY, 31, 00, 00);
    private static LocalDateTime currentDate = LocalDateTime.now();

    public void addProductToCartByPID(int pid, int quantity) {
        Product product = getProductByProductID(pid);
        product.setpQuantity(quantity);
        addToCart(product);
    }

    private Product getProductByProductID(int pid) {
        Product product = null;
        List<Product> products = new ProductService().getProducts();
        for (Product prod : products) {
            if (prod.getpId() == pid) {
                product = prod;
                break;
            }
        }
        return product;
    }

    private void addToCart(Product product) {
        Product newProduct = cartItems.stream().filter(x -> x.getpId() == product.getpId()).findFirst().orElse(null);
        if (newProduct == null) {
            cartItems.add(product);
        } else {
            newProduct.setpQuantity(newProduct.getpQuantity() + product.getpQuantity());
        }
    }

    public void removeProductByPID(int pid) {
        Product prod = getProductByProductID(pid);
        cartItems.remove(prod);
    }

    public void printCartItems() {
        for (Product prod : cartItems) {
            System.out.println(prod);
        }
    }

    public boolean isDiscountApplicable() {
        return (currentDate.isAfter(fromDate) && currentDate.isBefore(toDate))
                || (currentDate.isEqual(fromDate) || currentDate.isEqual(toDate));
    }

    public double noDiscountCalculation(Product prod, double totalCost) {
        totalCost += prod.getpCost() * prod.getpQuantity();
        return totalCost;
    }

    public void generateBill() {
        double totalCost = 0;
        boolean isSoupOffer = false;

        for (Product prod : cartItems) {
            if (prod.getpId() == 1 && prod.getpQuantity() >= 2) {
                isSoupOffer = true;
            }
        }

        for (Product prod : cartItems) {
            if (prod.getpId() == 2 && isSoupOffer)
                if (isDiscountApplicable()) {
                    totalCost += (prod.getpCost() / 2) * prod.getpQuantity();
                } else {
                    totalCost += noDiscountCalculation(prod, totalCost);

                }
            else if (prod.getpId() == 4) {
                if (isDiscountApplicable()) {
                    double totalApplePrice = prod.getpCost() * prod.getpQuantity();
                    totalCost += totalApplePrice - ((totalApplePrice * 10) / 100);
                } else {
                    totalCost += noDiscountCalculation(prod, totalCost);
                }
            } else
                totalCost += noDiscountCalculation(prod, totalCost);
        }
        System.out.println("Total cost of your bill: " + df2.format(totalCost));
    }

}
