# srp-facade-lab
CSC 309 Lab on the Single Responsibility Principle and Facade Design Pattern

*Gather together those things that change for the same reason, and separate those things that change for different reasons.*

*Create a Facade as a way to provide clients a unique central point of access to those different functionalities*

## Overview of this repo

Inside you will find the beginnings of a ground-breaking new RPG game. Unfortunately in the rush to get features completed the main
RpgPlayer class is starting to turn into a hair-ball of responsibilities.

You'll start by adding some more features to it to get it into a right mess, then we'll fix it up good.

## Getting started

1. Fork this repo.
2. Clone your fork to make a local copy.
2. Build it.

## Making the situation worse...

### Feature: Super rare items look more awesome

* **As a** graphics designer
* **I want** rare and unique items to look more awesome
* **So that** the player gets a dopamine hit and keep buying more in-game currency

Add a new rule to ```PickUpItem``` that will show a ```blue_swirly``` effect if the ```item``` 
is both ```rare``` and ```unique```.

### Feature: Un-encumbered players can parry more successfully

* **As a** game designer
* **I want** the players damage taken to be reduced by 25% if they're carrying under 50% of my capacity
* **So that** they will win more fights because they're lighter and can dodge attacks more successfully.

Add a new rule that reduces all damage taken via ```TakeDamage``` by 25% if the player is carrying 
less than half their ```CarryingCapacity```.

## ...What's gone wrong?

Even though the public interface for the RpgPlayer looks nice and tidy, the nightmare exists behind the scenes.

The RpgPlayer has far too much knowledge about what the items are capable of, though initially this may have seemed like a good place to
put the logic as the items are *mostly* acting on the player.

## How to fix it?

*Apply the Single Responsibility Principle to provide a better separation of concerns, improve class cohesion, and them provide a Facade as a way to provide clients a unique central point of access to those different functionalities.*
