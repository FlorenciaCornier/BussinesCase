#language:es
  Característica: BusinessCase
    Escenario: Automation Opcion 1
      Dado que soy un usuario que se dirige a Alquiler Argentina
      Cuando ingreso "Villa Carlos Paz" como localidad
      Y selecciono las fechas de estadia
      E ingreso los integrantes del viaje para iniciar una busqueda
      Entonces el sistema muestra 32 propiedades
      Y cuando aplico el filtro Wifi deberia ver menor cantidad de propiedades
