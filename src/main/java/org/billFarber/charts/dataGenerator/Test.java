package org.billFarber.charts.dataGenerator;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class Test {

    public static void main(String[] args) throws IOException, TemplateException {
        System.out.println("Begin Test");
        DatabaseClient client = DatabaseClientFactory.newClient("localhost",
                8000, "MyDatabase", new DatabaseClientFactory.DigestAuthContext(
                        "myuser", "mypassword"));
        
     // Create your Configuration instance, and specify if up to what FreeMarker
     // version (here 2.3.25) do you want to apply the fixes that are not 100%
     // backward-compatible. See the Configuration JavaDoc for details.
     Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);

     // Specify the source where the template files come from. Here I set a
     // plain directory for it, but non-file-system sources are possible too:
//     cfg.setDirectoryForTemplateLoading(new File("."));
     String resourcesPath = getContextClassLoader().getResource("resources").getPath()+"";
     System.out.println("resourcesPath:"+resourcesPath);
     File resourcesFile = new File(resourcesPath);
     cfg.setDirectoryForTemplateLoading(resourcesFile);

     // Set the preferred charset template files are stored in. UTF-8 is
     // a good choice in most applications:
     cfg.setDefaultEncoding("UTF-8");

     // Sets how errors will appear.
     // During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
     cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

     // Don't log exceptions inside FreeMarker that it will thrown at you anyway:
     cfg.setLogTemplateExceptions(false);
     
     
     
  // Create the root hash. We use a Map here, but it could be a JavaBean too.
     Map<String, Object> root = new HashMap<>();
     // Put string "user" into the root
     root.put("state", "VA");
     root.put("amount", "987654");
     
     
     Template temp = cfg.getTemplate("uredTemplate.ftlh");
     
     
     Writer out = new OutputStreamWriter(System.out);
     temp.process(root, out);
     
     
        System.out.println("End Test");
    }
    
    
        public static InputStream getResourceAsStream( String resource ) {
          final InputStream in = getContextClassLoader().getResourceAsStream( resource );
          return in == null ? getResourceAsStream( resource ) : in;
        }

        private static ClassLoader getContextClassLoader() {
          return Thread.currentThread().getContextClassLoader();
        }

    
}
