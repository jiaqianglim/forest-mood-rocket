package cafefashionsociety.structureliteraturemeadow.serviceutilities;

import java.util.HashMap;

import org.springframework.context.annotation.Profile;

@Profile("dev")
public class Get1MQuoteDev implements IGet1MQuote {

    @Override
    public String[] getquote() {
        String[] quote = { "God is dead and we killed him", "Nietzche" };
        return quote;
    }

}
