package uk.gov.dwp.uc;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.rules.ExpectedException;
import uk.gov.dwp.uc.pairtest.TicketService;
import uk.gov.dwp.uc.pairtest.TicketServiceImpl;
import uk.gov.dwp.uc.pairtest.domain.TicketHelper;
import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;
import uk.gov.dwp.uc.pairtest.exception.InvalidPurchaseException;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class TicketServiceTest {

    private TicketService ticketService = new TicketServiceImpl();

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void givenTicketRequestFor1AdultAnd1Child_thenPurchaseTicketSuccessfully(){

        List<TicketTypeRequest> tickets = new ArrayList<>();
        TicketTypeRequest adultTicket = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 1);
        TicketTypeRequest childTicket = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 1);

        tickets.add(adultTicket);
        tickets.add(childTicket);

        TicketTypeRequest[] ticketTypeRequests = tickets.toArray(new TicketTypeRequest[0]);
        ticketService.purchaseTickets(1000L, ticketTypeRequests);

    }

    @Test
    public void givenTicketRequestFor1AdultAnd1Child1Infant_thenPurchaseTicketSuccessfully(){

        List<TicketTypeRequest> tickets = new ArrayList<>();
        TicketTypeRequest adultTicket = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 1);
        TicketTypeRequest childTicket = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 1);
        TicketTypeRequest infantTicket = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 1);

        tickets.add(adultTicket);
        tickets.add(childTicket);
        tickets.add(infantTicket);

        TicketTypeRequest[] ticketTypeRequests = tickets.toArray(new TicketTypeRequest[0]);
        ticketService.purchaseTickets(1000L, ticketTypeRequests);

    }


    @Test
    public void givenTicketRequestFor26Adults_whenTicketPurchased_thenExceptionShouldBeThrown(){

        int numberOfAdultTickets = 26;
        expectedEx.expect(InvalidPurchaseException.class);
        expectedEx.expectMessage(MessageFormat.format("Number of tickets ({0}) ordered exceeds maximum of 25", numberOfAdultTickets));

        List<TicketTypeRequest> tickets = new ArrayList<>();
        TicketTypeRequest adultTicket = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, numberOfAdultTickets);


        tickets.add(adultTicket);

        TicketTypeRequest[] ticketTypeRequests = tickets.toArray(new TicketTypeRequest[0]);
        ticketService.purchaseTickets(1000L, ticketTypeRequests);

    }

    @Test(expected = InvalidPurchaseException.class)
    public void givenTicketRequestFor1ChildNoAdults_whenTicketPurchased_thenExceptionShouldBeThrown(){

        List<TicketTypeRequest> tickets = new ArrayList<>();
        TicketTypeRequest childTicket = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 1);

        tickets.add(childTicket);

        TicketTypeRequest[] ticketTypeRequests = tickets.toArray(new TicketTypeRequest[0]);
        ticketService.purchaseTickets(1000L, ticketTypeRequests);

    }

    @Test(expected = InvalidPurchaseException.class)
    public void givenTicketRequestFor1InfantNoAdults_whenTicketPurchased_thenExceptionShouldBeThrown(){

        List<TicketTypeRequest> tickets = new ArrayList<>();
        TicketTypeRequest infantTicket = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 1);

        tickets.add(infantTicket);

        TicketTypeRequest[] ticketTypeRequests = tickets.toArray(new TicketTypeRequest[0]);
        ticketService.purchaseTickets(1000L, ticketTypeRequests);

    }

    @Test(expected = InvalidPurchaseException.class)
    public void givenTicketRequestFor1Child1InfantNoAdults_whenTicketPurchased_thenExceptionShouldBeThrown(){

        List<TicketTypeRequest> tickets = new ArrayList<>();
        TicketTypeRequest infantTicket = new TicketTypeRequest(TicketTypeRequest.Type.INFANT, 1);
        TicketTypeRequest childTicket = new TicketTypeRequest(TicketTypeRequest.Type.CHILD, 1);

        tickets.add(infantTicket);
        tickets.add(childTicket);


        TicketTypeRequest[] ticketTypeRequests = tickets.toArray(new TicketTypeRequest[0]);
        ticketService.purchaseTickets(1000L, ticketTypeRequests);

    }

    @Test(expected = InvalidPurchaseException.class)
    public void givenTicketRequestFor1AdultAndInvalidAccountNumber_whenTicketPurchased_thenExceptionShouldBeThrown(){

        List<TicketTypeRequest> tickets = new ArrayList<>();
        TicketTypeRequest adultTicket = new TicketTypeRequest(TicketTypeRequest.Type.ADULT, 1);

        tickets.add(adultTicket);

        TicketTypeRequest[] ticketTypeRequests = tickets.toArray(new TicketTypeRequest[0]);
        ticketService.purchaseTickets(-1l, ticketTypeRequests);

    }

}
