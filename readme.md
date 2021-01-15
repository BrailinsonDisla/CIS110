# **0xff CIS110 Projects**

## Description:
This repository hosts a series of code snippets and projects completed through UPenn's F'15 & F'20 CIS110 course.

*The programs are written in Java, the programming language used throughout both courses.*

**Course Website:** [CIS110 2015 Website](https://www.cis.upenn.edu/~cis110/15fa/) | [CIS110 2020 Website](https://www.seas.upenn.edu/~cis110/20fa/)

## Cloud-Based Integrated Development Environment
* [Repl.it IDE](https://repl.it/)
   * *might require uploading and compiling of java files provided in class*
## Local Machine Integrated Development Environment
* **OS:** Kali Linux
    * [Download Binaries](https://cdimage.kali.org/)
* **Compiler:** JavaC v15.0.1
    * Debian Installation
         * `sudo apt-get install openjdk-15-jdk`
* **Debugger:** JDB v15.0.1
    * Debian Installation
         * `sudo apt-get install openjdk-15-jdk`
         
## Compiling & Running
* **Compiling:** `program.java`
   * `javac program.java`
      * creates **`program.class`**
* **Running:** `program.class`
   * `java program.class`
------------------------------------
# **Project List**
### **1. Hello, World!**
* Assignment Link: [CIS110 F'15 - Hello, World!](https://www.cis.upenn.edu/~cis110/15fa/hw/hw00/hello.html) | [CIS110 F'20 - Hello, World!](https://www.seas.upenn.edu/~cis110/current/homework/hello_world.html)
* File: [`HelloWorld.java`](Projects/1.%20Hello%20World/HelloWorld.java)
> **Description:** <br/> <br/>
> This program prints "Hello, World" to the console; a new programmer's traditional first written program. *Source code file includes notes from class that explain Java's syntax and important introductory guidelines (the rules of Java) for beginners in the subject.*
<br/>

### **2. My Sketch**
* Assignment Link: [CIS110 F'15 - MySketch](https://www.cis.upenn.edu/~cis110/15fa/hw/hw00/hello.html) | [CIS110 F'20 - MySketch](https://www.seas.upenn.edu/~cis110/current/homework/hello_world.html)
* File: [`MySketch.java`](Projects/2.%20My%20Sketch/MySketch.java)
> **Description:** <br/> <br/>
> This program uses the [`PennDraw.java`](Projects/2.%20My%20Sketch/PennDraw.java) library to draw a series of rectangles of multiple colours and successive decreasing size; creating a simple but interesting and abstract figure. Each iteration altenates between shrinking the width and height, either, by a factor of two.
<br/>

### **3. Race / Rivalry**
* Assignment Link: [CIS110 F'15 - Race](https://www.cis.upenn.edu/~cis110/15fa/hw/hw01/interactive.html) | [CIS110 F'20 - Rivalry](https://www.seas.upenn.edu/~cis110/current/homework/rivalry_click_art.html)
* File: [`Race.java`](Projects/3.%20Race/Race.java)
> **Description:** <br/> <br/>
> This program makes extensive use of the [`PennDraw.java`](Projects/3.%20Race/PennDraw.java) library, and its animation features to simulate a race between two lifelong rivals; the University of Pennsylvania and Princeton, each represented by their respective pennants in the simulation.
<br/>


### **4. Interactive Drawing / Click Art**
* Assignment Link: [CIS110 F'15 - Interactive Drawing](https://www.cis.upenn.edu/~cis110/15fa/hw/hw01/interactive.html) | [CIS110 F'20 - ClickArt](https://www.seas.upenn.edu/~cis110/current/homework/rivalry_click_art.html)
* File: [`ClickArt.java`](Projects/4.%20ClickArt/ClickArt.java)
> **Description:** <br/> <br/>
> This program makes extensive use of the [`PennDraw.java`](Projects/4.%20ClickArt/PennDraw.java) library, its animation features, and its key and mouse activity tracking abilities to provide an interactive drawing environment for the user. The environment features a sky, where birds and UFOs, seldomly, are randomly drawn; and the the green land below the horizon, where grass is randomly drawn.
> * `ANY KEY PRESS` : The background is newly drawn, as well as random drawings
> * `Click Above Horizon`: Draws a cloud **
> * `Click Below Horizon`: Draws a tree **
> <br/>&nbsp;&nbsp;&nbsp;&nbsp; ** drawn at scale from horizon
<br/>

<!--

### **X. Template**
* Assignment Link: [CIS110 F'15 - Name](https://linkfa20) | [CIS110 F'20 - Name](https://linksp21)
* File: [`name.java`](Projects/X.%20Template/name.java)
> **Description:** <br/> <br/>
> `DETAILS IN PROGRESS`
<br/>

-->
