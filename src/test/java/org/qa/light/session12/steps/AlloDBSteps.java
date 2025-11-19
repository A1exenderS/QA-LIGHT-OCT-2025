package org.qa.light.session12.steps;

import io.cucumber.java.en.Then;
import org.qa.light.session12.HoveredCardItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AlloDBSteps {

    public static Connection conn;

    @Then("the system saves each hovered item into the Phones database table")
    public void storeItemsDataToDB(List<HoveredCardItem> hoveredCardItems) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement(
                "INSERT INTO Phones (DeviceName, DevicePrice, DeviceScreenSize) VALUES (?,?,?)"
        );

        for (HoveredCardItem hoveredCardItem : hoveredCardItems) {
            preparedStatement.setString(1, hoveredCardItem.getDeviceName());
            preparedStatement.setString(2, hoveredCardItem.getDevicePrice());
            preparedStatement.setString(3, hoveredCardItem.getDeviceScreenType());
            try {
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println("Failed to save in DB: " + hoveredCardItem);
            }
        }
    }
}
