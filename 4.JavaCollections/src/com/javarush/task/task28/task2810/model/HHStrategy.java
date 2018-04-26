package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT =
            "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> list = new ArrayList<>();
        if (searchString == null) return Collections.emptyList();

        int page = 0;
        while (true) {
            try {
                Document doc = getDocument(searchString, page++);
                Elements elements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (elements.size() > 1) {
                    for (int i = 0; i < elements.size(); i++) {
                        Vacancy vacancy = new Vacancy();
                        String title = elements.get(i).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text();
                        vacancy.setTitle(title);

                        String salary = elements.get(i).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text();
                        if (salary != null)
                            vacancy.setSalary(salary);
                        else vacancy.setSalary("");

                        String city = elements.get(i).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text();
                        vacancy.setCity(city);

                        String companyName = elements.get(i).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text();
                        vacancy.setCompanyName(companyName);

                        String url = elements.get(i).getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href");
                        vacancy.setUrl(url);

                        String siteName = "http://hh.ua";
                        vacancy.setSiteName(siteName);

                        list.add(vacancy);
                    }
                } else break;
            } catch (IOException ex) {

            }
        }
        return list;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        Document doc = null;
        try {
            doc = Jsoup.connect(String.format(URL_FORMAT, searchString, page)).
                    userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:59.0) Gecko/20100101 Firefox/59.0").referrer("?").get();
        } catch (IOException ignore) {
        }
        return doc;
    }

}
