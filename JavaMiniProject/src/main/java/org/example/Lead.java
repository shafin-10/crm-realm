package org.example;

/**
 * Represents a potential customer with a name,
 * email address, and score.
 */
public class Lead {

    // Immutable lead information: values cannot be reassigned after construction
    private final String fullName;
    private final String email;
    private final int score;

    /**
     * Creates a lead using the supplied information.
     *
     * @param fullName the lead's full name
     * @param email the lead's email address
     * @param score the lead's score from 0 to 100
     */
    public Lead(String fullName, String email, int score) {
        this.fullName = fullName;
        this.email = email;
        this.score = score;
    }

    // Returns the lead's email address
    public String getEmail() {
        return email;
    }

    // Returns the lead's full name
    public String getFullName() {
        return fullName;
    }

    // Returns the lead's score
    public int getScore() {
        return score;
    }


    /**
     * Calculates the lead's priority based on its score.
     *
     * @return HOT for scores 80-100,
     *         WARM for scores 50-79,
     *         COLD for scores 0-49
     */
    public String calculatePriority(){
        if (score >= 80) {
            return "HOT";
        } else if (score >= 50) {
            return "WARM";
        } else {
            return "COLD";
        }
    }


    @Override
    public String toString() {
        return "Lead{" +
                "email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", score=" + score +
                '}';
    }
}
