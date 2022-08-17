package cafefashionsociety.structureliteraturemeadow.serviceutilities;

import java.util.HashMap;

import org.springframework.context.annotation.Profile;

@Profile("prod")
public class Get1MQuoteProd implements IGet1MQuote {

    @Override
    public String[] getquote() {
        String[] quote = new String[2];
        String[] backupQuote = { "God is dead and we killed him", "Nietzche" };
        // TODO
        return (quote[0] != null) ? quote : backupQuote;
    }

}
