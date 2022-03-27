import java.util.Scanner
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    println("Fallout 4 - Console Hacker")
    println("----------------------------------------------------------------------------------------------------")
    println("First enter the words, user . to indicate words are over and enter the guesses.")
    var mode = 0;
    val solver = Solver()
    with(Scanner(System.`in`)) {
        while (true) {
            if (mode == 0) {
                print("Add word:")
            } else {
                print("Add result, word?")
            }
            val read = next()
            when (mode) {
                0 -> {

                    if (read == ".") {
                        println("Done with the words now lets guess...")
                        mode = 1
                        continue
                    } else {
                        solver.addWord(read)
                    }
                }
                1 -> {
                    print("Result:")
                    val res = nextInt()
                    val result = solver.addResult(read, res)
                    if (result != null) {
                        println("Answer is $result")
                        exitProcess(0)
                    }
                }
            }


        }

    }
}