-- Select
-- ANSII -> kodun başka yerlerde de çalışması (oracle, postgresql, mysql)

use Northwind
Select * from Customers -- Customers tablosundan bütün kolonları seç

Select ContactName, CompanyName, City from Customers -- Customers tablosundan ContactName, CompanyName, City'deki kolonları seç

Select ContactName Adi, CompanyName SirketAdi, City Sehir from Customers

-- filtreleme sorgusu
Select * from Customers where City = 'London' -- Customers'tan şehri Londra olanları seç

Select * from Customers where City = 'Berlin' -- Customers'tan şehri Berlin olanları seç

-- case insensitive -> büyük Küçük harf duyarsızdır.
Select * from Products -- Products tablosunu tüm kolonlarıyla getir.

Select * from Products where CategoryID = 1 -- Products tablosunda CategoryID'si 1 olan kolonları getir

Select * from Products where CategoryID = 1 or CategoryID = 3 -- Products tablosunda CategoryID'si 1 olan ya da 3 olan kolonları getir

Select * from Products where CategoryID = 1 and UnitPrice >= 10 -- Products tablosunda CategoryID'si 1 olan ve UnitPrice'i 10'dan büyük eşit olan kolonları getir.

--order by -> sıralama
Select * from Products order by ProductName -- Products tablosunu seç PrdocutName'ye göre sırala (order by = sırala)

Select * from Products order by CategoryID, ProductName -- Products tablosunu seç CategoryID'ye göre sýralarken ProductName'ye göre de sırala

-- asc -> ascending -> artan 
Select * from Products order by UnitPrice asc -- Products tablosunu seç UnitPrice'ye göre sırala (en ucuzdan başlattı)

-- desc -> descenging -> azalan
Select * from Products order by UnitPrice desc

Select * from Products where CategoryID = 1 order by UnitPrice desc -- Prdocust tablosunu seç CategoryID'si 1 olanları filtrele onları UnitPrice'a göre azalan olarak getir

Select count(*) from Products -- Products tablosundan kaç data olduğunu gösterir

Select count(*) from Products where CategoryID = 2 -- Products tablosunda CategoryID'si 2 olanlardan kaç tane olduğnu gösterir

Select count(*) Adet from Products where CategoryID = 2

-- group by -> gruplar oluşturmak
-- count(*) her grup için ayrı ayrı hesaplama yapıyor
-- Hangi kategoride kaç farklı ürün var?
Select CategoryID, count(*) from Products group by CategoryID

-- ürün sayısı 10'dan az olan kategorileri listele
-- having -> gorup by'a konu olan kümülatif(birikmiş) sorguya yazılır
Select CategoryID, count(*) from Products group by CategoryID having count(*) < 10

-- Fiyatı 20 den fazla olan ürünleri CategoryID'ye göre grupla, CategoryID'de ürün sayısı 10dan az olanları getir
Select CategoryID, count(*) from Products where UnitPrice > 20 group by CategoryID having count(*) < 10

-- join -> birleştirmek
-- Products ile Categories'te bulunan CategoryID'leri birleþtir (neye göre -> eşitliğe göre)
Select * 
from Products inner join Categories on Products.CategoryID = Categories.CategoryID


-- Products tablosundan ProductID, ProductName, UnitPrice, Kategori tablosundan CategoryName'i ver CategoryID'leri birleþtir
Select Products.ProductID, Products.ProductName, Products.UnitPrice, Categories.CategoryName from Products inner join Categories on Products.CategoryID = Categories.CategoryID

-- DTO Data Transformation Object


-- Ürünlerden fiyatı 10'dan büyük olanlar için Categories.CategoryName ile birleştir 
Select Products.ProductID, Products.ProductName, Products.UnitPrice, Categories.CategoryName from Products inner join Categories on Products.CategoryID = Categories.CategoryID where Products.UnitPrice > 10

-- inner join -> sadece 2 tabloda da eşleşenleri bir araya getirir. Eşleşmeyen data varsa onu getirmez. Sadece eşleşen kayıtları getirir.
-- 2 tablodaki ortak kolon bulunur (p -> products, od -> order details)
Select * from Products  p inner join [Order Details] od on p.ProductID = od.ProductID

-- left join -> solda olup sağda olmayanları da getir (ürünlerde olup sipariş detayında olmayan ürün)
Select * from Products  p left join [Order Details] od on p.ProductID = od.ProductID

-- Customer ve Orders tablosundaki ID'leri getir (eşleşenler)
Select * from Customers c inner join Orders o on c.CustomerID = o.CustomerID

-- Customers'ta olup Orders'ta olmayanları da getir
Select * from Customers c left join Orders o on c.CustomerID = o.CustomerID

-- sisteme kayıt olup, sipariş vermeyen kullanıcılar (solda olup sağda olmayanlar)
Select * from Customers c left join Orders o on c.CustomerID = o.CustomerID where o.CustomerID is null 


-- right join -> sağda olup solda olmayanlar

-- ikiden fazla tabloyu join etmek
Select * from Products p inner join [Order Details] od on p.ProductID = od.ProductID
inner join Orders o 
on o.OrderID = od.OrderID

