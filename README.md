# Overview
This is a simple console version of a drawing program which currently supports a small set of commands:

# Running the program
If you have Maven and JDK 8 or above installed on your machine, simply run:
```sh
make run
```
or if you prefer Docker:
```sh
docker run -it --rm vdimitrov/console-drawing
```

# Requirements

#### Initialize a canvas
Create a new canvas of width w and height h:
```sh
C w h
```

#### Draw a line
Creates a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported:
```sh
L x1 y1 x2 y2
```

#### Draw a rectangle
Creates a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2):
```sh
R x1 y1 x2 y2
```

#### Flood-fill an area
Fills the entire area connected to (x,y) with "colour" c:
```sh
B x y c
```

#### Quit the interactive shell
```sh
Q
```