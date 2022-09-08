# CDL Kata task

## Brief

Implement the code for a checkout system that handles pricing schemes such as “apples cost 50 pence, three apples cost £1.30.”
Implement the code for a supermarket checkout that calculates the total price of a number of items. In a normal supermarket, things are identified using Stock Keeping Units, or SKUs. In our store, we’ll use individual letters of the alphabet (A, B, C, and so on). Our goods are priced individually. In addition, some items are multi-priced: buy ‘n’ of them, and they’ll cost you ‘y’ pence. For example, item ‘A’ might cost 50 pence individually, but this week we have a special offer: buy three ‘A’s and they’ll cost you £1.30.

Our checkout accepts items in any order, so that if we scan a B, an A, and another B, we’ll recognize the two B’s and price them at 45 (for a total price so far of 95). Because the pricing changes frequently, we need to be able to pass in a set of pricing rules each time we start handling a checkout transaction.

The solution should allow for items to input at the command line, and allow for a final total to be calculated and for a running total after each item is ‘scanned’.

Please use Java for the solution and place this onto a publicly accessible Github repository and let us know where it is

##CLI arguments

### Seeding

You will need to seed the items before you can run the code and get a total
it was done so that the code could be extended to add other products

to seed enter either `--seed` or `-s` followed by either

`{product name here},{product price here}` for non bulk product or
`{product name here},{product price here},{product bulk price here}, {number of products to get bulk price here}` for bulk discounts

### Generating a total

When you have finished typing product information after typing `-s` or `--seed`,  type `--order` or `-o` to start typing the order
the order should just contain the name, case-sensitive, of the products that you want to order. It works irrespective of
the order but the name should match the product name in the seed.

so the final command should look like this `-s{or --seed} {items entered in format under seed section} -o{or --order} {name of items case sensitive}`. It is done this way as no data is persisted and the application is required to be run on a CLI

eg command based on brief. `-s A,50,130,3 B,30,45,2 C,20 D,15 -o B A B` output for this command is £0.95

## Running the project

It uses Java 8+

1. Open IDE of your choice
2. Or if using cli navigate to source and compile all classes using `javac ProductScanSimulator.java`
3. enter command line args listed above either on cli or in IDE CLI args
4. Run the code



