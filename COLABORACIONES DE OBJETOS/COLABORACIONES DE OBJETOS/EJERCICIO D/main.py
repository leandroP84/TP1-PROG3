from vivienda import Vivienda
from barrio import Barrio
from habitacion import Habitacion

natania47 = Barrio(
    id=1,
    nombre="natania 47",
    empresaConstructora="Nantania",
)

vivienda_A=Vivienda(
    id=1,
    nombre="casa A",
    empresaConstructora="Nantania",
    calle="F.Gabrielli",
    numeroCalle=1,
    superficieTerreno=200,
)

vivienda_B=Vivienda(
    id=2,
    nombre="casa A",
    empresaConstructora="Nantania",
    calle="F.Gabrielli",
    numeroCalle=1,
    superficieTerreno=500,
)

habitacion_1A=Habitacion(
    id=1,
    nombre="Dormitorio",
    metrosCuadrados=40,
    vivienda=vivienda_A
)

habitacion_2A=Habitacion(
    id=2,
    nombre="Dormitorio 2",
    metrosCuadrados=80,
    vivienda=vivienda_A
)

habitacion_3A=Habitacion(
    id=3,
    nombre="Baño",
    metrosCuadrados=40,
    vivienda=habitacion_1A
)

habitacion_1B=Habitacion(
    id=1,
    nombre="Dormitorio",
    metrosCuadrados=200,
    vivienda=vivienda_B
)

habitacion_2B=Habitacion(
    id=1,
    nombre="Cocina",
    metrosCuadrados=100,
    vivienda=vivienda_B
)
habitacion_3B=Habitacion(
    id=3,
    nombre="Garaje",
    metrosCuadrados=400,
    vivienda=vivienda_B
)
habitacion_4B=Habitacion(
    id=4,
    nombre="Lavanderia",
    metrosCuadrados=200,
    vivienda=vivienda_B
)

vivienda_A.barrio = natania47
vivienda_B.barrio = natania47

vivienda_A.habitaciones=[habitacion_1A,habitacion_2A,habitacion_3A]
vivienda_B.habitaciones=[habitacion_1B,habitacion_2B,habitacion_3A,habitacion_4B]

natania47.listaDeViviendas=[vivienda_A,vivienda_B]

print("Total Metros Barrio")
natania47.get_superficie_totalTerreno()
print("="*40)
print("total Metros Cuadrados vivienda 1")
vivienda_A.getMetrosCuadradosCubiertos()
print("="*40)
print("Total Metros Vivienda B")
vivienda_B.getMetrosCuadradosCubiertos()

print("↑"*40)
natania47.get_superficie_totalDeTodo()