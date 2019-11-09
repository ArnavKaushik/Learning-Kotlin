import kotlin.random.Random

class SortingAndSearching(n: Int) {

    var vals = Array(n) { 0 }
    var random = Random(1234567890)

    fun fillRandom() {
        for(i in vals.indices) {
            vals[i] = random.nextInt(vals.size*vals.size)
        }
    }

    fun fillInOrder() {
        var start = random.nextInt(vals.size * vals.size)
        for (i in vals.indices) {
            vals[i] = start++
        }
    }

    fun fillAlmostInOrder() {
        var start = random.nextInt(vals.size * vals.size)
        for (i in vals.indices) {
            vals[i] = start++
        }
        val a = random.nextInt(vals.size)
        val b = random.nextInt(vals.size)
        swap(a, b)
    }

    fun bubbleSort() {
        var sorting: Boolean
        var lastIndex = vals.size - 2
        do {
            sorting = false
            for (i in 0..lastIndex) {
                if (vals[i] > vals[i + 1]) {
                    sorting = true
                    swap(i, i + 1)
                }
            }
            lastIndex--
        } while (sorting)
    }

    fun swap(one: Int, two: Int) {
        val temp = vals[one]
        vals[one] = vals[two]
        vals[two] = temp
    }


    fun selectionSort() {
        for (i in 0 until vals.size - 1) {
            val indexToSwap = findMin(i)
            if (vals[i] > vals[indexToSwap]) {
                swap(i, indexToSwap)
            }
        }
    }

    fun findMin(startingIndex: Int): Int {
        if (startingIndex < vals.size - 1) {
            var min = startingIndex + 1
            for (i in startingIndex + 1 until vals.size) {
                if (vals[i] < vals[min]) {
                    min = i
                }
            }
            return min
        }
        return vals.size - 1
    }

    fun insertionSort() {
        for (g in 1 until vals.size) {
            var k = g
            while (k > 0 && vals[k] < vals[k - 1]) {
                swap(k, k - 1)
                k--
            }
        }
    }

    fun mergeSort() {
        mergeSort(0, vals.size - 1)
    }

    private fun mergeSort(a: Int, b: Int) {
        if (a < b) {
            val c = (a + b) / 2
            mergeSort(a, c)
            mergeSort(c + 1, b)
            merge(a, c, c + 1, b)
        }
    }

    private fun merge(lpStart: Int, lpStop: Int, rpStart: Int, rpStop: Int) {
        var lp = lpStart
        var rp = rpStart
        val temp = IntArray(rpStop - lpStart + 1)
        var pos = 0
        while (lp <= lpStop && rp <= rpStop) {
            if (vals[lp] <= vals[rp]) {
                temp[pos] = vals[lp]
                pos++
                lp++
            } else {
                temp[pos] = vals[rp]
                pos++
                rp++
            }
        }
        if (lp > lpStop && rp <= rpStop) {
            while (rp <= rpStop) {
                temp[pos] = vals[rp]
                rp++
                pos++
            }
        } else if (lp <= lpStop && rp > rpStop) {
            while (lp <= lpStop) {
                temp[pos] = vals[lp]
                lp++
                pos++
            }
        }
        pos = lpStart
        for (k in temp.indices) {
            vals[pos] = temp[k]
            pos++
        }
    }


    fun builtInSort() {
        vals.sort()
    }

    fun quickSort() {
        quickSort(0, vals.size - 1)
    }

    private fun quickSort(a: Int, b: Int) {
        if (a < b) {
            val partitionIndex = partition(a, b)

            quickSort(a, partitionIndex - 1)
            quickSort(partitionIndex + 1, b)
        }
    }

    private fun partition(a: Int, b: Int): Int {
        val pivot = vals[b]
        var i = a - 1
        for (j in a until b) {
            if (vals[j] <= pivot) {
                i++
                swap(i, j)
            }
        }
        swap(i + 1, b)
        return i + 1
    }


    fun linearSearch(key: Int): Int {
        for (i in vals.indices) {
            if (vals[i] == key) {
                return i
            }
        }
        return -1
    }

    fun binarySearch(key: Int): Int {
        return binarySearch(key, 0, vals.size - 1)
    }

    private fun binarySearch(key: Int, start: Int, end: Int): Int {
        if (start > end) {
            return -1
        } else {
            val mid = (start + end) / 2
            return if (vals[mid] == key) {
                mid
            } else if (key < vals[mid]) {
                binarySearch(key, 0, mid - 1)
            } else {
                binarySearch(key, mid + 1, end)
            }
        }
    }

    override fun toString(): String {
        return "ArrayAlgs{" +
                "vals=" + vals.toString() +
                '}'.toString()
    }


}