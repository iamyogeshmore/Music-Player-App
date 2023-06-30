# Music-Player-App

- [ ] The Main class serves as the entry point for the music player application. 
It creates albums, adds songs to them, and creates a playlist.
It provides a menu-driven interface for the user to interact with the music player.
The user can view the list of songs, play the next or previous song, 
replay the current song, delete the current song from the playlist, and perform other actions.
The printMenu and printList methods are used to display information to the user, 
and the play method controls the playback of songs based on user input.

- [ ] Song class:
It represents a song and contains two instance variables: title (to store the song's title) and duration (to store the song's duration).
The class provides constructors, getters, and setters for these variables.
The toString method is overridden to provide a string representation of a Song object.

- [ ] Album class:
It represents an album and contains instance variables for the album's name, artist, and a list of songs.
The class provides constructors and methods to manage the album and its songs.
The findSong method searches for a song by its title within the album.
The addSong method adds a new song to the album if it doesn't already exist.
The addToPlayList methods allow adding songs to a playlist either by track number or by title.
Overall, these classes work together to create a simple music player application that allows the user to manage albums, create playlists, and play songs.
