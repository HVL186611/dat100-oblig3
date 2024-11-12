package no.hvl.dat100.oppgave6;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.Innlegg;
import no.hvl.dat100.oppgave3.Blogg;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}
	
	private static String HTMLPREFIX = 
            "<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n" + 
            HtmlBlogg.STYLE + "\n\t</head>\n\t<body>\n";
    
    private static String HTMLPOSTFIX = 
            "\t</body>\n</html>";
    
    // Inline CSS for consistent style
    public static final String STYLE = """
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 20px;
                background-color: #f4f4f9;
                color: #333;
            }
            .image {
                max-width: 100%;
                height: auto;
                border-radius: 8px;
            }
            .content {
                line-height: 1.6;
                color: #444;
            }
            .highlight {
                color: #007bff;
                font-weight: bold;
            }
            .container {
                max-width: 800px;
                margin: auto;
                padding: 20px;
                border: 1px solid #ddd;
                border-radius: 8px;
                background-color: #ffffff;
            }
        </style>
        """;
    
    @Override
    public String toString() {
        StringBuilder htmlDocument = new StringBuilder(HTMLPREFIX);
        
        // Loop through each Innlegg and append its HTML representation
        for (int i = 0; i < getAntall(); i++) {
            Innlegg innlegg = getSamling()[i];
            htmlDocument.append("\n").append(innlegg.toHTML()).append("\n");
        }
        
        // Append postfix to close the HTML document
        htmlDocument.append(HTMLPOSTFIX);
        
        return htmlDocument.toString();
    }
}