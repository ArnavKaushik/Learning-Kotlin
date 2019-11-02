import java.io.File
import java.io.FileNotFoundException
import java.util.ArrayList
import java.util.Scanner

class SudokuSolver(filePath: String) {
    private val numbers: Array<IntArray>
    val SIZE = 9

    init {
        numbers = Array(SIZE) { IntArray(SIZE) }
        try {
            val scanner = Scanner(File(filePath))
            val list = ArrayList<Int>()
            while (scanner.hasNext()) {
                list.add(scanner.next().toInt())
            }
            var pos = 0
            for (r in 0 until SIZE) {
                for (c in 0 until SIZE) {
                    numbers[r][c] = list[pos]
                    pos++
                }
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }

    }

    fun solve(): Boolean {
        return solve(0, 0)
    }

    private fun solve(row: Int, col: Int): Boolean {
        var row = row
        var col = col
        if (row == SIZE) {
            row = 0
            if (++col == SIZE) {
                return true
            }
        }
        if (numbers[row][col] != 0) {
            return solve(row + 1, col)
        }
        for (k in 1..SIZE) {
            if (isPossibleDigit(k, row, col)) {
                numbers[row][col] = k
                if (solve(row + 1, col)) {
                    return true
                }
            }
        }
        numbers[row][col] = 0
        return false
    }

    private fun isPossibleDigit(number: Int, row: Int, col: Int): Boolean {
        return !isInRow(number, row) && !isInColumn(number, col) &&
                !isInSquare(number, row, col)
    }

    private fun isInSquare(k: Int, row: Int, col: Int): Boolean {
        val square = getSquare(row, col)
        return isInSquare(k, square)
    }

    private fun isInSquare(k: Int, square: Array<IntArray>): Boolean {
        for (r in square.indices) {
            for (c in 0 until square[r].size) {
                if (square[r][c] == k) {
                    return true
                }
            }
        }
        return false
    }

    private fun getSquare(row: Int, col: Int): Array<IntArray> {
        val square = Array(3) { IntArray(3) }

        val rowStart = row / 3 * 3
        val colStart = col / 3 * 3

        for (r in rowStart until rowStart + 3) {
            for (c in colStart until colStart + 3) {
                square[r - rowStart][c - colStart] = numbers[r][c]
            }
        }

        return square
    }

    private fun isInColumn(k: Int, col: Int): Boolean {
        for (i in numbers.indices) {
            if (numbers[i][col] == k) {
                return true
            }
        }
        return false
    }

    private fun isInRow(k: Int, row: Int): Boolean {
        for (i in 0 until numbers[row].size) {
            if (numbers[row][i] == k) {
                return true
            }
        }
        return false
    }

    override fun toString(): String {
        var str = ""
        for(r in numbers.indices) {
            for (c in 0 until numbers[r].size) {
                str += numbers[r][c].toString() + " "
            }
            str += "\n"
        }
        return str
    }
}
