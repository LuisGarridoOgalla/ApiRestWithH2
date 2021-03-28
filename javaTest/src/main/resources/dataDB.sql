DROP TABLE IF EXISTS PRICES;
DROP TABLE IF EXISTS BRANDS;
DROP TABLE IF EXISTS COMPANIES;

CREATE TABLE BRANDS(
	BRAND_ID INT PRIMARY KEY,
	NAME VARCHAR(255)
);

CREATE TABLE PRICES (
  ID INT AUTO_INCREMENT PRIMARY KEY,
  BRAND_ID INT,
  START_DATE TIMESTAMP NOT NULL,
  END_DATE TIMESTAMP NOT NULL,
  PRICE_LIST INT,
  PRODUCT_ID INT NOT NULL,
  PRIORITY INT NOT NULL,
  PRICE DOUBLE NOT NULL,
  CURR VARCHAR(255) NOT NULL,
  FOREIGN KEY (BRAND_ID) REFERENCES BRANDS(BRAND_ID) 
);


INSERT INTO BRANDS(BRAND_ID, NAME) values (1, 'ZARA');
INSERT INTO PRICES(BRAND_ID,START_DATE,END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR ) values(1, '2020-06-14 00.00.00', '2020-12-31 23.59.59', 1, 35455, 0, 35.50, 'EUR');
INSERT INTO PRICES(BRAND_ID,START_DATE,END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR ) values(1, '2020-06-14 15.00.00', '2020-06-14 18.30.00', 2, 35455, 1, 25.45, 'EUR');
INSERT INTO PRICES(BRAND_ID,START_DATE,END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR ) values(1, '2020-06-15 00.00.00', '2020-06-15 11.00.00', 3, 35455, 1, 30.50, 'EUR');
INSERT INTO PRICES(BRAND_ID,START_DATE,END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR ) values(1, '2020-06-15 16.00.00', '2020-12-31 23.59.59', 4, 35455, 1, 38.95, 'EUR');

