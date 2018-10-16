# Consumiento API Rest de Last.FM

Esta aplicacion realiza un proceso de consumo del servicio que presta Last.FM, en la cual se muestran (n) numero de canciones, albumes y artistas. En esta practica, procederemos a realizar la muestra de 50 de cada un de ellas. Con el fin de dar una muestra bastante amplia. 

VIDEO DE PRUEBA: https://photos.google.com/search/_tra_/photo/AF1QipNp6HWjfZlRmLRZvx5t83nnbIP4ilMdBiKkfzpP

![alt text](https://lh3.googleusercontent.com/q8wZaOHUiVsHndGH2cBKgjdA2XEUX2OnXwZDxRCy7Xx8U9FYUWoqWILHVeOhU7cLYE3h21ftREwo-JEHtctcomSr3GOQAt7ZiQRJvcpzhLvkYSBAhlLJO7jK4M1IiG4gfZMYbCqvUPrVg9lTClMk2n6QU_23gmwHkW7gVN0V6u_hgmzq1hu85AywatUqFPKy8YTmkuzEnRmcxgn8uz7ByAR4AHb7f3rY4Vlt5cH9kpuky1GM1d8cz0gybqRZHEqdJpaPAEekn6NKlm9CFhOMu0vdL4R8NBNAGOB4_aEtQjN775D24T0w2RHviO0X2b-ak1mG1EKqppaJFHMChfkEKG26zMiFolchx-rLX_rJe2k-zDaUE9_bBqhUHcUaOd-tXvnu1NvCJzTQcv-gai1vN6za7RTo5BJ5AaBTODHhP5mvEyKAbpQtCYAqtyc4gYgWQSBRbyJ8nwDCzD-5lUXoHa0p-9VE4qmdTrCZqH2MWBcNADuxzl8w7oeGqM4AOhEyEL5TcpYUbpNJPFardjZxOXGJEf9TZLB6-77HUtznoo0ScyoIjAmnf9_qsFNHsqyx1cU2BOCqVNePtSKVea04wBmixt7IEEAYCxRB48jeU6HWTtXeUyilBO6FKy8VtBjj=w353-h626-no)

# # Descripción técnica:
* La aplicación está estructurada en MVP.

![alt text](https://cdn-images-1.medium.com/max/1600/1*p2JvbgEir0BusDiiVHMvIA.png)

Modelo
En una aplicación con una buena arquitectura estratificada, este modelo sólo sería la puerta de enlace a la capa de dominio o a la lógica empresarial. Consulte como proveedor de los datos que queremos mostrar en la vista. Las responsabilidades del modelo incluyen el uso de APIs, almacenamiento de datos en caché, administración de bases y así sucesivamente.

Vista
La vista, normalmente implementada por una actividad, contendrá una referencia al presentador. Lo único que la vista va a hacer es llamar a un método desde el presentador cada vez que hay una acción de interfaz.

Presentador
El presentador es responsable de actuar como el intermediario entre la visión y el modelo. Recupera los datos del modelo y lo devuelve formateado a la vista. Pero a diferencia del MVC típico, también decide qué sucede cuando interactúas con la vista.


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


