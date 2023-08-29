# Tshirt Search Program using Hibernate

This project implements a standalone Tshirt search program in Java using Hibernate, which lists matching T-shirt products based on user criteria. The program reads T-shirt data from CSV files for different companies (Nike, Puma, Adidas) and persists the data in a database. Users can search for T-shirts by specifying color, size, gender, and output preference.

## Problem Statement

The program aims to provide users with a product search functionality for T-shirts using Hibernate. It utilizes CSV files to populate the database with T-shirt data and performs search operations on the database.

### CSV Fields Details

The CSV files contain the following fields for each T-shirt:

- **ID**: Unique product ID, starting with a 2-digit company code.
- **NAME**: Model name.
- **COLOUR**: T-shirt color.
- **GENDER_RECOMMENDATION**: Gender for which this T-shirt is recommended (M - Male, F - Female, U - Unisex).
- **SIZE**: T-shirt size (S, M, L, XL, XXL).
- **PRICE**: Price of the T-shirt per piece in INR.
- **RATING**: Rating of the T-shirt from 1 to 5 (1 being lowest and 5 being highest).
- **AVAILABILITY**: Availability of the T-shirt (Y or N).

## How to Use

1. Clone or download this repository to your local machine.
2. Open a terminal and navigate to the directory where the Java program is located.
3. Compile the Java program using a Java compiler.
4. Run the program and provide the required input parameters.

## Features

- Populate the database with T-shirt data from CSV files using Hibernate.
- Search for T-shirts based on color, size, gender, and output preference.
- Display matching results sorted by output preference.
- Utilize a thread to periodically check for new CSV files and load them into the database.

## Note

- The program supports dynamic loading of CSV files and database interaction using Hibernate.
- If no matching T-shirt is found for the given input, a user-friendly output will be displayed.

For any further assistance or inquiries, please contact Prakhar Srivastava at sprakhar275@gmail.com.
