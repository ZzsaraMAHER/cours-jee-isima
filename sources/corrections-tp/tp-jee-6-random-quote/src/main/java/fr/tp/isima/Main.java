package fr.tp.isima;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

import fr.tp.isima.entities.Quote;
import fr.tp.isima.services.HttpQuoteService;
import fr.tp.isima.services.QuoteService;

public class Main {

    public static void main(String[] args) {
        final Options opt = buildOptions();
        // "http://localhost:8080/tp-jee-6-integration-continue-display-quote-v4"
        try {
            final CommandLineParser parser = new BasicParser();

            final CommandLine cmd = parser.parse(opt, args);
            if (cmd.hasOption("url") && cmd.hasOption("user")) {
                final QuoteService qs = new HttpQuoteService(cmd.getOptionValue("url"));
                final Quote quote = qs.findRandomQuote(cmd.getOptionValue("user"));
                System.out.println(quote.getContent());
                System.out.println("De " + quote.getAuthor());
            } else {
                final HelpFormatter hf = new HelpFormatter();
                hf.printHelp("Random Quote", opt);
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }

    private static Options buildOptions() {
        final Options opt = new Options();
        opt.addOption("url", true, "The url of server where to find quotes");
        opt.addOption("user", true, "The user to user to see the quotes");
        return opt;
    }
}
