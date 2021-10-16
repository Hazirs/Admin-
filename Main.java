package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.w3c.dom.Text;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main extends Application {

    private ObservableList<ObservableList> data;
    private TableView viewStudent;
    private TableView viewSchool;
    private TableView viewProgram;
    private TableView viewHolidays;
    private TableView viewModules;
    private TableView viewIntakes;
    private TableView viewLecturers;
    private TableView viewGroups;

    public boolean isInteger( String input ) {
        if (input.length()!=0 || input!=null){
            try {
                Integer.parseInt( input );
                return true;
            }
            catch( Exception e ) {
                return false;
            }
        }
        else {
            return false;
        }

    }


    public void fviewStudent(){
    	
        data = FXCollections.observableArrayList();
        try{
            Db db = new Db();
            db.connect();
            ResultSet rss = db.query("SELECT * FROM student");
            String tab = "\t";

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rss.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rss.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>, ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                viewStudent.getColumns().addAll(col);
                System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rss.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rss.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rss.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            viewStudent.setItems(data);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }


    public void fviewschools(){

        data = FXCollections.observableArrayList();
        try{
            Db db = new Db();
            db.connect();
            ResultSet rss = db.query("SELECT * FROM school");
            String tab = "\t";

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rss.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rss.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>, ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                viewSchool.getColumns().addAll(col);
                System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rss.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rss.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rss.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            viewSchool.setItems(data);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }




    public void fviewPrograms(){

        data = FXCollections.observableArrayList();
        try{
            Db db = new Db();
            db.connect();
            ResultSet rss = db.query("SELECT * FROM program");
            String tab = "\t";

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rss.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rss.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>, ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                viewProgram.getColumns().addAll(col);
                System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rss.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rss.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rss.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            viewProgram.setItems(data);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }



    public void fviewIntakes(){

        data = FXCollections.observableArrayList();
        try{
            Db db = new Db();
            db.connect();
            ResultSet rss = db.query("SELECT * FROM intake;");
            String tab = "\t";

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rss.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rss.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>, ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                viewIntakes.getColumns().addAll(col);
                System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rss.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rss.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rss.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            viewIntakes.setItems(data);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }



    public void fviewHolidays(){

        data = FXCollections.observableArrayList();
        try{
            Db db = new Db();
            db.connect();
            ResultSet rss = db.query("SELECT * FROM holidays");
            String tab = "\t";

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rss.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rss.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>, ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                viewHolidays.getColumns().addAll(col);
                System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rss.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rss.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rss.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            viewHolidays.setItems(data);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }


    public void fviewModules(){

        data = FXCollections.observableArrayList();
        try{
            Db db = new Db();
            db.connect();
            ResultSet rss = db.query("SELECT * FROM module");
            String tab = "\t";

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rss.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rss.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>, ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                viewModules.getColumns().addAll(col);
                System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rss.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rss.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rss.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            viewModules.setItems(data);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }



    public void fviewLecturers(){

        data = FXCollections.observableArrayList();
        try{
            Db db = new Db();
            db.connect();
            ResultSet rss = db.query("SELECT * FROM lecturer");
            String tab = "\t";

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rss.getMetaData().getColumnCount(); i++){
                //The group members are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rss.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>, ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                viewLecturers.getColumns().addAll(col);
                System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rss.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rss.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rss.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            viewLecturers.setItems(data);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

    public void fviewGroups(){

        data = FXCollections.observableArrayList();
        try{
            Db db = new Db();
            db.connect();
            ResultSet rss = db.query("SELECT * FROM groupcode");
            String tab = "\t";

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rss.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(rss.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>, ObservableValue<String>>(){
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                        return new SimpleStringProperty(param.getValue().get(j).toString());
                    }
                });

                viewGroups.getColumns().addAll(col);
                System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rss.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rss.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rss.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data.add(row);

            }

            //FINALLY ADDED TO TableView
            viewGroups.setItems(data);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

    private String f1name="", path1="";
    Button btn_path1 = new Button("Choose CSV file");
    Button btn_addstudcsv = new Button("Import File");
    Button btn_addlectcsv = new Button("Import File"); 

    public String openfile1(Stage primaryStage){
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files","*.csv"));
        File file = fileChooser.showOpenDialog(primaryStage);
        String returningvar = null;
        if(file!=null) {
            try {
                String name = file.getName().substring(0, file.getName().length() - 4);
                f1name = name;
//                v1lbl1.setText(name);
                path1 = file.getAbsolutePath();
                System.out.println(path1);
               returningvar = path1.toString();
            }
            catch (Exception e){
                System.out.println("The error is "+ e);
            }
        }

        return returningvar;
    }







    @Override
    public void start(Stage primaryStage) throws Exception{
        String button_style = "-fx-font-size: 14px; -fx-border-color: Black; -fx-border-radius: 5px;" +
                "-fx-background-color: White; -fx-text-fill: Black;";
        String txtfield_style = "-fx-border-color: Black; -fx-border-radius: 5px;";

        final String[] prev_stud = new String[1];
        final String[] prev_school = new String[1];
        final String[] prev_holiday = new String[1];
        final String[] prev_module = new String[1];
        final String[] prev_program = new String[1];
        final String[] prev_intake = new String[1];
        final String[] prev_lect = new String[1];
        final String[] prev_group = new String[1];
      
        //LOGIN PAGE
        ImageView imgview1 = new ImageView();
        Image img1 = new Image(new File("C:\\Users\\Owner\\eclipse-workspace\\admin\\src\\sample\\img.jpeg").toURI().toURL().toExternalForm());
        imgview1.setImage(img1);

        Label wel = new Label("Admin Login");
        Label log_l1 = new Label("Username");
        Label log_l2 = new Label("Password");
        TextField log_username = new TextField();
        PasswordField log_pass = new PasswordField();
        Button login_now = new Button("Login");
        Button log_cancel = new Button("Cancel");


        VBox col1 = new VBox(20,log_l1,log_l2,login_now);
        VBox col2 = new VBox(10,log_username,log_pass,log_cancel);
        HBox login_cont_row = new HBox(10,col1,col2);
        VBox col3 = new VBox(10,wel,login_cont_row);
        col3.setAlignment(Pos.CENTER);
        HBox log_row1 = new HBox(10,imgview1,col3);
        log_row1.setAlignment(Pos.CENTER);
        VBox log_row = new VBox(10,log_row1);
        log_row.setAlignment(Pos.CENTER);
        wel.setStyle("-fx-font-weight: bold; -fx-font-size: 20px; -fx-border-color: Black; " +
                "-fx-border-radius: 5px");
        log_row.setStyle("-fx-border-color: Black;");
        login_now.setStyle(button_style);
        log_username.setStyle(txtfield_style);
        log_pass.setStyle(txtfield_style);
        log_cancel.setStyle(button_style);

       //Update ADMIN Profile
        Label up_wel = new Label("Update Admin Profile");
        Label up_l1 = new Label("Username ");
        Label up_l2 = new Label("Email ");
        Label up_l3 = new Label("Reset Password ");
        TextField up_name = new TextField();
        TextField up_mail = new TextField();
        PasswordField up_pass = new PasswordField();
        Button up_now = new Button("Save");
        Button up_cancel = new Button("Cancel");
        VBox up_col1 = new VBox(18,up_l1,up_l2,up_l3,up_now);
        VBox up_col2 = new VBox(10,up_name,up_mail,up_pass,up_cancel);
        HBox up_log_row1 = new HBox(10,up_col1,up_col2);
        up_log_row1.setAlignment(Pos.CENTER);



        //View Buttons
        Button btn_viewStudents = new Button("View Student");
        Button btn_viewSchools = new Button("View School");
        Button btn_viewPrograms = new Button("View Program");
        Button btn_viewHolidays = new Button("View Holiday");
        Button btn_viewModules = new Button("View Module");
        Button btn_viewIntakes = new Button("View InTake");
        Button btn_viewLecturers = new Button("View Lecturer");
        Button btn_viewGroups = new Button("View Group");
        btn_viewStudents.setStyle(button_style);
        btn_viewSchools.setStyle(button_style);
        btn_viewPrograms.setStyle(button_style);
        btn_viewHolidays.setStyle(button_style);
        btn_viewModules.setStyle(button_style);
        btn_viewIntakes.setStyle(button_style);
        btn_viewLecturers.setStyle(button_style);
        btn_viewGroups.setStyle(button_style);

        //Update Buttons
        Button btn_updateStudents = new Button("Update Student");
        Button btn_updateSchools = new Button("Update School");
        Button btn_updatePrograms = new Button("Update Program");
        Button btn_updateHolidays = new Button("Update Holiday");
        Button btn_updateModules = new Button("Update Module");
        Button btn_updateIntake = new Button("Update InTake");
        Button btn_updateLecturers = new Button("Update Lecturer");
        Button btn_updateProfile = new Button("Update Profile");
        Button btn_updateGroups = new Button("Update Group");
        btn_updateStudents.setStyle(button_style);
        btn_updateSchools.setStyle(button_style);
        btn_updatePrograms.setStyle(button_style);
        btn_updateHolidays.setStyle(button_style);
        btn_updateModules.setStyle(button_style);
        btn_updateIntake.setStyle(button_style);
        btn_updateLecturers.setStyle(button_style);
        btn_updateProfile.setStyle(button_style);
        btn_updateGroups.setStyle(button_style);

        //Add Buttons
        Button btn_addStudents = new Button("Add Student");
        Button btn_addLecturers = new Button("Add Lecturer"); 
        Button btn_addSchools = new Button("Add School");
        Button btn_addPrograms = new Button("Add Program");
        Button btn_addHolidays = new Button("Add Holiday");
        Button btn_addModule = new Button("Add Module");
        Button btn_addIntake = new Button("Add InTake");
        Button btn_addc_lecturer = new Button("Add Lecturer");
        Button btn_addGroups = new Button("Add Groups");
        btn_addStudents.setStyle(button_style);
        btn_addLecturers.setStyle(button_style); 
        btn_addSchools.setStyle(button_style);
        btn_addPrograms.setStyle(button_style);
        btn_addHolidays.setStyle(button_style);
        btn_addModule.setStyle(button_style);
        btn_addIntake.setStyle(button_style);
        btn_addc_lecturer.setStyle(button_style);
        btn_addGroups.setStyle(button_style);

        //Add Student
        Label l_astud_welcom = new Label("Fill in the fields");
        Label l_astud_ID  = new Label("Student ID");
        Label l_astud_fname = new Label("First Name");
        Label l_astud_lname = new Label("Last Name");
        Label l_astud_intakeIDfk = new Label("Intake ID");
        Label l_astud_email = new Label("Email Address");
        Label l_astud_password = new Label("Password");
        Label l_astud_defaultps = new Label("Default Password");
        Label l_astud_active = new Label("Active");
        Label l_astud_groupcodeidfk = new Label("Group Code ID");
        Label l_astud_programidfk = new Label("Program ID");
        Label l_astud_schoolidfk = new Label("Program Title");
        TextField t_astud_ID = new TextField();
        TextField t_astud_fname = new TextField();
        TextField t_astud_lname = new TextField();
        ComboBox astud_intakeIDfk = new ComboBox();
        TextField t_astud_email = new TextField();
        TextField t_astud_password = new TextField();
        TextField t_astud_defaulps = new TextField();
        ComboBox astud_active = new ComboBox();
        ComboBox astud_groupcodeidfk = new ComboBox();
        ComboBox astud_programidfk = new ComboBox();
        ComboBox astud_schoolidfk= new ComboBox();
        Button btn_asave_stud = new Button("Save");
        Button btn_acancel_stud = new Button("Cancel");
        Button btn_astud_canc = new Button("Cancel");
        VBox l_astud_col1 = new VBox(18,l_astud_ID,l_astud_fname,l_astud_lname,l_astud_intakeIDfk,l_astud_email,l_astud_password,l_astud_defaultps,l_astud_active,l_astud_groupcodeidfk,l_astud_programidfk,l_astud_schoolidfk, btn_asave_stud,btn_path1);
        VBox l_astud_col2 = new VBox(10,t_astud_ID,t_astud_fname,t_astud_lname,astud_intakeIDfk,t_astud_email,t_astud_password,t_astud_defaulps,astud_active,astud_groupcodeidfk,astud_programidfk, astud_schoolidfk, btn_astud_canc,btn_addstudcsv);
        HBox astud_main_row = new HBox(10,l_astud_col1,l_astud_col2);
        astud_main_row.setAlignment(Pos.CENTER);



        //Update Student
        Label l_ustud_welcom = new Label("Fill in the fields");
        Label l_ustud_ID  = new Label("Student ID");
        Label l_ustud_fname = new Label("First Name");
        Label l_ustud_lname = new Label("Last Name");
        Label l_ustud_intakeIDfk = new Label("Intake ID");
        Label l_ustud_email = new Label("Email Address");
        Label l_ustud_password = new Label("Password");
        Label l_ustud_defaultps = new Label("Default Password");
        Label l_ustud_active = new Label("Active");
        Label l_ustud_groupcodeidfk = new Label("Group Code ID");
        Label l_ustud_programidfk = new Label("Program ID");
        Label l_ustud_schoolidfk = new Label("School ID");
        TextField t_ustud_ID = new TextField();
        TextField t_ustud_fname = new TextField();
        TextField t_ustud_lname = new TextField();
        ComboBox ustud_intakeIDfk = new ComboBox();
        TextField t_ustud_email = new TextField();
        TextField t_ustud_password = new TextField();
        TextField t_ustud_defaulps = new TextField();
        t_ustud_ID.setStyle(txtfield_style);
        t_ustud_fname.setStyle(txtfield_style);
        t_ustud_lname.setStyle(txtfield_style);
        t_ustud_email.setStyle(txtfield_style);
        t_ustud_password.setStyle(txtfield_style);
        t_ustud_defaulps.setStyle(txtfield_style);
        ComboBox ustud_active = new ComboBox();
        ComboBox ustud_groupcodeidfk = new ComboBox();
        ComboBox ustud_programidfk = new ComboBox();
        ComboBox ustud_schoolidfk= new ComboBox();
        Button btn_usave_stud = new Button("Update");
        Button btn_ucancel_stud = new Button("Cancel");
        btn_usave_stud.setStyle(button_style);
        btn_ucancel_stud.setStyle(button_style);
        VBox l_ustud_col1 = new VBox(18,l_ustud_ID,l_ustud_fname,l_ustud_lname,l_ustud_intakeIDfk,l_ustud_email,l_ustud_password,l_ustud_defaultps,l_ustud_active,l_ustud_groupcodeidfk,l_ustud_programidfk,l_ustud_schoolidfk, btn_usave_stud);
        VBox l_ustud_col2 = new VBox(10,t_ustud_ID,t_ustud_fname,t_ustud_lname,ustud_intakeIDfk,t_ustud_email,t_ustud_password,t_ustud_defaulps,ustud_active,ustud_groupcodeidfk,ustud_programidfk, ustud_schoolidfk, btn_ucancel_stud);
        HBox ustud_main_row = new HBox(10,l_ustud_col1,l_ustud_col2);
        ustud_main_row.setAlignment(Pos.CENTER);


        //Add Lecturer 
        Label l_alect_welcom = new Label("Fill in the fields");
        Label l_alect_ID  = new Label("Lecturer ID");
        Label l_alect_fname = new Label("First Name");
        Label l_alect_lname = new Label("Last Name");
        Label l_alect_email = new Label("Email Address");
        Label l_alect_password = new Label("Password");
        Label l_alect_defaultps = new Label("Default Password");
        Label l_alect_active = new Label("Active");
        Label l_alect_schoolidfk = new Label("School");
        TextField t_alect_ID = new TextField();
        TextField t_alect_fname = new TextField();
        TextField t_alect_lname = new TextField();
        TextField t_alect_email = new TextField();
        TextField t_alect_password = new TextField();
        TextField t_alect_defaultps = new TextField();
        ComboBox alect_active = new ComboBox();
        ComboBox alect_schoolidfk= new ComboBox();
        Button btn_asave_lect = new Button("Save");
        Button btn_acancel_lect = new Button("Cancel");
        Button btn_alect_canc = new Button("Cancel");
        VBox l_alect_col1 = new VBox(18,l_alect_ID,l_alect_fname,l_alect_lname,l_alect_email,l_alect_password,l_alect_defaultps,l_alect_active,l_alect_schoolidfk, btn_asave_lect,btn_path1);
        VBox l_alect_col2 = new VBox(10,t_alect_ID,t_alect_fname,t_alect_lname,t_alect_email,t_alect_password,t_alect_defaultps,alect_active, alect_schoolidfk, btn_alect_canc,btn_addlectcsv);
        HBox alect_main_row = new HBox(10,l_alect_col1,l_alect_col2);
        alect_main_row.setAlignment(Pos.CENTER);


        //Update Lecturer
        Label l_ulect_welcom = new Label("Fill in the fields");
        Label l_ulect_ID  = new Label("Lecturer ID");
        Label l_ulect_fname = new Label("First Name");
        Label l_ulect_lname = new Label("Last Name");
        Label l_ulect_email = new Label("Email Address");
        Label l_ulect_password = new Label("Password");
        Label l_ulect_defaultps = new Label("Default Password");
        Label l_ulect_active = new Label("Active");
        Label l_ulect_schoolidfk = new Label("School ID");
        TextField t_ulect_ID = new TextField();
        TextField t_ulect_fname = new TextField();
        TextField t_ulect_lname = new TextField();
        TextField t_ulect_email = new TextField();
        TextField t_ulect_password = new TextField();
        TextField t_ulect_defaulps = new TextField();
        t_ulect_ID.setStyle(txtfield_style);
        t_ulect_fname.setStyle(txtfield_style);
        t_ulect_lname.setStyle(txtfield_style);
        t_ulect_email.setStyle(txtfield_style);
        t_ulect_password.setStyle(txtfield_style);
        t_ulect_defaulps.setStyle(txtfield_style);
        ComboBox ulect_active = new ComboBox();
        ComboBox ulect_schoolidfk= new ComboBox();
        Button btn_usave_lect = new Button("Update");
        Button btn_ucancel_lect = new Button("Cancel");
        btn_acancel_lect.setStyle(button_style);
        btn_usave_lect.setStyle(button_style);
        btn_ucancel_lect.setStyle(button_style);
        VBox l_ulect_col1 = new VBox(18,l_ulect_ID,l_ulect_fname,l_ulect_lname,l_ulect_email,l_ulect_password,l_ustud_defaultps,l_ustud_active,l_ustud_schoolidfk, btn_usave_lect);
        VBox l_ulect_col2 = new VBox(10,t_ulect_ID,t_ulect_fname,t_ulect_lname,t_ulect_email,t_ulect_password,t_ulect_defaulps,ulect_active, ulect_schoolidfk, btn_ucancel_lect);
        HBox ulect_main_row = new HBox(10,l_ulect_col1,l_ulect_col2);
        ulect_main_row.setAlignment(Pos.CENTER);


        //Add School - done
        Label l_asch_welcom = new Label("Fill in the fields");
        Label l_asch_ID = new Label("School ID  ");
        Label l_asch_Name = new Label("School Name");
        TextField t_asch_ID = new TextField();
        TextField t_asch_Name = new TextField();
        Button btn_cancelSchool = new Button("Cancel");
        Button btn_saveSchool = new Button("Save");
        Button btn_aschool_canc = new Button("Cancel");
        t_asch_ID.setStyle(txtfield_style);
        t_asch_Name.setStyle(txtfield_style);
        btn_saveSchool.setStyle(button_style);
        btn_aschool_canc.setStyle(button_style);
        HBox hBox_row1_addstud = new HBox(l_asch_welcom);
        VBox a_school_col1 = new VBox(18,l_asch_ID,l_asch_Name,btn_saveSchool);
        VBox a_school_col2 = new VBox(10,t_asch_ID,t_asch_Name,btn_aschool_canc);
        HBox a_school_main_row = new HBox(10,a_school_col1,a_school_col2);
        hBox_row1_addstud.setAlignment(Pos.CENTER);
        a_school_main_row.setAlignment(Pos.CENTER);

        //Update School
        Label l_usch_welcom = new Label("Fill in the fields");
        Label l_usch_ID = new Label("School ID  ");
        Label l_usch_Name = new Label("School Name");
        TextField t_usch_ID = new TextField();
        TextField t_usch_Name = new TextField();
        Button btn_usaveSchool = new Button("Update");
        Button btn_ucancelSchool = new Button("Cancel");
        t_usch_ID.setStyle(txtfield_style);
        t_usch_Name.setStyle(txtfield_style);
        btn_usaveSchool.setStyle(button_style);
        btn_usaveSchool.setStyle(button_style);
        btn_ucancelSchool.setStyle(button_style);
        VBox u_school_col1 = new VBox(18,l_usch_ID,l_usch_Name,btn_usaveSchool);
        VBox u_school_col2 = new VBox(10,t_usch_ID,t_usch_Name,btn_ucancelSchool);
        HBox u_school_main_row = new HBox(10,u_school_col1,u_school_col2);
        u_school_main_row.setAlignment(Pos.CENTER);


        //Add Program 
        Label l_aprog_welcom = new Label("Fill in the fields");
        Label l_aprog_ID = new Label("Program ID  ");
        Label l_aprog_title = new Label("School Title");
        TextField t_aprog_ID = new TextField();
        TextField t_aprog_title = new TextField();
        Button btn_saveprog = new Button("Save");
        Button btn_aprog_canc = new Button("Cancel");
        t_aprog_ID.setStyle(txtfield_style);
        t_aprog_title.setStyle(txtfield_style);
        btn_saveprog.setStyle(button_style);
        btn_aprog_canc.setStyle(button_style);
        VBox a_prog_col1 = new VBox(18,l_aprog_ID,l_aprog_title,btn_saveprog);
        VBox a_prog_col2 = new VBox(10,t_aprog_ID,t_aprog_title,btn_aprog_canc);
        HBox a_prog_row1 = new HBox(10,a_prog_col1,a_prog_col2);
       a_prog_row1.setAlignment(Pos.CENTER);


        //Add InTake
        Label l_aintake_welcom = new Label("Fill in the fields");
        Label l_aintake_ID = new Label("InTake ID  ");
        Label l_aintake_title = new Label("Intake");
        TextField t_aintake_ID = new TextField();
        TextField t_aintake_title = new TextField();
        Button btn_saveintake = new Button("Save");
        Button btn_aintake_canc = new Button("Cancel");
        t_aintake_ID.setStyle(txtfield_style);
        t_aintake_title.setStyle(txtfield_style);
        btn_saveintake.setStyle(button_style);
        btn_aintake_canc.setStyle(button_style);
        VBox a_intake_col1 = new VBox(18,l_aintake_ID,l_aintake_title,btn_saveintake);
        VBox a_intake_col2 = new VBox(10,t_aintake_ID,t_aintake_title,btn_aintake_canc);
        HBox a_intake_row1 = new HBox(10,a_intake_col1,a_intake_col2);
        a_intake_row1.setAlignment(Pos.CENTER);



        //Update Intake
        Label l_uintake_welcom = new Label("Fill in the fields");
        Label l_uintake_ID = new Label("Intake ID  ");
        Label l_uintake_title = new Label("Intake");
        TextField t_uintake_ID = new TextField();
        TextField t_uintake_title = new TextField();
        Button btn_usaveintake = new Button("Update");
        Button btn_ucancelintake = new Button("Cancel");
        t_uintake_ID.setStyle(txtfield_style);
        t_uintake_title.setStyle(txtfield_style);
        btn_usaveintake.setStyle(button_style);
        btn_ucancelintake.setStyle(button_style);
        VBox u_intake_col1 = new VBox(18,l_uintake_ID,l_uintake_title,btn_usaveintake);
        VBox u_intake_col2 = new VBox(10,t_uintake_ID,t_uintake_title,btn_ucancelintake);
        HBox u_intake_row1 = new HBox(10,u_intake_col1,u_intake_col2);
        u_intake_row1.setAlignment(Pos.CENTER);





        //Add Group
        Label l_agroup_welcom = new Label("Fill in the fields");
        Label l_agroup_ID = new Label("GroupCode ID  ");
        Label l_agroup_code = new Label("Group Code");
        TextField t_agroup_ID = new TextField();
        TextField t_agroup_code = new TextField();
        Button btn_asavegroup = new Button("Save");
        Button btn_agroup_canc = new Button("Cancel");
        t_agroup_ID.setStyle(txtfield_style);
        t_agroup_code.setStyle(txtfield_style);
        btn_asavegroup.setStyle(txtfield_style);
        btn_agroup_canc.setStyle(txtfield_style);
        VBox a_group_col1 = new VBox(18,l_agroup_ID,l_agroup_code,btn_asavegroup);
        VBox a_group_col2 = new VBox(10,t_agroup_ID,t_agroup_code,btn_agroup_canc);
        HBox a_group_row1 = new HBox(10,a_group_col1,a_group_col2);
        a_group_row1.setAlignment(Pos.CENTER);



        //Update Group
        Label l_ugroup_welcom = new Label("Fill in the fields");
        Label l_ugroup_ID = new Label("GroupCode ID  ");
        Label l_ugroup_code = new Label("Group Code");
        TextField t_ugroup_ID = new TextField();
        TextField t_ugroup_code = new TextField();
        Button btn_usavegroup = new Button("Update");
        Button btn_ugroup_canc = new Button("Cancel");
        t_ugroup_ID.setStyle(txtfield_style);
        t_ugroup_code.setStyle(txtfield_style);
        btn_usavegroup.setStyle(button_style);
        btn_ugroup_canc.setStyle(button_style);
        VBox u_group_col1 = new VBox(18,l_ugroup_ID,l_ugroup_code,btn_usavegroup);
        VBox u_group_col2 = new VBox(10,t_ugroup_ID,t_ugroup_code,btn_ugroup_canc);
        HBox u_group_row1 = new HBox(10,u_group_col1,u_group_col2);
        u_group_row1.setAlignment(Pos.CENTER);




        //Update Program
        Label l_uprog_welcom = new Label("Fill in the fields");
        Label l_uprog_ID = new Label("Program ID  ");
        Label l_uprog_title = new Label("School Title");
        TextField t_uprog_ID = new TextField();
        TextField t_uprog_title = new TextField();
        Button btn_usaveprog = new Button("Update");
        Button btn_ucancelprog = new Button("Cancel");
        t_uprog_ID.setStyle(txtfield_style);
        t_uprog_title.setStyle(txtfield_style);
        btn_usaveprog.setStyle(button_style);
        btn_ucancelprog.setStyle(button_style);
        VBox u_prog_col1 = new VBox(18,l_uprog_ID,l_uprog_title,btn_usaveprog);
        VBox u_prog_col2 = new VBox(10,t_uprog_ID,t_uprog_title,btn_ucancelprog);
        HBox u_prog_row1 = new HBox(10,u_prog_col1,u_prog_col2);
        u_prog_row1.setAlignment(Pos.CENTER);


        //Add holiday
        Label l_aholi_welcom = new Label("Fill in the fields");
        Label l_aholi_Name = new Label("Holiday Name  ");
        Label l_aholi_Date = new Label("Holiday Date");
        TextField t_aholi_Name = new TextField();
        DatePicker t_aholi_date = new DatePicker();
        Button btn_saveholi = new Button("Save");
        Button btn_cancelholi = new Button("Cancel");
        t_aholi_Name.setStyle(txtfield_style);
        t_aholi_date.setStyle(txtfield_style);
        btn_saveholi.setStyle(button_style);
        btn_cancelholi.setStyle(button_style);

        VBox a_holi_col1 = new VBox(18,l_aholi_Name,l_aholi_Date,btn_saveholi);
        VBox a_holi_col2 = new VBox(10,t_aholi_Name,t_aholi_date,btn_cancelholi);
        HBox a_holi_main_row = new HBox(10,a_holi_col1,a_holi_col2);
        a_holi_main_row.setAlignment(Pos.CENTER);



        //Udpate Holiday
        Label l_uholi_welcom = new Label("Fill The Fields");
        Label l_uholi_Name = new Label("Holiday Name:  ");
        Label l_uholi_Date = new Label("Holiday Date");
        TextField t_uholi_Name = new TextField();
        DatePicker t_uholi_date = new DatePicker();
        Button btn_usaveholi = new Button("Update");
        Button btn_ucancelholi = new Button("Cancel");
        t_uholi_Name.setStyle(txtfield_style);
        t_uholi_date.setStyle(txtfield_style);
        btn_usaveholi.setStyle(button_style);
        btn_ucancelholi.setStyle(button_style);
        VBox u_holi_col1 = new VBox(18,l_uholi_Name,l_uholi_Date,btn_usaveholi);
        VBox u_holi_col2 = new VBox(10,t_uholi_Name,t_uholi_date,btn_ucancelholi);
        HBox u_holi_main_row = new HBox(10,u_holi_col1,u_holi_col2);
        u_holi_main_row.setAlignment(Pos.CENTER);


        //Add Module
        Label l_amodule_welcom = new Label("Fill in the fields");
        Label l_amodule_ID = new Label("Module ID  ");
        Label l_amodule_Code = new Label("Module Code");
        Label l_amodule_Name = new Label("Module Name");
        TextField t_amodule_ID = new TextField();
        TextField t_amodule_Code = new TextField();
        TextField t_amodule_Name = new TextField();
        Button btn_savemodlue = new Button("Save");
        Button btn_cancelmodule = new Button("Cancel");
        t_amodule_ID.setStyle(txtfield_style);
        t_amodule_Code.setStyle(txtfield_style);
        t_amodule_Name.setStyle(txtfield_style);
        btn_savemodlue.setStyle(button_style);
        btn_cancelmodule.setStyle(button_style);
        VBox a_module_col1 = new VBox(18,l_amodule_ID,l_amodule_Code,l_amodule_Name,btn_savemodlue);
        VBox a_module_col2 = new VBox(10,t_amodule_ID,t_amodule_Code,t_amodule_Name,btn_cancelmodule);
        HBox a_moduel_main_row = new HBox(10,a_module_col1,a_module_col2);
        a_moduel_main_row.setAlignment(Pos.CENTER);



        //Update Module
        Label l_umodule_welcom = new Label("Fill in the fields");
        Label l_umodule_ID = new Label("Module ID  ");
        Label l_umodule_Code = new Label("Module Code");
        Label l_umodule_Name = new Label("Module Name");
        TextField t_umodule_ID = new TextField();
        TextField t_umodule_Code = new TextField();
        TextField t_umodule_Name = new TextField();
        Button btn_usavemodlue = new Button("Save");
        Button btn_ucancelmodule = new Button("Cancel");
        t_umodule_ID.setStyle(txtfield_style);
        t_umodule_Code.setStyle(txtfield_style);
        t_umodule_Name.setStyle(txtfield_style);
        btn_usavemodlue.setStyle(button_style);
        btn_ucancelmodule.setStyle(button_style);
        VBox u_module_col1 = new VBox(18,l_umodule_ID,l_umodule_Code,l_umodule_Name,btn_usavemodlue);
        VBox u_module_col2 = new VBox(10,t_umodule_ID,t_umodule_Code,t_umodule_Name,btn_ucancelmodule);
        HBox u_moduel_main_row = new HBox(10,u_module_col1,u_module_col2);
        u_moduel_main_row.setAlignment(Pos.CENTER);


        HBox homebtns1 = new HBox(10,btn_viewStudents, btn_viewSchools, btn_viewPrograms, btn_viewHolidays, btn_viewModules,btn_viewIntakes,btn_viewLecturers);
        HBox homebtns2 = new HBox(10,btn_addStudents, btn_addLecturers, btn_addSchools, btn_addPrograms, btn_addHolidays,btn_addModule,btn_addIntake,btn_updateProfile);

        //Image BACKGROUND
        ImageView imgview2 = new ImageView();
        Image img2 = new Image(new File("C:\\Users\\Owner\\eclipse-workspace\\admin\\src\\sample\\img.jpeg").toURI().toURL().toExternalForm());
        imgview2.setImage(img1);



        HBox home_btn0 = new HBox(10,imgview2);
        home_btn0.setAlignment(Pos.CENTER);
        HBox home_btn1 = new HBox(20,btn_viewStudents,btn_viewLecturers);
        home_btn1.setAlignment(Pos.CENTER);
        HBox home_btn2 = new HBox(20,btn_viewSchools,btn_viewPrograms,btn_viewIntakes,btn_viewGroups, btn_viewModules);
        home_btn2.setAlignment(Pos.CENTER);
        HBox home_btn3 = new HBox(20, btn_viewHolidays, btn_updateProfile);
        home_btn3.setAlignment(Pos.CENTER);
        VBox m_homebtn = new VBox(20,home_btn0,home_btn1,home_btn2,home_btn3);
        m_homebtn.setAlignment(Pos.CENTER);


        Button btn_back = new Button("<-- Go Back");
        btn_back.setStyle(button_style);

        //LOGIN
        //START THE FUNCTIONS ON EACH BUTTONS CLICKED
        
        log_cancel.setOnAction(e->{
            Platform.exit();
        });

        login_now.setOnAction(e->{
            System.out.println("you are trying to login");
            String username;
            String password;
            String e_username = log_username.getText();
            String e_pass = log_pass.getText();
            boolean login = false;
            try {
                Db db = new Db();
                db.connect();
                ResultSet rss = db.query("SELECT * FROM admin;");
                while (rss.next()){
                	username = rss.getString("username");
                    password = rss.getString("newPassword");
                    if (username.equals(e_username) && password.equals(e_pass)){
                        login = true;
                    }
                    System.out.println("theeeee");
                    System.out.println(username+password);
                }
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            if (login == true){

                primaryStage.setTitle("Admin Panel");
                primaryStage.setScene(new Scene(m_homebtn, 700,500));
                primaryStage.centerOnScreen();
                primaryStage.show();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Welcome");
                alert.setHeaderText("Welcome");
                alert.setContentText("Logged-In Successfully!");
                alert.showAndWait();
            }
            else if(login != true){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Creddentials Miss-Matched");
                alert.setHeaderText("Login Failed!");
                alert.setContentText("Seems that credentials you entered are incorrect");
                alert.showAndWait();
            }


        });


        //Update Profile Listener
        btn_updateProfile.setOnAction(e->{
            VBox up_log_row = new VBox(10,up_wel,up_log_row1);
            up_log_row.setAlignment(Pos.CENTER);

            primaryStage.setTitle("Update Admin Profile");
            primaryStage.setScene(new Scene(up_log_row, 500, 500));


            String modID = null;
            String modCode = null;
            String modName = null;

            try {
                Db db = new Db();
                db.connect();
                ResultSet rss = db.query("SELECT * FROM admin;");
                while (rss.next()){
                    modID = rss.getString("username");
                    modCode = rss.getString("email");
                    modName = rss.getString("newPassword");
                    System.out.println("theeeee");
                    System.out.println(modID+modCode+modName);
                }
                up_name.setText(modID);
                up_mail.setText(modCode);
                up_pass.setText(modName);
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        });

        up_now.setOnAction(e->{
            String name = up_name.getText();
            String email = up_mail.getText();
            String pass = up_pass.getText();
            boolean saved = true;
            boolean occur = false;

                String quer = "UPDATE admin SET username = \'"+name+"\', email = \'"+email+"\', newPassword = \'"+pass+"\' WHERE admin.adminID = "+1+";";
                Db db = new Db();
                try {
                    db.InsertSchool(quer);
                } catch (SQLException | ClassNotFoundException throwables) {
                    saved = false;
                    throwables.printStackTrace();
                    System.out.println("Saving failed");

                }


            if (saved==true){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succeeded!");
                alert.setHeaderText(null);
                alert.setContentText("Data Stored Successfully!");
                alert.showAndWait();
            }

        });



        //Update Module Listener
        btn_updateModules.setOnAction(e->{
            if(prev_module[0]!=null){
                VBox root = new VBox(10,l_umodule_welcom,u_moduel_main_row);
                root.setAlignment(Pos.CENTER);
                primaryStage.setTitle("Update Module");
                primaryStage.setScene(new Scene(root, 500, 500));
                String modID = null;
                String modCode = null;
                String modName = null;
                int idd = Integer.parseInt(prev_module[0]);
                try {
                    Db db = new Db();
                    db.connect();
                    ResultSet rss = db.query("SELECT * FROM module WHERE moduleID="+idd+";");
                    while (rss.next()){
                        modID = rss.getString("moduleID");
                        modCode = rss.getString("moduleCode");
                        modName = rss.getString("moduleName");
                        System.out.println("theeeee");
                        System.out.println(modID+modCode+modName);
                    }
                    t_umodule_ID.setText(modID);
                    t_umodule_Code.setText(modCode);
                    t_umodule_Name.setText(modName);
                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("No Record Selected!");
                alert.setHeaderText(null);
                alert.setContentText("It seems that you have selected no record!");
                alert.showAndWait();
            }

        });
        btn_usavemodlue.setOnAction(e->{
            String ID = t_umodule_ID.getText();
            String code = t_umodule_Code.getText();
            String name = t_umodule_Name.getText();
            int idd = Integer.parseInt(prev_program[0]);
            boolean yes = isInteger(ID);
            boolean saved = true;
            boolean occur = false;
            if (yes == true){
                String quer = "UPDATE module SET moduleID = \'"+ID+"\', moduleCode = \'"+code+"\', moduleName = \'"+name+"\' WHERE program.programID = "+idd+";";
                Db db = new Db();
                try {
                    db.InsertSchool(quer);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                    System.out.println("Saving failed");
                    saved = false;
                }
            }
            else{
                saved = false;
                occur = true;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Type Error");
                alert.setHeaderText("Type Miss Matched");
                alert.setContentText("Only Integer Values are allowed in the ID");
                alert.showAndWait();
            }
            if (saved==true){
                t_umodule_ID.setText("");
                t_umodule_Code.setText("");
                t_umodule_Name.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succeeded!");
                alert.setHeaderText(null);
                alert.setContentText("Data Stored Successfully!");
                alert.showAndWait();
            }

        });


        //Update Holidays Listener
        btn_updateHolidays.setOnAction(e->{
            if(prev_holiday[0]!=null){
                VBox root = new VBox(10,l_uholi_welcom,u_holi_main_row);
                root.setAlignment(Pos.CENTER);
                root.setAlignment(Pos.CENTER);
                primaryStage.setTitle("Update Holidays");
                primaryStage.setScene(new Scene(root, 500, 500));
                String holiday = prev_holiday[0];
                String holi = null;
                try {
                    Db db = new Db();
                    db.connect();
                    ResultSet rss = db.query("SELECT * FROM holidays WHERE holidayName LIKE \'"+holiday+"\';");
                    while (rss.next()){
                        holi = rss.getString("holidayName");

                        System.out.println("theeeee");
                        System.out.println(holi);
                    }
                    t_uholi_Name.setText(holi);

                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }

            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("No Record Selected!");
                alert.setHeaderText(null);
                alert.setContentText("It seems that you have selected no record!");
                alert.showAndWait();
            }
        });
        btn_usaveholi.setOnAction(e->{
            String name = t_uholi_Name.getText();
            Date thedate = Date.valueOf(t_uholi_date.getValue());
            String dateval = thedate.toString();
            System.out.println("date "+thedate);
            System.out.println("the date now "+ dateval);
            boolean saved = true;
            boolean occur = false;
            if(name.length()!=0 && name!=null){
                String quer = "UPDATE holidays SET holidayName=\'"+name+"\', holidayDate = \'"+thedate+"\' WHERE holidays.holidayName LIKE \'"+prev_holiday[0]+"\' ;";

                Db db = new Db();
                try {
                    db.InsertSchool(quer);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                    System.out.println("Saving failed");
                    saved = false;
                }
            }
            else {
                // occur = true;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Date Error");
                alert.setHeaderText("Data Not Found!");
                alert.setContentText("Seems that you have not filled data into a field");
                alert.showAndWait();
            }

            if (saved==true){
                t_uholi_Name.setText("");
                t_aprog_title.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succeeded!");
                alert.setHeaderText(null);
                alert.setContentText("Data Stored Successfully!");
                alert.showAndWait();
            }

        });

        //Update Intakes Listener
        btn_updateIntake.setOnAction(e->{
            if (prev_intake[0]!=null){
                VBox root = new VBox(10,l_uintake_welcom, u_intake_row1);
                root.setAlignment(Pos.CENTER);
                primaryStage.setTitle("Update Intake");
                primaryStage.setScene(new Scene(root, 500, 500));
                String progID = null;
                String progtitle = null;
                int idd = Integer.parseInt(prev_intake[0]);
                try {
                    Db db = new Db();
                    db.connect();
                    ResultSet rss = db.query("SELECT * FROM intake WHERE intakeID="+idd+";");
                    while (rss.next()){
                        progID = rss.getString("intakeID");
                        progtitle = rss.getString("intake");
                        System.out.println("theeeee");
                        System.out.println(progID+progtitle);
                    }
                    t_uintake_ID.setText(progID);
                    t_uintake_title.setText(progtitle);
                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }



            }

            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("No Record Selected!");
                alert.setHeaderText(null);
                alert.setContentText("It seems that you have selected no record!");
                alert.showAndWait();
            }


        });
        
        //update Groups listener
        btn_updateGroups.setOnAction(e->{
            if (prev_group[0]!=null){
            	VBox root = new VBox(10,l_ugroup_welcom, u_group_row1);
                root.setAlignment(Pos.CENTER);
                primaryStage.setTitle("Update Groups");
                primaryStage.setScene(new Scene(root, 500, 500));
                String groupID = null;
                String groupCode = null;
                int idd = Integer.parseInt(prev_group[0]);
                try {
                    Db db = new Db();
                    db.connect();
                   // ResultSet rss = db.query("SELECT * FROM intake WHERE intakeID="+idd+";");
                    ResultSet rss = db.query("SELECT * FROM groupcode WHERE groupCodeID="+idd+";");
                    while (rss.next()){
                    	groupID  = rss.getString("groupCodeID");
                    	groupCode = rss.getString("groupCode");
                        System.out.println("theeeee");
                        System.out.println(groupID+groupCode);
                    }
                    t_ugroup_ID.setText(groupID);
                    t_ugroup_code.setText(groupCode);
                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }



            }

            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("No Record Selected!");
                alert.setHeaderText(null);
                alert.setContentText("It seems that you have selected no record!");
                alert.showAndWait();
            }


        }); 
        
      //save update intake button
        btn_usavegroup .setOnAction(e->{
            String ID = t_ugroup_ID.getText();
            String name = t_ugroup_code.getText();
            int idd = Integer.parseInt(prev_group[0]);
            boolean yes = isInteger(ID);
          //boolean yes1 = isInteger(name);
            boolean saved = true;
            boolean occur = false;
            if (yes == true){
                //String quer = "UPDATE groupcode SET groupCodeID = \'"+name+"\' WHERE groupcode.groupcodeID = \'"+idd+"\';";
                String quer = "UPDATE groupCode SET groupCodeID = \'"+ID+"\', groupCode = \'"+name+"\' WHERE groupcode.groupcodeID = "+idd+";";
                Db db = new Db();
                try {
                    db.InsertSchool(quer);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                    System.out.println("Saving failed");
                    saved = false;
                }
            }
            else{
                saved = false;
                occur = true;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Type Error");
                alert.setHeaderText("Type Miss Matched");
                alert.setContentText("Only Integer Values are allowed in the ID");
                alert.showAndWait();
            }
            if (saved==true){
            	t_ugroup_ID.setText("");
            	t_ugroup_code.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succeeded!");
                alert.setHeaderText(null);
                alert.setContentText("Data Stored Successfully!");
                alert.showAndWait();
            }

        });
        
        //Save Update InTake Button
        btn_usaveintake.setOnAction(e->{
            String ID = t_uintake_ID.getText();
            String name = t_uintake_title.getText();
            int idd = Integer.parseInt(prev_intake[0]);
            boolean yes = isInteger(ID);
            boolean yes1 = isInteger(name);
            boolean saved = true;
            boolean occur = false;
            if (yes == true && yes1==true){
                String quer = "UPDATE intake SET intake = \'"+name+"\' WHERE intake.intakeID = \'"+idd+"\';";
                Db db = new Db();
                try {
                    db.InsertSchool(quer);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                    System.out.println("Saving failed");
                    saved = false;
                }
            }
            else{
                saved = false;
                occur = true;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Type Error");
                alert.setHeaderText("Type Miss Matched");
                alert.setContentText("Only Integer Values are allowed in the ID");
                alert.showAndWait();
            }
            if (saved==true){
                t_uprog_ID.setText("");
                t_uprog_title.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succeeded!");
                alert.setHeaderText(null);
                alert.setContentText("Data Stored Successfully!");
                alert.showAndWait();
            }

        });

        //Update Programs Listener
        btn_updatePrograms.setOnAction(e->{
            if (prev_program[0]!=null){
                VBox root = new VBox(10,l_uprog_welcom, u_prog_row1);
                root.setAlignment(Pos.CENTER);
                primaryStage.setTitle("Update Program");
                primaryStage.setScene(new Scene(root, 500, 500));
                String progID = null;
                String progtitle = null;
                int idd = Integer.parseInt(prev_program[0]);
                try {
                    Db db = new Db();
                    db.connect();
                    ResultSet rss = db.query("SELECT * FROM program WHERE programID="+idd+";");
                    while (rss.next()){
                        progID = rss.getString("programID");
                        progtitle = rss.getString("programTitle");
                        System.out.println("theeeee");
                        System.out.println(progID+progtitle);
                    }
                    t_uprog_ID.setText(progID);
                    t_uprog_title.setText(progtitle);
                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }



            }

            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("No Record Selected!");
                alert.setHeaderText(null);
                alert.setContentText("It seems that you have selected no record!");
                alert.showAndWait();
            }


        });
        
        
        //Update InTake Save Button Listener
        btn_usaveprog.setOnAction(e->{
            String ID = t_uprog_ID.getText();
            String name = t_uprog_title.getText();
            int idd = Integer.parseInt(prev_program[0]);
            boolean yes = isInteger(ID);
            boolean saved = true;
            boolean occur = false;
            if (yes == true){
                String quer = "UPDATE program SET programID = \'"+ID+"\', programTitle = \'"+name+"\' WHERE program.programID = "+idd+";";
                Db db = new Db();
                try {
                    db.InsertSchool(quer);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                    System.out.println("Saving failed");
                    saved = false;
                }
            }
            else{
                saved = false;
                occur = true;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Type Error");
                alert.setHeaderText("Type Miss Matched");
                alert.setContentText("Only Integer Values are allowed in the ID");
                alert.showAndWait();
            }
            if (saved==true){
                t_uprog_ID.setText("");
                t_uprog_title.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succeeded!");
                alert.setHeaderText(null);
                alert.setContentText("Data Stored Successfully!");
                alert.showAndWait();
            }

        });




        //Update School Listener
        btn_updateSchools.setOnAction(e->{
            if (prev_school[0]!=null){
                VBox root = new VBox(10, l_usch_welcom,u_school_main_row);
                root.setAlignment(Pos.CENTER);
                primaryStage.setTitle("Update School");
                primaryStage.setScene(new Scene(root, 500, 500));
                int iprev_schoolid = Integer.parseInt(prev_school[0]);
                String schID = null;
                String schName = null;
                try {
                    Db db = new Db();
                    db.connect();
                    ResultSet rss = db.query("SELECT * FROM school WHERE schoolID="+iprev_schoolid);
                    while (rss.next()){
                        schID = rss.getString("schoolID");
                        schName = rss.getString("school");
                        System.out.println("theeeee");
                        System.out.println(schID+schName);
                    }
                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                t_usch_ID.setText(schID);
                t_usch_Name.setText(schName);

            }

            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("No Record Selected!");
                alert.setHeaderText(null);
                alert.setContentText("It seems that you have selected no record!");
                alert.showAndWait();
            }


        });

        btn_usaveSchool.setOnAction(e->{
            String ID = t_usch_ID.getText();
            String name = t_usch_Name.getText();
            int idd = Integer.parseInt(prev_school[0]);
            boolean yes = isInteger(ID);
            boolean saved = true;
            boolean occur = false;
            if (yes == true){
                String quer = "UPDATE school SET schoolID = \'"+ID+"\', school = \'"+name+"\' WHERE school.schoolID = "+idd+";";
                Db db = new Db();
                try {
                    db.InsertSchool(quer);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                    System.out.println("Saving failed");
                    saved = false;
                }
            }
            else{
                saved = false;
                occur = true;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Type Error");
                alert.setHeaderText("Type Miss Matched");
                alert.setContentText("Only Integer Values are allowed in the ID");
                alert.showAndWait();
            }
            if (saved==true){
                t_usch_ID.setText("");
                t_usch_Name.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succeeded!");
                alert.setHeaderText(null);
                alert.setContentText("Data Stored Successfully!");
                alert.showAndWait();
            }


        });


        //Update Lecturer
        btn_updateLecturers.setOnAction(e->{
            VBox root = new VBox(10, l_ulect_welcom, ulect_main_row);
            primaryStage.setTitle("Update Lecturer");
            primaryStage.setScene(new Scene(root, 500, 500));
            ulect_active.getItems().add("0");
            ulect_active.getItems().add("1");
            String slectID = null, sfname = null, slname = null, smail = null, spass = null, sdfaultps = null;
            if(prev_lect[0]!=null){
                try {
                    Db db = new Db();
                    db.connect();
                    ResultSet rss = db.query("SELECT * FROM lecturer WHERE lecturer.lecturerID=\'"+prev_lect[0]+"\';");
                    System.out.println("Student id 1"+ prev_stud[0]);
                    while (rss.next()){
                        slectID = rss.getString("lecturerID");
                        System.out.println("Student id is "+slectID);
                        sfname = rss.getString("firstName");
                        slname = rss.getString("lastName");
                        smail = rss.getString("email");
                        spass = rss.getString("password");
                        sdfaultps = rss.getString("defaultPs");
                        t_ulect_ID.setText(slectID);
                        t_ulect_fname.setText(sfname);
                        t_ulect_lname.setText(slname);
                        t_ulect_email.setText(smail);
                        t_ulect_password.setText(spass);
                        t_ulect_defaulps.setText(sdfaultps);

                        System.out.println("theeeee");
                        System.out.println(slectID+sfname+slname+smail+spass+sdfaultps);
                    }

                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }



                try {
                    Db db = new Db();
                    db.connect();
                    ResultSet rss = db.query("SELECT schoolID FROM school;");


                    while (rss.next()){
                        String school = rss.getString("schoolID");
                        ulect_schoolidfk.getItems().add(school);
                    }


                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }





            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("No Record Selected!");
                alert.setHeaderText(null);
                alert.setContentText("It seems that you have selected no record!");
                alert.showAndWait();
            }

        });



        btn_usave_lect.setOnAction(e->{
            String sid = t_ulect_ID.getText();
            String finame = t_ulect_fname.getText();
            String liname = t_ulect_lname.getText();
            String iemail = t_ulect_email.getText();
            String ipassword = t_ulect_password.getText();
            String idefaultps = t_ulect_defaulps.getText();
            String iactive1 = (String) ulect_active.getValue();
            int iactive = 0;
            if(isInteger(iactive1)){
                iactive = Byte.parseByte(iactive1);
            }
            String ischoolid = (String) ulect_schoolidfk.getValue();
            System.out.println("The data for iactive is : "+iactive);


            boolean saved = true;
            boolean occur = false;


//            String quer = "INSERT INTO student (studentID, firstName, lastName, intakeID, email, password, defaultPs, active, groupCodeID, programID, schoolID) VALUES ('"+sid+"', '"+finame+"', '"+liname+"', '"+iintake+"', '"+iemail+"', '"+ipassword+"', '"+idefaultps+"', b'"+iactive+"', '"+igroupid+"', '"+iprogramid+"', '"+ischoolid+"');";
//            String quer = ("UPDATE student SET lastName = \'"++"\' WHERE `student`.`studentID` = '18FTT1602';")
            String quer = ("UPDATE lecturer SET schoolID=\'"+ischoolid+"\',active=b\'"+iactive+"\',defaultPs = \'"+idefaultps+"\',password = \'"+ipassword+"\',email= \'"+iemail+"\',lecturerID = \'"+sid+"\', firstName = \'"+finame+"\',  lastName = \'"+liname+"\' WHERE lecturer.lecturerID = \'"+prev_lect[0]+"\';");

            Db db = new Db();
            try {
                db.InsertSchool(quer);
            } catch (SQLException | ClassNotFoundException throwables) {
                saved = false;
                throwables.printStackTrace();
                System.out.println("Saving failed");
                saved = false;
            }
            if (saved==true){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succeeded!");
                alert.setHeaderText(null);
                alert.setContentText("Data Stored Successfully!");
                alert.showAndWait();
            }

        });




        //Update Student 
        btn_updateStudents.setOnAction(e->{
            VBox root = new VBox(10, l_ustud_welcom, ustud_main_row);
            primaryStage.setTitle("Update Student");
            primaryStage.setScene(new Scene(root, 500, 500));
            ustud_active.getItems().add("0");
            ustud_active.getItems().add("1");
            String studID = null, sfname = null, slname = null, smail = null, spass = null, sdfaultps = null;
            if(prev_stud[0]!=null){
                try {
                    Db db = new Db();
                    db.connect();
                    ResultSet rss = db.query("SELECT * FROM student WHERE student.studentID=\'"+prev_stud[0]+"\';");
                    System.out.println("Student id 1"+ prev_stud[0]);
                    while (rss.next()){
                        studID = rss.getString("studentID");
                        System.out.println("Student id is "+studID);
                        sfname = rss.getString("firstName");
                        slname = rss.getString("lastName");
                        smail = rss.getString("email");
                        spass = rss.getString("password");
                        sdfaultps = rss.getString("defaultPs");
                        t_ustud_ID.setText(studID);
                        t_ustud_fname.setText(sfname);
                        t_ustud_lname.setText(slname);
                        t_ustud_email.setText(smail);
                        t_ustud_password.setText(spass);
                        t_ustud_defaulps.setText(sdfaultps);

                        System.out.println("theeeee");
                        System.out.println(studID+sfname+slname+smail+spass+sdfaultps);
                    }

                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                try {
                    Db db = new Db();
                    db.connect();
                    ResultSet rss = db.query("SELECT intakeID FROM intake;");


                    while (rss.next()){
                        String intakeid = rss.getString("intakeID");
                        ustud_intakeIDfk.getItems().add(intakeid);
                    }


                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                try {
                    Db db = new Db();
                    db.connect();
                    ResultSet rss = db.query("SELECT groupCodeID FROM groupcode;");


                    while (rss.next()){
                        String intakeid = rss.getString("groupCodeID");
                        ustud_groupcodeidfk.getItems().add(intakeid);
                    }


                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                try {
                    Db db = new Db();
                    db.connect();
                    ResultSet rss = db.query("SELECT programID FROM program;");


                    while (rss.next()){
                        String program = rss.getString("programID");
                        ustud_programidfk.getItems().add(program);
                    }


                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                try {
                    Db db = new Db();
                    db.connect();
                    ResultSet rss = db.query("SELECT schoolID FROM school;");


                    while (rss.next()){
                        String school = rss.getString("schoolID");
                        ustud_schoolidfk.getItems().add(school);
                    }


                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }





            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("No Record Selected!");
                alert.setHeaderText(null);
                alert.setContentText("It seems that you have selected no record!");
                alert.showAndWait();
            }

        });

        // Update Student Save Button
        btn_usave_stud.setOnAction(e->{

            String sid = t_ustud_ID.getText();
            String finame = t_ustud_fname.getText();
            String liname = t_ustud_lname.getText();
            String iintake = (String) ustud_intakeIDfk.getValue();
            String iemail = t_ustud_email.getText();
            String ipassword = t_ustud_password.getText();
            String idefaultps = t_ustud_defaulps.getText(); 
            String iactive1 = (String) ustud_active.getValue();
            int iactive = 0;
            if(isInteger(iactive1)){
                iactive = Byte.parseByte(iactive1);
            }
            String igroupid = (String) ustud_groupcodeidfk.getValue();
            String iprogramid = (String) ustud_programidfk.getValue();
            String ischoolid = (String) ustud_schoolidfk.getValue();
            System.out.println("The data for iactive is : "+iactive);


            boolean saved = true;
            boolean occur = false;


//            String quer = "INSERT INTO student (studentID, firstName, lastName, intakeID, email, password, defaultPs, active, groupCodeID, programID, schoolID) VALUES ('"+sid+"', '"+finame+"', '"+liname+"', '"+iintake+"', '"+iemail+"', '"+ipassword+"', '"+idefaultps+"', b'"+iactive+"', '"+igroupid+"', '"+iprogramid+"', '"+ischoolid+"');";
//            String quer = ("UPDATE student SET lastName = \'"++"\' WHERE `student`.`studentID` = '18FTT1602';")
            String quer = ("UPDATE student SET schoolID=\'"+ischoolid+"\',programID=\'"+iprogramid+"\',groupCodeID=\'"+igroupid+"\',active=b\'"+iactive+"\',defaultPs = \'"+idefaultps+"\',password = \'"+ipassword+"\',email= \'"+iemail+"\',intakeID = \'"+iintake+"\',studentID = \'"+sid+"\', firstName = \'"+finame+"\',  lastName = \'"+liname+"\' WHERE student.studentID = \'"+prev_stud[0]+"\';");

            Db db = new Db();
            try {
                db.InsertSchool(quer);
            } catch (SQLException | ClassNotFoundException throwables) {
                saved = false;
                throwables.printStackTrace();
                System.out.println("Saving failed");
                saved = false;
            }
            if (saved==true){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succeeded!");
                alert.setHeaderText(null);
                alert.setContentText("Data Stored Successfully!");
                alert.showAndWait();
            }


        });
        
        btn_path1.setOnAction(e->{
            openfile1(primaryStage);
            System.out.println("the name of the file in  file: "+ path1);
        });
        
        
        btn_addc_lecturer.setOnAction(e->{
            VBox root = new VBox(10,btn_path1, btn_addc_lecturer,btn_acancel_lect); //123
            root.setAlignment(Pos.CENTER);
            primaryStage.setTitle("Update Lecturer");
            primaryStage.setScene(new Scene(root, 500, 500));
        });

        // add lecturer csv
        btn_addc_lecturer.setOnAction(e->{ //sini jua
            String lineText = null;
            if(path1!=""){
                try {
                    BufferedReader lineReader = new BufferedReader(new FileReader(path1));
                    lineReader.readLine();
                    while((lineText=lineReader.readLine())!=null){
                        String[] data=lineText.split(",");


//                        String val = "";
//                        int val1 =0;
//                        try {
//                            System.out.println("in the Lecturer id");
//                            Db db = new Db();
//                            db.connect();
//                            ResultSet rss = db.query("select * from lecturer ORDER BY lecturerID DESC LIMIT 1;");
//                            if (rss.next()){
//                                val = rss.getString("lecturerID");
//                            }
//
//                            val1 = Integer.parseInt(val);
//                            System.out.println("the value of val1 is "+val1);
//                            val1+=1;
//                            System.out.println("the value of val1 is "+val1);
//
//                        } catch (SQLException throwables) {
//                            val = "";
//                            val1 = 0;
//                            throwables.printStackTrace();
//
//                        }
//                        if(val1>0){
//                            t_amodule_ID.setText(""+val1);
//
//                        }
                        
                        String lecturerID = data[0];
                        String firstName = data[1];
                        String lastName = data[2];
                        String email = data[3];
                        String password = data[4];
                        String defaultPs = data[5];
                        String active = data[6];
                        String schoolID = data[7];

                        String quer = "INSERT INTO lecturer (lecturerID, firstName, lastName, email, password, defaultPs, active, schoolID) VALUES ('"+lecturerID+"', '"+firstName+"', '"+lastName+"',  '"+email+"', '"+password+"', '"+defaultPs+"', b'"+active+"',  '"+schoolID+"');";
                        Db db = new Db();
                        try {
                            db.InsertSchool(quer);
                        } catch (SQLException | ClassNotFoundException throwables) {

                            throwables.printStackTrace();
                            System.out.println("Saving failed");

                        }



                    }


                } catch (FileNotFoundException fileNotFoundException) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("File Not Found");
                    alert.setContentText("Ooops, Files seems missing!");
                    alert.showAndWait();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("File Not Found");
                alert.setContentText("Ooops, Files seems missing!");
                alert.showAndWait();
            }
        });
        
        //BUTTON ADD CSV STUDENT
        
        btn_addstudcsv.setOnAction(e->{
            String lineText = null;
            if(path1!=""){
            try {
                BufferedReader lineReader = new BufferedReader(new FileReader(path1));
                lineReader.readLine();
                while((lineText=lineReader.readLine())!=null){
                    String[] data=lineText.split(",");
                    String studentID = data[0];
                    String firstName = data[1];
                    String lastName = data[2];
                    String intakeID = data[3];
                    String email = data[4];
                    String password = data[5];
                    String defaultPs = data[6];
                    String active = data[7];
                    String groupCodeID = data[8];
                    String programID = data[9];
                    String schoolID = data[10];

                    System.out.println(                                                                                                                                                           studentID+ firstName+lastName+intakeID+email+password+defaultPs+active+groupCodeID+programID+schoolID);
                    String quer = "INSERT INTO student (studentID, firstName, lastName, intakeID, email, password, defaultPs, active, groupCodeID, programID, schoolID) VALUES ('"+studentID+"', '"+firstName+"', '"+lastName+"', '"+intakeID+"', '"+email+"', '"+password+"', '"+defaultPs+"', b'"+active+"', '"+groupCodeID+"', '"+programID+"', '"+schoolID+"');";
                    Db db = new Db();
                    try {
                        db.InsertSchool(quer);
                    } catch (SQLException | ClassNotFoundException throwables) {

                        throwables.printStackTrace();
                        System.out.println("Saving failed");

                    }



                }


            } catch (FileNotFoundException fileNotFoundException) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("File Not Found");
                alert.setContentText("Ooops, Files seems missing!");
                alert.showAndWait();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("File Not Found");
                alert.setContentText("Ooops, Files seems missing!");
                alert.showAndWait();
            }
        });
        
        
        
      //BUTTON ADD CSV LECTURER
        
        btn_addlectcsv.setOnAction(e->{
            String lineText = null;
            if(path1!=""){
            try {
                BufferedReader lineReader = new BufferedReader(new FileReader(path1));
                lineReader.readLine();
                while((lineText=lineReader.readLine())!=null){
                    String[] data=lineText.split(",");
                    String lecturerID = data[0];
                    String firstName = data[1];
                    String lastName = data[2];
                    String email = data[4];
                    String password = data[5];
                    String defaultPs = data[6];
                    String active = data[7];
                    String schoolID = data[10];

                    System.out.println(                                                                                                                                                           lecturerID+ firstName+lastName+email+password+defaultPs+active+schoolID);
                    String quer = "INSERT INTO lecturer (lecturerID, firstName, lastName, email, password, defaultPs, active, schoolID) VALUES ('"+lecturerID+"', '"+firstName+"', '"+lastName+"', '"+email+"', '"+password+"', '"+defaultPs+"', b'"+active+"', '"+schoolID+"');";
                    Db db = new Db();
                    try {
                        db.InsertSchool(quer);
                    } catch (SQLException | ClassNotFoundException throwables) {

                        throwables.printStackTrace();
                        System.out.println("Saving failed");

                    }



                }


            } catch (FileNotFoundException fileNotFoundException) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("File Not Found");
                alert.setContentText("Ooops, Files seems missing!");
                alert.showAndWait();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("File Not Found");
                alert.setContentText("Ooops, Files seems missing!");
                alert.showAndWait();
            }
        });








        //Add student
        btn_addStudents.setOnAction(e->{
            //VBox root = new VBox(10, stud_row1,stud_row2,stud_row3,stud_row4,stud_row5,stud_row6,stud_row7,stud_row8,stud_row9,stud_row10,stud_row11,stud_row12,stud_row13);
           VBox root = new VBox(10,l_astud_welcom, astud_main_row); //1234
            primaryStage.setTitle("Add Student");
            primaryStage.setScene(new Scene(root, 500, 500));
            astud_active.getItems().add("0");
            astud_active.getItems().add("1");
            try {
                Db db = new Db();
                db.connect();
                ResultSet rss = db.query("SELECT intakeID FROM intake;");


                while (rss.next()){
                    String intakeid = rss.getString("intakeID");
                    astud_intakeIDfk.getItems().add(intakeid);
                }


            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                Db db = new Db();
                db.connect();
                ResultSet rss = db.query("SELECT groupCodeID FROM groupcode;");


                while (rss.next()){
                    String intakeid = rss.getString("groupCodeID");
                    astud_groupcodeidfk.getItems().add(intakeid);
                }


            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                Db db = new Db();
                db.connect();
                ResultSet rss = db.query("SELECT programID FROM program;");


                while (rss.next()){
                    String program = rss.getString("programID");
                    astud_programidfk.getItems().add(program);
                }


            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                Db db = new Db();
                db.connect();
                ResultSet rss = db.query("SELECT schoolID FROM school;");


                while (rss.next()){
                    String school = rss.getString("schoolID");
                    astud_schoolidfk.getItems().add(school);
                }


            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });

        //Add Student Save Button

        btn_asave_stud.setOnAction(e->{
            String sid = t_astud_ID.getText();
            String finame = t_astud_fname.getText();
            String liname = t_astud_lname.getText();
            String iintake = (String) astud_intakeIDfk.getValue();
            String iemail = t_astud_email.getText();
            String ipassword = t_astud_password.getText();
            String idefaultps = t_astud_defaulps.getText();
            String iactive = (String) astud_active.getValue();
            String igroupid = (String) astud_groupcodeidfk.getValue();
            String iprogramid = (String) astud_programidfk.getValue();
            String ischoolid = (String) astud_schoolidfk.getValue();


            boolean saved = true;
            boolean occur = false;


            String quer = "INSERT INTO student (studentID, firstName, lastName, intakeID, email, password, defaultPs, active, groupCodeID, programID, schoolID) VALUES ('"+sid+"', '"+finame+"', '"+liname+"', '"+iintake+"', '"+iemail+"', '"+ipassword+"', '"+idefaultps+"', b'"+iactive+"', '"+igroupid+"', '"+iprogramid+"', '"+ischoolid+"');";
            Db db = new Db();
            try {
                db.InsertSchool(quer);
            } catch (SQLException | ClassNotFoundException throwables) {
                saved = false;
                throwables.printStackTrace();
                System.out.println("Saving failed");
                saved = false;
            }
            if (saved==true){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succeeded!");
                alert.setHeaderText(null);
                alert.setContentText("Data Stored Successfully!");
                alert.showAndWait();
            }


        });
        
        
        
        
        
        //Add Lecturer
        btn_addLecturers.setOnAction(e->{
            //VBox root = new VBox(10, stud_row1,stud_row2,stud_row3,stud_row4,stud_row5,stud_row6,stud_row7,stud_row8,stud_row9,stud_row10,stud_row11,stud_row12,stud_row13);
           VBox root = new VBox(10,l_alect_welcom, alect_main_row);
            primaryStage.setTitle("Add Lecturer");
            primaryStage.setScene(new Scene(root, 500, 500));
            alect_active.getItems().add("0");
            alect_active.getItems().add("1");
          
            try {
                Db db = new Db();
                db.connect();
                ResultSet rss = db.query("SELECT schoolID FROM school;");


                while (rss.next()){
                    String school = rss.getString("schoolID");
                    alect_schoolidfk.getItems().add(school);
                }


            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });
        
        
      //Add Lecturer Save Button 
        btn_asave_lect.setOnAction(e->{
            String lid = t_alect_ID.getText();
            String finame = t_alect_fname.getText();
            String liname = t_alect_lname.getText();
            String iemail = t_alect_email.getText();
            String ipassword = t_alect_password.getText();
            String idefaultps = t_alect_defaultps.getText();
            String iactive = (String) alect_active.getValue();
            String ischoolid = (String) alect_schoolidfk.getValue();


            boolean saved = true;
            boolean occur = false;


            String quer = "INSERT INTO lecturer (lecturerID, firstName, lastName, email, password, defaultPs, active, schoolID) VALUES ('"+lid+"', '"+finame+"', '"+liname+"', '"+iemail+"', '"+ipassword+"', '"+idefaultps+"', b'"+iactive+"', '"+ischoolid+"');";
            Db db = new Db();
            try {
                db.InsertSchool(quer);
            } catch (SQLException | ClassNotFoundException throwables) {
                saved = false;
                throwables.printStackTrace();
                System.out.println("Saving failed");
                saved = false;
            }
            if (saved==true){

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succeeded!");
                alert.setHeaderText(null);
                alert.setContentText("Data Stored Successfully!");
                alert.showAndWait();
            }


        });
        



        btn_addModule.setOnAction(e->{
            VBox root = new VBox(10,l_amodule_welcom,a_moduel_main_row);
            root.setAlignment(Pos.CENTER);
            primaryStage.setTitle("Add Module");
            primaryStage.setScene(new Scene(root, 400, 300));
            String val = "";
            int val1 =0;
            try {
                System.out.println("in the module id");
                Db db = new Db();
                db.connect();
                ResultSet rss = db.query("select * from module ORDER BY moduleID DESC LIMIT 1;");
                if (rss.next()){
                    val = rss.getString("moduleID");
                }

                val1 = Integer.parseInt(val);
                System.out.println("the value of val1 is "+val1);
                val1+=1;
                System.out.println("the value of val1 is "+val1);

            } catch (SQLException throwables) {
                val = "";
                val1 = 0;
                throwables.printStackTrace();

            }
            if(val1>0){
                t_amodule_ID.setText(""+val1);
            }
        });

        btn_savemodlue.setOnAction(e->{

            String ID = t_amodule_ID.getText();
            String code = t_amodule_Code.getText();
            String name = t_amodule_Name.getText();
            boolean yes = isInteger(ID);
            boolean saved = true;
            boolean occur = false;
            if (yes == true){
                String quer = "INSERT INTO module (moduleID, moduleCode, moduleName) VALUES ('"+ID+"', '"+code+"', '"+name+"');";
                Db db = new Db();
                try {
                    db.InsertSchool(quer);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                    System.out.println("Saving failed");
                    saved = false;
                }
            }
            else{
                saved = false;
                occur = true;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Type Error");
                alert.setHeaderText("Type Miss Matched");
                alert.setContentText("Only Integer Values are allowed in the ID");
                alert.showAndWait();
            }
            if (saved==true){
                t_amodule_ID.setText("");
                t_amodule_Code.setText("");
                t_amodule_Name.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succeeded!");
                alert.setHeaderText(null);
                alert.setContentText("Data Stored Successfully!");
                alert.showAndWait();
            }
            else if(saved!=true && occur!=true){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Data Error");
                alert.setHeaderText("Duplication May Occured");
                alert.setContentText("It seems that the School ID already exists in database");
                alert.showAndWait();
            }

        });


        btn_addHolidays.setOnAction(e->{
            VBox root = new VBox(10,l_aholi_welcom,a_holi_main_row);
            root.setAlignment(Pos.CENTER);
            primaryStage.setTitle("Add Holidays");
            primaryStage.setScene(new Scene(root, 500, 400));
        });

        btn_saveholi.setOnAction(e->{
            String name = t_aholi_Name.getText();
            Date thedate = Date.valueOf(t_aholi_date.getValue());
            String dateval = thedate.toString();
            System.out.println("date "+thedate);
            System.out.println("the date now "+ dateval);
            boolean saved = true;
            boolean occur = false;
            if(name.length()!=0 && name!=null){
                String quer = "INSERT INTO holidays (holidayName, holidayDate) VALUES ('"+name+"', '"+thedate+"');";
                Db db = new Db();
                try {
                    db.InsertSchool(quer);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                    System.out.println("Saving failed");
                    saved = false;
                }
            }
            else {
                occur = true;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Date Error");
                alert.setHeaderText("Data Not Found!");
                alert.setContentText("Seems that you have not filled data into a field");
                alert.showAndWait();
            }

            if (saved==true){
                t_aprog_ID.setText("");
                t_aprog_title.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succeeded!");
                alert.setHeaderText(null);
                alert.setContentText("Data Stored Successfully!");
                alert.showAndWait();
            }

        });

        // Add InTake Listener
        btn_addIntake.setOnAction(e->{
            VBox root = new VBox(10,l_aintake_welcom,a_intake_row1);
            root.setAlignment(Pos.CENTER);
            primaryStage.setTitle("Add Intake");
            primaryStage.setScene(new Scene(root, 400, 400));
            String val = "";
            int val1 =0;
            try {
                System.out.println("in the module id");
                Db db = new Db();
                db.connect();
                ResultSet rss = db.query("select * from intake ORDER BY intakeID DESC LIMIT 1;");
                if (rss.next()){
                    val = rss.getString("intakeID");
                }

                val1 = Integer.parseInt(val);
                System.out.println("the value of val1 is "+val1);
                val1+=1;
                System.out.println("the value of val1 is "+val1);

            } catch (SQLException throwables) {
                val = "";
                val1 = 0;
                throwables.printStackTrace();

            }
            if(val1>0){
                t_aintake_ID.setText(""+val1);
            }
        });
        
        
        //Save InTake
        btn_saveintake.setOnAction(e->{
            String ID = t_aintake_ID.getText();
            String title = t_aintake_title.getText();
            boolean yes = isInteger(ID);
            boolean yes1 = isInteger(title);
            boolean saved = true;
            boolean occur = false;
            if (yes == true && yes1 == true){
                String quer = "INSERT INTO intake (intakeID, intake) VALUES ('"+ID+"', '"+title+"');";
                Db db = new Db();
                try {
                    db.InsertSchool(quer);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                    System.out.println("Saving failed");
                    saved = false;
                }
            }
            else{
                saved = false;
                occur = true;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Type Error");
                alert.setHeaderText("Type Miss Matched");
                alert.setContentText("Only Integer Values are allowed in the ID");
                alert.showAndWait();
            }
            if (saved==true){
                t_aprog_ID.setText("");
                t_aprog_title.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succeeded!");
                alert.setHeaderText(null);
                alert.setContentText("Data Stored Successfully!");
                alert.showAndWait();
            }
            else if(saved!=true && occur!=true){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Data Error");
                alert.setHeaderText("Duplication May Occured");
                alert.setContentText("It seems that the School ID already exists in database");
                alert.showAndWait();
            }
        });



        // Add Programs Listener
        btn_addPrograms.setOnAction(e->{
            VBox root = new VBox(10,l_aprog_welcom,a_prog_row1);
            root.setAlignment(Pos.CENTER);
            primaryStage.setTitle("Add Program");
            primaryStage.setScene(new Scene(root, 400, 400));
            String val = "";
            int val1 =0;
            try {
                System.out.println("in the module id");
                Db db = new Db();
                db.connect();
                ResultSet rss = db.query("select * from program ORDER BY programID DESC LIMIT 1;");
                if (rss.next()){
                    val = rss.getString("programID");
                }

                val1 = Integer.parseInt(val);
                System.out.println("the value of val1 is "+val1);
                val1+=1;
                System.out.println("the value of val1 is "+val1);

            } catch (SQLException throwables) {
                val = "";
                val1 = 0;
                throwables.printStackTrace();

            }
            if(val1>0){
                t_aprog_ID.setText(""+val1);
            }
        });
        
        
        // save Program Listener
        btn_saveprog.setOnAction(e->{
            String ID = t_aprog_ID.getText();
            String title = t_aprog_title.getText();
            boolean yes = isInteger(ID);
            boolean saved = true;
            boolean occur = false;
            if (yes == true){
                String quer = "INSERT INTO program (programID, programTitle) VALUES ('"+ID+"', '"+title+"');";
                Db db = new Db();
                try {
                    db.InsertSchool(quer);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                    System.out.println("Saving failed");
                    saved = false;
                }
            }
            else{
                saved = false;
                occur = true;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Type Error");
                alert.setHeaderText("Type Miss Matched");
                alert.setContentText("Only Integer Values are allowed in the ID");
                alert.showAndWait();
            }
            if (saved==true){
                t_aprog_ID.setText("");
                t_aprog_title.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succeeded!");
                alert.setHeaderText(null);
                alert.setContentText("Data Stored Successfully!");
                alert.showAndWait();
            }
            else if(saved!=true && occur!=true){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Data Error");
                alert.setHeaderText("Duplication May Occured");
                alert.setContentText("It seems that the School ID already exists in database");
                alert.showAndWait();
            }
        });



     // add Intake set on action
        btn_addGroups.setOnAction(e->{
            VBox root = new VBox(10,l_agroup_welcom,a_group_row1);
            root.setAlignment(Pos.CENTER);
            primaryStage.setTitle("Add Groups");
            primaryStage.setScene(new Scene(root, 400, 400));
            String val = "";
            int val1 =0;
            try {
                System.out.println("in the Group id");
                Db db = new Db();
                db.connect();
                ResultSet rss = db.query("select * from groupcode ORDER BY groupCodeID DESC LIMIT 1;");
                if (rss.next()){
                    val = rss.getString("groupCodeID");
                }

                val1 = Integer.parseInt(val);
                System.out.println("the value of val1 is "+val1);
                val1+=1;
                System.out.println("the value of val1 is "+val1);

            } catch (SQLException throwables) {
                val = "";
                val1 = 0;
                throwables.printStackTrace();

            }
            if(val1>0){
                t_aintake_ID.setText(""+val1);
            }
        });
        // save groupcode
        btn_asavegroup .setOnAction(e->{
            String ID = t_agroup_ID .getText();
            String title = t_agroup_code .getText();
            boolean yes = isInteger(ID);
            boolean yes1 = isInteger(title);
            boolean saved = true;
            boolean occur = false;
            if (yes == true){
                String quer = "INSERT INTO groupcode (groupCodeID, groupCode) VALUES ('"+ID+"', '"+title+"');";
                Db db = new Db();
                try {
                    db.InsertSchool(quer);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                    System.out.println("Saving failed");
                    saved = false;
                }
            }
            else{
                saved = false;
                occur = true;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Type Error");
                alert.setHeaderText("Type Miss Matched");
                alert.setContentText("Only Integer Values are allowed in the ID");
                alert.showAndWait();
            }
            if (saved==true){
                t_aprog_ID.setText("");
                t_aprog_title.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succeeded!");
                alert.setHeaderText(null);
                alert.setContentText("Data Stored Successfully!");
                alert.showAndWait();
            }
            else if(saved!=true && occur!=true){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Data Error");
                alert.setHeaderText("Duplication May Occured");
                alert.setContentText("It seems that the School ID already exists in database");
                alert.showAndWait();
            }
        });
        
        
        // Add School Listener
        btn_addSchools.setOnAction(e->{
            VBox root = new VBox(10,hBox_row1_addstud,a_school_main_row);
            root.setAlignment(Pos.CENTER);
            primaryStage.setTitle("Add School");
            primaryStage.setScene(new Scene(root, 400, 400));



            String val = "";
            int val1 =0;
            try {
                System.out.println("in the module id");
                Db db = new Db();
                db.connect();
                ResultSet rss = db.query("select * from school ORDER BY schoolID DESC LIMIT 1;");
                if (rss.next()){
                    val = rss.getString("schoolID");
                }

                val1 = Integer.parseInt(val);
                System.out.println("the value of val1 is "+val1);
                val1+=1;
                System.out.println("the value of val1 is "+val1);

            } catch (SQLException throwables) {
                val = "";
                val1 = 0;
                throwables.printStackTrace();

            }
            if(val1>0){
                t_asch_ID.setText(""+val1);
            }




        });
        btn_saveSchool.setOnAction(e->{
            String ID = t_asch_ID.getText();
            String name = t_asch_Name.getText();
            boolean yes = isInteger(ID);
            boolean saved = true;
            boolean occur = false;
            if (yes == true){
                String quer = "INSERT INTO school (schoolID, school) VALUES ('"+ID+"', '"+name+"');";
                Db db = new Db();
                try {
                    db.InsertSchool(quer);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                    System.out.println("Saving failed");
                    saved = false;
                }
            }
            else{
                saved = false;
                occur = true;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Type Error");
                alert.setHeaderText("Type Miss Matched");
                alert.setContentText("Only Integer Values are allowed in the ID");
                alert.showAndWait();
            }
            if (saved==true){
                t_asch_ID.setText("");
                t_asch_Name.setText("");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Succeeded!");
                alert.setHeaderText(null);
                alert.setContentText("Data Stored Successfully!");
                alert.showAndWait();
            }
            else if(saved!=true && occur!=true){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Data Error");
                alert.setHeaderText("Duplication May Occured");
                alert.setContentText("It seems that the School ID already exists in database");
                alert.showAndWait();
            }
        });
        
        // button2 untuk page atu 
        // Add View Lecturers
        btn_viewLecturers.setOnAction(e->{
            try{
                HBox btns = new HBox(20,btn_back,btn_updateLecturers, btn_addc_lecturer, btn_addLecturers); //button yg hujung yg aku create
                viewLecturers = new TableView();
                fviewLecturers();
                VBox root = new VBox(7, viewLecturers, btns);
                primaryStage.setTitle("All Lecturers");
                primaryStage.setScene(new Scene(root, 600, 450));
            }
            catch (Exception ee){
                System.out.println("you have the error"+ee);
            }

            viewLecturers.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){

                    System.out.println("Selected Module name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_lect[0] = x;
                    System.out.println("The updated value is: "+prev_lect[0]);

                }

            });
        }); 
        

        btn_viewModules.setOnAction(e->{
            HBox btns = new HBox(20,btn_back, btn_updateModules,btn_addModule);
            viewModules = new TableView();
            fviewModules();
            VBox root = new VBox(7, viewModules,btns);
            primaryStage.setTitle("All Modules");
            primaryStage.setScene(new Scene(root, 500, 450));
            viewModules.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){

                    System.out.println("Selected Module name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_module[0] = x;
                    System.out.println("The updated value is: "+prev_module[0]);

                }

            });

        });  



        btn_viewHolidays.setOnAction(actionEvent -> {
            HBox btns = new HBox(20,btn_back,btn_updateHolidays,btn_addHolidays);

            viewHolidays = new TableView();
            fviewHolidays();
            VBox root = new VBox(7, viewHolidays,btns );
            primaryStage.setTitle("All Holidays");
            primaryStage.setScene(new Scene(root, 500, 450));
            viewHolidays.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){
                    // System.out.println("Selected Holiday name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_holiday[0] = x;
                    System.out.println("The updated value is: "+prev_holiday[0]);
                }

            });
        });  
        
        
        //View Programs set on action
        btn_viewPrograms.setOnAction(actionEvent -> {
            HBox btns = new HBox(20,btn_back, btn_updatePrograms,btn_addPrograms);
            viewProgram = new TableView();
            fviewPrograms();
            VBox root = new VBox(7, viewProgram, btns);
            primaryStage.setTitle("All Programs");
            primaryStage.setScene(new Scene(root, 500, 450));
            viewProgram.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){
//                    System.out.println("Selected Holiday name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_program[0] = x;
                    System.out.println("Selected program name is: "+ prev_program[0]);

                }
            });
        });  

        //View InTakes set on action
        btn_viewIntakes.setOnAction(actionEvent -> {
            HBox btns = new HBox(20,btn_back, btn_updateIntake,btn_addIntake);
            viewIntakes = new TableView();
            fviewIntakes();
            VBox root = new VBox(5, viewIntakes, btns);
            primaryStage.setTitle("All Intakes");
            primaryStage.setScene(new Scene(root, 500, 450));
            viewIntakes.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){
//                    System.out.println("Selected Holiday name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_intake[0] = x;
                    System.out.println("Selected program name is: "+ prev_intake[0]);

                }
            });
        }); 


        //View School Listener
        btn_viewSchools.setOnAction(actionEvent -> {
            HBox btns = new HBox(20, btn_back, btn_updateSchools, btn_addSchools);
            viewSchool = new TableView();
            fviewschools();
            VBox root = new VBox(5, viewSchool,btns);
            primaryStage.setTitle("All Schools");
            primaryStage.setScene(new Scene(root,500,470));
            viewSchool.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){
//                    System.out.println("Selected Holiday name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_school[0]  = x;
                    System.out.println("Selected Holiday name is: "+ prev_school[0]);
                }

            });

        });  

        btn_viewStudents.setOnAction(actionEvent -> {
            HBox btns = new HBox(20,btn_back,btn_updateStudents,btn_addStudents);
            viewStudent = new TableView();
            fviewStudent();
            VBox root = new VBox(5,viewStudent, btns);
            primaryStage.setTitle("All Students");
            primaryStage.setScene(new Scene(root, 965, 450));
            primaryStage.centerOnScreen();
            viewStudent.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){
                    System.out.println("Selected Holiday name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_stud[0] = x;
                    System.out.println("The updated value is: "+prev_stud[0]);




                }
            });
        }); 

        //view Group set on action
        btn_viewGroups.setOnAction(actionEvent -> {
            HBox btns = new HBox(20,btn_back, btn_updateGroups,btn_addGroups);
            viewGroups = new TableView();
            fviewGroups();
            VBox root = new VBox(5, viewGroups, btns);
            primaryStage.setTitle("All Groups");
            primaryStage.setScene(new Scene(root, 500, 450));
            viewGroups.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){
//                    System.out.println("Selected Holiday name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_group[0] = x;
                    System.out.println("Selected program name is: "+ prev_group[0]);

                }
            });
        }); //done 8
        
        btn_back.setOnAction(e->{
            VBox m_homebtn1 = new VBox(20,home_btn0,home_btn1,home_btn2,home_btn3);
            m_homebtn1.setAlignment(Pos.CENTER);

            primaryStage.setTitle("Admin Panel");
            primaryStage.setScene(new Scene(m_homebtn1, 700,500));
            primaryStage.centerOnScreen();
            primaryStage.show();

        });

        up_cancel.setOnAction(e->{
            VBox m_homebtn1 = new VBox(20,home_btn0,home_btn1,home_btn2,home_btn3);
            m_homebtn1.setAlignment(Pos.CENTER);

            primaryStage.setTitle("Admin Panel");
            primaryStage.setScene(new Scene(m_homebtn1, 700,500));
            primaryStage.centerOnScreen();
            primaryStage.show();

        });



        btn_ucancel_lect.setOnAction(e->{
            try{
                HBox btns = new HBox(20,btn_back,btn_updateLecturers, btn_addc_lecturer, btn_addLecturers);
                viewLecturers = new TableView();
                fviewLecturers();
                VBox root = new VBox(7, viewLecturers, btns);
                primaryStage.setTitle("All Lecturers");
                primaryStage.setScene(new Scene(root, 600, 450));
            }
            catch (Exception ee){
                System.out.println("you have the error"+ee);
            }

            viewLecturers.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){

                    System.out.println("Selected Module name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_lect[0] = x;
                    System.out.println("The updated value is: "+prev_lect[0]);

                }

            });

        });

        //button cancel arah update
        btn_acancel_lect.setOnAction(e->{ 
            try{
                HBox btns = new HBox(20,btn_back,btn_updateLecturers, btn_addc_lecturer, btn_addLecturers); //lect sini
                viewLecturers = new TableView();
                fviewLecturers();
                VBox root = new VBox(7, viewLecturers, btns);
                primaryStage.setTitle("All Lecturers");
                primaryStage.setScene(new Scene(root, 600, 450));
            }
            catch (Exception ee){
                System.out.println("you have the error"+ee);
            }

            viewLecturers.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){

                    System.out.println("Selected Module name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_lect[0] = x;
                    System.out.println("The updated value is: "+prev_lect[0]);

                }

            });
        });
        
        
        btn_alect_canc.setOnAction(e->{ 
            try{
                HBox btns = new HBox(20,btn_back,btn_updateLecturers, btn_addc_lecturer, btn_addLecturers); //lect sini
                viewLecturers = new TableView();
                fviewLecturers();
                VBox root = new VBox(7, viewLecturers, btns);
                primaryStage.setTitle("All Lecturers");
                primaryStage.setScene(new Scene(root, 600, 450));
            }
            catch (Exception ee){
                System.out.println("you have the error"+ee);
            }

            viewLecturers.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){

                    System.out.println("Selected Module name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_lect[0] = x;
                    System.out.println("The updated value is: "+prev_lect[0]);

                }

            });
        });
        
        
        btn_aschool_canc.setOnAction(e->{
            HBox btns = new HBox(20, btn_back, btn_updateSchools, btn_addSchools);
            viewSchool = new TableView();
            fviewschools();
            VBox root = new VBox(5, viewSchool,btns);
            primaryStage.setTitle("All Schools");
            primaryStage.setScene(new Scene(root,500,470));
            viewSchool.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){
//                    System.out.println("Selected Holiday name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_school[0]  = x;
                    System.out.println("Selected Holiday name is: "+ prev_school[0]);
                }

            });
        });
        btn_ucancelSchool.setOnAction(e->{
            HBox btns = new HBox(20, btn_back, btn_updateSchools, btn_addSchools);
            viewSchool = new TableView();
            fviewschools();
            VBox root = new VBox(5, viewSchool,btns);
            primaryStage.setTitle("All Schools");
            primaryStage.setScene(new Scene(root,500,470));
            viewSchool.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){
//                    System.out.println("Selected Holiday name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_school[0]  = x;
                    System.out.println("Selected Holiday name is: "+ prev_school[0]);
                }

            });

        });

        btn_aprog_canc.setOnAction(e->{
            HBox btns = new HBox(20,btn_back, btn_updatePrograms,btn_addPrograms);
            viewProgram = new TableView();
            fviewPrograms();
            VBox root = new VBox(7, viewProgram, btns);
            primaryStage.setTitle("All Programs");
            primaryStage.setScene(new Scene(root, 500, 450));
            viewProgram.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){
//                    System.out.println("Selected Holiday name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_program[0] = x;
                    System.out.println("Selected program name is: "+ prev_program[0]);

                }
            });

        });
        btn_aintake_canc.setOnAction(e->{
            HBox btns = new HBox(20,btn_back, btn_updateIntake,btn_addIntake);
            viewIntakes = new TableView();
            fviewIntakes();
            VBox root = new VBox(5, viewIntakes, btns);
            primaryStage.setTitle("All Intakes");
            primaryStage.setScene(new Scene(root, 500, 450));
            viewIntakes.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){
//                    System.out.println("Selected Holiday name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_intake[0] = x;
                    System.out.println("Selected program name is: "+ prev_intake[0]);

                }
            });
        });

        btn_ucancelintake.setOnAction(e->{
            HBox btns = new HBox(20,btn_back, btn_updateIntake,btn_addIntake);
            viewIntakes = new TableView();
            fviewIntakes();
            VBox root = new VBox(5, viewIntakes, btns);
            primaryStage.setTitle("All Intakes");
            primaryStage.setScene(new Scene(root, 500, 450));
            viewIntakes.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){
//                    System.out.println("Selected Holiday name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_intake[0] = x;
                    System.out.println("Selected program name is: "+ prev_intake[0]);

                }
            });

        });



        btn_ucancelprog.setOnAction(e->{
            HBox btns = new HBox(20,btn_back, btn_updatePrograms,btn_addPrograms);
            viewProgram = new TableView();
            fviewPrograms();
            VBox root = new VBox(7, viewProgram, btns);
            primaryStage.setTitle("All Programs");
            primaryStage.setScene(new Scene(root, 500, 450));
            viewProgram.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){
//                    System.out.println("Selected Holiday name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_program[0] = x;
                    System.out.println("Selected program name is: "+ prev_program[0]);

                }
            });

        });
        
        btn_agroup_canc.setOnAction(e->{
            HBox btns = new HBox(20,btn_back, btn_updateGroups,btn_addGroups);
            viewGroups = new TableView();
            fviewGroups();
            VBox root = new VBox(5, viewGroups, btns);
            primaryStage.setTitle("All Groups");
            primaryStage.setScene(new Scene(root, 500, 450));
            viewGroups.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){
//                    System.out.println("Selected groupcode name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_intake[0] = x;
                    System.out.println("Selected groupcode name is: "+ prev_group[0]);

                }
            });
        });
        
        btn_ugroup_canc.setOnAction(e->{
            HBox btns = new HBox(20,btn_back, btn_updateGroups,btn_addGroups);
            viewGroups = new TableView();
            fviewGroups();
            VBox root = new VBox(7, viewGroups, btns);
            primaryStage.setTitle("All Groups");
            primaryStage.setScene(new Scene(root, 500, 450));
            viewGroups.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){
//                    System.out.println("Selected Group code is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_program[0] = x;
                    System.out.println("Selected groupcode name is: "+ prev_group[0]);

                }
            });

        });
    
        

        


        btn_cancelholi.setOnAction(e->{
            HBox btns = new HBox(20,btn_back,btn_updateHolidays,btn_addHolidays);

            viewHolidays = new TableView();
            fviewHolidays();
            VBox root = new VBox(7, viewHolidays,btns );
            primaryStage.setTitle("All Holidays");
            primaryStage.setScene(new Scene(root, 500, 450));
            viewHolidays.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){
                    // System.out.println("Selected Holiday name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_holiday[0] = x;
                    System.out.println("The updated value is: "+prev_holiday[0]);
                }

            });

        });

        btn_ucancelholi.setOnAction(e->{
            HBox btns = new HBox(20,btn_back,btn_updateHolidays,btn_addHolidays);

            viewHolidays = new TableView();
            fviewHolidays();
            VBox root = new VBox(7, viewHolidays,btns );
            primaryStage.setTitle("All Holidays");
            primaryStage.setScene(new Scene(root, 500, 450));
            viewHolidays.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){
                    // System.out.println("Selected Holiday name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_holiday[0] = x;
                    System.out.println("The updated value is: "+prev_holiday[0]);
                }

            });

        });

        btn_acancel_stud.setOnAction(e->{
            System.out.println("back in view menu");
            HBox btns = new HBox(20,btn_back,btn_updateStudents,btn_addStudents);
            viewStudent = new TableView();
            fviewStudent();
            VBox root = new VBox(5,viewStudent, btns);
            primaryStage.setTitle("All Students");
            primaryStage.setScene(new Scene(root, 965, 450));
            primaryStage.centerOnScreen();
            viewStudent.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){
                    System.out.println("Selected Holiday name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_stud[0] = x;
                    System.out.println("The updated value is: "+prev_stud[0]);


                }
            });

        });
        btn_ucancel_stud.setOnAction(e->{
            System.out.println("Back in view menu");
            HBox btns = new HBox(20,btn_back,btn_updateStudents,btn_addStudents);
            viewStudent = new TableView();
            fviewStudent();
            VBox root = new VBox(5,viewStudent, btns);
            primaryStage.setTitle("All Students");
            primaryStage.setScene(new Scene(root, 965, 450));
            primaryStage.centerOnScreen();
            viewStudent.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){
                    System.out.println("Selected Holiday name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_stud[0] = x;
                    System.out.println("The updated value is: "+prev_stud[0]);




                }
            });

        });
        btn_astud_canc.setOnAction(e->{
            HBox btns = new HBox(20,btn_back,btn_updateStudents,btn_addStudents);
            viewStudent = new TableView();
            fviewStudent();
            VBox root = new VBox(5,viewStudent, btns);
            primaryStage.setTitle("All Students");
            primaryStage.setScene(new Scene(root, 965, 450));
            primaryStage.centerOnScreen();
            viewStudent.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){
                    System.out.println("Selected Holiday name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_stud[0] = x;
                    System.out.println("The updated value is: "+prev_stud[0]);




                }
            });

        });



        btn_cancelmodule.setOnAction(e->{
            HBox btns = new HBox(20,btn_back, btn_updateModules,btn_addModule);
            viewModules = new TableView();
            fviewModules();
            VBox root = new VBox(7, viewModules,btns);
            primaryStage.setTitle("All Modules");
            primaryStage.setScene(new Scene(root, 500, 450));
            viewModules.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){

                    System.out.println("Selected Module name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_module[0] = x;
                    System.out.println("The updated value is: "+prev_module[0]);

                }

            });

        });
        btn_ucancelmodule.setOnAction(e->{
            HBox btns = new HBox(20,btn_back, btn_updateModules,btn_addModule);
            viewModules = new TableView();
            fviewModules();
            VBox root = new VBox(7, viewModules,btns);
            primaryStage.setTitle("All Modules");
            primaryStage.setScene(new Scene(root, 500, 450));
            viewModules.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue)->{
                if(newValue != null){

                    System.out.println("Selected Module name is: "+ newValue);
                    String x = newValue.toString().substring(1, newValue.toString().indexOf(","));
                    prev_module[0] = x;
                    System.out.println("The updated value is: "+prev_module[0]);

                }

            });

        });


        primaryStage.setTitle("Admin Login");
        primaryStage.setScene(new Scene(log_row, 700,400));
        primaryStage.centerOnScreen();
        primaryStage.show();



    }


    public static void main(String[] args) {
        launch(args);
    }

}
