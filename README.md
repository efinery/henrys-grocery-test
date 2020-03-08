# henrys-grocery-test
Coding test for Industrial Logic


# Implementation Notes:
- I decided to handle money using an int for pence as this seemed like the simplest option.
- It's not specified what an example input would look like so I assumed it would just be an array of Strings to the main() method.
- For the output I simply show the basket total in pounds and pence.
- I implemented the Promotions using a PromotionRule interface so the design is more Open/Closed.
- The HalfPriceDiscount and PercentOffDiscount classes are reusable for possible future Promotions.
- All scenarios stated in the specification and more are tested in BasketTotallerTest


# To run:
- mvn clean package
- java -jar target/pricing-1.0-SNAPSHOT.jar soup soup soup bread bread

Example output:

**Basket : [soup, soup, soup, bread, bread]**

**Total is £3.15**
