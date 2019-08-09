# Data Model

This section decribes the general data model and communication protocols.


## Question Authoring.

While questions authoring is done outside of the application 
The application needs to be able to load questions.

Each questions is stored in a `YAML` file with the following structure:
The system need to be able to parse this format.


```
title:
  The title of the question

author:
  Clark Kent

text: |

  A formated text block representing the body of the question.
  
  This block will contain special tokens that represent 
  user inputs, in various formats.
  tokens are surrouned by special markes as show below:
    
    *:a_dropdown:* - a dropdown
    *:a_radio_controll:* - a radio group
    *:a_checkbox:* - a checkbox
 
choices:
  a_dropdown:
    dropdown: ["a", "b", "c"]
  a_radio_controll:
    radio: ["a", "b", "c"]
  a_checkbox:
    checkbox: 


answers:
  a_dropdown: "a"
  a_radio_controll: "b"
  a_checkbox: "true"
 
explanation: |
  Formated text block containing explanation of this question.

```


## Questions Data for frontend

The format expected by the frontend is know as `edn`
short for `extensible data notation`

the output is expected by the client is similar to the yaml format,
but differes in one segnificat way.

The `:text` property of a question needs to be parsed separatly

The text property needs to split in to chunks where each chuck is
either a continous block of text or a `keyword` marker for the tokens.

The system will also need to generate an unique id for each question 
that must persist accros multiple api calls, but need not persist
accros multiple application deployments.

the output format a question is as follows:


```
{
 :id 1
 :title "The title of the question"

 :author "Clark Kent"

 :text: ["A formated text block representing the body of the question. 
          This block will contain special tokens that represent user inputs, in various formats. 
          tokens are surrouned by special markes as show below:" 
         :a_dropdown 
         " - a dropdown " 
         :a_radio_controll 
         " - a radio group " 
         :a_checkbox 
         " - a checkbox"]

 :choices {:a_dropdown {:dropdown ["a" "b" "c"]}
           :a_radio_controll {:radio ["a" "b" "c"]}
           :a_checkbox {:checkbox nil}}

 :answers { :a_dropdown "a"
            :a_radio_controll "b"
            :a_checkbox "true" }
 
 :explanation "Formated text block containing explanation of this question."

}

```


