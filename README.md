# Simple Calculator App

A browser-based calculator (`index.html`) that performs basic arithmetic operations — addition, subtraction, multiplication, and division — with clear result display and built-in error handling. Also included: `Calculator.java`, a console version of the same logic.

## Technologies Used

- HTML5, CSS3, JavaScript (vanilla, no frameworks or build step)
- Google Fonts (JetBrains Mono, Space Grotesk)
- Java (JDK 8+) for the console version (`Calculator.java`)

## Features

- Clickable keypad plus full keyboard support (digits, `+ - * /`, Enter, Backspace, Esc)
- Clear, formatted result display
- Handles invalid/incomplete input gracefully
- Handles division by zero without crashing, with a clear on-screen error message
- Running "receipt tape" session log of past calculations

## Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/S-rakesh409/Calculator_app.git
   cd Calculator_app
   ```

2. **Run the web calculator**
   - Simply open `index.html` in any modern browser (double-click it, or right-click → Open With → your browser). No build step or server required.

3. **(Optional) Run the Java console version**
   ```bash
   javac Calculator.java
   java Calculator
   ```

## GitHub Repository Link

https://github.com/S-rakesh409/Calculator_app
