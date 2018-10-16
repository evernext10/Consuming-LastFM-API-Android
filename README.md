# Consumiento API Rest de Last.FM

Esta aplicacion realiza un proceso de consumo del servicio que presta Last.FM, en la cual se muestran (n) numero de canciones, albumes y artistas. En esta practica, procederemos a realizar la muestra de 50 de cada un de ellas. Con el fin de dar una muestra bastante amplia. 

# # Descripción técnica:
* La aplicación está estructurada en MVP.

![alt text](https://cdn-images-1.medium.com/max/800/1*HoHOQmr79f-SnoWGsuh1OQ.jpeg)


* La aplicación utiliza la última FM [APIs] (http://www.Last.FM/API/Intro) para obtener las listas de usuario superior.
* Para poder usar sus APIs, primero necesitas [crear] (https://www.Last.FM/API/Account/Create) una clave API.
* Usted puede utilizar métodos para conseguir los artistas superiores, la búsqueda para los Artis/las pistas etc..
* Para no sólo mostrar los cinco primeros se puede ampliar el límite para cada solicitud tanto como desee, pero con Max 50 registros por llamada cambiando el valor de TOP_ITEMS_LIMIT a 50 en el archivo constants. java.
* Se utiliza Dagger2 para inyectar dependencias en el módulo userslisting. 
* Se añadio una prueba de unidad Android utilizando espresso para probar que los datos de la lista se muestran correctamente.
* Se añadio una prueba unitaria para el convertidor de tiempo de duración.
* Se utilizaron otras librerias de terceros como: RxJava/RxAndroid 2, Dagger2, Butterknife, Retrofit2, ZLayoutManager, MaterialSearchBar, AwesomeSplash entre otras, con el fin de ahorrar un poco de codigo..

