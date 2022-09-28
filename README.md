# I decided to make this readme file as a separate branch for clarity

This project is a spring boot initialzr, preconfigured package with some slight modifications to enable connecting to an external, client-network apache derby DB

A big chunk of logic was created following a spring boot tutorial, mostly this video:

https://www.youtube.com/watch?v=vtPkZShrvXQ

Personally i recommend it as it made the process of learning spring seem easy

That being said the project had to be reconfigured to connect to a db which is not embedded so the configuration and parts of the logic were created by me with some help from spring documentation

Nothing fancy - at the moment of creating this readme file, except the mock dao classes which work with embedded db, i implemented one postmapping for adding an entry to the database, the rest will be added in the future. 

This project is WIP - Work in progress, it runs correctly and writes to the db correctly as well - but the rest of methods for get, put and delete mappings are not implemented yet - please keep that in mind in case you want to use this code

All the best! 
