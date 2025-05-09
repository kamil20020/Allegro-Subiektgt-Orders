package pl.kamil_dywan.factory;

import org.junit.jupiter.api.Test;
import pl.kamil_dywan.external.subiektgt.generated.BatchTrailer;
import pl.kamil_dywan.external.subiektgt.generated.Currency;
import pl.kamil_dywan.external.subiektgt.own.Code;

import static org.junit.jupiter.api.Assertions.*;

class BatchTrailerFactoryTest {

    @Test
    void shouldCreate() {

        //given
        Code currencyCode = Code.PLN;

        //when
        BatchTrailer batchTrailer = BatchTrailerFactory.create(currencyCode);

        //then
        assertNotNull(batchTrailer);
        assertNull(batchTrailer.getChecksum());
        assertNotNull(batchTrailer.getItemCurrency());
        assertNotNull(batchTrailer.getItemCurrency().getCurrency());

        Currency gotCurrency = batchTrailer.getItemCurrency().getCurrency();

        assertEquals(currencyCode, gotCurrency.getCode());
    }
}