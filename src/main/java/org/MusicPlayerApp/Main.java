package org.MusicPlayerApp;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {
        Album album = new Album("Album1", "Bollywood");
        album.addSong("Apna Bana Le", 4.21);
        album.addSong("Maan Meri Jaan", 3.14);
        album.addSong("Pyaar Toh Tha", 5.0);
        albums.add(album);

        album = new Album("Album2", "Anime");
        album.addSong("Pokemon Theme", 4.5);
        album.addSong("Unravel", 3.5);
        album.addSong("Colors of the Heart", 4.5);
        albums.add(album);

        LinkedList<Song> playList_1 = new LinkedList<>();
        albums.get(0).addToPlayList("Apna Bana Le", playList_1);
        albums.get(1).addToPlayList("Pokemon Theme", playList_1);
        albums.get(0).addToPlayList("Pyaar Toh Tha", playList_1);
        albums.get(0).addToPlayList("Maan Meri Jaan", playList_1);
        albums.get(1).addToPlayList("Unravel", playList_1);
        albums.get(1).addToPlayList("Colors of the Heart", playList_1);

        play(playList_1);
    }

    private static void printMenu() {
        System.out.println("Available options\n press");
        System.out.println("""
                0 - to quit\s
                1 - list of all songs\s
                2 - to play next song
                3 - to play previous song
                3 - to replay the current song
                5 - print all available options
                6 - delete current song""");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("-----------------");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-----------------");
    }

    private static void play(LinkedList<Song> playList) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("This playlist have no song");
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            System.out.print("Enter your choice: ");
            int action = sc.nextInt();
            sc.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                case 1:
                    printList(playList);
                    break;

                case 2:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("no song available, reached to the end of the list");
                        forward = false;
                    }
                    break;

                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("we are the first song");
                        forward = false;
                    }
                    break;

                case 4:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now playing " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("we are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("now playing " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("we have reached to the end of list");
                        }
                    }
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("now playing " + listIterator.next().toString());
                        } else {
                            if (listIterator.hasPrevious())
                                System.out.println("now playing " + listIterator.previous().toString());
                        }
                    }
            }
        }
    }
}