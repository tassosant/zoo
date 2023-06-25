
# Zoo 


## Name
Zoo management system.

## Description
1. This project is a sample of zoo management system with no graphics.

2. It is able to add some animal types.

3. Also, it is able to delete specific animals by Id, search animals by id and search animals by name.

4. When displaying the animals there are info about weight, age, abilities etc.






## Installation
This app was created and tested in **intellij** using the **gradle** tool.

## Usage
1. There is a menu to choose management options

```  
Please select from 1 to 7:  
1. View all animals
2. Add a new animal
3. Search by animal name
4. Search by id
5. Delete by id
6. Feed all animals
7. Exit
```  

2. When pressing 2 a menu will appear to choose the homotaxy and then a new menu to choose the homotaxy's animals.

## Devs


1. We create a zoocontoller like these lines below:
```  
ZooController zooController = new ZooController();
zooController.handleMenu();
```  

There are two IMPORTANT FEATURES:

	*If we add a new abstract class which is subclass of Animal or a new subclass of animal's homotaxy there is no need to render the subclasses to choose, it is handled automatically by ClassesController.

	*The instantiation of classes are handled by ClassesController 



## Project status
This project is only for educational purposes

## Contributors
* Anastasios Antoniou