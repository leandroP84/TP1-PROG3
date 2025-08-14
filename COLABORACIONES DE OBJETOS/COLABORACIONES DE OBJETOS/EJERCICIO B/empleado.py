class Empleado:
    
    def __init__(self, nombre: str, cuit: int, domicilio: str, email: str):
        
        from asistencias import Asistencia
        from tardanza import Tardanza
        from regimen_horario import RegimenHorario
                
        self.nombre: str = nombre
        self.cuit: int = cuit
        self.domicilio: str = domicilio
        self.email: str = email

        self.regimenHorario: RegimenHorario = None
        self.tardanzas: list["Tardanza"] = []
        self.asistencias: list["Asistencia"] = []
        
    def contar_presentismo(self):
        print("Asistencias →",len(self.asistencias))
        print("Tardanzas →",len(self.tardanzas))
        
        
    def getAsistenciaXMesXAnio(self,mes:int , año:int):
        listaCoincidente = []
    
        for i in range(len(self.asistencias)-1):
            if self.asistencias[i].fecha.month==mes and self.asistencias[i].fecha.year == año:
                self.asistencias[i].print_all_info()
                listaCoincidente.append(self.asistencias[i])
    
        return listaCoincidente
    
    def getTardanzasXMesXAnio(self,mes:int , año:int):
        listaCoincidente = []
    
        for i in range(len(self.tardanzas)-1):
            if self.tardanzas[i].fecha.month==mes and self.tardanzas[i].fecha.year == año:
                self.tardanzas[i].print_all_info()
                listaCoincidente.append(self.tardanzas[i])
    
        return listaCoincidente