package dmv;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public class DmvSystem extends Application {
    static ArrayList<Citizen> citizens = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        getCitizensData(stage);
        getLicensesData(stage);
        if (stage.isShowing())
            return;
        showLogInScene(stage);
    }

    private void showLogInScene(Stage stage) {
        LogInScene logInScene = new LogInScene();
        stage.setHeight(170);
        stage.setWidth(400);
        stage.setResizable(false);
        stage.setScene(logInScene.scene);
        stage.show();

        logInScene.logInButton.setOnAction(_ -> {
            String firstAdminName = "Patrick";
            String firstAdminPassword = "2406232";
            String secondAdminName = "Youssef";
            String secondAdminPassword = "2406241";
            String thirdAdminName = "Ahmed";
            String thirdAdminPassword = "2406238";

            String name = logInScene.nameTextField.getText();
            String password = logInScene.passwordTextField.getText();

            if (((name.equals(firstAdminName) && password.equals(firstAdminPassword)) ||
                    (secondAdminName.equals(name) && secondAdminPassword.equals(password))) ||
                    (thirdAdminName.equals(name) && thirdAdminPassword.equals(password))) {
                showDmvSystem(stage);
            } else {
                Alert alert = new Alert();
                stage.close();
                stage.setHeight(150);
                stage.setWidth(400);
                stage.setResizable(false);
                stage.setScene(alert.scene);
                stage.show();
                alert.detailsLabel.setText("Invalid Name or Password");
                alert.okButton.setOnAction(_ -> {
                    stage.close();
                    showLogInScene(stage);
                });
            }
        });
    }

    private void showDmvSystem(Stage stage) {
        DmvSystemScene dmvSystemScene = new DmvSystemScene();
        stage.close();
        stage.setHeight(200);
        stage.setWidth(400);
        stage.setResizable(false);
        stage.setScene(dmvSystemScene.scene);
        stage.show();

        dmvSystemScene.nextButton.setOnAction(_ -> {
            if (dmvSystemScene.addCitizenToggleButton.isSelected())
                showAddCitizenScene(stage);
            if (dmvSystemScene.creatLicenseToggleButton.isSelected())
                if (!citizens.isEmpty())
                    showCreateLicenseScene(stage);
                else {
                    Alert alert = new Alert();
                    alert.detailsLabel.setText("There Is No Citizens");
                    stage.close();
                    stage.setHeight(150);
                    stage.setWidth(400);
                    stage.setResizable(false);
                    stage.setScene(alert.scene);
                    stage.show();
                    alert.okButton.setOnAction(_ -> showDmvSystem(stage));
                }
            if (dmvSystemScene.citizenToggleButton.isSelected())
                if (!citizens.isEmpty())
                    showFindCitizenScene(stage);
                else {
                    Alert alert = new Alert();
                    alert.detailsLabel.setText("There Is No Citizens");
                    stage.close();
                    stage.setHeight(150);
                    stage.setWidth(400);
                    stage.setResizable(false);
                    stage.setScene(alert.scene);
                    stage.show();
                    alert.okButton.setOnAction(_ -> showDmvSystem(stage));
                }
            if (dmvSystemScene.licenseToggleButton.isSelected())
                if (!citizens.isEmpty())
                    showFindLicenseScene(stage);
                else {
                    Alert alert = new Alert();
                    alert.detailsLabel.setText("There Is No Licenses");
                    stage.close();
                    stage.setHeight(150);
                    stage.setWidth(400);
                    stage.setResizable(false);
                    stage.setScene(alert.scene);
                    stage.show();
                    alert.okButton.setOnAction(_ -> showDmvSystem(stage));
                }
        });

        dmvSystemScene.logOutButton.setOnAction(_ -> {
            stage.close();
            showLogInScene(stage);
        });

        dmvSystemScene.shutDownButton.setOnAction(_ -> Platform.exit());
    }

    private void showAddCitizenScene(Stage stage) {
        AddCitizenScene addCitizenScene = new AddCitizenScene();
        stage.close();
        stage.setHeight(500);
        stage.setWidth(750);
        stage.setResizable(false);
        stage.setScene(addCitizenScene.scene);
        stage.show();

        addCitizenScene.submitButton.setOnAction(_ -> {
            int nationalId;
            try {
                nationalId = Integer.parseInt(addCitizenScene.nationalIdTextField.getText());
            } catch (Exception e) {
                Alert alert = new Alert();
                alert.detailsLabel.setText("Invalid National ID Please Try Again");
                stage.close();
                stage.setHeight(200);
                stage.setWidth(500);
                stage.setResizable(false);
                stage.setScene(alert.scene);
                stage.show();
                alert.okButton.setOnAction(_ -> showAddCitizenScene(stage));
                return;
            }
            String fullName = addCitizenScene.fullNameTextField.getText();
            if (!citizenFound(nationalId)) {
                int houseNo;
                try {
                    houseNo = Integer.parseInt(addCitizenScene.houseNoTextField.getText());
                } catch (Exception e) {
                    Alert alert = new Alert();
                    alert.detailsLabel.setText("Invalid House Number Please Try Again");
                    stage.close();
                    stage.setHeight(200);
                    stage.setWidth(500);
                    stage.setResizable(false);
                    stage.setScene(alert.scene);
                    stage.show();
                    alert.okButton.setOnAction(_ -> showAddCitizenScene(stage));
                    return;
                }
                String street = addCitizenScene.streetTextField.getText();
                String governorate = addCitizenScene.governorateTextField.getText();
                String country = addCitizenScene.countryTextField.getText();
                LocalDate date;
                try {
                    date = addCitizenScene.dateOfBirthDatePicker.getValue();
                } catch (Exception e) {
                    Alert alert = new Alert();
                    alert.detailsLabel.setText("Invalid Date Please Try Again");
                    stage.close();
                    stage.setHeight(200);
                    stage.setWidth(500);
                    stage.setResizable(false);
                    stage.setScene(alert.scene);
                    stage.show();
                    alert.okButton.setOnAction(_ -> showAddCitizenScene(stage));
                    return;
                }
                if (date == null) {
                    Alert alert = new Alert();
                    alert.detailsLabel.setText("Invalid Date Please Try Again");
                    stage.close();
                    stage.setHeight(200);
                    stage.setWidth(500);
                    stage.setResizable(false);
                    stage.setScene(alert.scene);
                    stage.show();
                    alert.okButton.setOnAction(_ -> showAddCitizenScene(stage));
                    return;
                }
                Gender gender;
                MaritalStatus maritalStatus;
                Religion religion;
                if (addCitizenScene.maleToggleButton.isSelected())
                    gender = Gender.MALE;
                else if (addCitizenScene.femaleToggleButton.isSelected())
                    gender = Gender.FEMALE;
                else {
                    Alert alert = new Alert();
                    alert.detailsLabel.setText("Invalid Gender Please Select One");
                    stage.close();
                    stage.setHeight(200);
                    stage.setWidth(500);
                    stage.setResizable(false);
                    stage.setScene(alert.scene);
                    stage.show();
                    alert.okButton.setOnAction(_ -> showAddCitizenScene(stage));
                    return;
                }
                if (addCitizenScene.singleToggleButton.isSelected())
                    maritalStatus = MaritalStatus.SINGLE;
                else if (addCitizenScene.marriedToggleButton.isSelected())
                    maritalStatus = MaritalStatus.MARRIED;
                else if (addCitizenScene.divorcedToggleButton.isSelected())
                    maritalStatus = MaritalStatus.DIVORCED;
                else if (addCitizenScene.widowedToggleButton.isSelected())
                    maritalStatus = MaritalStatus.WIDOWED;
                else {
                    Alert alert = new Alert();
                    alert.detailsLabel.setText("Invalid Marital Status Please Select One");
                    stage.close();
                    stage.setHeight(200);
                    stage.setWidth(500);
                    stage.setResizable(false);
                    stage.setScene(alert.scene);
                    stage.show();
                    alert.okButton.setOnAction(_ -> showAddCitizenScene(stage));
                    return;
                }
                if (addCitizenScene.christianToggleButton.isSelected())
                    religion = Religion.CHRISTIAN;
                else if (addCitizenScene.muslimToggleButton.isSelected())
                    religion = Religion.MUSLIM;
                else {
                    Alert alert = new Alert();
                    alert.detailsLabel.setText("Invalid Religion Please Select One");
                    stage.close();
                    stage.setHeight(200);
                    stage.setWidth(500);
                    stage.setResizable(false);
                    stage.setScene(alert.scene);
                    stage.show();
                    alert.okButton.setOnAction(_ -> showAddCitizenScene(stage));
                    return;
                }

                addCitizenData(fullName, nationalId, houseNo, street, governorate, country, date.toString(), String.valueOf(gender), String.valueOf(maritalStatus), String.valueOf(religion), stage);

                citizens.add(new Citizen(fullName, nationalId, houseNo, street, governorate, country, date, gender, maritalStatus, religion));
                showDmvSystem(stage);
            } else {
                Alert alert = new Alert();
                alert.detailsLabel.setText("This Citizen Already Exist");
                stage.close();
                stage.setHeight(150);
                stage.setWidth(400);
                stage.setResizable(false);
                stage.setScene(alert.scene);
                stage.show();
                alert.okButton.setOnAction(_ -> showAddCitizenScene(stage));
            }
        });
        addCitizenScene.backButton.setOnAction(_ -> showDmvSystem(stage));
    }

    private void showFindCitizenScene(Stage stage) {
        FindScene findCitizenScene = new FindScene();
        stage.close();
        stage.setHeight(175);
        stage.setWidth(450);
        stage.setResizable(false);
        stage.setScene(findCitizenScene.scene);
        stage.show();
        findCitizenScene.okButton.setOnAction(_ -> {
            int nationalId;
            try {
                nationalId = Integer.parseInt(findCitizenScene.nationalIdTextField.getText());
            } catch (Exception e) {
                Alert alert = new Alert();
                alert.detailsLabel.setText("Invalid National ID Please Try Again");
                stage.close();
                stage.setHeight(200);
                stage.setWidth(500);
                stage.setResizable(false);
                stage.setScene(alert.scene);
                stage.show();
                alert.okButton.setOnAction(_ -> showFindCitizenScene(stage));
                return;
            }
            if (citizenFound(nationalId)) {
                int index = citizenIndex(nationalId);
                Citizen citizen = citizens.get(index);
                showCitizenScene(stage, citizen);
            } else {
                Alert alert = new Alert();
                alert.detailsLabel.setText("This Citizen Not Found");
                stage.close();
                stage.setHeight(200);
                stage.setWidth(500);
                stage.setResizable(false);
                stage.setScene(alert.scene);
                stage.show();
                alert.okButton.setOnAction(_ -> showFindCitizenScene(stage));
            }
        });
        findCitizenScene.backButton.setOnAction(_ -> showDmvSystem(stage));
    }

    private void showCitizenScene(Stage stage, Citizen citizen) {
        CitizenScene citizenScene = new CitizenScene();
        stage.close();
        stage.setHeight(400);
        stage.setWidth(700);
        stage.setResizable(false);
        stage.setScene(citizenScene.scene);
        stage.show();
        String fullName = citizen.getFullName();
        long nationalId = citizen.getNationalID();
        String address = citizen.getAddress().getAddress();
        String birthDate = String.valueOf(citizen.getBirthDate());
        String gender = String.valueOf(citizen.getGender());
        String maritalStatus = String.valueOf(citizen.getMaritalStatus());
        String religion = String.valueOf(citizen.getReligion());
        citizenScene.fullNameValueLabel.setText(fullName);
        citizenScene.nationalIdValueLabel.setText(String.valueOf(nationalId));
        citizenScene.addresstLabelValueLabel.setText(address);
        citizenScene.birthDateValueLabel.setText(birthDate);
        citizenScene.genderValueLabel.setText(gender);
        citizenScene.maritalStatusValueLabel.setText(maritalStatus);
        citizenScene.religionValueLabel.setText(religion);
        citizenScene.removeButton.setOnAction(_ -> {
            removeCitizenData(citizen.getNationalID(), stage);
            citizens.remove(citizen);
            showDmvSystem(stage);
        });
        citizenScene.okButton.setOnAction(_ -> showDmvSystem(stage));

    }

    private void showCreateLicenseScene(Stage stage) {
        CreateLicenseScene createLicenseScene = new CreateLicenseScene();
        stage.close();
        stage.setHeight(350);
        stage.setWidth(600);
        stage.setResizable(false);
        stage.setScene(createLicenseScene.scene);
        stage.show();

        createLicenseScene.createButton.setOnAction(_ -> {
            int nationalId;
            try {
                nationalId = Integer.parseInt(createLicenseScene.nationalIdTextField.getText());
            } catch (Exception e) {
                Alert alert = new Alert();
                alert.detailsLabel.setText("Invalid National ID Please Try Again");
                stage.close();
                stage.setHeight(200);
                stage.setWidth(500);
                stage.setResizable(false);
                stage.setScene(alert.scene);
                stage.show();
                alert.okButton.setOnAction(_ -> showCreateLicenseScene(stage));
                return;
            }
            if (citizenFound(nationalId)) {
                LicenseClass classType;
                Restriction rest;

                if (createLicenseScene.aToggleButton.isSelected())
                    classType = LicenseClass.A;
                else if (createLicenseScene.bToggleButton.isSelected())
                    classType = LicenseClass.B;
                else if (createLicenseScene.cToggleButton.isSelected())
                    classType = LicenseClass.C;
                else if (createLicenseScene.dToggleButton.isSelected())
                    classType = LicenseClass.D;
                else if (createLicenseScene.eToggleButton.isSelected())
                    classType = LicenseClass.E;
                else if (createLicenseScene.fToggleButton.isSelected())
                    classType = LicenseClass.F;
                else {
                    Alert alert = new Alert();
                    alert.detailsLabel.setText("Invalid Class Please Select One");
                    stage.close();
                    stage.setHeight(200);
                    stage.setWidth(500);
                    stage.setResizable(false);
                    stage.setScene(alert.scene);
                    stage.show();
                    alert.okButton.setOnAction(_ -> showCreateLicenseScene(stage));
                    return;
                }


                if (createLicenseScene.noneToggleButton.isSelected())
                    rest = Restriction.NONE;
                else if (createLicenseScene.visionToggleButton.isSelected())
                    rest = Restriction.VISION;
                else if (createLicenseScene.nightToggleButton.isSelected())
                    rest = Restriction.NIGHT_DRIVING;
                else if (createLicenseScene.areaToggleButton.isSelected())
                    rest = Restriction.AREA;
                else if (createLicenseScene.ageToggleButton.isSelected())
                    rest = Restriction.AGE_LIMITATION;
                else if (createLicenseScene.medicalToggleButton.isSelected())
                    rest = Restriction.MEDICAL_REASSESSMENT;
                else {
                    Alert alert = new Alert();
                    alert.detailsLabel.setText("Invalid Restriction Please Select One");
                    stage.close();
                    stage.setHeight(200);
                    stage.setWidth(500);
                    stage.setResizable(false);
                    stage.setScene(alert.scene);
                    stage.show();
                    alert.okButton.setOnAction(_ -> showCreateLicenseScene(stage));
                    return;
                }

                Citizen citizen = citizens.get(citizenIndex(nationalId));
                citizen.addLicense(classType, rest);
                License license = citizen.getLicenses().getLast();
                addLicenseData(license.getFullName(), citizen.getNationalID(), license.getLicenseNo(), license.getBirthDate().toString(), license.getIssueDate().toString(), license.getExpiryDate().toString(), license.getLicenseStatus().toString(), license.getClassType().toString(), license.getRestrictions().toString(), stage);
                showDmvSystem(stage);
            } else {
                Alert alert = new Alert();
                stage.close();
                alert.detailsLabel.setText("This Citizen Not Found");
                stage.setHeight(150);
                stage.setWidth(400);
                stage.setResizable(false);
                stage.setScene(alert.scene);
                stage.show();
                alert.okButton.setOnAction(_ -> showCreateLicenseScene(stage));
            }
        });
        createLicenseScene.backButton.setOnAction(_ -> showDmvSystem(stage));
    }

    private void showFindLicenseScene(Stage stage) {
        FindScene findLicenseScene = new FindScene();
        stage.close();
        stage.setHeight(175);
        stage.setWidth(450);
        stage.setResizable(false);
        stage.setScene(findLicenseScene.scene);
        stage.show();
        findLicenseScene.okButton.setOnAction(_ -> {

            int nationalId;
            try {
                nationalId = Integer.parseInt(findLicenseScene.nationalIdTextField.getText());
            } catch (Exception e) {
                Alert alert = new Alert();
                alert.detailsLabel.setText("Invalid National ID Please Try Again");
                stage.close();
                stage.setHeight(200);
                stage.setWidth(500);
                stage.setResizable(false);
                stage.setScene(alert.scene);
                stage.show();
                alert.okButton.setOnAction(_ -> showFindLicenseScene(stage));
                return;
            }
            if (citizenFound(nationalId)) {
                int index = citizenIndex(nationalId);
                Citizen citizen = citizens.get(index);
                ArrayList<License> license = citizen.licenses;
                if (!license.isEmpty()) {
                    showDmvSystem(stage);
                    for (License lic : license) {
                        showLicenseScene(new Stage(), citizen, lic);
                    }
                } else {
                    Alert alert = new Alert();
                    alert.detailsLabel.setText("License Not Found");
                    stage.close();
                    stage.setHeight(150);
                    stage.setWidth(400);
                    stage.setResizable(false);
                    stage.setScene(alert.scene);
                    stage.show();
                    alert.okButton.setOnAction(_ -> showFindLicenseScene(stage));
                }
            } else {
                Alert alert = new Alert();
                alert.detailsLabel.setText("This Citizen Not Found");
                stage.close();
                stage.setHeight(200);
                stage.setWidth(500);
                stage.setResizable(false);
                stage.setScene(alert.scene);
                stage.show();
                alert.okButton.setOnAction(_ -> showFindCitizenScene(stage));
            }
        });
        findLicenseScene.backButton.setOnAction(_ -> showDmvSystem(stage));
    }

    private void showLicenseScene(Stage stage, Citizen citizen, License license) {
        LicenseScene licenseScene = new LicenseScene();
        stage.close();
        stage.setHeight(450);
        stage.setWidth(650);
        stage.setResizable(false);
        stage.setScene(licenseScene.scene);
        stage.show();

        if (license.getExpiryDate().isBefore(LocalDate.now())) {
            license.setLicenseStatus(LicenseStatus.INACTIVE);
        }

        String fullName = license.getFullName();
        int licenseNo = license.getLicenseNo();
        String birthDate = String.valueOf(license.getBirthDate());
        String issueDate = String.valueOf(license.getIssueDate());
        String expiryDate = String.valueOf(license.getExpiryDate());
        String classType = String.valueOf(license.getClassType());
        String status = String.valueOf(license.getLicenseStatus());
        String rest = String.valueOf(license.getRestrictions());

        licenseScene.fullNameValueLabel.setText(fullName);
        licenseScene.licenseNoValueLabel.setText(String.valueOf(licenseNo));
        licenseScene.birthDateValueLabel.setText(birthDate);
        licenseScene.issueDateValueLabel.setText(issueDate);
        licenseScene.expiryDateValueLabel.setText(expiryDate);
        licenseScene.classValueLabel.setText(classType);
        licenseScene.licenseStatusValueLabel.setText(status);
        licenseScene.restValueLabel.setText(rest);

        licenseScene.removeButton.setOnAction(_ -> {
            removeLicenseData(licenseNo, stage);
            citizen.getLicenses().remove(license);
            stage.close();
        });
        licenseScene.renewButton.setOnAction(_ -> {
            license.renewalLic();
            stage.close();
        });
        licenseScene.okButton.setOnAction(_ -> stage.close());
    }


    private static boolean citizenFound(int nationalId) {
        boolean flag = false;
        for (Citizen c : citizens) {
            if (c.getNationalID() == nationalId) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private static int citizenIndex(int nationalId) {
        int index = 0;
        for (Citizen c : citizens) {
            if (c.getNationalID() == nationalId)
                index = citizens.indexOf(c);
        }
        return index;
    }

    private static void getCitizensData(Stage stage) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/data.db");
            Statement statement = connection.createStatement();
            statement.execute("select * from citizens;");
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {
                String fullName = resultSet.getString("fullName");
                int nationalId = resultSet.getInt("nationalId");
                int houseNo = resultSet.getInt("houseNo");
                String street = resultSet.getString("street");
                String governorate = resultSet.getString("governorate");
                String country = resultSet.getString("country");
                LocalDate birthDate = LocalDate.parse(resultSet.getString("birthDate"));
                Gender gender = Gender.valueOf(resultSet.getString("gender"));
                MaritalStatus maritalStatus = MaritalStatus.valueOf(resultSet.getString("maritalStatus"));
                Religion religion = Religion.valueOf(resultSet.getString(10));

                citizens.add(new Citizen(fullName, nationalId, houseNo, street
                        , governorate, country, birthDate, gender, maritalStatus, religion));
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            showDataBaseAlert(stage);
        }
    }

    private static void addCitizenData(String fullName, int nationalId, int houseNumber
            , String street, String governorate, String country, String birthDate
            , String gender, String maritalStatus, String religion, Stage stage) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/data.db");
            Statement statement = connection.createStatement();
            String code = "insert into citizens values ('" + fullName + "'," + nationalId + "," + houseNumber + ",'" +
                    street + "','" + governorate + "','" + country + "','" + birthDate + "','" + gender + "','" + maritalStatus + "','" + religion + "');";
            statement.execute(code);
            statement.close();
            connection.close();
        } catch (Exception e) {
            showDataBaseAlert(stage);
        }
    }

    private static void removeCitizenData(int nationalId, Stage stage) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/data.db");
            Statement statement = connection.createStatement();
            statement.execute("delete from citizens where nationalId = " + nationalId + ";");
            statement.close();
            connection.close();
        } catch (Exception e) {
            showDataBaseAlert(stage);
        }
    }

    private static void getLicensesData(Stage stage) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/data.db");
            Statement statement = connection.createStatement();
            statement.execute("select * from licenses;");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                String fullName = resultSet.getString("fullName");
                int nationalId = resultSet.getInt("nationalId");

                int index = citizenIndex(nationalId);
                int licenseNo = resultSet.getInt("licenseNo");
                LocalDate birthDate = LocalDate.parse(resultSet.getString("birthDate"));
                LocalDate issueDate = LocalDate.parse(resultSet.getString("issueDate"));
                LocalDate expiryDate = LocalDate.parse(resultSet.getString("expiryDate"));
                LicenseStatus status = LicenseStatus.valueOf(resultSet.getString("licenseStatus"));
                LicenseClass classType = LicenseClass.valueOf(resultSet.getString("classType"));
                Restriction restriction = Restriction.valueOf(resultSet.getString("restriction"));
                citizens.get(index).addLicense(licenseNo, fullName, birthDate, issueDate, expiryDate, status, classType, restriction);
            }
            statement.close();
            connection.close();
        } catch (Exception e) {
            showDataBaseAlert(stage);
        }
    }

    private static void addLicenseData(String fullName, int nationalId, int licenseNo, String birthDate, String issueDate, String expiryDate, String licenseStatus, String classType, String restriction, Stage stage) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/data.db");
            Statement statement = connection.createStatement();
            String code = "insert into licenses values ('" + fullName + "'," + nationalId + "," + licenseNo + ",'" + birthDate + "','" + issueDate + "','" +
                    expiryDate + "','" + licenseStatus + "','" + classType + "','" + restriction + "');";
            statement.execute(code);
            statement.close();
            connection.close();
        } catch (Exception e) {
            showDataBaseAlert(stage);
        }
    }

    private static void removeLicenseData(int licenseNo, Stage stage) {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/data.db");
            Statement statement = connection.createStatement();
            statement.execute("delete from licenses where licenseNo = " + licenseNo + ";");
            statement.close();
            connection.close();
        } catch (Exception e) {
            showDataBaseAlert(stage);
        }
    }

    private static void showDataBaseAlert(Stage stage) {
        Alert alert = new Alert();
        stage.close();
        alert.detailsLabel.setText("Something Went Wrong");
        stage.setHeight(150);
        stage.setWidth(400);
        stage.setResizable(false);
        stage.setScene(alert.scene);
        stage.show();
        alert.okButton.setOnAction(_ -> Platform.exit());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
