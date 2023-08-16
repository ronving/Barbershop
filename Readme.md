# Sleeping Barber Problem (Multi-threading)

In computer science, the sleeping barber problem is a classic inter-process communication and synchronization problem that illustrates the complexities that arise when there are multiple operating system processes.

The problem was originally proposed in 1965 by computer science pioneer Edsger Dijkstra, who used it to make the point that general semaphores are often superfluous.

## Problem Statement

Imagine a hypothetical barbershop with one barber, one barber chair, and a waiting room with n chairs (n may be 0) for waiting customers. The following rules apply:[4]

If there are no customers, the barber falls asleep in the chair
A customer must wake the barber if he is asleep
If a customer arrives while the barber is working, the customer leaves if all chairs are occupied and sits in an empty chair if it's available
When the barber finishes a haircut, he inspects the waiting room to see if there are any waiting customers and falls asleep if there are none[3][5]
There are two main complications. First, there is a risk that a race condition, where the barber sleeps while a customer waits for the barber to get them for a haircut, arises because all of the actions—checking the waiting room, entering the shop, taking a waiting room chair—take a certain amount of time. Specifically, a customer may arrive to find the barber cutting hair so they return to the waiting room to take a seat but while walking back to the waiting room the barber finishes the haircut and goes to the waiting room, which he finds empty (because the customer walks slowly or went to the restroom) and thus goes to sleep in the barber chair. Second, another problem may occur when two customers arrive at the same time when there is only one empty seat in the waiting room and both try to sit in the single chair; only the first person to get to the chair will be able to sit.

A multiple sleeping barbers problem has the additional complexity of coordinating several barbers among the waiting customers.[6]
