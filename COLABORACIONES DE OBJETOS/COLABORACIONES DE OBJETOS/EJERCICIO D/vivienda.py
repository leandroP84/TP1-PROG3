class Vivienda:
    
    def __init__(self, id: int, nombre: str, empresaConstructora: str, 
                 calle: str, numeroCalle: int, superficieTerreno: float, ):
        
        
        from barrio import Barrio
        from habitacion import Habitacion
        
        self.id = id
        self.nombre = nombre
        self.empresaConstructora = empresaConstructora
        self.calle = calle
        self.numeroCalle = numeroCalle
        self.superficieTerreno = superficieTerreno
        self.barrio:Barrio = None
        self.habitaciones:list["Habitacion"] = []
        self.totalSuperficie=0

    def getMetrosCuadradosCubiertos(self):
        for habitacion in self.habitaciones:
            
            self.totalSuperficie+=habitacion.metrosCuadrados
        
        if self.totalSuperficie > self.superficieTerreno:
            self.totalSuperficie=0
            print("→ Las habitaciones superan el total del terreno")
            print("="*40)
            
        print("Total → ", self.totalSuperficie)
        
        return self.totalSuperficie