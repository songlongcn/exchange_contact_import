import microsoft.exchange.webservices.data.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;


/**
 * Created with IntelliJ IDEA.
 * User: michael.song
 * Date: 2/26/14
 * Time: 10:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class EWS_portal {
    public static void main(String args[]){
//        try{
//            new JavaApplication_JavaMail().send_email();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
        ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
//        service.setTraceEnabled(true);
        ExchangeCredentials credentials = new WebCredentials("michael.song@j2global.com","Cra1gm0nt");
        service.setCredentials(credentials);
        System.out.print(service);

        try {
//            service.setUrl(new URI("https://j2.com/AutoDiscover/AutoDiscover.xml"));
//            service.autodiscoverUrl("michael.song@j2.com");
            AutoRule valid = new AutoRule();
            service.autodiscoverUrl("michael.song@j2global.com", valid);

            //send email
            EmailMessage message = new EmailMessage(service);
            message.getToRecipients().add("slcntest1@yahoo.com");
            message.setSubject("EWS testing");
            message.setBody(MessageBody.getMessageBodyFromText("Email test."));
            message.send();

            //contact
            ContactsFolder contactsfolder = ContactsFolder.bind(service, WellKnownFolderName.Contacts);
// Set the number of items to the number of items in the Contacts folder or 50, whichever is smaller.
            int numItems = contactsfolder.getTotalCount() < 50 ? contactsfolder.getTotalCount() : 50;
// Instantiate the item view with the number of items to retrieve from the Contacts folder.
            ItemView view = new ItemView(numItems);
// To keep the request smaller, request only the display name property.
            view.setPropertySet(new PropertySet(BasePropertySet.IdOnly, ContactSchema.DisplayName));
// Retrieve the items in the Contacts folder that have the properties that you selected.
            FindItemsResults<Item>  contactItems = service.findItems(WellKnownFolderName.Contacts, view);
// Display the list of contacts.
            for (Item item: contactItems){
                item.load();
                Contact contact = (Contact)item;
                System.out.print(contact.getDisplayName()+"; ");
                System.out.print(contact.getCompanyName()+"; ");
                System.out.print(contact.getPhoneNumbers()+"; ");
                System.out.println(contact.getEmailAddresses()+"; ");
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception ex){
            ex.printStackTrace();
        }



    }
}


