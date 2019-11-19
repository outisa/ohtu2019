package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.*;
import static org.mockito.Mockito.*;

public class KauppaTest {
    Pankki pankki;
    Viitegeneraattori viite; 
    Varasto varasto;
    Kauppa kauppa;
    
    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);
        kauppa = new Kauppa(varasto, pankki, viite);
        
        when(viite.uusi()).thenReturn(42);
        
        when(varasto.saldo(1)).thenReturn(20);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));
        when(varasto.saldo(2)).thenReturn(20);
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "sima", 6));
        when(varasto.saldo(3)).thenReturn(0);
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "mehu", 4));    
    }
    @Test
    public void ostoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaan() {
        kauppa.aloitaAsiointi();;
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(), anyInt());
    }
    
    @Test
    public void ostoksenPaatyttyaTilisiirtoVeloittaTililtaOikeanSumman() {        
        kauppa.aloitaAsiointi();;
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), anyString(), eq(5));        
    }
    
    @Test
    public void kahdenEriOstoksenPaatyttyaTilisiirtoVeloittaaTililtaOikeanSumman() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("olli", "987654");
        
        verify(pankki).tilisiirto(eq("olli"), eq(42), eq("987654"), anyString(), eq(11));           
    }
    
    @Test
    public void kahdenSamanOstoksenPaatyttyaTilisiirtoVeloittaaTililtaOikeanSumman() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(1);
        kauppa.tilimaksu("olli", "987654");

        verify(pankki).tilisiirto(eq("olli"), eq(42), eq("987654"), anyString(), eq(10));        
    }  
    
    @Test
    public void toinenTuoteLoppunutTilisiirtoVeloittaaOikeanTililtaSumman() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.lisaaKoriin(3);
        kauppa.tilimaksu("olli", "987654");
       
        verify(pankki).tilisiirto(eq("olli"), eq(42), eq("987654"), anyString(), eq(6));       
    }
    
    @Test
    public void aloitaAsiointiNollaaEdellistenOstostenTiedot() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.aloitaAsiointi();
        kauppa.tilimaksu("name", "2323");
        
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(), eq(0));
    }
    
    @Test
    public void  jokaiselleMaksutapahtumalleLuodaanUusiViite() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);

        kauppa.tilimaksu("teppo", "12323");        
        
        verify(viite, times(1)).uusi();   
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.lisaaKoriin(2);
        
        kauppa.tilimaksu("pekka", "22323");
        
        verify(viite, times(2)).uusi();
        
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(2);
        kauppa.lisaaKoriin(2);
        kauppa.tilimaksu("sanna", "23423");
       
        verify(viite, times(3)).uusi();       
   }
    
    @Test
    public void ostoskoristaPoistettuTuotettaEiVeloiteta() {
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(2);
        kauppa.poistaKorista(2);
        kauppa.tilimaksu("sanna", "23423");
        
        verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(), eq(5));
    }
}
