package org.qa.light.session6.homeWork;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.qa.light.session6.homeWork.hw_main.createBoat;

//TODO: each boat has one or more owners -> check this with assert
//TODO: each owner must be unique
//TODO*: print boat names for boats with only one owner
//TODO**: generate boats and owners and boat / owners params automatically and randomly -> make this test params
public class HomeWorkTest {

    @DataProvider
    public Object[][] newBoats() {
        return new Object[][]{
                {createBoat()},
                {createBoat()},
        };
    }

    @Test
    public void checkBoatHasAtLeastOneOwner() {

        newBoat testBoat = createBoat();

        Assert.assertNotNull(testBoat.owners, "Owners list is NULL :(((");
        Assert.assertFalse(testBoat.owners.isEmpty(), "Owners list is empty :(((");
    }

    @Test(dataProvider = "newBoats")
    public void checkBoatCreationWithParams(newBoat boat) {

        Assert.assertFalse(boat == null, "Boat is not created");
        Assert.assertFalse(boat.name == null, "Boat name is not created");
        Assert.assertFalse(boat.owners == null, "Boat name is not created");
    }

}
