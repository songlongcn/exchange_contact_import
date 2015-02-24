package ews.demo

import microsoft.exchange.webservices.data.BasePropertySet
import microsoft.exchange.webservices.data.Contact
import microsoft.exchange.webservices.data.ContactSchema
import microsoft.exchange.webservices.data.ContactsFolder
import microsoft.exchange.webservices.data.ExchangeCredentials
import microsoft.exchange.webservices.data.ExchangeService
import microsoft.exchange.webservices.data.ExchangeVersion
import microsoft.exchange.webservices.data.FindItemsResults
import microsoft.exchange.webservices.data.IAutodiscoverRedirectionUrl
import microsoft.exchange.webservices.data.Item
import microsoft.exchange.webservices.data.ItemView
import microsoft.exchange.webservices.data.PropertySet
import microsoft.exchange.webservices.data.WebCredentials
import microsoft.exchange.webservices.data.WellKnownFolderName


class RaceController {
    // default target for incoming Race request from the web
    def index() {
        ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP2)

        try{
            service.traceEnabled = true;
            service.credentials = new WebCredentials("michael.song@j2.com", "Cra1gm0nt3");
            //service.autodiscoverUrl("michael.song@j2global.com", new RedirectionUrlCallback());
            service.setUrl(new URI("https://casarraysz.j2.com/ews/exchange.asmx"))
        }catch(Exception ex){
            ex.printStackTrace()
        }



        if (service){
            ContactsFolder contactsFolder = ContactsFolder.bind(service, WellKnownFolderName.Contacts)
            int numItems = contactsFolder.totalCount
            ItemView view = new ItemView(numItems)
            view.propertySet = new PropertySet(BasePropertySet.IdOnly, ContactSchema.Surname, ContactSchema.GivenName)
            FindItemsResults<Item> contactItems = service.findItems(WellKnownFolderName.Contacts,view)
            String firstname,lastname
            for(Item item in contactItems){
                if (item as Contact){
                    Contact contact = item as Contact
                    firstname = contact.getGivenName()
                    lastname = contact.getSurname()
                }
            }
        }

        render "Race"
    }

    static class RedirectionUrlCallback implements IAutodiscoverRedirectionUrl{
        public boolean autodiscoverRedirectionUrlValidationCallback(String redirectionUrl){
            println "=========="+redirectionUrl;
            return redirectionUrl.toLowerCase().startsWith("https://")
        }

    }
}
