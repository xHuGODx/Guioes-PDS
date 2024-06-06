**Ex3 Mediator**
Para compilar e correr usar o script 'run.sh'
```bash
$ chmod +x run.sh
$ ./run.sh
```
1-PROBLEM

Imagine you are designing a system to manage
the communication between entities (e.g.
students). Implement a simple example in Java
demonstrating the Mediator design pattern.
Assume that each message sent by a student
should be broadcasted to all the students.

In a system with multiple objects that need to communicate, managing direct communication can become complex and error-prone. Each object would need to maintain references to all other objects it wants to communicate with, leading to a tightly coupled system that's hard to maintain and extend. This is particularly problematic in scenarios where objects frequently change or when the number of objects is large, as it increases the complexity of managing these interactions.
Solution


2-SOLUTION
The solution provided by this code is to use the Mediator design pattern. The core idea is to introduce a ChatMediator class that handles the communication between Colleague objects. Each Colleague only knows about the mediator, not about the other colleagues. The mediator manages the list of colleagues and is responsible for broadcasting messages to all colleagues except the sender.

3-REFERENCES
https://refactoring.guru/design-patterns/mediator
