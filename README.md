# Album-Lists

- ***Name and Surname:*** *Asel Esra Ozyilmaz*
- ***Email:*** *esra.ozyilmaz@iaau.edu.kg*
- *Computer Science Department of Alatoo International University.*
- *Individual midterm project for CS 201: Object Oriented Programming.*

<img src="https://user-images.githubusercontent.com/64264345/98457440-6f969680-21b1-11eb-8e5a-34dfa85d1560.jpg" width="800">

## Project Description

A basic Gui to keep album names and properties of them. Created with **javafx**. With the help of **mysql** all of the data inserted, deleted and updated will remain in a database. There are **9** classes & files in total (without the images), which are;

- ***Main.java :*** To start the Gui.
- ***Controller.java :*** Where all of the functions are written.
- ***sample.fxml :*** Codes written when interface is made with **SceneBuilder**.
- ***Music.java :*** Parent class.
- ***Songs.java :*** Child class which inherits from Music class and uses polymorphism.
- ***SongsTest.java :*** Test class made with JUnit testing (5 Tests are made).
- ***bgImg.css :*** For the background of the interface.
- ***lib.sql :*** Data is read and written on this file.


`Also jar file is used in order to connect mysql to java.`

<img src="https://user-images.githubusercontent.com/64264345/98457614-64446a80-21b3-11eb-8255-b0e0b57324ca.jpg" width="300">

> ### The Use Of Buttons

### Insert Button:

<img src="https://user-images.githubusercontent.com/64264345/98457439-6dccd300-21b1-11eb-8a00-66d2044ca2db.jpg" width="700"> 

### Update Button:

<img src="https://user-images.githubusercontent.com/64264345/98457438-6c030f80-21b1-11eb-957d-4a5631612914.jpg" width="700"> 

### Delete Button:

<img src="https://user-images.githubusercontent.com/64264345/98457436-6a394c00-21b1-11eb-9a43-367bdd3c1590.jpg" width="700"> <img src="https://user-images.githubusercontent.com/64264345/98457433-673e5b80-21b1-11eb-8900-e2806cf1e751.jpg" width="700">

> ### JUnit Tests

``` Java
package sample;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class SongsTest {
    Songs song = new Songs(1,"NF","The Search", "Hip-Hop",2019);

    @Test
    void getId() {
        assertEquals(1, song.getId());
    }

    @Test
    void getArtist() {
        assertEquals("NF", song.getArtist());
    }

    @Test
    void getAlbum() {
        assertEquals("The Search", song.getAlbum());
    }

    @Test
    void getGenre() {
        assertEquals("Hip-Hop", song.getGenre());
    }

    @Test
    void getYear() {
        assertEquals(2019, song.getYear());
    }
}
```
