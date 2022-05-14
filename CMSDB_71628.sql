CREATE DATABASE CMSDB_71628;
USE CMSDB_71628;
-- drop database cmsdb;
CREATE TABLE LOGIN(
LOGIN_ID INT,
EMAIL VARCHAR(255) NOT NULL,
PASSWORD VARCHAR(255) NOT NULL
);
-- INSERT INTO LOGIN(LOGIN_ID,EMAIL,PASSWORD) VALUES(?,?,?);
 
CREATE TABLE VENDOR(
VENDOR_ID INT AUTO_INCREMENT,
VENDOR_NAME VARCHAR(255) NOT NULL,
VENDOR_PHONE VARCHAR(10) NOT NULL,
VENDOR_EMAIL VARCHAR(255) NOT NULL UNIQUE,
VENDOR_SPECS VARCHAR(255) NOT NULL,
CONSTRAINT VENDOR_ID_PK PRIMARY KEY(VENDOR_ID)
);
-- INSERT INTO VENDOR(VENDOR_NAME,VENDOR_PHONE,VENDOR_EMAIL,VENDOR_SPECS) VALUES(?,?,?,?);
CREATE TABLE CUSTOMER(
CUSTOMER_ID INT AUTO_INCREMENT,
CUSTOMER_NAME VARCHAR(255) NOT NULL,
CUSTOMER_PHONE VARCHAR(10) NOT NULL,
CUSTOMER_EMAIL VARCHAR(255) NOT NULL UNIQUE,
CUSTOMER_WALLET_BAL DECIMAL,
CONSTRAINT CUSTOMER_ID_PK PRIMARY KEY(CUSTOMER_ID)
);
-- INSERT INTO CUSTOMER (CUSTOMER_NAME,CUSTOMER_PHONE,CUSTOMER_EMAIL,CUSTOMER_COUPON,CUSTOMER_WALLET_BAL) VALUES (?,?,?,?,?); 

-- Alter Table CUSTOMER Drop column CUSTOMER_COUPON;
-- desc customer;
 
CREATE TABLE FOODITEM (
FOOD_ID INT AUTO_INCREMENT,
FOOD_NAME VARCHAR(255) NOT NULL,
FOOD_PRICE DECIMAL,
VENDOR_ID INT,
CALORIES INT,
CONSTRAINT FOOD_ID_PK PRIMARY KEY (FOOD_ID),
CONSTRAINT VENDOR_ID_FK FOREIGN KEY (VENDOR_ID) REFERENCES VENDOR(VENDOR_ID)
);

-- desc foodITEM;
-- INSERT INTO FOODITEM(FOOD_NAME,FOOD_PRICE,VENDOR_ID) VALUES (?,?,?);
-- UPDATE FOODITEM SET FOOD_NAME =?, FOOD_PRICE=? WHERE FOOD_ID =?;

CREATE TABLE ORDERDETAILS (
ORDER_NO INT AUTO_INCREMENT,
VENDOR_ID INT,
CUSTOMER_ID INT,
FOOD_ID INT,
QUANTITY INT NOT NULL,
ETA TIME NOT NULL,
DATE_AND_TIME DATETIME NOT NULL,
ORDER_VALUE DECIMAL NOT NULL,
ORDER_STATUS VARCHAR(255) DEFAULT 'PENDING',
REASON VARCHAR(255),
CONSTRAINT ORDER_NO_PK PRIMARY KEY (ORDER_NO),
CONSTRAINT ORDER_VENDOR_ID_FK FOREIGN KEY (VENDOR_ID) REFERENCES VENDOR(VENDOR_ID),
CONSTRAINT CUSTOMER_ID_FK FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID),
CONSTRAINT FOOD_ID_FK  FOREIGN KEY (FOOD_ID) REFERENCES FOODITEM(FOOD_ID)
);

-- INSERT INTO ORDERDETAILS(VENDOR_ID,CUSTOMER_ID,FOOD_ID,QUANTITY,ETA,DATE_AND_TIME,ORDER_VALUE,ORDER_STATUS,REASON) VALUES (1,1,1,1,"00:15","2022-05-09",123,"PLACED","");

-- drop table orderdetails;

 -- SELECT O.ORDER_NO,F.FOOD_NAME,F.FOOD_PRICE,O.QUANTITY, O.ORDER_STATUS,O.ETA,O.DATE_AND_TIME,O.ORDER_VALUE FROM ORDERDETAILS O JOIN FOODITEM F ON O.FOOD_ID=F.FOOD_ID WHERE O.CUSTOMER_ID=2 ; 

-- INSERT INTO ORDERDETAILS(VENDOR_ID,CUSTOMER_ID,FOOD_ID,QUANTITY,ETA,DATE_AND_TIME,ORDER_VALUE,ORDER_STATUS) VALUES (?,?,?,?,?,?,?,?);

-- INSERT INTO ORDERDETAILS(VENDOR_ID,CUSTOMER_ID,FOOD_ID,QUANTITY,ETA,DATE_AND_TIME,ORDER_VALUE,ORDER_STATUS) Values (1,1,1,2,10,"2022-05-05 10:10:10",101,"Accepted");-- 

-- truncate table orderdetails;
-- truncate table login;
-- truncate table customer;
-- truncate table vendor;
-- truncate table fooditem;
-- SET FOREIGN_KEY_CHECKS=0;

select * from login;
select * from vendor;
select * from fooditem;
select * from customer;
select * from orderdetails;
 
-- UPDATE CUSTOMER SET CUSTOMER_WALLET_BAL=0 WHERE CUSTOMER_ID=4;
--  UPDATE ORDERDETAILS SET ORDER_STATUS="PENDING" WHERE ORDER_NO=7;

-- SELECT ORDER_NO,VENDOR_ID,CUSTOMER_ID,FOOD_ID,QUANTITY,ETA,DATE_AND_TIME,ORDER_VALUE,ORDER_STATUS FROM ORDERDETAILS WHERE CUSTOMER_ID=1;

-- SELECT O.ORDER_NO,F.FOOD_NAME,F.FOOD_PRICE,O.QUANTITY,O.ORDER_VALUE,O.ETA,O.Date_AND_TIME,O.ORDER_STATUS FROM ORDERDETAILS O
-- JOIN FOODITEM F ON O.FOOD_ID = F.FOOD_ID
-- WHERE O.CUSTOMER_ID =1;

-- SELECT F.FOOD_NAME,F.FOOD_PRICE,(COUNT(*))AS "NO OF ORDERS",SUM(O.ORDER_VALUE),SUM(O.QUANTITY),O.DATE_AND_TIME,O.ORDER_STATUS FROM  ORDERDETAILS O JOIN FOODITEM F ON O.FOOD_ID = F.FOOD_ID WHERE O.VENDOR_ID = 1 GROUP BY F.FOOD_NAME;

SELECT COUNT(*) FROM ORDERDETAILS WHERE CUSTOMER_ID=4;