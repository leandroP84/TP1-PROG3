class Habitacion:
    
    from vivienda import Vivienda
    
    def __init__(self,id:int,nombre:str,metrosCuadrados:float,vivienda:Vivienda):
        
        self.id=id
        self.nombre=nombre
        self.metrosCuadrados=metrosCuadrados
        self.vivienda = vivienda