package steps;

import org.junit.Assert;

import pages.BookFlightsPage;

public class BookFlightsPageSteps extends Steps{

    public void initBrowser(){
        super.init();
    }

    public void searchDestination(String originLocation, String destinationLocation, String departureDate, String returnDate){
        BookFlightsPage bookFlightsPage = new BookFlightsPage(driver);
        bookFlightsPage.open();
        bookFlightsPage.searchDestination(originLocation, destinationLocation, departureDate, returnDate);
    }

    public void isOnDestinationPage(){
        Assert.assertTrue("title should contain Авиакомпания 'Белавиа' - Выбор",
                driver.getTitle().contains("Авиакомпания 'Белавиа' - Выбор"));
    }
    
    public void openOnAirPage(){
        BookFlightsPage bookFlightsPage = new BookFlightsPage(driver);
        bookFlightsPage.open();
        bookFlightsPage.openOnAirPage();
    }

    public void isOnOnAirPage(){
        Assert.assertTrue("title should contain OnAir - бортовой журнал авиакомпании «Белавиа» - БЕЛАВИА - Авиакомпания Республики Беларусь",
                driver.getTitle().contains("OnAir - бортовой журнал авиакомпании «Белавиа» - БЕЛАВИА - Авиакомпания Республики Беларусь"));
    }

}
