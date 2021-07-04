package com.help.service;

import java.util.List;
import java.util.Scanner;

import com.help.cart.Cart;
import com.help.entity.Product;

public class ProductMenus {

    Cart cart = new Cart();

    private int choice = 0;

    public ProductMenus() {
        menu();
    }

    public void startMenu() {
        System.out.println("1. Display Store Products");
        System.out.println("2. Display Cart");
        System.out.println("3. Generate Bill");
        System.out.println("0. Exit");
    }

    public void cartProductsMenu() {
        System.out.println("1. Add to Cart");
        System.out.println("2. Remove From Cart");
        System.out.println("0. Exit");
    }

    public void menu() {
        do {
            System.out.println();
            startMenu();
            System.out.print("Enter your choice: ");
            getUserInput();

            switch (choice) {
            case 1:
                displayStoreProducts();
                cartProductsMenu();
                System.out.print("Enter your choice: ");
                getUserInput();
                innerChoice1();
                break;
            case 2:
                cart.printCartItems();
                break;
            case 3:
                cart.generateBill();
                break;
            case 0:
                System.exit(0);
                break;
            default:

                break;
            }
        } while (choice != 0);
    }

    private void innerChoice1() {
        switch (choice) {
        case 1:
            addProductToCart();
            break;
        case 2:
            removeProductFromCart();
            break;
        default:

            break;
        }
    }

    private int getUserInput() throws NumberFormatException {
        Scanner in = new Scanner(System.in);
        choice = Integer.parseInt(in.nextLine());
        return choice;
    }

    private void displayStoreProducts() {
        List<Product> products = new ProductService().getProducts();
        System.out.println("List of products: ");
        for (Product prod : products) {
            System.out.println(prod.getpId() + "- " + prod.getpName() + " " + prod.getpUnit() + " " + prod.getpCost());
        }
        System.out.println("\n");
    }

    private void addProductToCart() {
        System.out.print("Select product from list: ");
        int pid = getUserInput();
        System.out.print("Enter quantity for Product: ");
        int pQuantity = getUserInput();
        cart.addProductToCartByPID(pid, pQuantity);
    }

    private void removeProductFromCart() {
        System.out.print("Enter product id which need to be removed from list: ");
        int pid = getUserInput();
        cart.removeProductByPID(pid);
    }
}