# 🏆 Football World Cup ScoreBoard (TDD)

## 📌 Objective

Design and implement a simple in-memory ScoreBoard system for tracking football matches, using **Test-Driven Development (TDD)** and following **SOLID** and **Clean Code** principles.

---

## ✅ Functional Requirements

1. **Start a game** – initialize a match with home and away teams, starting at 0–0.
2. **Update score** – update the score for a specific game.
3. **Finish a game** – remove a match from the scoreboard.
4. **Get summary** – return a list of matches ordered by:
    - total score (home + away), descending
    - for ties: by most recently added match first

---

## 🧪 Development Approach – TDD

This project was implemented fully using **TDD**, following the Red-Green-Refactor cycle:

1. **Red** – write a failing test
2. **Green** – implement just enough to make the test pass
3. **Refactor** – clean up the code without breaking functionality

---

## 📚 Learning Note

Although I studied the concept of **TDD** during my studies, this is my **first project** built entirely using the TDD approach. Before starting the implementation, I spent a few days to strengthen my understanding by reading a book about TDD in Java and completing exercises from the book.

![Book cover](https://static01.helion.com.pl/global/okladki/vbig/e_38v4.jpg)

## Assumptions

### Starting a Game

Based on the requirement to **start a game** and initialize it with a score of `0-0`, the following assumptions were made:

1. **Each team can only participate in one game at a time**  
   A team cannot be part of more than one ongoing game. If a team is already playing, attempting to start another game involving that team will result in an `IllegalArgumentException`.


2. **The home and away teams must be different**  
   It is not allowed to start a game with the same team on both sides. Case-insensitive team names are considered equal (e.g., "Mexico" vs "mexico" is invalid).


3. **Games are stored in memory and preserved in order of addition**  
   The scoreboard keeps games in the order they were started. This order is later used for sorting games with equal total scores in the summary.


4. **Starting a game always sets the initial score to 0–0**  
   There is no way to start a game with a custom score. All games begin with zero goals for both teams.

These assumptions ensure clarity and safety around match initialization while keeping the implementation simple.

### Updating a Game

While implementing the **update score** functionality, several assumptions were made due to lack of detailed specification:

1. **Score updates are absolute, not incremental**  
   The `updateScore` method sets the full score at a given moment, e.g., setting the score from `0-0` directly to `5-3` is valid.


2. **Negative scores are not allowed**  
   Football scores cannot be negative. Attempting to update a game with a negative score will throw an `IllegalArgumentException`.


3. **Only existing games can be updated**  
   The game must be started (exist in the scoreboard) before it can be updated.  
   If no match with the given teams is found, an `IllegalArgumentException` will be thrown.


4. **Multiple updates for the same game are allowed**  
   Scores can be updated multiple times for a single match, reflecting the current status during a live game.


5. **Score values can be reduced (rollback allowed)**  
   The updated score may be lower than the previous one. This accounts for potential human input errors or VAR (Video Assistant Referee) decisions cancelling goals.


These assumptions aim to reflect how a live football scoreboard typically operates in a real-time environment.
