Testlerimi cURL kullanarak yaptım. Paket düzenimi size uygun olarak
yapmaya özen gösterdim. Aşağıdaki görseldeki gibi (derste anlatılan)
paket düzenimi oluşturdum.

![Graphical user interface, text, application, Word Description
automatically
generated](./images/media/image1.PNG)

Oluşturduğum iki mikroserviste (Inventory, Shopping) de aşağıdaki
görseldeki mimariye uydum. Commerce mikroservisi veri tabanı içermediği
için bu mimarinin veri tabanı kısmı kesilmiş biçimini uyguladım
diyebilirim. Bir de Commerce mikroservisi diğer iki mikroservisten
farklı olarak RestClient içeriyor.

![Diagram Description automatically generated with medium
confidence](./images/media/image2.PNG)

Tüm projenin mimarisi ise derste aşağıdaki görseldeki gibi olması
istendi. Ben de tam olarak o şekilde projeyi gerçekleştirdim.

![Diagram Description automatically
generated](./images/media/image3.PNG)

Oluşturduğum veri tabanlarının en son hâllerinin ER diyagramları şu
şekildedir:

![Table Description automatically generated with medium
confidence](./images/media/image4.PNG) ![Graphical user interface, application, table, Excel
Description automatically generated](./images/media/image5.PNG)

Inventory, Shopping ve Commerce olarak sırasıyla mikroservisleri yaptım.
Commerce mikroservisini yapmadan önce product_name özelliği tabloda
yoktu fakat Commerce ile hem Product tablosuna hem Car_Product tablosuna
erişim sağlayabildiğim için Car_Product tablosundaki product_id
özelliğini kullanarak Product tablosundan product_name özelliğini
çekebildim ve bu özelliği Card_Product tablosuna ekledim. İki veri
tabanında da iki tablo arasında OneToMany ilişkisi bulunuyor.

# Inventory Microservice 

## **GET** /inventory/products/{id} 

![Text Description automatically generated with medium
confidence](./images/media/image6.PNG)

## Product Table 

![](./images/media/image7.PNG)

## **GET** /inventory/product/{id}

![Graphical user interface, text, application Description automatically
generated](./images/media/image8.PNG)

## **GET** /inventory/categories 

![Text Description automatically
generated](./images/media/image9.PNG)

## Category Table 

![Graphical user interface, text, application, table Description
automatically
generated](./images/media/image10.PNG)

# Shopping Microservice 

## **POST** /shopping/cart/create \> Response: cartId 

![Chart Description automatically generated with low
confidence](./images/media/image11.PNG)

## Database View 
![Graphical user interface, text, application, email Description automatically generated](./images/media/image12.PNG)

## **POST** /shopping/cart/add \< Request: cartProductDto 

![Text Description automatically generated](./images/media/image13.PNG)

## Database View
![Graphical user interface, application, Word Description automatically
generated](./images/media/image14.PNG)

Bu isteği atarken Commerce mikroservisini yapmamıştım, o yüzden
sales_price değerini elimle girmiştim fakat Commerce mikroservisini
yaptıktan sonra elle girmeden Inventory mikroservisini kullanarak
sales_price değerini bulabiliyorum. Ayrıca daha sonradan product_name
özelliğini de tabloya ekledim.

## **DELETE** /shopping/cart/{cartId}/remove/{productId} 

![Graphical user interface, text, email Description automatically
generated](./images/media/image15.PNG)

## Database View (İstekten Önce)
![](./images/media/image14.PNG)

## Database View (İstekten Sonra)
![Graphical user interface, application Description automatically
generated](./images/media/image16.PNG)

Ben DELETE isteğini tüm CardProduct nesnelerini silmek gibi değil de
sales_quantity özelliğinden bir eksiltmek, eğer sales_quantity sıfır
olursa da tamamen silmek gibi düşündüm, o yüzden o şekilde yerine
getirdim.

