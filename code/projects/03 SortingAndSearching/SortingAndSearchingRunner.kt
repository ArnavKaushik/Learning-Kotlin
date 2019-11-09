import kotlin.random.Random

//This will test every sort method
private fun testDifferent(NUM_TRIALS: Int, START: Int, END: Int, TYPE: Int) {
    testTime(NUM_TRIALS, START, END, TYPE, 1)
    println()
    testTime(NUM_TRIALS, START, END, TYPE, 2)
    println()
    testTime(NUM_TRIALS, START, END, TYPE, 3)
    println()
    testTime(NUM_TRIALS, START, END, TYPE, 4)
    println()
    testTime(NUM_TRIALS, START, END, TYPE, 5)
}

private fun testTime(NUM_TRIALS: Int, START: Int, END: Int, TYPE: Int, SORT_METHOD: Int) {
    var k = START
    while (k <= END) {
        val al = SortingAndSearching(k)
        val time1 = System.currentTimeMillis()
        for (j in 0 until NUM_TRIALS) {
            if (TYPE == 1) {
                al.fillRandom()
            } else if (TYPE == 2) {
                al.fillAlmostInOrder()
            } else if (TYPE == 3) {
                al.fillInOrder()
            }
            if (SORT_METHOD == 1) {
                al.bubbleSort()
            } else if (SORT_METHOD == 2) {
                al.selectionSort()
            } else if (SORT_METHOD == 3) {
                al.insertionSort()
            } else if (SORT_METHOD == 4) {
                al.mergeSort()
            } else if (SORT_METHOD == 5) {
                al.builtInSort()
            } else if (SORT_METHOD == 6) {
                al.quickSort()
            }

        }
        val time2 = System.currentTimeMillis()
        println(k.toString() + " " + (time2 - time1) / NUM_TRIALS.toDouble())
        k += 1
    }
}

//This will test every search method
private fun testDifferentSearch(NUM_TRIALS: Int, START: Int, END: Int) {
    testSearch(NUM_TRIALS, START, END, 1)
    println()
    testSearch(NUM_TRIALS, START, END, 2)
    println()

}

private fun testSearch(NUM_TRIALS: Int, START: Int, END: Int, TYPE: Int) {
    var k = START
    while (k <= END) {
        val random = Random(1234567890)
        val al = SortingAndSearching(k)

        val time1 = System.currentTimeMillis()
        for (j in 0 until NUM_TRIALS) {
            al.fillRandom()
            val key = random.nextInt(NUM_TRIALS)
            if (TYPE == 1) {
                al.linearSearch(key)
            } else if (TYPE == 2) {
                al.binarySearch(key)
            }

        }
        val time2 = System.currentTimeMillis()
        println(k.toString() + " " + (time2 - time1) / NUM_TRIALS.toDouble())
        k += 1
    }
}

fun main() {
    val NUM_TRIALS = 10
    val START = 10
    val END = 200

    println("Random")
    testDifferent(NUM_TRIALS, START, END, 1)
    println("Almost in Order")
    testDifferent(NUM_TRIALS, START, END, 2)
    println("In Order")
    testDifferent(NUM_TRIALS, START, END, 3)
    println("Search")
    testDifferentSearch(NUM_TRIALS, START, END)
}