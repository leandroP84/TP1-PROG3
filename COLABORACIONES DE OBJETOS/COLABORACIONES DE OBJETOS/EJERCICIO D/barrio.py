class Barrio:
    
    
    
    def __init__(self,id:int,nombre:str,empresaConstructora:str):
        from vivienda import Vivienda
    
        self.id=id
        self.nombre=nombre
        self.empresaConstructora=empresaConstructora
        self.listaDeViviendas:list["Vivienda"] = []
        self.totalTerreno = 0
        self.totalTerrenoYHabitaciones=0
        
    def get_superficie_totalTerreno(self):
        
        for vivienda in self.listaDeViviendas:
            
            self.totalTerreno+=vivienda.superficieTerreno
            
     
        print("Total → ", self.totalTerreno," Metros Cuadrados")
        
        return self.totalTerreno
    
    def get_superficie_totalDeTodo(self):
        
            total=self.get_superficie_totalTerreno()
        
            for vivienda in self.listaDeViviendas:
            
                try:
                    self.totalTerrenoYHabitaciones+=vivienda.getMetrosCuadradosCubiertos()
                except:
                    pass
                    
            self.totalTerrenoYHabitaciones = self.totalTerrenoYHabitaciones+total
        
            return print("Total de todo → :", self.totalTerrenoYHabitaciones)