import javafx.application.*; // Required for the Application class
import javafx.stage.*;       // Required for the Stage (the window)
import javafx.scene.*;       // Required for the Scene (the container)
import javafx.scene.layout.*;// Required for layouts like GridPane
import javafx.scene.control.*;// Required for UI elements (Buttons, Fields)
import javafx.geometry.*;     // Required for positioning (Pos) and padding (Insets)
import javafx.scene.text.*;    // Required for Text and Fonts

public class LoginApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        // 1. SET UP THE WINDOW TITLE
        primaryStage.setTitle("JavaFX Welcome");

        // 2. CREATE AND CONFIG THE LAYOUT (GRID)
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER); // Center the login form in the window
        grid.setHgap(10);              // Horizontal gap between columns
        grid.setVgap(10);              // Vertical gap between rows
        grid.setPadding(new Insets(25)); // Margin around the outer edge of the grid

        // 3. CREATE AND ADD UI ELEMENTS TO THE GRID
        // Syntax: grid.add(element, column, row, column_span, row_span);
        
        Text sceneTitle = new Text("Welcome");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1); // Row 0: Spans 2 columns

        grid.add(new Label("User Name:"), 0, 1); // Row 1, Column 0
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);           // Row 1, Column 1

        grid.add(new Label("Password:"), 0, 2); // Row 2, Column 0
        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 2);           // Row 2, Column 1

        Button btn = new Button("Sign in");
        grid.add(btn, 1, 3);                     // Row 3, Column 1

        // 4. HANDLE BUTTON CLICK (AUTHENTICATION LOGIC)
        btn.setOnAction(e -> {
            // Fetch inputs directly and check against exam-specified credentials
            if ("PU".equals(userTextField.getText()) && "PU@2025Spring".equals(passwordField.getText())) {
                System.out.println("Login Successful"); // Action if correct
            } else {
                System.out.println("Login Failed");     // Action if incorrect
            }
        });

        // 5. DISPLAY THE SCENE
        // Pass the layout grid into the scene, set dimensions (Width, Height)
        primaryStage.setScene(new Scene(grid, 300, 275));
        primaryStage.show(); // Display the window
    }

    public static void main(String[] args) {
        launch(args); // Launches the JavaFX lifecycle
    }
}