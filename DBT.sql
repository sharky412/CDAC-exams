

create table OS(OS_ID int primary key, OS_Name varchar(20));
insert into OS values(1,"Android"),(2,"IOS"),(3,"Windows");
select * from OS;
+-------+---------+
| OS_ID | OS_Name |
+-------+---------+
|     1 | Android |
|     2 | IOS     |
|     3 | Windows |
+-------+---------+


create table Mobile (Mobile_ID int primary key, Model varchar(20), Company varchar(20), Price int, OS_ID int, foreign key(OS_ID) references OS(OS_ID));

insert into Mobile values(1,"iPhone 13","Apple",8000,2),(2,"Note 10 Pro","Redmi",18000,1),(3,"Lumia 420","Nokia",18000,3),(4,"M30s","Samsung",18000,2),(5,"A31","OPPO",11500,1),(6,"Narzo","Realme",9000,1);


select * from Mobile;
+-----------+-------------+---------+-------+-------+
| Mobile_ID | Model       | Company | Price | OS_ID |
+-----------+-------------+---------+-------+-------+
|         1 | iPhone 13   | Apple   |  8000 |     2 |
|         2 | Note 10 Pro | Redmi   | 18000 |     1 |
|         3 | Lumia 420   | Nokia   | 18000 |     3 |
|         4 | M30s        | Samsung | 18000 |     2 |
|         5 | A31         | OPPO    | 11500 |     1 |
|         6 | Narzo       | Realme  |  9000 |     1 |
+-----------+-------------+---------+-------+-------+

select * from Mobile,OS where Mobile.OS_ID = OS.OS_ID and OS_Name = (select OS_Name from OS where OS_Name = "Android");
+-----------+-------------+---------+-------+-------+-------+---------+
| Mobile_ID | Model       | Company | Price | OS_ID | OS_ID | OS_Name |
+-----------+-------------+---------+-------+-------+-------+---------+
|         2 | Note 10 Pro | Redmi   | 18000 |     1 |     1 | Android |
|         5 | A31         | OPPO    | 11500 |     1 |     1 | Android |
|         6 | Narzo       | Realme  |  9000 |     1 |     1 | Android |
+-----------+-------------+---------+-------+-------+-------+---------+




select OS.OS_ID, OS.OS_Name from Mobile, OS where Mobile.OS_ID = OS.OS_ID and OS.OS_ID = any(select Mobile.OS_ID from Mobile group by OS_ID having count(Mobile.OS_Id)
 > 1);
+-------+---------+
| OS_ID | OS_Name |
+-------+---------+
|     1 | Android |
|     1 | Android |
|     1 | Android |
|     2 | IOS     |
|     2 | IOS     |
+-------+---------+




1.Write a stored procedure to revers given number? Create temp table with two fields number and revers_number and Output Should be inserted into temp table like

delimiter //
CREATE PROCEDURE reversal(IN x int)
begin
declare num1 int;
declare num2 int; 
declare rev int default 0;
set num1 = x;
while num1>0 do
set num2:=num1 mod 10;
set rev:=num2+(rev*10);
set num1:=floor(num1/10);
end while;
insert into temp values(num1, rev);
end//
DELIMITER ;

call reversal(89);

select * from temp;
+--------+------------+
| number | rev_number |
+--------+------------+
|     89 |         98 |
+--------+------------+


2. The function will calculate the Least Common Multiple (LCM) of two numbers using the formula: LCM = (num1 * num2) / GCD(num1, num2). For this, we will also need to ensure we have a function to calculate the GCD (Greatest Common Divisor).
  
delimiter //

-- Function to calculate GCD
CREATE FUNCTION GCD(a INT, b INT)
RETURNS INT
DETERMINISTIC
BEGIN
    WHILE b != 0 DO
        SET a = a % b;
        SET a = a + b;
        SET b = a - b;
        SET a = a - b;
    END WHILE;
    RETURN a;
END //

-- Function to calculate LCM
CREATE FUNCTION LCM(x INT, y INT)
RETURNS INT
DETERMINISTIC
BEGIN
    IF x > 0 AND y > 0 THEN
        RETURN (x * y) / GCD(x, y);
    ELSE
        RETURN NULL;
    END IF;
END //
delimiter ;
SELECT LCM(15, 20) AS LCM;
60





3. Correct the MongoDB syntax to insert documents into the Activities collection using the insertMany method.
use Activities
db.createCollection("Sports");

db.Activities.insert([{ Student: "Rohan", Sport_Name: "Cricket", Cost: "3000", Address: "Shivaji Nagar" }, { Student: "Mohan", Sport_Name: "Foot Ball", Cost: "4000", Address: "Swargate" }, { Student: "Roma", Sport_Name: "Swimming", Cost: "2000", Address: " " }, { Student: "Mahesh", Sport_Name: "Tennis", Cost: " ", Address: "Deccan " }]);
DeprecationWarning: Collection.insert() is deprecated. Use insertOne, insertMany, or bulkWrite.
{
  acknowledged: true,
  insertedIds: {
    '0': ObjectId('66080a3f9b9fc97fd37b2da9'),
    '1': ObjectId('66080a3f9b9fc97fd37b2daa'),
    '2': ObjectId('66080a3f9b9fc97fd37b2dab'),
    '3': ObjectId('66080a3f9b9fc97fd37b2dac')
  }
}



