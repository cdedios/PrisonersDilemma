PrisonersDilemma
================

Prisoner's dilemma implementation simulating tournaments of the iterative prisoner's dilemma. The user can choose the strategy of each player, # of game rounds and the utility matrix values.

## The strategies:

*	**Cocky Strategy:** An implementation of player strategy that always returns desertar (defect). It's a simple strategy
*	**Majority Rule Strategy:** An implementation of player strategy that returns the majority decision of all his strategies. It's an intelligent strategy
*	**Random Strategy:** An implementation of player strategy that returns the decision randomly.
*	**Smart Strategy:** An implementation of player strategy that always cooperates if the opponent previous decisions are cooperate also, only 10% can be desertar (defect). It's an intelligent strategy 
*	**Naive Strategy:** An implementation of player strategy that always returns cooperate. It's a simple strategy

## Class Design 

*	**UtilityMatrix Interface:** 
	* Represents the Utility Matrix

*	**UtilityMatrixImp Class:** 
	* Represents the matrix utility. Implements UtilityMatrix.

*	**Play Class:**
	* Represents a game, knows both players, the utility matrix and also the global score of the game.
	* Executes a game with a determinated number of rounds.
	* Extends Observable 

*	**Player Interface:**
	* Player interface with the methods to use the player.

*	**PlayerStrategy Interface:**
 	* The player strategy interface.
 	* Decides wich decision has to be made. Is informed of the opponent decision.
 	* Can be simple or composite.
	* Allows the deep copy.

*	**Register Class:**
 	* It's used to save the PlayerStrategies, with an asociated name, of the game.
 	* Pattern Singleton is applied.

*	**ObserverPlay Class:**
	* Implements Observer.
	* Represents an observer of the game. Is informed of the changes they happen in the game
	* It's a push Observer. On each iteration of the game the observers are informed of the results with a InfoToObserver object.

*	**PlayerImp Class:**
	* Implements Player.
 	* Represents a player of the game. Implements Player interface.
	* This player knows his strategy and delegates to it his decisions. 
	* Also reports to the strategy the opponent previous decision.

