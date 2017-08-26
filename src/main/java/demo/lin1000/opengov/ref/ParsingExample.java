package demo.lin1000.opengov.ref;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.metadata.Metadata;
import org.xml.sax.SAXException;

public class ParsingExample {

    //public static String document = "documents/CV-TonyLin-July-2017.docx";
    public static String document = "documents/104年度經濟部資料開放行動策略.doc";
    //public static String document = "documents/doc_20170704030445.pdf";
    //public static String document = "documents/film_time_for_taiwan_ppt.pptx";
    //public static String document = "documents/film_time_for_taiwan_ppt_1.mov";
    //public static String document = "documents/time_for_taiwan_dub.wmv";
    
    /**
    * Example of how to use Tika's parseToString method to parse the content of a file,
    * and return any text found.
    * <p>
    * Note: Tika.parseToString() will extract content from the outer container
    * document and any embedded/attached documents.
    *
    * @return The content of a file.
    */
    public String parseToStringExample() throws IOException, SAXException, TikaException {
        Tika tika = new Tika();
        try (InputStream stream = ParsingExample.class.getClassLoader().getResourceAsStream(document)) {
            return tika.parseToString(stream);
        }
    }

    /**
     * Example of how to use Tika to parse a file when you do not know its file type
     * ahead of time.
     * <p>
     * AutoDetectParser attempts to discover the file's type automatically, then call
     * the exact Parser built for that file type.
     * <p>
     * The stream to be parsed by the Parser. In this case, we get a file from the
     * resources folder of this project.
     * <p>
     * Handlers are used to get the exact information you want out of the host of
     * information gathered by Parsers. The body content handler, intuitively, extracts
     * everything that would go between HTML body tags.
     * <p>
     * The Metadata object will be filled by the Parser with Metadata discovered about
     * the file being parsed.
     * <p>
     * Note: This example will extract content from the outer document and all
     * embedded documents.  However, if you choose to use a {@link ParseContext},
     * make sure to set a {@link Parser} or else embedded content will not be
     * parsed.
     *
     * @return The content of a file.
     */
    public String parseExample() throws IOException, SAXException, TikaException {
        AutoDetectParser parser = new AutoDetectParser();
        BodyContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        try (InputStream stream = ParsingExample.class.getClassLoader().getResourceAsStream(document)) {
            parser.parse(stream, handler, metadata);
            List<ArrayList> list = Arrays.asList(metadata.names()).stream().map(s -> new ArrayList(Arrays.asList(s,metadata.get(s)))).collect(Collectors.toList());;
            list.forEach(System.out::println);
            return handler.toString();
        }
    }    
    public static void main(String arg[]) {

        ParsingExample parsingExample = new ParsingExample();

        String r1 = null;
        String r2 = null;
        try{
            r1 = parsingExample.parseToStringExample();
            r2 = parsingExample.parseExample();
            
        }catch(Exception e){
            e.printStackTrace();
        }
        //System.out.println(r1);
        System.out.println(r2);
    }
}