## **GET** /shopping/checkout/{cartId} \> Eğer checkout false ise true yap  
![Graphical user interface, text, email Description automatically generated](./images/media/image17.PNG)

## Database View
![Graphical user interface, text, application, email Description
automatically
generated](./images/media/image18.PNG)

Cart oluşturma kısmında Mustafa'nın cart_status özelliği false idi,
şimdi ise true.

## **GET** /shopping/cart/find/{cartId} 

![Graphical user interface, text Description automatically
generated](./images/media/image19.PNG)

Çıktıda da görüldüğü gibi totalAmount değeri kaydedilememiş. Bu çıktıyı
gördükten sonra veri tabanına kayıt kısımlarını bir daha gözden geçirdim
ve yeni bir CardProduct ekleyip yeniden denediğimde yeni eklediğim
miktar totalAmount değerine yansıdı.

![Text Description automatically
generated](./images/media/image20.PNG)

2 tane 2000 birimlik ürün ekledim ve sonuç olarak toplam miktar 4000
oldu. İçerikte çıkanlar yanlış bir şekilde veri tabanına kaydedilen
ürünler.

Veri tabanını sıfırlayıp CardProduct ekleyip çıkaralım...

![Graphical user interface, text Description automatically generated
with medium confidence](./images/media/image21.png)

![](./images/media/image22.png)

![Table Description automatically
generated](./images/media/image23.png)

Cart nesneleri haricinde diğer kayıtları sildim ve tanesi 300 birim olan
üründen bir tane ekledim. Mustafa'nın total_amount değeri 300 arttı ve
CardProduct tablosunda bir satır oluştu.

Şimdi eklediğim CardProduct nesnesini silelim...

![Text Description automatically
generated](./images/media/image24.png)

![Table Description automatically
generated](./images/media/image25.png)

![](./images/media/image26.png)

Sonuç olarak CardProduct tablosu boşaldı ve Mustafa'nın total_amount
değeri 300 azaldı.

# Commerce Microservice 

## **GET** /commerce/inventory/products/{id}  
![Text Description automatically generated with low confidence](./images/media/image27.PNG)  
## **GET** /commerce/inventory/product/{id}  
![Graphical user interface, text, application Description automatically generated](./images/media/image28.PNG)

## **GET** /commerce/inventory/categories
![A picture containing text Description automatically
generated](./images/media/image29.PNG)

## **POST** /commerce/shopping/cart/create > Response: cartId  
![Text Description automatically generated](./images/media/image30.PNG)

## Database View

![Graphical user interface, text, application Description automatically
generated](./images/media/image31.PNG)

## **POST** /commerce/shopping/cart/add < Request: cartProductDto

![Text Description automatically generated with low
confidence](./images/media/image32.PNG)

## Database View

![](./images/media/image33.PNG)

![Graphical user interface, application, table Description automatically
generated](./images/media/image34.PNG)

Bu sefer sales_quantity ve product_name özelliklerini elimle girmedim.
Servis benim yerime o özellikleri buldu ve doldurdu.

## **DELETE** /commerce/shopping/cart/{cartId}/remove/{productId} 

![Graphical user interface, text Description automatically
generated](./images/media/image35.PNG)

## Database View

![](./images/media/image36.PNG)
![Application, table Description automatically generated](./images/media/image37.PNG)

Yukarı görüldüğü gibi tablet ürünün sayısı bir azaldı ve toplam maliyet
2000 birim düştü.

## **GET** /commerce/shopping/checkout/{cartId} \> Eğer checkout false ise true  
![Text Description automatically generated](./images/media/image38.PNG)  
## Database View (İstekten Önce) 
![Application, table Description automatically generated](./images/media/image39.PNG) 
## İstekten Sonra 
![Table Description automatically generated](./images/media/image40.PNG)

## **GET** /commerce/shopping/cart/find/{cartId}  
![A picture containing chart Description automatically generated](./images/media/image41.PNG)

Yukarıda yapılan işlemlerin sonuçları yukarıdaki görselde Content
kısmında doğrulanıyor.
