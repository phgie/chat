# Customer Chat

Imagine a situation where you need to implement a chat software for our customer service to interact with our customers.

_How would the quick win solution look like and how would the state-of-the-art solution look like?_

Implement a simple solution for a chat that enables customers to send messages to customer service.

Talking points / topics to be considered:
- Which objects / classes would you create? 
- How do they interact? 
- How does the frontend interact with your classes? 
- Which enhancements come to your mind when talking about chat software solutions?

---

# Simple Customer Chat Application (Backend)
Simple implementation for a messaging backend. Clients can use a frontend application (i.e. JavaScript Website) to call
messaging URIs of the backend

## Features 
- Clients connect to the backend through the backend message broker
- The connection is broadcast to all support agents
- An agent can initiate a private chat session with a specific user

## Objects and Classes
This example uses Java Websockets for message handling. Spring (Boot) Configuration is used where possible to keep the
application code light weight and manual configuration to a minimum.

- `ChatMessage.class` Domain object handling messaging content
- `WebSocketConfiguration.class` Enables a message broker for topics (global communication) and queues (user-to-user configuration).
- `CustomerSupportEventListener.class` Handles events for new client connections and broadcasts a message to a topic, agents should subscribe to
- `CustomerSupportController.class` Handles user to user communication via messages

## How do classes interact?
Backend classes interact with each other through Spring Boot functionality.

## How does the frontend interact with the backend?
Since communication is handled through WebSockets over HTTP, the frontend handling client communication needs to
address certain endpoints of the backend API.

- All clients connect to the backend via Sockets (i.e. SockJs)
- Customer service agent clients must subscribe to topic ```/chat/topic/support``` to be notified of new customers connections
- All clients can send messages though API endpoint ```/chat/message``` and must include a valid ChatMessage JSON:
```json
{
  "userFrom": "Sender",
  "userTo": "Receiver",
  "message": "Message content"
}
```

## Which enhancements come to your mind when talking about chat software solutions?
The application example has several limitations which should be implemented:

- Security is not included
- Communication is not restricted (everyone can send to everyone)
- Payload is not validated
- Error handling is not included
- Tests are not included