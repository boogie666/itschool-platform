# General Arhitecture Guidelines - System Backend

The application will consist of a 3 main parts.

  1) The Web Server
     Responsible for receiving requests from the frontend
     and sending responses back.
  
  2) The Interactors
     Responsible for handling given requests 
     and generating relevant responses for any given request
  
  3) The Data Processors.
     Responsible for extracting data for consumption by the Interactors
     if the interactors require it.


## The Interactors

The interactors represent the core of the application.
They execute the main usecases of the application along with
secondary usecases.


### The Router Interactor.

The router is reponsible for routing requests to other interactors.
It does so based on the given request.

It should be able to route both static routes (such as request for files)
as well as dynamic routes (such as api routes).


### The Static File Interactor
 
This interactor is reponsible the secondary use case of serving 
the static content to the front end.

Static content includes html css and javascript files
as well as any image files or other static content


### The 'AllQuestions' interactor

This interactor is responsible for serving a sorted list of
of all questions to the front end.
Note that the interactor need only suply basic
information for each question. 
such as title author and some unique identifier of a question.


### The 'QuestionById' Interactor

This interactor is reponsible for serving a single questions
(based on some unique identifier) to the fontend.

The response for a single question need to contain all relevant
data for the requested question.


