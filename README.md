# CRM Realm Technical Assessment

## 1. How to Run

### Java Application
1. Ensure Java JDK is installed.
2. Open a terminal in the Java project directory.
3. Compile the source files:

   ```bash
   javac src/*.java
   ```

   If your source files are inside a package or a different directory structure, adjust the command accordingly.

4. Run the application using the class containing the `main()` method:

   ```bash
   java -cp src Main
   ```

### JavaScript Functions
1. Ensure Node.js is installed.
2. Place the JavaScript functions and test cases in a `.js` file.
3. Run the file:

   ```bash
   node filename.js
   ```

### SQL Queries
The SQL queries are provided in `queries.sql` and are written for PostgreSQL. They can be executed against a database containing the `leads` table.

## 2. JavaScript Solution Approaches

- **First Non-Repeating Character:** Uses a `Map` to count the frequency of letters and digits, ignoring spaces and punctuation. A second pass returns the first character with a frequency of one, preserving its original case.
- **Two Sum:** Uses a `Map` to store previously visited numbers and their indices. For each number, it checks whether the required second number exists and returns the pair of indices if found.
- **Count Leads by Status:** Iterates through the leads and uses an object to count each status. It supports new status values, leaves the original array unchanged, and returns an empty object for an empty array.

## 3. Test Cases

| Problem | Input | Expected Output |
|---|---|---|
| First non-repeating character | `"aabbcdd"` | `"c"` |
| First non-repeating character | `"aabb"` | `null` |
| First non-repeating character | `"a b a"` | `null` |
| First non-repeating character | `""` | `null` |
| Two Sum | `[2, 7, 11, 15]`, target `9` | `[0, 1]` |
| Two Sum | `[3, 3]`, target `6` | `[0, 1]` |
| Two Sum | `[1, 2, 3]`, target `10` | `null` |
| Count Leads by Status | Two `NEW` leads and one `CONTACTED` lead | `{ NEW: 2, CONTACTED: 1 }` |
| Count Leads by Status | `[]` | `{}` |

For the Java application, test valid leads, missing names, invalid email addresses, scores below `0` or above `100`, and priority boundaries (`49`, `50`, `79`, and `80`).

## 4. Decision and Assumption

For the first non-repeating character problem, I chose to ignore spaces and punctuation and count only English letters and digits. Character counting is case-insensitive, but the original character is returned. For lead priority, I used HOT (80–100), WARM (50–79), and COLD (0–49).

## 5. Future Improvement

With more time, I would improve the email validation to handle more edge cases, make the Java application handle invalid user input more gracefully, and add more test cases for duplicate values, empty inputs, and boundary scores.

## 6. AI Tools and Other Resources

- **ChatGPT:** Used to clarify requirements, review my approach, understand errors, and improve explanations and documentation.
- **Official documentation:** Used as a reference for Java, JavaScript, and PostgreSQL syntax and concepts.

I reviewed the solutions and made decisions about the implementation myself.
