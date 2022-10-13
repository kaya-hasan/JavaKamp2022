-- Select
-- ANSII -> kodun baþka yerlerde de çalýþmasý (oracle, postgresql, mysql)

use Northwind
Select * from Customers -- Customers tablosundan bütün kolonlarý seç

Select ContactName, CompanyName, City from Customers -- Customers tablosundan ContactName, CompanyName, City'deki kolonlarý seç

Select ContactName Adi, CompanyName SirketAdi, City Sehir from Customers

-- filtreleme sorgusu
Select * from Customers where City = 'London' -- Customers'tan Þehri Londra olanlarý seç

Select * from Customers where City = 'Berlin' -- Customers'tan Þehri Berlin olanlarý seç

-- case insensitive -> büyük Küçük harf duyarsýzdýr.
Select * from Products -- Products tablosunu tüm kolonlarýyla getir.

Select * from Products where CategoryID = 1 -- Products tablosunda CategoryID'si 1 olan kolonlarý getir

Select * from Products where CategoryID = 1 or CategoryID = 3 -- Products tablosunda CategoryID'si 1 olan ya da 3 olan kolonlarý getir

Select * from Products where CategoryID = 1 and UnitPrice >= 10 -- Products tablosunda CategoryID'si 1 olan ve UnitPrice'i 10'dan büyük eþit olan kolonlarý getir.

--order by -> sýralama
Select * from Products order by ProductName -- Products tablosunu seç PrdocutName'ye göre sýrala (order by = sýrala)

Select * from Products order by CategoryID, ProductName -- Products tablosunu seç CategoryID'ye göre sýralarken ProductName'ye göre de sýrala

-- asc -> ascending -> artan 
Select * from Products order by UnitPrice asc -- Products tablosunu seç UnitPrice'ye göre sýrala (en ucuzdan baþlattý)

-- desc -> descenging -> azalan
Select * from Products order by UnitPrice desc

Select * from Products where CategoryID = 1 order by UnitPrice desc -- Prdocust tablosunu seç CategoryID'si 1 olanlarý filtrele onlarý UnitPrice'a göre azalan olarak getir

Select count(*) from Products -- Products tablosundan kaç data olduðunu gösterir

Select count(*) from Products where CategoryID = 2 -- Products tablosunda CategoryID'si 2 olanlardan kaç tane olduðnu gösterir

Select count(*) Adet from Products where CategoryID = 2

-- group by -> gruplar oluþturmak
-- count(*) her grup için ayrý ayrý hesaplama yapýyor
-- Hangi kategoride kaç farklý ürün var?
Select CategoryID, count(*) from Products group by CategoryID

-- ürün sayýsý 10'dan az olan kategorileri listele
-- having -> gorup by'a konu olan kümülatif(birikmiþ) sorguya yazýlýr
Select CategoryID, count(*) from Products group by CategoryID having count(*) < 10

-- Fiyatý 20 den fazla olan ürünleri CategoryID'ye göre grupla, CategoryID'de ürün sayýsý 10dan az olanlarý getir
Select CategoryID, count(*) from Products where UnitPrice > 20 group by CategoryID having count(*) < 10

-- join -> birleþtirmek
-- Products ile Categories'te bulunan CategoryID'leri birleþtir (neye göre -> eþitliðe göre)
Select * 
from Products inner join Categories on Products.CategoryID = Categories.CategoryID


-- Products tablosundan ProductID, ProductName, UnitPrice, Kategori tablosundan CategoryName'i ver CategoryID'leri birleþtir
Select Products.ProductID, Products.ProductName, Products.UnitPrice, Categories.CategoryName from Products inner join Categories on Products.CategoryID = Categories.CategoryID

-- DTO Data Transformation Object


-- Ürünlerden fiyatý 10'dan büyük olanlar için Categories.CategoryName ile birleþtir 
Select Products.ProductID, Products.ProductName, Products.UnitPrice, Categories.CategoryName from Products inner join Categories on Products.CategoryID = Categories.CategoryID where Products.UnitPrice > 10

-- inner join -> sadece 2 tabloda da eþleþenleri bir araya getirir. Eþleþmeyen data varsa onu getirmez. Sadece eþleþen kayýtlarý getirir.
-- 2 tablodaki ortak kolon bulunur (p -> products, od -> order details)
Select * from Products  p inner join [Order Details] od on p.ProductID = od.ProductID

-- left join -> solda olup saðda olmayanlarý da getir (ürünlerde olup sipariþ detayýnda olmayan ürün)
Select * from Products  p left join [Order Details] od on p.ProductID = od.ProductID

-- Customer ve Orders tablosundaki ID'leri getir (eþleþenler)
Select * from Customers c inner join Orders o on c.CustomerID = o.CustomerID

-- Customers'ta olup Orders'ta olmayanlarý da getir
Select * from Customers c left join Orders o on c.CustomerID = o.CustomerID

-- sisteme kayýt olup, sipariþ vermeyen kullanýcýlar (solda olup saðda olmayanlar)
Select * from Customers c left join Orders o on c.CustomerID = o.CustomerID where o.CustomerID is null 


-- right join -> saðda olup solda olmayanlar

-- ikiden fazla tabloyu join etmek
Select * from Products p inner join [Order Details] od on p.ProductID = od.ProductID
inner join Orders o 
on o.OrderID = od.OrderID

