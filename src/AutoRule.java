import microsoft.exchange.webservices.data.AutodiscoverLocalException;
import microsoft.exchange.webservices.data.IAutodiscoverRedirectionUrl;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 * User: michael.song
 * Date: 2/26/14
 * Time: 6:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class AutoRule implements IAutodiscoverRedirectionUrl {

    @Override
    public boolean autodiscoverRedirectionUrlValidationCallback(String string) throws AutodiscoverLocalException {
        boolean result = false;

        try{
            URI redirectionUri = new URI(string);
            if (redirectionUri.getScheme().contains("https"))
            {
                result = true;

            }
        }catch(URISyntaxException e){e.printStackTrace(); }
        System.out.println(result);
        System.out.println(string);
// Validate the contents of the redirection URL. In this simple validation
// callback, the redirection URL is considered valid if it is using HTTPS
// to encrypt the authentication credentials.
        return result;
    }
}
