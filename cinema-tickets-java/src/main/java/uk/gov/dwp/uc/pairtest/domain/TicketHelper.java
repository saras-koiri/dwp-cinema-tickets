package uk.gov.dwp.uc.pairtest.domain;

import java.util.List;

public class TicketHelper {

    public static int calculateTicketPrice(TicketTypeRequest[] ticketTypeRequests){

        if(ticketTypeRequests == null || ticketTypeRequests.length == 0) return 0;

        int price = 0;

        for(TicketTypeRequest ticketTypeRequest: ticketTypeRequests){

            int numberOfTickets = ticketTypeRequest.getNoOfTickets();
            int ticketPrice = ticketTypeRequest.getTicketType().getPrice();
            int subTotal = numberOfTickets * ticketPrice;

            price += subTotal;
        }

        return price;
    }

    public static int calculateTotalNumberOfTickets(TicketTypeRequest[] ticketTypeRequests){

        if(ticketTypeRequests == null || ticketTypeRequests.length == 0) return 0;

        int totalNumberOfTickets = 0;

        for(TicketTypeRequest ticketTypeRequest: ticketTypeRequests){

            totalNumberOfTickets +=  ticketTypeRequest.getNoOfTickets();
        }

        return totalNumberOfTickets;

    }

    public static boolean containsAdultTicket(TicketTypeRequest[] ticketTypeRequests){

        if(ticketTypeRequests == null || ticketTypeRequests.length == 0) return false;

        boolean hasNoAdultTicket = false;

        for(TicketTypeRequest ticketTypeRequest: ticketTypeRequests){

            if(ticketTypeRequest.getTicketType() == TicketTypeRequest.Type.ADULT){
                return true;
            }
        }

        return hasNoAdultTicket;

    }

    public static int calculateNumberOfSeatsToReserve(TicketTypeRequest[] ticketTypeRequests) {

        if(ticketTypeRequests == null || ticketTypeRequests.length == 0) return 0;

        int numberOfSeatsToReserve = 0;

        for(TicketTypeRequest ticketTypeRequest: ticketTypeRequests){


            if(ticketTypeRequest.getTicketType() == TicketTypeRequest.Type.ADULT || ticketTypeRequest.getTicketType() == TicketTypeRequest.Type.CHILD) {
                int numberOfTickets = ticketTypeRequest.getNoOfTickets();
                numberOfSeatsToReserve += numberOfTickets;
            }
        }

        return numberOfSeatsToReserve;
    }
}
