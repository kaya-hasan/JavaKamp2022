-- Select
-- ANSII -> kodun ba�ka yerlerde de �al��mas� (oracle, postgresql, mysql)

use Northwind
Select * from Customers -- Customers tablosundan b�t�n kolonlar� se�

Select ContactName, CompanyName, City from Customers -- Customers tablosundan ContactName, CompanyName, City'deki kolonlar� se�

Select ContactName Adi, CompanyName SirketAdi, City Sehir from Customers

-- filtreleme sorgusu
Select * from Customers where City = 'London' -- Customers'tan �ehri Londra olanlar� se�

Select * from Customers where City = 'Berlin' -- Customers'tan �ehri Berlin olanlar� se�

-- case insensitive -> b�y�k K���k harf duyars�zd�r.
Select * from Products -- Products tablosunu t�m kolonlar�yla getir.

Select * from Products where CategoryID = 1 -- Products tablosunda CategoryID'si 1 olan kolonlar� getir

Select * from Products where CategoryID = 1 or CategoryID = 3 -- Products tablosunda CategoryID'si 1 olan ya da 3 olan kolonlar� getir

Select * from Products where CategoryID = 1 and UnitPrice >= 10 -- Products tablosunda CategoryID'si 1 olan ve UnitPrice'i 10'dan b�y�k e�it olan kolonlar� getir.

--order by -> s�ralama
Select * from Products order by ProductName -- Products tablosunu se� PrdocutName'ye g�re s�rala (order by = s�rala)

Select * from Products order by CategoryID, ProductName -- Products tablosunu se� CategoryID'ye g�re s�ralarken ProductName'ye g�re de s�rala

-- asc -> ascending -> artan 
Select * from Products order by UnitPrice asc -- Products tablosunu se� UnitPrice'ye g�re s�rala (en ucuzdan ba�latt�)

-- desc -> descenging -> azalan
Select * from Products order by UnitPrice desc

Select * from Products where CategoryID = 1 order by UnitPrice desc -- Prdocust tablosunu se� CategoryID'si 1 olanlar� filtrele onlar� UnitPrice'a g�re azalan olarak getir

Select count(*) from Products -- Products tablosundan ka� data oldu�unu g�sterir

Select count(*) from Products where CategoryID = 2 -- Products tablosunda CategoryID'si 2 olanlardan ka� tane oldu�nu g�sterir

Select count(*) Adet from Products where CategoryID = 2

-- group by -> gruplar olu�turmak
-- count(*) her grup i�in ayr� ayr� hesaplama yap�yor
-- Hangi kategoride ka� farkl� �r�n var?
Select CategoryID, count(*) from Products group by CategoryID

-- �r�n say�s� 10'dan az olan kategorileri listele
-- having -> gorup by'a konu olan k�m�latif(birikmi�) sorguya yaz�l�r
Select CategoryID, count(*) from Products group by CategoryID having count(*) < 10

-- Fiyat� 20 den fazla olan �r�nleri CategoryID'ye g�re grupla, CategoryID'de �r�n say�s� 10dan az olanlar� getir
Select CategoryID, count(*) from Products where UnitPrice > 20 group by CategoryID having count(*) < 10

-- join -> birle�tirmek
-- Products ile Categories'te bulunan CategoryID'leri birle�tir (neye g�re -> e�itli�e g�re)
Select * 
from Products inner join Categories on Products.CategoryID = Categories.CategoryID


-- Products tablosundan ProductID, ProductName, UnitPrice, Kategori tablosundan CategoryName'i ver CategoryID'leri birle�tir
Select Products.ProductID, Products.ProductName, Products.UnitPrice, Categories.CategoryName from Products inner join Categories on Products.CategoryID = Categories.CategoryID

-- DTO Data Transformation Object


-- �r�nlerden fiyat� 10'dan b�y�k olanlar i�in Categories.CategoryName ile birle�tir 
Select Products.ProductID, Products.ProductName, Products.UnitPrice, Categories.CategoryName from Products inner join Categories on Products.CategoryID = Categories.CategoryID where Products.UnitPrice > 10

-- inner join -> sadece 2 tabloda da e�le�enleri bir araya getirir. E�le�meyen data varsa onu getirmez. Sadece e�le�en kay�tlar� getirir.
-- 2 tablodaki ortak kolon bulunur (p -> products, od -> order details)
Select * from Products  p inner join [Order Details] od on p.ProductID = od.ProductID

-- left join -> solda olup sa�da olmayanlar� da getir (�r�nlerde olup sipari� detay�nda olmayan �r�n)
Select * from Products  p left join [Order Details] od on p.ProductID = od.ProductID

-- Customer ve Orders tablosundaki ID'leri getir (e�le�enler)
Select * from Customers c inner join Orders o on c.CustomerID = o.CustomerID

-- Customers'ta olup Orders'ta olmayanlar� da getir
Select * from Customers c left join Orders o on c.CustomerID = o.CustomerID

-- sisteme kay�t olup, sipari� vermeyen kullan�c�lar (solda olup sa�da olmayanlar)
Select * from Customers c left join Orders o on c.CustomerID = o.CustomerID where o.CustomerID is null 


-- right join -> sa�da olup solda olmayanlar

-- ikiden fazla tabloyu join etmek
Select * from Products p inner join [Order Details] od on p.ProductID = od.ProductID
inner join Orders o 
on o.OrderID = od.OrderID

