from datetime import date
from empleado import Empleado

class Asistencia:
    
    def __init__(self,empleado:Empleado,id: int, tipo:str,año,mes,dia,hora,minuto):
        self.id: int = id
        self.tipo: str = tipo
        self.fecha: date = date(año,mes,dia)
        self.hora: int = hora
        self.minuto: int = minuto
        self.empleado:Empleado = empleado
        
    def print_info(self): #← Metodo hecho en gpt para ahorrar tiempo
        print(f"Asistencia ID: {self.id}")
        print(f"Tipo: {self.tipo}")
        print(f"Fecha: {self.fecha.strftime('%Y-%m-%d')}")
        print(f"Hora: {self.hora:02d}:{self.minuto:02d}")

    def print_all_info(self):
        print("="*50)
        print("Empleado → " , self.empleado.nombre)
        print("Cuit →" , self.empleado.cuit)
        print("="*50)
        self.print_info()
        print("←="*50)