package ca.georgiancollege.comp1011m2022ice5;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/* Singleton */
public class SceneManager
{
    /********************* SINGLETON SECTION *****************************/
    // Step 1. private static instance member variable
    private static SceneManager m_instance = null;
    // Step 2. make the default constructor private
    private SceneManager() {}
    // Step 3. create a public static entry point / instance method
    public static SceneManager Instance()
    {
        // Step 4. Check if the private instance member variable is null
        if(m_instance == null)
        {
            // Step 5. Instantiate a new SceneManager instance
            m_instance = new SceneManager();
        }
        return m_instance;
    }
    /*********************************************************************/

    /**
     * This method will change the new scene passed into it as an argument
     * @param event
     * @param FXMLFileName
     */
    public void changeScene(ActionEvent event, String FXMLFileName) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(FXMLFileName));
        Scene scene = new Scene(fxmlLoader.load());

        // derive the stage (window) from the action event (button press)
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
