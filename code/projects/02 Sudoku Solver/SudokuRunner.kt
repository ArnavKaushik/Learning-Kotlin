fun getSolve(s: SudokuSolver) {
    if (s.solve()) {
        println(s)
    } else {
        getSolve(s)
    }
}

fun main() {
    val solver = SudokuSolver("src/puzzle.txt")
    getSolve(solver)
}