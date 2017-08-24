package org.billFarber.charts.dataGenerator;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

public class FreemarkerClient {

    private static final Logger logger = LoggerFactory.getLogger(FreemarkerClient.class);

    private Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
    private Template template = null;

    public FreemarkerClient() throws IOException {
        String resourcesPath = getContextClassLoader().getResource("resources")
                .getPath() + "";
        logger.info("resourcesPath:" + resourcesPath);
        File resourcesFile = new File(resourcesPath);
        cfg.setDirectoryForTemplateLoading(resourcesFile);
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);

    }

    public void loadTemplate(String templateFilename) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
        template = cfg.getTemplate(templateFilename);
    }

    private static ClassLoader getContextClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public String process(Map<String, Object> root) throws TemplateException, IOException {
        if (template == null) throw new TemplateException("You must load a template first.", null);
        StringWriter out = new StringWriter();
        template.process(root, out);
        return out.toString();
    }
}
