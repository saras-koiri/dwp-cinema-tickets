package uk.gov.dwp.uc.pairtest;

import thirdparty.paymentgateway.TicketPaymentService;
import thirdparty.paymentgateway.TicketPaymentServiceImpl;
import thirdparty.seatbooking.SeatReservationService;
import thirdparty.seatbooking.SeatReservationServiceImpl;
import uk.gov.dwp.uc.pairtest.domain.TicketHelper;
import uk.gov.dwp.uc.pairtest.domain.TicketTypeRequest;
import uk.gov.dwp.uc.pairtest.exception.InvalidPurchaseException;

import java.text.MessageFormat;

public class TicketServiceImpl implements TicketService {
    /**
     * Should only have private methods other than the one below.
     */

    public static final int MAX_NUMBER_OF_TICKETS_THAT_CAN_BE_ORDERED = 25;

    private TicketPaymentService ticketPaymentService = new TicketPaymentServiceImpl();
    private SeatReservationService seatReservationService = new SeatReservationServiceImpl();

    @Override
    public void purchaseTickets(Long accountId, TicketTypeRequest... ticketTypeRequests) throws InvalidPurchaseException {

        if(accountId < 0){
            throw new InvalidPurchaseException("Invalid Account Number");
        }

        int numberOfTickets = TicketHelper.calculateTotalNumberOfTickets(ticketTypeRequests);
        if(numberOfTickets > MAX_NUMBER_OF_TICKETS_THAT_CAN_BE_ORDERED){
            throw new InvalidPurchaseException(MessageFormat.format("Number of tickets ({0}) ordered exceeds maximum of 25}", numberOfTickets));
        }

        if(!TicketHelper.containsAdultTicket(ticketTypeRequests)){
            throw new InvalidPurchaseException("There must be at least 1 Adult ticket");
        }

        ticketPaymentService.makePayment(accountId, TicketHelper.calculateTicketPrice(ticketTypeRequests));
        seatReservationService.reserveSeat(accountId, TicketHelper.calculateNumberOfSeatsToReserve(ticketTypeRequests));
    }




}
