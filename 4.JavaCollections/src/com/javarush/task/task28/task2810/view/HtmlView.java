package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View {
    Controller controller;
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replaceAll("\\.", "/") + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        System.out.println(vacancies.size());
        try {
            String vacancy = getUpdatedFileContent(vacancies);
            updateFile(vacancy);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        String result = null;
        try {
            Document document = getDocument();
            Element element = document.getElementsByClass("template").first();
            Element copy = element.clone();
            copy.removeClass("template").removeAttr("style");

            document.getElementsByAttributeValue("class", "vacancy").remove();

            for (Vacancy v : vacancies) {
                Element t = copy.clone();
                t.getElementsByAttributeValue("class", "city").get(0).text(v.getCity());
                t.getElementsByAttributeValue("class", "companyName").get(0).text(v.getCompanyName());
                t.getElementsByAttributeValue("class", "salary").get(0).text(v.getSalary());

                Element link = t.getElementsByTag("a").get(0).text(v.getTitle());
                link.attr("href", v.getUrl());
                element.before(t.outerHtml());
            }

            result = document.html();

        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
        return result;
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }

    private void updateFile(String string) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(string.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }
}
