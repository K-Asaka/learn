trait Increaser {
    def increase(i: Int): Int
}

def increaseOne(increaser: Increaser): Int =
    increaser.increase(1)

increaseOne(
    new Increaser {
        def increase(i: Int): Int = i + 7
    }
)

increaseOne(i => i + 7)
