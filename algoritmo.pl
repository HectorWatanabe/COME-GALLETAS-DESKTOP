

indice_posicion(1,'1').
indice_posicion(2,'2').
indice_posicion(3,'3').
indice_posicion(4,'4').
indice_posicion(5,'5').
indice_posicion(6,'6').
indice_posicion(7,'7').
indice_posicion(8,'8').
indice_posicion(10,'10').
indice_posicion(11,'11').
indice_posicion(13,'13').
indice_posicion(14,'14').
indice_posicion(15,'15').
indice_posicion(16,'16').
indice_posicion(19,'19').
indice_posicion(20,'20').
indice_posicion(21,'21').
indice_posicion(22,'22').
indice_posicion(23,'23').
indice_posicion(24,'24').
indice_posicion(25,'25').
indice_posicion(27,'27').
indice_posicion(30,'30').
indice_posicion(31,'31').
indice_posicion(32,'32').
indice_posicion(34,'34').
indice_posicion(35,'35').
indice_posicion(36,'36').
indice_posicion(37,'37').
indice_posicion(38,'38').
indice_posicion(39,'39').
indice_posicion(40,'40').

% grafo
grafo(1,6,1).
grafo(6,1,1).
grafo(1,2,1).
grafo(2,1,1).
grafo(6,7,1).
grafo(7,6,1).
grafo(6,11,1).
grafo(11,6,1).
grafo(11,16,1).
grafo(16,11,1).
grafo(16,21,1).
grafo(21,16,1).
grafo(21,22,1).
grafo(22,21,1).
grafo(32,31,1).
grafo(31,32,1).
grafo(36,31,1).
grafo(31,36,1).
grafo(36,37,1).
grafo(37,36,1).
grafo(2,7,1).
grafo(7,2,1).
grafo(2,3,1).
grafo(3,2,1).
grafo(7,8,1).
grafo(8,7,1).
grafo(22,27,1).
grafo(27,22,1).
grafo(23,22,1).
grafo(22,23,1).
grafo(27,32,1).
grafo(32,27,1).
grafo(32,37,1).
grafo(37,32,1).
grafo(37,38,1).
grafo(38,37,1).
grafo(3,8,1).
grafo(8,3,1).
grafo(3,4,1).
grafo(4,3,1).
grafo(8,13,3).
grafo(13,8,1).
grafo(13,14,1).
grafo(14,13,1).
grafo(23,24,1).
grafo(24,23,1).
grafo(38,39,1).
grafo(39,38,1).
grafo(4,5,1).
grafo(5,4,1).
grafo(14,19,1).
grafo(19,14,1).
grafo(14,15,1).
grafo(15,14,1).
grafo(19,24,1).
grafo(24,19,1).
grafo(24,25,1).
grafo(25,24,1).
grafo(34,39,1).
grafo(39,34,1).
grafo(34,35,1).
grafo(35,34,1).
grafo(39,38,1).
grafo(38,39,1).
grafo(39,40,1).
grafo(40,39,1).
grafo(5,10,1).
grafo(10,5,1).
grafo(10,15,1).
grafo(15,10,1).
grafo(25,30,1).
grafo(30,25,1).
grafo(30,35,1).
grafo(35,30,1).
grafo(35,40,1).
grafo(40,35,1).


% valores h
h(1,3,2).
h(6,3,3).
h(11,3,4).
h(16,3,5).
h(21,3,6).
h(31,3,8).
h(36,3,9).
h(2,3,1).
h(7,3,2).
h(22,3,5).
h(27,3,6).
h(32,3,7).
h(37,3,8).
h(3,3,0).
h(8,3,1).
h(13,3,2).
h(23,3,4).
h(38,3,7).
h(4,3,1).
h(14,3,3).
h(19,3,4).
h(24,3,5).
h(34,3,9).
h(39,3,8).
h(5,3,2).
h(10,3,3).
h(15,3,4).
h(25,3,6).
h(30,3,7).
h(40,3,9).
h(35,3,8).



obtener_h(Destino, Origen, LineaRecta):-
 h(Destino, Origen, LineaRecta).


%principal - encontrar_mejor_camino

encontrar_mejor_camino(Destino, Origen,Costo,Camino):-
 indice_posicion(C1,Destino),
 indice_posicion(C2,Origen),
 a_estrella([[0,C1]],CaminoFinal,C2),
 CaminoFinal = [Cabeza|Cola],
  Costo = Cabeza,
  Camino = Cola.

 encontrar_mejor_camino(_,_):-
 write('Null').


% busqueda a_estrella
a_estrella(Caminos, [Costo,Origen|Camino], Origen):-
 member([Costo,Origen|Camino],Caminos),
 elegir_mejorf(Caminos, [Costo1|_], Origen),
 Costo1 == Costo.

a_estrella(Caminos, MejorCamino, Origen):-
 elegir_mejorf(Caminos, Prox, Origen),
 delete(Caminos,Prox,CaminosRestantes),
 expandir_frontera(Prox, NuevosCaminos),
 append(CaminosRestantes, NuevosCaminos, ListaCompleta),
 a_estrella(ListaCompleta, MejorCamino, Origen).


% De todos los nuevos caminos expandidos de la frontera elegimos
% el de mejor f = h + g, es decir, la eleccion que hace el algoritmo A*.
   

elegir_mejorf([X],X,_):-!.
elegir_mejorf([[Costo1,Posicion1|Cola1],[Costo2,Posicion2|_]|Resto], MejorCamino, Origen):-
 obtener_h(Posicion1, Origen, H1),
 obtener_h(Posicion2, Origen, H2),
 H1 +  Costo1 =< H2 +  Costo2,
 elegir_mejorf([[Costo1,Posicion1|Cola1]|Resto], MejorCamino, Origen).
elegir_mejorf([[Costo1,Posicion1|_],[Costo2,Posicion2|Cola2]|Resto], MejorCamino, Origen):-
 obtener_h(Posicion1, Origen, H1),
 obtener_h(Posicion2, Origen, H2),
 H1  + Costo1 > H2 +  Costo2,
 elegir_mejorf([[Costo2,Posicion2|Cola2]|Resto], MejorCamino, Origen).

% expandirFrontera: Buscamos todos los nodos del grafo que 
% sean frontera de la ciudad actual

expandir_frontera([Costo,Nodo|Camino],NuevosCaminos):-
 findall([Costo,NuevoNodo,Nodo|Camino], (grafo(Nodo, NuevoNodo,_),not(member(NuevoNodo,Camino))), ListaResultante),
 cambiar_costo_camino(ListaResultante, NuevosCaminos).

%  Actualizo los costos de cada camino, una vez agregado el ultimo nodo.
cambiar_costo_camino([],[]):-!.
cambiar_costo_camino([[Costo,NuevoNodo,Nodo|Camino]|Cola],[[NuevoCosto,NuevoNodo,Nodo|Camino]|Cola1]):-
 grafo(NuevoNodo, Nodo, Distancia),
 NuevoCosto is Costo + Distancia,
 cambiar_costo_camino(Cola,Cola1).








