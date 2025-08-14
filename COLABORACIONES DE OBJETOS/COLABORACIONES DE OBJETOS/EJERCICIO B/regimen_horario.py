from empleado import Empleado

class RegimenHorario:
    
    def __init__(
        self,
        id: int,
        hora_ingreso: int,
        minuto_ingreso: int,
        hora_egreso: int,
        minuto_egreso: int,
        empleado: Empleado = None
    ):
        self.id: int = id
        self.hora_ingreso: int = hora_ingreso
        self.minuto_ingreso: int = minuto_ingreso
        self.hora_egreso: int = hora_egreso
        self.minuto_egreso: int = minuto_egreso
        self.empleado: Empleado = empleado
