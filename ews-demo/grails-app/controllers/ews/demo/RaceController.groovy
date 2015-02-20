package ews.demo

import microsoft.exchange.webservices.data.Contact
import microsoft.exchange.webservices.data.ExchangeCredentials
import microsoft.exchange.webservices.data.ExchangeService
import microsoft.exchange.webservices.data.ExchangeVersion
import microsoft.exchange.webservices.data.IAutodiscoverRedirectionUrl
import microsoft.exchange.webservices.data.WebCredentials

class RaceController {
    // default target for incoming Race request from the web
    def index() {
        ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP2)
        ExchangeCredentials credentials = new WebCredentials("michael.song@j2global.com", "Cra1gm0nt3")
        service.setCredentials(credentials)
        service.autodiscoverUrl("michael.song@j2global.com", new RedirectionUrlCallback())
        Contact contact = new Contact(service)
        println contact
        render "Race"
    }

    static class RedirectionUrlCallback implements IAutodiscoverRedirectionUrl{
        public boolean autodiscoverRedirectionUrlValidationCallback(String redirectionUrl){
            return redirectionUrl.toLowerCase().startsWith("https://")
        }

    }
}
