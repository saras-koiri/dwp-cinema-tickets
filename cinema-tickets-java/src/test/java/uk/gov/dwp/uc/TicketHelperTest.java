package uk.gov.dwp.uc;

import org.junit.Test;
import uk.gov.dwp.uc.pairtest.domain.TicketHelper;
import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TicketHelperTest {


    @Test
    public void givenTicketRequestFor1AdultAnd1Child_thenCalculateTicketPrice(){

        List<TicketTypeRequest> tickets = new ArrayList<>();
        TicketTypeRequest adultTicket = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 1);
        TicketTypeRequest childTicket = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 1);

        tickets.add(adultTicket);
        tickets.add(childTicket);

        int calculatedPrice = TicketHelper.calculateTicketPrice(tickets.toArray(new TicketTypeRequest[0]));

        assertEquals(40, calculatedPrice);

    }

    @Test
    public void givenTicketRequestFor2AdultAnd1Child_thenCalculateTicketPrice(){

        List<TicketTypeRequest> tickets = new ArrayList<>();
        TicketTypeRequest adultTicket = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 2);
        TicketTypeRequest childTicket = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 1);

        tickets.add(adultTicket);
        tickets.add(childTicket);

        int calculatedPrice = TicketHelper.calculateTicketPrice(tickets.toArray(new TicketTypeRequest[0]));

        assertEquals(65, calculatedPrice);

    }

    @Test
    public void givenTicketRequestFor1AdultAnd1ChildAnd1Infant_thenCalculateTicketPrice(){

        List<TicketTypeRequest> tickets = new ArrayList<>();
        TicketTypeRequest adultTicket = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 1);
        TicketTypeRequest childTicket = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 1);
        TicketTypeRequest infantTicket = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 1);

        tickets.add(adultTicket);
        tickets.add(childTicket);
        tickets.add(infantTicket);

        int calculatedPrice = TicketHelper.calculateTicketPrice(tickets.toArray(new TicketTypeRequest[0]));

        assertEquals(40, calculatedPrice);

    }

    @Test
    public void givenTicketRequestFor10AdultAnd10ChildAnd10Infant_thenCalculateTicketPrice(){

        List<TicketTypeRequest> tickets = new ArrayList<>();
        TicketTypeRequest adultTicket = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 10);
        TicketTypeRequest childTicket = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 10);
        TicketTypeRequest infantTicket = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 10);

        tickets.add(adultTicket);
        tickets.add(childTicket);
        tickets.add(infantTicket);

        int calculatedPrice = TicketHelper.calculateTicketPrice(tickets.toArray(new TicketTypeRequest[0]));

        assertEquals(400, calculatedPrice);

    }


    @Test
    public void givenTicketRequestFor10AdultAnd10Child_thenCalculateNumberOfTickets(){

        List<TicketTypeRequest> tickets = new ArrayList<>();
        TicketTypeRequest adultTicket = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 10);
        TicketTypeRequest childTicket = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 10);

        tickets.add(adultTicket);
        tickets.add(childTicket);

        int numberOfTickets = TicketHelper.calculateTotalNumberOfTickets(tickets.toArray(new TicketTypeRequest[0]));

        assertEquals(20, numberOfTickets);

    }

    @Test
    public void givenTicketRequestFor10AdultAnd10ChildAnd10Infant_thenCalculateNumberOfTickets(){

        List<TicketTypeRequest> tickets = new ArrayList<>();
        TicketTypeRequest adultTicket = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 10);
        TicketTypeRequest childTicket = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 10);
        TicketTypeRequest infantTicket = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 10);

        tickets.add(adultTicket);
        tickets.add(childTicket);
        tickets.add(infantTicket);

        int numberOfTickets = TicketHelper.calculateTotalNumberOfTickets(tickets.toArray(new TicketTypeRequest[0]));

        assertEquals(30, numberOfTickets);

    }

    @Test
    public void givenTicketRequestFor10AdultAnd10ChildAnd10InfantSeparateRequests_thenCalculateNumberOfTickets(){

        List<TicketTypeRequest> tickets = new ArrayList<>();

        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 1));

        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 1));

        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 1));
        tickets.add(new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 1));


        int numberOfTickets = TicketHelper.calculateTotalNumberOfTickets(tickets.toArray(new TicketTypeRequest[0]));

        assertEquals(30, numberOfTickets);

    }

    @Test
    public void givenTicketRequestFor10ChildAnd10Infant_thenVerifyThereIsNoAdultTicket(){

        List<TicketTypeRequest> tickets = new ArrayList<>();

        TicketTypeRequest childTicket = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 10);
        TicketTypeRequest infantTicket = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 10);

        tickets.add(childTicket);
        tickets.add(infantTicket);

        boolean containsAdultTicket = TicketHelper.containsAdultTicket(tickets.toArray(new TicketTypeRequest[0]));

        assertEquals(false, containsAdultTicket);

    }

    @Test
    public void givenTicketRequestFor1Adult10ChildAnd10Infant_thenVerifyThereIsAdultTicket(){

        List<TicketTypeRequest> tickets = new ArrayList<>();


        TicketTypeRequest adultTicket = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 10);
        TicketTypeRequest childTicket = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 10);
        TicketTypeRequest infantTicket = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 10);

        tickets.add(adultTicket);
        tickets.add(childTicket);
        tickets.add(infantTicket);

        boolean containsAdultTicket = TicketHelper.containsAdultTicket(tickets.toArray(new TicketTypeRequest[0]));

        assertEquals(true, containsAdultTicket);

    }

    @Test
    public void givenTicketRequestFor1Adult4ChildAnd1Infant_thenCalculateNumberOfSeatsToReserve(){

        List<TicketTypeRequest> tickets = new ArrayList<>();

        TicketTypeRequest adultTicket = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 1);
        TicketTypeRequest childTicket = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 4);
        TicketTypeRequest infantTicket = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 1);

        tickets.add(adultTicket);
        tickets.add(childTicket);
        tickets.add(infantTicket);

        int numberOfSeatsToReserve = TicketHelper.calculateNumberOfSeatsToReserve(tickets.toArray(new TicketTypeRequest[0]));

        assertEquals(5, numberOfSeatsToReserve);

    }

    @Test
    public void givenTicketRequestFor10Adult4ChildAnd0Infant_thenCalculateNumberOfSeatsToReserve(){

        List<TicketTypeRequest> tickets = new ArrayList<>();

        TicketTypeRequest adultTicket = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 10);
        TicketTypeRequest childTicket = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 4);
        TicketTypeRequest infantTicket = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 0);

        tickets.add(adultTicket);
        tickets.add(childTicket);
        tickets.add(infantTicket);

        int numberOfSeatsToReserve = TicketHelper.calculateNumberOfSeatsToReserve(tickets.toArray(new TicketTypeRequest[0]));

        assertEquals(14, numberOfSeatsToReserve);

    }

    @Test
    public void givenTicketRequestForZeroAdult4ChildAnd0Infant_thenCalculateNumberOfSeatsToReserve(){

        List<TicketTypeRequest> tickets = new ArrayList<>();

        TicketTypeRequest adultTicket = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 0);
        TicketTypeRequest childTicket = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 4);
        TicketTypeRequest infantTicket = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 0);

        tickets.add(adultTicket);
        tickets.add(childTicket);
        tickets.add(infantTicket);

        int numberOfSeatsToReserve = TicketHelper.calculateNumberOfSeatsToReserve(tickets.toArray(new TicketTypeRequest[0]));

        assertEquals(4, numberOfSeatsToReserve);

    }

    @Test
    public void givenTicketRequestFor4Child_thenCalculateNumberOfSeatsToReserve(){

        List<TicketTypeRequest> tickets = new ArrayList<>();

        TicketTypeRequest childTicket = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 4);
        tickets.add(childTicket);

        int numberOfSeatsToReserve = TicketHelper.calculateNumberOfSeatsToReserve(tickets.toArray(new TicketTypeRequest[0]));

        assertEquals(4, numberOfSeatsToReserve);

    }

    @Test
    public void givenTicketRequestFor2Adult4Child_thenCalculateNumberOfSeatsToReserve(){

        List<TicketTypeRequest> tickets = new ArrayList<>();

        TicketTypeRequest adultTicket = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 2);
        TicketTypeRequest childTicket = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 4);

        tickets.add(adultTicket);
        tickets.add(childTicket);

        int numberOfSeatsToReserve = TicketHelper.calculateNumberOfSeatsToReserve(tickets.toArray(new TicketTypeRequest[0]));

        assertEquals(6, numberOfSeatsToReserve);

    }

}


