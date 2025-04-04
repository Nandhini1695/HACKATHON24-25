import java.util.*;

public class Main {
    static class Child {
        String name;
        int age;
        String sensitivityLevel;
        int socialSkillScore;

        public Child(String name, int age, String sensitivityLevel) {
            this.name = name;
            this.age = age;
            this.sensitivityLevel = sensitivityLevel;
            this.socialSkillScore = 50; // start at neutral
        }

        public void displayProfile() {
            System.out.println("---- Child Profile ----");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Sensitivity Level: " + sensitivityLevel);
            System.out.println("Social Skill Score: " + socialSkillScore + "/100");
            System.out.println("------------------------\n");
        }
    }

    static class VRScenario {
        String scenarioName;
        String emotionExpected;

        public VRScenario(String name, String emotion) {
            this.scenarioName = name;
            this.emotionExpected = emotion;
        }

        public void runScenario(Child child) {
            System.out.println("\n[VR SCENARIO: " + scenarioName + "]");
            System.out.println("Expected Emotion: " + emotionExpected);
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter detected emotion from child (happy, sad, angry): ");
            String emotion = sc.nextLine();

            if (emotion.equalsIgnoreCase(emotionExpected)) {
                System.out.println("✅ Great! The child responded correctly.");
                child.socialSkillScore += 10;
            } else {
                System.out.println("⚠ Try again. The child might need more practice.");
                child.socialSkillScore -= 5;
            }

            System.out.println("Updated Social Skill Score: " + child.socialSkillScore + "/100\n");
        }
    }

    static void showDashboard(Child child) {
        System.out.println("\n📊 Parent/Educator Dashboard:");
        System.out.println("Child: " + child.name);
        System.out.println("Social Skill Score: " + child.socialSkillScore + "/100");
        if (child.socialSkillScore >= 80) {
            System.out.println("Status: Excellent Progress! 🎉");
        } else if (child.socialSkillScore >= 60) {
            System.out.println("Status: Moderate Progress");
        } else {
            System.out.println("Status: Needs Attention ⚠");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create child profile
        System.out.println("Welcome to Interactive Skills Enhancer (ISE)!");
        System.out.print("Enter child's name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt(); scanner.nextLine(); // consume newline
        System.out.print("Enter sensitivity level (Low/Medium/High): ");
        String level = scanner.nextLine();

        Child child = new Child(name, age, level);
        child.displayProfile();

        // Run VR Scenarios
        VRScenario classroom = new VRScenario("Classroom Interaction", "happy");
        VRScenario playground = new VRScenario("Playground Sharing", "happy");

        classroom.runScenario(child);
        playground.runScenario(child);

        // Show dashboard
        showDashboard(child);
    }
}