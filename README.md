PrisonersDilemma
================

Prisoner's dilemma implementation simulating tournaments of the itarative prisoner's dilemma. The user can choose the strategy of each player, # of game rounds and the utility matrix values.

## The strategies:

*	**Cocky Strategy:** An implementation of player strategy that always returns desertar. It's a simple strategy
*	**Majority Rule Strategy:** An implementation of player strategy that returns the majority decision of al his strategies.It's an inteligent strategy
*	**Random Strategy:** An implementation of player strategy that returns the decision randomly.
*	**Smart Strategy:** An implementation of player strategy that always coperates if the oponent previous decisions are cooperate also, only 10% can be desertar. It's an inteligent strategy 
*	**Naive Strategy:** An implementation of player strategy that always returns cooperate. It's a simple strategy

## Class Design 

*	**UtilityMatrix Class:** 
	* Represents the Utility Matrix
*	**Play Class:**
	* Represents a game play.
	* Knows the two participating players.
	* Knows the Utility Matrix.
	* Knows the play score.
	* Runs the game # times.
*	**Player Class:**
	* Knows his strategy.
	* Delegates to Strategy the decisions.
	* Informs to the Stragegy the rival decisons.
*	**PlayerStrategy Class:**
	* Decides de decision	
*	**Register Class:**
Aspectes rellevants del disseny

- Per implementar les strategies (Patró Strategy)
Hem fet una interfície PlayerStrategy, i cada estratègia implementava aquesta interfície. Com que hi ha la possibilitat de fer estratègies compostes per 2 o més estratègies, hem fet una classe abstracta (CompositeStrategy) que implementa PlayerStrategy i conte una llista (de
PlayerStrategy) i un mètode per afegir estratègies a la llista, ja que totes les estratègies compostes ho han de tenir.
Les estratègies compostes heredaràn de CompositeStrategy i per tant, també implementen PlayerStrategy.

- Classe Register (Patró Singleton)
A l'aplicar el patró singleton ens assegurem de que tots els players faran servir la mateixa instància
de Register i també hem afegit el control d'accés multi-thread.

- Classe UtilityMatrix
Per crear la matriu de resultats, ho hem fet amb un HashMap<Decisions, int[]> , on Decisions és una classe interna que conte les decisions preses pels 2 jugadors. En aquest punt vam contemplar la opció de concatenar els dos Strings decisions de cada jugador i fer-les servir com a clau al hashmap, el codi seria menys llarg però vam decantar-nos en fer una altra classe, ja que ens semblava més correcte. int[] és un array de int[2]; on la posició [0] correspon a la penalització del playerA i la posició [1] a la penalització del playerB.

- Classe ObserverPlay (Observador de la partida)
Hem optat per fer un observador de tipus push. D'aquesta manera a cada volta de la partida, quan els observadors són avisats també els hi passem els canvis mitjançant un Objecte (InfoToObserver), que encapsula la informació següent : decisió del playerA, decisió del PlayerB, puntuació fins al moment del Player A i puntuació fins al moment del Player B. Per crear un Observador, aquest ha d'implementar la interfície Observer i implementar el mètode update(Observer obs, Objec o); on Object o serà l'objecte InfoToObserver comentat abans.
Per poder assignar N observadors a la partida, hem fet que la classe Play hereti de Observable, d'aquesta manera amb el mètode Play.addObserver(Observer obs) podem assignar-li els observadors
que vulguem.
Amb el mètode super.notifyObservers(Object o), on “o” es l'objecte InfoToObserver, avisem als observadors de que s'ha produït un canvi i el valor d'aquests.
