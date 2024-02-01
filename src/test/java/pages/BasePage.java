package pages;

import lombok.extern.log4j.Log4j2;
import utils.PropertyReader;


@Log4j2
public class BasePage {

    final String BASE_URL = PropertyReader.getProperty("tr.base.url");
}
