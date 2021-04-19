# PrecioJusto

# Detalles 

Este es un juego el cual consiste en adivinar el precio de un objeto. Por el momento solo existe una opcion de juego la cual te permite
escoger entre 3 precios diferente y solo uno es el correcto. El juego tiene un temporizador de 1 minuto por objeto y 2 vidas en total.
Si el temporizador o las vidas acaban pierdes y tienes que vovler a empezar.(EL JUEGO NO ESTA TERMINADO).

Esta App usa las siguientes librerias: 

- Retrofit
- Gson
- Glide
- ViewModel
- LiveData
- Koin
- Lottie

Esta App a traves de retrofit y gson consume una Api la cual por el momento la tengo subida y compartida en dropbox para facilitar el trabajo en un futuro
esta Api mostrara en tiempo real los datos de una BD. La estrucutra de la Api es la siguiente: 


  "objetos":[
    {
            "id": 1,
            "name": "...",
			      "foto": "...",
            "descripcion": "...",
            "precio": "..",
			      "precios":
					    {
						    "primero":"..",
						    "segundo":".."
					    }
    }
  ]
