import yahoofinance.*;
import java.util.Calendar;
import java.util.List;
import yahoofinance.histquotes.*;
import yahoofinance.histquotes.HistoricalQuote.*;
import java.math.BigDecimal;

/**
 * Retrieve historical stock prices
 */
public class StockPriceHistory
{

    private final String TICKER = "GOOG";
    
    /**
     * Retrieve the stock price data
     */
    public void run() {
        try {
            Stock stock = YahooFinance.get(TICKER,Interval.DAILY);
            List<HistoricalQuote> list = stock.getHistory();
            System.out.println("Date" + "," + "Closing price");
            for(HistoricalQuote historicalQuote : list) {
                System.out.print(formatDate(historicalQuote.getDate()));
                System.out.print(",");
                System.out.println(historicalQuote.getClose());
            }
            //System.out.println(list.getDate() + "," + list.getAdjClose());
            //System.out.println(date + "," + closingPrice);
        } catch (Exception e) {
            System.out.println("Error in stock call");    
        }
    }
    
    /**
     * Format a Calendar object to YYYY-MM-DD format
     */
    private String formatDate(Calendar date) {
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH)+1;
        int day = date.get(Calendar.DATE);
        String monthStr = (month < 10) ? "0"+month : month+"";
        String dayStr = (day < 10) ? "0"+day : day+"";
        
        String dateStr = year+"-"+monthStr+"-"+dayStr;
        return dateStr;
    }
    

    /**
     * Main method to run the program
     */
    public static void main (String[] args) {
        StockPriceHistory sph = new StockPriceHistory();
        sph.run();
    }

}

