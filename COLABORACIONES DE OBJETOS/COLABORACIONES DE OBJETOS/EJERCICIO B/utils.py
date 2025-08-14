from empleado import Empleado
import random

# Preguntar al profe si se podia crear un Objeto Presentismo 
# y que directamente Asistencia y Tardanza heredaran de el
# o mejor si directamente era mejor crear una variable que sea tipo tardanza o asistencia

meses = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
años = [2020, 2021, 2022, 2023, 2024, 2025] 
dias = list(range(1, 28))

#A
def generador_Asistencias(objempleado,cantidad,hora,minuto):
    """Retorna una lista de asistencias"""    
    from asistencias import Asistencia
    listaAsistencias = []
    for i in range(cantidad):
        
        asistencia = Asistencia(
            empleado=objempleado,
            id=i,
            tipo="A",
            año=random.choice(años),
            mes=random.choice(meses),
            dia=random.choice(dias),
            hora=hora,
            minuto=minuto
        )
        listaAsistencias.append(asistencia)
        
    return listaAsistencias

#T
def generador_Tardanzas(objempleado,cantidad, hora, minuto):
    """Retorna una lista de tardanzas"""    
    from tardanza import Tardanza
    listaTardanzas = []
    for i in range(cantidad):
        
        tardanza = Tardanza(
            empleado=objempleado,
            id=i,
            tipo="T",
            año=random.choice(años),
            mes=random.choice(meses),
            dia=random.choice(dias),
            hora=hora,
            minuto=minuto
        )
        listaTardanzas.append(tardanza)
        
    return listaTardanzas