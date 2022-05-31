package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    public TextField tfID;
    public TextField tfArtist;
    public TextField tfAlbum;
    public TextField tfGenre;
    public TextField tfYear;

    public TableView<Songs> tvSongs;
    public TableColumn<Songs,Integer> colID;
    public TableColumn<Songs, String> colArtist;
    public TableColumn<Songs,String> colAlbum;
    public TableColumn<Songs,String> colGenre;
    public TableColumn<Songs,Integer> colYear;

    public Button btnInsert;
    public Button btnUpdate;
    public Button btnDelete;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showSongs();
    }

    public void handleButtonAction(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnInsert){
            insertRecord();
        }else if (actionEvent.getSource() == btnUpdate){
            updateRecord();
        }else if (actionEvent.getSource() == btnDelete){
            deleteRecord();
        }

    }
    public Connection getConnection(){
        Connection con;
        try{
            con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=lib;integratedSecurity=true;");
            return con;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public ObservableList<Songs> getSongsList(){
        ObservableList<Songs> songList = FXCollections.observableArrayList();
        Connection con = getConnection();
        String query = "SELECT * FROM lib.songs";
        Statement statement;
        ResultSet resultSet;

        try{
            statement = con.createStatement();
            resultSet = statement.executeQuery(query);
            Songs songs;
            while (resultSet.next()){
                songs = new Songs(resultSet.getInt("id"), resultSet.getString("artist"), resultSet.getString("album"), resultSet.getString("genre"), resultSet.getInt("year"));
                songList.add(songs);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return songList;
    }
    public void showSongs(){
        ObservableList<Songs> list = getSongsList();

        colID.setCellValueFactory(new PropertyValueFactory<Songs,Integer>("id"));
        colArtist.setCellValueFactory(new PropertyValueFactory<Songs,String>("artist"));
        colAlbum.setCellValueFactory(new PropertyValueFactory<Songs,String>("album"));
        colGenre.setCellValueFactory(new PropertyValueFactory<Songs,String>("genre"));
        colYear.setCellValueFactory(new PropertyValueFactory<Songs,Integer>("year"));

        tvSongs.setItems(list);
    }
    private void insertRecord(){
        String query = "INSERT INTO lib.songs VALUES(" + tfID.getText() + ",'"+ tfArtist.getText() + "','" + tfAlbum.getText() + "','" + tfGenre.getText() + "'," + tfYear.getText() + ")";
        executeQuery(query);
        showSongs();
        deleteFields();
    }
    private void deleteFields(){
        tfID.clear();
        tfArtist.clear();
        tfAlbum.clear();
        tfGenre.clear();
        tfYear.clear();
    }
    private void updateRecord(){
        String query = "UPDATE lib.songs SET artist = '" + tfArtist.getText() + "', album = '" + tfAlbum.getText() + "', genre = '" + tfGenre.getText() + "', year = " + tfYear.getText() + "WHERE id = " + tfID.getText() + "";
        executeQuery(query);
        showSongs();

    }
    private void deleteRecord(){
        String query = "DELETE FROM lib.songs WHERE id = " + tfID.getText() + "";
        executeQuery(query);
        showSongs();
    }

    private void executeQuery(String query){
        Connection connection = getConnection();
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML
    private void handleMouseAction(MouseEvent event){
        Songs song = tvSongs.getSelectionModel().getSelectedItem();
        tfID.setText("" + song.getId());
        tfArtist.setText(song.getArtist());
        tfAlbum.setText(song.getAlbum());
        tfGenre.setText(song.getGenre());
        tfYear.setText("" + song.getYear());
    }
}
