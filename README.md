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

## Simple Customer Chat Application (Backend)
Simple implementation for a messaging backend. Clients can use a frontend application (i.e. JavaScript Website) to call
messaging URIs of the backend

### Features 
- Clients connect to the backend through the backend message broker
- The connection is broadcast to all support agents
- An agent can initiate a private chat session with a specific user
