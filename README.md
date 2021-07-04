# Fun-Times

Step to clone application:

1. clone https repository 
2. Take pull from master branch.

Step to run fun times application:
1. First we are showing product options
2. Enter your choice
   i.  if select option 1 then we are showing product list.
   ii. if select option 2 then we are showing the cart.
   iii. if select option 3 then we are generating bill.
   iv. if select 0 then we are existing from the application.
   
3. if select option 1 (in 2.a)
  a. then we are showing list of products and then we are showing options like 
    i.  Add to Cart
    ii. Remove From Cart
    iii.Exit
 
 Option1: 
 - If we select option 1 add to cart then we need to give product id which we want to add in to the cart.
 - Then we need to give product quantity.
 - If product is already present in cart list then we are updating the quanity of product.
 
 Option2: 
 - If select option 2 then we removing product if we have alredy added in to the cart.

4. same processing we are following for all option which we adding into the cart.

5. while generating bill i have consider below steps.
  - As in this application we haven't use database so i have take from date and toDate static.
  - and for current date i have take system as a current date.
  - if current date is availble in from date and toDate then we giving discount as per requiremnt.
