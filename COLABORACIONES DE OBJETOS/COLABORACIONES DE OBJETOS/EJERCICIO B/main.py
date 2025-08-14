from utils import *
from empleado import Empleado
from regimen_horario import RegimenHorario

empleadoA = Empleado(
    "Francisco"
    ,"20-44144121"
    ,"Casa Blanca"
    ,"francisco245@gmail.com"
)

regimenA = RegimenHorario(
    1,
    9,
    1,
    12,
    12,
    empleadoA
)

empleadoA.asistencias=generador_Asistencias(
    objempleado=empleadoA,
    cantidad=360,
    hora=9,
    minuto=1
)

empleadoA.tardanzas=generador_Tardanzas(
    objempleado=empleadoA,
    cantidad=300,
    hora=10,
    minuto=30
)

#empleadoA.contar_presentismo()

#empleadoA.getAsistenciaXMesXAnio(5,2025);
empleadoA.getTardanzasXMesXAnio(5,2025);