package org.billFarber.charts.dataGenerator;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

public class FreemarkerClient {

    private Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
    private Template template = null;

    public FreemarkerClient() throws IOException {
        cfg.setClassForTemplateLoading(this.getClass(), "/");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
    }

    public void loadTemplate(String templateFilename) throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
        template = cfg.getTemplate(templateFilename);
    }

    public String process(Map<String, Object> root) throws TemplateException, IOException {
        if (template == null) throw new TemplateException("You must load a template first.", null);
        StringWriter out = new StringWriter();
        template.process(root, out);
        return out.toString();
    }
}
