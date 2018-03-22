

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.List;

public class helloworld extends Application {

	private int i = 0;
	private int clicks = 0;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		List<String> something = CSVReaderInJava.readFromCSV("Igotthisfromawebsite.txt");
		int elements = something.size();

		primaryStage.setTitle("101 EASY WAYS TO SAY NO!");
		Button btn = new Button();
		Label label = new Label("Times clicked:" + clicks);
		btn.setText(Integer.toString(i));
		btn.setText("CLICK ME!!!!");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (i >= elements)
				{
					clicks++;
					System.out.println("I Have Nothing More To Say");
				}

				else if (i < elements)
				{
					clicks++;
					System.out.println(something.get(i));
					i++;
				}

				label.setText("Times clicked:" + clicks);

			}
		});

		StackPane root = new StackPane();
		root.setAlignment(label, Pos.TOP_CENTER);
		root.getChildren().addAll(btn, label);

		primaryStage.setScene(new Scene(root, 350, 300));
		primaryStage.show();
	}
}

