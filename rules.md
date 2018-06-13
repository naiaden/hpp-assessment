# TwentyOne

A game of chance. A game against other players and against the machine. Similar to Blackjack, but with a twist.

## Rules

Since the rules are defined by the customer, the rules contained in the implementation are as described below. Any vagueness or incorrect interpretation is not intentional but a result of the description of the rules.

The goal of the game is to get as close to 21 points as possible, beating both other players and the bank in the process.

The game starts by adding players to the game, with a maximum of three (currently one deck of cards is implemented). In the first round every player is dealt a card. The cards are held privately, so other players do not know the cards in your hand. Then all players place their bet, and every player is handed a second card.

After this initial round, the game starts, and each player (in a clock-wise fashion) has the opportunity to play. Each round, the player has three options:
* stand: hold your total and end your turn
* hit: ask for a card to bring your points as close as possible to 21
* split: (only when you have two identical cards in your hand) place the two identical cards on the table and play twice, one game per card

If a player has more than 21 points in his hand, he is 'bust', and his bets are lost.

After all players have played a round, it is the bank's turn (if all players are bust, the bank wins by definition). The bank must hit when it has a total of 16 points or less, and must stand with a total of 17 points or more. If the bank and any of the players have the same numbers of points, the bank wins. If the bank has more than 21 points, the bank is bust, and all players that are standing (e.g. not bust), win.

The points are distributed as follows:
* King 3, Queen 2, Jack 1
* Ace is 1 or 11, this is up to the player
* Cards 2 through 10 have their face value
* A card's suit is irrelevant
* No jokers
