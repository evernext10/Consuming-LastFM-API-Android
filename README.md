# Consumiento API Rest de Last.FM

Esta aplicacion realiza un proceso de consumo del servicio que presta Last.FM, en la cual se muestran (n) numero de canciones, albumes y artistas. En esta practica, procederemos a realizar la muestra de 50 de cada un de ellas. Con el fin de dar una muestra bastante amplia. 

# # Descripción técnica:
* La aplicación está estructurada en MVP.

![alt text](https://cdn-images-1.medium.com/max/1600/1*p2JvbgEir0BusDiiVHMvIA.png)


* La aplicación utiliza la última FM [APIs] (http://www.Last.FM/API/Intro) para obtener las listas de usuario superior.
* Para poder usar sus APIs, primero necesitas [crear] (https://www.Last.FM/API/Account/Create) una clave API.
* Usted puede utilizar métodos para conseguir los artistas superiores, la búsqueda para los Artis/las pistas etc..

* Se guarda la informacion que se recibe del servicio en una base de datos (SQLite), la cual utilizaremos como gestora de la informacion. 
![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/3/38/SQLite370.svg/1200px-SQLite370.svg.png)


* Se utiliza Dagger2 para inyectar dependencias en el módulo userslisting. 
![alt text](https://cdn-images-1.medium.com/max/1800/1*E1kr8neHIWIVivFffKS_2A.png)

* Se añadio una prueba de unidad Android utilizando espresso para probar que los datos de la lista se muestran correctamente.
![alt text](https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/EspressoImg.png/220px-EspressoImg.png)

* Se añadio una prueba unitaria para el convertidor de tiempo de duración.

* Se utilizaron otras librerias de terceros como: RxJava/RxAndroid 2, Dagger2, Butterknife, Retrofit2, ZLayoutManager, MaterialSearchBar, AwesomeSplash entre otras, con el fin de ahorrar un poco de codigo..

![alt text](https://cdn.dribbble.com/users/563824/screenshots/4329283/untitled-4.gif)


