package com.example.tawjihi;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public class HelloApplication extends Application {
    public static void main(String[] args) {
        Application.launch(args);

    }



    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        VBox vb = new VBox();
        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(120);
        label1.setTranslateX(255);
        // label1.setStyle("-fx-background-color:violate; -fx-padding: 20px;");

        ImageView West_BankIm = new ImageView("https://img.icons8.com/cute-clipart/344/enter-2.png");
        West_BankIm.setFitWidth(30);
        West_BankIm.setFitHeight(30);
        Button West_Bank = new Button("Enter", West_BankIm);
        West_Bank.setTranslateX(400);
        West_Bank.setTranslateY(150);
        West_Bank.setPrefSize(150, 50);
        West_Bank.setStyle("-fx-border-color:purple");



        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(175);

        vb.getChildren().addAll(label1, West_Bank,  imageView);
        vb.setSpacing(40);

        bp.setCenter(vb);

        West_Bank.setOnAction(e -> {
            try {
                WBLS(stage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });


        // bp.setStyle("-fx-background-color: white;");
        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);
        stage.show();

    }

    static DoubleLinkedList WestBank = new DoubleLinkedList();
     static AVL treeSortByNumber = new AVL();
     TawjiheDS Student =new TawjiheDS();
     NodeAVL root;

    public void FileChooser(Stage stage) throws Exception
    {

        BorderPane bp = new BorderPane();
        VBox vb = new VBox();
        try {

            FileChooser fil_chooser = new FileChooser();
            Label label = new Label("   No Files Selected");
            label.setPrefWidth(180);
            label.setTranslateY(90);
            label.setTranslateX(585);
            label.setStyle("-fx-background-color: pink; -fx-padding: 20px;");

            ImageView selectIm = new ImageView("https://cdn-icons-png.flaticon.com/512/4047/4047250.png");
            selectIm.setFitWidth(30);
            selectIm.setFitHeight(30);
            Button Select = new Button("Select", selectIm);
            Select.setTranslateX(405);
            Select.setTranslateY(20);
            Select.setPrefSize(150, 50);
            Select.setStyle("-fx-border-color:purple");

            EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

                public void handle(ActionEvent e) {
                    File file1 = fil_chooser.showOpenDialog(stage);
                    if (file1 != null) {

                        label.setText(file1.getName() + " Selected");
                    }
                    if (file1.exists()) {
                        Scanner in = null;
                        try {
                            in = new Scanner(file1);
                            int count = 0;
                            while (in.hasNext()) {
                                String line = in.nextLine();
                                if (line.contains("Literary")) {
                                    System.out.println(line);
                                    String[] splittedList = line.split(",");
                                    WestBank.insert(new Tawjihe(Integer.valueOf(splittedList[0]), splittedList[1], splittedList[2]));
                                    treeSortByNumber.insert(root,new Tawjihe(splittedList[0]));
                                    count++;
                                }
                            }
                        } catch (FileNotFoundException e1) {
                            e1.printStackTrace();
                        }

                        in.close();
                    } else
                        System.out.println("Error: File West Bank not found!!!");
                }
            };

            Select.setOnAction(event);

            ImageView NextIm = new ImageView("https://cdn-icons-png.flaticon.com/512/556/556670.png");
            NextIm.setFitWidth(30);
            NextIm.setFitHeight(30);
            Button Next = new Button("Next", NextIm);
            Next.setTranslateX(405);
            Next.setTranslateY(20);
            Next.setPrefSize(150, 50);
            Next.setStyle("-fx-border-color:purple");

            Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitWidth(1000);
            imageView.setFitHeight(250);
            imageView.setTranslateY(80);

            vb.getChildren().addAll(label, Select, Next, imageView);

            vb.setSpacing(20);

            Next.setOnAction(e -> {
                try {
                    listWBL(stage);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            });

            bp.setCenter(vb);
            Scene scene = new Scene(bp, 1000, 600);
            stage.setTitle("File Chooser");
            stage.setScene(scene);
            stage.show();
        }

        catch (Exception e) {

            System.out.println(e.getMessage());
        }

    }

    public void WBLS(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        VBox vb = new VBox();
        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);
        // label1.setStyle("-fx-background-color:violate; -fx-padding: 20px;");
        Label label2 = new Label("In The West Bank");
        label2.setFont(new Font("In The West Bank", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(370);

        ImageView LiteraryIm = new ImageView("https://cdn-icons-png.flaticon.com/512/5526/5526395.png");
        LiteraryIm.setFitWidth(30);
        LiteraryIm.setFitHeight(30);
        Button Literary = new Button("Literary ", LiteraryIm);
        Literary.setTranslateX(550);
        Literary.setTranslateY(90);
        Literary.setPrefSize(150, 50);
        Literary.setStyle("-fx-border-color:purple");

        ImageView ScienceIm = new ImageView("https://cdn-icons-png.flaticon.com/512/2821/2821637.png");
        ScienceIm.setFitWidth(30);
        ScienceIm.setFitHeight(30);
        Button Science = new Button("Science", ScienceIm);
        Science.setTranslateX(250);
        Science.setTranslateY(20);
        Science.setPrefSize(150, 50);
        Science.setStyle("-fx-border-color:purple");

        ImageView BackIm = new ImageView("https://cdn-icons-png.flaticon.com/512/8482/8482632.png");
        BackIm.setFitWidth(30);
        BackIm.setFitHeight(30);
        Button Back = new Button("Back", BackIm);
        Back.setTranslateX(405);
        Back.setTranslateY(20);
        Back.setPrefSize(150, 50);
        Back.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(45);

        vb.getChildren().addAll(label1, label2, Literary, Science, Back, imageView);
        vb.setSpacing(20);

        bp.setCenter(vb);

        Literary.setOnAction(e -> {
            try {
                FileChooser(stage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        Science.setOnAction(e -> {
            try {
                listWBS(stage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        Back.setOnAction(e -> {
            try {
                start(stage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        // bp.setStyle("-fx-background-color: white;");
        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);
        stage.show();

    }
    public void listWBL(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        VBox vb1 = new VBox();
        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);
        // label1.setStyle("-fx-background-color:violate; -fx-padding: 20px;");
        Label label2 = new Label("In The West Bank ( Literary )");
        label2.setFont(new Font("In The West Bank ( Literary )", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(370);

        Button Insert = new Button(" Insert new Student ");
        Insert.setTranslateX(100);
        Insert.setTranslateY(90);
        Insert.setPrefSize(230, 20);
        Insert.setStyle("-fx-border-color:purple");

        Button delete = new Button(" Delete Student ");
        delete.setTranslateX(100);
        delete.setTranslateY(90);
        delete.setPrefSize(230, 20);
        delete.setStyle("-fx-border-color:purple");

        Button Update = new Button(" Update ");
        Update.setTranslateX(100);
        Update.setTranslateY(90);
        Update.setPrefSize(230, 20);
        Update.setStyle("-fx-border-color:purple");

        Button Find = new Button(" Find The Students ");
        Find.setTranslateX(100);
        Find.setTranslateY(90);
        Find.setPrefSize(230, 20);
        Find.setStyle("-fx-border-color:purple");

        Button getall = new Button(" Get All  the Student ");
        getall.setTranslateX(450);
        getall.setTranslateY(-60);
        getall.setPrefSize(230, 20);
        getall.setStyle("-fx-border-color:purple");

        Button print = new Button(" Print   ");
        print.setTranslateX(450);
        print.setTranslateY(-60);
        print.setPrefSize(230, 20);
        print.setStyle("-fx-border-color:purple");

        Button height = new Button(" Print Height AVL   ");
        height.setTranslateX(450);
        height.setTranslateY(-60);
        height.setPrefSize(230, 20);
        height.setStyle("-fx-border-color:purple");

        Button exit = new Button(" Exit  ");
        exit.setTranslateX(450);
        exit.setTranslateY(-60);
        exit.setPrefSize(230, 20);
        exit.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(-40);

        vb1.getChildren().addAll(label1, label2, Insert, delete, Update, Find, getall, print, height, exit, imageView);
        vb1.setSpacing(10);

        bp.setCenter(vb1);

        Insert.setOnAction(a -> {
            try {
                addStudentWBL(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        delete.setOnAction(d -> {
            try {
                deleteStudentWBL(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Update.setOnAction(u -> {
            try {
                updateStudentWBL(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Find.setOnAction(s -> {
            try {
                FindStudentWBL(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        getall.setOnAction(p -> {
            try {
                GetallentWBL(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        print.setOnAction(m -> {
            try {
                print(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        height.setOnAction(m -> {
            try {
               printHeightL(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        exit.setOnAction(m -> {
            try {
                WBLS(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(" * List * ");
        stage.show();

    }
    private void addStudentWBL(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        VBox vb1 = new VBox();

        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);
        // label1.setStyle("-fx-background-color:violate; -fx-padding: 20px;");
        Label label2 = new Label("Insert Student In WestBank ( Literary )");
        label2.setFont(new Font("Insert Student In WestBank ( Literary )", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(300);

        Label num = new Label(" Student Seat Number : ");
        num.setFont(new Font(15));
        num.setPrefWidth(200);
        num.setTranslateY(80);
        num.setTranslateX(170);

        Label branch = new Label(" Branch : ");
        branch.setFont(new Font(15));
        branch.setPrefWidth(200);
        branch.setTranslateY(80);
        branch.setTranslateX(170);

        Label average = new Label(" Average : ");
        average.setFont(new Font(15));
        average.setPrefWidth(200);
        average.setTranslateY(80);
        average.setTranslateX(170);

        GridPane gp = new GridPane();
        gp.setVgap(10);
        TextField numTF = new TextField();
        numTF.setPromptText(" Student Seat Number ");
        numTF.setTranslateX(330);
        numTF.setTranslateY(-13);
        numTF.setPrefWidth(150);
        gp.add(numTF, 3, 0);

        TextField branchTF = new TextField();
        branchTF.setPromptText(" Branch ");
        branchTF.setTranslateX(330);
        branchTF.setTranslateY(-15);
        branchTF.setPrefWidth(150);
        gp.add(branchTF, 3, 1);
        branchTF.setDisable(true);
        numTF.setOnKeyTyped(n -> {
            branchTF.setDisable(false);
        });

        TextField AverageTF = new TextField();
        AverageTF.setPrefWidth(150);
        gp.add(AverageTF, 3, 2);
        AverageTF.setPromptText(" Average ");
        AverageTF.setTranslateX(330);
        AverageTF.setTranslateY(-10);
        AverageTF.setDisable(true);
        branchTF.setOnKeyTyped(n -> {
            AverageTF.setDisable(false);
        });

        ImageView insertIm = new ImageView("https://img.icons8.com/color/344/add.png");
        insertIm.setFitWidth(30);
        insertIm.setFitHeight(30);
        Button insertB = new Button("Insert", insertIm);
        insertB.setTranslateX(300);
        insertB.setTranslateY(5);
        insertB.setPrefSize(150, 30);
        insertB.setStyle("-fx-border-color:purple");

        ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
        backIm.setFitWidth(30);
        backIm.setFitHeight(30);
        Button backB = new Button("Back", backIm);
        backB.setTranslateX(490);
        backB.setTranslateY(-45);
        backB.setPrefSize(150, 30);
        backB.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(-45);

        vb1.getChildren().addAll(label1, label2, num, branch, average, gp, insertB, backB, imageView);
        vb1.setSpacing(10);

        bp.setCenter(vb1);

        insertB.setOnAction(a -> {
           Student.insert(new Tawjihe(),root);
           Student.print();

        });

        backB.setOnAction(b -> {
            try {
                listWBL(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(" * Insert Student  * ");
        stage.show();
    }
    private void deleteStudentWBL(Stage stage) throws Exception {

        BorderPane bp = new BorderPane();
        VBox vb1 = new VBox();

        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);

        Label label2 = new Label("Detete Student In WestBank ( Literary )");
        label2.setFont(new Font("Delete Student In WestBank ( Literary )", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(300);

        Label num = new Label(" Student Seat Number : ");
        num.setFont(new Font(15));
        num.setPrefWidth(200);
        num.setTranslateY(80);
        num.setTranslateX(170);

        Label result = new Label(" Result : ");
        result.setFont(new Font(15));
        result.setPrefWidth(200);
        result.setTranslateY(80);
        result.setTranslateX(170);

        GridPane gp = new GridPane();
        gp.setVgap(10);
        TextField numTF = new TextField();
        numTF.setPromptText(" Student Seat Number ");
        numTF.setTranslateX(330);
        numTF.setTranslateY(-13);
        numTF.setPrefWidth(150);
        gp.add(numTF, 3, 3);

        Label result2 = new Label();
        result2.setFont(new Font(15));
        result2.setPrefWidth(400);
        result2.setPrefHeight(5);
        result2.setTranslateY(-10);
        result2.setTranslateX(330);
        gp.add(result2, 3, 4);
        result2.setStyle("-fx-background-color: Thistle; -fx-padding: 20px;");

        ImageView deleteIm = new ImageView("https://cdn-icons-png.flaticon.com/512/3221/3221897.png");
        deleteIm.setFitWidth(30);
        deleteIm.setFitHeight(30);
        Button deleteB = new Button("Delete", deleteIm);
        deleteB.setTranslateX(300);
        deleteB.setTranslateY(5);
        deleteB.setPrefSize(150, 30);
        deleteB.setStyle("-fx-border-color:purple");

        ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
        backIm.setFitWidth(30);
        backIm.setFitHeight(30);
        Button backB = new Button("Back", backIm);
        backB.setTranslateX(490);
        backB.setTranslateY(-45);
        backB.setPrefSize(150, 30);
        backB.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(-45);

        vb1.getChildren().addAll(label1, label2, num, result, gp, deleteB, backB, imageView);
        vb1.setSpacing(10);

        bp.setCenter(vb1);

        deleteB.setOnAction(a -> {

            /*
             * mange.addCustomer(nameTF.getText(), idTF.getText(), mobileTF.getText(),
             * addressTF.getText(), planTF.getText());
             *
             * System.out.println(mange.customers); try {
             *
             * if (outputFile.createNewFile()) { System.out.println("File created: " +
             * outputFile.getName()); } else { System.out.println("File already exists."); }
             * FileWriter myWriter = new FileWriter("out.txt"); for (int i = 0; i <
             * mange.customers.size(); i++) {
             * myWriter.write(mange.customers.get(i).toString() + "\n"); } myWriter.close();
             * } catch (IOException e) { System.out.println("An error occurred.");
             * e.printStackTrace(); }
             */
        });

        backB.setOnAction(b -> {
            try {
                listWBL(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(" * Delete Student  * ");

    }
    private void updateStudentWBL(Stage stage) throws Exception {

            BorderPane bp = new BorderPane();
            VBox vb1 = new VBox();

            Label label1 = new Label("High school results (Tawjihi 2022)");
            label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
            label1.setPrefWidth(500);
            label1.setTranslateY(60);
            label1.setTranslateX(255);
            // label1.setStyle("-fx-background-color:violate; -fx-padding: 20px;");
            Label label2 = new Label("Update Student In WestBank ( Literary )");
            label2.setFont(new Font("Update Student In WestBank ( Literary )", 20));
            label2.setPrefWidth(500);
            label2.setTranslateY(80);
            label2.setTranslateX(300);

            Label num = new Label(" Student Seat Number : ");
            num.setFont(new Font(15));
            num.setPrefWidth(200);
            num.setTranslateY(80);
            num.setTranslateX(170);

            Label branch = new Label(" Branch : ");
            branch.setFont(new Font(15));
            branch.setPrefWidth(200);
            branch.setTranslateY(80);
            branch.setTranslateX(170);

            Label average = new Label(" Average : ");
            average.setFont(new Font(15));
            average.setPrefWidth(200);
            average.setTranslateY(80);
            average.setTranslateX(170);

            GridPane gp = new GridPane();
            gp.setVgap(10);
            TextField numTF = new TextField();
            numTF.setPromptText(" Student Seat Number ");
            numTF.setTranslateX(330);
            numTF.setTranslateY(-13);
            numTF.setPrefWidth(150);
            gp.add(numTF, 3, 0);

            TextField branchTF = new TextField();
            branchTF.setPromptText(" Branch ");
            branchTF.setTranslateX(330);
            branchTF.setTranslateY(-15);
            branchTF.setPrefWidth(150);
            gp.add(branchTF, 3, 1);


            TextField AverageTF = new TextField();
            AverageTF.setPrefWidth(150);
            gp.add(AverageTF, 3, 2);
            AverageTF.setPromptText(" Average ");
            AverageTF.setTranslateX(330);
            AverageTF.setTranslateY(-10);


            ImageView updateIm = new ImageView("https://cdn-icons-png.flaticon.com/512/724/724834.png");
            updateIm.setFitWidth(30);
             updateIm.setFitHeight(30);
            Button updateB = new Button("Update", updateIm);
             updateB.setTranslateX(300);
             updateB.setTranslateY(5);
             updateB.setPrefSize(150, 30);
             updateB.setStyle("-fx-border-color:purple");

            ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
            backIm.setFitWidth(30);
            backIm.setFitHeight(30);
            Button backB = new Button("Back", backIm);
            backB.setTranslateX(690);
            backB.setTranslateY(-95);
            backB.setPrefSize(150, 30);
            backB.setStyle("-fx-border-color:purple");

             ImageView FindIm = new ImageView("https://cdn-icons-png.flaticon.com/512/2310/2310707.png");
             FindIm.setFitWidth(30);
              FindIm.setFitHeight(30);
              Button FindB = new Button("Find", FindIm);
             FindB.setTranslateX(490);
             FindB.setTranslateY(-45);
             FindB.setPrefSize(150, 30);
             FindB.setStyle("-fx-border-color:purple");

            Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitWidth(1000);
            imageView.setFitHeight(250);
            imageView.setTranslateY(-75);

            vb1.getChildren().addAll(label1, label2, num, branch, average, gp, updateB,FindB, backB, imageView);
            vb1.setSpacing(10);

            bp.setCenter(vb1);

            updateB.setOnAction(a -> {


            });
              FindB.setOnAction(a -> {


                });

            backB.setOnAction(b -> {
                try {
                    listWBL(stage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            Scene scene = new Scene(bp, 1000, 600);
            stage.setScene(scene);
            stage.setTitle(" * Update Student  * ");
            stage.show();
        }
    private void FindStudentWBL(Stage stage) throws Exception {

        BorderPane bp = new BorderPane();
        VBox vb1 = new VBox();

        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);
        // label1.setStyle("-fx-background-color:violate; -fx-padding: 20px;");
        Label label2 = new Label("Find The Student In WestBank ( Literary )");
        label2.setFont(new Font("Find The Student In WestBank ( Literary )", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(300);

        Label num = new Label(" Student Seat Number : ");
        num.setFont(new Font(15));
        num.setPrefWidth(200);
        num.setTranslateY(80);
        num.setTranslateX(170);

        Label branch = new Label(" Branch : ");
        branch.setFont(new Font(15));
        branch.setPrefWidth(200);
        branch.setTranslateY(80);
        branch.setTranslateX(170);

        Label average = new Label(" Average : ");
        average.setFont(new Font(15));
        average.setPrefWidth(200);
        average.setTranslateY(80);
        average.setTranslateX(170);

        GridPane gp = new GridPane();
        gp.setVgap(10);
        TextField numTF = new TextField();
        numTF.setPromptText(" Student Seat Number ");
        numTF.setTranslateX(330);
        numTF.setTranslateY(-13);
        numTF.setPrefWidth(150);
        gp.add(numTF, 3, 0);


        TextField branchTF = new TextField();
        branchTF.setPromptText(" Branch ");
        branchTF.setTranslateX(330);
        branchTF.setTranslateY(-15);
        branchTF.setPrefWidth(150);
        gp.add(branchTF, 3, 1);
        branchTF.setDisable(true);


        TextField AverageTF = new TextField();
        AverageTF.setPrefWidth(150);
        gp.add(AverageTF, 3, 2);
        AverageTF.setPromptText(" Average ");
        AverageTF.setTranslateX(330);
        AverageTF.setTranslateY(-10);
        AverageTF.setDisable(true);


        ImageView previousIm = new ImageView("https://cdn-icons-png.flaticon.com/512/3318/3318703.png");
        previousIm.setFitWidth(30);
        previousIm.setFitHeight(30);
        Button previousB = new Button("Previous", previousIm);
        previousB.setTranslateX(100);
        previousB.setTranslateY(5);
        previousB.setPrefSize(150, 30);
        previousB.setStyle("-fx-border-color:purple");

        ImageView FindIm = new ImageView("https://cdn-icons-png.flaticon.com/512/2310/2310707.png");
        FindIm.setFitWidth(30);
        FindIm.setFitHeight(30);
        Button FindB = new Button("Find", FindIm);
        FindB.setTranslateX(290);
        FindB.setTranslateY(-45);
        FindB.setPrefSize(150, 30);
        FindB.setStyle("-fx-border-color:purple");

        ImageView nextIm = new ImageView("https://cdn-icons-png.flaticon.com/512/1/1371.png");
        nextIm.setFitWidth(30);
        nextIm.setFitHeight(30);
        Button nextB = new Button("Next", nextIm);
        nextB.setTranslateX(490);
        nextB.setTranslateY(-95);
        nextB.setPrefSize(150, 30);
        nextB.setStyle("-fx-border-color:purple");


        ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
        backIm.setFitWidth(30);
        backIm.setFitHeight(30);
        Button backB = new Button("Back", backIm);
        backB.setTranslateX(690);
        backB.setTranslateY(-145);
        backB.setPrefSize(150, 30);
        backB.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(-135);

        vb1.getChildren().addAll(label1, label2, num, branch, average, gp, previousB,FindB, nextB,backB, imageView);
        vb1.setSpacing(10);

        bp.setCenter(vb1);
        previousB.setOnAction(a -> {


        });

        FindB.setOnAction(a -> {


        });

        nextB.setOnAction(a -> {


        });

        backB.setOnAction(b -> {
            try {
                listWBL(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(" * Find The Student  * ");

    }
    private void GetallentWBL(Stage stage) throws Exception {

        BorderPane bp = new BorderPane();
        VBox vb1 = new VBox();

        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);

        Label label2 = new Label(" Student In WestBank ( Literary )");
        label2.setFont(new Font(" Student In WestBank ( Literary )", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(300);

        Label top = new Label(" Average : ");
        top.setFont(new Font(15));
        top.setPrefWidth(200);
        top.setTranslateY(80);
        top.setTranslateX(250);

        GridPane gp = new GridPane();
        gp.setVgap(10);

        TextField numTF = new TextField();
        numTF.setPromptText(" Average ");
        numTF.setTranslateX(330);
        numTF.setTranslateY(-13);
        numTF.setPrefWidth(150);
        gp.add(numTF, 3, 3);

        TextArea area = new TextArea();
        area.setPromptText(" Get All Student  ");
        area.setTranslateX(365);
        area.setTranslateY(10);
        area.setPrefWidth(300);
        area.setDisable(true);
        gp.add(area, 4, 3);

        // result2.setStyle("-fx-background-color: Thistle; -fx-padding: 20px;");

        ImageView resultIm = new ImageView("https://cdn-icons-png.flaticon.com/512/1162/1162914.png");
        resultIm.setFitWidth(30);
        resultIm.setFitHeight(30);
        Button resultB = new Button("Result", resultIm);
        resultB.setTranslateX(300);
        resultB.setTranslateY(25);
        resultB.setPrefSize(150, 30);
        resultB.setStyle("-fx-border-color:purple");

        ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
        backIm.setFitWidth(30);
        backIm.setFitHeight(30);
        Button backB = new Button("Back", backIm);
        backB.setTranslateX(490);
        backB.setTranslateY(-25);
        backB.setPrefSize(150, 30);
        backB.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(-10);

        vb1.getChildren().addAll(label1, label2, top, gp, resultB, backB, imageView);
        vb1.setSpacing(10);

        bp.setCenter(vb1);

        resultB.setOnAction(a -> {


        });

        backB.setOnAction(b -> {
            try {
                listWBL(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);

    }
    private void print (Stage stage) throws Exception{
             BorderPane bp = new BorderPane();
             VBox vb = new VBox();
             Label label1 = new Label("High school results (Tawjihi 2022)");
             label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
             label1.setPrefWidth(500);
             label1.setTranslateY(60);
             label1.setTranslateX(255);
    // label1.setStyle("-fx-background-color:violate; -fx-padding: 20px;");
             Label label2 = new Label(" Pirnt In The West Bank");
             label2.setFont(new Font(" Print In The West Bank", 20));
             label2.setPrefWidth(500);
             label2.setTranslateY(80);
             label2.setTranslateX(370);

          ImageView LiteraryIm = new ImageView("https://cdn-icons-png.flaticon.com/512/2821/2821637.png");
          LiteraryIm.setFitWidth(30);
          LiteraryIm.setFitHeight(30);
          Button DLL = new Button("Double Linked List ", LiteraryIm);
          DLL.setTranslateX(650);
          DLL.setTranslateY(90);
          DLL.setPrefSize(200, 50);
          DLL.setStyle("-fx-border-color:purple");

         ImageView ScienceIm = new ImageView("https://cdn-icons-png.flaticon.com/512/2821/2821637.png");
         ScienceIm.setFitWidth(30);
         ScienceIm.setFitHeight(30);
         Button avl1 = new Button("AVL sort by number", ScienceIm);
        avl1.setTranslateX(150);
        avl1.setTranslateY(30);
        avl1.setPrefSize(200, 50);
        avl1.setStyle("-fx-border-color:purple");

        ImageView Science1Im = new ImageView("https://cdn-icons-png.flaticon.com/512/2821/2821637.png");
        Science1Im.setFitWidth(30);
        Science1Im.setFitHeight(30);
        Button avl2 = new Button("AVL sort by average", Science1Im);
        avl2.setTranslateX(400);
        avl2.setTranslateY(-30);
        avl2.setPrefSize(200, 50);
        avl2.setStyle("-fx-border-color:purple");

    ImageView BackIm = new ImageView("https://cdn-icons-png.flaticon.com/512/8482/8482632.png");
        BackIm.setFitWidth(30);
        BackIm.setFitHeight(30);
    Button Back = new Button("Back", BackIm);
        Back.setTranslateX(405);
        Back.setTranslateY(20);
        Back.setPrefSize(150, 50);
        Back.setStyle("-fx-border-color:purple");

    Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
    ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(45);

        vb.getChildren().addAll(label1, label2, DLL, avl1,avl2, Back, imageView);
        vb.setSpacing(20);

        bp.setCenter(vb);

        DLL.setOnAction(e -> {
        try {
            DLLWBL(stage);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    });

        avl1.setOnAction(e -> {
        try {
           avl1L(stage);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    });
        avl2.setOnAction(e -> {
            try {
                avl2L(stage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        Back.setOnAction(e -> {
        try {
            start(stage);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    });
    // bp.setStyle("-fx-background-color: white;");
    Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);
        stage.show();

}
    private void DLLWBL(Stage stage) throws Exception {

        BorderPane bp = new BorderPane();
        VBox vb1 = new VBox();

        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);

        Label label2 = new Label(" Student In WestBank ( Literary )");
        label2.setFont(new Font(" Student In WestBank ( Literary )", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(300);

        Label top = new Label(" Print Double Linked List : ");
        top.setFont(new Font(15));
        top.setPrefWidth(200);
        top.setTranslateY(80);
        top.setTranslateX(170);

        GridPane gp = new GridPane();
        gp.setVgap(10);
        TextArea area = new TextArea();
        area.setPromptText(" Double Linked List");
        area.setTranslateX(365);
        area.setTranslateY(10);
        area.setPrefWidth(300);
        area.setDisable(true);
        gp.add(area, 3, 3);

        // result2.setStyle("-fx-background-color: Thistle; -fx-padding: 20px;");

        ImageView resultIm = new ImageView("https://cdn-icons-png.flaticon.com/512/839/839184.png");
        resultIm.setFitWidth(30);
        resultIm.setFitHeight(30);
        Button resultB = new Button("Print ", resultIm);
        resultB.setTranslateX(300);
        resultB.setTranslateY(25);
        resultB.setPrefSize(150, 30);
        resultB.setStyle("-fx-border-color:purple");

        ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
        backIm.setFitWidth(30);
        backIm.setFitHeight(30);
        Button backB = new Button("Back", backIm);
        backB.setTranslateX(490);
        backB.setTranslateY(-25);
        backB.setPrefSize(150, 30);
        backB.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(-10);

        vb1.getChildren().addAll(label1, label2, top, gp, resultB, backB, imageView);
        vb1.setSpacing(10);

        bp.setCenter(vb1);

        resultB.setOnAction(a -> {


        });

        backB.setOnAction(b -> {
            try {
                print(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);

    }
    private void avl2L(Stage stage) throws Exception {

        BorderPane bp = new BorderPane();
        VBox vb1 = new VBox();

        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);

        Label label2 = new Label(" Student In WestBank ( Literary )");
        label2.setFont(new Font(" Student In WestBank ( Literary )", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(300);

        Label top = new Label(" AVL Sort By Average : ");
        top.setFont(new Font(15));
        top.setPrefWidth(200);
        top.setTranslateY(80);
        top.setTranslateX(170);

        GridPane gp = new GridPane();
        gp.setVgap(10);
        TextArea area = new TextArea();
        area.setPromptText(" AVL Sort By Average");
        area.setTranslateX(365);
        area.setTranslateY(10);
        area.setPrefWidth(300);
        area.setDisable(true);
        gp.add(area, 3, 3);

        // result2.setStyle("-fx-background-color: Thistle; -fx-padding: 20px;");

        ImageView resultIm = new ImageView("https://cdn-icons-png.flaticon.com/512/839/839184.png");
        resultIm.setFitWidth(30);
        resultIm.setFitHeight(30);
        Button resultB = new Button("Print ", resultIm);
        resultB.setTranslateX(300);
        resultB.setTranslateY(25);
        resultB.setPrefSize(150, 30);
        resultB.setStyle("-fx-border-color:purple");

        ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
        backIm.setFitWidth(30);
        backIm.setFitHeight(30);
        Button backB = new Button("Back", backIm);
        backB.setTranslateX(490);
        backB.setTranslateY(-25);
        backB.setPrefSize(150, 30);
        backB.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(-10);

        vb1.getChildren().addAll(label1, label2, top, gp, resultB, backB, imageView);
        vb1.setSpacing(10);

        bp.setCenter(vb1);

        resultB.setOnAction(a -> {


        });

        backB.setOnAction(b -> {
            try {
                print(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);

    }
    private void avl1L(Stage stage) throws Exception {

        BorderPane bp = new BorderPane();
        VBox vb1 = new VBox();

        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);

        Label label2 = new Label(" Student In WestBank ( Literary )");
        label2.setFont(new Font(" Student In WestBank ( Literary )", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(300);

        Label top = new Label(" AVL Sort By Number : ");
        top.setFont(new Font(15));
        top.setPrefWidth(200);
        top.setTranslateY(80);
        top.setTranslateX(170);

        GridPane gp = new GridPane();
        gp.setVgap(10);
        TextArea area = new TextArea();
        area.setPromptText(" AVL Sort By Seat Number");
        area.setTranslateX(365);
        area.setTranslateY(10);
        area.setPrefWidth(300);
        area.setDisable(true);
        gp.add(area, 3, 3);

        // result2.setStyle("-fx-background-color: Thistle; -fx-padding: 20px;");

        ImageView resultIm = new ImageView("https://cdn-icons-png.flaticon.com/512/839/839184.png");
        resultIm.setFitWidth(30);
        resultIm.setFitHeight(30);
        Button resultB = new Button("Print ", resultIm);
        resultB.setTranslateX(300);
        resultB.setTranslateY(25);
        resultB.setPrefSize(150, 30);
        resultB.setStyle("-fx-border-color:purple");

        ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
        backIm.setFitWidth(30);
        backIm.setFitHeight(30);
        Button backB = new Button("Back", backIm);
        backB.setTranslateX(490);
        backB.setTranslateY(-25);
        backB.setPrefSize(150, 30);
        backB.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(-10);

        vb1.getChildren().addAll(label1, label2, top, gp, resultB, backB, imageView);
        vb1.setSpacing(10);

        bp.setCenter(vb1);

        resultB.setOnAction(a -> {


        });

        backB.setOnAction(b -> {
            try {
              print(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);

    }
    private void printHeightL(Stage stage) throws Exception {

        BorderPane bp = new BorderPane();
        VBox vb = new VBox();
        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);
        // label1.setStyle("-fx-background-color:violate; -fx-padding: 20px;");
        Label label2 = new Label("In The West Bank");
        label2.setFont(new Font("In The West Bank", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(370);

        ImageView LiteraryIm = new ImageView("https://cdn-icons-png.flaticon.com/512/2821/2821637.png");
        LiteraryIm.setFitWidth(30);
        LiteraryIm.setFitHeight(30);
        Button HA = new Button("Height AVL Sort By Average ", LiteraryIm);
        HA.setTranslateX(490);
        HA.setTranslateY(90);
        HA.setPrefSize(230, 50);
        HA.setStyle("-fx-border-color:purple");

        ImageView ScienceIm = new ImageView("https://cdn-icons-png.flaticon.com/512/2821/2821637.png");
        ScienceIm.setFitWidth(30);
        ScienceIm.setFitHeight(30);
        Button HN = new Button("Height AVL Sort By Number", ScienceIm);
        HN.setTranslateX(250);
        HN.setTranslateY(20);
        HN.setPrefSize(230, 50);
        HN.setStyle("-fx-border-color:purple");

        ImageView BackIm = new ImageView("https://cdn-icons-png.flaticon.com/512/8482/8482632.png");
        BackIm.setFitWidth(30);
        BackIm.setFitHeight(30);
        Button Back = new Button("Back", BackIm);
        Back.setTranslateX(405);
        Back.setTranslateY(20);
        Back.setPrefSize(150, 50);
        Back.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(45);

        vb.getChildren().addAll(label1, label2, HA,HN, Back, imageView);
        vb.setSpacing(20);

        bp.setCenter(vb);

        HA.setOnAction(e -> {
            try {
                avl2HL(stage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        HN.setOnAction(e -> {
            try {
                avl1HL(stage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        Back.setOnAction(e -> {
            try {
                listWBL(stage);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        // bp.setStyle("-fx-background-color: white;");
        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);
        stage.show();

    }
    private void avl2HL(Stage stage) throws Exception {

        BorderPane bp = new BorderPane();
        VBox vb1 = new VBox();

        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);

        Label label2 = new Label("AVL Student In WestBank ( Literary )");
        label2.setFont(new Font("AVL Student In WestBank ( Literary )", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(300);

        Label height = new Label("Height AVL Sort By Average : ");
        height.setFont(new Font(15));
        height.setPrefWidth(250);
        height.setTranslateY(80);
        height.setTranslateX(150);

        GridPane gp = new GridPane();
        gp.setVgap(10);
        TextField meanTF = new TextField();
        meanTF.setPromptText("  Height ");
        meanTF.setTranslateX(360);
        meanTF.setTranslateY(18);
        meanTF.setPrefWidth(150);
        meanTF.setDisable(true);
        gp.add(meanTF, 3, 3);

        ImageView resultIm = new ImageView("https://cdn-icons-png.flaticon.com/512/1162/1162914.png");
        resultIm.setFitWidth(30);
        resultIm.setFitHeight(30);
        Button resultB = new Button("Result", resultIm);
        resultB.setTranslateX(300);
        resultB.setTranslateY(85);
        resultB.setPrefSize(150, 30);
        resultB.setStyle("-fx-border-color:purple");

        ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
        backIm.setFitWidth(30);
        backIm.setFitHeight(30);
        Button backB = new Button("Back", backIm);
        backB.setTranslateX(490);
        backB.setTranslateY(35);
        backB.setPrefSize(150, 30);
        backB.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(55);

        vb1.getChildren().addAll(label1, label2, height, gp, resultB, backB, imageView);
        vb1.setSpacing(10);

        bp.setCenter(vb1);

        resultB.setOnAction(a -> {


        });

        backB.setOnAction(b -> {
            try {
                printHeightL(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);

    }
    private void avl1HL(Stage stage) throws Exception {

        BorderPane bp = new BorderPane();
        VBox vb1 = new VBox();

        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);

        Label label2 = new Label("AVL Student In WestBank ( Literary )");
        label2.setFont(new Font("AVL Student In WestBank ( Literary )", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(300);

        Label mean = new Label(" Height AVL Sort By Number : ");
        mean.setFont(new Font(15));
        mean.setPrefWidth(230);
        mean.setTranslateY(80);
        mean.setTranslateX(150);

        GridPane gp = new GridPane();
        gp.setVgap(10);
        TextField meanTF = new TextField();
        meanTF.setPromptText("  Height ");
        meanTF.setTranslateX(360);
        meanTF.setTranslateY(18);
        meanTF.setPrefWidth(150);
        meanTF.setDisable(true);
        gp.add(meanTF, 3, 3);

        ImageView resultIm = new ImageView("https://cdn-icons-png.flaticon.com/512/1162/1162914.png");
        resultIm.setFitWidth(30);
        resultIm.setFitHeight(30);
        Button resultB = new Button("Result", resultIm);
        resultB.setTranslateX(300);
        resultB.setTranslateY(85);
        resultB.setPrefSize(150, 30);
        resultB.setStyle("-fx-border-color:purple");

        ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
        backIm.setFitWidth(30);
        backIm.setFitHeight(30);
        Button backB = new Button("Back", backIm);
        backB.setTranslateX(490);
        backB.setTranslateY(35);
        backB.setPrefSize(150, 30);
        backB.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(55);

        vb1.getChildren().addAll(label1, label2, mean, gp, resultB, backB, imageView);
        vb1.setSpacing(10);

        bp.setCenter(vb1);

        resultB.setOnAction(a -> {


        });

        backB.setOnAction(b -> {
            try {
                printHeightL(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);

    }
    public void listWBS(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        VBox vb1 = new VBox();
        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);
        // label1.setStyle("-fx-background-color:violate; -fx-padding: 20px;");
        Label label2 = new Label("In The West Bank ( Science )");
        label2.setFont(new Font("In The West Bank ( Science )", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(370);

        Button Insert = new Button(" Insert new Student ");
        Insert.setTranslateX(100);
        Insert.setTranslateY(90);
        Insert.setPrefSize(230, 20);
        Insert.setStyle("-fx-border-color:purple");

        Button delete = new Button(" Delete Student ");
        delete.setTranslateX(100);
        delete.setTranslateY(90);
        delete.setPrefSize(230, 20);
        delete.setStyle("-fx-border-color:purple");

        Button search = new Button(" Search ");
        search.setTranslateX(100);
        search.setTranslateY(90);
        search.setPrefSize(230, 20);
        search.setStyle("-fx-border-color:purple");

        Button DTopS = new Button(" Display The Top 10 Students ");
        DTopS.setTranslateX(100);
        DTopS.setTranslateY(90);
        DTopS.setPrefSize(230, 20);
        DTopS.setStyle("-fx-border-color:purple");

        Button mean = new Button(" Display the mean ");
        mean.setTranslateX(450);
        mean.setTranslateY(-60);
        mean.setPrefSize(230, 20);
        mean.setStyle("-fx-border-color:purple");

        Button modA = new Button(" display the mode average  ");
        modA.setTranslateX(450);
        modA.setTranslateY(-60);
        modA.setPrefSize(230, 20);
        modA.setStyle("-fx-border-color:purple");

        Button numOfS = new Button(" Number And Percentage Of Students   ");
        numOfS.setTranslateX(450);
        numOfS.setTranslateY(-60);
        numOfS.setPrefSize(230, 20);
        numOfS.setStyle("-fx-border-color:purple");

        Button exit = new Button(" Exit  ");
        exit.setTranslateX(450);
        exit.setTranslateY(-60);
        exit.setPrefSize(230, 20);
        exit.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(-40);

        vb1.getChildren().addAll(label1, label2, Insert, delete, search, DTopS, mean, modA, numOfS, exit, imageView);
        vb1.setSpacing(10);

        bp.setCenter(vb1);

        Insert.setOnAction(a -> {
            try {
                addStudentWBS(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        delete.setOnAction(d -> {
            try {
                deleteStudentWBS(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        search.setOnAction(u -> {
            try {
                searchStudentWBS(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        DTopS.setOnAction(s -> {
            try {
                TopStudentWBS(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        mean.setOnAction(p -> {
            try {
                meanStudentWBS(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        modA.setOnAction(m -> {
            try {
                modeAStudentWBS(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        numOfS.setOnAction(m -> {
            try {
                returnNPStudentWBS(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        exit.setOnAction(m -> {
            try {
                WBLS(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(" * List * ");
        stage.show();

    }

    private void addStudentWBS(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        VBox vb1 = new VBox();

        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);
        // label1.setStyle("-fx-background-color:violate; -fx-padding: 20px;");
        Label label2 = new Label("Insert Student In WestBank ( Science )");
        label2.setFont(new Font("Insert Student In WestBank ( Science )", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(300);

        Label num = new Label(" Student Seat Number : ");
        num.setFont(new Font(15));
        num.setPrefWidth(200);
        num.setTranslateY(80);
        num.setTranslateX(170);

        Label branch = new Label(" Branch : ");
        branch.setFont(new Font(15));
        branch.setPrefWidth(200);
        branch.setTranslateY(80);
        branch.setTranslateX(170);

        Label average = new Label(" Average : ");
        average.setFont(new Font(15));
        average.setPrefWidth(200);
        average.setTranslateY(80);
        average.setTranslateX(170);

        GridPane gp = new GridPane();
        gp.setVgap(10);
        TextField numTF = new TextField();
        numTF.setPromptText(" Student Seat Number ");
        numTF.setTranslateX(330);
        numTF.setTranslateY(-13);
        numTF.setPrefWidth(150);
        gp.add(numTF, 3, 0);

        TextField branchTF = new TextField();
        branchTF.setPromptText(" Branch ");
        branchTF.setTranslateX(330);
        branchTF.setTranslateY(-15);
        branchTF.setPrefWidth(150);
        gp.add(branchTF, 3, 1);
        branchTF.setDisable(true);
        numTF.setOnKeyTyped(n -> {
            branchTF.setDisable(false);
        });

        TextField AverageTF = new TextField();
        AverageTF.setPrefWidth(150);
        gp.add(AverageTF, 3, 2);
        AverageTF.setPromptText(" Average ");
        AverageTF.setTranslateX(330);
        AverageTF.setTranslateY(-10);
        AverageTF.setDisable(true);
        branchTF.setOnKeyTyped(n -> {
            AverageTF.setDisable(false);
        });

        ImageView insertIm = new ImageView("https://img.icons8.com/color/344/add.png");
        insertIm.setFitWidth(30);
        insertIm.setFitHeight(30);
        Button insertB = new Button("Insert", insertIm);
        insertB.setTranslateX(300);
        insertB.setTranslateY(5);
        insertB.setPrefSize(150, 30);
        insertB.setStyle("-fx-border-color:purple");

        ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
        backIm.setFitWidth(30);
        backIm.setFitHeight(30);
        Button backB = new Button("Back", backIm);
        backB.setTranslateX(490);
        backB.setTranslateY(-45);
        backB.setPrefSize(150, 30);
        backB.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(-45);

        vb1.getChildren().addAll(label1, label2, num, branch, average, gp, insertB, backB, imageView);
        vb1.setSpacing(10);

        bp.setCenter(vb1);

        insertB.setOnAction(a -> {

            /*
             * mange.addCustomer(nameTF.getText(), idTF.getText(), mobileTF.getText(),
             * addressTF.getText(), planTF.getText());
             *
             * System.out.println(mange.customers); try {
             *
             * if (outputFile.createNewFile()) { System.out.println("File created: " +
             * outputFile.getName()); } else { System.out.println("File already exists."); }
             * FileWriter myWriter = new FileWriter("out.txt"); for (int i = 0; i <
             * mange.customers.size(); i++) {
             * myWriter.write(mange.customers.get(i).toString() + "\n"); } myWriter.close();
             * } catch (IOException e) { System.out.println("An error occurred.");
             * e.printStackTrace(); }
             */
        });

        backB.setOnAction(b -> {
            try {
                listWBS(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(" * Insert Student  * ");
        stage.show();
    }

    private void deleteStudentWBS(Stage stage) throws Exception {

        BorderPane bp = new BorderPane();
        VBox vb1 = new VBox();

        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);

        Label label2 = new Label("Detete Student In WestBank ( Science )");
        label2.setFont(new Font("Delete Student In WestBank ( Science )", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(300);

        Label num = new Label(" Student Seat Number : ");
        num.setFont(new Font(15));
        num.setPrefWidth(200);
        num.setTranslateY(80);
        num.setTranslateX(170);

        Label result = new Label(" Result : ");
        result.setFont(new Font(15));
        result.setPrefWidth(200);
        result.setTranslateY(80);
        result.setTranslateX(170);

        GridPane gp = new GridPane();
        gp.setVgap(10);
        TextField numTF = new TextField();
        numTF.setPromptText(" Student Seat Number ");
        numTF.setTranslateX(330);
        numTF.setTranslateY(-13);
        numTF.setPrefWidth(150);
        gp.add(numTF, 3, 3);

        Label result2 = new Label();
        result2.setFont(new Font(15));
        result2.setPrefWidth(400);
        result2.setPrefHeight(5);
        result2.setTranslateY(-10);
        result2.setTranslateX(330);
        gp.add(result2, 3, 4);
        result2.setStyle("-fx-background-color: Thistle; -fx-padding: 20px;");

        ImageView deleteIm = new ImageView("https://cdn-icons-png.flaticon.com/512/3221/3221897.png");
        deleteIm.setFitWidth(30);
        deleteIm.setFitHeight(30);
        Button deleteB = new Button("Delete", deleteIm);
        deleteB.setTranslateX(300);
        deleteB.setTranslateY(5);
        deleteB.setPrefSize(150, 30);
        deleteB.setStyle("-fx-border-color:purple");

        ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
        backIm.setFitWidth(30);
        backIm.setFitHeight(30);
        Button backB = new Button("Back", backIm);
        backB.setTranslateX(490);
        backB.setTranslateY(-45);
        backB.setPrefSize(150, 30);
        backB.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(-45);

        vb1.getChildren().addAll(label1, label2, num, result, gp, deleteB, backB, imageView);
        vb1.setSpacing(10);

        bp.setCenter(vb1);

        deleteB.setOnAction(a -> {

            /*
             * mange.addCustomer(nameTF.getText(), idTF.getText(), mobileTF.getText(),
             * addressTF.getText(), planTF.getText());
             *
             * System.out.println(mange.customers); try {
             *
             * if (outputFile.createNewFile()) { System.out.println("File created: " +
             * outputFile.getName()); } else { System.out.println("File already exists."); }
             * FileWriter myWriter = new FileWriter("out.txt"); for (int i = 0; i <
             * mange.customers.size(); i++) {
             * myWriter.write(mange.customers.get(i).toString() + "\n"); } myWriter.close();
             * } catch (IOException e) { System.out.println("An error occurred.");
             * e.printStackTrace(); }
             */
        });

        backB.setOnAction(b -> {
            try {
                listWBS(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(" * Delete Student  * ");

    }

    private void searchStudentWBS(Stage stage) throws Exception {

        BorderPane bp = new BorderPane();
        VBox vb1 = new VBox();

        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);

        Label label2 = new Label("Search Student In WestBank ( Science )");
        label2.setFont(new Font("Search Student In WestBank ( Science )", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(300);

        Label num = new Label(" Student Seat Number : ");
        num.setFont(new Font(15));
        num.setPrefWidth(200);
        num.setTranslateY(80);
        num.setTranslateX(170);

        Label result = new Label(" Result : ");
        result.setFont(new Font(15));
        result.setPrefWidth(200);
        result.setTranslateY(80);
        result.setTranslateX(170);

        GridPane gp = new GridPane();
        gp.setVgap(10);
        TextField numTF = new TextField();
        numTF.setPromptText(" Student Seat Number ");
        numTF.setTranslateX(330);
        numTF.setTranslateY(-13);
        numTF.setPrefWidth(150);
        gp.add(numTF, 3, 3);

        Label result2 = new Label();
        result2.setFont(new Font(15));
        result2.setPrefWidth(200);
        result2.setPrefHeight(5);
        result2.setTranslateY(-10);
        result2.setTranslateX(330);
        gp.add(result2, 3, 4);
        result2.setStyle("-fx-background-color: Thistle; -fx-padding: 20px;");

        ImageView searchIm = new ImageView("https://cdn-icons-png.flaticon.com/512/954/954591.png");
        searchIm.setFitWidth(30);
        searchIm.setFitHeight(30);
        Button searchB = new Button("Search", searchIm);
        searchB.setTranslateX(300);
        searchB.setTranslateY(5);
        searchB.setPrefSize(150, 30);
        searchB.setStyle("-fx-border-color:purple");

        ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
        backIm.setFitWidth(30);
        backIm.setFitHeight(30);
        Button backB = new Button("Back", backIm);
        backB.setTranslateX(490);
        backB.setTranslateY(-45);
        backB.setPrefSize(150, 30);
        backB.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(-45);

        vb1.getChildren().addAll(label1, label2, num, result, gp, searchB, backB, imageView);
        vb1.setSpacing(10);

        bp.setCenter(vb1);

        searchB.setOnAction(a -> {

            /*
             * mange.addCustomer(nameTF.getText(), idTF.getText(), mobileTF.getText(),
             * addressTF.getText(), planTF.getText());
             *
             * System.out.println(mange.customers); try {
             *
             * if (outputFile.createNewFile()) { System.out.println("File created: " +
             * outputFile.getName()); } else { System.out.println("File already exists."); }
             * FileWriter myWriter = new FileWriter("out.txt"); for (int i = 0; i <
             * mange.customers.size(); i++) {
             * myWriter.write(mange.customers.get(i).toString() + "\n"); } myWriter.close();
             * } catch (IOException e) { System.out.println("An error occurred.");
             * e.printStackTrace(); }
             */
        });

        backB.setOnAction(b -> {
            try {
                listWBS(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);
        stage.setTitle(" * Search Student  * ");

    }

    private void TopStudentWBS(Stage stage) throws Exception {

        BorderPane bp = new BorderPane();
        VBox vb1 = new VBox();

        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);

        Label label2 = new Label(" Student In WestBank ( Science )");
        label2.setFont(new Font(" Student In WestBank ( Science )", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(300);

        Label top = new Label(" Top 10 Student In Science : ");
        top.setFont(new Font(15));
        top.setPrefWidth(200);
        top.setTranslateY(80);
        top.setTranslateX(170);

        GridPane gp = new GridPane();
        gp.setVgap(10);
        TextArea area = new TextArea();
        area.setPromptText(" Top 10 Student  ");
        area.setTranslateX(365);
        area.setTranslateY(10);
        area.setPrefWidth(300);
        area.setDisable(true);
        gp.add(area, 3, 3);

        // result2.setStyle("-fx-background-color: Thistle; -fx-padding: 20px;");

        ImageView resultIm = new ImageView("https://cdn-icons-png.flaticon.com/512/1162/1162914.png");
        resultIm.setFitWidth(30);
        resultIm.setFitHeight(30);
        Button resultB = new Button("Result", resultIm);
        resultB.setTranslateX(300);
        resultB.setTranslateY(25);
        resultB.setPrefSize(150, 30);
        resultB.setStyle("-fx-border-color:purple");

        ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
        backIm.setFitWidth(30);
        backIm.setFitHeight(30);
        Button backB = new Button("Back", backIm);
        backB.setTranslateX(490);
        backB.setTranslateY(-25);
        backB.setPrefSize(150, 30);
        backB.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(-10);

        vb1.getChildren().addAll(label1, label2, top, gp, resultB, backB, imageView);
        vb1.setSpacing(10);

        bp.setCenter(vb1);

        resultB.setOnAction(a -> {

            /*
             * mange.addCustomer(nameTF.getText(), idTF.getText(), mobileTF.getText(),
             * addressTF.getText(), planTF.getText());
             *
             * System.out.println(mange.customers); try {
             *
             * if (outputFile.createNewFile()) { System.out.println("File created: " +
             * outputFile.getName()); } else { System.out.println("File already exists."); }
             * FileWriter myWriter = new FileWriter("out.txt"); for (int i = 0; i <
             * mange.customers.size(); i++) {
             * myWriter.write(mange.customers.get(i).toString() + "\n"); } myWriter.close();
             * } catch (IOException e) { System.out.println("An error occurred.");
             * e.printStackTrace(); }
             */
        });

        backB.setOnAction(b -> {
            try {
                listWBS(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);

    }

    private void meanStudentWBS(Stage stage) throws Exception {

        BorderPane bp = new BorderPane();
        VBox vb1 = new VBox();

        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);

        Label label2 = new Label("Mean Student In WestBank ( Science )");
        label2.setFont(new Font("Mean Student In WestBank ( Science )", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(300);

        Label mean = new Label("Mean Student Science : ");
        mean.setFont(new Font(15));
        mean.setPrefWidth(200);
        mean.setTranslateY(80);
        mean.setTranslateX(170);

        GridPane gp = new GridPane();
        gp.setVgap(10);
        TextField meanTF = new TextField();
        meanTF.setPromptText("  Mean Student ");
        meanTF.setTranslateX(330);
        meanTF.setTranslateY(18);
        meanTF.setPrefWidth(150);
        meanTF.setDisable(true);
        gp.add(meanTF, 3, 3);

        ImageView resultIm = new ImageView("https://cdn-icons-png.flaticon.com/512/1162/1162914.png");
        resultIm.setFitWidth(30);
        resultIm.setFitHeight(30);
        Button resultB = new Button("Result", resultIm);
        resultB.setTranslateX(300);
        resultB.setTranslateY(85);
        resultB.setPrefSize(150, 30);
        resultB.setStyle("-fx-border-color:purple");

        ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
        backIm.setFitWidth(30);
        backIm.setFitHeight(30);
        Button backB = new Button("Back", backIm);
        backB.setTranslateX(490);
        backB.setTranslateY(35);
        backB.setPrefSize(150, 30);
        backB.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(55);

        vb1.getChildren().addAll(label1, label2, mean, gp, resultB, backB, imageView);
        vb1.setSpacing(10);

        bp.setCenter(vb1);

        resultB.setOnAction(a -> {

            /*
             * mange.addCustomer(nameTF.getText(), idTF.getText(), mobileTF.getText(),
             * addressTF.getText(), planTF.getText());
             *
             * System.out.println(mange.customers); try {
             *
             * if (outputFile.createNewFile()) { System.out.println("File created: " +
             * outputFile.getName()); } else { System.out.println("File already exists."); }
             * FileWriter myWriter = new FileWriter("out.txt"); for (int i = 0; i <
             * mange.customers.size(); i++) {
             * myWriter.write(mange.customers.get(i).toString() + "\n"); } myWriter.close();
             * } catch (IOException e) { System.out.println("An error occurred.");
             * e.printStackTrace(); }
             */
        });

        backB.setOnAction(b -> {
            try {
                listWBS(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);

    }

    private void modeAStudentWBS(Stage stage) throws Exception {

        BorderPane bp = new BorderPane();
        VBox vb1 = new VBox();

        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);

        Label label2 = new Label("Mode Average Student In WestBank ( Science )");
        label2.setFont(new Font("Mode Average Student In WestBank ( Science )", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(300);

        Label mode = new Label("Mode Average Student Science : ");
        mode.setFont(new Font(15));
        mode.setPrefWidth(300);
        mode.setTranslateY(80);
        mode.setTranslateX(170);

        GridPane gp = new GridPane();
        gp.setVgap(10);
        TextField modeTF = new TextField();
        modeTF.setPromptText("  Mode Average ");
        modeTF.setTranslateX(390);
        modeTF.setTranslateY(18);
        modeTF.setPrefWidth(150);
        modeTF.setDisable(true);
        gp.add(modeTF, 3, 3);

        ImageView resultIm = new ImageView("https://cdn-icons-png.flaticon.com/512/1162/1162914.png");
        resultIm.setFitWidth(30);
        resultIm.setFitHeight(30);
        Button resultB = new Button("Result", resultIm);
        resultB.setTranslateX(300);
        resultB.setTranslateY(85);
        resultB.setPrefSize(150, 30);
        resultB.setStyle("-fx-border-color:purple");

        ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
        backIm.setFitWidth(30);
        backIm.setFitHeight(30);
        Button backB = new Button("Back", backIm);
        backB.setTranslateX(490);
        backB.setTranslateY(35);
        backB.setPrefSize(150, 30);
        backB.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(55);

        vb1.getChildren().addAll(label1, label2, mode, gp, resultB, backB, imageView);
        vb1.setSpacing(10);

        bp.setCenter(vb1);

        resultB.setOnAction(a -> {

            /*
             * mange.addCustomer(nameTF.getText(), idTF.getText(), mobileTF.getText(),
             * addressTF.getText(), planTF.getText());
             *
             * System.out.println(mange.customers); try {
             *
             * if (outputFile.createNewFile()) { System.out.println("File created: " +
             * outputFile.getName()); } else { System.out.println("File already exists."); }
             * FileWriter myWriter = new FileWriter("out.txt"); for (int i = 0; i <
             * mange.customers.size(); i++) {
             * myWriter.write(mange.customers.get(i).toString() + "\n"); } myWriter.close();
             * } catch (IOException e) { System.out.println("An error occurred.");
             * e.printStackTrace(); }
             */
        });

        backB.setOnAction(b -> {
            try {
                listWBS(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);

    }

    private void returnNPStudentWBS(Stage stage) throws Exception {

        BorderPane bp = new BorderPane();
        VBox vb1 = new VBox();

        Label label1 = new Label("High school results (Tawjihi 2022)");
        label1.setFont(new Font(" High school results (Tawjihi 2022)", 30));
        label1.setPrefWidth(500);
        label1.setTranslateY(60);
        label1.setTranslateX(255);

        Label label2 = new Label("Return Student In WestBank ( Science )");
        label2.setFont(new Font("Return Student In WestBank ( Science )", 20));
        label2.setPrefWidth(500);
        label2.setTranslateY(80);
        label2.setTranslateX(300);

        Label average = new Label(" Average : ");
        average.setFont(new Font(15));
        average.setPrefWidth(200);
        average.setTranslateY(80);
        average.setTranslateX(170);

        Label result = new Label(" Result : ");
        result.setFont(new Font(15));
        result.setPrefWidth(200);
        result.setTranslateY(80);
        result.setTranslateX(170);

        GridPane gp = new GridPane();
        gp.setVgap(10);
        TextField numTF = new TextField();
        numTF.setPromptText(" Average ");
        numTF.setTranslateX(330);
        numTF.setTranslateY(-13);
        numTF.setPrefWidth(150);
        gp.add(numTF, 3, 3);

        Label result2 = new Label();
        result2.setFont(new Font(15));
        result2.setPrefWidth(200);
        result2.setPrefHeight(5);
        result2.setTranslateY(-10);
        result2.setTranslateX(330);
        gp.add(result2, 3, 4);
        result2.setStyle("-fx-background-color: Thistle; -fx-padding: 20px;");

        ImageView returnIm = new ImageView("https://cdn-icons-png.flaticon.com/512/1585/1585197.png");
        returnIm.setFitWidth(30);
        returnIm.setFitHeight(30);
        Button returnB = new Button("Return", returnIm);
        returnB.setTranslateX(300);
        returnB.setTranslateY(5);
        returnB.setPrefSize(150, 30);
        returnB.setStyle("-fx-border-color:purple");

        ImageView backIm = new ImageView("https://img.icons8.com/fluency/344/circled-left-2.png");
        backIm.setFitWidth(30);
        backIm.setFitHeight(30);
        Button backB = new Button("Back", backIm);
        backB.setTranslateX(490);
        backB.setTranslateY(-45);
        backB.setPrefSize(150, 30);
        backB.setStyle("-fx-border-color:purple");

        Image image = new Image("C:\\Users\\Admin\\Desktop\\Data Strctur\\project_1\\Capture.PNG");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setFitWidth(1000);
        imageView.setFitHeight(250);
        imageView.setTranslateY(-45);

        vb1.getChildren().addAll(label1, label2, average, result, gp, returnB, backB, imageView);
        vb1.setSpacing(10);

        bp.setCenter(vb1);

        returnB.setOnAction(a -> {

            /*
             * mange.addCustomer(nameTF.getText(), idTF.getText(), mobileTF.getText(),
             * addressTF.getText(), planTF.getText());
             *
             * System.out.println(mange.customers); try {
             *
             * if (outputFile.createNewFile()) { System.out.println("File created: " +
             * outputFile.getName()); } else { System.out.println("File already exists."); }
             * FileWriter myWriter = new FileWriter("out.txt"); for (int i = 0; i <
             * mange.customers.size(); i++) {
             * myWriter.write(mange.customers.get(i).toString() + "\n"); } myWriter.close();
             * } catch (IOException e) { System.out.println("An error occurred.");
             * e.printStackTrace(); }
             */
        });

        backB.setOnAction(b -> {
            try {
                listWBS(stage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Scene scene = new Scene(bp, 1000, 600);
        stage.setScene(scene);

    }


}


