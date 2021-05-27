**Design decisions**

- I decided to create a model per each data type the API so it could be easier to manage the data in possible future improvements (right now they are not extremely necessary).
- In the controllers section, I tried to make some abstraction as all of them have some things in common.
- I chose using Spring framework for two main reasons: It provides an easy way to create an API and to consume another, and because it's something I would like to keep learning.

**Possible improvements**

- Abstraction: All the controllers have the same methods, only changing the type they return and the endpoints, so one major improvements would be to take advantage of abstraction and generic types.
- HATEOAS: A mayor improvement would be implementing the HATEOAS principle. The models will be helpful for that.
- Microservices: Instead of accessing the data through an external API, it could be great to create a microservices architecture, in where each data type would be managed internally (with internal databases) without the needing of the external API.  
- Update methods: Update methods are taking so long to return a response (around 1 minute), so optimize this is an important improvement.
- UI: I would like to develop a simple user interface, so it could be easier to access the methods. 
