package com.example.baeldungscala.classesobjects

import org.junit.jupiter.api.{Assertions, Test}

class _5_InnerClassesTest {

  @Test
  def shouldCreateInstanceOfInnerClass = {
    val demo = new DemoPlaylist

    demo.funk.addSong(demo.song1)
    // Note: Using song1 here would cause compilation error since inner class are bound to their outer classes
    demo.jazz.addSong(demo.song2)

    Assertions.assertEquals(1, demo.funk.size)
    Assertions.assertEquals(1, demo.jazz.size)
  }

  class DemoPlaylist {
    val funk = new Playlist
    val jazz = new Playlist

    var song1 = new funk.Song("We celebrate")
    val song2 = new jazz.Song("Amazing grace")
  }

  class Playlist {
    var songs: List[Song] = Nil
    def addSong(song: Song): Unit = {
      songs = song :: songs
    }
    def size: Int = songs.size

    class Song(title: String)
  }

}
