# personal-library
(This readme will be better formatted later)

This is a personal project. Over the past few months, I've been discovering new technologies...actually, I've heard about them before, but have never use them properly. In this project, I want to gather my knowledge and just build something in my free time. Here, I'll place not only the code, but also a few other things that will help me. That will make sense later

## General Idea

As the title suggests, I want to build a personal library. At my house, we have a lot of books, so it's easy not to know if we have a specific book or no. My idea is to build an application just for catalogue those books. I choose that idea because I wanted something that I could easily imagine all the 'architecture' of the system. It had to be something that I could easily remember, and that fits with my current level of coding. Also, I can practice my english by writing this README and the message for the commits :) 

## Used technologies

I'll describe each one of them as soon as they get mentioned here. (e.g. "For achieve this, I'll use [some tech]"). This tech will be added to a list in this section.

### Server: Old PC STI, Motherboard model STI-005492, CPU Intel® Core™ 2 Duo E6300, 2GB RAM, SSD KINGSTON SA400S3 - 120GB.

First things first, I want to start to describe the hardware used in this project. I got and old PC that was just collecting dust, So I decided to use it this way. This computer has been through a lot since my father firstly bought it till I really learn how to use it in the best way (at least, the best for me). I'm particularly proud of myself for being capable of turn a computer with these specs into a personal server. It ain't much, but it's honest work ;) (Note: I just checked, and right now, I pretty sure that this PC is in the highest usage of memory of all time (since I started using as server: 561MB / 2GB). That's pretty cool)
 
### Main laptop: Samsung Essentials E20, CPU Intel® Celeron® 4205U, 8GB RAM, SSD KINGSTON SA400S3 - 480GB.

My main laptop, well, is pretty basic. My father also bought it...back at the time, I didn't had the knowledge I have today, otherwise, I'd definetely help him to get a laptop at least with a better CPU hahaha. Anyway...Just as described in the server section, I've learned how to use computers in the way that better suits my needs, so I know that it's possible to develop this project using this hardware. And what allowed me to use these computers as I described here was the Operating System, that I'll describe in the next section!

### Operating Systems: Ubuntu Server 22.04.3 LTS and Manjaro Linux

I'd say it's been nearly a year and a half since I started using GNU/Linux. I started on Linux Mint, and since last July or so, I've been using Manjaro. When my father bought this laptop, it came with 4GB of RAM, a HDD and Windows 10. Long story short, I started to use GNU/Linux in college and decided to run a live mode of Linux Mint (20.3). I was amazed by how much less RAM it consumes when compared to Windows...that's probably the main reason why I started enjoying linux that much. Having a way of using a low-end PC/Laptop without any major concerns about performance is a great advantage. 

As I said in the server description, that computer has been through a lot. It spent most of the years so far running (or trying to run) Windows 10, believe or not. Back at the time it was bought, it had 2 HDDs, so it was pretty hard to do basically anything on it. After a couple of years, early 2020, I installed a SSD in it...but I was still using Windows.. It was only in 2022, when I was already using Linux, that I decided to install in it. Well...people say "Yeah... Linux can run on any potato pc"...I didn't believe it the first time I heard, but after running Linux Mint in both computers, I definitely changed my mind. (Fun-fact: My mother needed to use the PC back at the time, and she's not comfortable at all with tech, but after I configured Mint 20.3 (with things such as renaming firefox to "INTERNET" and enabling automatic login), she quickly learned how to access her favorite streaming services... That's the history I always tell when I want to prove that GNU/Linux ain't that hard haha ).

A while after my college vacations started (December 2023), my mother didn't need the computer anymore, so I got the idea of turning it into a computer. My laptop is not strong, so even using GNU/Linux, it's still a challenge not to use all of my RAM, especially programming in Java LOL...(Note: my laptop does not have swap memory, but that's because I don't remember if the Manjaro installer gave me the option to do so, but I also got lazy and decided just to rely on Arch's lightweightness).

Anyway...I needed some OS... A friend of mine (big fan of Fedora) recommended Rocky Linux... I've searched a little about it, but as I want to learn more about the apt package manager, I decided to use Ubuntu Server...First time ever I'm using a computer without GUI. I've used TTY a lot of times, but it's the first time that I got an OS without option of having a GUI.

So...yeah, these OSs have been serving me well, so I'll probably stick with them for a time.



### Development Tools

(...)

### 'Pseudo'-data-modeling
I take a couple hours today to define the first entity of the system, in order to commit the boilerplate code and at least the first class. I asked for some help to determinate which info should I keep in the system. As my sister reads a lot, and hopefully will use this system sometimes, I asked her to think about what would she want to keep about each book. So our first entity is book, and here are it fields:
#### Entity "Book" - first draft
|                 |         |
|-----------------|---------|
| Field           | Type    |
| Title           | String  |
| Genre           | String  |
| Owner           | String  |
| Shelf Number    | Integer |
| Number of Pages | Integer |
| Author          | String  |
| Synopsis        | String  |

Based on this, I'll code the 'book' class
