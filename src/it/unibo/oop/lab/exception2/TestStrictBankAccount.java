package it.unibo.oop.lab.exception2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public final class TestStrictBankAccount {

    private static final int INITIAL_AMOUNT = 10_000;
    private static final int TOO_MUCH = 50_000;

    /**
     * Used to test Exceptions on
     * {@link it.unibo.oop.lab.exception2.StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         */
    	final int nMaxATMTransactions = 10;

        final AccountHolder ah1 = new AccountHolder("Pinco", "Panco", 1);
        final AccountHolder ah2 = new AccountHolder("Panco", "Pinco", 2);
        final StrictBankAccount account1 = new StrictBankAccount(ah1.getUserID(), INITIAL_AMOUNT, nMaxATMTransactions);
        final StrictBankAccount account2 = new StrictBankAccount(ah2.getUserID(), INITIAL_AMOUNT, nMaxATMTransactions);
        /*
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in presenza
         * di un id utente errato, oppure al superamento del numero di operazioni ATM
         * gratuite.
         */
        
        /* Test for the method deposit */
        try {
            account1.deposit(13, 100);
            fail("The account info does not line up correctly, please try again!");
        } catch (WrongAccountHolderException e) {
            assertNotNull(e);
        }

        /* Test for the method withdraw */
        try {
            account2.withdraw(ah2.getUserID(), TOO_MUCH);
        } catch (WrongAccountHolderException e) {
            fail("The account info does not line up correctly, please try again!");
        } catch (NotEnoughFoundsException e) {
            assertNotNull(e);
        }

        /* Tests for the method depositFromATM */
        for (int i = 0; i < nMaxATMTransactions; i++) {
            try {
                account2.depositFromATM(ah2.getUserID(), 1);
            } catch (WrongAccountHolderException e){
            	fail("The account info does not line up correctly, please try again!");
            } catch (TransactionsOverQuotaException e) {
                fail("There should be no more transactions avaiable for this account holder!");
            }
        }
        try {
            account2.depositFromATM(ah2.getUserID(), 1);
            fail("There should be no more transactions after the last test!");
        } catch (WrongAccountHolderException e){
        	fail("The account info does not line up correctly, please try again!");
        } catch (TransactionsOverQuotaException e) {
            assertNotNull(e);
        }
    }
}
