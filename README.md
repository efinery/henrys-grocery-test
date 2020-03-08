# henrys-grocery-test
Coding test for Industrial Logic


# Implementation Notes
- I decided to handle money using an int for pence as this seemed like the simplest option.
- It's not specified what an example input would look like so I assumed it would just be an array of Strings to the main() method.
- For the output I simply show the basket total in pounds and pence.
- I implemented the Promotions using a PromotionRule interface so the design is more Open/Closed.
- The HalfPriceDiscount and PercentOffDiscount classes are reusable for possible future Promotions.
- All scenarios stated in the specification and more are tested in BasketTotallerTest
- Output seemed a bit spare so I added a more receipt-like output.


# Running
Type the following from the command line:
```
mvn clean package
java -jar target/pricing-1.0-SNAPSHOT.jar soup soup soup bread bread
```

# Example output
```
    Item    Price /     Unit   Qty
-------- ------------------- -----
bread        0.80 /     loaf     2
soup         0.65 /      tin     3
  
Discounts : £0.40
TOTAL     : £3.15
```