package it.polito.tdp.meteo;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

public class MeteoController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ChoiceBox<Integer> boxMese;

	@FXML
	private Button btnCalcola;

	@FXML
	private Button btnUmidita;

	@FXML
	private TextArea txtResult;

	private Model model;

	@FXML
	void doCalcolaSequenza(ActionEvent event) {

	}

	@FXML
	void doCalcolaUmidita(ActionEvent event) {
		
		List<Double> data = new LinkedList<Double>();
		
		int month;
		
		try {
			month = boxMese.getValue();
		} catch (NullPointerException e) {
			txtResult.setText("ERROR: Select a month.");
			return;
		}
		
		data = model.getUmiditaMedia(month);
		
		txtResult.clear();
		
		txtResult.setText("UMIDITA' MEDIA - MESE "+month+"\n\n");
		
		txtResult.appendText("TORINO:\t"+String.format("%.2f", data.get(0))+"%\n");
		txtResult.appendText("MILANO:\t"+String.format("%.2f", data.get(1))+"%\n");
		txtResult.appendText("GENOVA:\t"+String.format("%.2f", data.get(2))+"%\n");

	}

	@FXML
	void initialize() {
		assert boxMese != null : "fx:id=\"boxMese\" was not injected: check your FXML file 'Meteo.fxml'.";
		assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Meteo.fxml'.";
		assert btnUmidita != null : "fx:id=\"btnUmidita\" was not injected: check your FXML file 'Meteo.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Meteo.fxml'.";
	}

	public void setModel(Model model) {
		
		this.model = model;
		
		boxMese.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
		
	}

}
