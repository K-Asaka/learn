package bobsrockets {
    package navigation {
        class Navigator {
            // bobsrockets.navigation.StarMapと書かなくてよい
            val map = new StarMap
        }
        class StarMap
    }
    class Ship {
        // bobsrockets.navigation.Navigatorと書かなくてよい
        val nav = new navigation.Navigator
    }
    package fleets {
        class Fleet {
            // bobsrockers.Shipと書かなくてよい
            def addShip() = { new Ship }
        }
    }
}