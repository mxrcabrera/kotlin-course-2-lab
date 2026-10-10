/**
 * Main entry point of our Kotlin application.
 *
 * In Lesson 1 we learned that the JVM searches for a function named 'main'.
 * In Lesson 2 we learned how to capture and validate user input safely against nulls.
 * In Lesson 3 we implement the interactive main loop with exhaustive control flow.
 */

/**
 * Represents the exhaustive set of selectable options in the console main menu.
 */
enum class MenuOption {
    CHAT,
    SETTINGS,
    EXIT,
    UNKNOWN
}

fun printBanner(
    title: String = "AI Chat CLI",
    width: Int = 31,
    borderChar: Char = '='
) {
    val border = borderChar.toString().repeat(width)
    println(border)
    println("🤖 $title")
    println(border)
}

fun askForUsername(): String {
    print("Please, enter your name: ")
    val input: String? = readlnOrNull()
    return if (!input.isNullOrBlank()) input else "Guest"
}

fun parseMenuOption(rawOption: String?): MenuOption = when (rawOption) {
    "1" -> MenuOption.CHAT
    "2" -> MenuOption.SETTINGS
    "3" -> MenuOption.EXIT
    else -> MenuOption.UNKNOWN
}

fun printMenu() {
    println("\n--- Main Menu ---")
    println("1. Chat")
    println("2. Settings")
    println("3. Exit")
    print("Choose an option: ")
}

fun executeMenuOption(option: MenuOption, username: String): Boolean {
    return when (option) {
        MenuOption.CHAT -> {
            println(">>> Entering chat mode... (Work in progress)")
            true
        }
        MenuOption.SETTINGS -> {
            println(">>> Entering settings... (Work in progress)")
            true
        }
        MenuOption.EXIT -> {
            println("Goodbye, $username! See you soon.")
            false
        }
        MenuOption.UNKNOWN -> {
            println("Invalid option. Please try again.")
            true
        }
    }
}

/**
 * Main interactive entry point for the AI Chat CLI application.
 */
fun main() {
    printBanner()

    val username = askForUsername()
    println("\nHello, $username!")

    while (true) {
        printMenu()

        val rawInput = readlnOrNull()
        val option = parseMenuOption(rawInput)

        val shouldContinue = executeMenuOption(option, username)

        if (!shouldContinue) {
            break
        }
    }
}
